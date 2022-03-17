//Bilbiothèque
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class FenetreNiveau extends JFrame implements ActionListener{
    
    int niveau=0;
    JButton bouton1;
    JButton bouton2;
    JButton bouton3;
    JButton quitter;
    
    Font police = new Font(" Arial ",Font.BOLD,12);
    //Faire attention mettre la bonne police partout NORMALMENT C4EST BON, on peut la midifier la c'est en gras
    String res;
    String res1;
    JMenu menu;
    JMenuBar menubar;
    JMenuItem e1;
    JMenuItem e2;
    JTextField chpsTexte;
    //RAJOUTER date et heure
    
    
    public FenetreNiveau(){
        
        super("Bienvenue - The Memory");
        setSize(400,400);
		setLocation(100,200);
		setResizable(false);
		this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
        //conteneur principal - se place au centre
        JPanel monConteneur = new JPanel();
        monConteneur.setLayout(null);
        
        //autres conteneurs
        JPanel conteneur1 = new JPanel();// pour les boutons
        conteneur1.setLayout(null);
        conteneur1.setBounds(65,70,260,40);
        
        JPanel conteneur2 = new JPanel();//du fond d'ecran
        conteneur2.setLayout(null);
        conteneur2.setBounds(0,0,0,0);
        
        JPanel conteneur3 = new JPanel();//jtexte
        conteneur3.setLayout(null);
        conteneur3.setBounds(250,118,50,45);
        
        JPanel conteneur4 = new JPanel();//bouton quitter
        conteneur4.setLayout(null);
        conteneur4.setBounds(310,300,80,50);
        
        JPanel conteneur5 = new JPanel();//étiquette
        conteneur5.setLayout(null);
        conteneur5.setBounds(5,110,400,50);
        
        JPanel conteneur6 = new JPanel();//logo
        conteneur6.setLayout(null);
        conteneur6.setBounds(182,10,60,60);
        
        
        //Fond d'écran -  MARCHE PASSSSS
        //JLabel fond = new JLabel(new ImageIcon("/Documents/IMG_0242.JPG"));
        JLabel fond = new JLabel();
        //fond.setIcon (new ImageIcon("/IMG_0242.JPG"));
        fond.setBounds(0,0,0,0);
        conteneur2.add(fond);
        
        //Boutons - les replacer????
        bouton1 = new JButton("Niveau 1");
        bouton1.setFont(police);
        bouton1.setBounds(0,0,80,40);
        bouton1.addActionListener(this);
        
        bouton2 = new JButton("Niveau 2");
        bouton2.setFont(police);
        bouton2.setBounds(90,0,80,40);
        bouton2.addActionListener(this);
        
        bouton3 = new JButton("Niveau 3");
        bouton3.setBounds(180,0,80,40);
        bouton3.setFont(police);
        bouton3.addActionListener(this);
        
        conteneur1.add(bouton1);
		conteneur1.add(bouton2);
		conteneur1.add(bouton3);
        
        //Vous aussi ca met du temps à s'afficher pout celui la ??? c'est bon
        quitter = new JButton("Quitter");
        quitter.setBounds(0,0,80,50);
        quitter.setFont(police);
        quitter.setForeground(Color.RED);
        quitter.addActionListener(this);
        conteneur4.add(quitter);
        monConteneur.add(conteneur4);
        
        //Champ texte avec étiquette - VOUS AUSSI PAS D ETIQUETTE ???
        chpsTexte = new JTextField();
        chpsTexte.setFont(police);
        chpsTexte.setBounds(0,0,50,40); 
        conteneur3.add(chpsTexte);
        
        JLabel chps = new JLabel("Vous avez choisit le niveau :"); // étiquette qui ne s'affiche pas
        chps.setBounds(65,6,200,40);
        chps.setFont(police);
        conteneur5.add(chps);
        monConteneur.add(conteneur5);
        
        JLabel monEtiquette2 ; //logo
        monEtiquette2 = new JLabel("logo ici");
        monEtiquette2.setIcon(new ImageIcon("./Logo.png"));
        monEtiquette2.setBounds(0,0,120,50);
        //monEtiquette2 = new JLabel(new ImageIcon("./Documents/Logo.png"));
        conteneur6.add(monEtiquette2);
        monConteneur.add(conteneur6);
        
        //Création du menu
        menu = new JMenu("Menu");
        menu.setFont(police);
        menubar = new JMenuBar();
        //Items du menus - et leurs caractéristiques
        e1 = new JMenuItem("Règles du jeu");
        e1.addActionListener(this);
        e2 = new JMenuItem("Autres");
        e2.addActionListener(this);
        e1.setFont(police);
        e2.setFont(police);
        menu.add(e1); 
        menu.add(e2); 
        menubar.add(menu);
        setJMenuBar(menubar);
        
        //Ajout des conteneurs au conteneur général
		monConteneur.add(conteneur1);
        monConteneur.add(conteneur2);
        monConteneur.add(conteneur3);
		add(monConteneur);
            
        setVisible(true);
        
        
        //Texte de présentation du menu
        res = "Ce jeu est un memory. \nL'ordinateur choisit un nombre entre ?? et ??.\nVotre but est de retrouver toutes les paires dont la somme fait le nombre choisit !";
        res += "\nCe jeu vous entraine donc à la fois votre mémoire et développe aussi votre capacité de calcul mental :)";
        res1= "- Jeu réalisé par Agathe Vincent, Harry Kalfon et Noa Portier -\n2022 - Projet Informatique - Insa LYON";
        
        //pour changer la couleur des joption
       // UIManager.put("OptionPane.background",new ColorUIResource(54,66,230));
        //UIManager.put("Panel.background",new ColorUIResource(54,66,230));
        
        //Actions
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
        
        if (e.getSource()==e1){
            JOptionPane.showMessageDialog(this,res,"Règles du Jeu",1,null); 
        }else if(e.getSource()==e2){
            JOptionPane.showMessageDialog(this,res1,"Informations",1,null);
        }
        
        if(e.getSource()==quitter){
            System.exit(0);
        }
    }
}

