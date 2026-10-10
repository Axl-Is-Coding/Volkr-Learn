package com.ironsource.mediationsdk.e;

/* JADX INFO: compiled from: MetaDataUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a(String str, String str2) {
        return str.equals("do_not_sell") && str2.length() > 0;
    }

    public static boolean a(String str) {
        return !str.equals("false");
    }
}
