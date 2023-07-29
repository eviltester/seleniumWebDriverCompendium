package uk.co.compendiumdev.examples.browserstorage;

import java.util.Collection;

public interface TodoMvcLocalStorage {

    long length();
    Collection<String> itemTitles();
    String titleAt(int index);
    boolean containsTitle(String title);
}
