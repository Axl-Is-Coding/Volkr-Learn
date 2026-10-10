package com.ironsource.sdk.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.data.SSAEnums$ProductType;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
public class W implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f15234a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15235b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b.f.d.g.e f15236c;

    W(InterfaceC2399i interfaceC2399i) {
        f15234a.post(new M(this, interfaceC2399i));
    }

    @Override // com.ironsource.sdk.controller.I
    public void destroy() {
    }

    @Override // com.ironsource.sdk.controller.I
    public void enterBackground() {
    }

    @Override // com.ironsource.sdk.controller.I
    public void enterForeground() {
    }

    @Override // com.ironsource.sdk.controller.I
    public void getOfferWallCredits(String str, String str2, b.f.d.g.e eVar) {
        if (eVar != null) {
            f15234a.post(new P(this, eVar));
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void initBanner(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.b bVar) {
        if (bVar != null) {
            bVar.a(SSAEnums$ProductType.Banner, dVar.d(), this.f15235b);
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void initInterstitial(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.c cVar) {
        if (cVar != null) {
            f15234a.post(new T(this, cVar, dVar));
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void initOfferWall(String str, String str2, Map<String, String> map, b.f.d.g.e eVar) {
        if (eVar != null) {
            this.f15236c = eVar;
            f15234a.post(new N(this));
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void initRewardedVideo(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.d dVar2) {
        if (dVar2 != null) {
            f15234a.post(new Q(this, dVar2, dVar));
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public boolean isInterstitialAdAvailable(String str) {
        return false;
    }

    @Override // com.ironsource.sdk.controller.I
    public void loadBanner(JSONObject jSONObject, b.f.d.g.a.b bVar) {
        if (bVar != null) {
            f15234a.post(new L(this, bVar, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void loadInterstitial(String str, b.f.d.g.a.c cVar) {
        if (cVar != null) {
            f15234a.post(new U(this, cVar, str));
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void registerConnectionReceiver(Context context) {
    }

    @Override // com.ironsource.sdk.controller.I
    public void restoreSavedState() {
    }

    @Override // com.ironsource.sdk.controller.I
    public void setCommunicationWithAdView(ISNAdView iSNAdView) {
    }

    @Override // com.ironsource.sdk.controller.I
    public void showInterstitial(JSONObject jSONObject, b.f.d.g.a.c cVar) {
        if (cVar != null) {
            f15234a.post(new J(this, cVar, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void showOfferWall(Map<String, String> map) {
        if (this.f15236c != null) {
            f15234a.post(new O(this));
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void showRewardedVideo(JSONObject jSONObject, b.f.d.g.a.d dVar) {
        if (dVar != null) {
            f15234a.post(new S(this, dVar, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void unregisterConnectionReceiver(Context context) {
    }

    @Override // com.ironsource.sdk.controller.I
    public void updateConsentInfo(JSONObject jSONObject) {
    }

    void a(String str) {
        this.f15235b = str;
    }

    @Override // com.ironsource.sdk.controller.I
    public void loadInterstitial(com.ironsource.sdk.data.d dVar, Map<String, String> map, b.f.d.g.a.c cVar) {
        if (cVar != null) {
            f15234a.post(new V(this, cVar, dVar));
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void showInterstitial(com.ironsource.sdk.data.d dVar, Map<String, String> map, b.f.d.g.a.c cVar) {
        if (cVar != null) {
            f15234a.post(new K(this, cVar, dVar));
        }
    }
}
