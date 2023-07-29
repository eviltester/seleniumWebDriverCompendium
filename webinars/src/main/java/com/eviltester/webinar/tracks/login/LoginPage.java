package com.eviltester.webinar.tracks.login;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;
    By user_login_text_field = By.id("user_login");
    By user_password_text_field = By.id("user_password");
    By sign_in_button = By.name("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeUserName(String userName) {
        WebElement userLogin = driver.findElement(user_login_text_field);
        userLogin.sendKeys(userName);
    }

    public void typePassword(String password) {
        WebElement userPassword = driver.findElement(user_password_text_field);
        userPassword.sendKeys(password);
    }

    public void signIn() {
        WebElement signInButton = driver.findElement(sign_in_button);
        signInButton.click();
    }

    public boolean loginUnsuccessfulMessageIsPresent() {

        WebElement messageHolder;

        try{
            messageHolder = driver.findElement(By.id("flash"));
        }catch(NoSuchElementException e){
            return false;
        }

        if(!messageHolder.isDisplayed()){
            return false;
        }

        if(messageHolder.getText().equals("Login unsuccessful.")){
            return true;
        }

        return false;
    }
}
