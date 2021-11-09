package project;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class project extends JFrame{
	private MyPanel panel = new MyPanel();
	private Vector<Point> v = new Vector<Point>();
	private int x,y;
	public project(){
		setTitle("Free Drawing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBorder(BorderFactory.createTitledBorder("Free Drawing Area"));
		setContentPane(panel);
		setSize(500, 500);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public MyPanel() {
			setLayout(null);
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e1) {
					x = e1.getX();
					y = e1.getY();
					v.add(null);
					v.add(new Point(x,y));
					repaint();
				}
				public void mouseReleased(MouseEvent e2) {
					x = e2.getX();
					y = e2.getY();
					v.add(new Point(x,y));
					repaint();
				}
			});
			addMouseMotionListener(new MouseAdapter() {
				public void mouseDragged(MouseEvent e3) {
					x = e3.getX();
					y = e3.getY();
					v.add(new Point(x,y));
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i=1; i<v.size(); i++) {
				if(v.get(i-1)==null)
					continue;
				else if(v.get(i)==null)
					continue;
				else
					g.drawLine(v.get(i-1).x,v.get(i-1).y,v.get(i).x,v.get(i).y);
			}
		}
	}
	
class Point{
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public static void main(String[] args) {
	new project();
}
}