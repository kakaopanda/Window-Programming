package project;

import java.awt.*;
import javax.swing.*;

public class project extends JFrame {
	project(){
	setTitle("���� ������");
    	setSize(300,300);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); 	
    	Container c = getContentPane();
    	
    	JPanel x = new JPanel();
    	JPanel y = new JPanel();
    	JPanel z = new JPanel();
    	
    	x.setBackground(Color.LIGHT_GRAY);
    	y.setLayout(new GridLayout(4,4));
    	z.setBackground(Color.GREEN);

    	c.add(x,BorderLayout.NORTH);
    	c.add(y,BorderLayout.CENTER);
    	c.add(z,BorderLayout.SOUTH);
    	
    	JLabel x_label = new JLabel("�����Է�");
    	JTextField x_text = new JTextField(20);
    	x.add(x_label);
    	x.add(x_text);
    	for(int i=0; i<16; i++) {
    		JButton button = new JButton();
    		String[] cal = {"CE","���","+","-","x","/"};
    		if(i<10)
    			button.setText(Integer.toString(i));
    		else
    			button.setText(cal[i-10]);
    		if(i>11)
    			button.setBackground(Color.cyan);
    		y.add(button);
    	}
    	JLabel z_label = new JLabel("�����");
    	JTextField z_text = new JTextField(20);
    	z.add(z_label);
    	z.add(z_text);
    	
    	setVisible(true);
	}
    public static void main(String args[]) {
    	project p = new project();
    }
}