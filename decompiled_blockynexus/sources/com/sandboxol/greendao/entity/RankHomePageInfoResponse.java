package com.sandboxol.greendao.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RankHomePageInfoResponse {
    private long remainingTime;
    private List<TopRankInfo> topRankInfos;

    public long getRemainingTime() {
        return this.remainingTime;
    }

    public List<TopRankInfo> getTopRankInfos() {
        return this.topRankInfos;
    }

    public void setRemainingTime(long j) {
        this.remainingTime = j;
    }

    public void setTopRankInfos(List<TopRankInfo> list) {
        this.topRankInfos = list;
    }
}
