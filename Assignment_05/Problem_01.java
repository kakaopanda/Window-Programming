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
		setTitle("텍스트 필드 배치");
		c.setLayout(gbl);
		panel.setLayout(gbl);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc.insets = (new Insets(0,0,0,0));
		
		JLabel title = new JLabel("학생 인적사항");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		title.setBorder(BorderFactory.createEmptyBorder(70,0,0,0));
		c.add(title, gbc);
	    
		gbc.insets = (new Insets(0,0,0,0));
		addComponent(new JLabel("이름: "),x=0,y=1);
		gbc.gridwidth = 3;
		addComponent(new JTextField("김은석",15),x=1,y=1);
		gbc.gridwidth = 1;
		addComponent(new JLabel("학번: "),x=0,y=2);
		addComponent(new JTextField("2020021234",10),x=1,y=2);
		addComponent(new JLabel("상태: "),x=2,y=2);
		gbc.insets = (new Insets(0,0,0,100));
		addComponent(new JTextField("재학.", 4),x=3,y=2);
		gbc.insets = (new Insets(0,0,0,0));
		addComponent(new JLabel("학과: "),x=0,y=3);
		gbc.gridwidth = 3;
		addComponent(new JTextField("소프트웨어공학과",15),x=1,y=3);
		gbc.gridwidth = 1;
		addComponent(new JLabel("학생의 주소: "),x=0,y=4);
		gbc.gridwidth = 3;
		addComponent(new JTextField("광주직할시 서구 빛고을로 123"),x=1,y=4);
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
