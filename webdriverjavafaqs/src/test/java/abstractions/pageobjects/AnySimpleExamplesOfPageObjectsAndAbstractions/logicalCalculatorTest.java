package abstractions.pageobjects.AnySimpleExamplesOfPageObjectsAndAbstractions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import abstractions.pageobjects.AnySimpleExamplesOfPageObjectsAndAbstractions.logical.calculator.*;

public class logicalCalculatorTest {

    static WebDriver driver;

    @BeforeAll
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void canAddTwoNumbers(){
        Calculator calculator = new Calculator(driver);

        Calculation addTwoNumbers = new Calculation(2,"+",2);

        long result = calculator.calculate(addTwoNumbers);

        Assertions.assertEquals(result,4L);
    }

    @AfterAll
    public static void tearDownDriver(){
        driver.close();
    }

}
