public class QuickSortProducts {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        int t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] prices = {400, 250, 120, 700, 310};
        quickSort(prices, 0, prices.length - 1);
        for (int i = 0; i < prices.length; i++) System.out.print(prices[i] + " ");
    }
}
