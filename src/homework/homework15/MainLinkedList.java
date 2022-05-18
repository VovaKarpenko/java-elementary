package homework.homework15;

public class MainLinkedList {
    public static void main(String[] args) {
        LikeLinkedList arr = new LikeLinkedList();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println(arr);
        System.out.println(arr.get(2));

        arr.set(2,10);
        System.out.println(arr);

        arr.remove(3);
        System.out.println(arr);

        arr.add(3);
        System.out.println(arr);

        System.out.println(arr.size());

        arr.add(2,13);
        System.out.println(arr);

        arr.add(0,99);
        System.out.println(arr);
    }
}
