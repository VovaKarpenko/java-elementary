package homework.homework8;

public class Person {

    String name;

    class Account {
        int password;

        public Account(int password) {
            this.password = password;
        }

        public void displayAccount() {
            System.out.println("Вы вошли в акаунт " + name);
        }
    }
}

