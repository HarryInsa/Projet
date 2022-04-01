//Bibliothèque
import java.util.*;

public class plateau{
	
	//Attribut
	public int [][] jeu;
	
	public plateau (LinkedList<Pair> list){
		
		//pas de problem car les listes sont composées d'un nombre de paire de telle sorte à obtenir une matrice carrée
		int n = (int)(Math.sqrt((list.size())*2));	
		jeu = new int [n][n];
		
		
		for(Pair p : list){
			//indice des positions des nombres de la pair
			int i = (int)(Math.random()*n);	
			int j = (int)(Math.random()*n);
			int k = (int)(Math.random()*n);
			int l = (int)(Math.random()*n);
			
			//Vérification si la case est vide pour le 1er nombre
			while(!estVide(i,j)){
				i = (int)(Math.random()*n);	
				j = (int)(Math.random()*n);
			}
			jeu[i][j] = p.a;
			
			//Idem pour le 2ème nombre de la pair
			while(!estVide(k,l)){
				k = (int)(Math.random()*n);
				l = (int)(Math.random()*n);
			}	
			jeu[k][l] = p.b;
			
		}	
	}
	
	//Vérifie si la case du tableau est vide
	public boolean estVide (int i, int j){
		boolean vide = false;
		if(jeu[i][j] == 0){
			vide = true;
		}
		return vide;
	}
	
}

