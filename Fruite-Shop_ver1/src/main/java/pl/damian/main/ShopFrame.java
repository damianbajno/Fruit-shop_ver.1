package pl.damian.main;

import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShopFrame extends JFrame {

	final String frameTitle="Fruite Shop";
	FruitePanels fruitePanels=new FruitePanels("PL");
	
	public ShopFrame() {
		setLayout(new GridLayout(1, 2));
		addFruitePanelsToFrame();
		setDefaulteSettings();
	}

	public void addFruitePanelsToFrame() {
		for (int i = 0; i < fruitePanels.manyPanels(); i++) {
			fruitePanels.createPanel();
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
