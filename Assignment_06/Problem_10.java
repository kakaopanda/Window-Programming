package project;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class project extends JFrame{
	private MyPanel panel = new MyPanel();
	Vector<Integer> vector_x = new Vector<Integer>();
	Vector<Integer> vector_y = new Vector<Integer>();
	
	public project(){
		setTitle("마우스로 폐다각형 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(400, 400);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					vector_x.add(e.getX());
					vector_y.add(e.getY());
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int[] x = new int[vector_x.size()];
			int[] y = new int[vector_y.size()];
			for(int i=0; i<vector_x.size(); i++) {
				x[i] = vector_x.get(i);
				y[i] = vector_y.get(i);
			}
			g.drawPolygon(x,y,vector_x.size());
		}
	}
	public static void main(String[] args) {
		new project();
	}
}