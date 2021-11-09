package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame {
	project(){
		setTitle("JTextField and JComboBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JTextField tf = new JTextField(10);
		JComboBox<String> cb = new JComboBox<String>();
		
		c.add(tf);
		c.add(cb);
		
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				cb.addItem(tf.getText());
				tf.setText("");
			}
		});
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new project();
	}
}
