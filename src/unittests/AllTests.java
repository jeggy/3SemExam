package unittests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Jógvan 28/12-2015 21:08.
 *
 * http://www.vogella.com/tutorials/JUnit/article.html
 * http://www.vogella.com/tutorials/Mockito/article.html
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ SimpleListTest.class, GenericListTest.class })
public class AllTests {
}
