package com.sandboxol.center.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BuyRecommendRequest {
    private List<BuyRecommendListBean> buyRecommendList;
    private int engineVersion;

    public static class BuyRecommendListBean {
        private int day;
        private int recommendId;

        public int getDay() {
            return this.day;
        }

        public int getRecommendId() {
            return this.recommendId;
        }

        public void setDay(int i) {
            this.day = i;
        }

        public void setRecommendId(int i) {
            this.recommendId = i;
        }
    }

    public List<BuyRecommendListBean> getBuyRecommendList() {
        return this.buyRecommendList;
    }

    public int getEngineVersion() {
        return this.engineVersion;
    }

    public void setBuyRecommendList(List<BuyRecommendListBean> list) {
        this.buyRecommendList = list;
    }

    public void setEngineVersion(int i) {
        this.engineVersion = i;
    }
}
