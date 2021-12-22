package com.namimono.entities;

public class Channel {
    private String url;

    public Channel(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
