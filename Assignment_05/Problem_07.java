package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class project extends JFrame {
	private JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,0);
	private JTextArea area = new JTextArea(10,10);
	
	project(){
		setTitle("TextArea Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider)e.getSource();
				if(area.getText().length()<=slider.getValue()) {
					slider.setValue(area.getText().length());
				}
				else {
					try {
						area.setText(area.getText(0,slider.getValue()));
					}catch(Exception error) {}
				}
			}
		});
		c.add(slider,BorderLayout.SOUTH);
		
		area.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				JTextArea area = (JTextArea)e.getSource();
				int size = area.getText().length();
				slider.setValue(size);
			}
		});
		c.add(new JScrollPane(area),BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
		}
	
	public static void main(String[] args) {
		new project();
	}
}
