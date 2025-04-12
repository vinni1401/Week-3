public class BubbleSortMarks {
    public static void main(String[] args) {
        int[] marks = {45, 32, 89, 76, 12};
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        for (int i = 0; i < n; i++) System.out.print(marks[i] + " ");
    }
}
