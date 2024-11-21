package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunPriceTest {
    private String bunName;
    private float expectedPrice;

    public BunPriceTest(String bunName, float expectedPrice) {
        this.bunName = bunName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { "Tasty bun", 99.99f },
                { "White bun", 149.00f },
                { "Sesame bun", 999.49f }
        };
    }

    @Test
    public void testBunPrice() {
        Bun bun = new Bun(bunName, expectedPrice);
        Assert.assertEquals(expectedPrice, bun.getPrice(), 0.01);
    }
}
