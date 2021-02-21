package appointment;
import java.time.LocalDateTime;

public class Appointment {
	private final String id;
	private LocalDateTime appointmentDate;
	private String description;
	
	public Appointment(String id, LocalDateTime appointmentDate, String description) {
		if (id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		if (appointmentDate == null || appointmentDate.isBefore(LocalDateTime.now())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		if (description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	public String getId() {
		return id;
	}
		
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}
	public String getDescription() {
		return description;
	}
}
