package com.example.asus.mymusic;

public class SongDetails {
    public String Title,Artist,Url;

    public SongDetails()
    {

    }

    public SongDetails(String title, String artist, String url) {
        Title = title;
        Artist = artist;
        Url = url;
    }

    public String getTitle() {
        return Title;
    }

    public String getArtist() {
        return Artist;
    }

    public String getUrl() {
        return Url;
    }
}
