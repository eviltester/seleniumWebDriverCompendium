package uk.co.compendiumdev.selenium.support.navigation;

import org.openqa.selenium.support.ui.LoadableComponent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** A wrapper around a LoadableComponent
 *  Uses reflection to make the isLoaded method on the component accessible
 *  then uses that method to check if it is loaded, without
 *  having to call 'get' - since get 'loads' the page
 *  allows easier waiting on slow loadable components which implement
 *  a load method (even if we 'loaded' the page or component as a side-effect)
 *
 */
public class PublicIsLoadableComponent{

    private final LoadableComponent page;

    PublicIsLoadableComponent(LoadableComponent aPage){
        this.page = aPage;
    }

    public void isLoaded() throws Exception {

        try {
            Method isloaded = page.getClass().getDeclaredMethod("isLoaded");

            // allow access to the protected method isLoaded
            isloaded.setAccessible(true);
            isloaded.invoke(page);

            // can throw noSuchMethodException, Invocation
        } catch (NoSuchMethodException e) {
            throw new ComponentLoadingException(page.getClass().getCanonicalName(), "NoSuchMethodException calling is loaded " + e.getMessage());
        } catch (InvocationTargetException e) {
            throw new ComponentLoadingException(page.getClass().getCanonicalName(), "InvocationTargetException calling is loaded " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new ComponentLoadingException(page.getClass().getCanonicalName(), "IllegalAccessException calling is loaded " + e.getMessage());
        }

        // allows errors to propogate
    }
}
