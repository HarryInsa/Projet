//Bibliothèque
import java.util.* ;

public class partie{
	
	//Attributs
	public int nombre;
	public int nombrePair;
	public LinkedList<Pair> list;
	public plateau tab;
	public int taillebouton;
	
	public partie (int niveau){

		creationNiveau(niveau);
		
		//Création de la list contenant toutes les pairs pour le jeu
		list = new LinkedList<Pair> ();
		while (list.size()<nombrePair){
			list.add(creationPair());
		}
		
		//Création du plateau de jeu
		tab = new plateau (list);
		
	}
	
	//Donne le nombre de pair à créer selon le niveau choisit
	public void creationNiveau (int niveau){
		if (niveau == 1){
			nombrePair = 8;
			taillebouton = 90;
			nombre = (int)(Math.random()*10+20);
		}else if (niveau == 2){
			nombrePair = 18;
			taillebouton = 70;
			nombre = (int)(Math.random()*10+40);
		}else{
			nombrePair = 32;
			taillebouton = 50;
			nombre = (int)(Math.random()*10+60);
		}
	}
	
	//Crétion d'une pair aléatoire telle que a + b = nombre
	public Pair creationPair (){
		int a = (int)(Math.random()*nombre);
		int b = (int)(nombre - a);
		Pair pair = new Pair (a, b);
		return pair;
	}
	
	//Vérification si une pair appartient ou non à la list
	public boolean verifList (int a, int b){
		boolean verif = false;
		
		//Si pair appartient on l'enlève de list
		Pair v1 = new Pair(a,b);
		if(list.contains(v1)){
			verif = true;
			list.remove(v1);	
		}
		
		//Idem si la pair "dans l'autre sens" appartient
		Pair v2	= new Pair (b,a);
		if(list.contains(v2)){
			verif = true;
			list.remove(v2);
		}
		
		return verif;
	}
	
	//Vérifie si la partie est finie ou non (si la list est vide)
	public boolean verifPartie (){
		if(list.size()==0){
			return true;
		}
		return false;
	}	
	
}
