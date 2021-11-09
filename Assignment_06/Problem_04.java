package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame{
	private MyPanel panel = new MyPanel();
	private ImageIcon image = new ImageIcon("images/back.jpg");
	private Image img = image.getImage();
	
	public project(){
		setTitle("이미지 위에 원 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setLayout(new FlowLayout());
		setSize(300, 300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private int x = 0, y = 0;
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			g.setColor(Color.green);
			g.fillOval(x, y, 20, 20);
			addMouseMotionListener(new MouseMotionAdapter() {
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