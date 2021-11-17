package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class project extends JFrame{
	Clip clip = null;
	File audioFile = null;
	project(){
		setTitle("오디오 시작 중단 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		try {
			clip = AudioSystem.getClip();
			audioFile = new File("music/test.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);
			clip.start();
		}catch (Exception e) {
			e.printStackTrace();
		}
		JLabel label = new JLabel(audioFile.getPath()+"연주 계속 ");
		label.setHorizontalAlignment(JLabel.CENTER);;
		c.add(label);
		c.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e){
				clip.stop();
				label.setText(audioFile.getPath()+ "연주 일시 중단 ");
			}		
			public void mouseEntered(MouseEvent e){
				if(! clip.isActive()) {
					clip.start();
					label.setText(audioFile.getPath()+ "연주 계속");
				}				
			}
		});
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new project();
	}
}