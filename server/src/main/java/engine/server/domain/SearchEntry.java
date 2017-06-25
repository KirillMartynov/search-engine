package engine.server.domain;

import java.util.List;

public class SearchEntry {
    private final String name;
    private final List<String> type;
    private final List<String> designedBy;

    public SearchEntry(String name, List<String> type, List<String> designedBy) {
        this.name = name;
        this.type = type;
        this.designedBy = designedBy;
    }

    public String getName() {
        return name;
    }

    public List<String> getType() {
        return type;
    }

    public List<String> getDesignedBy() {
        return designedBy;
    }
}