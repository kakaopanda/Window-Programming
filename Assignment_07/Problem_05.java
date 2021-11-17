package project;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

class MyThread extends Thread{
	MyPanel panel;
	Vector<Point> v;
	
	public MyThread(MyPanel panel, Vector<Point> v) {
		this.panel = panel;
		this.v = v;
	}
	public void changeLocation() {
		for(int i=0; i<v.size(); i++) {
			v.get(i).y += 3;
			if(v.get(i).y > 500)
				v.get(i).y = 0;
		}
	}
	public void run() {
		while(true) {
			try {
				sleep(300);
			}catch(InterruptedException e) {
				return;
			}
			changeLocation();
			panel.repaint();
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

class MyPanel extends JPanel{
	ImageIcon icon = new ImageIcon("images/snow.png");
	Image img = icon.getImage();
	Vector<Point> v;
	
	public MyPanel(Vector<Point> v) {
		this.v = v;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,0,0,getWidth(),getHeight(),this);
		g.setColor(Color.white);
		for(int i=0; i<v.size(); i++) {
			Point p = v.get(i);
			g.fillOval(p.x, p.y, 15, 15);
		}
	}
}

public class project extends JFrame{
	Vector<Point> v = new Vector<Point>();
	MyPanel panel = new MyPanel(v);
	
	public project() {
		int x,y;
		setTitle("´« ³»¸®´Â »þ°¥ÀÇ ¸¶À»");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i=0; i<50; i++) {
			x = (int)(Math.random()*500);
			y = (int)(Math.random()*500);
			v.add(new Point(x,y));
		}
		setContentPane(panel);
		MyThread th = new MyThread(panel,v);
		th.start();
		
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new project();
	}
}