package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DatabaseTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testAvailableBuns() {
        // Получаем список булочек
        List<Bun> buns = database.availableBuns();

        // Проверяем, что в списке есть три булочки
        Assert.assertEquals(3, buns.size());

        // Проверяем, что названия булочек правильные
        Assert.assertEquals("black bun", buns.get(0).getName());
        Assert.assertEquals("white bun", buns.get(1).getName());
        Assert.assertEquals("red bun", buns.get(2).getName());

        // Проверяем цену булочек
        Assert.assertEquals(100, buns.get(0).getPrice(), 0.01);
        Assert.assertEquals(200, buns.get(1).getPrice(), 0.01);
        Assert.assertEquals(300, buns.get(2).getPrice(), 0.01);
    }

    @Test
    public void testAvailableIngredients() {
        // Получаем список ингредиентов
        List<Ingredient> ingredients = database.availableIngredients();

        // Проверяем, что в списке есть шесть ингредиентов
        Assert.assertEquals(6, ingredients.size());

        // Проверяем, что имена ингредиентов правильные
        Assert.assertEquals("hot sauce", ingredients.get(0).getName());
        Assert.assertEquals("sour cream", ingredients.get(1).getName());
        Assert.assertEquals("chili sauce", ingredients.get(2).getName());
        Assert.assertEquals("cutlet", ingredients.get(3).getName());
        Assert.assertEquals("dinosaur", ingredients.get(4).getName());
        Assert.assertEquals("sausage", ingredients.get(5).getName());

        // Проверяем типы ингредиентов
        Assert.assertEquals(IngredientType.SAUCE, ingredients.get(0).getType());
        Assert.assertEquals(IngredientType.SAUCE, ingredients.get(1).getType());
        Assert.assertEquals(IngredientType.SAUCE, ingredients.get(2).getType());
        Assert.assertEquals(IngredientType.FILLING, ingredients.get(3).getType());
        Assert.assertEquals(IngredientType.FILLING, ingredients.get(4).getType());
        Assert.assertEquals(IngredientType.FILLING, ingredients.get(5).getType());

        // Проверяем цены ингредиентов
        Assert.assertEquals(100, ingredients.get(0).getPrice(), 0.01);
        Assert.assertEquals(200, ingredients.get(1).getPrice(), 0.01);
        Assert.assertEquals(300, ingredients.get(2).getPrice(), 0.01);
        Assert.assertEquals(100, ingredients.get(3).getPrice(), 0.01);
        Assert.assertEquals(200, ingredients.get(4).getPrice(), 0.01);
        Assert.assertEquals(300, ingredients.get(5).getPrice(), 0.01);
    }
}
