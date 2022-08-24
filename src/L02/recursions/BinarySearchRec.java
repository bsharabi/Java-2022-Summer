package L02.recursions;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchRec {

    public static void main(String[] args) {
        int[] a = fill(10);
        System.out.println(Arrays.toString(a));
        int key = a[8];
        Arrays.sort(a); //By default O(nlog(n))
        System.out.println(Arrays.toString(a));
        int res = BinarySearch(a, key);
        System.out.println(res);
    }

    public static int BinarySearch(int[] a, int key) {
        return BinarySearch(a, key, 0, a.length - 1);
    }

    private static int BinarySearch(int a[], int key, int left, int right) {
        int middle = (right + left) / 2;
        if (right >= left) {
            if (a[middle] == key)
                return middle;
            else if (a[middle] < key)
                return BinarySearch(a, key, middle + 1, right);
            else
                return BinarySearch(a, key, left, middle - 1);
        }
        return -1;
    }

    public static int[] fill(int size) {
        Random rd = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = rd.nextInt(30);
        }
        return a;
    }
}
