package com.sandboxol.center.entity;

import com.sandboxol.greendao.entity.BannerEntity;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppConfig {
    private List<String> WhitelistLink;
    private String activityUrl;
    private int activityVersionCode;
    private AdsConfig adsConfig;
    private int dailyShareVersionCode;
    private com.sandboxol.file.entity.DownloadConfig downloadConfig;
    private List<String> downloadGames;
    private int friendRefreshTimes = 30;
    private String gratitudeUrl;
    private boolean isClearCache;
    private boolean isNeedStopServiceAnnouncement;
    private boolean isNeedSystemAnnouncement;
    private boolean isOpenMTP;
    private boolean isOpenMorePay;
    private boolean isOpenUpdateSO;
    private boolean isShowActivity;
    private boolean isShowAds;
    private boolean isShowCampaign;
    private boolean isShowChest;
    private boolean isShowDressRecommend;
    private boolean isShowFriendFollow;
    private boolean isShowFriendMatch;
    private boolean isShowGameGuide;
    private boolean isShowHallowmasChest;
    private boolean isShowMainGuide;
    private boolean isShowMoreGame;
    private boolean isShowPartyInvite;
    private boolean isShowShare;
    private boolean isShowThirdPart;
    private boolean isShowTopActivity;
    private boolean isShowUniversalActivity;
    private boolean isSilentDownload;
    private boolean isUseNewSearch;
    private String newGratitudeUrl;
    private int pingReportInterval;
    private int reportInterval;
    private int sensitiveWordVersion;
    private AdsConfig specialAdsConfig;
    private List<String> tempMTPBlackList;
    private List<TribeBanner> tribeIntroduction;
    private int universalActivityVersionCode;
    private List<String> v2CommonGameList;
    private List<BannerEntity> videoBanner;
    private int videoSubmitActivityCode;
    private VideoSubmitActivityConfig videoSubmitActivityConfig;
    private List<Integer> vipList;

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public int getActivityVersionCode() {
        return this.activityVersionCode;
    }

    public AdsConfig getAdsConfig() {
        return this.adsConfig;
    }

    public int getDailyShareVersionCode() {
        return this.dailyShareVersionCode;
    }

    public com.sandboxol.file.entity.DownloadConfig getDownloadConfig() {
        return this.downloadConfig;
    }

    public List<String> getDownloadGames() {
        return this.downloadGames;
    }

    public int getFriendRefreshTimes() {
        return this.friendRefreshTimes;
    }

    public String getGratitudeUrl() {
        return this.gratitudeUrl;
    }

    public String getNewGratitudeUrl() {
        return this.newGratitudeUrl;
    }

    public int getPingReportInterval() {
        return this.pingReportInterval;
    }

    public int getReportInterval() {
        return this.reportInterval;
    }

    public int getSensitiveWordVersion() {
        return this.sensitiveWordVersion;
    }

    public AdsConfig getSpecialAdsConfig() {
        return this.specialAdsConfig;
    }

    public List<String> getTempMTPBlackList() {
        return this.tempMTPBlackList;
    }

    public List<TribeBanner> getTribeIntroduction() {
        return this.tribeIntroduction;
    }

    public int getUniversalActivityVersionCode() {
        return this.universalActivityVersionCode;
    }

    public List<String> getV2CommonGameList() {
        return this.v2CommonGameList;
    }

    public List<BannerEntity> getVideoBanner() {
        return this.videoBanner;
    }

    public int getVideoSubmitActivityCode() {
        return this.videoSubmitActivityCode;
    }

    public VideoSubmitActivityConfig getVideoSubmitActivityConfig() {
        return this.videoSubmitActivityConfig;
    }

    public List<Integer> getVipList() {
        return this.vipList;
    }

    public List<String> getWhitelistLink() {
        return this.WhitelistLink;
    }

    public boolean isClearCache() {
        return this.isClearCache;
    }

    public boolean isNeedStopServiceAnnouncement() {
        return this.isNeedStopServiceAnnouncement;
    }

    public boolean isNeedSystemAnnouncement() {
        return this.isNeedSystemAnnouncement;
    }

    public boolean isOpenMTP() {
        return this.isOpenMTP;
    }

    public boolean isOpenMorePay() {
        return this.isOpenMorePay;
    }

    public boolean isOpenUpdateSO() {
        return this.isOpenUpdateSO;
    }

    public boolean isShowActivity() {
        return this.isShowActivity;
    }

    public boolean isShowAds() {
        return this.isShowAds;
    }

    public boolean isShowCampaign() {
        return this.isShowCampaign;
    }

    public boolean isShowChest() {
        return this.isShowChest;
    }

    public boolean isShowDressRecommend() {
        return this.isShowDressRecommend;
    }

    public boolean isShowFriendFollow() {
        return this.isShowFriendFollow;
    }

    public boolean isShowFriendMatch() {
        return this.isShowFriendMatch;
    }

    public boolean isShowGameGuide() {
        return this.isShowGameGuide;
    }

    public boolean isShowHallowmasChest() {
        return this.isShowHallowmasChest;
    }

    public boolean isShowMainGuide() {
        return this.isShowMainGuide;
    }

    public boolean isShowMoreGame() {
        return this.isShowMoreGame;
    }

    public boolean isShowPartyInvite() {
        return this.isShowPartyInvite;
    }

    public boolean isShowShare() {
        return this.isShowShare;
    }

    public boolean isShowThirdPart() {
        return this.isShowThirdPart;
    }

    public boolean isShowTopActivity() {
        return this.isShowTopActivity;
    }

    public boolean isShowUniversalActivity() {
        return this.isShowUniversalActivity;
    }

    public boolean isSilentDownload() {
        return this.isSilentDownload;
    }

    public boolean isUseNewSearch() {
        return this.isUseNewSearch;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public void setActivityVersionCode(int i) {
        this.activityVersionCode = i;
    }

    public void setAdsConfig(AdsConfig adsConfig) {
        this.adsConfig = adsConfig;
    }

    public void setClearCache(boolean z) {
        this.isClearCache = z;
    }

    public void setDailyShareVersionCode(int i) {
        this.dailyShareVersionCode = i;
    }

    public void setDownloadConfig(com.sandboxol.file.entity.DownloadConfig downloadConfig) {
        this.downloadConfig = downloadConfig;
    }

    public void setDownloadGames(List<String> list) {
        this.downloadGames = list;
    }

    public void setFriendRefreshTimes(int i) {
        this.friendRefreshTimes = i;
    }

    public void setGratitudeUrl(String str) {
        this.gratitudeUrl = str;
    }

    public void setNeedStopServiceAnnouncement(boolean z) {
        this.isNeedStopServiceAnnouncement = z;
    }

    public void setNeedSystemAnnouncement(boolean z) {
        this.isNeedSystemAnnouncement = z;
    }

    public void setNewGratitudeUrl(String str) {
        this.newGratitudeUrl = str;
    }

    public void setOpenMTP(boolean z) {
        this.isOpenMTP = z;
    }

    public void setOpenMorePay(boolean z) {
        this.isOpenMorePay = z;
    }

    public void setOpenUpdateSO(boolean z) {
        this.isOpenUpdateSO = z;
    }

    public void setPingReportInterval(int i) {
        this.pingReportInterval = i;
    }

    public void setReportInterval(int i) {
        this.reportInterval = i;
    }

    public void setSensitiveWordVersion(int i) {
        this.sensitiveWordVersion = i;
    }

    public void setShowActivity(boolean z) {
        this.isShowActivity = z;
    }

    public void setShowAds(boolean z) {
        this.isShowAds = z;
    }

    public void setShowCampaign(boolean z) {
        this.isShowCampaign = z;
    }

    public void setShowChest(boolean z) {
        this.isShowChest = z;
    }

    public void setShowDressRecommend(boolean z) {
        this.isShowDressRecommend = z;
    }

    public void setShowFriendFollow(boolean z) {
        this.isShowFriendFollow = z;
    }

    public void setShowFriendMatch(boolean z) {
        this.isShowFriendMatch = z;
    }

    public void setShowGameGuide(boolean z) {
        this.isShowGameGuide = z;
    }

    public void setShowHallowmasChest(boolean z) {
        this.isShowHallowmasChest = z;
    }

    public void setShowMainGuide(boolean z) {
        this.isShowMainGuide = z;
    }

    public void setShowMoreGame(boolean z) {
        this.isShowMoreGame = z;
    }

    public void setShowPartyInvite(boolean z) {
        this.isShowPartyInvite = z;
    }

    public void setShowShare(boolean z) {
        this.isShowShare = z;
    }

    public void setShowThirdPart(boolean z) {
        this.isShowThirdPart = z;
    }

    public void setShowTopActivity(boolean z) {
        this.isShowTopActivity = z;
    }

    public void setShowUniversalActivity(boolean z) {
        this.isShowUniversalActivity = z;
    }

    public void setSilentDownload(boolean z) {
        this.isSilentDownload = z;
    }

    public void setSpecialAdsConfig(AdsConfig adsConfig) {
        this.specialAdsConfig = adsConfig;
    }

    public void setTempMTPBlackList(List<String> list) {
        this.tempMTPBlackList = list;
    }

    public void setTribeIntroduction(List<TribeBanner> list) {
        this.tribeIntroduction = list;
    }

    public void setUniversalActivityVersionCode(int i) {
        this.universalActivityVersionCode = i;
    }

    public void setUseNewSearch(boolean z) {
        this.isUseNewSearch = z;
    }

    public void setV2CommonGameList(List<String> list) {
        this.v2CommonGameList = list;
    }

    public void setVideoBanner(List<BannerEntity> list) {
        this.videoBanner = list;
    }

    public void setVideoSubmitActivityCode(int i) {
        this.videoSubmitActivityCode = i;
    }

    public void setVideoSubmitActivityConfig(VideoSubmitActivityConfig videoSubmitActivityConfig) {
        this.videoSubmitActivityConfig = videoSubmitActivityConfig;
    }

    public void setVipList(List<Integer> list) {
        this.vipList = list;
    }

    public void setWhitelistLink(List<String> list) {
        this.WhitelistLink = list;
    }
}
