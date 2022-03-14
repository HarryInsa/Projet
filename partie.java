import java.util.* ;

public class partie {
	
	int nombre;
	int nombrePair;
	LinkedList <Pair> list;
	plateau jeu;
	
	public partie (int niveau){
		
		creationNiveau(niveau);
		
		//Création du nombre clé entre 50 et 100
		nombre = (int)(Math.random()*50+50);
		
		//Création de la list contenant toutes les pairs pour le jeu
		list = new LinkedList <Pair> ();
		while (list.size()<nombrePair){
			list.add(creationPair());
		}
		
		//Création du plateau de jeu
		jeu = new plateau (list);
		
	}
	
	//Donne le nombre de pair à créer selon le niveau choisit
	public void creationNiveau (int niveau){
		if (niveau == 1){
			nombrePair = 8;
		}else if (niveau == 2){
			nombrePair = 18;
		}else{
			nombrePair = 32;
		}
	}
	
	//Crétion d'une pair aléatoire telle que a + b = nombre
	public Pair creationPair (){
		int a = (int)(Math.random()*50+50);
		while(a>nombre){
			a = (int)(Math.random()*50+50);
		}
		int b = (int)(nombre - a);
		Pair pair = new Pair (a, b);
		return pair;
	}
}
