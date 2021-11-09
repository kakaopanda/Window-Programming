package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame{
	private ImageIcon image = new ImageIcon("images/apple.jpg");
	private Image img = image.getImage();
	private JLabel label = new JLabel(image);
	
	public project(){
		setTitle("이미지 레이블 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		label.setSize(image.getIconWidth(),image.getIconHeight());
		c.add(label);
		c.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Component c = (Component)e.getSource();
				c.setLocation(e.getX(),e.getY());
			}
		});
		setSize(400, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new project();
	}
}