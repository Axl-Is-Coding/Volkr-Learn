package com.sandboxol.center.entity;

import com.sandboxol.common.utils.CommonHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LatestVersion {
    private String apkMd5;
    private String apkUrl;
    private String content;
    private Map<String, DownInfo> downInfoMap;
    private List<String> downloadGames;
    private Map<String, Lang> langMap;
    private List<String> needTobeForceUpdateVersions;
    private String picUrl;
    private String url;
    private String updateInfo = "";
    private int newVersionCode = 0;
    private int smallerThanVersion = 0;
    private int forceUpdateMinVersionCode = 0;
    private int forceUpdateMaxVersionCode = 0;
    private int status = 0;

    public String getApkMd5() {
        return this.apkMd5;
    }

    public String getApkUrl() {
        return this.apkUrl;
    }

    public String getContent(boolean z) {
        Map<String, Lang> map = this.langMap;
        if (map != null && this.content == null) {
            Lang lang = map.get(CommonHelper.getLanguage());
            if (lang == null) {
                lang = this.langMap.get("en_US");
            }
            if (lang != null) {
                this.content = z ? lang.getForcible() : lang.getNormal();
            }
        }
        if (this.content == null) {
            this.content = getUpdateInfo();
        }
        return this.content;
    }

    public Map<String, DownInfo> getDownInfoMap() {
        return this.downInfoMap;
    }

    public List<String> getDownloadGames() {
        return this.downloadGames;
    }

    public int getForceUpdateMaxVersionCode() {
        return this.forceUpdateMaxVersionCode;
    }

    public int getForceUpdateMinVersionCode() {
        return this.forceUpdateMinVersionCode;
    }

    public List<String> getNeedTobeForceUpdateVersions() {
        if (this.needTobeForceUpdateVersions == null) {
            this.needTobeForceUpdateVersions = new ArrayList();
        }
        return this.needTobeForceUpdateVersions;
    }

    public int getNewVersionCode() {
        return this.newVersionCode;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getSmallerThanVersion() {
        return this.smallerThanVersion;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUpdateInfo() {
        return this.updateInfo;
    }

    public String getUrl() {
        return this.url;
    }

    public void setApkMd5(String str) {
        this.apkMd5 = str;
    }

    public void setApkUrl(String str) {
        this.apkUrl = str;
    }

    public void setDownInfoMap(Map<String, DownInfo> map) {
        this.downInfoMap = map;
    }

    public void setDownloadGames(List<String> list) {
        this.downloadGames = list;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
