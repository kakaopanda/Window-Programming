package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame {
	GridBagConstraints gbc = new GridBagConstraints( );
	GridBagLayout gbl = new GridBagLayout( );
	Container c = getContentPane();
	JPanel panel = new JPanel();
	int x = 0, y = 0;
	
	project() {
		setTitle("�ؽ�Ʈ �ʵ� ��ġ");
		c.setLayout(gbl);
		panel.setLayout(gbl);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc.insets = (new Insets(0,0,0,0));
		
		JLabel title = new JLabel("�л� ��������");
		title.setFont(new Font("���� ���", Font.BOLD, 15));
		title.setBorder(BorderFactory.createEmptyBorder(70,0,0,0));
		c.add(title, gbc);
	    
		gbc.insets = (new Insets(0,0,0,0));
		addComponent(new JLabel("�̸�: "),x=0,y=1);
		gbc.gridwidth = 3;
		addComponent(new JTextField("������",15),x=1,y=1);
		gbc.gridwidth = 1;
		addComponent(new JLabel("�й�: "),x=0,y=2);
		addComponent(new JTextField("2020021234",10),x=1,y=2);
		addComponent(new JLabel("����: "),x=2,y=2);
		gbc.insets = (new Insets(0,0,0,100));
		addComponent(new JTextField("����.", 4),x=3,y=2);
		gbc.insets = (new Insets(0,0,0,0));
		addComponent(new JLabel("�а�: "),x=0,y=3);
		gbc.gridwidth = 3;
		addComponent(new JTextField("����Ʈ������а�",15),x=1,y=3);
		gbc.gridwidth = 1;
		addComponent(new JLabel("�л��� �ּ�: "),x=0,y=4);
		gbc.gridwidth = 3;
		addComponent(new JTextField("�������ҽ� ���� �������� 123"),x=1,y=4);
		gbc.ipady = 20;
		gbc.ipadx = 20;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = (new Insets(0,0,80,0));
		c.add(panel, gbc);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 350);
		setVisible(true);
	}
	void addComponent(Component component, int x, int y) {
		    gbc.gridx = x;
		    gbc.gridy = y;
		    panel.add(component, gbc);
		  }
	
	public static void main(String[] args) {
		new project();
	}
}
