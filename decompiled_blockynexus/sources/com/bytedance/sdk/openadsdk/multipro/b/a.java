package com.bytedance.sdk.openadsdk.multipro.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: VideoControllerDataModel.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7063f;
    public long g;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VideoControllerDataModel.java */
    public interface InterfaceC0093a {
        a a();
    }

    public a a(boolean z) {
        this.f7061d = z;
        return this;
    }

    public a b(boolean z) {
        this.f7058a = z;
        return this;
    }

    public a c(boolean z) {
        this.f7059b = z;
        return this;
    }

    public a d(boolean z) {
        this.f7060c = z;
        return this;
    }

    public a a(long j) {
        this.f7062e = j;
        return this;
    }

    public a b(long j) {
        this.f7063f = j;
        return this;
    }

    public a c(long j) {
        this.g = j;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f7058a);
            jSONObject.put("isFromVideoDetailPage", this.f7059b);
            jSONObject.put("isFromDetailPage", this.f7060c);
            jSONObject.put("duration", this.f7062e);
            jSONObject.put("totalPlayDuration", this.f7063f);
            jSONObject.put("currentPlayPosition", this.g);
            jSONObject.put("isAutoPlay", this.f7061d);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.b(jSONObject.optBoolean("isCompleted"));
        aVar.c(jSONObject.optBoolean("isFromVideoDetailPage"));
        aVar.d(jSONObject.optBoolean("isFromDetailPage"));
        aVar.a(jSONObject.optLong("duration"));
        aVar.b(jSONObject.optLong("totalPlayDuration"));
        aVar.c(jSONObject.optLong("currentPlayPosition"));
        aVar.a(jSONObject.optBoolean("isAutoPlay"));
        return aVar;
    }
}
