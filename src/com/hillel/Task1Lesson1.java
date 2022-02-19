package com.hillel;

import java.util.Scanner;

public class Task1Lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int grade = scanner.nextInt();
        if (grade >= 1 && grade <= 3) {
            System.out.println("двоечник");
        } else if (grade >= 4 && grade <= 6) {
            System.out.println("троечник");
        } else if (grade >= 7 && grade <= 9) {
            System.out.println("хорошист");
        } else if (grade >= 10 && grade <= 12) {
            System.out.println("отличник");
        }

    }
}
