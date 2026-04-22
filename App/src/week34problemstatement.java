import java.util.*;

public class week34problemstatement {

    // =========================
    // Linear Search (First & Last)
    // =========================
    public static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1;
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First: " + first + ", Last: " + last);
        System.out.println("Comparisons: " + comparisons);
    }

    // =========================
    // Binary Search (Find One)
    // =========================
    public static int binarySearch(String[] arr, String target, int[] compCount) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            compCount[0]++;
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    // =========================
    // Count Occurrences (Binary)
    // =========================
    public static int countOccurrences(String[] arr, String target) {
        int[] comp = new int[1];
        int index = binarySearch(arr, target, comp);

        if (index == -1) {
            System.out.println("Binary Search: Not Found");
            return 0;
        }

        int count = 1;

        // Left side
        int i = index - 1;
        while (i >= 0 && arr[i].equals(target)) {
            count++;
            i--;
        }

        // Right side
        i = index + 1;
        while (i < arr.length && arr[i].equals(target)) {
            count++;
            i++;
        }

        System.out.println("Binary Search:");
        System.out.println("Found at index: " + index);
        System.out.println("Comparisons: " + comp[0]);
        System.out.println("Count: " + count);

        return count;
    }

    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear Search
        linearSearch(logs, "accB");

        // Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("\nSorted Logs: " + Arrays.toString(logs));

        // Binary Search + Count
        countOccurrences(logs, "accB");
    }
}