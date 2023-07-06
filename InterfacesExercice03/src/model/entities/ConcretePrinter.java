package model.entities;

public class ConcretePrinter extends Device implements Printer {
	
	public ConcretePrinter() {}
	
	public ConcretePrinter(String brand, String model, String serialNumber) 
	{
		super(brand, model, serialNumber);
	}

	@Override
	public void print(String doc) {
		System.out.println("ConcretePrinter: printing....: " + doc);		
	}

	@Override
	public void processDoc(String doc) {
		System.out.println("ConcretePrinter: Processing Doc....: " + doc);		
	}

}
