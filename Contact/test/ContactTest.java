package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("1", "Diego", "Zambiazzi", "8023991111", "NYC");
		assertTrue(contact.getId().equals("1"));
		assertTrue(contact.getFirstName().equals("Diego"));
		assertTrue(contact.getLastName().equals("Zambiazzi"));
		assertTrue(contact.getNumber().equals("8023991111"));
		assertTrue(contact.getAddress().equals("NYC"));
	}
	
	@Test
	void testContactIdNull() {
		// Test null Id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Diego", "Zambiazzi", "8023991111", "NYC");
		});
	}
	@Test
	void testContactIdTooLong() {
		// Test Id with more than 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910", "Diego", "Zambiazzi", "8023991111", "NYC");
		});
	}
	@Test
	void testContactFirstNameNull() {
		// Test null First Name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "Zambiazzi", "8023991111", "NYC");
		});
	}
	@Test
	void testContactFirstNameTooLong() {
		// Test First Name with more than 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Diego678910", "Zambiazzi", "8023991111", "NYC");
		});
	}
	@Test
	void testContactLastNameNull() {
		// Test null Last Name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Diego", null, "8023991111", "NYC");
		});
	}
	@Test
	void testContactLastNameTooLong() {
		// Test Last Name with more than 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Diego", "Zambiazzi10", "8023991111", "NYC");
		});
	}
	@Test
	void testContactPhoneNull() {
		// Test null Phone
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Diego", "Zambiazzi10", null, "NYC");
		});
	}
	@Test
	void testContactPhoneTooShort() {
		// Test Phone with lengths different than 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Diego", "Zambiazzi", "802399111", "NYC");
		});
	}
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Diego", "Zambiazzi", "80239911111", "NYC");
		});
	}
	@Test
	void testContactAddressNull() {
		// Test null address
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Diego", "Zambiazzi", "8023991111", null);
		});
	}
	@Test
	void testContactAddressTooLong() {
		// Test address with length greater than 30 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Diego", "Zambiazzi", "8023991111", "This address has 31 characters.");
		});
	}
	
	@Test
	// Test updates
	void testUpdates() {
		Contact contact = new Contact("1", "Diego", "Zambiazzi", "8023991111", "NYC");
		contact.updateFirstName("Diego2");
		assertTrue(contact.getFirstName().equals("Diego2"));
		contact.updateLastName("Zambiazzi2");
		assertTrue(contact.getLastName().equals("Zambiazzi2"));
		contact.updateNumber("8023991112");
		assertTrue(contact.getNumber().equals("8023991112"));
		contact.updateAddress("Brooklyn");
		assertTrue(contact.getAddress().equals("Brooklyn"));
	}
}
