package pl.damian.fruite;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.damian.main.GBC;
import pl.damian.resourceBundle.LanguageTranslator;

public class FruitePanel {
	private JPanel fruitePanel = new JPanel();;
	private JLabel nameLabel = new JLabel();
	private JLabel priceLabel = new JLabel();

	private JLabel pictureLabel = new JLabel();

	private JLabel amountLabel = new JLabel();
	private JTextField amountTextFild = new JTextField(5);
	private JLabel unitLabel = new JLabel();

	private static Locale language=new Locale("EN");
	private Fruite fruite;

	private static LanguageTranslator languageTranslator=LanguageTranslator.getInstance(language);
	
	public FruitePanel() {
		languageTranslator=LanguageTranslator.getInstance(language);
		fruite=languageTranslator.nextFruite();
		setLayout();
		setValuesInJLabels();
	}

	public void setLayout() {
		fruitePanel.setLayout(new GridBagLayout());
		fruitePanel.add(nameLabel, new GBC(0, 0).setSpan(1, 1));
		fruitePanel.add(priceLabel, new GBC(2, 0).setAnchor(GBC.CENTER));
		fruitePanel.add(pictureLabel, new GBC(0, 1).setSpan(3, 3));
		fruitePanel.add(amountLabel, new GBC(0, 4));
		fruitePanel.add(amountTextFild, new GBC(1, 4));
		fruitePanel.add(unitLabel, new GBC(2, 4));
	}

	public JPanel getPanel() {
		return fruitePanel;
	}

	public void changeLanguage(Locale language) {
		this.language = language;
		languageTranslator=LanguageTranslator.getInstance(language);
		fruite = languageTranslator.nextFruite();
		setValuesInJLabels();
	}

	public void setValuesInJLabels() {
		
		amountLabel.setText(languageTranslator.getString("amount"));
		unitLabel.setText(languageTranslator.getString("unite"));

		nameLabel.setText(fruite.getName());
		priceLabel.setText(String.valueOf(fruite.getPrise()));

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

		
	public static int size() {
		return languageTranslator.arrayFruiteSize();
	}

	public String getName(){
		return nameLabel.getText();
	}
	
	public long getPrice(){
		return fruite.getPrise();
	}
	
	public String getAmount(){
		return amountTextFild.getText();
	}

}
