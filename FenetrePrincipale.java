//Bibliothèques
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList; 

public class FenetrePrincipale extends JFrame implements ActionListener{
	
	//Attributs
	public JButton [][] lesBoutons;
	public Timer mt;
	public partie p;
	public int a;
	public int k;
	public int l;
	public boolean click = false;
	public int cpt =0;
	public JLabel temps;
    public Font policeTitre;
    public Font policeGrande;
    public Font policeMoyenne;
    public Font policePetite;
    public Font policeNbCle;
     public ImageIcon icon;

    
	public FenetrePrincipale (int niveau, int operation){
		
		//Instanciation partie
        p = new partie (niveau, operation);
        
		//police
        policeGrande = new Font ("Cambria", Font.BOLD,62); //police niveau 1
        policeMoyenne = new Font ("Cambria", Font.BOLD,32); //police niveau 2
        policePetite = new Font ("Cambria", Font.BOLD,22); //police niveau 3
        policeNbCle = new Font(" Arial " , Font.PLAIN , 20); //police nombre cle
        
		//Initialisation de la fenetre
		this.setTitle("THE MEMORY");
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Initialisation du timer
		mt = new Timer (1000, this);
		
		//Panneau du fond
		JPanel fond = new JPanel();
		fond.setBounds(0,0,700,700);
		fond.setLayout(null);
		this.add(fond);
		
		//Temps
		temps = new JLabel();
		temps.setBounds(560, 20, 150,50);
		temps.setForeground(Color.white);
		temps.setFont(policeNbCle);
		fond.add(temps);
		
		//nombre clé
		String z = Integer.toString(p.nombre);
		JLabel cle = new JLabel("Nombre clé : "+z);
        cle.setFont(policeNbCle);
		cle.setBounds(15,20,150,50);
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
                //lesBoutons[i][j].setBackground(Color.white);
				fond.add(lesBoutons[i][j]);		
                choixPolice(lesBoutons[i][j]);
				lesBoutons[i][j].addActionListener(this);
			}
		}
		
		//Fond d'écran - image        
        icon = new ImageIcon("./logoJeu.png");
        JLabel fondImage = new JLabel();
        Image imageZoom = scaleImage(icon.getImage(), 690, 700);
        fondImage.setIcon (new ImageIcon(imageZoom));
        fondImage.setBounds(0,0,700,700);
        fond.add(fondImage);
		
		this.setVisible(true);
	}	
	
	public void actionPerformed (ActionEvent e){
		
		cpt++;
		afficheTemps();
		
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
	
	//Permet de bloquer l'acces aux boutons du tableau
	public void bloquerClic (){
		for(int i=0 ; i < lesBoutons.length ; i++){
			for(int j=0 ; j < lesBoutons[0].length ; j++){
				lesBoutons[i][j].setEnabled(false);
			}
		}
    }
	
	//Permet de débloquer l'acces aux boutons du tableau
	public void debloquerClic (){
		for(int i=0 ; i < lesBoutons.length ; i++){
			for(int j=0 ; j < lesBoutons[0].length ; j++){
				lesBoutons[i][j].setEnabled(true);
			}
		}
    }
    
    public void choixPolice(JButton b){
        switch (p.niveau){
            case 1 :
                b.setFont(policeGrande);
            case 2 :
                b.setFont(policeMoyenne);
            case 3 : 
                b.setFont(policePetite);
        }    
    }
	
public void afficheTemps (){
		//Définition du temps
		int minutes = (int)(cpt/60);
		int secondes = (int)(cpt-minutes*60);
		
		if(minutes < 1){
            if(secondes==1 || secondes == 0){
                temps.setText(secondes + " sec");
            }else{
                temps.setText(secondes + " secs");
            }
		}else if(minutes == 1){
            if(secondes==1){
                temps.setText(minutes + " min " + secondes + " sec");
            }else if (secondes == 0){
				temps.setText(minutes + " min ");
			}else{
				
                temps.setText(minutes + " min " + secondes + " secs");
            }
		}else{
			if(secondes==1){
                temps.setText(minutes + " mins " + secondes + " sec");
            }else if (secondes == 0){
				temps.setText(minutes + " mins ");
			}else{
				
                temps.setText(minutes + " mins " + secondes + " secs");
            }
		}
	}
	
	public static Image scaleImage(Image source, int width, int height) {
	    return source.getScaledInstance(width, height, java.awt.Image.SCALE_AREA_AVERAGING);
    }
	
}
