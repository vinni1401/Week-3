import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMediaManager {
    User head;

    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) head = newUser;
        else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriend(int uid1, int uid2) {
        User u1 = findUser(uid1), u2 = findUser(uid2);
        if (u1 != null && u2 != null && !u1.friendIds.contains(uid2)) {
            u1.friendIds.add(uid2);
            u2.friendIds.add(uid1);
        }
    }

    void removeFriend(int uid1, int uid2) {
        User u1 = findUser(uid1), u2 = findUser(uid2);
        if (u1 != null && u2 != null) {
            u1.friendIds.remove((Integer) uid2);
            u2.friendIds.remove((Integer) uid1);
        }
    }

    void showFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println(user.name + "'s Friends: " + user.friendIds);
        }
    }

    void mutualFriends(int uid1, int uid2) {
        User u1 = findUser(uid1), u2 = findUser(uid2);
        if (u1 != null && u2 != null) {
            List<Integer> mutual = new ArrayList<>(u1.friendIds);
            mutual.retainAll(u2.friendIds);
            System.out.println("Mutual Friends: " + mutual);
        }
    }

    void search(String keyword) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(keyword) || Integer.toString(temp.userId).equals(keyword)) {
                System.out.println("Found: " + temp.name + " (ID: " + temp.userId + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaManager sm = new SocialMediaManager();
        sm.addUser(1, "Alice", 20);
        sm.addUser(2, "Bob", 22);
        sm.addUser(3, "Charlie", 23);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);

        sm.showFriends(1);
        sm.mutualFriends(1, 2);
        sm.search("Charlie");
        sm.countFriends();
        sm.removeFriend(1, 2);
        sm.showFriends(1);
    }
}
