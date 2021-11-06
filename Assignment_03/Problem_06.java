package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class project extends JFrame{
JLabel l = new JLabel("C");
	project(){
        setTitle("클릭 연습용 응용프로그램");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        
        l.setSize(200,50);
        l.setLocation(100,100);
        l.addMouseListener(new MyMouseAdapter());
  
        c.add(l);
        setSize(300,300);
        setVisible(true);
        
        c.setFocusable(true);
        c.requestFocus();
    }
    public static void main(String[] args) {
        new project();
    }
    
    class MyMouseAdapter extends MouseAdapter{
    int x,y;
    public void mousePressed(MouseEvent e) {
        x = (int)(Math.random()*200);
        y = (int)(Math.random()*200);
        l.setLocation(x, y);
        }
    }
}