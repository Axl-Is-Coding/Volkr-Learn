package com.disabngo.blockynexus.entity;

import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.app.BaseApplication;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TribeShopPageList implements Serializable {
    private static final long serialVersionUID = 10;
    private int clanLevel;
    private int currency;
    private String details;
    private int expire;
    private int hasPurchase;
    private String iconUrl;
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String resourceId;
    private int sex;
    private List<String> tag;
    private int typeId;

    public int getClanLevel() {
        return this.clanLevel;
    }

    public int getCurrency() {
        return this.currency;
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

    public int getId() {
        return this.id;
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

    public String getResourceId() {
        return this.resourceId;
    }

    public int getSex() {
        return this.sex;
    }

    public List<String> getTag() {
        return this.tag;
    }

    public long getTypeId() {
        return this.typeId;
    }

    public void setClanLevel(int i) {
        this.clanLevel = i;
    }

    public void setCurrency(int i) {
        this.currency = i;
    }

    public void setDetails(String str) {
        this.details = str;
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

    public void setId(int i) {
        this.id = i;
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

    public void setResourceId(String str) {
        this.resourceId = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setTag(List<String> list) {
        this.tag = list;
    }

    public void setTypeId(int i) {
        this.typeId = i;
    }

    public String showExpireText() {
        return BaseApplication.getContext().getString(R.string.dress_shop_car_time_left, Integer.valueOf(this.expire));
    }

    public String showQuantityText() {
        return this.quantity == -1 ? BaseApplication.getContext().getString(R.string.dress_shop_item_sell_out) : BaseApplication.getContext().getString(R.string.dress_shop_car_quantity_left, Integer.valueOf(this.quantity));
    }
}
