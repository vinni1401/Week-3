import java.util.Scanner;

public class FirstNegativeIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                System.out.println("First negative number index: " + i);
                return;
            }
        }
        System.out.println("-1");
    }
}
