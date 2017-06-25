package engine.server.service;

import engine.server.dao.SearchDao;
import engine.server.domain.SearchEntry;
import engine.server.domain.SearchEntryMatcher;

import java.util.List;
import java.util.stream.Collectors;

public class SearchServiceImpl implements SearchService {
    private final SearchDao searchDao;

    public SearchServiceImpl(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    @Override
    public List<SearchEntry> find(List<SearchEntryMatcher> matchers) {
        List<SearchEntry> entries = searchDao.getEntries();
        return entries.stream()
                      .filter(entry -> allMatch(matchers, entry))
                      .collect(Collectors.toList());
    }

    private boolean allMatch(List<SearchEntryMatcher> matchers, SearchEntry entry) {
        return matchers.stream().allMatch(matcher -> matcher.match(entry));
    }
}
