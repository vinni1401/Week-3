import java.util.Scanner;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sorted array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter sorted array:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter target element: ");
        int target = sc.nextInt();

        int first = -1, last = -1;
        int left = 0, right = n - 1;

        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        left = 0; right = n - 1;
    
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        if (first == -1) System.out.println("-1");
        else System.out.println("First: " + first + ", Last: " + last);
    }
}
