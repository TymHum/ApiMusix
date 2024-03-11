package org_jmusixmatch.entity.artist.getList;

import com.google.gson.annotations.SerializedName;
import org_jmusixmatch.entity.artist.Artist;
import org_jmusixmatch.entity.artist.ArtistData;

public class ArtistWrapper {
    @SerializedName("artist")
    private ArtistData artist;

    public ArtistData getArtist() {
        return artist;
    }
    public void setArtist(ArtistData artist){
        this.artist = artist;
    }
}
