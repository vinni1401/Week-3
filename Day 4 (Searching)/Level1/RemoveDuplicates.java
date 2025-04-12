import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!set.contains(c)) {
                result.append(c);
                set.add(c);
            }
        }
        System.out.println(result.toString());
        sc.close();
    }
}
