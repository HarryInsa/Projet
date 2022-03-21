public class Principal {
    
    public static void main (String [] args){
		
		//initialisation 
		FenetreNiveau f = new FenetreNiveau();
		while(f.niveau == 0){
            System.out.println();
		}
		partie p = new partie(f.niveau);
		FenetrePrincipale fenetre = new FenetrePrincipale(f.niveau,p);
		
		//début de la partie
		
    }
} 
