//Bilbiothèque
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

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
    JLabel chps;
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
        conteneur2.setBounds(0,0,400,400);
        
        JPanel conteneur3 = new JPanel();//de l'étiquette et du jtexte
        conteneur3.setLayout(null);
        conteneur3.setBounds(0,115,400,100);
        
        JPanel conteneur4 = new JPanel();//bouton quitter
        conteneur4.setLayout(null);
        conteneur4.setBounds(310,300,90,50);
        
        //Fond d'écran -  MARCHE PASSSSS
        //JLabel fond = new JLabel(new ImageIcon("/Documents/IMG_0242.JPG"));
        JLabel fond = new JLabel();
        fond.setIcon (new ImageIcon("/IMG_0242.JPG"));
        fond.setBounds(0,0,200,50);
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
        
        //Vous aussi ca met du temps à s'afficher pout celui la ??? 
        quitter = new JButton("Quitter");
        quitter.setBounds(0,0,80,50);
        quitter.setFont(police);
        quitter.setForeground(Color.RED);
        quitter.addActionListener(this);
        conteneur4.add(quitter);
        
        //Champ texte avec étiquette - VOUS AUSSI PAS D ETOIQUETTE ???
        chpsTexte = new JTextField();
        chpsTexte.setFont(police);
        chpsTexte.setBounds(300,0,35,30);
        conteneur3.add(chpsTexte);
        
        chps = new JLabel(); // étiquette qui ne s'affiche pas
        chps.setBackground(Color.yellow);//juste pour vor ou il est
        chps.setFont(police);
        chps.setBounds(0,0,300,300);
        conteneur3.add(chps);
        
           
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
        monConteneur.add(conteneur4);
		add(monConteneur);
            
        setVisible(true);
        
        
        //Texte de présentation du menu
        res = "Ce jeu est un memory. \nL'ordinateur choisit un nombre entre ?? et ??.\nVotre but est de retrouver toutes les paires dont la somme fait le nombre choisit !";
        res += "\nCe jeu vous entraine donc à la fois votre mémoire et développe aussi votre capacité de calcul mental :)";
        res1= "- Jeu réalisé par Agathe Vincent, Harry Kalfon et Noa Portier -\n2022 - Projet Informatique - Insa LYON";
        
        
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
            JOptionPane.showMessageDialog(this,res,"Règles du Jeu",1);
        }else if(e.getSource()==e2){
            JOptionPane.showMessageDialog(this,res1,"Informations",1);
        }
        
        if(e.getSource()==quitter){
            System.exit(0);
        }
    }
}
