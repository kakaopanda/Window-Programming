package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame {
	private JPanel first = new JPanel();
	private JLabel label = new JLabel("금액");
	private JTextField input = new JTextField(15);
	private JButton btn = new JButton("계산");
	
	private JPanel second = new JPanel();
	private int[] m_unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
	private String[] str = {"오만원","만원","천원","500원","100원","50원","10원","1원"};
	private JTextField[] m_text = new JTextField[str.length];
	
	project(){
		setTitle("Money Changer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		first.setLayout(null);
		label.setBounds(70, 30, 50, 20);
		input.setBounds(120, 30, 100, 20);
		btn.setBounds(240,30,70,20);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m = input.getText();
				if(m.length()==0)
					return;
				int money = Integer.parseInt(m);
				int k;
				
				for(int i=0; i<m_unit.length; i++) {
					k = money/m_unit[i];
					m_text[i].setText(Integer.toString(k));
					if(k>0)
						money = money % m_unit[i];
				}
			}
		});
		first.add(label);
		first.add(input);
		first.add(btn);
		second.setLayout(null);
		for(int i=str.length-1; i>=0; i--) {
			JLabel text = new JLabel(str[i]);
			text.setHorizontalAlignment(JLabel.RIGHT);
			text.setBounds(60,10+i*25, 60, 20);
			second.add(text,i,0);
			m_text[i] = new JTextField(10);
			m_text[i].setHorizontalAlignment(JTextField.CENTER);
			m_text[i].setBounds(140,10+i*25,70,20);
			second.add(m_text[i],i,1);
		}
		first.setBackground(Color.pink);
		second.setBackground(Color.pink);
		first.setBounds(0,0,350,50);
		second.setBounds(0,50,350,300);
		c.add(first);
		c.add(second);
		setSize(350,350);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new project();
	}
}
