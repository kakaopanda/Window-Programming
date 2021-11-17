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
	JLabel label = new JLabel("오디오 파일을 선택하세요");
	project(){
		setTitle("오디오 파일을 찾아 연주/종료 제어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("오디오");
		JMenuItem play = new JMenuItem("연주");
		JMenuItem stop = new JMenuItem("종료");
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
			if(text.equals("연주")){
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
						label.setText(path+"를 연주하고 있습니다.");
					}catch(Exception error){
						error.printStackTrace();}
				}
			}
			else if(text.equals("종료")){
				if(clip.isActive()) {
					label.setText("연주가 종료되었습니다");
					clip.stop();
				}		
			}
		}
	}
	public static void main(String[] args) {
		new project();
	}
}