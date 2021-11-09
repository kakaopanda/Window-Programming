package project;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class project extends JFrame{
	private MyPanel panel = new MyPanel();
	private Vector<Circle> v = new Vector<Circle>();
	private int x1,x2,y1,y2;
	public project(){
		setTitle("마우스로 원 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(1000, 400);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public MyPanel() {
			setLayout(null);
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					x1 = e.getX();
					y1 = e.getY();
				}
				public void mouseReleased(MouseEvent k) {
					x2 = k.getX();
					y2 = k.getY();
					v.add(new Circle(x1,y1,Math.abs(x1-x2),Math.abs(y1-y2)));
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i=0; i<v.size(); i++) {
				g.setColor(Color.magenta);
				Circle c = v.get(i);
				g.drawOval(c.x,c.y,c.w,c.h);
			}
		}
	}
	class Circle{
		int x,y,w,h;
		public Circle(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
	}
	public static void main(String[] args) {
		new project();
	}
}