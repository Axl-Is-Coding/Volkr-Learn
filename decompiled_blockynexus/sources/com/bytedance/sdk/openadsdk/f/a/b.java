package com.bytedance.sdk.openadsdk.f.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: LoadAdNoRspLog.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6740b;

    public b a(long j) {
        this.f6739a = j;
        return this;
    }

    public b b(long j) {
        this.f6740b = j;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.c, com.bytedance.sdk.openadsdk.f.a.a
    public JSONObject a() {
        JSONObject jSONObjectA = super.a();
        try {
            jSONObjectA.put("c_process_time", this.f6739a);
            jSONObjectA.put("s_process_time", this.f6740b);
        } catch (Exception unused) {
        }
        return jSONObjectA;
    }
}
