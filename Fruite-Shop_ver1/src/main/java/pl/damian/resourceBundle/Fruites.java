package pl.damian.resourceBundle;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import pl.damian.fruite.Fruite;

public class Fruites {

	private Fruite[] fruiteArray;
	private static ResourceBundle resourceBundle;
    private	Iterator<Fruite> fruiteIterator;

	public Fruites() {
		resourceBundle = ResourceBundle
				.getBundle("pl.damian.resourceBundle.FruiteBoundle");
		fruiteArray = (Fruite[]) resourceBundle.getObject("fruites");
	}

	public void changeLanguage(Locale locale) {
		resourceBundle = ResourceBundle.getBundle(
				"pl.damian.resourceBundle.FruiteBoundle", locale);
		fruiteArray = (Fruite[]) resourceBundle.getObject("fruites");
		List<Fruite> fruiteList = Arrays.asList(fruiteArray);
		fruiteIterator = fruiteList.iterator();
	}

	public int lenght() {
		return fruiteArray.length;
	}

	public Fruite get(int i) {
		return fruiteArray[i];
	}

	public Fruite next() {
		return fruiteIterator.next();
	}

	public static String getString(String key) {
		return resourceBundle.getString(key);
	}

}
