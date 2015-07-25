package pl.damian.xml;

import pl.damian.fruite.Fruite;

public class mainXML {

	

	public static void main(String args[]) {

		Fruite[] fruites = {
				new Fruite("pl", "Jabłko", 3,"apple.jpg"),
				new Fruite("pl", "Gruszka", 2,"pear.jpg"),
				new Fruite("pl", "Mandarynka", 3,"mandarin.jpeg")};
		FruitXML fruitXML=new FruitXML();
		fruitXML.writeFruitesToXMLFile(fruites);
		
	}

	

}
