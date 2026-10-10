package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendFriendEntity {
    private String country;
    private List<String> gameId;
    private String headPic;
    private String language;
    private List<RecommendFriendGameEntity> likeGames;
    private String nickName;
    private boolean searchById;
    private int sex;
    private List<RecommendFriendGameEntity> togetherGames;
    private long userId;
    private int vip;

    public String getCountry() {
        return this.country;
    }

    public List<String> getGameId() {
        return this.gameId;
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public String getLanguage() {
        return this.language;
    }

    public List<RecommendFriendGameEntity> getLikeGames() {
        return this.likeGames;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getSex() {
        return this.sex;
    }

    public List<RecommendFriendGameEntity> getTogetherGames() {
        return this.togetherGames;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getVip() {
        return this.vip;
    }

    public boolean isSearchById() {
        return this.searchById;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setGameId(List<String> list) {
        this.gameId = list;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLikeGames(List<RecommendFriendGameEntity> list) {
        this.likeGames = list;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setSearchById(boolean z) {
        this.searchById = z;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setTogetherGames(List<RecommendFriendGameEntity> list) {
        this.togetherGames = list;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setVip(int i) {
        this.vip = i;
    }
}
