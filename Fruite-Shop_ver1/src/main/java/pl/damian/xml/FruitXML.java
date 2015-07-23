package pl.damian.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import pl.damian.main.Fruite;

public class FruitXML {
	private static String fileDirection = "/home/damian/git/Fruite-Shop_ver.1/Fruite-Shop_ver1/src/main/resources/xmlFruiteData.txt";
	private ArrayList<Fruite> arrayFruite;
	private static FruitXML fruiteXML;
	
	public static FruitXML getInstance(){
		if (fruiteXML==null)
		 fruiteXML=new FruitXML();
		return fruiteXML;
	}
	
	public void writeFruitesToXMLFile(Fruite[] fruites) {
		try {
			FileOutputStream outFruite = new FileOutputStream(new File(
					fileDirection));
			XMLEncoder xmlFruiteEncoder = new XMLEncoder(outFruite);

			for (Fruite f : fruites) {
				xmlFruiteEncoder.writeObject(f);
			}
			xmlFruiteEncoder.close();
			outFruite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void readFruitesFromXMLFile() {
		arrayFruite = new ArrayList<Fruite>();

		try {
			FileInputStream outFruite = new FileInputStream(new File(fileDirection));
			XMLDecoder xmlFruiteDecoder = new XMLDecoder(outFruite);

			try {
				while (true) {
					arrayFruite.add((Fruite) xmlFruiteDecoder.readObject());
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			} finally {
				xmlFruiteDecoder.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Fruite> getArrayFruite() {
		if (arrayFruite==null)
			System.out.println("lista pusta");
			return arrayFruite;
	}

	
}
