package ResourceBundle;

import java.util.ListResourceBundle;

import pl.damian.fruite.Fruite;

public class FruiteBoundle_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return context;
	}

	private Object[][] context = {
			{ "apple", new Fruite("Apple", 3, "apple.jpg") },
			{ "pear", new Fruite("Pear", 2, "pear.jpg") },
			{ "mandarin", new Fruite("Mandarin", 3, "mandarin.jpeg") },
			{ "amount", "Ilo\u015B\u0107" }, { "unite", "Waga" } };

}
