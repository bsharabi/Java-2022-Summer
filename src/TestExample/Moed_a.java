package TestExample;

import java.util.Arrays;
import java.util.Random;

public class Moed_a {
    public static void main(String[] args) {
        Random rd = new Random();
        // ---------------------------- Q1 --------------------------------
        int[][] matrix = generate_Matrix(5, 5);
        print(matrix);
        System.out.println(isPositive(matrix));

        // ---------------------------- Q2 --------------------------------
        copies('a', 11);

        //----------------------------- Q6 -------------------------------
        Car[] cars = new Car[20];
        String[] types = {"A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < 20; i++) {
            cars[i] = new Car(rd.nextInt(20), types[rd.nextInt(6)], rd.nextInt(10) + 2012, rd.nextInt(100000) + 55000);
        }
        for (int i = 0; i < 20; i++) {
            double min = rd.nextDouble(85000);
            double max = min + 10000;
            System.out.println("-----------------------------------");
            System.out.println(cars[i]);
            System.out.println("MyPrice min = " + min + " max = " + max);
            System.out.println(cars[i].myPrice(min, max));
            System.out.println("-----------------------------------");
        }
        wantToBuy(cars, 120000, "A");

        //----------------------------- Q7 -------------------------------
        Chicken[] henEggs = new Chicken[10];
        for (int i = 0; i < 10; i++) {
            henEggs[i] = new Chicken(i, rd.nextDouble(8) + 4, rd.nextInt(10));
        }
        System.out.println("all");
        for (int i = 0; i < 10; i++) {
            System.out.println(henEggs[i]);
        }
        int max = henEggs[0].getAverageAmount();
        int Id = henEggs[0].getNumId();
        for (int i = 1; i < henEggs.length; i++) {
            if (henEggs[i].getAverageAmount() > max) {
                max = henEggs[i].getAverageAmount();
                Id = henEggs[i].getNumId();
            }
        }
        System.out.println("Hen number " + Id + " lays " + max + " eggs");

        //----------------------------- Q16 -------------------------------
        System.out.println( sum(5));
    }


    // ---------------------------- Q1 --------------------------------
    public static int[][] generate_Matrix(int row, int col) {
        Random rd = new Random();
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = rd.nextInt(100);
            }
        }
        return temp;
    }

    public static boolean isPositive(int[][] matrix) {
        int odd = 0, even = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j % 2 == 0)
                    even += matrix[i][j];
                else if (i % 2 != 0)
                    odd += even += matrix[i][j];
            }
        }
        return even > odd;
    }

    public static void print(int[][] mat) {
        for (int[] arr : mat) {
            System.out.println(Arrays.toString(arr));
        }
    }
    // ----------------------------------------------------------------

    //----------------------------- Q2 --------------------------------
    public static void copies(char ch, int num) {
        if (num % 2 == 0) {
            System.out.println("Invalid number");
            return;
        }
        int space = num / 2;
        for (int i = 0; i < (num / 2) + 1; i++) {
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print(ch);
            }
            System.out.println();
            space--;
        }

    }
    //-----------------------------------------------------------------

    //----------------------------- Q6 -------------------------------
    public static void wantToBuy(Car[] allCar, double p, String type) {
        for (int i = 0; i < allCar.length; i++) {
            Car car = allCar[i];
            if (car.price() < p && car.getType().equals(type)) {
                System.out.println(car);
            }
        }
    }
    // ----------------------------------------------------------------

    //----------------------------- Q8 -------------------------------
    public static int sum(int n) {
        if (n == 0)
            return 0;
        return n + sum(n - 1);
    }
    //----------------------------------------------------------------



}

class Car {
    private int numId;
    private String type;
    private int year;
    private double price;

    public Car(int numId, String type, int year, double price) {
        this.numId = numId;
        this.type = type;
        this.year = year;
        this.price = price;
    }

    public int getId() {
        return this.numId;
    }

    public int getYear() {
        return this.year;
    }

    public String getType() {
        return this.type;
    }

    public double price() {
        return price;
    }

    public boolean myPrice(double min, double max) {
        return (price >= min && price <= max);
    }

    public String toString() {
        return "Id " + this.numId + " type " + this.type + " year " + year + " price " + price;

    }
}

class Chicken {
    private int numId;
    private double weight;
    private int averageAmount;

    public Chicken(int numId, double weight, int averageAmount) {
        this.numId = numId;
        this.weight = weight;
        this.averageAmount = averageAmount;
    }

    public int laysMoreEggs(Chicken c) {
        return c.averageAmount > averageAmount ? c.averageAmount : averageAmount;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAverageAmount() {
        return averageAmount;
    }

    public void setAverageAmount(int averageAmount) {
        this.averageAmount = averageAmount;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "numId=" + numId +
                ", weight=" + weight +
                ", averageAmount=" + averageAmount +
                '}';
    }
}

class A {
    protected int num;

    public A(int num) {
        this.num = num;
    }
}// end of A

class B extends A {
    public B(int num) {
        super(num);
    }

    public boolean equals(Object other) {
        System.out.println("Hello equals(Object other)");
        return ((other != null) && (other instanceof B));
    }
}// end of B

class C extends B {
    public C(int num) {
        super(num + 1);
    }

    public boolean equals(C other) {
        System.out.println("Hello equals(C other)");
        return ((other != null) && (num == other.num));
    }
}// end of C

class Test {
    public static void main(String[] args) {
        B b = new B(1);
        C c = new C(2);
        Object b1 = new B(1);
        Object c1 = new C(1);
        //(*******)
        System.out.println(b1.equals(b));
        System.out.println(c1.equals(c));
        System.out.println(c.equals((C) c1));
    }
}

