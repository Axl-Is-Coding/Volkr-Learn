package com.disabngo.blockynexus.entity;

import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public class CampaignHistory {
    private String bet;
    private String dateStr;
    private long gameId;
    private String homeCountry;
    private long integral;
    private long integralReward;
    private String result;
    private int status;
    private String visitCountry;

    public CampaignHistory(long j, String str, String str2, String str3, long j2, String str4, String str5, int i, long j3) {
        this.gameId = j;
        this.homeCountry = str;
        this.visitCountry = str2;
        this.bet = str3;
        this.integral = j2;
        this.dateStr = str4;
        this.result = str5;
        this.status = i;
        this.integralReward = j3;
    }

    public String betIntegral() {
        return BaseApplication.getContext().getString(R.string.campaign_my_bet_integral, Long.valueOf(this.integral));
    }

    public String getBet() {
        return this.bet;
    }

    public String getBetResult() {
        int i = this.status;
        if (i == 1) {
            return BaseApplication.getContext().getString(R.string.campaign_my_bet_result, this.bet);
        }
        if (i == 2) {
            return BaseApplication.getContext().getString(R.string.campaign_my_bet_result, this.bet) + "(" + BaseApplication.getContext().getString(R.string.campaign_correct) + ")";
        }
        if (i != 3) {
            return BaseApplication.getContext().getString(R.string.campaign_my_bet_result, this.bet);
        }
        return BaseApplication.getContext().getString(R.string.campaign_my_bet_result, this.bet) + "(" + BaseApplication.getContext().getString(R.string.campaign_wrong) + ")";
    }

    public String getDateStr() {
        return this.dateStr;
    }

    public long getGameId() {
        return this.gameId;
    }

    public String getHomeCountry() {
        return this.homeCountry;
    }

    public long getIntegral() {
        return this.integral;
    }

    public String getIntegralReward() {
        return "+" + this.integralReward;
    }

    public String getResult() {
        return this.result;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTopResult() {
        if (this.status == 1) {
            return BaseApplication.getContext().getString(R.string.campaign_wait_result);
        }
        return this.homeCountry + " " + this.result + " " + this.visitCountry;
    }

    public String getVS() {
        return this.homeCountry + " VS " + this.visitCountry;
    }

    public String getVisitCountry() {
        return this.visitCountry;
    }

    public String rewardResult() {
        int i = this.status;
        return i != 1 ? i != 2 ? i != 3 ? "" : BaseApplication.getContext().getString(R.string.campaign_bet_error) : BaseApplication.getContext().getString(R.string.campaign_integral) : BaseApplication.getContext().getString(R.string.campaign_wait_result2);
    }

    public void setBet(String str) {
        this.bet = str;
    }

    public void setDateStr(String str) {
        this.dateStr = str;
    }

    public void setGameId(long j) {
        this.gameId = j;
    }

    public void setHomeCountry(String str) {
        this.homeCountry = str;
    }

    public void setIntegral(long j) {
        this.integral = j;
    }

    public void setIntegralReward(long j) {
        this.integralReward = j;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setVisitCountry(String str) {
        this.visitCountry = str;
    }
}
