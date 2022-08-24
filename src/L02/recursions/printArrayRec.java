package L02.recursions;

public class printArrayRec {
    public static void printRec(int[] arr) {
        printRec(arr, 0);
    }

    private static void printRec(int[] arr, int index) {
        if (index == arr.length)
            return;
        System.out.println(arr[index] + " ");
        printRec(arr, index + 1);
    }
}

class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printArrayRec.printRec(arr);
    }
}