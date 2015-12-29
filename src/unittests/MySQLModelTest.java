package unittests;
import db.old.MySQLModel;
import db.old.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by Jógvan 28/12-2015 22:11.
 */
public class MySQLModelTest {

    PojoExample tmpTest = new PojoExample("Hello", 1);

    @Mock
    MySQLModel db;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadPojo_Should_Load_A_Pojo()  {
        View viewTest = new View(db);

        when(db.load(1)).thenReturn(tmpTest);
        PojoExample pojo = viewTest.loadPojo(1);

        assertEquals(tmpTest, pojo);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void loadPojo_Should_Not_Load_A_Pojo()  {
        View viewTest = new View(db);

        when(db.load(0)).thenReturn(null);
        viewTest.loadPojo(0);

    }

}
