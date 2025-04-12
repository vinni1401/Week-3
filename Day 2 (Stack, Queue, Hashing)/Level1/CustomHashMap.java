import java.util.*;

class Entry {
    int key, value;
    Entry next;
    Entry(int k, int v) { key = k; value = v; }
}

class MyHashMap {
    int size = 10;
    Entry[] table = new Entry[size];

    int hash(int key) { return key % size; }

    void put(int key, int value) {
        int idx = hash(key);
        Entry head = table[idx];
        while (head != null) {
            if (head.key == key) { head.value = value; return; }
            head = head.next;
        }
        Entry newNode = new Entry(key, value);
        newNode.next = table[idx];
        table[idx] = newNode;
    }

    Integer get(int key) {
        int idx = hash(key);
        Entry head = table[idx];
        while (head != null) {
            if (head.key == key) return head.value;
            head = head.next;
        }
        return null;
    }

    void remove(int key) {
        int idx = hash(key);
        Entry head = table[idx], prev = null;
        while (head != null) {
            if (head.key == key) {
                if (prev == null) table[idx] = head.next;
                else prev.next = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    void display() {
        for (int i = 0; i < size; i++) {
            Entry head = table[i];
            System.out.print(i + ": ");
            while (head != null) {
                System.out.print("[" + head.key + "=" + head.value + "] ");
                head = head.next;
            }
            System.out.println();
        }
    }
}

public class CustomHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(12, 30);
        map.display();
        System.out.println("Get 2: " + map.get(2));
        map.remove(2);
        map.display();
    }
}
