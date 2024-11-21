package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        // Устанавливаем стоимость булочки
        Mockito.when(bun.getPrice()).thenReturn(47f);
        // Устанавливаем стоимость ингредиентов
        Mockito.when(ingredient1.getPrice()).thenReturn(12f);
        Mockito.when(ingredient2.getPrice()).thenReturn(33f);

        //добавляем ингридиенты в бургер
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        //считаем сколько должен стоить бургер
        float expectedPrice = 47f * 2 + 12f + 33f;
        //сравниваем какая цена у нас получилось, с тем что тестируем
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        // Мокаем поведение для булочки
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(47f);

        // Мокаем поведение для ингредиентов
        Mockito.when(ingredient1.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getPrice()).thenReturn(12f);

        Mockito.when(ingredient2.getName()).thenReturn("cutlet");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getPrice()).thenReturn(33f);

        // Устанавливаем булочку и добавляем ингредиенты
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Ожидаемый результат для рецепта
        String expectedReceipt = String.format("(==== %s ====)%s= sauce %s =%s= filling %s =%s(==== %s ====)%s%sPrice: %.6f%s",
                "black bun", System.lineSeparator(), "hot sauce", System.lineSeparator(),
                "cutlet", System.lineSeparator(), "black bun", System.lineSeparator(), System.lineSeparator(), 139.0f, System.lineSeparator());

        // Проверяем, что рецепт соответствует ожидаемому
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

}
