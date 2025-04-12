import java.util.Scanner;

public class RotationPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) left = mid + 1;
            else right = mid;
        }
        System.out.println("Rotation point index: " + left);
    }
}
