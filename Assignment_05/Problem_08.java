package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class project extends JFrame {
	private JSlider slider = new JSlider(JSlider.HORIZONTAL,1,100,56);
	private JLabel label = new JLabel("I Love Java");
	
	project(){
		setTitle("JSlider Practice Frame");
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
				label.setFont(new Font("Arial",Font.PLAIN,slider.getValue()));
			}
		});
		c.add(slider,BorderLayout.NORTH);
		label.setFont(new Font("Arial",Font.PLAIN,slider.getValue()));
		label.setHorizontalAlignment(JLabel.CENTER);
		c.add(label,BorderLayout.CENTER);
		
		setSize(400,400);
		setVisible(true);
		}
	
	public static void main(String[] args) {
		new project();
	}
}
