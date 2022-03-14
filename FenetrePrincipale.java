import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList; 

public class FenetrePrincipale extends JFrame implements ActionListener{
	
	public FenetrePrincipale (plateau p){
		
		this.setTitle("THE MEMORY");
		this.setSize(800,800);
		
		// Pour placer la fenêtre au centre de l'écran
		this.setLocationRelativeTo(null);
		
		// Pour empêcher le redimensionnement de la fenêtre
		this.setResizable(false);
		
		// Pour permettre la fermeture de la fenêtre lors de l'appui sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Panneau du fond
		JPanel fond = new JPanel();
		fond.setBounds(0,0,800,800);
		fond.setBackground(Color.green);
		this.add(fond);
		
		
		
		this.setVisible(true);
	}	
	
	public void actionPerformed (ActionEvent e){
		
		
	}	
}
