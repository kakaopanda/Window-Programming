package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class project extends JFrame{
	
	public project(){		
		setTitle("���� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JToolBar tb = new JToolBar();
		JButton exit = new JButton("����");	
		tb.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", "���� Ȯ��", JOptionPane.YES_NO_OPTION);
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
