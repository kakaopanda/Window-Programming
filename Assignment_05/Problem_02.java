package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame {
	project(){
		setTitle("CheckBox Practice Fuction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox active = new JCheckBox("버튼 비활성화");
		JCheckBox hide = new JCheckBox("버튼 감추기");
		JButton btn = new JButton("test button");
		
		c.add(active);
		c.add(hide);
		c.add(btn);
		
		active.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					btn.setEnabled(false);
				else
					btn.setEnabled(true);
			}
		});
		
		hide.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					btn.setVisible(false);
				else
					btn.setVisible(true);
			}
		});
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new project();
	}
}
