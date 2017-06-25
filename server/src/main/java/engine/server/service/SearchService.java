package engine.server.service;

import engine.server.domain.SearchEntry;
import engine.server.domain.SearchEntryMatcher;

import java.util.List;

public interface SearchService {
    List<SearchEntry> find(List<SearchEntryMatcher> matchers);
}
