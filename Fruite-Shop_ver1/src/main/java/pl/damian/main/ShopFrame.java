package pl.damian.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.damian.fruite.Fruite;
import pl.damian.fruite.FruitePanel;
import pl.damian.fruite.Fruites;

public class ShopFrame extends JFrame implements ItemListener {

	final String frameTitle = "Fruite Shop";
	Locale[] languageTypes = {new Locale("EN"), new Locale("PL")};
	private Locale language; 
	private JPanel fruitePanels;
	private ArrayList<FruitePanel> fruitePanelList=new ArrayList<FruitePanel>();
	
	public ShopFrame() {
		addFruitePanels();
		addComboBoxToChooseLanguage();

		setDefaulteSettings();

	}

	public void addFruitePanels() {
		fruitePanels = new JPanel();
		for (int i = 0; i < FruitePanel.size(); i++) {
			FruitePanel fruitePanel = new FruitePanel();
			fruitePanelList.add(fruitePanel);
			fruitePanels.add(fruitePanel.getPanel());
		}
		add(fruitePanels, BorderLayout.CENTER);
	}

	public void addCalculationButtonAndText() {
		JPanel calculationPanel = new JPanel();
		JButton calculationButton = new JButton();

		add(calculationPanel, BorderLayout.SOUTH);
	}

	public void addComboBoxToChooseLanguage() {
		JComboBox<Locale> chooseLanguage = new JComboBox<Locale>(languageTypes);
		chooseLanguage.addItemListener(this);
		add(chooseLanguage, BorderLayout.NORTH);
	}

	public void setDefaulteSettings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(frameTitle);
		setVisible(true);
		pack();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			language = (Locale) e.getItem();
			fruitePanelList.forEach(f -> f.changeLanguage(language));
			repaint();
		}
	}
		
}
