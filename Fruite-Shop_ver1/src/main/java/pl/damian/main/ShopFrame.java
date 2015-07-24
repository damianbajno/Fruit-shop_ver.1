package pl.damian.main;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShopFrame extends JFrame {

	final String frameTitle = "Fruite Shop";
	private Fruites fruites=new Fruites();
	
	public ShopFrame() {
		setLayout(new GridLayout(1, 2));
		addFruitePanels();
		setDefaulteSettings();
	}

	public void addFruitePanels() {
		while (fruites.hasNext()) {
			FruitePanels fruitePanels=new FruitePanels("EN", fruites.next());
			add(fruitePanels.getPanel());
		}
	}
	
	public void setDefaulteSettings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(frameTitle);
		setVisible(true);
		pack();
	}
}
