package base;

import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

public class SearchTest {

    private final String searchText = "software testing life cycle";

    @Test
    public void testSearch(HomePage homePage){
        SearchPage searchPage = homePage.search(searchText);
        ArrayList<String> results = searchPage.getSearchResults();

        for(String result: results){
            assertTrue(result.toLowerCase().contains(searchText));
        }
    }
}
