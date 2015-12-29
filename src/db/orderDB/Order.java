package db.orderDB;

/**
 * Created by Jógvan 29/12-2015 02:01.
 */
public class Order {

    int id;
    String status;

    public Order(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public Order(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
