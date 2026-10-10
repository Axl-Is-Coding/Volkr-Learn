package com.disabngo.blockynexus.entity;

import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TribeClanRequest {
    private long clanId;
    private int currency;
    private String details;
    private String headPic;
    private String name;
    private List<String> tags;

    public TribeClanRequest(String str, String str2, String str3, List<String> list, int i) {
        this.details = str;
        this.headPic = str2;
        this.name = str3;
        this.tags = list;
        this.currency = i;
    }

    public long getClanId() {
        return this.clanId;
    }

    public int getCurrency() {
        return this.currency;
    }

    public String getDetails() {
        return this.details;
    }

    public String getHeadPic() {
        return this.headPic;
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

    public void setClanId(long j) {
        this.clanId = j;
    }

    public void setCurrency(int i) {
        this.currency = i;
    }

    public void setDetails(String str) {
        this.details = str;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public TribeClanRequest(long j, String str, String str2, String str3, List<String> list) {
        this.clanId = j;
        this.details = str;
        this.headPic = str2;
        this.name = str3;
        this.tags = list;
        this.currency = this.currency;
    }
}
