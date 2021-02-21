package contact;

public class Contact {
	private final String id;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String number, String address) {
		if (id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if (number == null || number.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
	}
	public String getId() {
		return id;
	}
		
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getNumber() {
		return number;
	}
	public String getAddress() {
		return address;
	}
	
	public void updateFirstName(String newFirstName) {
		if (newFirstName == null || newFirstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = newFirstName;
	}
	public void updateLastName(String newLastName) {
		if (newLastName == null || newLastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = newLastName;
	}
	public void updateNumber(String newNumber) {
		if (newNumber == null || newNumber.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		this.number = newNumber;
	}
	public void updateAddress(String newAddress) {
		if (newAddress == null || newAddress.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = newAddress;
	}
}
