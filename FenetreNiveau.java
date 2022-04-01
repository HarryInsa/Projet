//Bilbiothèques
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.*;

public class FenetreNiveau extends JFrame implements ActionListener{
    
    //Atributs
    public int niveau = 0;
    public int operation = 0;
    public JButton bouton1;
    public JButton bouton2;
    public JButton bouton3;
    public JButton boutonadd;
    public JButton boutonsous;
    public JButton quitter;
    public JButton boutonJouer;
    public Font police;
    public Font police2;
    public Font police3;
    public String res;
    public String res1;
    public String res3;
    public JMenu menu;
    public JMenuBar menubar;
    public JMenuItem regle;
    public JMenuItem autre;
    public JLabel chpsNiveau;
    public JLabel chpsOpe;
    public JLabel horloge;
    public ImageIcon icon;
    public partie p;
    public FenetrePrincipale f;
    public boolean click1 = false;
    public boolean click2 = false;
    public boolean jouer = false;
    
    
    
    public FenetreNiveau(){
        
        //Définition de la fenetre
        this.setTitle("Bienvenue - The Memory");
        this.setSize(430,490);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //définition des polices d'écriture
        police3 = new Font(" Arial " , Font.PLAIN , 12);
        police = new Font(" Arial " , Font.PLAIN , 16);
        police2 = new Font(" Arial " , Font.PLAIN , 13);
        
        //Initialisation du niveau à 0
        niveau = 0;

        //conteneur principal - se place au centre
        JPanel monConteneur = new JPanel();
        monConteneur.setLayout(null);
        
        //Boutons de choix niveau
        bouton1 = new JButton("Niveau 1");
        bouton1.setFont(police);
        bouton1.setBounds(25,180,100,50);
        bouton1.addActionListener(this);
        monConteneur.add(bouton1);
        
        bouton2 = new JButton("Niveau 2");
        bouton2.setFont(police);
        bouton2.setBounds(150,180,100,50);
        bouton2.addActionListener(this);
        monConteneur.add(bouton2);
        
        bouton3 = new JButton("Niveau 3");
        bouton3.setBounds(275,180,100,50);
        bouton3.setFont(police);
        bouton3.addActionListener(this);
        monConteneur.add(bouton3);
        
        //Boutons choix opération
        boutonadd = new JButton("Addition");
        boutonadd.setBounds(25, 50, 150, 50);
        boutonadd.setFont(police);
        boutonadd.addActionListener(this);
        monConteneur.add(boutonadd);
        
        boutonsous = new JButton("Soustraction");
        boutonsous.setBounds(225, 50, 150, 50);
        boutonsous.setFont(police);
        boutonsous.addActionListener(this);
        monConteneur.add(boutonsous);
        
		//Bouton quitter
        quitter = new JButton("Quitter");
        quitter.setBounds(0,355,100,50);
        quitter.setFont(police3);
        quitter.setForeground(Color.RED);
        quitter.addActionListener(this);
        monConteneur.add(quitter);
        
        //Bouton Jouer
        boutonJouer = new JButton("Jouer !");
        boutonJouer.setBounds(320,355,100,50);
        boutonJouer.setFont(police3);
        boutonJouer.addActionListener(this);
        monConteneur.add(boutonJouer);
        
        //Affichage niveau choisit
        chpsNiveau = new JLabel();
        chpsNiveau.setFont(police);
        chpsNiveau.setForeground(Color.WHITE);
        chpsNiveau.setBounds(222,230,50,50);
        monConteneur.add(chpsNiveau);
        
        //Affichage opération choisit
        chpsOpe = new JLabel();
        chpsOpe.setFont(police);
        chpsOpe.setForeground(Color.WHITE);
        chpsOpe.setBounds(233,110,140,50);
        monConteneur.add(chpsOpe);
        
        //Etiquette info niveau
        JLabel chpsNiveau = new JLabel("Vous avez choisit le niveau :");
        chpsNiveau.setBounds(25,230,200,50);
        chpsNiveau.setForeground(Color.WHITE);
        chpsNiveau.setFont(police2);
        monConteneur.add(chpsNiveau);
        
        //Etiquette info operation
        JLabel chpsope = new JLabel("Vous avez choisit l'opération :");
        chpsope.setBounds(25, 110, 200, 50);
        chpsope.setForeground(Color.WHITE);
        chpsope.setFont(police2);
        monConteneur.add(chpsope);
        
        //Etiquette date et heure
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd                                                    HH:mm:ss");
		Date date = new Date();
		horloge = new JLabel(format.format(date));
		horloge.setForeground(Color.WHITE);
		horloge.setBounds(25,-30, 400, 100);
        monConteneur.add(horloge);
       
        //Création du menu
        menu = new JMenu("Menu");
        menu.setFont(police);
        menubar = new JMenuBar();
        
        //Items du menu et leurs caractéristiques
        regle = new JMenuItem("Règles du jeu");
        regle.addActionListener(this);
        regle.setFont(police);
        
        autre = new JMenuItem("Autres");
        autre.addActionListener(this);
        autre.setFont(police);
        
        menu.add(regle);
        menu.add(autre);
        menubar.add(menu);
        
        this.setJMenuBar(menubar);
		
        //Texte de présentation du menu
        res = "Ce jeu est un memory. \nL'ordinateur choisit un nombre entre 50 et 100.";
        res += "\nVotre but est de retrouver toutes les paires dont la somme fait le nombre choisit !";
        res += "\nCe jeu vous entraine donc à la fois votre mémoire et développe aussi votre capacité de calcul mental :)";
        res1= "- Jeu réalisé par Agathe Vincent, Harry Kalfon et Noa Portier \n-2022 - Projet Informatique - Insa LYON -";
        res3="Veuillez d'abord choisir un type et un niveau de jeu !";
        
        //pour changer la couleur des joption
		// UIManager.put("OptionPane.background",new ColorUIResource(54,66,230));
        //UIManager.put("Panel.background",new ColorUIResource(54,66,230));        
        
        //Fond d'écran - image        
        icon = new ImageIcon("./LogoPrinc.png");
        JLabel fond = new JLabel();
        Image imageZoom = scaleImage(icon.getImage(), 415, 465);
        fond.setIcon (new ImageIcon(imageZoom));
        fond.setBounds(0,0,415,465);
        monConteneur.add(fond);
        
        add(monConteneur);
        this.setVisible(true);
    }
    
    
    public void actionPerformed (ActionEvent e){
		
		if (e.getSource() == bouton1){
            chpsNiveau.setText("1");
            niveau = 1;
			click1 = true;
        }
        if (e.getSource() == bouton2){
            chpsNiveau.setText("2");
            niveau = 2;
			click1 = true;
        }
        if (e.getSource() == bouton3){
			chpsNiveau.setText("3");
			niveau = 3;
			click1 = true;
        }
        
        if (e.getSource() == boutonadd){
			chpsOpe.setText("Addition");
			operation = 1;	//1 pour le choix de l'addition
			click2 = true;
		}
        if (e.getSource() == boutonsous){
			chpsOpe.setText("Soustraction");
			operation = 2;	//2 pour le choix de la soustraction
			click2 = true;
		}	
        if(e.getSource() == boutonJouer){
            if(click1==false || click2==false){
                JOptionPane.showMessageDialog(this,res3,"Attention",1,null); //si la personne clique sur jouer sans avoir remplit les conditions
                jouer=false;
            }else{
            jouer=true;
            }
        }
        if (e.getSource()==regle){
            JOptionPane.showMessageDialog(this,res,"Règles du Jeu",1,null); 
        }
        if(e.getSource()==autre){
            JOptionPane.showMessageDialog(this,res1,"Informations",1,null);
        }
        
        if(e.getSource() == quitter){
            System.exit(0);
        }
        
    }
    
    public static Image scaleImage(Image source, int width, int height) {
	    return source.getScaledInstance(width, height, java.awt.Image.SCALE_AREA_AVERAGING);
    }
    
    //Pour savoir si la fenetre est ouverte ou non
    public boolean estOuverte (){
		if(this.isVisible() == true){
			return true;
		}else{
			return false;
		}	
	}	
    
}
