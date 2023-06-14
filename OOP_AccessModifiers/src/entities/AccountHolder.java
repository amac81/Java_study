package entities; //Class package

public class AccountHolder {
	private String name;
	private int age;
	private String vatIdentifierNumber;
	private String address;
	private String email;
	private String phoneNumber;

	public AccountHolder(String name, int age, String vatIdentifierNumber, String address, String email,
			String phoneNumber) {
		super();
		this.name = name;
		this.age = age;
		this.vatIdentifierNumber = vatIdentifierNumber;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public int birthday() {
		return age++;
	}

	public String getVatIdentifierNumber() {
		return vatIdentifierNumber;
	}

	public void setVatIdentifierNumber(String vatIdentifierNumber) {
		this.vatIdentifierNumber = vatIdentifierNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String toString() {
		return "AccountHolder [name=" + name + ", age=" + age + ", vatIdentifierNumber=" + vatIdentifierNumber
				+ ", address=" + address + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}

}
