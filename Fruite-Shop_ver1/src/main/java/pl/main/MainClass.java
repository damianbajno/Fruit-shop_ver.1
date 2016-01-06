package pl.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import pl.frame.ShopFrame;

public class MainClass {

     public static void main(String args[]) {
	
	  EventQueue.invokeLater(new Runnable() {

	       @Override
	       public void run() {
		    JFrame shopFrame = new ShopFrame();

	       }
	  
	  });
	  
     }
     
}
