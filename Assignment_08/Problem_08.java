package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.Vector;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class project extends JFrame{
	String[] audio_name = {"memories","onceagain","pianomoment","summer"};
	Vector<String> audio_list = null;
	File file[] = new File[4];
	JCheckBox[] cb = new JCheckBox[4];
	JLabel label = new JLabel("체크된 곡만 순서대로 한 번 연주합니다.");
	JButton btn_start = new JButton("연주시작");
	JButton btn_stop = new JButton("연주끝");
	project(){
		setTitle("오디오 연주");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 10));
		label.setBackground(Color.LIGHT_GRAY);
		label.setOpaque(true);
		Container c = getContentPane();
		c.setLayout(new GridLayout(6,1,5,5));
		c.add(label);
		
		for(int i=0;i<file.length;i++) {
			String name = "audio/"+audio_name[i]+".wav";
			file[i] = new File(name);
			cb[i] = new JCheckBox(file[i].getName());
			c.add(cb[i]);
			cb[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		JPanel panel = new JPanel();
		panel.add(btn_start);
		panel.add(btn_stop);
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAudio();
			}
		});
		
		btn_stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.close();
			}
		});
		
		c.add(panel);
		setSize(300,300);
		setVisible(true);
	}
	Clip clip = null;
	public void setAudio() {
		audio_list = new Vector<String>();
		for(int i=0;i<cb.length;i++) {
			if(cb[i].isSelected()) {
				audio_list.add(file[i].getPath());
			}
		}
		if(audio_list.size() <= 0)
			return;
		playFile(audio_list.get(0));
		audio_list.remove(0);
		clip.addLineListener(new LineListener() {
			public void update(LineEvent e){
				if(e.getType() == LineEvent.Type.STOP && audio_list.size() != 0) {
					playFile(audio_list.get(0));
					audio_list.remove(0);
				}
			}
		});
	}
	public void playFile(String path){
		File file = new File(path);	
		try{
			clip = AudioSystem.getClip();
			AudioInputStream audioStr = AudioSystem.getAudioInputStream(file);
			clip.open(audioStr);
			clip.start();
		}catch(Exception e){
			e.printStackTrace();}
	}
	public static void main(String[] args){
		new project();
	}
}