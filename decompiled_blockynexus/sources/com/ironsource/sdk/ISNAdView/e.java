package com.ironsource.sdk.ISNAdView;

import android.util.Log;
import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;

/* JADX INFO: compiled from: ISNAdViewLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f15091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ JSONObject f15092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ h f15093e;

    e(h hVar, String str, String str2, String str3, JSONObject jSONObject) {
        this.f15093e = hVar;
        this.f15089a = str;
        this.f15090b = str2;
        this.f15091c = str3;
        this.f15092d = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!this.f15093e.f(this.f15089a)) {
                String str = "ISNAdViewLogic | handleMessageFromController | cannot handle command: " + this.f15089a;
                Log.e(this.f15093e.g, str);
                this.f15093e.f15099c.a(this.f15090b, str, this.f15093e.f15102f);
                return;
            }
            if (this.f15089a.equalsIgnoreCase("isExternalAdViewInitiated")) {
                this.f15093e.b(this.f15091c);
                return;
            }
            if (this.f15089a.equalsIgnoreCase("handleGetViewVisibility")) {
                this.f15093e.h(this.f15091c);
                return;
            }
            if (!this.f15089a.equalsIgnoreCase("sendMessage") && !this.f15089a.equalsIgnoreCase("updateAd")) {
                String str2 = "ISNAdViewLogic | handleMessageFromController | unhandled API request " + this.f15089a + " " + this.f15092d.toString();
                Log.e(this.f15093e.g, str2);
                this.f15093e.f15099c.a(this.f15090b, str2, this.f15093e.f15102f);
                return;
            }
            this.f15093e.a(this.f15092d.getString(NativeProtocol.WEB_DIALOG_PARAMS), this.f15091c, this.f15090b);
        } catch (Exception e2) {
            e2.printStackTrace();
            String str3 = "ISNAdViewLogic | handleMessageFromController | Error while trying handle message: " + this.f15089a;
            Log.e(this.f15093e.g, str3);
            this.f15093e.f15099c.a(this.f15090b, str3, this.f15093e.f15102f);
        }
    }
}
