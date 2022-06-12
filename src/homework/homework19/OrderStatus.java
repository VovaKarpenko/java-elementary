package homework.homework19;

import java.util.EnumSet;
import java.util.Set;

public enum OrderStatus {
    NEW,
    IN_PROGRESS,
    FINISHED,
    FAILED;



    public static Set<OrderStatus> APPLICCABLE_FOR_NEW = EnumSet.of(IN_PROGRESS , FINISHED , FAILED);
    public static Set<OrderStatus> APPLICCABLE_FOR_IN_PROGRESS = EnumSet.of(FINISHED , FAILED);
    public static Set<OrderStatus> APPLICCABLE_FOR_FAILED = EnumSet.of(IN_PROGRESS , FINISHED , NEW);
}
