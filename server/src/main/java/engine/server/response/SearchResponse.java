package engine.server.response;

import java.util.List;

public class SearchResponse {
    private final List<SearchItemResponse> items;

    public SearchResponse(List<SearchItemResponse> items) {
        this.items = items;
    }

    public List<SearchItemResponse> getItems() {
        return items;
    }
}