package com.alibaba.sdk.android.feedback.xblink.f.a;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f3821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f3822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.alibaba.sdk.android.feedback.xblink.f.m f3823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ q f3824e;

    r(q qVar, String str, int i, String str2, com.alibaba.sdk.android.feedback.xblink.f.m mVar) {
        this.f3824e = qVar;
        this.f3820a = str;
        this.f3821b = i;
        this.f3822c = str2;
        this.f3823d = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!"start".equals(this.f3824e.f3819a.j)) {
            if (this.f3824e.f3819a.g != null) {
                com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaRecorder", "mWVCallBackContext success");
                this.f3824e.f3819a.g.a(this.f3823d);
                return;
            }
            return;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.a("WXMediaRecorder", "onTimeout");
        this.f3824e.f3819a.i = false;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", "onTimeout");
            jSONObject.put("audioData", this.f3820a);
            jSONObject.put("duration", String.valueOf(this.f3821b));
            jSONObject.put("audioFile", this.f3822c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        p pVar = this.f3824e.f3819a;
        pVar.a(pVar.g.a(), jSONObject.toString());
    }
}
