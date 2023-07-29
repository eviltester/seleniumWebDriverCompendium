package abstractions.pageobjects.AnySimpleExamplesOfPageObjectsAndAbstractions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import abstractions.pageobjects.AnySimpleExamplesOfPageObjectsAndAbstractions.pageobjects.calculator.*;

public class SimpleModelUsingPageObjectModelTest {

    static WebDriver driver;

    @BeforeAll
    static void startupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void canAddTwoNumbers(){

        driver.navigate().to("https://testpages.herokuapp.com/styled/calculator");

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.enterNumberOne("3");
        calculatorPage.selectFunction("plus");
        calculatorPage.enterNumberTwo("4");
        calculatorPage.calculate();

        Assertions.assertEquals(calculatorPage.getAnswer(), "7");
    }


    @Test
    public void canAddTwoNumbersLiterately(){

        driver.navigate().to("http://compendiumdev.co.uk/selenium/calculate.php");

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.
                enterNumberOne("3").
                then().
                enterNumberTwo("4").
                then().
                selectFunction("plus").
                and().
                calculate();

        Assertions.assertEquals(calculatorPage.getAnswer(), "7");
    }

    @AfterAll
    static void closeDriver(){
        driver.close();
    }
}
