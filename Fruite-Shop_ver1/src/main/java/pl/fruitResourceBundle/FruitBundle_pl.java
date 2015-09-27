package pl.fruitResourceBundle;

import java.util.ListResourceBundle;

import pl.fruit.Fruit;

public class FruitBundle_pl extends ListResourceBundle {

	public FruitBundle_pl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object[][] getContents() {
		return context;
	}

	private Fruit[] fruits = { new Fruit("Jabłko", 3, "apple.jpg"),
			new Fruit("Gruszka", 2, "pear.jpg"),
			new Fruit("Mandarynka", 3, "mandarin.jpeg") };

	private Object[][] context = { { "fruits", fruits },
			{ "amount", "Ilo\u015B\u0107" }, { "unite", "kg" },
			{ "calculation", "Oblicz"}, 
			{ "price", "Cena" },
			{ "bill", "Rachunek" }
	};

}
