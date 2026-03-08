class Task {
    int task_id;
    String description;
    boolean completed;

    Task(int task_id, String description, boolean completed) {
        this.task_id = task_id;
        this.description = description;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task id: " + task_id + "\nDescription: " + description + "\nCompleted: " + completed;
    }
}
