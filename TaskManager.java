


// These import statements bring in the necessary classes for input/output 
// and handling exceptions in the program.

    import java.util.ArrayList;
    import java.util.InputMismatchException;
    import java.util.Scanner;

// This class represents a task with a description and a completion status.


class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markComplete() {
        isCompleted = true;
    }
}


// This class manages a list of tasks and provides methods to add, list, 
// mark as complete, and delete tasks.


public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added: " + description);
    }

    public void listTasks() {
        System.out.println("Task List:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isCompleted() ? "[X]" : "[ ]";
            System.out.println(status + " " + (i + 1) + ". " + task.getDescription());
        }
    }

    public void markTaskComplete(int index) {
        if (index >= 1 && index <= tasks.size()) {
            Task task = tasks.get(index - 1);
            task.markComplete();
            System.out.println("Marked task as complete: " + task.getDescription());
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            Task task = tasks.remove(index - 1);
            System.out.println("Deleted task: " + task.getDescription());
        } else {
            System.out.println("Invalid task number.");
        }
    }


/* 

   The main method is the entry point of the program. 
   It creates a TaskManager object, sets up a menu-driven interface. 
   Allows the user to interact with the task manager by adding, listing, 
   marking as complete, and deleting tasks.
 
*/
    public static void main(String[] args) {
    TaskManager taskManager = new TaskManager();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("\n ");
        System.out.println("\nWelcome to Sophia Task Manager");
        System.out.println("      by Ramon Araujo ;)");
        System.out.println("\n ---------- Menu: ------------");
        System.out.println("\n ");
        System.out.println("1. Add Task");
        System.out.println("2. List Tasks");
        System.out.println("3. Mark Task as Complete");
        System.out.println("4. Delete Task");
        System.out.println("5. Quit");
        System.out.println("\n -----------------------------");
        System.out.println("\n ");
        System.out.print("Enter your choice: ");

        int choice;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid option.");
            scanner.next(); // Consume the invalid input
            continue;
        }
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.print("Enter task description: ");
                String description = scanner.nextLine();
                taskManager.addTask(description);
                break;
            case 2:
                taskManager.listTasks();
                break;
            case 3:
                System.out.print("Enter the task number to mark as complete: ");
                int index;
                try {
                    index = scanner.nextInt();
                    taskManager.markTaskComplete(index);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid task number.");
                    scanner.next(); // Consume the invalid input
                }
                break;
            case 4:
                System.out.print("Enter the task number to delete: ");
                try {
                    index = scanner.nextInt();
                    taskManager.deleteTask(index);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid task number.");
                    scanner.next(); // Consume the invalid input
                }
                break;
            case 5:
                System.out.println("Adios - Goodbye!");
                scanner.close();
                return; // Exiting the program gracefully
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}
}
/*  By Ramon Alberto Araujo Espinosa - www.esramon.com  */


