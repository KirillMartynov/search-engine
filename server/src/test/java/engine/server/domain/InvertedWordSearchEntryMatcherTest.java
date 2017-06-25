package engine.server.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class InvertedWordSearchEntryMatcherTest {
    private SearchEntryMatcher sourceMatcher;

    @Before
    public void setUp() {
        sourceMatcher = mock(SearchEntryMatcher.class);
        doReturn(true)
                .when(sourceMatcher)
                .match(any());
    }

    @Test
    public void shouldReturnFalseWhenSourceMatcherReturnsTrue() {
        // given
        InvertedWordSearchEntryMatcher matcher = createInstance();

        // when
        boolean result = matcher.match(null);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenSourceMatcherReturnsFalse() {
        // given
        doReturn(false)
                .when(sourceMatcher)
                .match(any());
        InvertedWordSearchEntryMatcher matcher = createInstance();

        // when
        boolean result = matcher.match(null);

        // then
        assertTrue(result);
    }

    private InvertedWordSearchEntryMatcher createInstance() {
        return new InvertedWordSearchEntryMatcher(sourceMatcher);
    }
}
