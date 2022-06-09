package homework.homework19;

import com.hillel.lesson11.FeatureTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {

    Integer numOrder;
    OrderStatus status;
    LocalDateTime create;
    LocalDateTime update;

    public Order(Integer numOrder, OrderStatus status, LocalDateTime create) {
        this.numOrder = numOrder;
        this.status = status;
        this.create = create;
    }

    public void setUpdate(LocalDateTime update) {
        this.update = update;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        if (update == null){
            return    "[сатус: " + status + "][дата создания: " + create + "]";
        }else {
            return "[сатус: " + status + "][дата создания: " + create + "][дата обновления: " + update + "]" ;
        }
    }

    public String info(){

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String buffStatus = status.toString();
        String buffUpdate = "";
        String buffCreate = create.format(formatter);
        if (update != null){
            buffUpdate = update.format(formatter);
        }
        String buffNum = Integer.toString(numOrder);
        return buffNum + " " + buffStatus + " " + buffCreate + " " + buffUpdate;
    }
}
