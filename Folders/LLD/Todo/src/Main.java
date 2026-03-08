public class Main {
    public static void main(String[] args) {
        System.out.println("Enter ID, Name, and Password to start:");
        ToDo madhu = new ToDo();
        
        // Example usage to test your methods:
        madhu.addTask(new Task(1, "Fix Java Errors", false));
        madhu.displayTask();
        madhu.completedTask(1);
        System.out.println("\n--- Completed List ---");
        madhu.displayCompletedTask();
    }
}