package application;

import java.util.Locale;

import model.entities.ConcretePrinter;
import model.entities.ConcreteScanner;
import model.entities.MultifunctionDevice;

/*
 * 
 * A class can implement more than one interface.
 * 
 * This example does not represent multiple inheritance!
 * There is no reuse in the relationship between the MultifunctionDevice class and the Scanner and Printer interfaces. 	
 * 
 * */

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		ConcretePrinter cp = new ConcretePrinter("HP", "Desket 1200", "abcd12345");
		ConcreteScanner cs = new ConcreteScanner("Epson", "CX10", "abcd54321");
		
		cp.print("Hello this a Doc to print");
		cp.processDoc("Email to process");
	
		System.out.println();
		cs.processDoc("process the email");
		System.out.println(cs.scan());		

		MultifunctionDevice mfd = new MultifunctionDevice("Xerox", "Desket 1200", "abcd12345"); 
		
		System.out.println();
		
		mfd.print("Doc2 to print");
		mfd.processDoc("Doc to process");
		System.out.println(mfd.scan());
	
	}
}
