import java.util.*;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) set.add(nums[i]);

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int curr = nums[i];
                int len = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                if (len > maxLen) maxLen = len;
            }
        }
        System.out.println("Longest sequence length: " + maxLen);
    }
}
