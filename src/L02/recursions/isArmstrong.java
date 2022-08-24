package L02.recursions;

public class isArmstrong {
    public static void main(String[] args) {
        int n = 407;
        if (isArmstrong(n) == n)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    //O(log(number)) base 10
    public static int isArmstrong_t(int number, int digit) {
        if (number == 0)
            return 0;
        return (int) (Math.pow(number % 10, digit) + isArmstrong_t(number / 10, digit));
    }

    //O(log(number)) base 10
    public static int isArmstrong(int number) {
        return isArmstrong_t(number, (int) (Math.log10(number) + 1));
    }
}
