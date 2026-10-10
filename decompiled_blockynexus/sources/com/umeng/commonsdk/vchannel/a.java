package com.umeng.commonsdk.vchannel;

import com.umeng.analytics.pro.au;

/* JADX INFO: compiled from: Constant.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21336a = "https://pslog.umeng.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f21337b = "https://pslog.umeng.com/";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f21338c = "explog";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f21339d = "analytics";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f21340e = "ekv";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f21341f = "id";
    public static final String g = "ts";
    public static final String h = "ds";
    public static final String i = "pn";
    public static String j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(String.format("%0" + (32 - str.length()) + au.au, 0));
        j = sb.toString();
    }
}
