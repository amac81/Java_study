package model.entities;

public class ConcreteScanner extends Device implements Scanner{

public ConcreteScanner() {}
	
	public ConcreteScanner(String brand, String model, String serialNumber) 
	{
		super(brand, model, serialNumber);
	}
	
	@Override
	public String scan() {
		return "ConcreteScanner: scanning....";		
	}

	@Override
	public void processDoc(String doc) {
		System.out.println("ConcreteScanner: Processing Doc....: " + doc);		
	}

}
