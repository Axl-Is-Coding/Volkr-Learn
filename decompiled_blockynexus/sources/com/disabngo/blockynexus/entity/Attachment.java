package com.disabngo.blockynexus.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Attachment implements Serializable {
    private String icon;
    private String itemId;
    private String name;
    private int qty;
    private int type;

    public String getIcon() {
        return this.icon;
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getName() {
        return this.name;
    }

    public int getQty() {
        return this.qty;
    }

    public int getType() {
        return this.type;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setQty(int i) {
        this.qty = i;
    }

    public void setType(int i) {
        this.type = i;
    }
}
