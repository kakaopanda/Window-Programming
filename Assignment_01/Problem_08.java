package project;

import java.awt.*;
import javax.swing.*;

public class project extends JFrame {
	project(){
	setTitle("여러 개의 패널을 가진 프레임");
    	setSize(300,300);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); 	
    	Container c = getContentPane();
    	
    	JPanel x = new JPanel();
    	JPanel y = new JPanel();
    	JPanel z = new JPanel();
    	
    	x.setBackground(Color.LIGHT_GRAY);
    	y.setLayout(null);
    	z.setBackground(Color.GREEN);
    	
    	c.add(x,BorderLayout.NORTH);
    	c.add(y,BorderLayout.CENTER);
    	c.add(z,BorderLayout.SOUTH);
    	
    	JButton x_open = new JButton("열기");
    	JButton x_close = new JButton("닫기");
    	JButton x_exit = new JButton("나가기");
    	x.add(x_open);
    	x.add(x_close);
    	x.add(x_exit);
    	
    	for(int i=0; i<10; i++) {
    		JLabel label = new JLabel("*");
    		int location_x = (int)(Math.random()*200)+50;
    		int location_y = (int)(Math.random()*200)+50;
    		label.setLocation(location_x, location_y);
    		label.setSize(10,10);
    		label.setOpaque(true);
    		y.add(label);
    	}
    	
    	JButton z_input = new JButton("Word Input");
    	JTextField z_text = new JTextField(15);
    	z.add(z_input);
      	z.add(z_text);
    	
    	setVisible(true);
	}
    public static void main(String args[]) {
    	project p = new project();
    }
}