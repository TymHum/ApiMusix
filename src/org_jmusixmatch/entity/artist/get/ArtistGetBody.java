package org_jmusixmatch.entity.artist.get;

import com.google.gson.annotations.SerializedName;
import org_jmusixmatch.entity.artist.ArtistData;
import org_jmusixmatch.entity.track.TrackData;

/**
 * A class to denote the body part of the JSON.
 *
 * @author Sachin Handiekar
 * @version 1.0
 */
public class ArtistGetBody {
    @SerializedName("artist")
    private ArtistData artist;

    public void setArtist(ArtistData artist) {
        this.artist = artist;
    }

    public ArtistData getArtist() {
        return artist;
    }
}
