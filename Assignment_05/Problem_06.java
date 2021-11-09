package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class project extends JFrame {
	private JSlider slider = new JSlider(JSlider.HORIZONTAL,100,200,128);
	private JLabel label = new JLabel("");
	
	project(){
		setTitle("JSlider Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(20);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider)e.getSource();
				label.setText(Integer.toString(slider.getValue()));
			}
		});
		c.add(slider);
		
		label.setText(Integer.toString(slider.getValue()));
		label.setOpaque(true);
		label.setBackground(Color.green);
		c.add(label);
		
		setSize(300,100);
		setVisible(true);
		}
	
	public static void main(String[] args) {
		new project();
	}
}
