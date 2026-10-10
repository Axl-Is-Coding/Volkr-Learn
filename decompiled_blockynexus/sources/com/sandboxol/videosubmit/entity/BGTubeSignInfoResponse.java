package com.sandboxol.videosubmit.entity;

import com.sandboxol.videosubmit.utils.ViewUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BGTubeSignInfoResponse {
    private String countryCode;
    private String countryName;
    private String language;
    private String languageName;
    private int linkCount;
    private List<String> linkList;
    private String youtubeName;

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountryName() {
        List<String>[] countries = ViewUtils.getCountries();
        List<String> list = countries[0];
        List<String> list2 = countries[1];
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).equals(this.countryCode)) {
                return list.get(i);
            }
        }
        return "";
    }

    public String getLanguage() {
        return this.language;
    }

    public String getLanguageName() {
        return ViewUtils.getLanguages().get(this.language);
    }

    public int getLinkCount() {
        return this.linkCount;
    }

    public List<String> getLinkList() {
        return this.linkList;
    }

    public String getYoutubeName() {
        return this.youtubeName;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLanguageName(String str) {
        this.languageName = str;
    }

    public void setLinkCount(int i) {
        this.linkCount = i;
    }

    public void setLinkList(List<String> list) {
        this.linkList = list;
    }

    public void setYoutubeName(String str) {
        this.youtubeName = str;
    }
}
