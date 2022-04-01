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
        
        this.pack();
        
		//Définition de la fenetre
        this.setTitle("Bienvenue - The Memory");
        this.setSize(415,465);
		this.setLocationRelativeTo(null);
		//this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //définition des polices d'écriture
        police = new Font(" Arial " , Font.PLAIN , 16);
        police2 = new Font(" Arial " , Font.PLAIN , 14);
        police3 =new Font("Comic Sans", Font.ITALIC, 14);
        
        //conteneur principal - se place au centre
        JPanel monConteneur = new JPanel();
        monConteneur.setLayout(null);
        
        
        //Bouton démarrer
        continuer = new JButton("Démarrer");
        continuer.setBounds (150, 350, 100, 50);
        continuer.setForeground(Color.BLUE);
        continuer.setFont(police2);
        monConteneur.add(continuer);
        continuer.addActionListener(this);
        
        //Fond d'écran - image        
        icon = new ImageIcon("./debut.gif");
        JLabel fond = new JLabel(icon,JLabel.CENTER);
        //fond.setIcon (icon);
       //fond.setLocation(0,0);
        fond.setSize(415,465);
        monConteneur.add(fond);
        
        
        add(monConteneur);
        this.setVisible(true);
        
	}	
	
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == continuer){
			fenetreniveau = new FenetreNiveau();
			click = true;
			this.dispose();
		}	
	}	
	
}	
