package homework.homework19;

import com.hillel.lesson11.FeatureTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {

   private final Integer numOrder;
   private OrderStatus status;
   private final LocalDateTime create;
   private LocalDateTime update;

    public Order(Integer numOrder, OrderStatus status, LocalDateTime create) {
        this.numOrder = numOrder;
        this.status = status;
        this.create = create;
    }

    public Integer getNumOrder() {
        return numOrder;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public LocalDateTime getUpdate() {
        return update;
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

    public String getOrderAsString(){

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

    public static Order getOrderFromString (String string){
        String[] arrInfo = string.split(" ");
        OrderStatus orderStatus = OrderStatus.valueOf(arrInfo[1]);
        Integer numOrder = Integer.parseInt(arrInfo[0]);
        Order order = new Order(numOrder, orderStatus, LocalDateTime.parse(arrInfo[2]));

        if (arrInfo.length == 4) {
            order.setUpdate(LocalDateTime.parse(arrInfo[3]));
        }
        return order;
    }
}
