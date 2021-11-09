package project;
import java.awt.*;
import javax.swing.*;

public class project extends JFrame{
	public project(){
		setTitle("Blue Label ¸¸µé±â");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		BlueLabel blue = new BlueLabel("Hello");
		blue.setBackground(Color.white);
		blue.setForeground(Color.yellow);
		blue.setFont(new Font("Arial",Font.PLAIN,10));
		blue.setOpaque(true);
		c.add(blue);
		
		BlueLabel big = new BlueLabel("Big Hello");
		big.setBackground(Color.black);
		big.setForeground(Color.magenta);
		big.setFont(new Font("Arial",Font.ITALIC,50));
		big.setOpaque(true);
		c.add(big);
		
		setSize(400, 200);
		setVisible(true);
	}
	class BlueLabel extends JLabel{
		public BlueLabel(String s) {
			super(s);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.BLUE);
		}
	}
	public static void main(String[] args) {
		new project();
	}
}