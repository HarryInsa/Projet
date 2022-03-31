//Bibliothèque
import java.util.* ;

public class partie{
	
	//Attributs
	public int nombre;
	public int nombrePair;
	public LinkedList<Pair> list;
	public plateau tab;
	public int taillebouton;
	public int niveau;
	public int operation;
    
	public partie (int niveau, int operation){
        
        this.niveau = niveau;
        this.operation = operation;
        
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
			nombre = (int)(Math.random()*20+10);
		}else if (niveau == 2){
			nombrePair = 18;
			taillebouton = 70;
			nombre = (int)(Math.random()*30+20);
		}else{
			nombrePair = 32;
			taillebouton = 50;
			nombre = (int)(Math.random()*40+30);
		}
	}
	
	//Crétion d'une pair aléatoire telle que a + b = nombre
	public Pair creationPair (){
		if(operation == 1){
			int a = (int)(Math.random()*nombre);
			int b = nombre - a;
			Pair pair = new Pair (a, b);
			return pair;
		}else{
			int a = (int)(Math.random()*nombre+nombre);
			int b = a - nombre;
			Pair pair = new Pair (a, b);
			return pair;
		}
	}
	
	//Vérification si une pair appartient ou non à la list
	public boolean verifList (int a, int b){
		boolean verif = false;
		
		//Si pair appartient on l'enlève de list
		Pair v1 = new Pair(a,b);
		if(list.contains(v1)){
			list.remove(v1);
			return true;	
		}
		
		//Idem si la pair "dans l'autre sens" appartient
		Pair v2	= new Pair (b,a);
		if(list.contains(v2)){
			list.remove(v2);
			return true;
		}
		
		return false;
	}
	
	//Vérifie si la partie est finie ou non (si la list est vide)
	public boolean verifPartie (){
		if(list.size()==0){
			return true;
		}
		return false;
	}	
	
}
