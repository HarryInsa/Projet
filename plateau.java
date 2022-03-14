import java.util.*;

public class plateau{
	
	
	public int[][] jeu;
	
	public plateau (LinkedList<Pair>list){
		
		//pas de problem car les listes sont composées d'un nombre de paire de telle sorte à obtenir une matrice carrée
		int n = (int)(Math.sqrt((list.size())*2));	
		jeu = new int [n][n];
		
		
		for(Pair p : list){
			//indice des positions des nombres de la pair
			int i = (int)(Math.random()*n);	
			int j = (int)(Math.random()*n);
			int k = (int)(Math.random()*n);
			int l = (int)(Math.random()*n);
			if(estVide(i,j)){
				jeu[i][j] = p.a;
			}else{
				
			}	
			if(estVide(k,l)){
				jeu[k][l] = p.b;
			}else{
				
			}	
		}	
	}
	
	public boolean estVide (int i, int j){
		boolean vide = false;
		if(jeu[i][j] == 0){
			vide = true;
		}
		return vide;
	}	
	
}
