package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class project extends JFrame{
	JLabel l = new JLabel("Love Java");
	StringBuffer s = new StringBuffer("Love Java");
	 
	project(){
        setTitle("Left Ű�� ���ڿ� ��ü");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        
        l.setSize(200,50);
        l.addKeyListener(new MyKeyListener());
  
        c.add(l);
        setSize(300,200);
        setVisible(true);
        
        l.setFocusable(true);
        l.requestFocus();
    }
    public static void main(String[] args) {
        new project();
    }
    
    class MyKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
        	int keyCode = e.getKeyCode();
        	
        	if(keyCode==KeyEvent.VK_LEFT) {
        		l.setText(s.reverse().toString());
        	}
        }
    }
}