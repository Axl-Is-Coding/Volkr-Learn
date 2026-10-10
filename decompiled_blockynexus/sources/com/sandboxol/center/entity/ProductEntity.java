package com.sandboxol.center.entity;

import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class ProductEntity implements Serializable {
    private int currency;
    private String desc;
    private int diamonds;
    private int gift;
    private int id;
    private boolean isFree;
    private boolean isVip;
    private int level;
    private int month;
    private String name;
    private double price;
    private String productId;
    private String resourcePic;
    private String type;

    public ProductEntity() {
    }

    public String addGiftText() {
        return "+" + this.gift;
    }

    public String getAddGift() {
        return "+" + this.gift;
    }

    public int getCurrency() {
        return this.currency;
    }

    public String getDepreciateString() {
        switch (this.id) {
            case 9:
                return "10%More";
            case 10:
                return "20%More";
            case 11:
                return "30%More";
            case 12:
                return "40%More";
            default:
                return "";
        }
    }

    public String getDesc() {
        return this.desc;
    }

    public int getDiamonds() {
        return this.diamonds;
    }

    public int getGift() {
        return this.gift;
    }

    public int getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }

    public int getMonth() {
        return this.month;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getPriceText() {
        return BaseApplication.getContext().getString(R.string.item_price_oversea, String.valueOf(this.price));
    }

    public String getProductId() {
        return this.productId;
    }

    public String getResourcePic() {
        return this.resourcePic;
    }

    public String getStringPrice() {
        return "$" + this.price;
    }

    public String getType() {
        return this.type;
    }

    public boolean isFree() {
        return this.isFree;
    }

    public boolean isVip() {
        return this.isVip;
    }

    public void setCurrency(int i) {
        this.currency = i;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDiamonds(int i) {
        this.diamonds = i;
    }

    public void setFree(boolean z) {
        this.isFree = z;
    }

    public void setGift(int i) {
        this.gift = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setMonth(int i) {
        this.month = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrice(double d2) {
        this.price = d2;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setResourcePic(String str) {
        this.resourcePic = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVip(boolean z) {
        this.isVip = z;
    }

    public ProductEntity(int i, boolean z, int i2) {
        this.diamonds = i;
        this.isFree = z;
        this.currency = i2;
    }
}
