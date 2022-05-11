package homework.homework12;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        System.out.print("дать пистолет нападающему y/n:  ");
        attack(scanner.nextLine(), bodyGuard());



    }
    public static BodyGuardSkills bodyGuard(){

        System.out.print("выбрать телохранителя 1.Боксер 2.Каратист 3.Джиу: ");

        switch (scanner.nextInt()){
            case 1: return new Boxer();
            case 2: return new Karateka();
            case 3: return new Juugist();
        }
        return null;
    }

    public static void attack (String hasPistol, BodyGuardSkills bodyGuard){
        bodyGuard.saveClient(hasPistol);
    }
}
