//Bilbiothèques
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;
import javax.swing.UIManager;
import javax.swing.plaf.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.*;

public class FenetreNiveau extends JFrame implements ActionListener{
    
    //Atributs
    public Font policeTaille14, policeTaille16, policeTaille18;
    public JMenu menu;
    public JMenuBar menubar;
    public JMenuItem regle, autre;
    public String reglejeu, information, erreur;
    public JButton bouton1, bouton2, bouton3, boutonadd, boutonsous, quitter, boutonJouer, son;
	public JLabel chpsNiveau, chpsOpe, horloge;
	public int niveau = 0, operation = 0;
    public Partie p;
    public FenetrePrincipale f;
    public boolean click1 = false, click2 = false, jouer = false, sonOn;
    public ImageIcon iconSonOn, iconSonOff, icon;
    public Image imageSonOn, imageSonOff;
    public Sound leSon;
    
    
    public FenetreNiveau(boolean sonOn){
        
        this.leSon = Principal.leSon;
        this.sonOn = sonOn;
        
        //Définition de la fenetre
        this.setTitle("Bienvenue - The Memory");
        this.setSize(430,490);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(FenetreAccueil.class.getResource("M.png")).getImage());
        
        //définition des polices d'écriture
        policeTaille14 = new Font("Cambria", Font.PLAIN , 14);
        policeTaille16 = new Font("Cambria", Font.PLAIN , 16);
        policeTaille18 = new Font("Cambria", Font.PLAIN , 18);
        
        //Initialisation du niveau à 0
        niveau = 0;

        //conteneur principal - se place au centre
        JPanel monConteneur = new JPanel();
        monConteneur.setLayout(null);
        
        //Boutons de choix niveau
        bouton1 = new JButton("Niveau 1");
        bouton1.setFont(policeTaille16);
        bouton1.setBounds(25,180,100,50);
        bouton1.addActionListener(this);
        monConteneur.add(bouton1);
        
        bouton2 = new JButton("Niveau 2");
        bouton2.setFont(policeTaille16);
        bouton2.setBounds(150,180,100,50);
        bouton2.addActionListener(this);
        monConteneur.add(bouton2);
        
        bouton3 = new JButton("Niveau 3");
        bouton3.setBounds(275,180,100,50);
        bouton3.setFont(policeTaille16);
        bouton3.addActionListener(this);
        monConteneur.add(bouton3);
        
        //Boutons choix opération
        boutonadd = new JButton("Addition");
        boutonadd.setBounds(25, 50, 150, 50);
        boutonadd.setFont(policeTaille18);
        boutonadd.addActionListener(this);
        monConteneur.add(boutonadd);
        
        boutonsous = new JButton("Soustraction");
        boutonsous.setBounds(225, 50, 150, 50);
        boutonsous.setFont(policeTaille18);
        boutonsous.addActionListener(this);
        monConteneur.add(boutonsous);
        
		//Bouton quitter
        quitter = new JButton("Quitter");
        quitter.setBounds(10,355,100,50);
        quitter.setFont(policeTaille16);
        quitter.setForeground(Color.RED);
        quitter.addActionListener(this);
        monConteneur.add(quitter);
        
        //Bouton Jouer
        boutonJouer = new JButton("Jouer !");
        boutonJouer.setBounds(305,355,100,50);
        boutonJouer.setFont(policeTaille18);
        boutonJouer.addActionListener(this);
        monConteneur.add(boutonJouer);
        
        //Bouton son
		iconSonOn = new ImageIcon("./SonOn.png");
        imageSonOn = scaleImage(iconSonOn.getImage(), 30, 30);
        
        iconSonOff = new ImageIcon("./SonOff.png");
        imageSonOff = scaleImage(iconSonOff.getImage(), 30, 30);
        
        son = new JButton();
        son.setBounds(385,0, 30, 30);
        son.setBackground(Color.WHITE);
        
        if(sonOn){
			son.setIcon(new ImageIcon(imageSonOn));
			leSon.jouerEnBoucle();
        }else{
			son.setIcon(new ImageIcon(imageSonOff));
			leSon.arreter();
		}	
        
        son.addActionListener(this);
        monConteneur.add(son);
       
        
        //Affichage niveau choisit
        chpsNiveau = new JLabel();
        chpsNiveau.setFont(policeTaille18);
        chpsNiveau.setForeground(Color.WHITE);
        chpsNiveau.setBounds(222,230,50,50);
        monConteneur.add(chpsNiveau);
        
        //Affichage opération choisit
        chpsOpe = new JLabel();
        chpsOpe.setFont(policeTaille18);
        chpsOpe.setForeground(Color.WHITE);
        chpsOpe.setBounds(243,110,140,50);
        monConteneur.add(chpsOpe);
        
        //Etiquette info niveau
        JLabel chpsNiveau = new JLabel("Vous avez choisit le niveau :");
        chpsNiveau.setBounds(25,230,200,50);
        chpsNiveau.setForeground(Color.WHITE);
        chpsNiveau.setFont(policeTaille16);
        monConteneur.add(chpsNiveau);
        
        //Etiquette info operation
        JLabel chpsope = new JLabel("Vous avez choisit l'opération :");
        chpsope.setBounds(25, 110, 210, 50);
        chpsope.setForeground(Color.WHITE);
        chpsope.setFont(policeTaille16);
        monConteneur.add(chpsope);
        
        //Etiquette date
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		horloge = new JLabel(format.format(date));
		horloge.setForeground(Color.WHITE);
		horloge.setBounds(25,-20, 400, 100);
		horloge.setFont(policeTaille16);
        monConteneur.add(horloge);
       
        //Création du menu
        menu = new JMenu("Menu");
        menu.setFont(policeTaille18);
        menubar = new JMenuBar();
        
        //Items du menu et leurs caractéristiques
        regle = new JMenuItem("Règles du jeu");
        regle.addActionListener(this);
        regle.setFont(policeTaille18);
        
        autre = new JMenuItem("Informations");
        autre.addActionListener(this);
        autre.setFont(policeTaille18);
        
        menu.add(regle);
        menu.add(autre);
        menubar.add(menu);
        
        this.setJMenuBar(menubar);
		
        //Texte de présentation du menu
        reglejeu = "<html> Ce jeu est un memory où il faut former des pairs en faisant au choix des sommes ou des soustractions. <br> L'ordinateur choisit un nombre entre 10 et 70 selon le niveau choisit.<br>Le nombre de pairs à retrouver dépend du niveau choisit ! <br> Le but du jeu est de retrouver toutes les pairs. Ce jeu vous entraine donc à la fois votre mémoire et développe aussi votre capacité de calcul mental :) </html>";
        information = "<html>- Jeu réalisé par Agathe Vincent, Harry Kalfon et Noa Portier - <br> - 2022 - Projet Informatique - Insa LYON - </html>";
        erreur = "Veuillez d'abord choisir un type et un niveau de jeu !";
        
        //Fond d'écran - image        
        icon = new ImageIcon("./ImageNiveau.png");
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
            if(click1 == false || click2 == false){
                JOptionPane.showMessageDialog(this, erreur,"Attention",1,null); //si la personne clique sur jouer sans avoir remplit les conditions
                jouer = false;
            }else{
				jouer = true;
				chpsOpe.setText("");
				chpsNiveau.setText("");
            }
        }
        
        if (e.getSource() == regle){
            ImageIcon iconjeu = new ImageIcon("jeu.png");
            Image imagejeu = scaleImage(iconjeu.getImage(), 30,30);
            UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
			UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font ("Cambria", Font.PLAIN , 14)));
            JOptionPane.showMessageDialog(this, reglejeu, "Règles du jeu", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imagejeu));
        }
        
        if(e.getSource() == autre){
            ImageIcon lum = new ImageIcon("lumière.jpg");
            Image lum2 = scaleImage(lum.getImage(), 30,30);
            UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
			UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font ("Cambria", Font.PLAIN , 14)));
            JOptionPane.showMessageDialog(this, information, "Information", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(lum2));
        }
        
        if(e.getSource() == quitter){
            System.exit(0);
        }
        
        if(e.getSource() == son){
			sonOnOff();
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
    
    //Arreter ou remmetre la musique
	public void sonOnOff (){
		if(sonOn){
			leSon.arreter();
			son.setIcon(new ImageIcon(imageSonOff));
			this.sonOn = false;
		}else{
			this.sonOn = true;
			leSon.jouer();
			son.setIcon(new ImageIcon(imageSonOn));
		}		
	}
    
}
