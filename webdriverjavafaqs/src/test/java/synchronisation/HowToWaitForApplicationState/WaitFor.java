package synchronisation.HowToWaitForApplicationState;

import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitFor {

    public static ExpectedCondition<Boolean> titleContainsCondition(String titleMustContain) {
        return new TitleContainsCondition(titleMustContain);
    }

}
