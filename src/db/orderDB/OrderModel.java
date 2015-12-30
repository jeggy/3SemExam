package db.orderDB;

import exceptions.OrderDBException;

import java.sql.SQLException;

/**
 * Created by Jógvan 29/12-2015 02:12.
 */
public class OrderModel {

    private OrderDB db;

    public OrderModel(OrderDB db) {
        this.db = db;
    }

    public boolean placeOrder(Order order) throws OrderDBException {
        try{
            int result = db.create(order);
            if(result > 0){
                return true;
            }
        } catch(SQLException e){
            throw new OrderDBException(e);
        }
        return false;
    }

    public boolean cancelOrder(int id) throws OrderDBException {
        try{
            Order order = db.read(id);
            order.setStatus("cancelled");
            int result = db.update(order);
            if(result > 0){
                return true;
            }
        } catch(SQLException e){
            throw new OrderDBException(e);
        }
        return false;
    }

    public boolean deleteOrder(int id) throws OrderDBException {
        try{
            int result = db.delete(id);
            if(result > 0){
                return true;
            }
        } catch(SQLException e){
            throw new OrderDBException(e);
        }
        return false;
    }


    public OrderDB getDb() {
        return db;
    }

    public void setDb(OrderDB db) {
        this.db = db;
    }
}
