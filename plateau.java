import java.util.*;

public class plateau{
	
	
	public int[][] plateau;
	
	public plateau (LinkedList<Pair>list){
		int n = Math.sqrt((Pair.size())*2);	/pas de problem car les listes sont composées d'un nombre de paire de telle sorte à obtenir une matrice carrée
		plateau = new int [n][n];
		
		p=0;
		While(!Pair.isEmpty()){
			int i = (int)(Math.random()*n);	/renvoie un indice de position entre 0 et n
			int j = (int)(Math.random()*n);
			int k = (int)(Math.random()*n);
			int l = (int)(Math.random()*n);
			
			if (plateau[i][j] == null && plateau[k][l] == null && (i!=k || j!=l){	/on vérifie qu'il n'y est pas déjà un chiffre aux emplacements (i,j),(k,l)
				plateau[i][j] == Pair.get(p.get(a));
				plateau[k][l] == Pair.get(p.get(b));
				p++;			
			}
	
		}
	}
	
}
