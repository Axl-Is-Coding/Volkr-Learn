package com.sandboxol.center.entity;

import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: loaded from: classes3.dex */
public class GameDetailShop {
    private int currency;
    private String details;
    private String expireDate;
    private String iconUrl;
    private int id;
    private String name;
    private int price;
    private String resourceId;
    private int status;
    private int validate;

    public String getBuyStatus() {
        return this.status == 0 ? String.valueOf(this.price) : BaseApplication.getContext().getString(R.string.base_game_detail_using);
    }

    public int getCurrency() {
        return this.currency;
    }

    public String getDetails() {
        return this.details;
    }

    public String getExpireDate() {
        return this.expireDate;
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

    public String getResourceId() {
        return this.resourceId;
    }

    public int getStatus() {
        return this.status;
    }

    public int getValidate() {
        return this.validate;
    }

    public void setCurrency(int i) {
        this.currency = i;
    }

    public void setDetails(String str) {
        this.details = str;
    }

    public void setExpireDate(String str) {
        this.expireDate = str;
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

    public void setResourceId(String str) {
        this.resourceId = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setValidate(int i) {
        this.validate = i;
    }
}
