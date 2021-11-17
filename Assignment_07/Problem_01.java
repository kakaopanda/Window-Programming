package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame{
	MyPanel p = new MyPanel();
	public project() {
		setTitle("원을 0.4초 간격으로 그리는 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(p);
		p.setLayout(null);
		p.setOpaque(true);
		
		MyThread th = new MyThread(p);
		p.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				th.start();
			}
		});
		setSize(400,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new project();
	}
}

class MyThread extends Thread{
	private MyPanel p;
	public MyThread(MyPanel p) {
		this.p = p;
	}
	public void run() {
		while(true) {
			try {
				sleep(400);
				p.repaint();
			}catch(InterruptedException e) {
				return;
			}
		}
	}
}

class MyPanel extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.magenta);
		int x = (int)(Math.random()*400);
		int y = (int)(Math.random()*400);
		g.drawOval(x, y, 50, 50);
	}
}