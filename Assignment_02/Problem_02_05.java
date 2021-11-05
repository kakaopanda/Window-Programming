
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame{
	private JLabel CelciusL, FahrenheitL;
	private JTextField CelciusTF, FahrenheitTF;
	
	public project() {
		super("¿Âµµ º¯È¯");
		CelciusL = new JLabel("¼·¾¾ ¿Âµµ", SwingConstants.RIGHT);
		FahrenheitL = new JLabel("È­¾¾ ¿Âµµ ", SwingConstants.RIGHT);
		
		CelciusTF = new JTextField(10);
		FahrenheitTF = new JTextField(10);
	
		CelciusTF.addActionListener(e -> {
			double Celcius = Double.parseDouble(CelciusTF.getText());
			double Fahrenheit = (Celcius*1.8)+32;
			Fahrenheit = (double)Math.round(Fahrenheit*100)/100;
			FahrenheitTF.setText("" + Fahrenheit);
		});
		
		FahrenheitTF.addActionListener(e -> {
			double Fahrenheit = Double.parseDouble(FahrenheitTF.getText());
			double Celcius = (Fahrenheit-32)/1.8;
			Celcius = (double)Math.round(Celcius*100)/100;
			CelciusTF.setText("" + Celcius);
		});
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(1, 4));
		pane.add(CelciusL);
		pane.add(CelciusTF);
		pane.add(FahrenheitL);
		pane.add(FahrenheitTF);
		setSize(500, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    public static void main(String[] args) {  	
    	project x = new project();
    }
}
