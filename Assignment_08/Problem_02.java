package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class project extends JFrame{
	ImageIcon icon = null;
	Image image = null;
	project(){
		setTitle("메뉴로 배경 이미지 로딩하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("파일");
		mb.add(m);
		JMenuItem open = new JMenuItem("열기");
		m.add(open);
		setJMenuBar(mb);
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser ch = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
				ch.setFileFilter(filter);
				int r = ch.showOpenDialog(null);
				if(r == JFileChooser.APPROVE_OPTION) {
					String path = ch.getSelectedFile().getPath();
					icon = new ImageIcon(path+"/");
					image = icon.getImage();
					repaint();
				}
			}
		});
		DrawImage bi = new DrawImage();
		setContentPane(bi);	
		setSize(300,300);
		setVisible(true);
	}
	class DrawImage extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
	public static void main(String[] args) {
		new project();
	}
}