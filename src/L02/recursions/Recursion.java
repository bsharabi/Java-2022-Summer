package L02.recursions;

public class Recursion {
    public static void main(String[] args) {
        A();
        D();
    }

    public static int A() {
        B();
        System.out.println("Hello A");
        return 1;
    }

    public static int B() {
        C();
        System.out.println("Hello B");
        return 2;
    }

    public static int C() {
        System.out.println("Hello C");
        return 0;
    }
    public static int D() {
        System.out.println("Hello D");
        return D();
    }


}
