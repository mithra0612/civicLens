import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Welcome to ToDo App Login ---");
        ToDo app = new ToDo();
        
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- To-Do Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Display Pending Tasks");
            System.out.println("3. Complete a Task");
            System.out.println("4. Delete a Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Task Description: ");
                    String desc = sc.nextLine();
                    app.addTask(new Task(id, desc, false));
                    break;

                case 2:
                    System.out.println("\n--- Current Tasks ---");
                    app.displayTask();
                    break;

                case 3:
                    System.out.print("Enter Task ID to complete: ");
                    int compId = sc.nextInt();
                    app.completedTask(compId);
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int delId = sc.nextInt();
                    app.deleteTask(delId);
                    break;

                case 5:
                    running = false;
                    System.out.println("Goodbye, " + app.user.user_name + "!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}