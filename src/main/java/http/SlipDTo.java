package http;

public class SlipDTo {
    private long id;
    private String album;

    public SlipDTo(String album) {
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "SlipDTo{" +
                "id=" + id +
                ", album='" + album + '\'' +
                '}';
    }
}
