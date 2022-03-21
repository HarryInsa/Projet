//Bilbiothèque
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.*;
import java.util.*;

public class FenetreNiveau extends JFrame implements ActionListener{
    
    int niveau;
    JButton bouton1;
    JButton bouton2;
    JButton bouton3;
    JButton quitter;
    
    Font police;
    Font police2;
    String res;
    String res1;
    JMenu menu;
    JMenuBar menubar;
    JMenuItem regle;
    JMenuItem autre;
    JTextField chpsTexte;
    //RAJOUTER date et heure
    JLabel horloge;
    ImageIcon icon;
    
    public FenetreNiveau(){
        
        //Définition de la fenetre
        super("Bienvenue - The Memory");
        setSize(415,465);
		setLocation(100,200);
		setResizable(false);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //définition de la police
        police = new Font(" Arial " , Font.BOLD , 16);
        police2 = new Font(" Arial " , Font.BOLD , 13);
        
        //Initialisation du niveau à 0
        niveau = 0;

        //conteneur principal - se place au centre
        JPanel monConteneur = new JPanel();
        monConteneur.setLayout(null);
        
        
        //Fond d'écran - image        
        icon = new ImageIcon("./Logo.png");
        JLabel fond = new JLabel();
        Image imageZoom = scaleImage(icon.getImage(), 400,400);
        fond.setIcon (new ImageIcon(imageZoom));
        fond.setBounds(0,0,400,400);
        monConteneur.add(fond);
        
        //Boutons de choix niveau
        bouton1 = new JButton("Niveau 1");
        bouton1.setFont(police);
        bouton1.setBounds(25,125,100,50);
        bouton1.addActionListener(this);
        
        bouton2 = new JButton("Niveau 2");
        bouton2.setFont(police);
        bouton2.setBounds(150,125,100,50);
        bouton2.addActionListener(this);
        
        bouton3 = new JButton("Niveau 3");
        bouton3.setBounds(275,125,100,50);
        bouton3.setFont(police);
        bouton3.addActionListener(this);
        
		//Bouton quitter
        quitter = new JButton("Quitter");
        quitter.setBounds(300,350,100,50);
        quitter.setFont(police);
        quitter.setForeground(Color.RED);
        quitter.addActionListener(this);
        
        
        //Champ texte avec étiquette
        chpsTexte = new JTextField();
        chpsTexte.setFont(police);
        chpsTexte.setBounds(275,225,50,50);
        
        //Etiquette info
        JLabel chps = new JLabel("Vous avez choisit le niveau :");
        chps.setBounds(25,225,200,50);
        chps.setFont(police2);
        
        //Création du menu
        menu = new JMenu("Menu");
        menu.setFont(police);
        menubar = new JMenuBar();
        
        //Items du menus - et leurs caractéristiques
        regle = new JMenuItem("Règles du jeu");
        regle.addActionListener(this);
        regle.setFont(police);
        
        autre = new JMenuItem("Autres");
        autre.addActionListener(this);
        autre.setFont(police);
        
        menu.add(regle);
        menu.add(autre);
        menubar.add(menu);
        
        setJMenuBar(menubar);
        
        
        //Ajout des éléments
        
        monConteneur.add(bouton1);
        monConteneur.add(bouton2);
        monConteneur.add(bouton3);
        monConteneur.add(quitter);
        monConteneur.add(chpsTexte);
        monConteneur.add(chps);
        
		add(monConteneur);
       
        setVisible(true);
        
        
        //Texte de présentation du menu
        res = "Ce jeu est un memory. \nL'ordinateur choisit un nombre entre 50 et 100.\nVotre but est de retrouver toutes les paires dont la somme fait le nombre choisit !";
        res += "\nCe jeu vous entraine donc à la fois votre mémoire et développe aussi votre capacité de calcul mental :)";
        res1= "- Jeu réalisé par Agathe Vincent, Harry Kalfon et Noa Portier \n-2022 - Projet Informatique - Insa LYON -";
        
        //pour changer la couleur des joption
		// UIManager.put("OptionPane.background",new ColorUIResource(54,66,230));
        //UIManager.put("Panel.background",new ColorUIResource(54,66,230));
        
        
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		horloge = new JLabel(format.format(date));
		horloge.setBounds(0,0, 200, 100);
        monConteneur.add(horloge);
        
    }
    
    
    public void actionPerformed (ActionEvent e){

       
       if (e.getSource() == bouton1){
            niveau=1;
            chpsTexte.setText("1");

        }else if (e.getSource()== bouton2){
            niveau = 2;
            chpsTexte.setText("2");

        }else{
            niveau = 3;
            chpsTexte.setText("3");
        }
        
        if (e.getSource()==regle){
            JOptionPane.showMessageDialog(this,res,"Règles du Jeu",1,null); 
        }else if(e.getSource()==autre){
            JOptionPane.showMessageDialog(this,res1,"Informations",1,null);
        }
        
        if(e.getSource()==quitter){
            System.exit(0);
        }
    }
    
    public static Image scaleImage(Image source, int width, int height) {
	    return source.getScaledInstance(width, height, java.awt.Image.SCALE_AREA_AVERAGING);
    }
}
