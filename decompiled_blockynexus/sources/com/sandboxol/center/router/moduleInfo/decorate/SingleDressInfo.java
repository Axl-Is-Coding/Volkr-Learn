package com.sandboxol.center.router.moduleInfo.decorate;

import androidx.databinding.BaseObservable;
import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SingleDressInfo extends BaseObservable {
    private String activityFlag;
    private int blankType;
    private boolean buySuccess;
    private int clanLevel;
    private int currency;
    private List<DecorationInfo> decorationInfoList;
    private String details;
    private int expire;
    private int hasPurchase;
    private String iconUrl;
    private long id;
    private int isActivity;
    private boolean isDressRec;
    private int isNew;
    private int isRecommend;
    private int itemType;
    private List<LimitedTimes> limitedTimes;
    private String name;
    private List<Long> occupyPosition;
    private int orderField;
    private int price;
    private int quantity;
    private long releaseTime;
    private int remainingDays;
    private String resourceId;
    private int sex;
    private int status;
    private int suitId;
    private long suitPrice;
    private List<String> tag;
    private int type;
    private long typeId;
    private int vip;

    public SingleDressInfo() {
    }

    public String getActivityFlag() {
        return this.activityFlag;
    }

    public int getBlankType() {
        return this.blankType;
    }

    public int getClanLevel() {
        return this.clanLevel;
    }

    public int getCurrency() {
        return this.currency;
    }

    public List<DecorationInfo> getDecorationInfoList() {
        return this.decorationInfoList;
    }

    public String getDetails() {
        return this.details;
    }

    public String getDressPriceText() {
        int i = this.price;
        return i == 0 ? BaseApplication.getContext().getString(R.string.decorate_friend_info_dress_item_price_free) : String.valueOf(i);
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

    public long getId() {
        return this.id;
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

    public List<Long> getOccupyPosition() {
        return this.occupyPosition;
    }

    public int getOrderField() {
        return this.orderField;
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

    public String getResourceId() {
        return this.resourceId;
    }

    public int getSex() {
        return this.sex;
    }

    public int getStatus() {
        return this.status;
    }

    public int getSuitId() {
        return this.suitId;
    }

    public long getSuitPrice() {
        return this.suitPrice;
    }

    public List<String> getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public long getTypeId() {
        return this.typeId;
    }

    public int getVip() {
        return this.vip;
    }

    public boolean isBuySuccess() {
        return this.buySuccess;
    }

    public boolean isDressRec() {
        return this.isDressRec;
    }

    public void setActivityFlag(String str) {
        this.activityFlag = str;
    }

    public void setBlankType(int i) {
        this.blankType = i;
    }

    public void setBuySuccess(boolean z) {
        this.buySuccess = z;
    }

    public void setClanLevel(int i) {
        this.clanLevel = i;
    }

    public void setCurrency(int i) {
        this.currency = i;
    }

    public void setDecorationInfoList(List<DecorationInfo> list) {
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

    public void setHasPurchase(int i) {
        this.hasPurchase = i;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(long j) {
        this.id = j;
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

    public void setOccupyPosition(List<Long> list) {
        this.occupyPosition = list;
    }

    public void setOrderField(int i) {
        this.orderField = i;
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

    public void setResourceId(String str) {
        this.resourceId = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setSuitId(int i) {
        this.suitId = i;
    }

    public void setSuitPrice(long j) {
        this.suitPrice = j;
    }

    public void setTag(List<String> list) {
        this.tag = list;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setTypeId(long j) {
        this.typeId = j;
    }

    public void setVip(int i) {
        this.vip = i;
    }

    public SingleDressInfo(long j) {
        this.typeId = j;
    }

    public SingleDressInfo(long j, String str) {
        this.iconUrl = str;
        this.typeId = j;
    }

    public SingleDressInfo(SingleDressInfo singleDressInfo) {
        this.status = singleDressInfo.getStatus();
        this.vip = singleDressInfo.getVip();
        this.type = singleDressInfo.getType();
        this.id = singleDressInfo.getId();
        this.currency = singleDressInfo.getCurrency();
        this.details = singleDressInfo.getDetails();
        this.expire = singleDressInfo.getExpire();
        this.hasPurchase = singleDressInfo.getHasPurchase();
        this.iconUrl = singleDressInfo.getIconUrl();
        this.isNew = singleDressInfo.getIsNew();
        this.isRecommend = singleDressInfo.getIsRecommend();
        this.name = singleDressInfo.getName();
        this.price = singleDressInfo.getPrice();
        this.quantity = singleDressInfo.getQuantity();
        this.remainingDays = singleDressInfo.getRemainingDays();
        this.resourceId = singleDressInfo.getResourceId();
        this.sex = singleDressInfo.getSex();
        this.suitId = singleDressInfo.getSuitId();
        this.suitPrice = singleDressInfo.getSuitPrice();
        this.typeId = singleDressInfo.getTypeId();
        this.limitedTimes = singleDressInfo.getLimitedTimes();
        this.tag = singleDressInfo.getTag();
        this.buySuccess = singleDressInfo.isBuySuccess();
        this.releaseTime = singleDressInfo.getReleaseTime();
        this.occupyPosition = singleDressInfo.getOccupyPosition();
        this.isActivity = singleDressInfo.getIsActivity();
        this.activityFlag = singleDressInfo.getActivityFlag();
        this.decorationInfoList = singleDressInfo.getDecorationInfoList();
        this.orderField = singleDressInfo.getOrderField();
        this.itemType = singleDressInfo.getItemType();
        this.blankType = singleDressInfo.getBlankType();
        this.isDressRec = singleDressInfo.isDressRec();
    }
}
