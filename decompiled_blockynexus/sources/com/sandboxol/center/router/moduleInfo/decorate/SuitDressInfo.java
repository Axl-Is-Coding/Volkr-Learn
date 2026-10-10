package com.sandboxol.center.router.moduleInfo.decorate;

import androidx.databinding.BaseObservable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SuitDressInfo extends BaseObservable {
    private String activityFlag;
    private int blankType;
    private String buyTime;
    private int currency;
    private List<SingleDressInfo> decorationInfoList;
    private String details;
    private int expire;
    private boolean hasLocalRes;
    private int hasPurchase;
    private String iconUrl;
    private int isActivity;
    private boolean isDressRec;
    private int isNew;
    private int isRecommend;
    private int itemType;
    private List<LimitedTimes> limitedTimes;
    private String name;
    private int price;
    private int quantity;
    private long releaseTime;
    private int remainingDays;
    private List<SingleDressInfo> shopDecorationInfos;
    private int status;
    private long suitId;
    private List<String> tag;

    public String getActivityFlag() {
        return this.activityFlag;
    }

    public int getBlankType() {
        return this.blankType;
    }

    public String getBuyTime() {
        return this.buyTime;
    }

    public int getCurrency() {
        return this.currency;
    }

    public List<SingleDressInfo> getDecorationInfoList() {
        return this.decorationInfoList;
    }

    public String getDetails() {
        return this.details;
    }

    public int getExpire() {
        return this.expire;
    }

    public int getHasPurchase() {
        return this.hasPurchase;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getIsActivity() {
        return this.isActivity;
    }

    public int getIsNew() {
        return this.isNew;
    }

    public int getIsRecommend() {
        return this.isRecommend;
    }

    public int getItemType() {
        return this.itemType;
    }

    public List<LimitedTimes> getLimitedTimes() {
        return this.limitedTimes;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public long getReleaseTime() {
        return this.releaseTime;
    }

    public int getRemainingDays() {
        return this.remainingDays;
    }

    public List<SingleDressInfo> getShopDecorationInfos() {
        return this.shopDecorationInfos;
    }

    public int getStatus() {
        return this.status;
    }

    public long getSuitId() {
        return this.suitId;
    }

    public List<String> getTag() {
        return this.tag;
    }

    public boolean isDressRec() {
        return this.isDressRec;
    }

    public boolean isHasLocalRes() {
        return this.hasLocalRes;
    }

    public void setActivityFlag(String str) {
        this.activityFlag = str;
    }

    public void setBlankType(int i) {
        this.blankType = i;
    }

    public void setBuyTime(String str) {
        this.buyTime = str;
    }

    public void setCurrency(int i) {
        this.currency = i;
    }

    public void setDecorationInfoList(List<SingleDressInfo> list) {
        this.decorationInfoList = list;
    }

    public void setDetails(String str) {
        this.details = str;
    }

    public void setDressRec(boolean z) {
        this.isDressRec = z;
    }

    public void setExpire(int i) {
        this.expire = i;
    }

    public void setHasLocalRes(boolean z) {
        this.hasLocalRes = z;
    }

    public void setHasPurchase(int i) {
        this.hasPurchase = i;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setIsActivity(int i) {
        this.isActivity = i;
    }

    public void setIsNew(int i) {
        this.isNew = i;
    }

    public void setIsRecommend(int i) {
        this.isRecommend = i;
    }

    public void setItemType(int i) {
        this.itemType = i;
    }

    public void setLimitedTimes(List<LimitedTimes> list) {
        this.limitedTimes = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrice(int i) {
        this.price = i;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public void setReleaseTime(long j) {
        this.releaseTime = j;
    }

    public void setRemainingDays(int i) {
        this.remainingDays = i;
    }

    public void setShopDecorationInfos(List<SingleDressInfo> list) {
        this.shopDecorationInfos = list;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setSuitId(long j) {
        this.suitId = j;
    }

    public void setTag(List<String> list) {
        this.tag = list;
    }
}
