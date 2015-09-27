package pl.damian.fruite;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import pl.damian.xml.FruitXML;

public class Fruites {

	private ArrayList<Fruite> arrayFruite=new ArrayList<Fruite>();
	private int fruiteNumberInList = -1;
	private String language = new String();

	public void setLanguage(String language) {
		this.language = language;
	}

	public Fruites() {
		loadValuesBoundle();
	}

	public Fruite next() {
		if (fruiteNumberInList < arrayFruite.size() - 1) {
			fruiteNumberInList++;
			return arrayFruite.get(fruiteNumberInList);
		} else
			return null;
	}

	public boolean hasNext() {
		if (fruiteNumberInList < arrayFruite.size() - 1) {
			return true;
		} else
			return false;
	}

	public int size() {
		return arrayFruite.size();
	}

	public void loadValuesBoundle() {

		Locale locale = new Locale(language.toString());
		ResourceBundle resourceBundle = ResourceBundle.getBundle(
				"pl.damian.resourceBundle.FruiteBoundle", locale);
		Enumeration<String> keys = resourceBundle.getKeys();
		while (keys.hasMoreElements()) {
			Object object = resourceBundle.getObject(keys.nextElement());
			if (object instanceof Fruite) {
				Fruite fruite = (Fruite) object;
//				System.out.println(fruite.toString());
				arrayFruite.add(fruite);
			}
		}
	}

	public void loadValuesXMl() {
		FruitXML fruitXML = FruitXML.getInstance();
		fruitXML.readFruitesFromXMLFile();
		arrayFruite = fruitXML.getArrayFruite();
	}
}
