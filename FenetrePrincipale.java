import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList; 

public class FenetrePrincipale extends JFrame implements ActionListener{
	
	public JButton [][] lesBoutons;
	public Timer mt;
	public partie p;
	int a;
	int k;
	int l;
	boolean click = false;
	int cpt =0;
	JLabel temps;
	
	public FenetrePrincipale (partie p){
		
		//Instanciation partie
        this.p=p;
		
		//Paramètres de la fenetre
		this.setTitle("THE MEMORY");
		this.setSize(700,700);
		
		// Pour placer la fenêtre au centre de l'écran
		this.setLocationRelativeTo(null);
		
		// Pour empêcher le redimensionnement de la fenêtre
		this.setResizable(false);
		
		// Pour permettre la fermeture de la fenêtre lors de l'appui sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Initialisation du timer
		mt = new Timer (1000, this);
		
		//Panneau du fond
		JPanel fond = new JPanel();
		fond.setBounds(0,0,700,700);
		fond.setLayout(null);
		fond.setBackground(Color.green);
		this.add(fond);
		
		//titre
		JLabel titre = new JLabel("THE MEMORY");
		titre.setBounds(250,20,200,50);
		titre.setBackground(Color.red);
		titre.setForeground(Color.white);
		fond.add(titre);
		
		//Timer
		temps = new JLabel();
		temps.setBounds(500, 20, 50,50);
		fond.add(temps);
		
		//nombre clé
		String z = Integer.toString(p.nombre);
		JLabel cle = new JLabel(z);
		cle.setBounds(20,20,50,50);
		cle.setBackground(Color.red);
		cle.setForeground(Color.white);
		fond.add(cle);
		
		//Tableau de boutons
		int n = (int)(Math.sqrt((p.nombrePair)*2));
		int t = p.taillebouton;
		lesBoutons = new JButton[n][n];		
		int ecartx = (700-n*t)/(n+1);
		int ecarty = (600-n*t)/(n+1);
		
		for(int i=0 ; i < n ; i++){
			for(int j=0 ; j < n ; j++){
				lesBoutons[i][j] = new JButton();
				lesBoutons[i][j].setBounds( ecartx+i*ecartx+i*t , 100+j*ecarty+j*t , t , t );
				lesBoutons[i][j].addActionListener(this);
				
				fond.add(lesBoutons[i][j]);			
			}
		}
		
		this.setVisible(true);
	}	
	
	public void actionPerformed (ActionEvent e){
		cpt++;
		temps.setText(String.valueOf(cpt));
		for(int i=0 ; i < lesBoutons.length ; i++){
			for(int j=0 ; j < lesBoutons[0].length ; j++){
				if(e.getSource() == lesBoutons[i][j]){
					a = afficherCase(i,j);
					k = i;
					l = j;
					click = true;
				}
			}
		}
	}
	
	//Récupère le nombre choisit et l'affiche sur le bouton
	public int afficherCase(int i, int j){
		int a = p.tab.jeu[i][j];
		String w = Integer.toString(a);
		lesBoutons[i][j].setText(w);
		return a;
	}	
	
	public boolean modification (int a, int b, int c){
		boolean modif = false;
		if(a != this.a || b != this.k || c != this.l){
			modif = true; 
		}
		return modif;
	}	
	
	public void bloquerClic (){
		for(int i=0 ; i < lesBoutons.length ; i++){
			for(int j=0 ; j < lesBoutons[0].length ; j++){
				lesBoutons[i][j].setEnabled(false);
			}
		}
    }
	
	public void debloquerClic (){
		for(int i=0 ; i < lesBoutons.length ; i++){
			for(int j=0 ; j < lesBoutons[0].length ; j++){
				lesBoutons[i][j].setEnabled(true);
			}
		}
    }
	
}
