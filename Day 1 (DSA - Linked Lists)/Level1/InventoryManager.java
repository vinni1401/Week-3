import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InventoryManager {
    static Item head = null;

    public static void addItemAtBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    public static void addItemAtEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
            return;
        }

        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newItem;
    }

    public static void addItemAtPosition(String name, int id, int qty, double price, int pos) {
        if (pos == 1) {
            addItemAtBeginning(name, id, qty, price);
            return;
        }

        Item newItem = new Item(name, id, qty, price);
        Item temp = head;
        int count = 1;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    public static void removeItemById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        } else {
            System.out.println("Item not found.");
        }
    }

    public static void updateQuantityById(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public static void searchByIdOrName(int id, String name) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemId == id || temp.itemName.equalsIgnoreCase(name)) {
                System.out.println("ID: " + temp.itemId + ", Name: " + temp.itemName + ", Qty: " + temp.quantity + ", Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No matching item found.");
    }

    public static void calculateTotalInventoryValue() {
        Item temp = head;
        double total = 0;

        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: ₹" + total);
    }

    public static void sortByNameOrPrice(boolean byName, boolean ascending) {
        if (head == null || head.next == null) return;

        Item sorted = null;

        while (head != null) {
            Item curr = head;
            head = head.next;

            if (sorted == null || compare(curr, sorted, byName, ascending)) {
                curr.next = sorted;
                sorted = curr;
            } else {
                Item temp = sorted;
                while (temp.next != null && !compare(curr, temp.next, byName, ascending)) {
                    temp = temp.next;
                }
                curr.next = temp.next;
                temp.next = curr;
            }
        }

        head = sorted;
        System.out.println("Inventory sorted.");
    }

    private static boolean compare(Item a, Item b, boolean byName, boolean ascending) {
        if (byName) {
            return ascending ? a.itemName.compareToIgnoreCase(b.itemName) < 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            return ascending ? a.price < b.price : a.price > b.price;
        }
    }

    public static void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        Item temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.itemId + ", Name: " + temp.itemName + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, id, qty, pos;
        double price;
        String name;

        do {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search Item by ID or Name");
            System.out.println("7. Calculate Total Inventory Value");
            System.out.println("8. Sort by Name Asc/Desc");
            System.out.println("9. Sort by Price Asc/Desc");
            System.out.println("10. Display Inventory");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Item Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    price = sc.nextDouble();

                    if (choice == 1) addItemAtBeginning(name, id, qty, price);
                    else if (choice == 2) addItemAtEnd(name, id, qty, price);
                    else {
                        System.out.print("Enter Position: ");
                        pos = sc.nextInt();
                        addItemAtPosition(name, id, qty, price, pos);
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to remove: ");
                    id = sc.nextInt();
                    removeItemById(id);
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    qty = sc.nextInt();
                    updateQuantityById(id, qty);
                    break;

                case 6:
                    System.out.print("Enter ID (enter -1 if unknown): ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name (enter blank if unknown): ");
                    name = sc.nextLine();
                    searchByIdOrName(id, name);
                    break;

                case 7:
                    calculateTotalInventoryValue();
                    break;

                case 8:
                    System.out.print("Sort Ascending? (true/false): ");
                    boolean asc1 = sc.nextBoolean();
                    sortByNameOrPrice(true, asc1);
                    break;

                case 9:
                    System.out.print("Sort Ascending? (true/false): ");
                    boolean asc2 = sc.nextBoolean();
                    sortByNameOrPrice(false, asc2);
                    break;

                case 10:
                    displayInventory();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
