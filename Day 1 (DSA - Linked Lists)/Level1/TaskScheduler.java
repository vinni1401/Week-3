import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

public class TaskScheduler {
    static Task head = null;
    static Task tail = null;
    static Task current = null;

    public static void addTaskAtEnd(int id, String name, int priority, String date) {
        Task newTask = new Task(id, name, priority, date);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
        }
    }

    public static void addTaskAtBeginning(int id, String name, int priority, String date) {
        Task newTask = new Task(id, name, priority, date);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    public static void addTaskAtPosition(int id, String name, int priority, String date, int pos) {
        if (pos == 1) {
            addTaskAtBeginning(id, name, priority, date);
            return;
        }

        Task newTask = new Task(id, name, priority, date);
        Task temp = head;
        int count = 1;

        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    public static void removeTaskById(int id) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task temp = head;
        Task prev = tail;

        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }

                if (current == temp) {
                    current = current.next;
                }

                System.out.println("Task removed.");
                return;
            }

            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found.");
    }

    public static void viewCurrentTask() {
        if (current == null) {
            if (head == null) {
                System.out.println("No tasks scheduled.");
                return;
            }
            current = head;
        }

        System.out.println("Current Task: ID=" + current.taskId + ", Name=" + current.taskName + ", Priority=" + current.priority + ", Due Date=" + current.dueDate);
        current = current.next;
    }

    public static void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public static void searchByPriority(int p) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == p) {
                System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + p);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add task at beginning");
            System.out.println("2. Add task at end");
            System.out.println("3. Add task at specific position");
            System.out.println("4. Remove task by ID");
            System.out.println("5. View current task and move to next");
            System.out.println("6. Display all tasks");
            System.out.println("7. Search tasks by priority");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            int id, priority, pos;
            String name, dueDate;

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    dueDate = sc.nextLine();
                    addTaskAtBeginning(id, name, priority, dueDate);
                    break;

                case 2:
                    System.out.print("Enter Task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    dueDate = sc.nextLine();
                    addTaskAtEnd(id, name, priority, dueDate);
                    break;

                case 3:
                    System.out.print("Enter Task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    dueDate = sc.nextLine();
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    addTaskAtPosition(id, name, priority, dueDate, pos);
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    id = sc.nextInt();
                    removeTaskById(id);
                    break;

                case 5:
                    viewCurrentTask();
                    break;

                case 6:
                    displayAllTasks();
                    break;

                case 7:
                    System.out.print("Enter priority to search: ");
                    priority = sc.nextInt();
                    searchByPriority(priority);
                    break;

                case 0:
                    System.out.println("Exiting Task Scheduler.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
