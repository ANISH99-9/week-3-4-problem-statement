import java.util.*;

public class week34problemstatement {

    // =========================
    // Transaction Class
    // =========================
    static class Transaction {
        String id;
        double fee;
        String timestamp; // HH:MM

        public Transaction(String id, double fee, String timestamp) {
            this.id = id;
            this.fee = fee;
            this.timestamp = timestamp;
        }

        public String toString() {
            return id + ":" + fee + "@" + timestamp;
        }
    }

    // =========================
    // Bubble Sort (by fee)
    // =========================
    public static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // early stop
        }

        System.out.println("Bubble Sort Result: " + list);
        System.out.println("Swaps: " + swaps);
    }

    // =========================
    // Insertion Sort (fee + timestamp)
    // =========================
    public static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee &&
                                    list.get(j).timestamp.compareTo(key.timestamp) > 0))) {

                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }

        System.out.println("Insertion Sort Result: " + list);
    }

    // =========================
    // High Fee Outliers
    // =========================
    public static void findOutliers(List<Transaction> list) {
        System.out.print("High-fee outliers (>50): ");

        boolean found = false;
        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.print(t + " ");
                found = true;
            }
        }

        if (!found) System.out.print("none");

        System.out.println();
    }

    // =========================
    // MAIN METHOD (TEST)
    // =========================
    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        // Bubble Sort (small batch)
        List<Transaction> copy1 = new ArrayList<>(transactions);
        bubbleSort(copy1);

        // Insertion Sort (medium batch)
        List<Transaction> copy2 = new ArrayList<>(transactions);
        insertionSort(copy2);

        // Outliers
        findOutliers(transactions);
    }
}