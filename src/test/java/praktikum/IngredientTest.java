package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Sweet sauce", 95.5f);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Sweet sauce", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(95.5f, ingredient.getPrice(), 0.01);
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
