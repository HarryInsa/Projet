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

public class FenetreAccueil extends JFrame implements ActionListener{
	
	//Attributs
	public Font police;
    public Font police2;
    public Font police3;
    public String res;
    public String res1;
    public JMenu menu;
    public JMenuBar menubar;
    public JMenuItem regle;
    public JMenuItem autre;
    public ImageIcon icon;
    public JLabel horloge;
    public JButton continuer;
    public boolean click = false;
    public FenetreNiveau fenetreniveau;
	
	public FenetreAccueil (){
		
		//Définition de la fenetre
        this.setTitle("Bienvenue - The Memory");
        this.setSize(415,465);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //définition des polices d'écriture
        police = new Font(" Arial " , Font.BOLD , 16);
        police2 = new Font(" Arial " , Font.BOLD , 13);
        police3 =new Font("Comic Sans", Font.ITALIC, 14);
        
        //conteneur principal - se place au centre
        JPanel monConteneur = new JPanel();
        monConteneur.setLayout(null);
        
        //Etiquette règles du jeu
        JLabel etiquette = new JLabel();
        etiquette.setBounds (50, 25, 400, 300);
        etiquette.setForeground(Color.black);
        etiquette.setFont(police3);
        etiquette.setText("Vous allez jouer au memory des chiffres, \n blablabla");
        monConteneur.add(etiquette); 
        
        //Bouton continuer
        continuer = new JButton("Continuer");
        continuer.setBounds (150, 300, 100, 50);
        monConteneur.add(continuer);
        continuer.addActionListener(this);
        
        //Fond d'écran - image        
        icon = new ImageIcon("./Logo2bis.png");
        JLabel fond = new JLabel();
        Image imageZoom = scaleImage(icon.getImage(), 400,400);
        fond.setIcon (new ImageIcon(imageZoom));
        fond.setBounds(0,0,400,400);
        monConteneur.add(fond);
        
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
        
        add(monConteneur);
        this.setVisible(true);
        
	}	
	
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == continuer){
			fenetreniveau = new FenetreNiveau();
			click = true;
			//Principal.b = true;
			//Principal.lancerJeu();
			this.dispose();
		}	
	}	
	
	 public static Image scaleImage(Image source, int width, int height) {
	    return source.getScaledInstance(width, height, java.awt.Image.SCALE_AREA_AVERAGING);
    }
	
}	
