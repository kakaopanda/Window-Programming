package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class project extends JFrame {
	project(){
	setTitle("Ten Color Buttons Frame");
    	setSize(800,400);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); 	
    	Container c = getContentPane();
    	c.setLayout(new GridLayout(1,10));
    	
    	for(int i=0; i<10; i++) {
    		Color[] color = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN,
Color.BLUE,Color.MAGENTA,Color.GRAY,Color.PINK,Color.LIGHT_GRAY};
    		JButton button = new JButton(Integer.toString(i));
    		button.setBackground(color[i]);
    		c.add(button);
    	}
    	setVisible(true);
	}
    public static void main(String args[]) {
    	project p = new project();
    }
}