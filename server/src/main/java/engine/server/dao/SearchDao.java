package engine.server.dao;

import engine.server.domain.SearchEntry;

import java.util.List;

public interface SearchDao {
    List<SearchEntry> getEntries();
}
