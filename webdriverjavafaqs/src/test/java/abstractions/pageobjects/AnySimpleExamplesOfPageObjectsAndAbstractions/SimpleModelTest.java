package abstractions.pageobjects.AnySimpleExamplesOfPageObjectsAndAbstractions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleModelTest {

    @Test
    public void canAddTwoNumbers(){
        WebDriverManager.chromedriver().setup();
        final WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://testpages.herokuapp.com/styled/calculator");
        driver.findElement(By.id("number1")).sendKeys("2");
        driver.findElement(By.id("function")).sendKeys("plus");
        driver.findElement(By.id("number2")).sendKeys("3");
        driver.findElement(By.id("calculate")).click();

        ExpectedCondition foundAnswer = new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("answer"));
            }
        };

        WebElement answer = (WebElement)new WebDriverWait(driver,5).until(foundAnswer);

        Assertions.assertEquals(answer.getText(), "5");

        driver.close();
    }


}
