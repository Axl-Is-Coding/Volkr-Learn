package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class RankInfoResponse {
    private long id = -1;
    private String name;
    private String pic;
    private long quantity;
    private long rank;
    private String rankType;

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPic() {
        return this.pic;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public long getRank() {
        return this.rank;
    }

    public String getRankType() {
        return this.rankType;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setQuantity(long j) {
        this.quantity = j;
    }

    public void setRank(long j) {
        this.rank = j;
    }

    public void setRankType(String str) {
        this.rankType = str;
    }
}
