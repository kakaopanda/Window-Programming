package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame{
	private ImageIcon image = new ImageIcon("images/apple.jpg");
	private Image img = image.getImage();
	private MyPanel panel = new MyPanel();
	private int width = img.getWidth(this);
	private int height = img.getHeight(this);
	
	public project(){
		setTitle("그래픽 이미지 확대 축소 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(400, 400);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public MyPanel() {
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar()=='+') {
						width *= 1.1;
						height *= 1.1;
						repaint();
					}
					else if(e.getKeyChar()=='-') {
						width *= 0.9;
						height *= 0.9;
						repaint();
					}
				}
			});
			setFocusable(true);
			requestFocus();
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,10,10,width,height,this);
		}
	}
	public static void main(String[] args) {
		new project();
	}
}