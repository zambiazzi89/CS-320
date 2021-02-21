package task;
import java.util.Hashtable;

public class TaskService {
	// Create hash table to store tasks
		Hashtable<String, Task> tasks = new Hashtable<String, Task>();
		
		public void addTask(String id, String name, String description) {
			if (tasks.get(id) != null) {
				throw new IllegalArgumentException("This task ID already exists");
			}
			Task task = new Task(id, name, description);
			tasks.put(id, task);
		}
		public void deleteTask(String id) {
			if (tasks.get(id) == null) {
				throw new IllegalArgumentException("Task ID does not exist");
			}			
			tasks.remove(id);
		}
		public void updateTask(String id, String name, String description) {
			if (tasks.get(id) == null) {
				throw new IllegalArgumentException("Task ID does not exist");
			}
			tasks.get(id).updateName(name);
			tasks.get(id).updateDescription(description);
		}
		public Hashtable<String, Task> getTasks() {
			return tasks;
		}
}
