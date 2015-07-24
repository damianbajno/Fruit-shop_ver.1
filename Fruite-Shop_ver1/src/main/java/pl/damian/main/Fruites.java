package pl.damian.main;

import java.util.ArrayList;
import java.util.Properties;

import pl.damian.xml.FruitXML;

public class Fruites {

	private ArrayList<Fruite> arrayFruite;
	private int fruiteNumberInList = -1;
	private StringBuilder language = new StringBuilder();

	public void setLanguage(StringBuilder language) {
		this.language = language;
	}

	public Fruites() {
		loadValues();
	}

	
	public Fruite next() {
		if (fruiteNumberInList < arrayFruite.size()) {
			fruiteNumberInList++;
			return arrayFruite.get(fruiteNumberInList);
		} else return new Fruite();
	}
		
	public boolean hasNext() {
		if (fruiteNumberInList < arrayFruite.size()) {
			return true;
		} else
			return false;
	}

	public int size() {
		return arrayFruite.size();
	}

	public void loadValues() {
		FruitXML fruitXML = FruitXML.getInstance();
		fruitXML.readFruitesFromXMLFile();
		arrayFruite = fruitXML.getArrayFruite();
		System.out.println(arrayFruite.get(0).getName());

	}
}
