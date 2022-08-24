package L06.Polymorphism;

public class Test {

    public Test(int a) {

    }

    public static void main(String[] args) {
        A1 d = new D1();
    }

}

class A1 {
    int i;

    public A1() {

    }

    void f() {
        System.out.println("f A1");
    }


}

class B1 extends A1 {
    int b;
    public B1() {

    }

    void f() {
        System.out.println("f B1");
    }
}

class C1 extends B1 {
    public C1() {

    }

    void f() {
        System.out.println("f C1");
    }
}

class D1 extends C1 {

    public D1() {

    }

    void f() {
        System.out.println("f D1");
    }
}