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

	private Object[][] context = {
			{ "1", new Fruite("Apple", 3, "apple.jpg") },
			{ "2", new Fruite("Pear", 2, "pear.jpg") },
			{ "3", new Fruite("Mandarin", 3, "mandarin.jpeg") },
			{ "amount", "Amount" }, { "unite", "Pound" } };

}
