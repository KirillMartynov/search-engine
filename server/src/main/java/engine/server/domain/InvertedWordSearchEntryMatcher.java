package engine.server.domain;

public class InvertedWordSearchEntryMatcher implements SearchEntryMatcher {
    private final SearchEntryMatcher matcher;

    public InvertedWordSearchEntryMatcher(SearchEntryMatcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean match(SearchEntry entry) {
        return !matcher.match(entry);
    }
}
