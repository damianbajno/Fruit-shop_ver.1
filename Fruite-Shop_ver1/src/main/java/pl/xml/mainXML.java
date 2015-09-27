package pl.xml;

import pl.fruit.Fruit;

public class mainXML {

	

	public static void main(String args[]) {

		Fruit[] fruits = {
				new Fruit("pl", "Jabłko", 3,"apple.jpg"),
				new Fruit("pl", "Gruszka", 2,"pear.jpg"),
				new Fruit("pl", "Mandarynka", 3,"mandarin.jpeg")};
		FruitXML fruitXML=new FruitXML();
		fruitXML.writefruitsToXMLFile(fruits);
		
	}

	

}
