package abstractions.pageobjects.AnySimpleExamplesOfPageObjectsAndAbstractions.pageobjects.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {

    private WebDriver driver;

    public CalculatorPage(WebDriver driver){
        this.driver = driver;
    }

    public CalculatorPage enterNumberOne(String numberOne){
        driver.findElement(By.id("number1")).sendKeys(numberOne);
        return this;
    }

    public CalculatorPage enterNumberTwo(String numberTwo){
        driver.findElement(By.id("number2")).sendKeys(numberTwo);
        return this;
    }

    public CalculatorPage selectFunction(String functionName){
        driver.findElement(By.id("function")).sendKeys(functionName);
        return this;
    }

    public CalculatorPage calculate(){
        driver.findElement(By.id("calculate")).click();
        return this;
    }

    // helper to make it easy to interact with
    public String getAnswer(){

        // this could be using ExpectedConditions.textToBe()
        ExpectedCondition foundAnswer = new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement elem = driver.findElement(By.id("answer"));
                if(elem!=null){
                    if(!elem.getText().isEmpty()){
                        return elem;
                    }
                }
                throw new NotFoundException("Answer not populated yet");
            }
        };

        WebElement answer = (WebElement)new WebDriverWait(driver, Duration.ofSeconds(5)).until(foundAnswer);

        return answer.getText();
    }

    /* Syntactic sugar for literate programming */
    public CalculatorPage then(){return this;}
    public CalculatorPage and(){return this;}

}
