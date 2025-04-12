import java.util.Scanner;

public class Search2DMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements (row-wise sorted):");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();

        System.out.print("Enter target to search: ");
        int target = sc.nextInt();

        int left = 0, right = rows * cols - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int r = mid / cols, c = mid % cols;
            if (matrix[r][c] == target) {
                System.out.println("Found");
                return;
            } else if (matrix[r][c] < target) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println("Not Found");
    }
}
