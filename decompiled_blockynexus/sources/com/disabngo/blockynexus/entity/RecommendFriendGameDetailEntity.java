package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendFriendGameDetailEntity {
    private String gameTitle;
    private String language;

    public String getGameTitle() {
        return this.gameTitle;
    }

    public String getLanguage() {
        return this.language.length() == 5 ? this.language.substring(0, 2) : this.language;
    }

    public void setGameTitle(String str) {
        this.gameTitle = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }
}
