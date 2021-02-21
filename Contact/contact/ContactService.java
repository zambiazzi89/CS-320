package contact;

import java.util.Hashtable;

public class ContactService {
	// Create hash table to store contacts
	Hashtable<String, Contact> contacts = new Hashtable<String, Contact>();
	
	public void addContact(String id, String firstName, String lastName, String number, String address) {
		if (contacts.get(id) != null) {
			throw new IllegalArgumentException("This contact ID already exists");
		}
		Contact contact = new Contact(id, firstName, lastName, number, address);
		contacts.put(id, contact);
	}
	public void deleteContact(String id) {
		if (contacts.get(id) == null) {
			throw new IllegalArgumentException("Contact ID does not exist");
		}			
		contacts.remove(id);
	}
	public void updateContact(String id, String firstName, String lastName, String number, String address) {
		if (contacts.get(id) == null) {
			throw new IllegalArgumentException("Contact ID does not exist");
		}
		contacts.get(id).updateFirstName(firstName);
		contacts.get(id).updateLastName(lastName);
		contacts.get(id).updateNumber(number);
		contacts.get(id).updateAddress(address);			
	}
	public Hashtable<String, Contact> getContacts() {
		return contacts;
	}
}
