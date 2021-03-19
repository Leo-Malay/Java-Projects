package support;

public class util {
    public static void display_unsorted(int[] arr) {
        System.out.print("Before Sorting Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void display_sorted(int[] arr) {
        System.out.print("\nAfter Sorting Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
    }
}
