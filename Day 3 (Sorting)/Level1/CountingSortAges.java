public class CountingSortAges {
    public static void countingSort(int[] arr, int maxVal) {
        int[] count = new int[maxVal + 1];
        for (int i = 0; i < arr.length; i++) count[arr[i]]++;
        int index = 0;
        for (int i = 0; i <= maxVal; i++) {
            while (count[i]-- > 0) arr[index++] = i;
        }
    }

    public static void main(String[] args) {
        int[] ages = {14, 17, 10, 12, 15, 18, 11, 13};
        countingSort(ages, 18);
        for (int i = 0; i < ages.length; i++) System.out.print(ages[i] + " ");
    }
}
