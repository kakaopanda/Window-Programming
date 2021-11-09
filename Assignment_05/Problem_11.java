package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame {
	private JLabel[] label = new JLabel[10];
	private int count = 0;
	project(){
		setTitle("Ten 레이블 클릭");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		setSize(300,300);
		setVisible(true);
		
		for(int i=0; i<label.length; i++) {
			label[i] = new JLabel(Integer.toString(i));
			label[i].setFont(new Font("Arial",Font.BOLD,15));
			label[i].setForeground(Color.magenta);
			
			label[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					JLabel label = (JLabel)e.getSource();
					if(Integer.parseInt(label.getText())==count) {
						count++;
						if(count==10) {
							count = 0;
							display();}
						else
							label.setVisible(false);}
				}
			}
			);
		}
		display();
		}
	
	public void display() {
		Container c = getContentPane();
		for(int i=0; i<label.length; i++) {
			label[i].setSize(15,15);
			int x = c.getWidth() - label[i].getWidth();
			int y = c.getHeight() - label[i].getHeight();
			int rand_x = (int)(Math.random()*x);
			int rand_y = (int)(Math.random()*y);
			label[i].setLocation(rand_x,rand_y);
			label[i].setVisible(true);
			c.add(label[i]);}
	}
	
	public static void main(String[] args) {
		new project();}
}