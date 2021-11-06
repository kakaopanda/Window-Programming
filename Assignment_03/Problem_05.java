package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class project extends JFrame{
	JLabel l = new JLabel("Love Java");
	Font f = l.getFont();
    int size = f.getSize();
	 
	project(){
        setTitle("+,- 키로 폰트 크기 조절");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        
        l.setSize(200,50);
        l.setFont(new Font("Arial",Font.PLAIN,10));
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
        	int keyChar = e.getKeyChar();
        	
        	if(keyChar=='+') {
        		l.setFont(new Font("Arial", Font.PLAIN, size+5));
        		size += 5;
        	}
        	else if(keyChar=='-') {
        		if(size>=10)
        		{
        			l.setFont(new Font("Arial", Font.PLAIN, size-5));
        			size -= 5;
        		}
        	}
        }
    }
}