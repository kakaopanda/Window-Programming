package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class project extends JFrame{
	JLabel l = new JLabel("Love Java");
	Font f = l.getFont();
    int size = f.getSize();
	 
	project(){
        setTitle("마우스 휠을 굴려 폰트 크기 조절");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        
        l.setSize(200,50);
        l.setFont(new Font("Arial",Font.PLAIN,10));
        l.addMouseWheelListener(new MyMouseWheelListener());
  
        c.add(l);
        setSize(300,200);
        setVisible(true);
        
        l.setFocusable(true);
        l.requestFocus();
    }
    public static void main(String[] args) {
        new project();
    }
    
    class MyMouseWheelListener implements MouseWheelListener{
        public void mouseWheelMoved(MouseWheelEvent e) {
        	int n = e.getWheelRotation();
        	if(n>0) {
        		l.setFont(new Font("Arial", Font.PLAIN, size+5));
        		size += 5;
        	}
        	else{
        		if(size>=10)
        		{
        			l.setFont(new Font("Arial", Font.PLAIN, size-5));
        			size -= 5;
        		}
        	}
        }
    }
}