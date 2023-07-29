package uk.co.compendiumdev.letsautomate.googlesearch;

import java.util.List;

/**
 * Created by Alan on 09/11/2016.
 */
public interface GoogleSearchResultsI {
    List<TitledUrl> returnUrls();

    void waitUntilAvailable();

    boolean getMoreResults();

}
