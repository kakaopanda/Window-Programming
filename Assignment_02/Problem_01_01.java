package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame{
	private JLabel lengthL, areaL, perimeterL;
	static JTextField lengthTF, areaTF, perimeterTF;
	private JButton calculateB, exitB;
	private CalculateListener cbHandler;
	private ExitHandler ebHandler;
	
	public project() {
		super("���簢���� ������ �ѷ� ���");
		lengthL = new JLabel("�� ���� ���̸� �Է��Ͻÿ� ", SwingConstants.RIGHT);
		areaL = new JLabel("���� ", SwingConstants.RIGHT);
		perimeterL = new JLabel("�ѷ� ", SwingConstants.RIGHT);
		
		lengthTF = new JTextField(10);
		areaTF = new JTextField(10);
		perimeterTF = new JTextField(10);
		calculateB = new JButton("���");
		cbHandler = new CalculateListener();
		calculateB.addActionListener(cbHandler);
		
		exitB = new JButton("Exit");
		ebHandler = new ExitHandler();
		exitB.addActionListener(ebHandler);
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(4, 2));
		pane.add(lengthL);
		pane.add(lengthTF);
		pane.add(areaL);
		pane.add(areaTF);
		pane.add(perimeterL);
		pane.add(perimeterTF);
		pane.add(calculateB);
		pane.add(exitB);
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    public static void main(String[] args) {  	
    	project x = new project();
    }
}

class CalculateListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		double length = Double.parseDouble(project.lengthTF.getText());
		double area = length * length;
		double perimeter = 4 * length;
		project.areaTF.setText("" + area);
		project.perimeterTF.setText("" + perimeter);
	}
}
class ExitHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}