package homework.homework8;

import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();

        System.out.print("Введите имя пользователя: ");
        person.name = scanner.nextLine();

        System.out.print("Введите пороль: ");
        Person.Account account = person.new Account(scanner.nextInt());

        account.displayAccount();


    }


}
