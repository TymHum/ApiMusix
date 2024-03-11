package org_jmusixmatch.entity.track.getList;

import com.google.gson.annotations.SerializedName;
import org_jmusixmatch.entity.Header;

public class TrackListGetContainer {

    @SerializedName("header")
    private Header header;


    @SerializedName("body")
    private TrackListGetBody body;


    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public TrackListGetBody getBody() {
        return body;
    }

    public void setBody(TrackListGetBody body) {
        this.body = body;
    }
}
