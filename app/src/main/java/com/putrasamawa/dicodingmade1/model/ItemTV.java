package com.putrasamawa.dicodingmade1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

//* Satria Junanda *//

public class ItemTV implements Parcelable {
    public static final Parcelable.Creator<ItemTV> CREATOR = new Parcelable.Creator<ItemTV>() {
        public ItemTV createFromParcel(Parcel in) {
            return new ItemTV(in);
        }

        public ItemTV[] newArray(int size) {
            return new ItemTV[size];
        }
    };

    @SerializedName("original_name")
    private String original_title;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("vote_average")
    private String vote_average;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public ItemTV(Parcel in) {
        this.id = in.readString();
        this.original_title = in.readString();
        this.overview = in.readString();
        this.poster_path = in.readString();
    }

    public ItemTV() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.poster_path);
        dest.writeValue(this.id);
        dest.writeString(this.original_title);
        dest.writeString(this.overview);

    }

    public ItemTV(String filmId, String filmTitle, String poster, String ovr) {
        this.id = filmId;
        this.original_title = filmTitle;
        this.poster_path = poster;
        this.overview = ovr;
    }
    public int describeContents() {
        return 0;
    }
}

//* Satria Junanda *//