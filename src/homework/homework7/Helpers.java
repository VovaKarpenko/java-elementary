package homework.homework7;

public class Helpers {
    class MathHelper {
        public int sum(int a, int b) {
            return a + b;
        }
    }

    class DistanceHelper {
        public double calculateDistance(double x1, double y1, double x2, double y2) {
            return Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
        }
    }
}
