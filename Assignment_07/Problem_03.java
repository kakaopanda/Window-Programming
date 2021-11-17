package project;
import java.awt.*;
import javax.swing.*;

public class project extends JFrame{
	public project() {
		setTitle("진동하는 레이블 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		JLabel label = new JLabel("진동 레이블");
		label.setFont(new Font("바탕",Font.PLAIN,20));
		label.setSize(200,100);
		label.setLocation(100, 100);
		c.add(label);
		MyThread th = new MyThread(label);
		setSize(400,400);
		setVisible(true);
		th.start();
	}
	
	public static void main(String[] args) {
		new project();
	}
}

class MyThread extends Thread{
	private JLabel label;
	private int x = 100;
	public MyThread(JLabel l) {
		label = l;
	}
	public void run() {
		while(true) {
			if(x==100)
				x += 5;
			else
				x -= 5;
			label.setLocation(x, x);
		}
	}
	
}