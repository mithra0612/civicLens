
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo {

    User user;
    List<Task> tasks;
    List<Task> completed;

    ToDo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User ID, Name, and Password: ");
        int user_id = sc.nextInt();
        String user_name = sc.next();
        String password = sc.next();

        this.user = new User(user_id, user_name, password);
        this.tasks = new ArrayList<>();
        this.completed = new ArrayList<>();
    }

    public void displayTask() {
        if (tasks.isEmpty()) {
            System.out.println("No pending tasks.");
        }
        for (Task task : tasks) {
            System.out.println(task + "\n---------");
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task " + task.task_id + " added.");
    }

    public void deleteTask(int task_id) {
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).task_id == task_id) {
                Task t = tasks.remove(i);
                completed.remove(i);
                t.completed = true;
                System.out.println("Task " + task_id + " is deleted.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task ID not found.");
        }
    }

    public void completedTask(int task_id) {
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).task_id == task_id) {
                Task t = tasks.remove(i);
                t.completed = true;
                completed.add(t);
                System.out.println("Task " + task_id + " marked as complete.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task ID not found.");
        }
    }
}
