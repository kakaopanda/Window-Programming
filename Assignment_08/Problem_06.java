package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame{
	JButton btn = new JButton("calculate");
	JLabel label = new JLabel("��� ��� ���");
	project(){
		setTitle("���̾�α� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		label.setBackground(Color.green);
		label.setOpaque(true);
		c.setLayout(new FlowLayout());
		c.add(btn);
		c.add(label);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CalDialog cal = new CalDialog();
				cal.setVisible(true);
			}
		});
		setSize(300,300);
		setVisible(true);
	}
	class CalDialog extends JDialog{
		JTextField tf1 = new JTextField(10);
		JTextField tf2 = new JTextField(10);
		JButton btn = new JButton("Add");
		CalDialog(){
			setLayout(new FlowLayout());
			setSize(100,200);
			add(new JLabel("�� ���� ���մϴ�"));
			add(tf1);
			add(tf2);
			add(btn);
			setTitle("Calculation Dialog");	
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					setVisible(false);		
					int result = Integer.parseInt(tf1.getText())+Integer.parseInt(tf2.getText());
					label.setText(Integer.toString(result));
				}
			});
		}
	}
	public static void main(String[] args) {
		new project();
	}
}