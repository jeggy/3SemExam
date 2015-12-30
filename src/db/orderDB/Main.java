package db.orderDB;

import exceptions.OrderDBException;

/**
 * Created by Jógvan 29/12-2015 02:29.
 */
public class Main {

    public static void main(String[] args) throws OrderDBException {
        OrderModel db = new OrderModel(new OrderDB());

        db.placeOrder(new Order(0, "New Order"));
        db.cancelOrder(5);

    }

}
