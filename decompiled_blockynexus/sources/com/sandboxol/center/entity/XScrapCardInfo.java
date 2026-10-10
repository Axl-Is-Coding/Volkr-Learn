package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class XScrapCardInfo {
    private boolean privateFlag;
    private String scrapDesc;
    private String scrapId;
    private int scrapLevel;
    private String scrapName;
    private int scrapNum;
    private String scrapUrl;
    private int scrapValue;
    private long senderId;
    private String senderName;
    private String targetId;
    private String uuid;

    public XScrapCardInfo(long j, String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, boolean z, String str7, int i3) {
        this.scrapLevel = 1;
        this.scrapNum = 1;
        this.senderId = j;
        this.senderName = str;
        this.scrapId = str2;
        this.scrapLevel = i;
        this.scrapNum = i2;
        this.scrapName = str3;
        this.scrapUrl = str4;
        this.uuid = str5;
        this.targetId = str6;
        this.privateFlag = z;
        this.scrapDesc = str7;
        this.scrapValue = i3;
    }

    public String getScrapDesc() {
        return this.scrapDesc;
    }

    public String getScrapId() {
        return this.scrapId;
    }

    public int getScrapLevel() {
        return this.scrapLevel;
    }

    public String getScrapName() {
        return this.scrapName;
    }

    public int getScrapNum() {
        return this.scrapNum;
    }

    public String getScrapUrl() {
        return this.scrapUrl;
    }

    public int getScrapValue() {
        return this.scrapValue;
    }

    public long getSenderId() {
        return this.senderId;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isPrivateFlag() {
        return this.privateFlag;
    }

    public void setPrivateFlag(boolean z) {
        this.privateFlag = z;
    }

    public void setScrapDesc(String str) {
        this.scrapDesc = str;
    }

    public void setScrapId(String str) {
        this.scrapId = str;
    }

    public void setScrapLevel(int i) {
        this.scrapLevel = i;
    }

    public void setScrapName(String str) {
        this.scrapName = str;
    }

    public void setScrapNum(int i) {
        this.scrapNum = i;
    }

    public void setScrapUrl(String str) {
        this.scrapUrl = str;
    }

    public void setScrapValue(int i) {
        this.scrapValue = i;
    }

    public void setSenderId(long j) {
        this.senderId = j;
    }

    public void setSenderName(String str) {
        this.senderName = str;
    }

    public void setTargetId(String str) {
        this.targetId = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }
}
