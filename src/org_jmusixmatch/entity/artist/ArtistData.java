package org_jmusixmatch.entity.artist;

import com.google.gson.annotations.SerializedName;
import java.util.List;
public class ArtistData {
    @SerializedName("begin_date_year")
    private String birthDateYear;
    @SerializedName("begin_date")
    private String birthDate;
    @SerializedName("end")
    private String endDateYear;
    @SerializedName("end_date")
    private String endDate;
    @SerializedName("artist_rating")
    private String artistRating;
    @SerializedName("artist_name")
    private String artistName;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistRating() {
        return artistRating;
    }

    public void setArtistRating(String artistRating) {
        this.artistRating = artistRating;
    }

    public String getBirthDateYear() {
        return birthDateYear;
    }

    public void setBirthDateYear(String birthDateYear) {
        this.birthDateYear = birthDateYear;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEndDateYear() {
        return endDateYear;
    }

    public void setEndDateYear(String endDateYear) {
        this.endDateYear = endDateYear;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
