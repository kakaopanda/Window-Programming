package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class project extends JFrame {
	project(){
	setTitle("4*4 Color Frame");
    	setSize(600,200);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); 	
    	Container c = getContentPane();
    	c.setLayout(new GridLayout(4,4));
    	
    	for(int i=0; i<16; i++) {
    		Color[] color = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN,
Color.BLUE,Color.MAGENTA,Color.GRAY,Color.PINK,Color.LIGHT_GRAY,Color.WHITE,Color.DARK_GRAY,Color.BLACK,Color.ORANGE,Color.BLUE,Color.MAGENTA};
    		JLabel label = new JLabel(Integer.toString(i));
    		label.setBackground(color[i]);
    		label.setOpaque(true);
    		c.add(label);
    	}
    	setVisible(true);
	}
    public static void main(String args[]) {
    	project p = new project();
    }
}