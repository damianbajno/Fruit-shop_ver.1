package pl.damian.fruite;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.URL;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.damian.main.GBC;
import pl.damian.resourceBundle.Fruites;

public class FruitePanel {
	private JPanel fruitePanel = new JPanel();;
	private JLabel nameLabel = new JLabel();
	private JLabel priceLabel = new JLabel();

	private JLabel pictureLabel = new JLabel();

	private JLabel amountLabel = new JLabel();
	private JTextField amountTextField = new JTextField(5);
	private JLabel unitLabel = new JLabel();

	private static Locale locale = new Locale("EN");
	private static Fruites fruites = new Fruites();
	private Fruite fruite;
	private static int fruiteNumber = 0;

	public FruitePanel() {
		setLayout();
		setValuesInJLabels();
		fruiteNumber++;
	}

	public void setLayout() {
		fruitePanel.setLayout(new GridBagLayout());
		fruitePanel.add(nameLabel, new GBC(0, 0).setAnchor(GBC.EAST).setSpan(1, 1));
		fruitePanel.add(priceLabel, new GBC(1, 0).setAnchor(GBC.EAST).setSpan(2, 1));
		fruitePanel.add(pictureLabel, new GBC(0, 1).setSpan(3, 3));
		fruitePanel.add(amountLabel, new GBC(0, 4));
		fruitePanel.add(amountTextField, new GBC(1, 4));
		fruitePanel.add(unitLabel, new GBC(2, 4));
	}

	public JPanel getPanel() {
		return fruitePanel;
	}

	public static void changeFruiteLanguage(Locale locale) {
		fruites.changeLanguage(locale);
	}

	public void changeLanguageInJLabels(){
		resetFruiteNumberIfOutOfBound();
		setValuesInJLabels();
	}
	
	public void resetFruiteNumberIfOutOfBound() {
		if (fruiteNumber < fruites.lenght()-1)
			fruiteNumber++;
		else {
			fruiteNumber = 0;
		}
	}

	public void setValuesInJLabels() {
		fruite = fruites.get(fruiteNumber);
		amountLabel.setText(fruites.getString("amount"));
		unitLabel.setText(fruites.getString("unite"));

		nameLabel.setText(fruite.getName());
		priceLabel.setText(fruites.getString("Price")+"  "+String.valueOf(fruite.getPrise()));

		ImageIcon fruiteImageIcon = getScaledFruitePicture(fruite);
		pictureLabel.setIcon(fruiteImageIcon);
		nameLabel.setText(fruite.getName());
	}

	public ImageIcon getScaledFruitePicture(Fruite fruite) {
		URL pictureURL = ClassLoader.getSystemResource(fruite
				.getPictureAdress());
		String pathToPictureFile = pictureURL.getPath();
		ImageIcon icon = new ImageIcon(pathToPictureFile);
		Image s = icon.getImage().getScaledInstance(150, 150,
				Image.SCALE_DEFAULT);
		icon.setImage(s);
		return icon;
	}

	public static int numberUniqueFruites() {
		return fruites.lenght();
	}

	public String getName() {
		return nameLabel.getText();
	}

	public long getPrice() {
		return fruite.getPrise();
	}

	public String getAmount() {
		return amountTextField.getText();
	}

	public String getRecipeValue()
	{
		if (amountTextField.getText()==" ")
			amountTextField.setText("0");
		return nameLabel.getText()+": "+amountTextField.getText()+"x"+fruite.getPrise()+" = "+price()+"  \n";
		
	}
	
	public double price(){
		if (amountTextField.getText()==" ") {
		double amount=Double.parseDouble(amountTextField.getText());
		return amount*fruite.getPrise();
		} else return 0;
	}
}
