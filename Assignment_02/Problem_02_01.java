package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame{
	private JLabel CelciusL, FahrenheitL;
	static JTextField CelciusTF, FahrenheitTF;
	private CelciusListener cHandler;
	private FahrenheitListener fHandler;
	
	public project() {
		super("¿Âµµ º¯È¯");
		CelciusL = new JLabel("¼·¾¾ ¿Âµµ", SwingConstants.RIGHT);
		FahrenheitL = new JLabel("È­¾¾ ¿Âµµ ", SwingConstants.RIGHT);
		
		CelciusTF = new JTextField(10);
		FahrenheitTF = new JTextField(10);
	
		cHandler = new CelciusListener();
		fHandler = new FahrenheitListener();
		
		CelciusTF.addActionListener(cHandler);
		FahrenheitTF.addActionListener(fHandler);
		
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

class CelciusListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		double Celcius = Double.parseDouble(project.CelciusTF.getText());
		double Fahrenheit = (Celcius*1.8)+32;
		Fahrenheit = (double)Math.round(Fahrenheit*100)/100;
		project.FahrenheitTF.setText("" + Fahrenheit);
	}
}

class FahrenheitListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		double Fahrenheit = Double.parseDouble(project.FahrenheitTF.getText());
		double Celcius = (Fahrenheit-32)/1.8;
		Celcius = (double)Math.round(Celcius*100)/100;
		project.CelciusTF.setText("" + Celcius);
	}
}
