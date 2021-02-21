package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.TaskService;

class TaskServiceTest {

	TaskService taskService = new TaskService();
	@Test
	void testAddTask() {
		// Add two tasks and check if they have been added correctly
		taskService.addTask("1", "First Task", "First task to be tested");
		taskService.addTask("2", "Second Task", "Second task to be tested");
		assertTrue(taskService.getTasks().get("1").getId().equals("1"));
		assertTrue(taskService.getTasks().get("1").getName().equals("First Task"));
		assertTrue(taskService.getTasks().get("1").getDescription().equals("First task to be tested"));
		assertTrue(taskService.getTasks().get("2").getId().equals("2"));
		assertTrue(taskService.getTasks().get("2").getName().equals("Second Task"));
		assertTrue(taskService.getTasks().get("2").getDescription().equals("Second task to be tested"));
	}
	
	@Test
	void testAddTaskExistingId() {
		// Tests if throws when using existing Id	
		taskService.addTask("1", "First Task", "First task to be tested");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("1", "Another Task", "Another task to be tested");
		});
	}
	
	@Test
	void testDeleteTask() {
		// Add a task, remove it, confirm that list is empty
		taskService.addTask("1", "First Task", "First task to be tested");
		taskService.deleteTask("1");
		assertTrue(taskService.getTasks().isEmpty());
	}
	@Test
	void testDeleteTaskIdDoesNotExist() {
		// Tests if throws when using ID that does not exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("1");
		});
	}
	
	@Test
	void testUpdateTaskDoesNotExist() {
		taskService.addTask("1", "First Task", "First task to be tested");
		// Test if will throw when ID does not exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTask("2", "First Task Update", "Update the first task to be tested");
		});
	}
	@Test
	void testUpdateTask() {
		taskService.addTask("1", "First Task", "First task to be tested");
		taskService.updateTask("1", "First Task Update", "Update the first task to be tested");
		// Verify that task has been updated
		assertTrue(taskService.getTasks().get("1").getName().equals("First Task Update"));
		assertTrue(taskService.getTasks().get("1").getDescription().equals("Update the first task to be tested"));
	}

}
