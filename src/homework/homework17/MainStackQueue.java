package homework.homework17;

public class MainStackQueue {
    public static void main(String[] args) {
        LikeStack stack = new LikeStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.likeToString());


        System.out.println("");
        System.out.println("");


        LikeQueue queqe = new LikeQueue();

        for (int i = 0; i < 25; i++) {
            queqe.add(String.valueOf(i));
        }

        for (int i = 0; i < 20; i++) {
            System.out.print(queqe.poll() + " ");
        }



        System.out.println(queqe.likeToString());

    }
}
