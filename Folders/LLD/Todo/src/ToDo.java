
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo {

    User user;
    List<Task> tasks;
    List<Task> completed; 

    ToDo() {
        int user_id;
        String user_name;
        String password;
        Scanner sc = new Scanner(System.in);
        user_id = sc.nextInt();
        user_name = sc.next();
        password = sc.next();
        user = new User(user_id, user_name, password);
        tasks = new ArrayList<>();
        completed = new ArrayList<>();
        sc.close();
    }

    public void displayTask() {
        for (Task task : tasks) {
            System.out.println(task.toString());
            System.out.println("---------");
        }
    }

    public void displayCompletedTask() {
        for (Task task : completed) {
            System.out.println(task.toString());
            System.out.println("---------");
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task " + task.task_id + " added.");
    }

    public void deleteTask(int task_id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).task_id == task_id) {
                tasks.remove(i);
                System.out.println("Task Deleted.");
                break;
            }
        }
    }

    public void completedTask(int task_id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).task_id == task_id) {
                tasks.get(i).completed = true;
                completed.add(tasks.get(i));
                tasks.remove(i);
                break;
            }
        }
    }
}




// To make this work, Main must provide data to the constructor
