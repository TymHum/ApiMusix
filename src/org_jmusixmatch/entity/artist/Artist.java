package org_jmusixmatch.entity.artist;

import com.google.gson.annotations.SerializedName;

public class Artist {
    @SerializedName("artist")
    private ArtistData artist;
    public void setArtistData(ArtistData artist) {
        this.artist = artist;
    }

    public ArtistData getArtistData() {
        return artist;
    }
}
