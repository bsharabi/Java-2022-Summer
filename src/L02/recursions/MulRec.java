package L02.recursions;

public class MulRec {
    public static int mul(int a, int b) {
        if (b == 0)
            return 0;
        return a + mul(a, b - 1);
    }
    public static void main(String[] args) {
        System.out.println(mul(10,5));
    }
}
//"abbbbabbcba"
//"abbbbbbbba"

