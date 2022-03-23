package homework;

public class Palindrome {
    public static void main(String[] args) {
        comparePalindrome("abc");
        comparePalindrome(" А роза упала на лапу азора");
    }

    public static boolean comparePalindrome(String str) {
        str = str.replace(" ", "");
        StringBuilder reversStr = new StringBuilder(str);

        if (str.equalsIgnoreCase(String.valueOf(reversStr.reverse()))) {
            System.out.println("da");
            return true;
        } else {
            System.out.println("net");
            return false;
        }
    }
}
