package pl.fruitResourceBundle;

import java.util.ListResourceBundle;

import pl.fruit.Fruit;

public class FruitBundle extends ListResourceBundle {

	public FruitBundle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object[][] getContents() {
		return context;
	}

	Fruit[] fruits = { new Fruit("Apple", 3, "apple.jpg"),
			new Fruit("Pear", 2, "pear.jpg"),
			new Fruit("Mandarin", 3, "mandarin.jpeg") };

	private Object[][] context = { { "fruits", fruits },
			{ "amount", "Ilo\u015B\u0107" }, { "unit", "Waga" },
			{ "calculation", "Calculate" }, 
			{ "Price", "Price" },
			{ "bill", "Bill" }
	};

}
