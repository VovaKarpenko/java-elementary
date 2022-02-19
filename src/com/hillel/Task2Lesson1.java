package com.hillel;

import java.util.Scanner;

public class Task2Lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfMonth = scanner.nextInt();

        while (numOfMonth <= 0 || numOfMonth >= 13) {
            System.out.println("error");
            numOfMonth = scanner.nextInt();

        }
        switch (numOfMonth) {
            case 1:
                System.out.println("jan");
                break;
            case 2:
                System.out.println("feb");
                break;
            case 3:
                System.out.println("mar");
                break;
            case 4:
                System.out.println("apr");
                break;
            case 5:
                System.out.println("may");
                break;
            case 6:
                System.out.println("jun");
                break;
            case 7:
                System.out.println("jul");
                break;
            case 8:
                System.out.println("aug");
                break;
            case 9:
                System.out.println("sep");
                break;
            case 10:
                System.out.println("oct");
                break;
            case 11:
                System.out.println("nov");
                break;
            case 12:
                System.out.println("dec");
                break;
        }


        if (numOfMonth == 12) {
            numOfMonth = 1;
        }
        switch (numOfMonth / 3) {
            case 0:
                System.out.println("winter");
                break;
            case 1:
                System.out.println("spring");
                break;
            case 2:
                System.out.println("summer");
                break;
            case 3:
                System.out.println("aut");
                break;
        }
    }
}


