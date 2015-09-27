package pl.main;

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

import pl.fruit.FruitPanel;
import pl.fruitResourceBundle.Fruits;

public class ShopFrame extends JFrame implements ItemListener, ActionListener {

	final String frameTitle = "Fruit Shop";
	private Locale[] languageTypes = { new Locale("PL"), new Locale("EN")};
	private Locale locale = languageTypes[0];
	private ArrayList<FruitPanel> fruitPanelList = new ArrayList<FruitPanel>();
	private JTextArea recipeTextField;
	private JButton calculationButton;

	public ShopFrame() {
		addFruitPanels();
		addComboBoxToChooseLanguage();
		addCalculationButtonAndText();
		setDefaulteSettings();

	}

	public void addFruitPanels() {
		JPanel fruitPanels = new JPanel();
		for (int i = 0; i < FruitPanel.numberUniquefruits(); i++) {
			FruitPanel fruitPanel = new FruitPanel();
			fruitPanelList.add(fruitPanel);
			fruitPanels.add(fruitPanel.getPanel());
		}
		add(fruitPanels, BorderLayout.CENTER);
	}

	public void addCalculationButtonAndText() {
		JPanel calculationPanel = new JPanel();
		calculationButton = new JButton("Oblicz");
		recipeTextField = new JTextArea(fruitPanelList.size() + 1, 20);

		calculationButton.addActionListener(this);

		calculationPanel.add(calculationButton);
		calculationPanel.add(recipeTextField);

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
			locale = (Locale) e.getItem();
			changeLanguage(locale);
			repaint();
		}
	}

	private void changeLanguage(Locale locale) {
		FruitPanel.changefruitLanguage(locale);
		fruitPanelList.forEach(e -> {e.changeLanguageInJLabels();});
		calculationButton.setText(Fruits.getString("calculation"));
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		recipeTextField.setText("");
		Double recepieSume=0D;
		StringBuilder recepie = new StringBuilder();
		for (int i = 0; i < fruitPanelList.size(); i++) {
			FruitPanel fruit = fruitPanelList.get(i);
			recepie.append(fruit.getRecipeValue());
			recepieSume +=fruit.price();
		}
		recepie.append(Fruits.getString("bill")+" = "+recepieSume );
		recipeTextField.setText(recepie.toString());
	}

}
