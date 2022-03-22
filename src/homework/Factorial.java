package homework;

public class Factorial {
    public static void main(String[] args) {

        int i = 6;
        System.out.println(recursion(i));
        System.out.println(cycle(i));
    }

    public static int recursion(int i) {
        int result = 1;
        if (i == 0) {
            return result;
        }
        result = i * recursion(i - 1);
        return result;
    }
    public static int cycle(int i) {
        int result = 1;
        for (int j = 1; j <= i; j++) {
            result = result * j;
        }
        return result;
    }
}
