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
    public String res, res1;
    public JMenu menu;
    public JMenuBar menubar;
    public JMenuItem regle, autre;
    public JLabel horloge;
    public JButton continuer, son;
    public boolean click = false, sonOn;
    public FenetreNiveau fenetreniveau;
    public ImageIcon icon, iconSonOn, iconSonOff;
    public Image imageSonOn, imageSonOff;
    public Sound SonDebut;
	
	public FenetreAccueil (boolean sonOn){
        
        this.sonOn = sonOn;
        this.SonDebut = new Sound("generique.wav");
        SonDebut.jouer();
        this.pack();
        
		//Définition de la fenetre
        this.setTitle("Bienvenue - The Memory");
        this.setSize(415,465);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(FenetreAccueil.class.getResource("M.png")).getImage());
        
        //définition des polices d'écriture
        police = new Font("Cambria" , Font.PLAIN , 14);
        
        //conteneur principal - se place au centre
        JPanel monConteneur = new JPanel();
        monConteneur.setLayout(null);
        
        //Bouton son
		iconSonOn = new ImageIcon("./SonOn.png");
        imageSonOn = scaleImage(iconSonOn.getImage(), 30, 30);
        
        iconSonOff = new ImageIcon("./SonOff.png");
        imageSonOff = scaleImage(iconSonOff.getImage(), 30, 30);
        
        son = new JButton();
        son.setBounds(370,0, 30, 30);
        son.setBackground(Color.WHITE);
        
        if(sonOn){
			son.setIcon(new ImageIcon(imageSonOn));
        }else{
			son.setIcon(new ImageIcon(imageSonOff));
		}	
        
        son.addActionListener(this);
        monConteneur.add(son);
        
        //Bouton démarrer
        continuer = new JButton("Démarrer");
        continuer.setBounds (150, 350, 100, 50);
        continuer.setForeground(new Color(253, 212, 65));
        continuer.setFont(police);
        monConteneur.add(continuer);
        continuer.addActionListener(this);
        
        //Fond d'écran - image        
        icon = new ImageIcon("./ImageAccueil.gif");
        JLabel fond = new JLabel(icon,JLabel.CENTER);
        fond.setSize(415,465);
        monConteneur.add(fond);
        
        add(monConteneur);
        this.setVisible(true);
        
	}	
	
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == continuer){
			fenetreniveau = new FenetreNiveau(sonOn);
			SonDebut.arreter();
			click = true;
			this.dispose();
		}
		
		if(e.getSource() == son){
			sonOnOff();
		}	
	}	
	
	public static Image scaleImage(Image source, int width, int height) {
	    return source.getScaledInstance(width, height, java.awt.Image.SCALE_AREA_AVERAGING);
    }
	
	//Arreter ou remmetre la musique
	public void sonOnOff (){
		if(sonOn){
			SonDebut.arreter();
			son.setIcon(new ImageIcon(imageSonOff));
			this.sonOn = false;
		}else{
			this.sonOn = true;
			SonDebut.jouer();
			son.setIcon(new ImageIcon(imageSonOn));
		}		
	}	
}	
