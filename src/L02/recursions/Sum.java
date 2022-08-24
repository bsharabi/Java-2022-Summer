package L02.recursions;

public class Sum {
    public static int sum(int n) {
        if (n == 0)
            return 0;
        return n + sum(n - 1);
    }

    public static void main(String[] args) {

        System.out.println(sum(10));
    }
}
