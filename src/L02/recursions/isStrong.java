package L02.recursions;

public class isStrong {
    public static void main(String[] args) {
        System.out.println(isStrong(145));
    }

    //O(log(n)) base 10 n is a digit of number
    public static boolean isStrong(int n) {
        int Factorial[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        int factSum = 0;
        int temp = n;
        while (temp != 0) {
            factSum += Factorial[temp % 10];
            temp /= 10;
        }
        return (factSum == n) ? true : false;
    }
}
