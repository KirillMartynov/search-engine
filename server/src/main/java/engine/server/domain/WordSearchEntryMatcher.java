package engine.server.domain;

public class WordSearchEntryMatcher implements SearchEntryMatcher {
    private final String word;

    public WordSearchEntryMatcher(String word) {
        this.word = word;
    }

    @Override
    public boolean match(SearchEntry entry) {
        return containsIgnoreCase(entry.getName()) ||
               entry.getType().stream().anyMatch(this::containsIgnoreCase) ||
               entry.getDesignedBy().stream().anyMatch(this::containsIgnoreCase);
    }

    private boolean containsIgnoreCase(String source) {
        int length = word.length();
        for (int i = source.length() - length; i >= 0; i--) {
            if (source.regionMatches(true, i, word, 0, length))
                return true;
        }

        return false;
    }
}
