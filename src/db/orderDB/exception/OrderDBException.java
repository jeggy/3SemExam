package db.orderDB.exception;

import java.sql.SQLException;

/**
 * Created by Jógvan 29/12-2015 02:10.
 */
public class OrderDBException extends Exception {

    public OrderDBException(SQLException e) {
        super(e);
    }
}
