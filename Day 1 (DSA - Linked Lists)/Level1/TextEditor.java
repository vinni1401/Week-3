import java.util.*;

class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
    }
}

public class TextEditor {
    private TextState current;
    private int size = 0;
    private final int MAX_SIZE = 10;

    public void addState(String content) {
        TextState newState = new TextState(content);
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }
        current = newState;
        size++;
        trimHistory();
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo available.");
        }
    }

    public void showCurrent() {
        System.out.println("Current: " + (current != null ? current.content : "Empty"));
    }

    private void trimHistory() {
        TextState temp = current;
        int count = 1;
        while (temp.prev != null) {
            temp = temp.prev;
            count++;
            if (count > MAX_SIZE) {
                temp.prev.next = null;
                temp.prev = null;
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        while (true) {
            System.out.println("1. Add Text\n2. Undo\n3. Redo\n4. Show Current\n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    editor.addState(sc.nextLine());
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.showCurrent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
