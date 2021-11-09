package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public project(){
		setTitle("격자 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(400, 400);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int w = getWidth();
			int h = getHeight();
			for(int i=1; i<10; i++) {
				g.drawLine(0, (int)(h*i*0.1), w, (int)(h*i*0.1));
				g.drawLine((int)(w*i*0.1), 0, (int)(w*i*0.1), h);
			}
		}
	}
	public static void main(String[] args) {
		new project();
	}
}