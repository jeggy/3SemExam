package unittests;

import adt.collections.GenericList;
import adt.collections.SimpleList;
import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Created by Jógvan 28/12-2015 21:34.
 */
public class GenericListTest {

    @Test
    public void getShouldReturnSameAsAddedValueTest() {
        GenericList<String> tester = new GenericList<>();

        String s1 = "Hello World";
        String s2 = "What?";
        String s3 = "HelloOh yeah";
        tester.add(s1);
        tester.add(s2);
        tester.add(s3);

        assertSame("Should return same String as inserted!", s1, tester.get(0));
        assertSame("Should return same String as inserted!", s3, tester.get(2));
        assertSame("Should return same String as inserted!", s2, tester.get(1));
    }

    @Test
    public void getShouldReturnSameAsAddedValueAdvancedTest() {
        GenericList<SimpleList<?>> outerList = new GenericList<>();

        SimpleList<String> innerList1 = new SimpleList<>(3);
        String s1 = "Hello World";
        String s2 = "What?";
        String s3 = "HelloOh yeah";
        innerList1.add(s1);
        innerList1.add(s2);
        innerList1.add(s3);

        SimpleList<PojoExample> innerList2 = new SimpleList<>(3);
        PojoExample pojo1 = new PojoExample("name", 50);
        PojoExample pojo2 = new PojoExample("Other name", 100);
        innerList2.add(pojo1);
        innerList2.add(pojo2);

        outerList.add(innerList1);
        outerList.add(innerList2);


        // Outer list
        assertSame("Should return same String as inserted!", innerList1, outerList.get(0));
        assertSame("Should return same String as inserted!", innerList2, outerList.get(1));

        // Inner lists
        assertSame("Should return same pojo as inserted!", pojo1, outerList.get(1).get(0));
        assertSame("Should return same pojo as inserted!", pojo2, outerList.get(1).get(1));
        assertSame("Should return null as we didn't insert any value into the last place.", null, outerList.get(1).get(2));

        assertSame("Should return same String as inserted!", "What?", outerList.get(0).get(1));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void arrayOutOfBoundsGet(){
        GenericList<String> list = new GenericList<>();
        list.get(3);
    }

}
