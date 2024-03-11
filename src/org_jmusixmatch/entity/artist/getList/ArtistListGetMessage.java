package org_jmusixmatch.entity.artist.getList;

import com.google.gson.annotations.SerializedName;
import org_jmusixmatch.entity.artist.get.ArtistGetContainer;

public class ArtistListGetMessage {

    @SerializedName("message")
    private ArtistListGetContainer artistListMessage;

    public void setArtistListMessage(ArtistListGetContainer artistListMessage) {
        this.artistListMessage = artistListMessage;
    }

    public ArtistListGetContainer getArtistListMessage() {
        return artistListMessage;
    }

}
