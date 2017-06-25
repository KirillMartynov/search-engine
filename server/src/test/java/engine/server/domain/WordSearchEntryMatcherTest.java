package engine.server.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordSearchEntryMatcherTest {
    private final String searchWord = "test";

    @Test
    public void shouldFindByName() {
        shouldFindByName(true, "TEST");
        shouldFindByName(true, "test");
        shouldFindByName(true, "TEST abra cadabra");
        shouldFindByName(true, "abra cadabra test");
    }

    @Test
    public void shouldNotFindByName() {
        shouldFindByName(false, "mew woof");
        shouldFindByName(false, "woof");
        shouldFindByName(false, "abra cadabra");
    }

    private void shouldFindByName(boolean expectedResult, String name) {
        // given
        WordSearchEntryMatcher matcher = createInstance();

        // when
        boolean result = matcher.match(entryWithName(name));

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    public void shouldFindByType() {
        shouldFindByType(true, "mew", "woof", "TEST");
        shouldFindByType(true, "quack", "test", "woof");
    }

    @Test
    public void shouldNotFindByType() {
        shouldFindByType(false, "mew", "woof");
        shouldFindByType(false, "quack", "woof");
    }

    private void shouldFindByType(boolean expectedResult, String... types) {
        // given
        WordSearchEntryMatcher matcher = createInstance();

        // when
        boolean result = matcher.match(entryWithType(types));

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    public void shouldFindByDesignedBy() {
        shouldFindByDesignedBy(true, "mew", "woof", "test");
        shouldFindByDesignedBy(true, "TEST", "woof", "test");
    }

    @Test
    public void shouldNotFindByDesignedBy() {
        shouldFindByDesignedBy(false, "mew", "woof", "whoo");
        shouldFindByDesignedBy(false, "qaa", "woof", "hoo");
    }

    private void shouldFindByDesignedBy(boolean expectedResult, String... designedBy) {
        // given
        WordSearchEntryMatcher matcher = createInstance();

        // when
        boolean result = matcher.match(entryWithDesignedBy(designedBy));

        // then
        assertEquals(expectedResult, result);
    }

    private SearchEntry entryWithName(String name) {
        return entry(name, Collections.emptyList(), Collections.emptyList());
    }

    private SearchEntry entryWithType(String... type) {
        return entry("", Arrays.asList(type), Collections.emptyList());
    }

    private SearchEntry entryWithDesignedBy(String... designedBy) {
        return entry("", Collections.emptyList(), Arrays.asList(designedBy));
    }

    private SearchEntry entry(String name, List<String> type, List<String> designedBy) {
        return new SearchEntry(name, type, designedBy);
    }

    private WordSearchEntryMatcher createInstance() {
        return new WordSearchEntryMatcher(searchWord);
    }
}
