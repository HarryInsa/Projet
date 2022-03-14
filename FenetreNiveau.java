//Bilbiothèque
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

public class FenetreNiveau extends JFrame {
    
    JButton bouton1;
    JButton bouton2;
    JButton bouton3;
    
    public FenetreNiveau(){
        super("ChoixNiveau");
        setSize(400,400);
		setLocation(100,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //instanciation boutons
        bouton1 = new JButton("Niveau 1");
        bouton1.setBounds(0,10,80,40);
        bouton2 = new JButton("Niveau 2");
        bouton2.setBounds(90,10,80,40);
        bouton3 = new JButton("Niveau 3");
        bouton3.setBounds(180,10,80,40);
        
        //rangement
        JPanel monConteneur = new JPanel();
        monConteneur.setLayout(null);
        monConteneur.add(bouton1);
		monConteneur.add(bouton2);
		monConteneur.add(bouton3);
		monConteneur.setBounds(100,200,160,40);
		add(monConteneur);
        
        setVisible(true);
      	
    }
}
