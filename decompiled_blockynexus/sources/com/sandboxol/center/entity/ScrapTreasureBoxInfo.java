package com.sandboxol.center.entity;

import com.sandboxol.greendao.entity.ScrapTreasureRewardInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapTreasureBoxInfo {
    private int duration;
    private int openStatus;
    private int rewardQuantity;
    private List<ScrapTreasureRewardInfo> scrapList;
    private String treasureBoxId;
    private int treasureBoxLevel;
    private String treasureBoxPic;
    private int treasureBoxType;
    private String uuid;

    public int getDuration() {
        return this.duration;
    }

    public int getOpenStatus() {
        return this.openStatus;
    }

    public int getRewardQuantity() {
        return this.rewardQuantity;
    }

    public List<ScrapTreasureRewardInfo> getScrapList() {
        return this.scrapList;
    }

    public String getTreasureBoxId() {
        return this.treasureBoxId;
    }

    public int getTreasureBoxLevel() {
        return this.treasureBoxLevel;
    }

    public String getTreasureBoxPic() {
        return this.treasureBoxPic;
    }

    public int getTreasureBoxType() {
        return this.treasureBoxType;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setOpenStatus(int i) {
        this.openStatus = i;
    }

    public void setRewardQuantity(int i) {
        this.rewardQuantity = i;
    }

    public void setScrapList(List<ScrapTreasureRewardInfo> list) {
        this.scrapList = list;
    }

    public void setTreasureBoxId(String str) {
        this.treasureBoxId = str;
    }

    public void setTreasureBoxLevel(int i) {
        this.treasureBoxLevel = i;
    }

    public void setTreasureBoxPic(String str) {
        this.treasureBoxPic = str;
    }

    public void setTreasureBoxType(int i) {
        this.treasureBoxType = i;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }
}
