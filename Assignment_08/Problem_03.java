package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class project extends JFrame{
	
	public project(){		
		setTitle("툴바 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JToolBar tb = new JToolBar();
		JButton exit = new JButton("종료");	
		tb.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(tb, BorderLayout.NORTH);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new project();
	}
}
