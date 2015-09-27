package pl.damian.resourceBundle;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import pl.damian.fruite.Fruite;

public class LanguageTranslator {

	private Fruite[] fruites;
	private Iterator<Fruite> fruiteIterator;
	
	private static ResourceBundle resourceBundle;

	private LanguageTranslator(Locale locale) {
		
		resourceBundle = ResourceBundle.getBundle(
				"pl.damian.resourceBundle.FruiteBoundle", locale);
	
		fruites = (Fruite[]) resourceBundle.getObject("fruites");
		HashSet<Fruite> fruiteSet=new HashSet<Fruite>();
		Collections.addAll(fruiteSet, fruites);
		fruiteIterator = fruiteSet.iterator();
	}
	
	public static LanguageTranslator getInstance(Locale locale) {
		return new LanguageTranslator(locale);
	}

	public int arrayFruiteSize() {
		return fruites.length;
	}

	public Fruite nextFruite(){
		return fruiteIterator.next();
	}
	
	public Fruite[] getFruites() {
		return fruites;
	}

	public final String getString(String key) {
		return resourceBundle.getString(key);
	}
	
	
}
