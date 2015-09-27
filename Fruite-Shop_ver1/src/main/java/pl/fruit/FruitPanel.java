package pl.fruit;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.Tools.Tools;
import pl.fruitResourceBundle.Fruits;
import pl.main.GBC;

public class FruitPanel {
	private JPanel fruitPanel = new JPanel();;
	private JLabel nameLabel = new JLabel();
	private JLabel priceLabel = new JLabel();

	private JLabel pictureLabel = new JLabel();

	private JLabel amountLabel = new JLabel();
	private JTextField amountTextField = new JTextField(5);
	private JLabel unitLabel = new JLabel();

	private static Locale locale = new Locale("EN");
	private static Fruits fruits = new Fruits();
	private Fruit fruit;
	private static int fruitNumber = 0;

	public FruitPanel() {
		setLayout();
		setValuesInJLabels();
		fruitNumber++;
	}

	public void setLayout() {
		fruitPanel.setLayout(new GridBagLayout());
		fruitPanel.add(nameLabel,
				new GBC(0, 0).setAnchor(GBC.EAST).setSpan(1, 1));
		fruitPanel.add(priceLabel, new GBC(1, 0).setAnchor(GBC.CENTER)
				.setSpan(2, 1));
		fruitPanel.add(pictureLabel, new GBC(0, 1).setSpan(3, 3));
		fruitPanel.add(amountLabel, new GBC(0, 4));
		fruitPanel.add(amountTextField, new GBC(1, 4));
		fruitPanel.add(unitLabel, new GBC(2, 4));
	}

	public JPanel getPanel() {
		return fruitPanel;
	}

	public static void changefruitLanguage(Locale locale) {
		fruits.changeLanguage(locale);
	}

	public void changeLanguageInJLabels() {
		resetfruitNumberIfOutOfBound();
		setValuesInJLabels();
	}

	public void resetfruitNumberIfOutOfBound() {
		if (fruitNumber < fruits.lenght() - 1)
			fruitNumber++;
		else {
			fruitNumber = 0;
		}
	}

	public void setValuesInJLabels() {
		fruit = fruits.get(fruitNumber);
		amountLabel.setText(Fruits.getString("amount"));
		unitLabel.setText(Fruits.getString("unite"));

		nameLabel.setText(fruit.getName());
		priceLabel.setText(Fruits.getString("Price") + "  "
				+ String.valueOf(fruit.getPrise()));

		ImageIcon fruitImageIcon = getScaledfruitPicture(fruit);
		pictureLabel.setIcon(fruitImageIcon);
		nameLabel.setText(fruit.getName());
	}

	public ImageIcon getScaledfruitPicture(Fruit fruit) {
		URL pictureURL = ClassLoader.getSystemResource(fruit
				.getPictureAdress());
		String pathToPictureFile = pictureURL.getPath();
		ImageIcon icon = new ImageIcon(pathToPictureFile);
		Image s = icon.getImage().getScaledInstance(150, 150,
				Image.SCALE_DEFAULT);
		icon.setImage(s);
		return icon;
	}

	public static int numberUniquefruits() {
		return fruits.lenght();
	}

	public String getName() {
		return nameLabel.getText();
	}

	public long getPrice() {
		return fruit.getPrise();
	}

	public String getAmount() {
		return amountTextField.getText();
	}

	public String getRecipeValue() {
		if (!Tools.isNumeric(amountTextField.getText()))
			amountTextField.setText("0");
		return nameLabel.getText() + ": " + amountTextField.getText() + "x"
				+ fruit.getPrise() + " = " + price() + "  \n";

	}

	public double price() {
		try {
			double amount = Double.parseDouble(amountTextField.getText());
			return amount * fruit.getPrise();
		} catch (NumberFormatException e) {
			return 0;
		}

	}
}
