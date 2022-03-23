package homework;

public class CommandLineArguments {
    public static void main(String[] args) {

        System.out.println(calculate(Integer.parseInt(args[0]),Integer.parseInt(args[2]),args[1]));

    }
        public static int calculate (int num1, int num2 , String sum){
            switch (sum) {
                case "+":
                   return num1 + num2;

                case "-":
                   return num1 - num2;

                case "*":
                    return num1 * num2;

                case "/":
                    return num1 / num2;
        }
            System.out.println("ошибка");
            return 0;
    }
}
