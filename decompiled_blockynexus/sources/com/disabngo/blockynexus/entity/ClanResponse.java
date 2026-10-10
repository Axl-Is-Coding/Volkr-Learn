package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ClanResponse {
    private long clanId;
    private String details;
    private long experience;
    private int freeVerify;
    private String headPic;
    private int level;
    private String name;
    private int role;
    private List<String> tags;

    public long getClanId() {
        return this.clanId;
    }

    public String getDetails() {
        return this.details;
    }

    public long getExperience() {
        return this.experience;
    }

    public int getFreeVerify() {
        return this.freeVerify;
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public int getRole() {
        return this.role;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setClanId(long j) {
        this.clanId = j;
    }

    public void setDetails(String str) {
        this.details = str;
    }

    public void setExperience(long j) {
        this.experience = j;
    }

    public void setFreeVerify(int i) {
        this.freeVerify = i;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRole(int i) {
        this.role = i;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }
}
