package TestExample;

import java.util.Arrays;
import java.util.Random;

public class Moed_b {
    public static void main(String[] args) {
        Random rd = new Random();
        // ---------------------------- Q1 --------------------------------
        int n = 7;
        int[][] magic = generateSquare(n);
        // print magic square
        System.out.println("The Magic Square for " + n
                + ":");
        System.out.println("Sum of each row or column "
                + n * (n * n + 1) / 2 + ":");
        print(magic);
        System.out.println(isMagicSquare(magic));

        // ---------------------------- Q2 --------------------------------
        for (int i = 0; i < 10; i++) {
            int grade = rd.nextInt(100);
            System.out.print(grade + ": ");
            feedback(grade);
        }
        feedback(-5);
        feedback(120);


        //----------------------------- Q6 -------------------------------
        Book[] books = new Book[20];
        String[] Author = {"Ariel", "Barak", "Carmen", "Demi", "Eli", "Faris"};
        for (int i = 0; i < 20; i++) {
            books[i] = new Book(rd.nextInt(20), Author[rd.nextInt(6)], rd.nextInt(10) + 2012, rd.nextInt(250) + 25);
        }
        for (int i = 0; i < 20; i++) {
            double min = rd.nextDouble(45);
            double max = min + 100;
            System.out.println("-----------------------------------");
            System.out.println(books[i]);
            System.out.println("MyPrice min = " + min + " max = " + max);
            System.out.println(books[i].myPrice(min, max));
            System.out.println("-----------------------------------");
        }
        wantToBuy(books, 100, "Ariel");

        //----------------------------- Q7 -------------------------------
        char[] PartyChars = {'A', 'B', 'L', 'Y'};
        Petek[] Peteks = new Petek[100];
        for (int i = 0; i < 100; i++) {
            Peteks[i] = new Petek(PartyChars[rd.nextInt(4)], "None");
        }
        BallotBox ballotBox = new BallotBox(1);
        ballotBox.setPetekArray(Peteks);

        printVotes(ballotBox);

        //----------------------------- Q17 -------------------------------
        System.out.println(factorial(5));
    }


    // ---------------------------- Q1 --------------------------------

    static int[][] generateSquare(int n) {
        int[][] magicSquare = new int[n][n];

        // Initialize position for 1
        int i = n / 2;
        int j = n - 1;

        // One by one put all values in magic square
        for (int num = 1; num <= n * n; ) {
            if (i == -1 && j == n) // 3rd condition
            {
                j = n - 2;
                i = 0;
            } else {
                // 1st condition helper if next number
                // goes to out of square's right side
                if (j == n)
                    j = 0;

                // 1st condition helper if next number is
                // goes to out of square's upper side
                if (i < 0)
                    i = n - 1;
            }

            // 2nd condition
            if (magicSquare[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            } else
                // set number
                magicSquare[i][j] = num++;

            // 1st condition
            j++;
            i--;
        }


        return magicSquare;

    }

    public static boolean isMagicSquare(int[][] mat) {
        int N = mat.length;
        int sumd1 = 0, sumd2 = 0;
        for (int i = 0; i < N; i++) {
            sumd1 += mat[i][i];
            sumd2 += mat[i][N - 1 - i];
        }
        if (sumd1 != sumd2)
            return false;
        for (int i = 0; i < N; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < N; j++) {
                rowSum += mat[i][j];
                colSum += mat[j][i];
            }
            if (rowSum != colSum || colSum != sumd1)
                return false;
        }
        return true;
    }

    public static void print(int[][] mat) {
        for (int[] arr : mat) {
            System.out.println(Arrays.toString(arr));
        }
    }
    // ----------------------------------------------------------------

    //----------------------------- Q2 --------------------------------
    public static void feedback(int grade) {
        if (grade > 100 || grade < 0) {
            System.out.println("Invalid grade");
            return;
        }

        if (grade >= 95) {
            System.out.println("excellent");
        } else if (grade >= 85 && grade < 95) {
            System.out.println("Very Good");
        } else if (grade >= 75 && grade < 85) {
            System.out.println("Good");
        } else if (grade >= 65 && grade < 75) {
            System.out.println("almost good");
        } else if (grade >= 55 && grade < 65) {
            System.out.println("enough");
        } else {
            System.out.println("Not enough");
        }
    }
    // ----------------------------------------------------------------

    //----------------------------- Q7 -------------------------------
    public static void printVotes(BallotBox bb) {
        int[] votes = new int[4];
        Petek[] pArr = bb.getPetekArray();
        for (int i = 0; i < pArr.length; i++) {
            char vote = pArr[i].getPartyChar();
            switch (vote) {
                case 'A':
                    votes[0]++;
                    break;
                case 'B':
                    votes[1]++;
                    break;
                case 'L':
                    votes[2]++;
                    break;
                case 'Y':
                    votes[3]++;
                    break;
            }

        }
        System.out.println("A Votes " + votes[0]);
        System.out.println("B Votes " + votes[1]);
        System.out.println("L Votes " + votes[2]);
        System.out.println("Y Votes " + votes[3]);

    }
    //-----------------------------------------------------------------

    //----------------------------- Q6 -------------------------------
    public static void wantToBuy(Book[] allBook, double p, String author) {
        for (int i = 0; i < allBook.length; i++) {
            Book book = allBook[i];
            if (book.price() < p && book.getAuthor().equals(author)) {
                System.out.println(book);
            }
        }
    }
    //----------------------------------------------------------------

    //----------------------------- Q8 -------------------------------
    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
    //----------------------------------------------------------------

}


class Book {
    private int numId;
    private String author;
    private int year;
    private double price;

    public Book(int numId, String author, int year, double
            price) {
        this.numId = numId;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public int getId() {
        return this.numId;
    }

    public int getYear() {
        return this.year;
    }

    public String getAuthor() {
        return this.author;
    }

    public double price() {
        return price;
    }

    public boolean myPrice(double min, double max) {
        return (price >= min && price <= max);
    }

    public String toString() {
        return "Id " + this.numId + " Author " + this.author + " year " + year + " price " + price;
    }
}

class A1 {
    protected int num;

    public A1(int num) {
        this.num = num;
    }

    public void func(int i) {
        System.out.println("func(int i) from class A1");
        System.out.println("Hello number " + i);
    }
}// end of A

class B1 extends A1 {
    public B1(int num) {
        super(num);
    }

    public void func(int i) {
        System.out.println("func(int i) from class B1");
        System.out.println("Hello number " + i);
    }

    public void func(double d) {
        System.out.println("func(double D) from class B1");
        System.out.println("Hello number " + d);
    }

}// end of B

class C1 extends B1 {
    public C1(int num) {
        super(num + 1);
    }

    public void func(float f) {
        System.out.println("func(float f) from class C1");
        System.out.println("Hello number " + f);
    }


}// end of C

class Program {
    public static void main(String[] args) {
        A1 a = new A1(1);
        B1 b = new B1(1);
        C1 c = new C1(1);
        Object c1 = new C1(1);
        //(*******)
        a.func(1);
        b.func(2);
        c.func(3f);
        b.func(3.5);
    }
}

class Petek {
    private char PartyChar;
    private String PartyName;

    public Petek(char partyChar, String partyName) {
        PartyChar = partyChar;
        PartyName = partyName;
    }

    public char getPartyChar() {
        return PartyChar;
    }

    public void setPartyChar(char partyChar) {
        PartyChar = partyChar;
    }

    public String getPartyName() {
        return PartyName;
    }

    public void setPartyName(String partyName) {
        PartyName = partyName;
    }
}

class BallotBox {
    private int BallotBoxNumber;
    private Petek[] PetekArray;
    private int index;

    public BallotBox(int ballotBoxNumber) {
        BallotBoxNumber = ballotBoxNumber;
        PetekArray = new Petek[100];
        index = 0;
    }

    public int getBallotBoxNumber() {
        return BallotBoxNumber;
    }

    public void setBallotBoxNumber(int ballotBoxNumber) {
        BallotBoxNumber = ballotBoxNumber;
    }

    public Petek[] getPetekArray() {
        return PetekArray;
    }

    public void setPetekArray(Petek[] petekArray) {
        PetekArray = petekArray;
    }

    public void addPetek(Petek p) {
        PetekArray[index] = p;
        index++;
    }
}