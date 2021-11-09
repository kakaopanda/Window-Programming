package project;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;
import javax.swing.*;

public class project extends JFrame {
	private JPanel select = new JPanel();
	private JPanel result = new JPanel();
	private JButton[] btn = new JButton[3];
	private JLabel me = new JLabel("me");
	private JLabel computer = new JLabel("com");
	private JLabel winner = new JLabel("Winner");
	private ImageIcon[] image = {new ImageIcon("images/1.png"),new ImageIcon("images/2.png"),new ImageIcon("images/3.png")};
	project(){
		setTitle("가위 바위 보 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		select.setBackground(Color.gray);
		for(int i=0; i<btn.length; i++) {
			btn[i] = new JButton(image[i]);
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					int player = -1;
					int com = (int)(Math.random()*3); // 가위->0, 주먹->1, 보->2
					String win;
					
					if(b.getIcon()==image[0])
						player = 0;
					else if(b.getIcon()==image[1])
						player = 1;
					else if(b.getIcon()==image[2])
						player = 2;
					if((player==0&&com==2)||(player==1&&com==0)||(player==2&&com==1))
						win = "ME !!!";
					else if((player==0&&com==1)||(player==1&&com==2)||(player==2&&com==0))
						win = "Computer !!!";
					else
						win = "Same !!!";
					me.setIcon(b.getIcon());
					computer.setIcon(image[com]);
					winner.setText(win);
				}			
			});
			select.add(btn[i]);
		}
		result.setBackground(Color.yellow);
		result.add(me);
		result.add(computer);
		result.add(winner);
		winner.setForeground(Color.red);		
		c.add(select,BorderLayout.NORTH);
		c.add(result,BorderLayout.CENTER);
		setSize(500,400);
		setVisible(true);
		}
	
	public static void main(String[] args) {
		new project();
	}
}