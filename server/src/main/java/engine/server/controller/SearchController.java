package engine.server.controller;

import engine.server.domain.SearchEntry;
import engine.server.domain.SearchEntryMatcher;
import engine.server.response.SearchItemResponse;
import engine.server.response.SearchResponse;
import engine.server.service.MatchersFactory;
import engine.server.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {
    @Autowired
    private SearchService searchService;

    @Autowired
    private MatchersFactory factory;

    @GetMapping("/search")
    public SearchResponse searchForQuery(@RequestParam("query") String query) {
        List<SearchEntryMatcher> matchers = factory.create(query);
        return toResponse(searchService.find(matchers));
    }

    private SearchResponse toResponse(List<SearchEntry> entries) {
        return new SearchResponse(entries.stream()
                .map(entry -> new SearchItemResponse(
                        entry.getName(),
                        String.join(", ", entry.getType()),
                        String.join(", ", entry.getDesignedBy()))).collect(Collectors.toList()));
    }
}
