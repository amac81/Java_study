package model.entities;

public class MultifunctionDevice extends Device implements Printer, Scanner {
	
	public MultifunctionDevice(){}
	
	public MultifunctionDevice(String brand, String model, String serialNumber) {
		super(brand, model, serialNumber); 
	}
	

	@Override
	public void processDoc(String doc) {
		System.out.println("MultifunctionDevice: Processing Doc....: " + doc);
	}

	@Override
	public String scan() {
		return "MultifunctionDevice: scanning....";		
	}

	@Override
	public void print(String doc) {
		System.out.println("MultifunctionDevice: printing....: " + doc);		
	}

}
