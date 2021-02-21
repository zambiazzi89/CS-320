package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import appointment.Appointment;

class AppointmentTest {

	LocalDateTime argDate = LocalDateTime.parse("30.04.2021 09:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
	
	@Test
	void testAppointment() {
		Appointment appointment = new Appointment("1", argDate, "This is the first appointment");
		assertTrue(appointment.getId().equals("1"));
		assertTrue(appointment.getAppointmentDate().equals(LocalDateTime.parse("30.04.2021 09:00",
				DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))));
		assertTrue(appointment.getDescription().equals("This is the first appointment"));
	}

	@Test
	void testAppointmentIdNull() {
		// Test null Id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, argDate, "Create an Appointment to be tested");
		});
	}
	@Test
	void testAppointmentIdTooLong() {
		// Test Id with more than 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678901", argDate, "Create an Appointment to be tested");
		});
	}
	
	@Test
	void testAppointmentDateNull() {
		// Test null date
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1", null, "Create an Appointment to be tested");
		});
	}
	@Test
	void testAppointmentDateBeforeNow() {
		// Test argument date before current date
		LocalDateTime invalidArgDate = LocalDateTime.parse("01.01.2021 09:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1", invalidArgDate, "Create an Appointment to be tested");
		});
	}
	
	@Test
	void testAppointmentDescriptionNull() {
		// Test null description
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1", argDate, null);
		});
	}
	@Test
	void testAppointmentDescriptionTooLong() {
		// Test description with more than 50 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1", argDate, "123456789012345678901234567890123456789012345678901");
		});
	}
}
