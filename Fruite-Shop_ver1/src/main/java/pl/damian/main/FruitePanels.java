package pl.damian.main;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.damian.xml.FruitXML;

public class FruitePanels {
	private JPanel fruitePanel = new JPanel();;
	private JLabel nameLabel = new JLabel();
	private JLabel priceLabel = new JLabel();

	private JLabel pictureLabel = new JLabel();

	private JLabel amountLabel = new JLabel();
	private JTextField amountTextFild = new JTextField(5);
	private JLabel unitLabel = new JLabel();

	private StringBuilder language = new StringBuilder();
	private Properties fruiteLanguageProperties;
	private Fruite fruite;

	public FruitePanels(String language, Fruite fruite) {
		this.language.append(language);
		this.fruite = fruite;
		propertise();
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
		setLayout();
		if (fruite != null) {
			setValuesInJLabels();
		}
		return fruitePanel;
	}

	public void setValuesInJLabels() {

		amountLabel.setText(fruiteLanguageProperties.getProperty("amount"));
		unitLabel.setText(fruiteLanguageProperties.getProperty("unite"));

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

	public void propertise() {
		InputStream languageResourse = ClassLoader
				.getSystemResourceAsStream(language.append(".properties")
						.toString());
		fruiteLanguageProperties = new Properties();
		try {
			fruiteLanguageProperties.load(languageResourse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
