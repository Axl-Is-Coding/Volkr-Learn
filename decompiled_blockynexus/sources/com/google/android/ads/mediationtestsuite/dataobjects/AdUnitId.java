package com.google.android.ads.mediationtestsuite.dataobjects;

/* JADX INFO: loaded from: classes.dex */
public class AdUnitId {
    private String id;
    private String name;

    public AdUnitId(String str, String str2) {
        this.id = str;
        this.name = str2;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPubId() {
        return this.id.substring(0, 26);
    }

    public String getSlotId() {
        return this.id.substring(28);
    }

    public String getTitle() {
        String str = this.name;
        return str != null ? str : this.id;
    }

    public boolean matches(String str) {
        String str2 = this.name;
        return (str2 != null && str2.toLowerCase().contains(str)) || getSlotId().toLowerCase().startsWith(str);
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
