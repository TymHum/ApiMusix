package org_jmusixmatch.entity.artist.getList;

import com.google.gson.annotations.SerializedName;
import org_jmusixmatch.entity.Header;
import org_jmusixmatch.entity.artist.get.ArtistGetBody;

public class ArtistListGetContainer {
    @SerializedName("header")
    private Header header;


    @SerializedName("body")
    private ArtistListGetBody body;


    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public ArtistListGetBody getBody() {
        return body;
    }

    public void setBody(ArtistListGetBody body) {
        this.body = body;
    }
}
