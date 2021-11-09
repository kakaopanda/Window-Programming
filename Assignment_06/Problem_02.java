package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame{
	private MyPanel panel = new MyPanel();
	private JButton btn = new JButton("Hide/Show");
	private ImageIcon image = new ImageIcon("images/back.jpg");
	private Image img = image.getImage();
	private int count = 0;
	
	public project(){
		setTitle("이미지 그리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setLayout(new FlowLayout());
		add(btn);
		setSize(300, 300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	public static void main(String[] args) {
		new project();
	}
}