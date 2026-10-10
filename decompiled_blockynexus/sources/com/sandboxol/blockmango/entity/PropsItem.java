package com.sandboxol.blockmango.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PropsItem implements Serializable {
    private int limit;
    private int number;
    private String payType;
    private String propsDesc;
    private String propsId;
    private String propsName;
    private double propsPrice;
    private String propsType;
    private String propsTypeId;
    private String propsUrl;
    private int qty;
    private int usageCount;
    private int vip;

    public int getLimit() {
        return this.limit;
    }

    public int getNumber() {
        return this.number;
    }

    public String getPayType() {
        return this.payType;
    }

    public String getPropsDesc() {
        return this.propsDesc;
    }

    public String getPropsId() {
        return this.propsId;
    }

    public String getPropsName() {
        return this.propsName;
    }

    public double getPropsPrice() {
        return this.propsPrice;
    }

    public String getPropsType() {
        return this.propsType;
    }

    public String getPropsTypeId() {
        return this.propsTypeId;
    }

    public String getPropsUrl() {
        return this.propsUrl;
    }

    public int getQty() {
        return this.qty;
    }

    public int getUsageCount() {
        return this.usageCount;
    }

    public int getVip() {
        return this.vip;
    }

    public void setLimit(int i) {
        this.limit = i;
    }

    public void setNumber(int i) {
        this.number = i;
    }

    public void setPayType(String str) {
        this.payType = str;
    }

    public void setPropsDesc(String str) {
        this.propsDesc = str;
    }

    public void setPropsId(String str) {
        this.propsId = str;
    }

    public void setPropsName(String str) {
        this.propsName = str;
    }

    public void setPropsPrice(double d2) {
        this.propsPrice = d2;
    }

    public void setPropsType(String str) {
        this.propsType = str;
    }

    public void setPropsTypeId(String str) {
        this.propsTypeId = str;
    }

    public void setPropsUrl(String str) {
        this.propsUrl = str;
    }

    public void setQty(int i) {
        this.qty = i;
    }

    public void setUsageCount(int i) {
        this.usageCount = i;
    }

    public void setVip(int i) {
        this.vip = i;
    }
}
