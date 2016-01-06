package pl.Tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Tools {

     public static String replaceCommaWithDot(String price) {
	  price = price.replace(",", ".");
	  return price;
     }



     public static String getValueBetweenTwoStrings(String text,
	       String befourString, String afterString) {
	  Pattern pattern = Pattern.compile(befourString + "(\\w*)"
		    + afterString);
	  Matcher matcher = pattern.matcher(text);
	  if (matcher.find()) {
	       return matcher.group(1);
	  }
	  return null;
     }



     public static String getTwoDecimalValue(float price){
	     String priceString = String.valueOf(price);
	     char[] priceCharArray = priceString.toCharArray();
	     
	     StringBuilder stringBuilder=new StringBuilder();
	     
	     int a=0;
	     for (int i = 0; i < priceCharArray.length; i++) {
		  stringBuilder.append(priceCharArray[a]);
	       if (priceCharArray[a]=='.' && i<priceCharArray.length-2){
		    i=priceCharArray.length-3;
	       }
	       a++;
	  }
	     
	     return stringBuilder.toString();
		       
	}



     public static boolean isNumeric(String str) {
	  replaceCommaWithDot(str);
	  return str.matches("\\d+\\.?\\d*");
     }



     public static boolean isNumericIfNotShowMessage(String str) {
	  if (str.matches("\\d+")) {
	       Integer age = Integer.valueOf(str);
	       if (age < 120) {
		    return true;
	       } else {
		    JOptionPane.showMessageDialog(null,
			      "Wiek musi być poniżej 120 lat");
		    return false;
	       }
	  } else {
	       JOptionPane.showMessageDialog(null, "Wartość nie jest liczba");
	       return false;
	  }
     }



     public static boolean isText(String str) {
	  return str.matches("[a-zA-Z]*\\s*[a-zA-Z]*");
     }



     public static boolean isTextIfNotShowMessage(String str) {
	  System.out.println(str);
	  if (str.trim().matches("[a-zA-Z]+\\s*[-]*[a-zA-Z]*"))
	       return true;
	  else {
	       JOptionPane.showMessageDialog(null, "Wartość nie jest tekstem");
	       return false;
	  }
     }
}
