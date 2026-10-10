package com.sandboxol.blockmango.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Realms implements Serializable {
    private int appVersionCode;
    private String bgColor;
    private String defaultMcVersion;
    private String desc;
    private List<String> descIcons;
    private int gameMode;
    private String gameName;
    private String icon;
    private boolean isAd;
    private boolean isShowCultivate;
    private boolean isShowJob;
    private boolean isShowRankList;
    private boolean isShowSuperPlayer;
    private boolean isStartBlockMan;
    private boolean isStartBlockManOverseas;
    private String mapId;
    private int minNum;
    private int onlineNum;
    private List<String> props;
    private List<PropsItem> propsList;
    private List<String> showRewardType;
    private String type;
    private String typeName;
    private List<String> unShowRegion;
    private List<String> versions;

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public String getDefaultMcVersion() {
        return this.defaultMcVersion;
    }

    public String getDesc() {
        return this.desc;
    }

    public List<String> getDescIcons() {
        return this.descIcons;
    }

    public int getGameMode() {
        return this.gameMode;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getIcon() {
        return this.icon;
    }

    public boolean getIsAd() {
        return this.isAd;
    }

    public boolean getIsShowCultivate() {
        return this.isShowCultivate;
    }

    public boolean getIsShowJob() {
        return this.isShowJob;
    }

    public boolean getIsShowRankList() {
        return this.isShowRankList;
    }

    public boolean getIsShowSuperPlayer() {
        return this.isShowSuperPlayer;
    }

    public boolean getIsStartBlockMan() {
        return this.isStartBlockMan;
    }

    public boolean getIsStartBlockManOverseas() {
        return this.isStartBlockManOverseas;
    }

    public String getMapId() {
        return this.mapId;
    }

    public int getMinNum() {
        return this.minNum;
    }

    public int getOnlineNum() {
        return this.onlineNum;
    }

    public List<String> getProps() {
        return this.props;
    }

    public List<PropsItem> getPropsList() {
        List<PropsItem> list = this.propsList;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getShowRewardType() {
        return this.showRewardType;
    }

    public String getType() {
        return this.type;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public List<String> getUnShowRegion() {
        return this.unShowRegion;
    }

    public List<String> getVersions() {
        return this.versions;
    }

    public boolean isAd() {
        return this.isAd;
    }

    public boolean isShowCultivate() {
        return this.isShowCultivate;
    }

    public boolean isShowJob() {
        return this.isShowJob;
    }

    public boolean isShowRankList() {
        return this.isShowRankList;
    }

    public boolean isShowSuperPlayer() {
        return this.isShowSuperPlayer;
    }

    public boolean isStartBlockMan() {
        return this.isStartBlockMan;
    }

    public boolean isStartBlockManOverseas() {
        return this.isStartBlockManOverseas;
    }

    public void setAd(boolean z) {
        this.isAd = z;
    }

    public void setAppVersionCode(int i) {
        this.appVersionCode = i;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setDefaultMcVersion(String str) {
        this.defaultMcVersion = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDescIcons(List<String> list) {
        this.descIcons = list;
    }

    public void setGameMode(int i) {
        this.gameMode = i;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIsAd(boolean z) {
        this.isAd = z;
    }

    public void setIsShowCultivate(boolean z) {
        this.isShowCultivate = z;
    }

    public void setIsShowJob(boolean z) {
        this.isShowJob = z;
    }

    public void setIsShowRankList(boolean z) {
        this.isShowRankList = z;
    }

    public void setIsShowSuperPlayer(boolean z) {
        this.isShowSuperPlayer = z;
    }

    public void setIsStartBlockMan(boolean z) {
        this.isStartBlockMan = z;
    }

    public void setIsStartBlockManOverseas(boolean z) {
        this.isStartBlockManOverseas = z;
    }

    public void setMapId(String str) {
        this.mapId = str;
    }

    public void setMinNum(int i) {
        this.minNum = i;
    }

    public void setOnlineNum(int i) {
        this.onlineNum = i;
    }

    public void setProps(List<String> list) {
        this.props = list;
    }

    public void setPropsList(List<PropsItem> list) {
        this.propsList = list;
    }

    public void setShowCultivate(boolean z) {
        this.isShowCultivate = z;
    }

    public void setShowJob(boolean z) {
        this.isShowJob = z;
    }

    public void setShowRankList(boolean z) {
        this.isShowRankList = z;
    }

    public void setShowRewardType(List<String> list) {
        this.showRewardType = list;
    }

    public void setShowSuperPlayer(boolean z) {
        this.isShowSuperPlayer = z;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public void setUnShowRegion(List<String> list) {
        this.unShowRegion = list;
    }

    public void setVersions(List<String> list) {
        this.versions = list;
    }
}
