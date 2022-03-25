public class Principal {
    
    
    
    public static void main (String [] args){
		
		//initialisation 
		FenetreNiveau f = new FenetreNiveau();
		while(f.niveau == 0){
            System.out.print("");
		}
		partie p = new partie(f.niveau);
		FenetrePrincipale fenetre = new FenetrePrincipale(f.niveau,p);
		boolean continu = false;
		
		//début de la partie
		
		boolean fin = p.verifPartie();
		int a = 0;
		int k = 0;
		int l = 0;
		
		int b = 0;
		int n = 0;
		int m = 0;
		
		while (!fin){
			//Debloquer les clics
			
			boolean modification = fenetre.modification(a, k, l);
			//Recupérer les 6 valeurs pour les 2 cases
			
			//Recupère les 3 premières valeurs comment ne pas les recupérer à 000
			while(!modification){
				System.out.print("");
				modification = fenetre.modification(b,n,m);
			}
			
			a = fenetre.a;
			k = fenetre.k;
			l = fenetre.l;
			
			System.out.println("a" + a);
			System.out.println("k" +k);
			System.out.println("l" +l);
				
			//Methode si une des 3 valeurs est modifie dans ce cas on recupère les 3 autres valeurs
			modification = fenetre.modification(a,k,l);
			while(!modification){
				System.out.print("");
				modification = fenetre.modification(a,k,l);
			}
			b = fenetre.a;
			m = fenetre.k;
			n = fenetre.l;
			
			System.out.println("b"+b);
			System.out.println("m"+m);
			System.out.println("n"+n);
			
			//Bloquer clic
			
			boolean retourne = p.verifList(a,b);
		
			//Attendre 1min
			
			try {
				Thread.sleep(5000);
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
			
			
		}
		if(fin){
			FenetreFin ffin = new FenetreFin();
		}	
    }
    
    
} 
