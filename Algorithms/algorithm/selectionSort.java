package algorithm;

public class selectionSort {
    // Declaring variable.
    static int min, temp;
    static int arr[];

    public selectionSort(int[] args) {
        arr = args;
    }

    public void sort() {
        // Array passed will be sorted using bubble sort technique.
        support.util.display_unsorted(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (min > arr[j]) {
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        support.util.display_sorted(arr);
    }

    public static void main(String args[]) {
    }
}
