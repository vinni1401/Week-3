import java.util.*;
class PetrolPump {
    int petrol, distance;
    PetrolPump(int p, int d) { petrol = p; distance = d; }
}
class CircularTour {
    public static int tour(PetrolPump[] arr) {
        int start = 0, deficit = 0, balance = 0;
        for (int i = 0; i < arr.length; i++) {
            balance += arr[i].petrol - arr[i].distance;
            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }
        return (balance + deficit >= 0) ? start : -1;
    }
    public static void main(String[] args) {
        PetrolPump[] arr = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };
        System.out.println(tour(arr));
    }
}
