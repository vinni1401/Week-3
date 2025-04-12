import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;

    Student(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentLinkedList {
    static Student head = null;

    public static void addAtBeginning(Student newStudent) {
        newStudent.next = head;
        head = newStudent;
    }

    public static void addAtEnd(Student newStudent) {
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public static void addAtPosition(Student newStudent, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newStudent);
            return;
        }
        Student temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public static void deleteByRollNo(int rollNo) {
        if (head == null) return;
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public static void searchByRollNo(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll No " + rollNo + " not found.");
    }

    public static void updateGrade(int rollNo, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Roll number not found.");
    }

    public static void displayAll() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1.Add at Beginning\n2.Add at End\n3.Add at Position\n4.Delete by Roll No\n5.Search by Roll No\n6.Update Grade\n7.Display All\n0.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Roll No, Name, Age, Grade: ");
                    int roll = sc.nextInt();
                    String name = sc.next();
                    int age = sc.nextInt();
                    char grade = sc.next().charAt(0);
                    Student newStudent = new Student(roll, name, age, grade);
                    if (choice == 1) addAtBeginning(newStudent);
                    else if (choice == 2) addAtEnd(newStudent);
                    else {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        addAtPosition(newStudent, pos);
                    }
                    break;
                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    deleteByRollNo(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Roll No to search: ");
                    searchByRollNo(sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Roll No and new Grade: ");
                    int r = sc.nextInt();
                    char g = sc.next().charAt(0);
                    updateGrade(r, g);
                    break;
                case 7:
                    displayAll();
                    break;
            }
        } while (choice != 0);
        sc.close();
    }
}
