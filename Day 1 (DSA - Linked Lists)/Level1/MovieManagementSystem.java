import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev;
    Movie next;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

public class MovieManagementSystem {
    static Movie head = null;
    static Movie tail = null;

    public static void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public static void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public static void addMovieAtPosition(String title, String director, int year, double rating, int pos) {
        if (pos == 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        int count = 1;
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addMovieAtEnd(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
        }
    }

    public static void removeMovieByTitle(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Movie removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public static void searchByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " (" + temp.year + ") - Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public static void searchByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating >= rating) {
                System.out.println(temp.title + " (" + temp.year + ") - Directed by: " + temp.director);
            }
            temp = temp.next;
        }
    }

    public static void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    public static void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add movie at beginning");
            System.out.println("2. Add movie at end");
            System.out.println("3. Add movie at specific position");
            System.out.println("4. Remove movie by title");
            System.out.println("5. Search movie by director");
            System.out.println("6. Search movie by rating");
            System.out.println("7. Display all movies (Forward)");
            System.out.println("8. Display all movies (Reverse)");
            System.out.println("9. Update movie rating");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            String title, director;
            int year, pos;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    title = sc.nextLine();
                    System.out.print("Enter director: ");
                    director = sc.nextLine();
                    System.out.print("Enter year: ");
                    year = sc.nextInt();
                    System.out.print("Enter rating: ");
                    rating = sc.nextDouble();
                    addMovieAtBeginning(title, director, year, rating);
                    break;

                case 2:
                    System.out.print("Enter title: ");
                    title = sc.nextLine();
                    System.out.print("Enter director: ");
                    director = sc.nextLine();
                    System.out.print("Enter year: ");
                    year = sc.nextInt();
                    System.out.print("Enter rating: ");
                    rating = sc.nextDouble();
                    addMovieAtEnd(title, director, year, rating);
                    break;

                case 3:
                    System.out.print("Enter title: ");
                    title = sc.nextLine();
                    System.out.print("Enter director: ");
                    director = sc.nextLine();
                    System.out.print("Enter year: ");
                    year = sc.nextInt();
                    System.out.print("Enter rating: ");
                    rating = sc.nextDouble();
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    addMovieAtPosition(title, director, year, rating, pos);
                    break;

                case 4:
                    System.out.print("Enter title to remove: ");
                    title = sc.nextLine();
                    removeMovieByTitle(title);
                    break;

                case 5:
                    System.out.print("Enter director name: ");
                    director = sc.nextLine();
                    searchByDirector(director);
                    break;

                case 6:
                    System.out.print("Enter minimum rating: ");
                    rating = sc.nextDouble();
                    searchByRating(rating);
                    break;

                case 7:
                    displayForward();
                    break;

                case 8:
                    displayReverse();
                    break;

                case 9:
                    System.out.print("Enter movie title to update: ");
                    title = sc.nextLine();
                    System.out.print("Enter new rating: ");
                    rating = sc.nextDouble();
                    updateRating(title, rating);
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}
