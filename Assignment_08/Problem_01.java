package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class project extends JFrame{
	project(){
		setTitle("�޴� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar mb = new JMenuBar();
		JMenu[] m = new JMenu[4];
		String[] text = {"����","����","����","�Է�"};
		JMenuItem menu_f = new JMenuItem("ȭ�� Ȯ��");
		JMenuItem menu_s = new JMenuItem("������");
		
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
