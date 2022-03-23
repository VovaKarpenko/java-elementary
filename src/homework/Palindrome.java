package homework;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(comparePalindrome("abc"));
        System.out.println(comparePalindrome(" А роза упала на лапу азора"));
    }

    public static boolean comparePalindrome(String str) {
        str = str.replace(" ", "");
        StringBuilder reversStr = new StringBuilder(str);

        if (str.equalsIgnoreCase(String.valueOf(reversStr.reverse()))) {
            return true;
        } else {
            return false;
        }
    }
}
