package database;

import http.SlipDTo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Slip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long slipId;

    public long getSlipId() {
        return slipId;
    }

    public void setSlipId(long slipId) {
        this.slipId = slipId;
    }

    private long id;
    private String album;

    public Slip(SlipDTo slip) {
    }

    public Slip(long id, String album) {
        this.id = id;
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Slip{" +
                "slipId=" + slipId +
                ", id=" + id +
                ", album='" + album + '\'' +
                '}' + "\n";
    }
}
