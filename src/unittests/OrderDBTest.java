package unittests;

import db.old.View;
import db.orderDB.Order;
import db.orderDB.OrderDB;
import db.orderDB.OrderModel;
import db.orderDB.exception.OrderDBException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

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

    @Test
    public void placeOrder_ShouldCreateAnOrder() throws SQLException, OrderDBException {
        OrderModel model = new OrderModel(db);

        Order newOrder = new Order(0, "Toast!");
        when(db.create(newOrder)).thenReturn(1);

        boolean result = model.placeOrder(newOrder);

        assertTrue(result);
        verify(db).create(newOrder);
    }

}
