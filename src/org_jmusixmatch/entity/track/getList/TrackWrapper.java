package org_jmusixmatch.entity.track.getList;

import com.google.gson.annotations.SerializedName;
import org_jmusixmatch.entity.artist.ArtistData;
import org_jmusixmatch.entity.track.TrackData;

public class TrackWrapper {
    @SerializedName("track")
    private TrackData track;

    public TrackData getTrackData() {
        return track;
    }
    public void setTrackData(TrackData track){
        this.track = track;
    }
}
