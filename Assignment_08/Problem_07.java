package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class project extends JFrame{
	Clip clip = null;
	File audioFile = null;
	JLabel label = new JLabel("����� ������ �����ϼ���");
	project(){
		setTitle("����� ������ ã�� ����/���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("�����");
		JMenuItem play = new JMenuItem("����");
		JMenuItem stop = new JMenuItem("����");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		c.add(label,BorderLayout.CENTER);
		mb.add(menu);
		menu.add(play);
		menu.add(stop);
		setJMenuBar(mb);
		Action action = new Action();
		play.addActionListener(action);
		stop.addActionListener(action);
		setSize(400,200);
		setVisible(true);
	}
	class Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String text = e.getActionCommand();
			if(text.equals("����")){
				JFileChooser ch = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Audio Files(wav,au,mid,rmf)", "wav");
				ch.setFileFilter(filter);
				int select = ch.showOpenDialog(null);
				if(select == JFileChooser.APPROVE_OPTION){
					String path = ch.getSelectedFile().getPath();
					try{
						clip = AudioSystem.getClip();
						audioFile = new File(path);
						AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
						clip.open(audioStream);
						clip.start();
						label.setText(path+"�� �����ϰ� �ֽ��ϴ�.");
					}catch(Exception error){
						error.printStackTrace();}
				}
			}
			else if(text.equals("����")){
				if(clip.isActive()) {
					label.setText("���ְ� ����Ǿ����ϴ�");
					clip.stop();
				}		
			}
		}
	}
	public static void main(String[] args) {
		new project();
	}
}