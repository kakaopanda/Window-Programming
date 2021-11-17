package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class project extends JFrame{
	project(){
		setTitle("메뉴 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar mb = new JMenuBar();
		JMenu[] m = new JMenu[4];
		String[] text = {"파일","편집","보기","입력"};
		JMenuItem menu_f = new JMenuItem("화면 확대");
		JMenuItem menu_s = new JMenuItem("쪽윤곽");
		
		for(int i=0;i<m.length;i++) {
			m[i] = new JMenu(text[i]);
			mb.add(m[i]);
		}
		m[2].add(menu_f);
		m[2].add(menu_s);
		setJMenuBar(mb);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new project();
	}
}
