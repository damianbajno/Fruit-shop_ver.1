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

	private Object[][] context = {
			{ "1", new Fruite("Jabłko", 3, "apple.jpg") },
			{ "2", new Fruite("Gruszka", 2, "pear.jpg") },
			{ "3", new Fruite("Mandarynka", 3, "mandarin.jpeg") },
			{ "amount", "Ilo\u015B\u0107" }, { "unite", "Waga" } };

}
