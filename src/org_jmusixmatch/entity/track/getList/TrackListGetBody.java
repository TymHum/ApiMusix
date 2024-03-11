package org_jmusixmatch.entity.track.getList;

import com.google.gson.annotations.SerializedName;
import org_jmusixmatch.entity.artist.getList.ArtistWrapper;
import org_jmusixmatch.entity.track.TrackData;

import java.util.List;

/**
 * A class to denote the body part of the JSON.
 *
 * @author Sachin Handiekar
 * @version 1.0
 */
public class TrackListGetBody {
    @SerializedName("track_list")
    private List<TrackWrapper> trackList;

    public void setTrackList(List<TrackWrapper> trackList) {
        this.trackList = trackList;
    }

    public List<TrackWrapper> getTrackList() {
        return trackList;
    }
}
