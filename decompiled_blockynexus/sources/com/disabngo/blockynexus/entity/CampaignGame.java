package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CampaignGame {
    private List<CampaignGameRate> betInfo;
    private List<Integer> betIntegrals;
    private int gameId;
    private String homeCountry;
    private String homeFlag;
    private boolean isFirst;
    private String result;
    private int status;
    private int timeLeft;
    private String visitCountry;
    private String visitFlag;

    public CampaignGame(boolean z) {
        this.isFirst = z;
    }

    public List<CampaignGameRate> getBetInfo() {
        return this.betInfo;
    }

    public List<Integer> getBetIntegrals() {
        return this.betIntegrals;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getHomeCountry() {
        return this.homeCountry;
    }

    public String getHomeFlag() {
        return this.homeFlag;
    }

    public String getNoGameId() {
        return "NO." + this.gameId;
    }

    public String getResult() {
        return this.result;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTimeLeft() {
        return this.timeLeft;
    }

    public String getVisitCountry() {
        return this.visitCountry;
    }

    public String getVisitFlag() {
        return this.visitFlag;
    }

    public String getXRateText(int i) {
        List<CampaignGameRate> list = this.betInfo;
        return (list == null || list.get(i) == null) ? "" : this.betInfo.get(i).getXRate();
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public boolean isShowCenterButton() {
        List<CampaignGameRate> list = this.betInfo;
        if (list == null || list.get(1) == null) {
            return false;
        }
        return this.betInfo.get(1).isShow();
    }

    public void setBetInfo(List<CampaignGameRate> list) {
        this.betInfo = list;
    }

    public void setBetIntegrals(List<Integer> list) {
        this.betIntegrals = list;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setHomeCountry(String str) {
        this.homeCountry = str;
    }

    public void setHomeFlag(String str) {
        this.homeFlag = str;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTimeLeft(int i) {
        this.timeLeft = i;
    }

    public void setVisitCountry(String str) {
        this.visitCountry = str;
    }

    public void setVisitFlag(String str) {
        this.visitFlag = str;
    }

    public CampaignGame(int i, String str, String str2, int i2, int i3, String str3, List<CampaignGameRate> list, List<Integer> list2) {
        this.gameId = i;
        this.homeCountry = str;
        this.result = str2;
        this.status = i2;
        this.timeLeft = i3;
        this.visitCountry = str3;
        this.betInfo = list;
        this.betIntegrals = list2;
    }
}
