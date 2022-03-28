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
    public JButton bouton1;
    public JButton bouton2;
    public JButton bouton3;
    public JButton quitter;
    public Font police;
    public Font police2;
    public String res;
    public String res1;
    public JMenu menu;
    public JMenuBar menubar;
    public JMenuItem regle;
    public JMenuItem autre;
    public JTextField chpsTexte;
    public JLabel horloge;
    public ImageIcon icon;
    public partie p;
    public FenetrePrincipale f;
    public boolean click;
    
    
    public FenetreNiveau(){
        
        //Définition de la fenetre
        this.setTitle("Bienvenue - The Memory");
        this.setSize(415,465);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //définition des polices d'écriture
        police = new Font(" Arial " , Font.BOLD , 16);
        police2 = new Font(" Arial " , Font.BOLD , 13);
        
        //Initialisation du niveau à 0
        niveau = 0;

        //conteneur principal - se place au centre
        JPanel monConteneur = new JPanel();
        monConteneur.setLayout(null);
        
        //Boutons de choix niveau
        bouton1 = new JButton("Niveau 1");
        bouton1.setFont(police);
        bouton1.setBounds(25,125,100,50);
        bouton1.addActionListener(this);
        monConteneur.add(bouton1);
        
        bouton2 = new JButton("Niveau 2");
        bouton2.setFont(police);
        bouton2.setBounds(150,125,100,50);
        bouton2.addActionListener(this);
        monConteneur.add(bouton2);
        
        bouton3 = new JButton("Niveau 3");
        bouton3.setBounds(275,125,100,50);
        bouton3.setFont(police);
        bouton3.addActionListener(this);
        monConteneur.add(bouton3);
        
		//Bouton quitter
        quitter = new JButton("Quitter");
        quitter.setBounds(300,350,100,50);
        quitter.setFont(police);
        quitter.setForeground(Color.RED);
        quitter.addActionListener(this);
        monConteneur.add(quitter);
        
        //Champ texte avec étiquette
        chpsTexte = new JTextField();
        chpsTexte.setFont(police);
        chpsTexte.setBounds(275,225,50,50);
        monConteneur.add(chpsTexte);
        
        //Etiquette info
        JLabel chps = new JLabel("Vous avez choisit le niveau :");
        chps.setBounds(25,225,200,50);
        chps.setFont(police2);
        monConteneur.add(chps);
        
        //Etiquette date et heure
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		horloge = new JLabel(format.format(date));
		horloge.setBounds(0,0, 200, 100);
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
        
        //pour changer la couleur des joption
		// UIManager.put("OptionPane.background",new ColorUIResource(54,66,230));
        //UIManager.put("Panel.background",new ColorUIResource(54,66,230));        
        
        //Fond d'écran - image        
        icon = new ImageIcon("./Logo.png");
        JLabel fond = new JLabel();
        Image imageZoom = scaleImage(icon.getImage(), 400, 400);
        fond.setIcon (new ImageIcon(imageZoom));
        fond.setBounds(0,0,400,400);
        monConteneur.add(fond);
        
        add(monConteneur);
        this.setVisible(true);
    }
    
    
    public void actionPerformed (ActionEvent e){
		
		if (e.getSource() == bouton1){
            f = new FenetrePrincipale(1);
			click = true;
        }else if (e.getSource() == bouton2){
            f = new FenetrePrincipale(2);
			click = true;
        }else if (e.getSource() == bouton3){
			f = new FenetrePrincipale(3);
			click = true;
        }
        
        if (e.getSource()==regle){
            JOptionPane.showMessageDialog(this,res,"Règles du Jeu",1,null); 
        }else if(e.getSource()==autre){
            JOptionPane.showMessageDialog(this,res1,"Informations",1,null);
        }
        
        if(e.getSource() == quitter){
            System.exit(0);
        }
    }
    
    public static Image scaleImage(Image source, int width, int height) {
	    return source.getScaledInstance(width, height, java.awt.Image.SCALE_AREA_AVERAGING);
    }
    
    public boolean estOuverte (){
		if(this.isVisible() == true){
			return true;
		}else{
			return false;
		}	
	}	
    
}
