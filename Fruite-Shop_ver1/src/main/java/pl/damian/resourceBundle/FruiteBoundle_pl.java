package pl.damian.resourceBundle;

import java.util.ListResourceBundle;

import pl.damian.fruite.Fruite;

public class FruiteBoundle_pl extends ListResourceBundle {

	public FruiteBoundle_pl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object[][] getContents() {
		return context;
	}

	private Fruite[] fruites = { new Fruite("Jabłko", 3, "apple.jpg"),
			new Fruite("Gruszka", 2, "pear.jpg"),
			new Fruite("Mandarynka", 3, "mandarin.jpeg") };

	private Object[][] context = { { "fruites", fruites },
			{ "amount", "Ilo\u015B\u0107" }, { "unite", "Waga" },
			{ "calculatorButton", "Oblicz" } };

}
