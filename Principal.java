public class Principal {
    
    public static void main (String [] args){
		
		//initialisation 
		FenetreNiveau f = new FenetreNiveau();
		
		while(f.niveau == 0){
			System.out.println("Bonjour");
		}
		
		FenetrePrincipale fenetre = new FenetrePrincipale(f.niveau);
		
		//début de la partie
		
    }
}
