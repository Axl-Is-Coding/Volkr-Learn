package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class CampaignBetRequest {
    private String bet;
    private int gameId;
    private int integral;

    public CampaignBetRequest(int i, String str, int i2) {
        this.gameId = i;
        this.bet = str;
        this.integral = i2;
    }

    public String getBet() {
        return this.bet;
    }

    public int getGameId() {
        return this.gameId;
    }

    public int getIntegral() {
        return this.integral;
    }

    public void setBet(String str) {
        this.bet = str;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setIntegral(int i) {
        this.integral = i;
    }
}
