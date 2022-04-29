package homework.homework11;

public class Fahrenheytes implements Converter {
    @Override
    public double convert(double temperature, String from) {
        if (from.equals("цельсий")) {
            return (temperature * 9 / 5) + 32;
        }
        if (from.equals("кельвин")) {
            return (temperature - 273.15d) * 9 / 5 + 32;
        }
        return 0;
    }
}
