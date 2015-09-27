package pl.fruitResourceBundle;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import pl.fruit.Fruit;

public class Fruits {

	private static final String RESOURCE_FRUIT_BUNDLE = "pl.fruitResourceBundle.FruitBundle";
	private Fruit[] fruitArray;
	private static ResourceBundle resourceBundle;
    private	Iterator<Fruit> fruitIterator;

	public Fruits() {
		resourceBundle = ResourceBundle
				.getBundle(RESOURCE_FRUIT_BUNDLE);
		fruitArray = (Fruit[]) resourceBundle.getObject("fruits");
	}

	public void changeLanguage(Locale locale) {
		resourceBundle = ResourceBundle.getBundle(
				RESOURCE_FRUIT_BUNDLE, locale);
		fruitArray = (Fruit[]) resourceBundle.getObject("fruits");
		List<Fruit> fruitList = Arrays.asList(fruitArray);
		fruitIterator = fruitList.iterator();
	}

	public int lenght() {
		return fruitArray.length;
	}

	public Fruit get(int i) {
		return fruitArray[i];
	}

	public Fruit next() {
		return fruitIterator.next();
	}

	public static String getString(String key) {
		return resourceBundle.getString(key);
	}

}
