package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class project extends JFrame{
 
    project(){
        setTitle("마우스 올리기 내리기");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        JLabel label = new JLabel("Love Java");
        label.addMouseListener(new MyMouseAdapter());
        label.setSize(200,50);
        c.add(label);
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new project();
    }
}

class MyMouseAdapter extends MouseAdapter{
    public void mouseEntered(MouseEvent e) {
        JLabel l = (JLabel)e.getSource();
        l.setText("Love Java");
    }
    public void mouseExited(MouseEvent e) {
        JLabel l = (JLabel)e.getSource();
        l.setText("사랑해");
    }
}
