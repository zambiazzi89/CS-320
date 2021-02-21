package task;


public class Task {
	private final String id;
	private String name;
	private String description;
	
	public Task(String id, String name, String description) {
		if (id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		if (name == null || name.length()>20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		if (description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
		
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public void updateName(String newName) {
		if (newName == null || newName.length()>20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		this.name = newName;
	}
	public void updateDescription(String newDescription) {
		if (newDescription == null || newDescription.length()>50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.description = newDescription;
	}
}
