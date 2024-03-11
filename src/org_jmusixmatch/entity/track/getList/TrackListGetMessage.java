package org_jmusixmatch.entity.track.getList;

import com.google.gson.annotations.SerializedName;

public class TrackListGetMessage {



	@SerializedName("message")
	private TrackListGetContainer trackMessage;

	public void setTrackListMessage(TrackListGetContainer trackMessage) {
		this.trackMessage = trackMessage;
	}

	public TrackListGetContainer getTrackListMessage() {
		return trackMessage;
	}

}
