package pl.damian.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainClass {
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame shopFrame=new ShopFrame();
				
			}
		});
	}
}
