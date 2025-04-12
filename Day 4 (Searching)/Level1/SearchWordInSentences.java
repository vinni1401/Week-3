import java.util.Scanner;

public class SearchWordInSentences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] sentences = new String[n];
        System.out.println("Enter sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }

        System.out.print("Enter word to search: ");
        String word = sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (sentences[i].contains(word)) {
                System.out.println("Found in: " + sentences[i]);
                return;
            }
        }
        System.out.println("Not Found");
    }
}
