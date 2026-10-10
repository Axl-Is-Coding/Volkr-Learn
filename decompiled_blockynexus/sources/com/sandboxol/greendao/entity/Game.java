package com.sandboxol.greendao.entity;

import com.google.firebase.crashlytics.internal.common.IdManager;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Game implements Serializable, Cloneable {
    private static final long serialVersionUID = 100;
    private boolean appreciate;
    private AuthorInfo authorInfo;
    private List<String> bannerPic;
    private int complexNum;
    private long createTime;
    private int currentPage;
    private int currentSize;
    private List<BannerEntity> gameBannerVideoInfos;
    private String gameCoverPic;
    private String gameDetail;
    private String gameId;
    private int gameMode;
    private String gameName;
    private GamePayInfo gamePayInfo;
    private String gameTitle;
    private List<String> gameTypes;
    private String gameUgcType;
    private int index;
    private int isNewEngine;
    private int isOpenParty;
    private int isPay;
    private int isRankOnline;
    private int isShopOnline;
    private int isUgcGame;
    private ResourceLatestVersionData latestResVersions;
    private int onlineNumber;
    private int pageType;
    private int praiseNumber;
    private List<RealPlayGame> realPlayGameList;
    private long resVersion;
    private int turntableRemainCount;
    private int turntableStatus;
    private long typeId;
    private int version;
    private int visitorEnter;
    private GameWarmUpResponse warmUpResponse;

    public Game(String str) {
        this.gameId = str;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        return this.gameId.equals(((Game) obj).gameId);
    }

    public boolean getAppreciate() {
        return this.appreciate;
    }

    public AuthorInfo getAuthorInfo() {
        return this.authorInfo;
    }

    public List<String> getBannerPic() {
        return this.bannerPic;
    }

    public int getComplexNum() {
        return this.complexNum;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public List<BannerEntity> getGameBannerVideoInfos() {
        return this.gameBannerVideoInfos;
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

    public GamePayInfo getGamePayInfo() {
        return this.gamePayInfo;
    }

    public String getGameTitle() {
        return this.gameTitle;
    }

    public List<String> getGameTypes() {
        return this.gameTypes;
    }

    public String getGameUgcType() {
        return this.gameUgcType;
    }

    public int getIndex() {
        return this.index;
    }

    public int getIsNewEngine() {
        return this.isNewEngine;
    }

    public int getIsOpenParty() {
        return this.isOpenParty;
    }

    public int getIsPay() {
        return this.isPay;
    }

    public int getIsRankOnline() {
        return this.isRankOnline;
    }

    public int getIsShopOnline() {
        return this.isShopOnline;
    }

    public int getIsUgc() {
        return this.isUgcGame;
    }

    public int getIsUgcGame() {
        return this.isUgcGame;
    }

    public ResourceLatestVersionData getLatestResVersions() {
        if (this.latestResVersions == null) {
            this.latestResVersions = new ResourceLatestVersionData(0L, 0L, 0L);
        }
        return this.latestResVersions;
    }

    public int getOnlineNumber() {
        return this.onlineNumber;
    }

    public int getPageType() {
        return this.pageType;
    }

    public int getPraiseNumber() {
        return this.praiseNumber;
    }

    public List<RealPlayGame> getRealPlayGameList() {
        return this.realPlayGameList;
    }

    public long getResVersion() {
        return this.resVersion;
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

    public long getTypeId() {
        return this.typeId;
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

    public void setAppreciate(boolean z) {
        this.appreciate = z;
    }

    public void setAuthorInfo(AuthorInfo authorInfo) {
        this.authorInfo = authorInfo;
    }

    public void setBannerPic(List<String> list) {
        this.bannerPic = list;
    }

    public void setComplexNum(int i) {
        this.complexNum = i;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public void setCurrentSize(int i) {
        this.currentSize = i;
    }

    public void setGameBannerVideoInfos(List<BannerEntity> list) {
        this.gameBannerVideoInfos = list;
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

    public void setGamePayInfo(GamePayInfo gamePayInfo) {
        this.gamePayInfo = gamePayInfo;
    }

    public void setGameTitle(String str) {
        this.gameTitle = str;
    }

    public void setGameTypes(List<String> list) {
        this.gameTypes = list;
    }

    public void setGameUgcType(String str) {
        this.gameUgcType = str;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setIsNewEngine(int i) {
        this.isNewEngine = i;
    }

    public void setIsOpenParty(int i) {
        this.isOpenParty = i;
    }

    public void setIsPay(int i) {
        this.isPay = i;
    }

    public void setIsRankOnline(int i) {
        this.isRankOnline = i;
    }

    public void setIsShopOnline(int i) {
        this.isShopOnline = i;
    }

    public void setIsUgc(int i) {
        this.isUgcGame = i;
    }

    public void setIsUgcGame(int i) {
        this.isUgcGame = i;
    }

    public void setLatestResVersions(ResourceLatestVersionData resourceLatestVersionData) {
        this.latestResVersions = resourceLatestVersionData;
    }

    public void setOnlineNumber(int i) {
        this.onlineNumber = i;
    }

    public void setPageType(int i) {
        this.pageType = i;
    }

    public void setPraiseNumber(int i) {
        this.praiseNumber = i;
    }

    public void setRealPlayGameList(List<RealPlayGame> list) {
        this.realPlayGameList = list;
    }

    public void setResVersion(long j) {
        this.resVersion = j;
    }

    public void setTurntableRemainCount(int i) {
        this.turntableRemainCount = i;
    }

    public void setTurntableStatus(int i) {
        this.turntableStatus = i;
    }

    public void setTypeId(long j) {
        this.typeId = j;
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

    public Game(String str, int i) {
        this.gameId = str;
        this.pageType = i;
    }

    public Game(String str, String str2, String str3, String str4, List<String> list, List<BannerEntity> list2, String str5, List<String> list3, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, long j, int i14, long j2, long j3, int i15, int i16, int i17, int i18, String str6, GamePayInfo gamePayInfo, GameWarmUpResponse gameWarmUpResponse, AuthorInfo authorInfo, List<RealPlayGame> list4, ResourceLatestVersionData resourceLatestVersionData) {
        this.gameId = str;
        this.gameTitle = str2;
        this.gameName = str3;
        this.gameCoverPic = str4;
        this.bannerPic = list;
        this.gameBannerVideoInfos = list2;
        this.gameDetail = str5;
        this.gameTypes = list3;
        this.appreciate = z;
        this.gameMode = i;
        this.visitorEnter = i2;
        this.version = i3;
        this.isRankOnline = i4;
        this.isShopOnline = i5;
        this.isOpenParty = i6;
        this.isPay = i7;
        this.turntableStatus = i8;
        this.turntableRemainCount = i9;
        this.isNewEngine = i10;
        this.isUgcGame = i11;
        this.currentPage = i12;
        this.currentSize = i13;
        this.resVersion = j;
        this.pageType = i14;
        this.typeId = j2;
        this.createTime = j3;
        this.complexNum = i15;
        this.praiseNumber = i16;
        this.onlineNumber = i17;
        this.index = i18;
        this.gameUgcType = str6;
        this.gamePayInfo = gamePayInfo;
        this.warmUpResponse = gameWarmUpResponse;
        this.authorInfo = authorInfo;
        this.realPlayGameList = list4;
        this.latestResVersions = resourceLatestVersionData;
    }

    public Game() {
    }
}
