package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame implements Runnable{
	private int x = 200;
	public void run() {
		while(true) {
			if(x==200)
				x += 10;
			else
				x -= 10;
			this.setLocation(x, x);
		}
	}
	
	public project() {
		setTitle("진동하는 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread th = new Thread(this);
		setSize(400,400);
		setVisible(true);
		th.start();
	}
	
	public static void main(String[] args) {
		new project();
	}
}