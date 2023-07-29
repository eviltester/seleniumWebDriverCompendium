package uk.co.compendiumdev.letsautomate.googlesearch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Alan on 07/11/2016.
 */
public class PageRankRefactoredTest {

    GoogleSearchI google;

    @Before
    public void setupGoogle(){
        // TODO
        //PageRankResult result = new GooglePageRankChecker("https://google.co.uk").checkRank("prolog programmer", "compendiumdev.co.uk");
        //google = new GoogleSearchViaURL("https://google.co.uk");
        google = new GoogleSearchViaClickAndType("https://google.co.uk");
    }

    @Test
    public void pageRankTool(){


        // 20230729 added a max page check to avoid searching forever
        int MAX_PAGES_TO_CHECK=4;

        String searchTerm="prolog programmer"; // "selenium training";
        String matchInUrl="compendiumdev.co.uk";

        // search page

        google.searchFor(searchTerm, matchInUrl);

        // search results page

        int pageNumber=0;
        boolean foundMatch=false;
        boolean haveMoreResults;
        String foundMatchingUrl="";

        do{

            pageNumber++;

            google.results().waitUntilAvailable();

            List<TitledUrl> titledUrls = google.results().returnUrls();

            for(TitledUrl aUrl : titledUrls){

                System.out.println(aUrl.href);
                System.out.println(aUrl.title);

                if(aUrl.href.contains(matchInUrl)){
                    System.out.println("****FOUND MATCH*** on page " + pageNumber);
                    foundMatchingUrl = aUrl.href;
                    foundMatch=true;
                }

            }

            haveMoreResults = google.results().getMoreResults();

            if(pageNumber > MAX_PAGES_TO_CHECK)
                break;

        }while(!foundMatch && haveMoreResults);

        if(foundMatch) {
            System.out.println(String.format("Found match on Page Number %d - %s", pageNumber, foundMatchingUrl));
        }else{
            System.out.println(String.format("Found no match after Page Number %d", pageNumber));
        }
    }

    @After
    public void endTest(){
        google.endSearch();
    }
}
