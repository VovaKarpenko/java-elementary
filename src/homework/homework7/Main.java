package homework.homework7;

public class Main {
    public static void main(String[] args) {
        Helpers helpers = new Helpers();
        Helpers.MathHelper mathHelper = helpers.new MathHelper();
        Helpers.DistanceHelper distanceHelper = helpers.new DistanceHelper();

        int a = 2;
        int b = 2;
        int resultSum = mathHelper.sum(a, b);
        System.out.println("result sum: " + resultSum);

        double x1 = 3;
        double y1 = 2;
        double x2 = 7;
        double y2 = 8;
        double resultDistance = distanceHelper.calculateDistance(x1, y1, x2, y2);
        System.out.println("result distance: " + resultDistance);
    }
}
