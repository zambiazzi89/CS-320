package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.AppointmentService;

class AppointmentServiceTest {

	AppointmentService appointmentService = new AppointmentService();
	LocalDateTime argDate1 = LocalDateTime.parse("30.04.2021 09:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
	LocalDateTime argDate2 = LocalDateTime.parse("01.05.2021 09:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
	@Test
	void testAddAppointment() {
		// Add two appointments and check if they have been added correctly
		appointmentService.addAppointment("1", argDate1, "First appointment to be tested");
		appointmentService.addAppointment("2", argDate2, "Second appointment to be tested");
		assertTrue(appointmentService.getAppointments().get("1").getId().equals("1"));
		assertTrue(appointmentService.getAppointments().get("1").getAppointmentDate().equals(LocalDateTime.parse("30.04.2021 09:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))));
		assertTrue(appointmentService.getAppointments().get("1").getDescription().equals("First appointment to be tested"));
		assertTrue(appointmentService.getAppointments().get("2").getId().equals("2"));
		assertTrue(appointmentService.getAppointments().get("2").getAppointmentDate().equals(LocalDateTime.parse("01.05.2021 09:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))));
		assertTrue(appointmentService.getAppointments().get("2").getDescription().equals("Second appointment to be tested"));
	}
	
	@Test
	void testAddAppointmentExistingId() {
		// Tests if throws when using existing Id	
		appointmentService.addAppointment("1", argDate1, "First appointment to be tested");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment("1", argDate2, "Another appointment to be tested");
		});
	}
	
	@Test
	void testDeleteAppointment() {
		// Add an appointment, remove it, confirm that list is empty
		appointmentService.addAppointment("1", argDate1, "First appointment to be tested");
		appointmentService.deleteAppointment("1");
		assertTrue(appointmentService.getAppointments().isEmpty());
	}
	@Test
	void testDeleteAppointmentIdDoesNotExist() {
		// Tests if throws when using ID that does not exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment("1");
		});
	}
}
