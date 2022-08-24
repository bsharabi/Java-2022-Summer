package L07.Interfaces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayTest test = new ArrayTest();
        ArrayList arr = new ArrayList();
        LinkedList ll = new LinkedList();
        Object obj = new Object();

        List list = new LinkedList();
        list = new ArrayTest();
        list = new ArrayList();

        if (list instanceof ArrayList) {

        }
        f(new ArrayTest());
    }

    static void f(List l) {
    }

}
