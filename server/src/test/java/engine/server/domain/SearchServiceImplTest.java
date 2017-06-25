package engine.server.domain;

import engine.server.dao.SearchDao;
import engine.server.service.MatchersFactory;
import engine.server.service.SearchService;
import engine.server.service.SearchServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class SearchServiceImplTest {
    private SearchDao searchDao;
    private List<SearchEntry> entries;

    @Before
    public void setUp() {
        searchDao = mock(SearchDao.class);
        entries = Arrays.asList(
                new SearchEntry("A", null, null),
                new SearchEntry("B", null, null),
                new SearchEntry("C", null, null),
                new SearchEntry("D", null, null)
                );

        doReturn(entries).when(searchDao).getEntries();
    }

    @Test
    public void shouldFindSearchEntries() {
        // given
        List<SearchEntryMatcher> matchers = Arrays.asList(
                createMatcher("A", "B", "C"),
                createMatcher("B", "C"),
                createMatcher("C")
        );
        SearchService service = createInstance();

        // when
        List<SearchEntry> entries = service.find(matchers);

        // then
        assertEquals(1, entries.size());
        assertEquals("C", entries.get(0).getName());
    }

    @Test
    public void shouldNotFindSearchEntries() {
        // given
        List<SearchEntryMatcher> matchers = Arrays.asList(
                createMatcher("A", "B"),
                createMatcher("C")
        );
        SearchService service = createInstance();

        // when
        List<SearchEntry> entries = service.find(matchers);

        // then
        assertEquals(0, entries.size());
    }

    private SearchEntryMatcher createMatcher(String... matchingNames) {
        SearchEntryMatcher matcher = mock(SearchEntryMatcher.class);
        List<String> list = Arrays.asList(matchingNames);
        doReturn(false).when(matcher).match(any());
        doReturn(true).when(matcher).match(ArgumentMatchers.argThat(
                searchEntry -> list.contains(searchEntry.getName())
        ));

        return matcher;
    }

    private SearchService createInstance() {
        return new SearchServiceImpl(searchDao);
    }
}
