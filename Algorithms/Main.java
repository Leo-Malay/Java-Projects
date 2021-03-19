import algorithm.*;

public class Main {
    public static void main(String args[]) {
        int arr[] = { 9, 7, 5, 3, 1, 2, 4, 6, 8, 0 };

        System.out.println("\n\nBubble Sort:-");
        bubbleSort bubble = new bubbleSort(arr);
        bubble.sort();

        System.out.println("\n\nSelection Sort:-");
        selectionSort selection = new selectionSort(arr);
        selection.sort();
    }
}
