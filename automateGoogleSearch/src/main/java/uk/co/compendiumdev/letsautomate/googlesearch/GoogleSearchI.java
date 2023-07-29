package uk.co.compendiumdev.letsautomate.googlesearch;

/**
 * Created by Alan on 09/11/2016.
 */
public interface GoogleSearchI {
    void searchFor(String searchTerm, String matchInUrl);

    GoogleSearchResultsI results();

    void endSearch();
}
