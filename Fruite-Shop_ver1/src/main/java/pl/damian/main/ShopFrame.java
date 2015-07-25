package pl.damian.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.damian.fruite.FruitePanel;
import pl.damian.fruite.Fruites;

public class ShopFrame extends JFrame implements ItemListener {

	final String frameTitle = "Fruite Shop";
	JPanel fruitePanels = new JPanel();
	private Fruites fruites = new Fruites();
	private String language = "EN";
	private ArrayList<FruitePanel> fruitePanelList=new ArrayList<FruitePanel>();
	
	public ShopFrame() {
		addFruitePanels();
		addComboBoxToChooseLanguage();
		setDefaulteSettings();

	}

	public void addFruitePanels() {
		fruitePanels.setLayout(new GridLayout(2, 2));
		while (fruites.hasNext()) {
			FruitePanel fruitePanel = new FruitePanel(language, fruites.next());
			fruitePanelList.add(fruitePanel);
			fruitePanels.add(fruitePanel.getPanel());
		}
		add(fruitePanels, BorderLayout.CENTER);
	}

	public void setDefaulteSettings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(frameTitle);
		setVisible(true);
		pack();
	}

	public void addComboBoxToChooseLanguage() {
		String[] languageTypes = { "PL", "EN" };

		JComboBox<String> chooseLanguage = new JComboBox<String>(languageTypes);
		chooseLanguage.addItemListener(this);
		
		add(chooseLanguage, BorderLayout.NORTH);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
			language = (String) e.getItem().toString();
			fruitePanelList.forEach(f -> f.changeLanguage(language));
			repaint();
		}
		
	}
}
