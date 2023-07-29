package uk.co.compendiumdev.examples.component.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

/**
 * Element abstractions abstract HTML Elements to restrict the methods available
 * to those relevant to the element. Rather than exposing all WebElement methods.
 *
 * It also allows us to create methods which model the semantics of the element
 * e.g. check, uncheck and toggle
 *
 */
public class CheckboxElement implements WrapsElement {

    private final WebElement webelement;

    public CheckboxElement(WebElement element){
        webelement = element;
    }

    public boolean isChecked() {
        return webelement.isSelected();
    }

    public CheckboxElement check() {
        if(!isChecked()){
            toggle();
        }
        return this;
    }

    public CheckboxElement uncheck() {
        if(isChecked()){
            toggle();
        }
        return this;
    }

    public CheckboxElement toggle() {
        webelement.click();
        return this;
    }

    @Override
    public WebElement getWrappedElement() {
        return webelement;
    }
}
