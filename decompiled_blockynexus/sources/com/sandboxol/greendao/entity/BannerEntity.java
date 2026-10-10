package com.sandboxol.greendao.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BannerEntity implements Serializable {
    private List<String> countryList;
    private int id;
    private String image;
    private boolean isFullScreen;
    private boolean isInside;
    private boolean isTest;
    private String title;
    private Map<String, String> titles;
    private String url;
    private int version;
    private long videoId;

    public List<String> getCountryList() {
        return this.countryList;
    }

    public int getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public String getTitle() {
        return this.title;
    }

    public Map<String, String> getTitles() {
        return this.titles;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersion() {
        return this.version;
    }

    public long getVideoId() {
        return this.videoId;
    }

    public boolean isFullScreen() {
        return this.isFullScreen;
    }

    public boolean isInside() {
        return this.isInside;
    }

    public boolean isTest() {
        return this.isTest;
    }

    public void setCountryList(List<String> list) {
        this.countryList = list;
    }

    public void setFullScreen(boolean z) {
        this.isFullScreen = z;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setInside(boolean z) {
        this.isInside = z;
    }

    public void setTest(boolean z) {
        this.isTest = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitles(Map<String, String> map) {
        this.titles = map;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setVideoId(long j) {
        this.videoId = j;
    }
}
