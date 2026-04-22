import java.util.*;

public class week34problemstatement {

    // =========================
    // Client Class
    // =========================
    static class Client {
        String name;
        int riskScore;
        double accountBalance;

        public Client(String name, int riskScore, double accountBalance) {
            this.name = name;
            this.riskScore = riskScore;
            this.accountBalance = accountBalance;
        }

        public String toString() {
            return name + ":" + riskScore;
        }
    }

    // =========================
    // Bubble Sort (Ascending Risk)
    // =========================
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Bubble Sort (ASC): " + Arrays.toString(arr));
        System.out.println("Swaps: " + swaps);
    }

    // =========================
    // Insertion Sort (DESC Risk + Balance)
    // =========================
    public static void insertionSort(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort (DESC): " + Arrays.toString(arr));
    }

    // =========================
    // Top K Highest Risk Clients
    // =========================
    public static void topK(Client[] arr, int k) {
        System.out.print("Top " + k + " risks: ");

        for (int i = 0; i < Math.min(k, arr.length); i++) {
            System.out.print(arr[i].name + "(" + arr[i].riskScore + ") ");
        }

        System.out.println();
    }

    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 2000),
                new Client("clientB", 50, 3000)
        };

        // Bubble Sort (Ascending)
        Client[] copy1 = Arrays.copyOf(clients, clients.length);
        bubbleSort(copy1);

        // Insertion Sort (Descending)
        Client[] copy2 = Arrays.copyOf(clients, clients.length);
        insertionSort(copy2);

        // Top 3 Risks
        topK(copy2, 3);
    }
}