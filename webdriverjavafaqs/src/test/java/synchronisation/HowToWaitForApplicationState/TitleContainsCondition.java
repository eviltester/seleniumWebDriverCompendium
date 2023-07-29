package synchronisation.HowToWaitForApplicationState;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class TitleContainsCondition implements ExpectedCondition<Boolean> {
    private String subMenuText;

    public TitleContainsCondition(final String subMenuText) {
        this.subMenuText=subMenuText;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        return driver.getTitle().contains(this.subMenuText);
    }
}
