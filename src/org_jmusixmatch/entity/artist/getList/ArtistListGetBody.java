package org_jmusixmatch.entity.artist.getList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistListGetBody {
    @SerializedName("artist_list")
    private List<ArtistWrapper> artistList;

    public List<ArtistWrapper> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<ArtistWrapper> artistList) {
        this.artistList = artistList;
    }
}
