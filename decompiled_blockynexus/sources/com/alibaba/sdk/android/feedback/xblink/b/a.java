package com.alibaba.sdk.android.feedback.xblink.b;

/* JADX INFO: loaded from: classes.dex */
public enum a {
    ONLINE(0, "m"),
    PRE(1, "wapa"),
    DAILY(2, "waptest");


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3768e;

    a(int i, String str) {
        this.f3767d = i;
        this.f3768e = str;
    }

    public String a() {
        return "http://api." + this.f3768e + ".taobao.com/rest/api3.do";
    }

    public String b() {
        return "http://h5." + this.f3768e + ".taobao.com/bizcache/2/windvane/config/";
    }
}
