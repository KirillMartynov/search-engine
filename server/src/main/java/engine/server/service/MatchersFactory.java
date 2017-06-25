package engine.server.service;

import engine.server.domain.SearchEntryMatcher;

import java.util.List;

public interface MatchersFactory {
    List<SearchEntryMatcher> create(String searchString);
}
