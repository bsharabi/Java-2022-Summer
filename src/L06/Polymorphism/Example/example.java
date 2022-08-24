package L06.Polymorphism.Example;

public class example {
    public static void main(String[] args) {
        System.out.println("-------------------------- (B Class) --------------------------");
        A b_A = new B();
        B b_B = new B();
        System.out.println("----------------- End constructor (B Class) -------------------");

        System.out.println("------------------- Start call to function --------------------");
        b_A.a();
        b_B.b();
        b_B.a();
        System.out.println("--------------- End call to function (B Class) ----------------");

        System.out.println("-------------------------- (C Class) --------------------------");
        A c_A = new C();
        C c_B = new C();
        System.out.println("----------------- End constructor (C Class) -------------------");

        System.out.println("------------------- Start call to function --------------------");
        c_A.a();
        c_B.c();
        c_B.a();
        System.out.println("--------------- End call to function (C Class) ----------------");

        System.out.println("-------------------------- (D Class) --------------------------");
        A d_A = new D();
        B d_B = new D();
        D d_D = new D();
        System.out.println("----------------- End constructor (D Class) -------------------");

        System.out.println("------------------- Start call to function --------------------");
        d_A.a();
        d_B.b();
        d_B.a();
        d_D.a();
        d_D.b();
        d_D.d();
        System.out.println("--------------- End call to function (D Class) ----------------");

        System.out.println("-------------------------- (E Class) --------------------------");
        A e_A = new E();
        B e_B = new E();
        D e_D = new E();
        E e_E = new E();
        System.out.println("----------------- End constructor (E Class) -------------------");

        System.out.println("------------------- Start call to function --------------------");
        e_A.a();
        e_B.a();
        e_B.b();
        e_D.a();
        e_D.b();
        e_D.d();
        e_E.a();
        e_E.b();
        e_E.d();
        e_E.e();
        e_E.f();
        System.out.println("--------------- End call to function (D Class) ----------------");

        System.out.println("-------------------------- (F Class) --------------------------");
        A f_A = new F();
        B f_B = new F();
        D f_D = new F();
        E f_E = new F();
        F f_F = new F();
        System.out.println("----------------- End constructor (F Class) -------------------");

        System.out.println("------------------- Start call to function --------------------");
        f_A.a();
        f_B.a();
        f_B.b();
        f_D.a();
        f_D.b();
        f_D.d();
        f_E.a();
        f_E.b();
        f_E.d();
        f_E.e();
        f_E.f();
        f_F.a();
        f_F.b();
        f_F.d();
        f_F.e();
        f_F.f();
        System.out.println("--------------- End call to function (D Class) ----------------");

    }
}

abstract class A {
    public A() {
        System.out.println("Hello from construct A");
        a();
    }

    public void a() {
        System.out.println("Hello function a from A class");
    }

    public void b() {
        System.out.println("Hello function b from A class");

    }
}

class B extends A {
    public B() {
        System.out.println("Hello from construct B");
        b();
        a();
    }

    public void b() {
        System.out.println("Hello function b from B class");
        a();
    }
}

final class C extends A {
    public C() {
        System.out.println("Hello from construct C");
        a();
        c();
    }

    public void a() {
        System.out.println("Hello function a from C class");
    }

    public void c() {
        System.out.println("Hello function c from C class");
        a();
    }
}

class D extends B {

    public void d() {
        System.out.println("Hello function d from D class");
        b();
        a();
    }

    public void b() {
        System.out.println("Hello function b from D class");
        a();
    }
}

class E extends D {
    public E() {
        System.out.println("Hello from construct E");
        e();
        a();
        d();
        b();
    }

    public void e() {
        System.out.println("Hello function e from E class");
        a();
    }

    public void a() {
        System.out.println("Hello function a from E class");
    }

    public void f() {
        System.out.println("Hello function f from E class");
        a();
        b();
        d();
        e();
    }
}

class F extends E {
    public F() {
        System.out.println("Hello from construct F");
        a();
        b();
        d();
        e();
        f();
    }

    public void f() {
        System.out.println("Hello function f from F class");
        a();
        b();
        d();

    }

    public void e() {
        System.out.println("Hello function e from F class");
        a();
        b();
        d();
        f();
    }
}
