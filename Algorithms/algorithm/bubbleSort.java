package algorithm;

public class bubbleSort {
    // Declaring variable.
    static int temp;
    static int arr[];

    public bubbleSort(int[] args) {
        arr = args;
    }

    public void sort() {
        // Array passed will be sorted using bubble sort technique.
        support.util.display_unsorted(arr);
        boolean is_sorted = false;
        while (is_sorted == false) {
            is_sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    is_sorted = false;
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        support.util.display_sorted(arr);
    }

    public static void main(String args[]) {
    }
}