import java.util.*;

public class week34problemstatement {

    // =========================
    // Linear Search (Unsorted)
    // =========================
    public static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: Found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: Not found");
        }

        System.out.println("Comparisons: " + comparisons);
    }

    // =========================
    // Binary Search Insertion Point
    // =========================
    public static int findInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low; // insertion index
    }

    // =========================
    // Floor (largest ≤ target)
    // =========================
    public static Integer floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        Integer result = null;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return arr[mid];

            if (arr[mid] < target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // =========================
    // Ceiling (smallest ≥ target)
    // =========================
    public static Integer ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        Integer result = null;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return arr[mid];

            if (arr[mid] > target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {

        int[] unsorted = {50, 10, 100, 25};
        int target = 30;

        // Linear Search
        linearSearch(unsorted, target);

        // Sort for Binary Operations
        int[] sorted = {10, 25, 50, 100};
        System.out.println("\nSorted Risks: " + Arrays.toString(sorted));

        // Insertion Point
        int index = findInsertionPoint(sorted, target);
        System.out.println("Insertion Index for " + target + ": " + index);

        // Floor & Ceiling
        Integer f = floor(sorted, target);
        Integer c = ceiling(sorted, target);

        System.out.println("Floor(" + target + "): " + f);
        System.out.println("Ceiling(" + target + "): " + c);
    }
}