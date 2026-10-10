package com.tendcloud.tenddata;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f19815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f19816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte f19817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte f19818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte f19819e;

    public ay() {
        this.f19815a = "";
        this.f19816b = "00:00:00:00:00:00";
        this.f19817c = (byte) -127;
        this.f19818d = (byte) 1;
        this.f19819e = (byte) 1;
    }

    public String a() {
        return this.f19815a;
    }

    public String b() {
        return this.f19816b;
    }

    public byte c() {
        return this.f19817c;
    }

    public byte d() {
        return this.f19818d;
    }

    public byte e() {
        return this.f19819e;
    }

    public ay f() {
        return new ay(this.f19815a, this.f19816b, this.f19817c, this.f19818d, this.f19819e);
    }

    public void setBand(byte b2) {
        this.f19818d = b2;
    }

    public void setBssid(String str) {
        this.f19816b = str;
    }

    public void setChannel(byte b2) {
        this.f19819e = b2;
    }

    public void setRssi(byte b2) {
        this.f19817c = b2;
    }

    public void setSsid(String str) {
        this.f19815a = str;
    }

    public ay(String str, String str2, byte b2, byte b3, byte b4) {
        this.f19815a = str;
        this.f19816b = str2;
        this.f19817c = b2;
        this.f19818d = b3;
        this.f19819e = b4;
    }
}
