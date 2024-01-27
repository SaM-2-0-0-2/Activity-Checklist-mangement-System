import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Task class to represent each task in the checklist
class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return "[" + (isDone ? "Done" : "Not Done") + "] " + description;
    }
}

// Checklist class to manage a list of tasks
class Checklist {
    private List<Task> tasks;

    public Checklist() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask);
    }

    public void markTaskAsDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
            System.out.println("Task marked as done: " + tasks.get(index));
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the checklist.");
        } else {
            System.out.println("Checklist:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}

public class ChecklistManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Checklist checklist = new Checklist();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    checklist.addTask(taskDescription);
                    break;
                case 2:
                    System.out.print("Enter the index of the task to mark as done: ");
                    int taskIndex = scanner.nextInt();
                    checklist.markTaskAsDone(taskIndex - 1); // Adjust for 0-based indexing
                    break;
                case 3:
                    checklist.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting Checklist Manager. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }
    }
}
