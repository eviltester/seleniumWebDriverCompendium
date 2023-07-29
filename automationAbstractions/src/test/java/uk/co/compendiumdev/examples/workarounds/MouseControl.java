package uk.co.compendiumdev.examples.workarounds;

import java.awt.*;

public class MouseControl {

    public static void moveOutOfTheWay(){
        // move the mouse out of the way so it
        // doesn't interfere with the test

        try {
            new Robot().mouseMove(0,0);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
