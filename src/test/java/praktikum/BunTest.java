package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Tasty bun", 100);
    }

    //проверяем, что имина совпадают
    @Test
    public void testGetName() {
        Assert.assertEquals("Tasty bun", bun.getName());
    }

    //сравниваем целевое значение с полученым из нашего bun.
    // Так как это флоут могут возникать ошибки округления, поэтому проверяем, что погрешность не больше 0.01
    @Test
    public void testGetPrice() {
        Assert.assertEquals(100.0f, bun.getPrice(), 0.01);
    }
}
