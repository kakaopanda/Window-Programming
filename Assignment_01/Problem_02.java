package project;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JButton;

public class project extends JFrame {
	project(){
	setTitle("BorderLayout Practice");
    	setSize(400,200);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); 	
    	Container c = getContentPane();
    	c.setLayout(new BorderLayout(5,7));
    	c.add(new JButton("North"),BorderLayout.NORTH);
    	c.add(new JButton("South"),BorderLayout.SOUTH);
    	c.add(new JButton("West"),BorderLayout.WEST);
    	c.add(new JButton("East"),BorderLayout.EAST);
    	c.add(new JButton("Center"),BorderLayout.CENTER);	
    	setVisible(true);
	}
    public static void main(String args[]) {
    	project p = new project();
    }
}