package L02.recursions;

public class PalindromeString {
    public static void main(String[] args) {
        String str = "abcba";
        System.out.println(isPalindrome(str));
    }
//a
    //""
    public static boolean isPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1)
            return true;
        int end = str.length() - 1;
        if (str.charAt(0) == str.charAt(end))
            return isPalindrome(str.substring(1, end));
        return false;
    }
}
