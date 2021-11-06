package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class project extends JFrame{
	JLabel l = new JLabel("Love Java");
	String s = new String("Love Java");
	 
	project(){
        setTitle("Left 키로 문자열 이동");
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
        		s = s.substring(1)+s.substring(0,1);
        		l.setText(s);
        	}
        }
    }
}