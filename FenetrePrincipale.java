import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList; 

public class FenetrePrincipale extends JFrame implements ActionListener{
	
	public JButton [][] lesBoutons;
	public Timer mt;
	public partie p;
	
	public FenetrePrincipale (int niveau){
		
		partie p = new partie (niveau);
		
		this.setTitle("THE MEMORY");
		this.setSize(700,700);
		
		// Pour placer la fenêtre au centre de l'écran
		this.setLocationRelativeTo(null);
		
		// Pour empêcher le redimensionnement de la fenêtre
		this.setResizable(false);
		
		// Pour permettre la fermeture de la fenêtre lors de l'appui sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Panneau du fond
		JPanel fond = new JPanel();
		fond.setBounds(0,0,700,700);
		fond.setLayout(null);
		fond.setBackground(Color.green);
		this.add(fond);
		
		//titre
		JTextField titre = new JTextField("THE MEMORY");
		titre.setBounds(250,20,200,50);
		titre.setBackground(Color.red);
		titre.setForeground(Color.white);
		fond.add(titre);
		
		//nombre clé
		String z = Integer.toString(p.nombre);
		JTextField cle = new JTextField(z);
		cle.setBounds(20,20,50,50);
		cle.setBackground(Color.red);
		cle.setForeground(Color.white);
		fond.add(cle);
		
		//Tableau de boutons
		int n = (int)(Math.sqrt((p.nombrePair)*2));
		lesBoutons = new JButton[n][n];		
		int ecartx = (700-n*70)/(n+1);
		int ecarty = (600-n*70)/(n+1);
		
		for(int i=0 ; i < n ; i++){
			for(int j=0 ; j < n ; j++){
				lesBoutons[i][j] = new JButton();
				lesBoutons[i][j].setBounds(ecartx+i*ecartx+i*70,100+j*ecarty+j*70,70,70);
				lesBoutons[i][j].addActionListener(this);
				
				fond.add(lesBoutons[i][j]);			
			}
		}
		
		//timer
		mt = new Timer(1000,this);
		
		this.setVisible(true);
	}	
	
	public void actionPerformed (ActionEvent e){
		
		boolean retourne = false;
		int a = 0;
		for(int i=0 ; i < lesBoutons.length ; i++){
			for(int j=0 ; j < lesBoutons[0].length ; j++){
				if(e.getSource() == lesBoutons[i][j]){
					a = afficherCase(i,j);
				}
			}	
		}
		
		int b = 0;
		for(int i=0 ; i < lesBoutons.length ; i++){
			for(int j=0 ; j < lesBoutons[0].length ; j++){
				if(e.getSource() == lesBoutons[i][j]){
					b = afficherCase(i,j);
				}
			}	
		}
		
		retourne = verif(a,b);
		//bloquer les clic
		//si retourne true il faut supprimer/cacher les 2 boutons
		//Si retourne false il faut recacher les images
		//Verif fin de partie
		//continuer jeu

	}
	public int afficherCase(int i, int j){
		int a = p.tab.jeu[i][j];	//ATTENTION ERREUR POINTER NUL
		String w = Integer.toString(a);
		lesBoutons[i][j].setText(w);
		return a;
	}	
	
	public boolean verif (int a, int b){
		boolean verif = false;
		Pair v1 = new Pair(a,b);
		if(p.list.contains(v1)){
			verif = true;
			p.list.remove(v1);
			
		}
		Pair v2	= new Pair (b,a);
		if(p.list.contains(v2)){
			verif = true;
			p.list.remove(v2);
		}
		return verif;
	}
		
}
