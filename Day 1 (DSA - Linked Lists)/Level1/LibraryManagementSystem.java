import java.util.*;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagementSystem {
    Book head = null, tail = null;

    public void addBook(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else if (position == 1) {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        } else {
            Book temp = head;
            int count = 1;
            while (temp.next != null && count < position - 1) {
                temp = temp.next;
                count++;
            }
            newBook.next = temp.next;
            newBook.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newBook;
            } else {
                tail = newBook;
            }
            temp.next = newBook;
        }
        System.out.println("Book added successfully.");
    }

    public void removeBook(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    public void searchBook(String keyword) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)) {
                System.out.println("Found Book - ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No book found with the given keyword.");
        }
    }

    public void updateAvailability(int bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                System.out.println("Book availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManagementSystem lib = new LibraryManagementSystem();
        while (true) {
            System.out.println("\n1. Add Book\n2. Remove Book\n3. Search Book\n4. Update Availability\n5. Display Forward\n6. Display Backward\n7. Count Books\n8. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Available (true/false): ");
                    boolean available = sc.nextBoolean();
                    System.out.print("Position to insert (1 for beginning): ");
                    int pos = sc.nextInt();
                    lib.addBook(title, author, genre, bookId, available, pos);
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();
                    lib.removeBook(removeId);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Enter title or author to search: ");
                    String keyword = sc.nextLine();
                    lib.searchBook(keyword);
                    break;
                case 4:
                    System.out.print("Enter Book ID to update: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new availability (true/false): ");
                    boolean status = sc.nextBoolean();
                    lib.updateAvailability(updateId, status);
                    break;
                case 5:
                    lib.displayForward();
                    break;
                case 6:
                    lib.displayBackward();
                    break;
                case 7:
                    lib.countBooks();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
