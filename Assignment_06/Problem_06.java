package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame{
	private ImageIcon image = new ImageIcon("images/apple.jpg");
	private Image img = image.getImage();
	private MyPanel panel = new MyPanel();
	
	public project(){
		setTitle("이미지 레이블 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(400, 400);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		private int x = 0, y = 0;
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,x,y,getWidth()/4,getHeight()/4,this);
			addMouseMotionListener(new MouseAdapter() {
				public void mouseDragged(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					repaint();
				}
			});
		}
	}
	public static void main(String[] args) {
		new project();
	}
}