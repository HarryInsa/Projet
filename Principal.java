public class Principal {
	
	public static FenetrePrincipale fenetre;
	public static partie p; 
	
    public static void main (String [] args){
		
		FenetreAccueil fenetreaccueil = new FenetreAccueil();
		
		while(!fenetreaccueil.click){
			System.out.print("");
		}
		
		FenetreNiveau fenetreniveau = fenetreaccueil.fenetreniveau;
		
		while(fenetreniveau.estOuverte()){
			while(fenetreniveau.click1 == false || fenetreniveau.click2 == false){
				System.out.print("");
			}
			
			//Attendre 2secs
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {}
			
			fenetreniveau.click1 = false;
			fenetreniveau.click2 = false;
			fenetre = new FenetrePrincipale(fenetreniveau.niveau, fenetreniveau.operation);
			p = fenetre.p;
			lancerJeu();
		}
		
    }
    
    
    public static void lancerJeu (){
		
		boolean continu = false;
		
		//début de la partie
		boolean fin = p.verifPartie();	//Verification si la partie est finie
		
		// Valeurs de la 1ère case choisi
		int a = 0;	//Valeur de la case
		int k = 0;	//Indice i de sa position
		int l = 0;	//Indice j de sa position
		
		//Valeurs de la 2ème case choisi
		int b = 0;	//Valeur de la case
		int n = 0;	//Indice i de sa position
		int m = 0;	//Indice j de sa position
		
		//Compteur du nombre de coups
		int coups = 0;
		
		while (!fin){
			
			//Lancement du timer
			fenetre.mt.start();
			
			//Debloquer les clics
			fenetre.debloquerClic();
			
			//Recupère les 3 premières valeurs
			while(!fenetre.click){
				System.out.print("");
			}
			
			a = fenetre.a;
			k = fenetre.k;
			l = fenetre.l;
			
			fenetre.click = false;
			
			//Methode si il y a eu un click sur l'un des boutons on recupère les 3 nouvelles valeurs
			while(!fenetre.click){
				System.out.print("");
			}
			
			b = fenetre.a;
			m = fenetre.k;
			n = fenetre.l;
			
			fenetre.click = false;
			
			//Bloquer clic
			fenetre.bloquerClic();
			
			boolean retourne = p.verifList(a,b);
			
			//Attendre 2secs
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {}
		
			if(retourne){	//si retourne true il faut supprimer/cacher les 2 boutons
				fenetre.lesBoutons[k][l].setVisible(false);
				fenetre.lesBoutons[m][n].setVisible(false);
			}else{		//Si retourne false il faut recacher les nombres
				fenetre.lesBoutons[k][l].setText("");
				fenetre.lesBoutons[m][n].setText("");
			}
		
			//Vérification si la partie est finie
			fin = p.verifPartie();
			coups++;			
		}

		if(fin){
			fenetre.dispose();
			FenetreFin ffin = new FenetreFin(coups, fenetre.cpt);
		}
	}	

} 
