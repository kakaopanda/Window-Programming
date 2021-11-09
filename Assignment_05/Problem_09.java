package project;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;
import javax.swing.*;

public class project extends JFrame {
	private JLabel label = new JLabel();
	private JRadioButton left = new JRadioButton("left");
	private JRadioButton right = new JRadioButton("right");
	private Vector<ImageIcon> vector = new Vector<ImageIcon>();
	private Radio radio = new Radio();
	
	project(){
		setTitle("Image Gallery Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(radio,BorderLayout.NORTH);
		c.add(label,BorderLayout.CENTER);
		
		File file = new File("images");
		File[] files = file.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				ImageIcon icon = new ImageIcon(f.getPath());
				vector.add(icon);
			}
		}	
		label.setIcon(vector.get(0));
		label.addMouseListener(new MyMouseListener(0));
		setSize(400,400);
		setVisible(true);
		}
	
	class MyMouseListener extends MouseAdapter{
		private int index;
		public MyMouseListener(int start) {
			index = start;
		}
		public void mouseReleased(MouseEvent e) {
			if(radio.isLeft()) {
				index++;
				index = index % vector.size();
				label.setIcon(vector.get(index));
			}
			else {
				index--;
				if(index == -1)
					index = vector.size()-1;
				label.setIcon(vector.get(index));
			}
		}
	}
	
	class Radio extends JPanel{
		public Radio() {
			ButtonGroup g = new ButtonGroup();
			g.add(left);
			g.add(right);
			add(left);
			add(right);
			left.setSelected(true);
		}
		public boolean isLeft() {
			return left.isSelected();
		}
	}
	
	public static void main(String[] args) {
		new project();
	}
}