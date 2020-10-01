import http.*;

public class MusicInfoClient {
    private final HttpClient httpClient = new HttpClient();
    private final String URL = PropertiesManager.getProperty("URL");

    public SlipDTo getRandomAlbum(){
        String fetch = httpClient.fetch(URL + "album");
        SlipResponse slipResponse = ResponseParser.parseFromString(fetch, SlipResponse.class);
        return slipResponse.getSlip();
    }

    public SlipResponse searchById(long id){
        String fetch = httpClient.fetch(URL + "album");
        fetch += "}";
        SlipResponse slipResponse = ResponseParser.parseFromString(fetch, SlipResponse.class);
        return slipResponse;
    }

    public SearchResponse searchByString(String query){
        String fetch = httpClient.fetch(URL + "album/search/" + query);
        SearchResponse searchResponse = ResponseParser.parseFromString(fetch, SearchResponse.class);
        return searchResponse;
    }
}
