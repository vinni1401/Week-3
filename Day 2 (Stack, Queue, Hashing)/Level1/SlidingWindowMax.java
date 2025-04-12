import java.util.*;
class SlidingWindowMax {
    public static void printMax(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!dq.isEmpty() && dq.peek() <= i - k) dq.poll();
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) dq.pollLast();
            dq.offer(i);
            if (i >= k - 1) System.out.print(arr[dq.peek()] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        printMax(arr, 3);
    }
}
