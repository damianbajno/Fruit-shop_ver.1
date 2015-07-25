package pl.damian.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pl.damian.fruite.FruitePanel;
import pl.damian.fruite.Fruites;

public class ShopFrame extends JFrame implements ActionListener {

	final String frameTitle = "Fruite Shop";
	JPanel fruitePanels = new JPanel();
	private Fruites fruites = new Fruites();
	private String language = "EN";

	public ShopFrame() {
		addFruitePanels();
		addComboBoxToChooseLanguage();
		setDefaulteSettings();

	}

	public void addFruitePanels() {
		fruitePanels.setLayout(new GridLayout(2, 2));
		while (fruites.hasNext()) {
			FruitePanel fruitePanel = new FruitePanel(language, fruites.next());
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
		chooseLanguage.addActionListener(this);
		add(chooseLanguage, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> chooseLanguage = (JComboBox<String>) e.getSource();
		language = chooseLanguage.getSelectedItem().toString();
		addFruitePanels();
		SwingUtilities.updateComponentTreeUI(this);
	}

}
