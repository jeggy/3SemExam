package unittests;

import db.orderDB.Order;
import db.orderDB.OrderDB;
import db.orderDB.OrderModel;
import exceptions.OrderDBException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Jógvan 29/12-2015 03:33.
 */
public class OrderDBTest {

    @Mock
    OrderDB db;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }



    /* *** CancelOrder Tests *** */
    @Test
    public void cancelOrder_ShouldCancelOrder() throws SQLException, OrderDBException {
        OrderModel model = new OrderModel(db);

        int orderId = 2;
        Order order = new Order(orderId, "processing");

        when(db.read(orderId)).thenReturn(order);
        when(db.update(order)).thenReturn(1);

        boolean result = model.cancelOrder(orderId);

        assertTrue(result);
        assertEquals(order.getStatus(), "cancelled");

        verify(db).read(orderId);
        verify(db).update(order);
    }


    @Test (expected = OrderDBException.class)
    public void cancelOrder_ShouldThrowOrderDBException() throws SQLException, OrderDBException {
        OrderModel model = new OrderModel(db);
        int orderId = 2;

        when(db.read(orderId)).thenThrow(SQLException.class);

        model.cancelOrder(orderId);
    }


    /* *** PlaceOrder Tests *** */
    @Test
    public void placeOrder_ShouldCreateAnOrder() throws SQLException, OrderDBException {
        OrderModel model = new OrderModel(db);

        Order newOrder = new Order(0, "Toast!");
        when(db.create(newOrder)).thenReturn(1);

        boolean result = model.placeOrder(newOrder);

        assertTrue(result);
        verify(db).create(newOrder);
    }

    @Test
    public void placeOrder_ShouldNotCreateAnOrder() throws SQLException, OrderDBException {
        OrderModel model = new OrderModel(db);

        Order newOrder = new Order(0, "Toast!");
        when(db.create(newOrder)).thenReturn(-1);

        boolean result = model.placeOrder(newOrder);

        assertFalse(result);
        verify(db).create(newOrder);
    }

    @Test (expected = OrderDBException.class)
    public void placeOrder_ShouldThrowOrderDBException() throws SQLException, OrderDBException {
        OrderModel model = new OrderModel(db);

        Order newOrder = new Order(0, "Toast!");
        when(db.create(newOrder)).thenThrow(SQLException.class);

        boolean result = model.placeOrder(newOrder);
    }


}
