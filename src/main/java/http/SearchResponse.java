package http;

import java.util.List;

public class SearchResponse {
    private int totalResult;
    private String query;
    private List<SlipDTo> slips;

    public SearchResponse(int totalResult, String query, List<SlipDTo> slip) {
        this.totalResult = totalResult;
        this.query = query;
        this.slips = slip;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<SlipDTo> getSlip() {
        return slips;
    }

    public void setSlip(List<SlipDTo> slip) {
        this.slips = slip;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("SearchResponse{" +
                "totalResult=" + totalResult +
                ", query='" + query+"\n");

        for (SlipDTo slip: slips) {
            result.append(slip.toString());
            result.append('\n');
        }
        return result.toString();
    }
}
