package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame{
	private MyPanel p = new MyPanel();
	private MyThread th = new MyThread(p);
	public project() {
		setTitle("Make Drawing to Start");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(p);
		p.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				th.play();
				th.flag = true;
			}
			public void mouseExited(MouseEvent e) {
				th.flag = false;
			}
		});
		setSize(400,400);
		setVisible(true);
		th.start();
	}
	public static void main(String[] args) {
		new project();
	}
}

class MyPanel extends JPanel{
	public void paintComponent(Graphics g) {
		int x = (int)(Math.random()*300);
		int y = (int)(Math.random()*300);
		int w = (int)(Math.random()*100)+5;
		int h = (int)(Math.random()*100)+5;
		g.setColor(Color.white);
		g.fillRect(0, 0, 400, 400);
		g.setColor(Color.MAGENTA);
		g.fillOval(x, y, w, h);	
	}
}

class MyThread extends Thread{
	public static boolean flag = false;
	MyPanel p;
	
	public MyThread(MyPanel p) {
		this.p = p;
	}
	synchronized public void play() {
		notify();
	}
	synchronized public void run() {
		while(true) {
			try {	
				if(flag == true) {
					p.repaint();
					sleep(300);}
				else if(flag==false) {
					wait();}
			}catch(InterruptedException e) {
				return;
			}
		}
	}
}