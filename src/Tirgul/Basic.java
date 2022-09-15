package Tirgul;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Basic {
    public static void main(String[] args) {
        //------------------------Basic----------------------
//        int[][] matrix = {{9, 13, 5, 2},
//                {1, 11, 7, 6},
//                {3, 7, 4,},
//                {6, 0, 7, 10}};
//        //{1,1,1}
//        //{1,1,1}
//        //{1,1,1}
//        System.out.println(sumDig(matrix));
//        System.out.println(sumDig0(matrix));

        //---------------------classes-------------------------
        int size = 3;
        Hotel[] HotelsAr = new Hotel[size];
        System.out.println(Arrays.toString(HotelsAr));
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        String Name;
        String City;
        int Rooms;
        int Free;
        for (int i = 0; i < size; i++) {
//            System.out.println("Get name");
//            Name= sc.nextLine();
//            System.out.println("Get City");
//            City= sc.nextLine();
//            System.out.println("Get Rooms");
//            Rooms = sc.nextInt();
//            System.out.println("Get Free");
//            Free = sc.nextInt();
//            HotelsAr[i] = new Hotel(Name,City,Rooms,Free);

            HotelsAr[i] = new Hotel("Name" + i, "City" + i, rd.nextInt(101) + 50, rd.nextInt(50));

        }
        for (int i = 0; i < HotelsAr.length; i++) {
            System.out.println(HotelsAr[i]);
        }
        System.out.println("Get city");
        Name = sc.nextLine();
        System.out.println(Name);
        for (int i = 0; i < size; i++) {
            if (HotelsAr[i].getCity().equals(Name)) {
                System.out.println(HotelsAr[i]);
            }
        }
        System.out.println("--------------------");
        for (int i = 0; i < size; i++) {
            if (HotelsAr[i].getFree() > 0) {
                System.out.println(HotelsAr[i]);
            }
        }
        System.out.println("--------------------");

        for (int i = 0; i < size; i++) {
            float a = (float) HotelsAr[i].getRooms() / 100;
            float b = (float) HotelsAr[i].getFree() / a;
            if (b > 40) {
                System.out.println(HotelsAr[i]);
            }
        }
    }

    public static int sumDig(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (i == j) {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }

    public static int sumDig0(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (i + j == mat.length - 1) {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }

    public static boolean contains(int number, int digit) {
        if (number == 0)
            return false;

        if (number % 10 == digit)
            return true;
        return contains(number / 10, digit);
    }


}
//sum += mat[0][0];
//sum += mat[1][0];
//sum += mat[2][0];
//sum += mat[3][0];

//sum += mat[0][1];
//sum += mat[1][1];
//sum += mat[2][1];
//sum += mat[3][1];

//sum += mat[0][2];
//sum += mat[1][2];
//sum += mat[2][2];
//sum += mat[3][2]; mat[3].len = 2

class Hotel {

    private String Name;
    private String City;
    private int Rooms;
    private int Free;

    public String getName() {
        return Name;
    }

    public String getCity() {
        return City;
    }

    public int getRooms() {
        return Rooms;
    }

    public int getFree() {
        return Free;
    }

    public Hotel(String Name, String city, int rooms, int free) {
        setCity(city);
        setFree(free);
        setName(Name);
        setRooms(rooms);
    }

    public Hotel() {
        this.Name = "NA";
        City = "NA";
        Rooms = 0;
        Free = 0;
    }

    public void setFree(int free) {
        if (free >= 0)
            Free = free;
    }

    public void setData(String Name, String city, int rooms, int free) {
        this.Name = Name;
        City = city;
        Rooms = rooms;
        setFree(free);
    }

    public void setName(String name) {
        if (name.length() > 0 && name.length() <= 30)
            Name = name;

    }

    public void setCity(String city) {
        if (city.length() > 0 && city.length() <= 20)

            City = city;
    }

    public void setRooms(int rooms) {
        if (rooms >= 0)
            Rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "Name='" + Name + '\'' +
                ", City='" + City + '\'' +
                ", Rooms=" + Rooms +
                ", Free=" + Free +
                '}';
    }

    public void Print() {
        System.out.println("Hotel{" +
                "Name='" + Name + '\'' +
                ", City='" + City + '\'' +
                ", Rooms=" + Rooms +
                ", Free=" + Free +
                '}');
    }
}


class A {
    public A() {
    }

    public A(int a) {
    }

    public void func() {

    }
}

class B extends A {
    public void func(float n) {

    }

    public void func(int a) {

    }

    @Override
    public String toString() {
        return "B{}";
    }
}

class Test {


    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        A b1 = new B();
        b.func(1);
        b.func(6f);

    }
}