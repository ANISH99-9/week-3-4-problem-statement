import java.util.*;

public class week34problemstatement {

    // =========================
    // Trade Class
    // =========================
    static class Trade {
        String id;
        int volume;

        public Trade(String id, int volume) {
            this.id = id;
            this.volume = volume;
        }

        public String toString() {
            return id + ":" + volume;
        }
    }

    // =========================
    // MERGE SORT (ASCENDING)
    // =========================
    public static void mergeSort(Trade[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(Trade[] arr, int left, int mid, int right) {
        Trade[] temp = new Trade[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i].volume <= arr[j].volume) {
                temp[k++] = arr[i++]; // stable
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    // =========================
    // QUICK SORT (DESCENDING)
    // =========================
    public static void quickSort(Trade[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Trade[] arr, int low, int high) {
        int pivot = arr[high].volume; // Lomuto
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].volume > pivot) { // DESC
                i++;
                Trade temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Trade temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // =========================
    // MERGE TWO SORTED LISTS
    // =========================
    public static Trade[] mergeTwoSorted(Trade[] a, Trade[] b) {
        Trade[] result = new Trade[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i].volume <= b[j].volume) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];

        return result;
    }

    // =========================
    // TOTAL VOLUME
    // =========================
    public static int totalVolume(Trade[] arr) {
        int sum = 0;
        for (Trade t : arr) {
            sum += t.volume;
        }
        return sum;
    }

    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {

        Trade[] trades = {
                new Trade("trade3", 500),
                new Trade("trade1", 100),
                new Trade("trade2", 300)
        };

        // Merge Sort (ASC)
        Trade[] copy1 = Arrays.copyOf(trades, trades.length);
        mergeSort(copy1, 0, copy1.length - 1);
        System.out.println("MergeSort (ASC): " + Arrays.toString(copy1));

        // Quick Sort (DESC)
        Trade[] copy2 = Arrays.copyOf(trades, trades.length);
        quickSort(copy2, 0, copy2.length - 1);
        System.out.println("QuickSort (DESC): " + Arrays.toString(copy2));

        // Merge two sorted lists
        Trade[] morning = {
                new Trade("m1", 100),
                new Trade("m2", 200)
        };

        Trade[] afternoon = {
                new Trade("a1", 300),
                new Trade("a2", 400)
        };

        Trade[] merged = mergeTwoSorted(morning, afternoon);
        System.out.println("Merged: " + Arrays.toString(merged));

        // Total volume
        System.out.println("Total Volume: " + totalVolume(merged));
    }
}