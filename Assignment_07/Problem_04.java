package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame{
	private JLabel label[] = new JLabel[100];
	private MyThread bubble[] = new MyThread[100];
	private int i = 0;
	ImageIcon icon = new ImageIcon("images/bubble.jpg");	
	public project() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		setSize(500,500);
		setVisible(true);
		for(int i=0; i<100; i++) {
			label[i] = new JLabel();
			label[i].setIcon(icon);
			label[i].setSize(50,50);
		}	
		c.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				bubble[i] = new MyThread(c,label[i],e.getX(),e.getY());
				bubble[i++].start();
			}
		});
	}	
	public static void main(String[] args) {
		new project();
	}
}

class MyThread extends Thread{
	private JLabel label;
	private Container c;
	private int x,y;
	public MyThread(Container c, JLabel label, int x, int y) {
		this.label = label;
		this.c = c;
		this.x = x;
		this.y = y;
	}
	public void run() {
		label.setLocation(x,y);
		c.add(label);
		while(true) {
			try {
				if(y>-50) {
					y -= 5;
					label.setLocation(x,y);
					sleep(20);
				}
				else if(y<=-50) {
					c.remove(label);
					c.repaint();
				}
			}catch(InterruptedException e) {
				return;
			}
		}
	}
}