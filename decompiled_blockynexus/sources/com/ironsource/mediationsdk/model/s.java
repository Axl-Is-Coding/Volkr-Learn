package com.ironsource.mediationsdk.model;

import org.json.JSONObject;

/* JADX INFO: compiled from: ServerSegmetData.java */
/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f14955c;

    public s(String str, String str2, JSONObject jSONObject) {
        this.f14953a = str;
        this.f14954b = str2;
        this.f14955c = jSONObject;
    }

    public JSONObject a() {
        return this.f14955c;
    }

    public String b() {
        return this.f14954b;
    }

    public String c() {
        return this.f14953a;
    }
}
