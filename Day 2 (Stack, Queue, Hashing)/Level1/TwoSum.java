import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];
            if (map.containsKey(comp)) {
                System.out.println("Indices: " + map.get(comp) + ", " + i);
                return;
            }
            map.put(arr[i], i);
        }
        System.out.println("No valid pair found.");
    }
}
