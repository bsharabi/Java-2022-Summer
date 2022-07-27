package L02;

public class PowRec {
    public static void main(String[] args) {
        System.out.println(pow(2,5));
    }
    public static int pow(int a, int b) {
        if (b == 0)
            return 1;

        return a * pow(a, b - 1);
    }
}
