package homework.homework14;

public class Main {
    public static void main(String[] args) {
        LikeArraylist arr = new LikeArraylist();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        arr.add("7");


        System.out.println(arr.toStrin());

        arr.set(1, "x");
        System.out.println(arr.toStrin());

        System.out.println(arr.get(2));

        arr.remove(1);
        System.out.println(arr.toStrin());
    }
}
