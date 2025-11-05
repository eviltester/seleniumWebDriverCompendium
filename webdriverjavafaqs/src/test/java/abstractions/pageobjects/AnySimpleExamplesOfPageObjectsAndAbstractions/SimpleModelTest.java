package abstractions.pageobjects.AnySimpleExamplesOfPageObjectsAndAbstractions;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleModelTest {

    @Test
    public void canAddTwoNumbers(){
        final WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://testpages.eviltester.com/apps/server-side-calculator/");
        driver.findElement(By.id("number1")).sendKeys("2");
        driver.findElement(By.id("function")).sendKeys("plus");
        driver.findElement(By.id("number2")).sendKeys("3");
        driver.findElement(By.id("calculate")).click();

        // answer is always present so we need to wait till it has text
        ExpectedCondition foundAnswer = new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement elem = driver.findElement(By.id("answer"));
                if(elem.getText().isEmpty()){
                    throw new NotFoundException("Answer not available");
                }
                return elem;
            }
        };

        WebElement answer = (WebElement)new WebDriverWait(driver, Duration.ofSeconds(5)).until(foundAnswer);

        Assertions.assertEquals(answer.getText(), "5");

        driver.close();
    }


}
