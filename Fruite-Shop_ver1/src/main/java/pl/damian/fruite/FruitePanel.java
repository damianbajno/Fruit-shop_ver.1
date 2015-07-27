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

public class FruitePanel {
	private JPanel fruitePanel = new JPanel();;
	private JLabel nameLabel = new JLabel();
	private JLabel priceLabel = new JLabel();

	private JLabel pictureLabel = new JLabel();

	private JLabel amountLabel = new JLabel();
	private JTextField amountTextFild = new JTextField(5);
	private JLabel unitLabel = new JLabel();

	private static String language = new String();
	private Properties fruiteLanguageProperties;
	private Fruite fruite;

	private static ResourceBundle resourceBundle;
	static Integer fruiteNumber = 1;

	public FruitePanel(String language) {
		this.language = language;
		loadResourceBoundle();
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
		setLayout();
		if (fruite != null) {
			setValuesInJLabels();
		}
		return fruitePanel;
	}

	public void changeLanguage(String language) {
		this.language = language;
		loadResourceBoundle();

		setValuesInJLabels();
		System.out.println(nameLabel.getText());
	}

	public void setValuesInJLabels() {

		Fruite fruite = (Fruite) resourceBundle.getObject(fruiteNumber
				.toString());
		amountLabel.setText(resourceBundle.getString("amount"));
		unitLabel.setText(resourceBundle.getString("unite"));

		nameLabel.setText(fruite.getName());
		priceLabel.setText(String.valueOf(fruite.getPrise()));

		ImageIcon fruiteImageIcon = getScaledFruitePicture(fruite);
		pictureLabel.setIcon(fruiteImageIcon);
		nameLabel.setText(fruite.getName());
		fruiteNumber++;
		if (fruiteNumber == 4)
			fruiteNumber = 1;
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

	public static void loadResourceBoundle() {
		Locale locale = new Locale(language.toString());
		System.out.println("jezyk=  "+locale.getLanguage());
		resourceBundle = ResourceBundle.getBundle(
				"pl.damian.resourceBundle.FruiteBoundle", locale);
		final Object object = resourceBundle.getObject("1");
		Fruite fruite = (Fruite) object;
		System.out.println(fruite.getName());

	}

	public static int size() {
		loadResourceBoundle();
		return resourceBundle.keySet().size() - 2;
	}

	public void loadPropertise() {
		InputStream languageResourse = ClassLoader
				.getSystemResourceAsStream(language + ".properties");
		fruiteLanguageProperties = new Properties();
		try {
			fruiteLanguageProperties.load(languageResourse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
