import java.util.*;

public class PairWithSum {
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (seen.contains(target - arr[i])) {
                System.out.println("Pair found: " + arr[i] + ", " + (target - arr[i]));
                return;
            }
            seen.add(arr[i]);
        }
        System.out.println("No pair found");
    }
}
