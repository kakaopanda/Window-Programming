package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class project extends JFrame{
	project(){
		setTitle("숫자가 아닌 키가 입력되는 경우 경고창 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JToolBar tb = new JToolBar();
		JTextField tf = new JTextField(20);		
		tb.add(new JButton("학번:"));
		tb.add(tf);	
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(tb,BorderLayout.SOUTH);		
		tf.addKeyListener(new MyKeyListener());
		setSize(300,300);
		setVisible(true);
	}
	class MyKeyListener extends KeyAdapter{
            public void keyTyped(KeyEvent e){
            	char code = e.getKeyChar();
            	if(code<48 || code> 57){
            		JOptionPane.showMessageDialog(null, code+"는 숫자 키가 아닙니다.\n숫자를 입력하세요.","경고",JOptionPane.ERROR_MESSAGE);
            		e.consume();
            	}
            }
    }
	public static void main(String[] args) {
		new project();
	}
}