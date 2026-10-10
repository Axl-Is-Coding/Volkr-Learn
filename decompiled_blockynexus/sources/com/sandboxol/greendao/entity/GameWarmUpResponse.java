package com.sandboxol.greendao.entity;

import androidx.databinding.BaseObservable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GameWarmUpResponse extends BaseObservable implements Serializable {
    private AuthorInfo authorInfo;
    private List<String> bannerPic;
    private List<BannerPic> featuredPlay;
    private String gameCoverPic;
    private String gameDetail;
    private String gameId;
    private String gameTitle;
    private List<String> images;
    private int isPublish;

    public AuthorInfo getAuthorInfo() {
        return this.authorInfo;
    }

    public List<String> getBannerPic() {
        return this.bannerPic;
    }

    public List<BannerPic> getFeaturedPlay() {
        return this.featuredPlay;
    }

    public String getGameCoverPic() {
        return this.gameCoverPic;
    }

    public String getGameDetail() {
        return this.gameDetail;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getGameTitle() {
        return this.gameTitle;
    }

    public List<String> getImages() {
        List<String> list = this.images;
        return list == null ? new ArrayList() : list;
    }

    public int getIsPublish() {
        return this.isPublish;
    }

    public boolean isCampaign() {
        return "g9990".equals(this.gameId);
    }

    public void notifyData(GameWarmUpResponse gameWarmUpResponse) {
        setBannerPic(gameWarmUpResponse.getBannerPic());
        setFeaturedPlay(gameWarmUpResponse.getFeaturedPlay());
        setGameCoverPic(gameWarmUpResponse.getGameCoverPic());
        setGameDetail(gameWarmUpResponse.getGameDetail());
        setGameId(gameWarmUpResponse.getGameId());
        setGameTitle(gameWarmUpResponse.getGameTitle());
        setImages(gameWarmUpResponse.getImages());
        setIsPublish(gameWarmUpResponse.getIsPublish());
        setAuthorInfo(gameWarmUpResponse.getAuthorInfo());
        notifyChange();
    }

    public void setAuthorInfo(AuthorInfo authorInfo) {
        this.authorInfo = authorInfo;
    }

    public void setBannerPic(List<String> list) {
        this.bannerPic = list;
    }

    public void setFeaturedPlay(List<BannerPic> list) {
        this.featuredPlay = list;
    }

    public void setGameCoverPic(String str) {
        this.gameCoverPic = str;
    }

    public void setGameDetail(String str) {
        this.gameDetail = str;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setGameTitle(String str) {
        this.gameTitle = str;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public void setIsPublish(int i) {
        this.isPublish = i;
    }
}
