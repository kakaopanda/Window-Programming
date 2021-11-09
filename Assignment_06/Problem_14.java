package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame{
	int[] angle = new int[4];
	int[] n = new int[4];
	JLabel label[] = new JLabel[4];
	JTextField text[] = new JTextField[4];
	String[] fruits = {"apple ","cherry ","strawberry ","prune "};
	Color[] colors = {Color.red, Color.blue, Color.magenta, Color.orange};
	FirstPanel fp = new FirstPanel();
	SecondPanel sp = new SecondPanel();
	public project(){
		setTitle("파이 차트 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(fp,BorderLayout.NORTH);
		c.add(sp,BorderLayout.CENTER);
		setSize(500, 350);
		setVisible(true);
	}
	
	class FirstPanel extends JPanel{
		public FirstPanel() {
			for(int i=0; i<fruits.length; i++) {
				text[i] = new JTextField(5);
				text[i].addActionListener(new MyActionListener());
				add(new JLabel(fruits[i]));
				add(text[i]);
			}
			setBackground(Color.lightGray);
		}
	}
	
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int sum = 0;
			for(int i=0; i<fruits.length; i++) {
				n[i] = Integer.parseInt(text[i].getText());
				sum += n[i];
			}
			for(int i=0; i<fruits.length; i++) {
				angle[i] = (int)Math.round(((double)n[i]/sum)*360);
			}
			repaint();
		}	
	}
	
	class SecondPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int k = 0;
			for(int i=0; i<fruits.length; i++) {
				g.setColor(colors[i]);
				g.drawString(fruits[i]+" "+Math.round(((double)angle[i]/360)*100)+"%",50+i*100,20);
			}
			for(int i=0; i<fruits.length; i++) {
				g.setColor(colors[i]);
				g.fillArc(150, 50, 200, 200, k, angle[i]);
				k += angle[i];
			}
		}
	}
	
	public static void main(String[] args) {
		new project();
	}
}