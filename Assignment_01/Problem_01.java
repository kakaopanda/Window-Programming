package project;
import javax.swing.JFrame;
public class project extends JFrame {
	project(){
		setTitle("Let's study Java");
    	setSize(400,200);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    public static void main(String args[]) {
    	project p = new project();
    }
}