package com.sandboxol.blocky.entity;

import androidx.databinding.BaseObservable;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.text.DecimalFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Game extends BaseObservable {
    private boolean appreciate;
    private List<String> bannerPic;
    private String gameCoverPic;
    private String gameDetail;
    private String gameId;
    private int gameMode;
    private String gameName;
    private String gameTitle;
    private List<String> gameTypes;
    private int isNewEngine = 0;
    private int isRankOnline;
    private int isShopOnline;
    private int onlineNumber;
    private int praiseNumber;
    private int turntableRemainCount;
    private int turntableStatus;
    private int version;
    private int visitorEnter;
    private GameWarmUpResponse warmUpResponse;

    public Game copy() {
        Game game = new Game();
        game.setGameId(this.gameId);
        game.setGameTitle(this.gameTitle);
        game.setGameCoverPic(this.gameCoverPic);
        game.setBannerPic(this.bannerPic);
        game.setGameDetail(this.gameDetail);
        game.setGameTypes(this.gameTypes);
        game.setPraiseNumber(this.praiseNumber);
        game.setAppreciate(this.appreciate);
        game.setOnlineNumber(this.onlineNumber);
        game.setGameName(this.gameName);
        game.setGameMode(this.gameMode);
        game.setVisitorEnter(this.visitorEnter);
        game.setVersion(this.version);
        return game;
    }

    public List<String> getBannerPic() {
        return this.bannerPic;
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

    public int getGameMode() {
        return this.gameMode;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGameTitle() {
        return this.gameTitle;
    }

    public List<String> getGameTypes() {
        return this.gameTypes;
    }

    public int getIsNewEngine() {
        return this.isNewEngine;
    }

    public int getIsRankOnline() {
        return this.isRankOnline;
    }

    public int getIsShopOnline() {
        return this.isShopOnline;
    }

    public int getOnlineNumber() {
        return this.onlineNumber;
    }

    public int getPraiseNumber() {
        return this.praiseNumber;
    }

    public String getStringText() {
        int i = this.onlineNumber;
        if (i <= 10000) {
            return String.valueOf(i);
        }
        return new DecimalFormat(IdManager.DEFAULT_VERSION_NAME).format(i / 1000.0f) + "k";
    }

    public int getTurntableRemainCount() {
        return this.turntableRemainCount;
    }

    public int getTurntableStatus() {
        return this.turntableStatus;
    }

    public int getVersion() {
        return this.version;
    }

    public int getVisitorEnter() {
        return this.visitorEnter;
    }

    public GameWarmUpResponse getWarmUpResponse() {
        return this.warmUpResponse;
    }

    public boolean isAppreciate() {
        return this.appreciate;
    }

    public void setAppreciate(boolean z) {
        this.appreciate = z;
        notifyChange();
    }

    public void setBannerPic(List<String> list) {
        this.bannerPic = list;
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

    public void setGameMode(int i) {
        this.gameMode = i;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGameTitle(String str) {
        this.gameTitle = str;
    }

    public void setGameTypes(List<String> list) {
        this.gameTypes = list;
    }

    public void setIsNewEngine(int i) {
        this.isNewEngine = i;
    }

    public void setIsRankOnline(int i) {
        this.isRankOnline = i;
    }

    public void setIsShopOnline(int i) {
        this.isShopOnline = i;
    }

    public void setOnlineNumber(int i) {
        this.onlineNumber = i;
    }

    public void setPraiseNumber(int i) {
        this.praiseNumber = i;
        notifyChange();
    }

    public void setTurntableRemainCount(int i) {
        this.turntableRemainCount = i;
    }

    public void setTurntableStatus(int i) {
        this.turntableStatus = i;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setVisitorEnter(int i) {
        this.visitorEnter = i;
    }

    public void setWarmUpResponse(GameWarmUpResponse gameWarmUpResponse) {
        this.warmUpResponse = gameWarmUpResponse;
    }
}
