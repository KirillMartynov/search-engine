package engine.server.response;

public class SearchItemResponse {
    private final String name;
    private final String type;
    private final String designedBy;

    public SearchItemResponse(String name, String type, String designedBy) {
        this.name = name;
        this.type = type;
        this.designedBy = designedBy;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDesignedBy() {
        return designedBy;
    }
}
