package com.ironsource.mediationsdk.sdk;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.sdk.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GeneralProperties.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2353h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C2353h f14996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f14997b = new JSONObject();

    private C2353h() {
    }

    public static synchronized C2353h a() {
        if (f14996a == null) {
            f14996a = new C2353h();
        }
        return f14996a;
    }

    public synchronized JSONObject b() {
        return this.f14997b;
    }

    public synchronized void a(Map<String, Object> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                a(str, map.get(str));
            }
        }
    }

    public synchronized void a(String str, Object obj) {
        try {
            this.f14997b.put(str, obj);
        } catch (Exception unused) {
        }
    }

    public synchronized String a(String str) {
        return this.f14997b.optString(str);
    }
}
