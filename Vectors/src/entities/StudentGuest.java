package entities;

public class StudentGuest {
	private String name;

	public StudentGuest(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return name + ", " + email;
	}

}
