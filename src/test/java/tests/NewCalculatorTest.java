package tests;

import objects.CalculatorPage;
import objects.ClassicCalculatorPage;
import objects.Keys;
import org.junit.*;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;


public class NewCalculatorTest extends BaseTest {

    static ClassicCalculatorPage calc = new ClassicCalculatorPage(driver);

    @BeforeClass
    public static void openPage() {
        calc.open();
    }

    @Before
    public void cleanup() {
        calc.clear();
    }

    @Test

    public void add_test() {
        calc.click_2();
        calc.click_plus();
        calc.click_5();
        calc.click_equal();
        Assert.assertEquals("7", calc.getResult());
    }

    @Test
    @Stories("Substract values story")
    @Features("Calculator functions")
    public void subtract_test() {
        calc.click("2");
        calc.click("-");
        calc.click("5");
        calc.click("=");
        Assert.assertEquals("-3", calc.getResult());
    }

    @Test
    public void multiply_test() {
        calc.click(Keys.TWO);
        calc.click(Keys.MULTIPLY);
        calc.click(Keys.FIVE);
        calc.click(Keys.EQUAL);
        Assert.assertEquals("10", calc.getResult());
    }

    @Test
    public void divide_test() {
        CalculatorPage cal = new CalculatorPage(driver);
        Assert.assertEquals("100", cal.calculate("1000/2-400"));
    }
}
