package http;

public class SlipStatistics {

    int releases;
    int artists;
    int labels;

    public SlipStatistics(int releases, int artists, int labels) {
        this.releases = releases;
        this.artists = artists;
        this.labels = labels;
    }

    public int getReleases() {
        return releases;
    }

    public void setReleases(int releases) {
        this.releases = releases;
    }

    public int getArtists() {
        return artists;
    }

    public void setArtists(int artists) {
        this.artists = artists;
    }

    public int getLabels() {
        return labels;
    }

    public void setLabels(int labels) {
        this.labels = labels;
    }
}
