//Bibliothèques
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class FenetrePrincipale extends JFrame implements ActionListener {
	
	//Attributs
	public Font policeTitre, policeNiveau1, policeNiveau2, policeNiveau3, policeCentaine, policeNbCle, policeTempsdeJeu;
    public int a, k, l, tempsdeJeu;
    public long start;
	public javax.swing.Timer mt;
	public JLabel temps;
    public JButton [][] lesBoutons;
	public partie p;
	public boolean click = false, b;
    public ImageIcon iconSonOn, iconSonOff, icon;
	public Image imageSonOn, imageSonOff;
	public JButton son;
	public Sound leSon;
    
	public FenetrePrincipale (int niveau, int operation, Sound leSon, boolean b){
		
		//Instanciation partie
        p = new partie (niveau, operation);
        this.b = b;
		this.leSon = leSon;
        
		//Définition des polices
        policeNiveau1 = new Font ("Cambria", Font.PLAIN, 50);
        policeNiveau2 = new Font ("Cambria", Font.PLAIN, 30);
        policeNiveau3 = new Font ("Cambria", Font.PLAIN, 17);
        policeCentaine = new Font ("Cambria",Font.PLAIN, 14);
        policeNbCle = new Font("Cambria", Font.PLAIN, 22);
        policeTempsdeJeu = new Font("Cambria", Font.PLAIN, 18);
        
		//Initialisation de la fenetre
		this.setTitle("THE MEMORY");
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(FenetreAccueil.class.getResource("M.png")).getImage());
		
		//Initialisation du temps de jeu
		mt = new javax.swing.Timer (1000,this);
		start = System.currentTimeMillis();
		
		//Panneau du fond
		JPanel fond = new JPanel();
		fond.setBounds(0,0,700,700);
		fond.setLayout(null);
		this.add(fond);
		
		//Bouton son
		iconSonOn = new ImageIcon("./SonOn.png");
        imageSonOn = scaleImage(iconSonOn.getImage(), 30, 30);
        
        iconSonOff = new ImageIcon("./SonOff.png");
        imageSonOff = scaleImage(iconSonOff.getImage(), 30, 30);
        
        son = new JButton();
        son.setBounds(655,0, 30, 30);
        son.setBackground(Color.WHITE);
        
        if(!b){
			son.setIcon(new ImageIcon(imageSonOn));
        }else{
			son.setIcon(new ImageIcon(imageSonOff));
		}	
        
        son.addActionListener(this);
        fond.add(son);
		
		//Affichage du temps de jeu
		temps = new JLabel();
		temps.setBounds(560, 20, 150,50);
		temps.setForeground(Color.white);
		temps.setFont(policeTempsdeJeu);
		temps.setHorizontalAlignment(SwingConstants.CENTER);
		fond.add(temps);
		
		//Affichage du nombre clé
		String z = Integer.toString(p.nombre);
		JLabel cle = new JLabel("Nombre clé : "+z);
        cle.setFont(policeNbCle);
		cle.setBounds(5,20,150,50);
		cle.setForeground(Color.white);
		fond.add(cle);
		
		//Création et affichage du tableau de boutons
		int n = (int)(Math.sqrt((p.nombrePair)*2));
		int t = p.taillebouton;
		lesBoutons = new JButton[n][n];		
		int ecartx = (700-n*t)/(n+1);
		int ecarty = (600-n*t)/(n+1);
		
		for(int i=0 ; i < n ; i++){
			for(int j=0 ; j < n ; j++){
				lesBoutons[i][j] = new JButton();
				lesBoutons[i][j].setBounds( ecartx+i*ecartx+i*t , 100+j*ecarty+j*t , t , t );
				fond.add(lesBoutons[i][j]);		
                choixPolice(lesBoutons[i][j], i, j);
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
		
		if(e.getSource() == son){
			sonOnOff(b);
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
    
    //Choix de la taille de la police selon le niveau
    public void choixPolice(JButton b, int i, int j){
        if(p.niveau == 1){
			b.setFont(policeNiveau1);
		}else if(p.niveau == 2){
			b.setFont(policeNiveau2);
        }else{
			b.setFont(policeNiveau3);
		}	
        
        if(String.valueOf(p.tab.jeu[i][j]).length() >= 3){
			b.setFont(policeCentaine);
		}	
    }
	
	//Calcul le temps écoulé et l'affiche
	public void afficheTemps (){
		
		long actuel = System.currentTimeMillis();
		tempsdeJeu = (int)(actuel - start)/1000;
		int minutes = (int)(tempsdeJeu/60);
		int secondes = (int)(tempsdeJeu - 60*minutes);
		
		
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
	
	//Arreter ou remmetre la musique	
	public void sonOnOff (boolean b){
		if(b){
			leSon.jouerEnBoucle();
			son.setIcon(new ImageIcon(imageSonOn));
			this.b = false;
		}else{
			leSon.arreter();
			son.setIcon(new ImageIcon(imageSonOff));
			this.b = true;
		}		
	}	
	
}
