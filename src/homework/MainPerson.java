package homework;

import javax.jnlp.PersistenceService;

public class MainPerson {
    static Person[] person = new Person[5];

    public static void main(String[] args) {
        person[0] = new Person("Vova", "Karpenko", "1111");
        person[1] = new Person("Sofiia", "Hushan", "1234");
        person[2] = new Person("Andrew", "Galkin", "1010");
        person[3] = new Person("Liana", "Kolodzheeva", "1731");
        person[4] = new Person("Nikita", "Serik", "2121");
        showAll();
        equalPeople(person[2], person[4]);

    }

    public static void showAll() {
        for (int i = 0; i < person.length - 1; i++) {
            System.out.println(person[i]);
        }
    }

    public static boolean equalPeople(Object person1, Object person2) {
        System.out.println("");
        if (person1.equals(person2)) {
            System.out.println(person1 + " and " + person2 + " equal");
            return true;
        } else {
            System.out.println(person1 + " and " + person2 + " not equal");
            return false;
        }
    }
}
