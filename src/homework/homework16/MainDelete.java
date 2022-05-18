package homework.homework16;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MainDelete {
    public static void main(String[] args) {
        Map<String, LocalDate> info = new HashMap<>();
        info.put("Bogashov", LocalDate.of(2007, 7, 20));
        info.put("Serik", LocalDate.of(2015, 6, 11));
        info.put("Galkin", LocalDate.of(2003, 10, 1));
        info.put("Chornokulskii", LocalDate.of(2008, 12, 31));
        info.put("Huzhan", LocalDate.of(2006, 8, 22));
        info.put("kizim", LocalDate.of(2010, 1, 1));
        info.put("Kolo", LocalDate.of(2007, 7, 20));
        info.put("Kolodzheeva", LocalDate.of(2008, 6, 10));
        info.put("Karpenko", LocalDate.of(2006, 10, 31));
        info.put("Pupkin", LocalDate.of(2020, 6, 3));

        System.out.println(info);
        info.entrySet().removeIf(entry -> entry.getValue().getMonthValue() >= 6 && entry.getValue().getMonthValue() <= 8);
        System.out.println(info);
    }
}
