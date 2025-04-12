import java.util.Arrays;
import java.util.Scanner;

public class ChallengeSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        boolean[] present = new boolean[n + 1];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > 0 && arr[i] <= n) present[arr[i]] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                System.out.println("First missing positive: " + i);
                break;
            }
        }
        Arrays.sort(arr);
        System.out.print("Enter target to search: ");
        int target = sc.nextInt();

        int left = 0, right = n - 1, index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                index = mid;
                break;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println("Target index: " + index);
    }
}
