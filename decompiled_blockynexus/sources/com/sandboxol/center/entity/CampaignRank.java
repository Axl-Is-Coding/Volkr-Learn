package com.sandboxol.center.entity;

import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: loaded from: classes3.dex */
public class CampaignRank {
    private String headPic;
    private long integral;
    private boolean isFirst;
    private String nickName;
    private int rank;
    private long userId;
    private int vip;

    public CampaignRank(int i, String str, String str2, long j, int i2) {
        this.userId = i;
        this.headPic = str;
        this.nickName = str2;
        this.integral = j;
        this.rank = i2;
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public long getIntegral() {
        return this.integral;
    }

    public String getIntegralDetail() {
        return BaseApplication.getContext().getString(R.string.base_game_detail_integral, Long.valueOf(this.integral));
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getRank() {
        return this.rank;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserRank() {
        return this.integral == 0 ? "—" : String.valueOf(this.rank);
    }

    public int getVip() {
        return this.vip;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setIntegral(long j) {
        this.integral = j;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setRank(int i) {
        this.rank = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setVip(int i) {
        this.vip = i;
    }
}
