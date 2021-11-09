package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public project(){
		setTitle("그래픽 다각형 연습");
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
			int[] pos_x = {0, w/2, w, w/2};
			int[] pos_y = {h/2, 0, h/2, h};
			for(int i=1; i<10; i++) {
				g.drawPolygon(pos_x,pos_y,4);
				pos_x[0] += 10;
				pos_x[2] -= 10;
				pos_y[1] += 10;
				pos_y[3] -= 10;
			}
		}
	}
	public static void main(String[] args) {
		new project();
	}
}