package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class project extends JFrame{
	project(){
		setTitle("���ڰ� �ƴ� Ű�� �ԷµǴ� ��� ���â �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JToolBar tb = new JToolBar();
		JTextField tf = new JTextField(20);		
		tb.add(new JButton("�й�:"));
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
            		JOptionPane.showMessageDialog(null, code+"�� ���� Ű�� �ƴմϴ�.\n���ڸ� �Է��ϼ���.","���",JOptionPane.ERROR_MESSAGE);
            		e.consume();
            	}
            }
    }
	public static void main(String[] args) {
		new project();
	}
}