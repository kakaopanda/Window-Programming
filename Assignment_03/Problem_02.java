import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class project extends JFrame{
	Container c = getContentPane();
    
	project(){
        setTitle("µå·¡±ëµ¿¾È YELLOW");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c.setBackground(Color.GREEN);
        c.addMouseListener(new MyMouseAdapter());
        c.addMouseMotionListener(new MyMouseMotionAdapter());
        
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new project();
    }
    
    class MyMouseAdapter extends MouseAdapter{
        public void mouseReleased(MouseEvent e) {
            c.setBackground(Color.GREEN);
        }
    }

    class MyMouseMotionAdapter extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e) {
        	 c.setBackground(Color.YELLOW);
        }
    }
}