//Bilbiothèque
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

public class FenetreNiveau extends JFrame implements ActionListener {
    
    int niveau=0;
    JButton bouton1;
    JButton bouton2;
    JButton bouton3;
    //Image sky;
    
    public FenetreNiveau(){
        
        super("Menu");
        setSize(400,400);
		setLocation(100,200);
		
		// Pour placer la fenêtre au centre de l'écran
		this.setLocationRelativeTo(null);
		
        //sky = Toolkit.getDefaultToolkit().getImage("IMG_0242.JPG");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        JPanel monConteneur = new JPanel();
        monConteneur.setBounds(0,0,400,400);
        monConteneur.setLayout(null);
        
        //instanciation boutons
        bouton1 = new JButton("Niveau 1");
        bouton1.setBounds(65,130,80,40);
        bouton1.addActionListener(this);
        
        bouton2 = new JButton("Niveau 2");
        bouton2.setBounds(155,130,80,40);
        bouton2.addActionListener(this);
        
        bouton3 = new JButton("Niveau 3");
        bouton3.setBounds(245,130,80,40);
        bouton3.addActionListener(this);
        
        //mettre un champ texte
                
        //rangement et voir pourquoi contenuer général marche pas
        
        monConteneur.add(bouton1);
		monConteneur.add(bouton2);
		monConteneur.add(bouton3);
		
		add(monConteneur);
        
 
        
        setVisible(true);
      	
    }
    public void actionPerformed (ActionEvent e){
       if (e.getSource() == bouton1){
            niveau=1;
            //System.exit(0) ;
        }else if (e.getSource()== bouton2){
            niveau = 2;
            //System.exit(0) ;
        }else{
            niveau = 3;
            //System.exit(0) ;
        }
    }
}
