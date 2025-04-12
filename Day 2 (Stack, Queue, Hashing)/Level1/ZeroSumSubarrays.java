import java.util.*;

public class ZeroSumSubarrays {
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                List<Integer> list = map.get(sum);
                for (int j = 0; j < list.size(); j++) {
                    System.out.println("Subarray: " + (list.get(j) + 1) + " to " + i);
                }
                list.add(i);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(sum, newList);
            }
        }
    }
}
