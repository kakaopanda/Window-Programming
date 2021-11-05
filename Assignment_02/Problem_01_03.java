package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame{
	private JLabel lengthL, areaL, perimeterL;
	private JTextField lengthTF, areaTF, perimeterTF;
	private JButton calculateB, exitB;
	
	public project() {
		super("���簢���� ������ �ѷ� ���");
		lengthL = new JLabel("�� ���� ���̸� �Է��Ͻÿ� ", SwingConstants.RIGHT);
		areaL = new JLabel("���� ", SwingConstants.RIGHT);
		perimeterL = new JLabel("�ѷ� ", SwingConstants.RIGHT);
		
		lengthTF = new JTextField(10);
		areaTF = new JTextField(10);
		perimeterTF = new JTextField(10);
		lengthTF = new JTextField(10);
		areaTF = new JTextField(10);
		perimeterTF = new JTextField(10);
	
		calculateB = new JButton("���");
		calculateB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double length = Double.parseDouble(lengthTF.getText());
				double area = length * length;
				double perimeter = 4 * length;
				areaTF.setText("" + area);
				perimeterTF.setText("" + perimeter);
			}
		});
		
		exitB = new JButton("Exit");
		exitB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
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