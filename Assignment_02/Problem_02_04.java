package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener{
	private JLabel CelciusL, FahrenheitL;
	private JTextField CelciusTF, FahrenheitTF;
	
	public project() {
		super("�µ� ��ȯ");
		CelciusL = new JLabel("���� �µ�", SwingConstants.RIGHT);
		FahrenheitL = new JLabel("ȭ�� �µ� ", SwingConstants.RIGHT);
		
		CelciusTF = new JTextField(10);
		FahrenheitTF = new JTextField(10);
		
		CelciusTF.addActionListener(this);
		FahrenheitTF.addActionListener(this);
		
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
    
    @Override
	public void actionPerformed(ActionEvent e) {
		JTextField f = (JTextField)e.getSource();
		if(f==CelciusTF) {
			double Celcius = Double.parseDouble(CelciusTF.getText());
			double Fahrenheit = (Celcius*1.8)+32;
			Fahrenheit = (double)Math.round(Fahrenheit*100)/100;
			FahrenheitTF.setText("" + Fahrenheit);
		}
		else if(f==FahrenheitTF) {
			double Fahrenheit = Double.parseDouble(FahrenheitTF.getText());
			double Celcius = (Fahrenheit-32)/1.8;
			Celcius = (double)Math.round(Celcius*100)/100;
			CelciusTF.setText("" + Celcius);
		}
	}
}