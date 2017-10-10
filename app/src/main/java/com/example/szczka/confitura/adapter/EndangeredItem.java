package com.example.szczka.confitura.adapter;

public class EndangeredItem {
    private String mName, mUrl = "";
    private int mThumbnail;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
