package pl.damian.resourceBundle;

import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import pl.damian.fruite.Fruite;

public class mainFruiteBoundle {

	public static void main(String[] args) {
		Locale locale = new Locale("en");
		ResourceBundle resourceBundle = ResourceBundle.getBundle(
				"pl.damian.resourceBundle.FruiteBoundle", locale);
		Fruite fruite = (Fruite) resourceBundle.getObject("apple");
		System.out.println(fruite.toString());
		
		
	}

}
