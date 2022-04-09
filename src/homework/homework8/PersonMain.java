package homework.homework8;

import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя пользователя: ");
        Person person = new Person(scanner.nextLine());

        System.out.print("Введите пороль: ");
        Person.Account account = person.new Account(scanner.nextInt());

        account.displayAccount();


    }


}
