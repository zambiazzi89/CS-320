package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import contact.ContactService;

public class ContactServiceTest {
	ContactService contactService = new ContactService();
	@Test
	void testAddContact() {
		// Add two contacts and check if they have been added correctly
		contactService.addContact("1", "Diego", "Zambiazzi", "8023991111", "NYC");
		contactService.addContact("2", "Diego2", "Zambiazzi2", "8023991112", "Brooklyn");
		assertTrue(contactService.getContacts().get("1").getId().equals("1"));
		assertTrue(contactService.getContacts().get("1").getFirstName().equals("Diego"));
		assertTrue(contactService.getContacts().get("1").getLastName().equals("Zambiazzi"));
		assertTrue(contactService.getContacts().get("1").getNumber().equals("8023991111"));
		assertTrue(contactService.getContacts().get("1").getAddress().equals("NYC"));
		assertTrue(contactService.getContacts().get("2").getId().equals("2"));
		assertTrue(contactService.getContacts().get("2").getFirstName().equals("Diego2"));
		assertTrue(contactService.getContacts().get("2").getLastName().equals("Zambiazzi2"));
		assertTrue(contactService.getContacts().get("2").getNumber().equals("8023991112"));
		assertTrue(contactService.getContacts().get("2").getAddress().equals("Brooklyn"));
	}
	
	@Test
	void testAddContactExistingId() {
		// Tests if throws when using existing Id	
		contactService.addContact("1", "Diego", "Zambiazzi", "8023991111", "NYC");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact("1", "Diego", "Zambiazzi", "8023991111", "NYC");
		});
	}
	
	@Test
	void testDeleteContact() {
		// Add a contact, remove it, confirm that list is empty
		contactService.addContact("1", "Diego", "Zambiazzi", "8023991111", "NYC");
		contactService.deleteContact("1");
		assertTrue(contactService.getContacts().isEmpty());
	}
	@Test
	void testDeleteContactIdDoesNotExist() {
		// Tests if throws when using ID that does not exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact("1");
		});
	}
	
	@Test
	void testUpdateContactDoesNotExist() {
		contactService.addContact("1", "Diego", "Zambiazzi", "8023991111", "NYC");
		// Test if will throw when ID does not exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("2", "Diego", "Zambiazzi", "8023991111", "NYC");
		});
	}
	@Test
	void testUpdateContact() {
		contactService.addContact("1", "Diego", "Zambiazzi", "8023991111", "NYC");
		contactService.updateContact("1", "Diego2", "Zambiazzi2", "8023991112", "Brooklyn");
		// Verify that contact has been updated
		assertTrue(contactService.getContacts().get("1").getFirstName().equals("Diego2"));
		assertTrue(contactService.getContacts().get("1").getLastName().equals("Zambiazzi2"));
		assertTrue(contactService.getContacts().get("1").getNumber().equals("8023991112"));
		assertTrue(contactService.getContacts().get("1").getAddress().equals("Brooklyn"));
	}
}
