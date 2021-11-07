package project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class project extends JFrame {
	Container contentPane = getContentPane();
	JCheckBox[] toppings = new JCheckBox[4];
	String[] names = {"Pepperoni","Mushrooms","Onions","Anchovies"};
	JRadioButton[] size = new JRadioButton[3];
	String[] size_names = {"Small","Medium","Large"};
	
	String toppings_state = "No";
	int topping_select = 0;
	int topping_price = 0;
	int size_price = 0;
	int price = (topping_price+size_price);
	JLabel price_state = new JLabel(Integer.toString(price));
	JLabel state = new JLabel(toppings_state);
	project() {
	    setTitle("Pizza Order");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    contentPane = getContentPane();
	    makeUI();
	    setSize(400,400);
	    setVisible(true);
	}
	private void makeUI() {
		JPanel toppings_panel = new JPanel();
		toppings_panel.setLayout(new GridLayout(4,1));
		toppings_panel.setBorder(BorderFactory.createTitledBorder("TOPPINGS"));
		for(int i=0; i<toppings.length; i++) {
			toppings[i] = new JCheckBox(names[i]);
			toppings[i].addItemListener(new MyItemListener());
			toppings_panel.add(toppings[i]);
		}
	    
	    ButtonGroup g = new ButtonGroup();
	    JPanel size_panel = new JPanel();
	    size_panel.setLayout(new GridLayout(1,3));
	    size_panel.setBorder(BorderFactory.createTitledBorder("SIZE"));
		for(int i=0; i<size.length; i++) {
			size[i] = new JRadioButton(size_names[i]);
			size[i].addItemListener(new MyRadioButtonListener());
			g.add(size[i]);
			size_panel.add(size[i]);
		}
		size[2].setSelected(true); // 초기 설정 Size:Large, Topping:None 선택 
		 JPanel price_panel = new JPanel();
	    price_panel.setBorder(BorderFactory.createTitledBorder("TOTAL PRICE"));
	    JLabel won = new JLabel("Won");
	    JLabel top = new JLabel("Topping");
	    price_panel.add(state);
	    price_panel.add(top);
	    price_panel.add(price_state);
	    price_panel.add(won);
	   
	    contentPane.setLayout(null);
	    contentPane.add(toppings_panel);
	    toppings_panel.setBounds(200,0,110,150);
	    contentPane.add(size_panel);
	    size_panel.setBounds(80,160,220,50);
	    contentPane.add(price_panel);
	    price_panel.setBounds(110,220,150,50);
	}
	class MyItemListener implements ItemListener {
		private int selected = 0;
		private int add_price = 0;
		private int add_topping = 1;
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED)
				selected = -1;
			else
				selected = 1;
			
			if (e.getItem() == toppings[0])
				add_price = 1000; 
			else if (e.getItem() == toppings[1])
				add_price = 1000;
			else if (e.getItem() == toppings[2])
				add_price = 1000;
			else if (e.getItem() == toppings[3])
				add_price = 1000;
			else {
				add_price = 0;
				add_topping = 0;
			}
			topping_price += selected * add_price;
			topping_select += selected * add_topping;
			price = (topping_price+size_price);
			price_state.setText(Integer.toString(price));
			
			if(topping_select==0)
				toppings_state = "No";
			else
				toppings_state = Integer.toString(topping_select);
			state.setText(toppings_state);
		}
	}
	class MyRadioButtonListener implements ItemListener {
		private int selected = 0;
		private int add_price = 0;
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED)
				selected = -1;
			else
				selected = 1;
			if (e.getItem() == size[0])
				add_price = 18000;
			else if (e.getItem() == size[1])
				add_price = 22000;
			else if (e.getItem() == size[2])
				add_price = 25000;
			else
				add_price = 0;
			size_price += selected * add_price;
			price = (topping_price+size_price);
			price_state.setText(Integer.toString(price));
		}
	}
	
	public static void main(String [] args) {
		new project();
	}
}