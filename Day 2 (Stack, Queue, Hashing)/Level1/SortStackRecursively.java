import java.util.*;
class SortStackRecursively {
    static void sortedInsert(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }

    static void sortStack(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sortStack(s);
            sortedInsert(s, x);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30); s.push(10); s.push(20); s.push(5);
        sortStack(s);
        while (!s.isEmpty()) System.out.println(s.pop());
    }
}