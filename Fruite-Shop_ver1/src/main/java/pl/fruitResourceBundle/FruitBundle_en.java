package pl.fruitResourceBundle;

import java.util.ListResourceBundle;

import pl.fruit.Fruit;

public class FruitBundle_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return context;
	}

	Fruit[] fruits = { new Fruit("Apple", 3, "apple.jpg"),
			new Fruit("Pear", 2, "pear.jpg"),
			new Fruit("Mandarin", 3, "mandarin.jpeg") };

	private Object[][] context = { { "fruits", fruits },
			{ "amount", "Amount" }, { "unit", "pound" },
			{ "calculation", "Calculate" }, 
			{ "price", "price"},
			{ "bill", "Bill" }
	};

}
