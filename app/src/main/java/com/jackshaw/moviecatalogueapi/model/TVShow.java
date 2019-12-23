package com.jackshaw.moviecatalogueapi.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShow implements Parcelable {
    private String judul, rating, popularity, release, overview, poster, backdrop;

    public TVShow() {
    }

    public TVShow(String judul, String rating, String popularity, String release, String overview, String poster, String backdrop) {
        this.judul = judul;
        this.rating = rating;
        this.popularity = popularity;
        this.release = release;
        this.overview = overview;
        this.poster = poster;
        this.backdrop = backdrop;
    }

//    setter

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    //getter

    public String getJudul() {
        return judul;
    }

    public String getRating() {
        return rating;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getRelease() {
        return release;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster() {
        return poster;
    }

    public String getBackdrop() {
        return backdrop;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.rating);
        dest.writeString(this.popularity);
        dest.writeString(this.release);
        dest.writeString(this.overview);
        dest.writeString(this.poster);
        dest.writeString(this.backdrop);
    }

    protected TVShow(Parcel in) {
        this.judul = in.readString();
        this.rating = in.readString();
        this.popularity = in.readString();
        this.release = in.readString();
        this.overview = in.readString();
        this.poster = in.readString();
        this.backdrop = in.readString();
    }

    public static final Parcelable.Creator<TVShow> CREATOR = new Parcelable.Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel source) {
            return new TVShow(source);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };
}
