package pl.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import pl.fruit.Fruit;

public class FruitXML {

     private static final String FILE_DIRECTORY = "/src/main/resources/xmlfruitData.txt";
     private static String fileSystemDirection = System.getProperty("user.dir")
	       + FILE_DIRECTORY;
     private ArrayList<Fruit> arrayfruit;
     private static FruitXML fruitXML;



     public static FruitXML getInstance() {
	  if (fruitXML == null)
	       fruitXML = new FruitXML();
	  return fruitXML;
     }



     public void writefruitsToXMLFile(Fruit[] fruits) {
	  try {
	       FileOutputStream outfruit = new FileOutputStream(new File(
			 fileSystemDirection));
	       XMLEncoder xmlfruitEncoder = new XMLEncoder(outfruit);

	       for (Fruit f : fruits) {
		    xmlfruitEncoder.writeObject(f);
	       }
	       xmlfruitEncoder.close();
	       outfruit.close();
	  } catch (IOException e) {
	       e.printStackTrace();
	  }

     }



     public void readfruitsFromXMLFile() {

	  arrayfruit = new ArrayList<Fruit>();

	  try {
	       FileInputStream outfruit = new FileInputStream(new File(
			 fileSystemDirection));
	       XMLDecoder xmlfruitDecoder = new XMLDecoder(outfruit);

	       try {
		    while (true) {
			 arrayfruit.add((Fruit) xmlfruitDecoder.readObject());
		    }
	       } catch (ArrayIndexOutOfBoundsException e) {
	       } finally {
		    xmlfruitDecoder.close();
	       }

	  } catch (IOException e) {
	       e.printStackTrace();
	  }
     }



     public ArrayList<Fruit> getArrayfruit() {
	  if (arrayfruit == null)
	       System.out.println("lista pusta");
	  return arrayfruit;
     }

}
