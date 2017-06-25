package engine.server.domain;

import engine.server.service.MatchersFactory;
import engine.server.service.MatchersFactoryImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MatchersFactoryImplTest {

    @Test
    public void shouldCreateSequenceOfMatchers() {
        shouldCreateSequenceOfMatchers("python scripting", WordSearchEntryMatcher.class, WordSearchEntryMatcher.class);
        shouldCreateSequenceOfMatchers("object-oriented scripting", WordSearchEntryMatcher.class, WordSearchEntryMatcher.class);
        shouldCreateSequenceOfMatchers("object-oriented \"non scripting\"", WordSearchEntryMatcher.class, WordSearchEntryMatcher.class);
        shouldCreateSequenceOfMatchers("object-oriented non scripting", WordSearchEntryMatcher.class, WordSearchEntryMatcher.class, WordSearchEntryMatcher.class);
        shouldCreateSequenceOfMatchers("object-oriented -scripting", WordSearchEntryMatcher.class, InvertedWordSearchEntryMatcher.class);
        shouldCreateSequenceOfMatchers("-\"non scripting\" object-oriented", InvertedWordSearchEntryMatcher.class, WordSearchEntryMatcher.class);
    }

    private void shouldCreateSequenceOfMatchers(String query, Class... classes) {
        // given
        MatchersFactory factory = createInstance();

        // when
        List<SearchEntryMatcher> matchers = factory.create(query);

        // then
        assertEquals(Arrays.asList(classes), matchers.stream().map(SearchEntryMatcher::getClass).collect(Collectors.toList()));
    }

    private MatchersFactory createInstance() {
        return new MatchersFactoryImpl();
    }
}
