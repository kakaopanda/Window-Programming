package project;
import java.awt.*;
import javax.swing.*;

public class project extends JFrame{
	private MyPanel panel = new MyPanel();
	public project(){
		setTitle("그래픽 이미지 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(400, 400);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images/back.jpg");
		private Image img = icon.getImage();	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int w = this.getWidth();
			int h = this.getHeight();
			g.drawImage(img, 0, 0, w/2-5, h/2-5, 0, 0, w/2, h/2, this);
			g.drawImage(img, w/2+5, 0, w, h/2-5, w/2, 0, w, h/2, this);
			g.drawImage(img, 0, h/2+5, w/2-5, h, 0, h/2, w/2, h, this);
			g.drawImage(img, w/2+5, h/2+5, w, h, w/2, h/2, w, h, this);
		}
	}
	public static void main(String[] args) {
		new project();
	}
}