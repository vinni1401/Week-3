import java.util.*;
class StockSpan {
    public static void calculateSpan(int[] price) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[price.length];
        for (int i = 0; i < price.length; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) stack.pop();
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        for (int i = 0; i < span.length; i++) System.out.print(span[i] + " ");
    }
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        calculateSpan(prices);
    }
}