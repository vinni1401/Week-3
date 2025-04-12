import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    Ticket(int id, String name, String movie, String seat, String time) {
        ticketId = id;
        customerName = name;
        movieName = movie;
        seatNumber = seat;
        bookingTime = time;
    }
}

public class TicketReservationSystem {
    static Ticket head = null;

    static void addTicket(int id, String name, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, name, movie, seat, time);
        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("Ticket booked successfully!");
    }

    static void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }
        Ticket curr = head, prev = null;
        do {
            if (curr.ticketId == id) {
                if (curr == head && curr.next == head)
                    head = null;
                else {
                    if (curr == head) {
                        Ticket last = head;
                        while (last.next != head)
                            last = last.next;
                        head = head.next;
                        last.next = head;
                    } else
                        prev.next = curr.next;
                }
                System.out.println("Ticket removed!");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
        System.out.println("Ticket ID not found.");
    }

    static void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        System.out.println("Booked Tickets:");
        do {
            System.out.println("ID: " + temp.ticketId + ", Name: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +
                    ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    static void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }
        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket found -> ID: " + temp.ticketId + ", Name: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +
                        ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No matching ticket found.");
    }

    static void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total Tickets: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Ticket\n2. Remove Ticket\n3. Display Tickets\n4. Search Ticket\n5. Count Tickets\n6. Exit");
            switch (sc.nextInt()) {
                case 1:
                    System.out.print("Enter ID, Name, Movie, Seat, Time: ");
                    addTicket(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    removeTicket(sc.nextInt());
                    break;
                case 3:
                    displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Name or Movie to search: ");
                    searchTicket(sc.next());
                    break;
                case 5:
                    countTickets();
                    break;
                case 6:
                    System.out.println("Exiting.");
                    return;
            }
        }
    }
}
