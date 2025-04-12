import java.util.*;

class Process {
    int pid, burstTime, priority, remainingTime;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

public class RoundRobinScheduler {
    static Process head = null;
    static Scanner sc = new Scanner(System.in);

    static void addProcess(int pid, int burstTime, int priority) {
        Process newNode = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
    }

    static void removeProcess(int pid) {
        if (head == null) return;
        Process curr = head, prev = null;
        do {
            if (curr.pid == pid) {
                if (prev == null) {
                    if (curr.next == head) head = null;
                    else {
                        Process tail = head;
                        while (tail.next != head) tail = tail.next;
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    static void simulate(int quantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }
        Process curr = head;
        int time = 0, totalWT = 0, totalTAT = 0, n = 0;
        while (true) {
            boolean done = true;
            Process temp = head;
            do {
                if (temp.remainingTime > 0) {
                    done = false;
                    if (temp.remainingTime > quantum) {
                        time += quantum;
                        temp.remainingTime -= quantum;
                    } else {
                        time += temp.remainingTime;
                        totalWT += time - temp.burstTime;
                        totalTAT += time;
                        temp.remainingTime = 0;
                        removeProcess(temp.pid);
                    }
                }
                temp = temp.next;
            } while (temp != head);
            if (done) break;
        }
        System.out.println("Average Waiting Time: " + (totalWT / 3.0));
        System.out.println("Average Turnaround Time: " + (totalTAT / 3.0));
    }

    static void display() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("PID: " + temp.pid + ", Burst: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        System.out.println("Enter number of processes:");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter Burst Time and Priority for Process " + i + ":");
            addProcess(i, sc.nextInt(), sc.nextInt());
        }
        System.out.println("Initial Queue:");
        display();
        System.out.println("Enter time quantum:");
        int quantum = sc.nextInt();
        simulate(quantum);
    }
}
