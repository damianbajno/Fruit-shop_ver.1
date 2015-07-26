package pl.damian.resourceBundle;

import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import pl.damian.fruite.Fruite;

public class mainFruiteBoundle {

	public static void main(String[] args) {
		Locale locale=new Locale("pl");
		ResourceBundle resourceBundle=ResourceBundle.getBundle("ResourceBundle.FruiteBoundle", locale);
		Fruite fruite = (Fruite) resourceBundle.getObject("apple");
		System.out.println(fruite.toString());
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(System.getProperty("zmiennaSystemowaJava"));
		final Properties properties = System.getProperties();
		final Set<Object> keySet = properties.keySet();
		keySet.forEach(e -> e=(String) e);
		for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
			String name=(String) iterator.next();
			System.out.println(name + " !!!!!!!    values  !!!!!!!   "+System.getProperty(name));
			
		}
		
	}

}
