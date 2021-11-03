package project;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;

public class project extends JFrame {
	project(){
	setTitle("Ten Color Buttons Frame");
    	setSize(800,400);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); 	
    	Container c = getContentPane();
    	c.setLayout(new GridLayout(1,10));
    	
    	for(int i=0; i<10; i++)
    		c.add(new JButton(Integer.toString(i)));
    	
    	setVisible(true);
	}
    public static void main(String args[]) {
    	project p = new project();
    }
}