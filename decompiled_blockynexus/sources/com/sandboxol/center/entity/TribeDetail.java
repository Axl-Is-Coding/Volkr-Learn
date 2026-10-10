package com.sandboxol.center.entity;

import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TribeDetail {
    private int clanId;
    private List<TribeClanMembersBean> clanMembers;
    private int currentCount;
    private String details;
    private long experience;
    private int freeVerify;
    private String headPic;
    private int level;
    private int maxCount;
    private String name;
    private List<String> tags;

    public long getClanId() {
        return this.clanId;
    }

    public List<TribeClanMembersBean> getClanMembers() {
        return this.clanMembers;
    }

    public int getCurrentCount() {
        return this.currentCount;
    }

    public String getCurrentPeopleTotalCount() {
        return BaseApplication.getContext().getString(R.string.tribe_member_list_count, Integer.valueOf(this.currentCount), Integer.valueOf(this.maxCount));
    }

    public String getCurrentTotalCount() {
        return this.currentCount + "/" + this.maxCount;
    }

    public String getDetails() {
        return this.details;
    }

    public String getExperience() {
        return String.valueOf(this.experience);
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

    public long getLongExperience() {
        return this.experience;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public String getName() {
        if (this.name.contains(UMCustomLogInfoBuilder.LINE_SEP)) {
            this.name = this.name.replaceAll(UMCustomLogInfoBuilder.LINE_SEP, " ");
        }
        return this.name;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setClanId(int i) {
        this.clanId = i;
    }

    public void setClanMembers(List<TribeClanMembersBean> list) {
        this.clanMembers = list;
    }

    public void setCurrentCount(int i) {
        this.currentCount = i;
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

    public void setMaxCount(int i) {
        this.maxCount = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public String toString() {
        return "TribeDetail{clanId=" + this.clanId + ", currentCount=" + this.currentCount + ", details='" + this.details + "', experience=" + this.experience + ", headPic='" + this.headPic + "', level=" + this.level + ", maxCount=" + this.maxCount + ", name='" + this.name + "', clanMembers=" + this.clanMembers + ", tags=" + this.tags + '}';
    }
}
