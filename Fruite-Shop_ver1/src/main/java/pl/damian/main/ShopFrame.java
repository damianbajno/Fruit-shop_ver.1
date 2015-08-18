package pl.damian.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import pl.damian.fruite.FruitePanel;
import pl.damian.resourceBundle.Fruites;

public class ShopFrame extends JFrame implements ItemListener, ActionListener {

	final String frameTitle = "Fruite Shop";
	Locale[] languageTypes = { new Locale("PL"), new Locale("EN") };
	private Locale locale = languageTypes[0];
	private ArrayList<FruitePanel> fruitePanelList = new ArrayList<FruitePanel>();
	private Fruites fruites;
	private JTextArea recipeTextField;
	JButton calculationButton;

	public ShopFrame() {
		addFruitePanels();
		addComboBoxToChooseLanguage();
		addCalculationButtonAndText();
		setDefaulteSettings();

	}

	public void addFruitePanels() {
		JPanel fruitePanels = new JPanel();
		for (int i = 0; i < FruitePanel.numberUniqueFruites(); i++) {
			FruitePanel fruitePanel = new FruitePanel();
			fruitePanelList.add(fruitePanel);
			fruitePanels.add(fruitePanel.getPanel());
		}
		add(fruitePanels, BorderLayout.CENTER);
	}

	public void addCalculationButtonAndText() {
		JPanel calculationPanel = new JPanel();
		calculationButton = new JButton("Oblicz");
		recipeTextField = new JTextArea(fruitePanelList.size() + 1, 20);

		calculationButton.addActionListener(this);

		calculationPanel.add(calculationButton);
		calculationPanel.add(recipeTextField);

		add(calculationPanel, BorderLayout.SOUTH);
	}

	public void addComboBoxToChooseLanguage() {
		JComboBox<Locale> chooseLanguage = new JComboBox<Locale>(languageTypes);
		// chooseLanguage.setSelectedItem(languageTypes[1]);
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
			locale = (Locale) e.getItem();
			changeLanguage(locale);
			repaint();
		}
	}

	private void changeLanguage(Locale locale) {
		FruitePanel.changeFruiteLanguage(locale);
		fruitePanelList.forEach(e -> {
			e.changeLanguageInJLabels();
			;
		});
		calculationButton.setText(Fruites.getString("calculation"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		recipeTextField.setText("");
		StringBuilder recepie = new StringBuilder();
		for (int i = 0; i < fruitePanelList.size(); i++) {
			recepie.append(fruitePanelList.get(i).getRecipeValue());
		}
		recipeTextField.setText(recepie.toString());
	}

}
