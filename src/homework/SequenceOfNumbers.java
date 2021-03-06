package homework;

import java.util.Arrays;
import java.util.Scanner;

public class SequenceOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strArr = scanner.nextLine();
        sequenceOfNumbers(strArr);

    }

    public static boolean sequenceOfNumbers(String strArr) {
        int[] numArr = Arrays.stream(strArr.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numArr.length - 1; i++) {
            if (numArr[i] >= numArr[i + 1]) {
                System.out.println("не является строго возростающей");
                return false;
            }
        }
        System.out.println("является строго возростающей");
        return true;
    }
}
