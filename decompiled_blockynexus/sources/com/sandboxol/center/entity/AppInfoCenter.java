package com.sandboxol.center.entity;

import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.gson.j;
import com.sandboxol.center.utils.AppSharedUtils;
import com.sandboxol.common.base.app.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class AppInfoCenter {
    private static AppInfoCenter appInfoCenter;
    private AdsCdConfig adsCdConfig;
    private AppConfig appConfig;
    private boolean authTokenSuccess;
    private BlockAccountResult blockAccount;
    private Map<String, List<String>> gameDetailToEditor = new HashMap();
    private boolean hasUpdateUserInfo;
    private boolean isNowParty;
    private boolean isShowThirdPart;
    private String latelyRegion;
    private LatestVersion latestVersion;
    private List<String> quickInText;
    private ResCheckEntity resCheckEntity;
    private SystemAnnouncementInfo stopServiceAnnouncementInfo;
    private SystemAnnouncementInfo systemAnnouncementInfo;

    private AppInfoCenter() {
    }

    static /* synthetic */ void a(AppInfoCenter appInfoCenter2) {
        synchronized (AccountCenter.class) {
            AppSharedUtils.newInstance().putAccountInfo(new j().a(appInfoCenter2));
        }
    }

    public static AppInfoCenter newInstance() {
        if (appInfoCenter == null) {
            appInfoCenter = new AppInfoCenter();
        }
        return appInfoCenter;
    }

    public static synchronized void storeAppInfo(final AppInfoCenter appInfoCenter2) {
        BaseApplication.getThreadPool().setName("storeAppInfo");
        BaseApplication.getThreadPool().execute(new Runnable() { // from class: com.sandboxol.center.entity.b
            @Override // java.lang.Runnable
            public final void run() {
                AppInfoCenter.a(this.f16327a);
            }
        });
    }

    public AdsCdConfig getAdsCdConfig() {
        AdsCdConfig adsCdConfig = this.adsCdConfig;
        return adsCdConfig == null ? new AdsCdConfig() : adsCdConfig;
    }

    public AppConfig getAppConfig() {
        AppConfig appConfig = this.appConfig;
        return appConfig == null ? new AppConfig() : appConfig;
    }

    public BlockAccountResult getBlockAccount() {
        return this.blockAccount;
    }

    public Map<String, List<String>> getGameDetailToEditor() {
        return this.gameDetailToEditor;
    }

    public String getLatelyRegion() {
        String str = this.latelyRegion;
        return str == null ? NativeContentAd.ASSET_HEADLINE : str;
    }

    public LatestVersion getLatestVersion() {
        return this.latestVersion;
    }

    public List<String> getQuickInText() {
        return this.quickInText;
    }

    public ResCheckEntity getResCheckEntity() {
        return this.resCheckEntity;
    }

    public SystemAnnouncementInfo getStopServiceAnnouncementInfo() {
        return this.stopServiceAnnouncementInfo;
    }

    public SystemAnnouncementInfo getSystemAnnouncementInfo() {
        return this.systemAnnouncementInfo;
    }

    public boolean isAuthTokenSuccess() {
        return this.authTokenSuccess;
    }

    public boolean isNowParty() {
        return this.isNowParty;
    }

    public boolean isShowGameDetailToEditor(String str) {
        Map<String, List<String>> map = this.gameDetailToEditor;
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = this.gameDetailToEditor.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void setAdsCdConfig(AdsCdConfig adsCdConfig) {
        this.adsCdConfig = adsCdConfig;
    }

    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
        com.sandboxol.file.entity.DownloadConfig.newInstance().setDownloadConfig(appConfig.getDownloadConfig());
    }

    public void setAuthTokenSuccess(boolean z) {
        this.authTokenSuccess = z;
    }

    public void setBlockAccount(BlockAccountResult blockAccountResult) {
        this.blockAccount = blockAccountResult;
    }

    public void setGameDetailToEditor(Map<String, List<String>> map) {
        this.gameDetailToEditor = map;
    }

    public void setLatelyRegion(String str) {
        this.latelyRegion = str;
    }

    public void setLatestVersion(LatestVersion latestVersion) {
        this.latestVersion = latestVersion;
    }

    public void setNowParty(boolean z) {
        this.isNowParty = z;
    }

    public void setQuickInText(List<String> list) {
        this.quickInText = list;
    }

    public void setResCheckEntity(ResCheckEntity resCheckEntity) {
        this.resCheckEntity = resCheckEntity;
    }

    public void setStopServiceAnnouncementInfo(SystemAnnouncementInfo systemAnnouncementInfo) {
        this.stopServiceAnnouncementInfo = systemAnnouncementInfo;
    }

    public void setSystemAnnouncementInfo(SystemAnnouncementInfo systemAnnouncementInfo) {
        this.systemAnnouncementInfo = systemAnnouncementInfo;
    }
}
