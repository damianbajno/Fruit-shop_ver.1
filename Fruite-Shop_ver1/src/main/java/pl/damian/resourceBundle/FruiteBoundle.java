package pl.damian.resourceBundle;

import java.util.ListResourceBundle;

import pl.damian.fruite.Fruite;

public class FruiteBoundle extends ListResourceBundle {

	public FruiteBoundle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object[][] getContents() {
		return context;
	}

	Fruite[] fruites = { new Fruite("Apple", 3, "apple.jpg"),
			new Fruite("Pear", 2, "pear.jpg"),
			new Fruite("Mandarin", 3, "mandarin.jpeg") };

	private Object[][] context = { { "fruites", fruites },
			{ "amount", "Ilo\u015B\u0107" }, { "unite", "Waga" },
			{ "calculation", "Calculate" }, 
			{ "Price", "Price" }
	};

}
