package pl.damian.xml;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import pl.damian.main.Fruite;

public class mainXML {

	

	public static void main(String args[]) {

		Fruite[] fruites = {
				new Fruite("pl", "Jabłko", 3,"apple.jpg"),
				new Fruite("pl", "Gruszka", 2,"pear.jpg") };
		FruitXML fruitXML=new FruitXML();
		fruitXML.writeFruitesToXMLFile(fruites);
		
	}

	

}
