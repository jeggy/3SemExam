package unittests;

import adt.collections.List;
import org.junit.*;

import static org.junit.Assert.assertSame;

/**
 * Created by Jógvan 28/12-2015 19:58.
 */

public class ListTest {

    @Test
    public void getShouldReturnSameAsAddedValueTest() {
        List<String> tester = new List<>(3);

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
        List<List<?>> outerList = new List<>(2);

        List<String> innerList1 = new List<>(3);
        String s1 = "Hello World";
        String s2 = "What?";
        String s3 = "HelloOh yeah";
        innerList1.add(s1);
        innerList1.add(s2);
        innerList1.add(s3);

        List<PojoExample> innerList2 = new List<>(3);
        PojoExample pojo1 = new PojoExample("name", 50);
        PojoExample pojo2 = new PojoExample("Other name", 100);
        innerList2.add(pojo1);
        innerList2.add(pojo2);

        outerList.add(innerList1);
        outerList.add(innerList2);


        // Outer SimpleLists
        assertSame("Should return same String as inserted!", innerList1, outerList.get(0));
        assertSame("Should return same String as inserted!", innerList2, outerList.get(1));

        // Inner SimpleLists
        assertSame("Should return same pojo as inserted!", pojo1, outerList.get(1).get(0));
        assertSame("Should return same pojo as inserted!", pojo2, outerList.get(1).get(1));
        assertSame("Should return null as we didn't insert any value into the last place.", null, outerList.get(1).get(2));

        assertSame("Should return same String as inserted!", "What?", outerList.get(0).get(1));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void arrayOutOfBoundsAdd(){
        List<String> list = new List<>(2);
        list.add("A");
        list.add("B");
        list.add("C");
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void arrayOutOfBoundsGet(){
        List<String> list = new List<>(2);
        list.get(3);
    }

}
