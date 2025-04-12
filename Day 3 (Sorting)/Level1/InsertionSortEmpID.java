public class InsertionSortEmpID {
    public static void main(String[] args) {
        int[] empIDs = {104, 102, 109, 101, 108};
        int n = empIDs.length;
        for (int i = 1; i < n; i++) {
            int key = empIDs[i], j = i - 1;
            while (j >= 0 && empIDs[j] > key) {
                empIDs[j + 1] = empIDs[j];
                j--;
            }
            empIDs[j + 1] = key;
        }
        for (int i = 0; i < n; i++) System.out.print(empIDs[i] + " ");
    }
}
