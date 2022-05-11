package homework.homework12;

public abstract class BodyGuardSkills {

    abstract void skill();

   public void saveClient(String pistol) {
        if (pistol.equals("y")) {
            System.out.println("применить оружие в ответ");
        } else {
            skill();
        }
    }
}
