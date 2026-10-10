package com.sandboxol.center.router.moduleInfo.pay;

import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class VipProductEntity implements Serializable {
    private String desc;
    private int diamonds;
    private int gift;
    private int id;
    private int level;
    private int month;
    private String name;
    private double price;
    private String productId;
    private String resPic;
    private String type;

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

    public String getResPic() {
        return this.resPic;
    }

    public String getType() {
        return this.type;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDiamonds(int i) {
        this.diamonds = i;
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

    public void setResPic(String str) {
        this.resPic = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
