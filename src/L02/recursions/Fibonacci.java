package L02.recursions;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
