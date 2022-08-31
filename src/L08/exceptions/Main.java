package L08.exceptions;


public class Main {
    public static void main(String[] args) {
        ArrayIndexOutOfBoundsException e1 = new ArrayIndexOutOfBoundsException();
        int[] arr = {1, 2, 3, 4, 5};
        try {
            for (int i = 0; i < arr.length; i++)
                System.out.println(arr[i]);
            f1();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Exception");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e);
        } finally {
            System.out.println("finally");
        }
        A a = null;
        try {

            a = new A(-1);
            System.out.println(a);
        } catch (Exception e4) {
            System.out.println(e4);
        }
        System.out.println(a);
    }

    private static void f1() throws Exception {
        f2();
    }

    private static void f2() throws Exception {
        f3();
    }

    private static void f3() throws Exception {
        f4();
    }

    private static void f4() throws Exception {
        f5();
    }

    private static void f5() throws Exception {
        if (true)
            throw new Exception();
    }
}

class A {
   private int i;

    public A(int i) throws Exception {
        setI(i);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) throws Exception {
        if (i < 0)
            throw new Exception("Error A");
        this.i = i;
    }

    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                '}';
    }
}