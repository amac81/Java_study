package model.entities;

public abstract class Device  {

	private String brand;
	private String model;
	private String serialNumber;	
	
	public Device() {}

	public Device(String brand, String model, String serialNumber) {
		this.brand = brand;
		this.model = model;
		this.serialNumber = serialNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public abstract void processDoc (String doc);
	
}
