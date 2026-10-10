package com.ironsource.sdk.utils;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IronSourceQaProperties.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f15423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, String> f15424b = new HashMap();

    private c() {
    }

    public static c a() {
        if (f15423a == null) {
            f15423a = new c();
        }
        return f15423a;
    }

    public static boolean c() {
        return f15423a != null;
    }

    public Map<String, String> b() {
        return f15424b;
    }
}
