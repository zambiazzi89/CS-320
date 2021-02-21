package appointment;

import java.time.LocalDateTime;
import java.util.Hashtable;

public class AppointmentService {
	// Create hash table to store tasks
	Hashtable<String, Appointment> appointments = new Hashtable<String, Appointment>();
	
	public void addAppointment(String id, LocalDateTime appointmentDate, String description) {
		if (appointments.get(id) != null) {
			throw new IllegalArgumentException("This appointment ID already exists");
		}
		Appointment appointment = new Appointment(id, appointmentDate, description);
		appointments.put(id, appointment);
	}
	public void deleteAppointment(String id) {
		if (appointments.get(id) == null) {
			throw new IllegalArgumentException("Appointment ID does not exist");
		}			
		appointments.remove(id);
	}
	public Hashtable<String, Appointment> getAppointments() {
		return appointments;
	}
}
