package org_jmusixmatch.subtitle.get;

import com.google.gson.annotations.SerializedName;
import org_jmusixmatch.subtitle.Subtitle;

public class SubtitleGetBody {

    @SerializedName("subtitle")
    private Subtitle subtitle;

    public Subtitle getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Subtitle subtitle) {
        this.subtitle = subtitle;
    }
}
