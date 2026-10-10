package com.sandboxol.recharge.entity;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BuyRequest {
    private List<BuyDecorationListBean> buyDecorationList;
    private List<BuySuitListBean> buySuitList;
    private int engineVersion;

    public static class BuyDecorationListBean {
        private int day;
        private int decorationId;

        public BuyDecorationListBean(int i, int i2) {
            this.day = i;
            this.decorationId = i2;
        }

        public int getDay() {
            return this.day;
        }

        public int getDecorationId() {
            return this.decorationId;
        }

        public void setDay(int i) {
            this.day = i;
        }

        public void setDecorationId(int i) {
            this.decorationId = i;
        }
    }

    public static class BuySuitListBean {
        private int day;
        private int suitId;

        public int getDay() {
            return this.day;
        }

        public int getSuitId() {
            return this.suitId;
        }

        public void setDay(int i) {
            this.day = i;
        }

        public void setSuitId(int i) {
            this.suitId = i;
        }
    }

    public BuyRequest(List<BuyDecorationListBean> list) {
        this.buyDecorationList = list;
    }

    public List<BuyDecorationListBean> getBuyDecorationList() {
        return this.buyDecorationList;
    }

    public List<BuySuitListBean> getBuySuitList() {
        return this.buySuitList;
    }

    public int getEngineVersion() {
        return this.engineVersion;
    }

    public void setBuyDecorationList(List<BuyDecorationListBean> list) {
        this.buyDecorationList = list;
    }

    public void setBuySuitList(List<BuySuitListBean> list) {
        this.buySuitList = list;
    }

    public void setEngineVersion(int i) {
        this.engineVersion = i;
    }
}
