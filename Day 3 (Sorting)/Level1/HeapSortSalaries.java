public class HeapSortSalaries {
    public static void heapify(int[] arr, int n, int i) {
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int temp = arr[i]; arr[i] = arr[largest]; arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int t = arr[0]; arr[0] = arr[i]; arr[i] = t;
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] salaries = {50000, 30000, 70000, 45000, 60000};
        heapSort(salaries);
        for (int i = 0; i < salaries.length; i++) System.out.print(salaries[i] + " ");
    }
}
