package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceController.java */
/* JADX INFO: loaded from: classes2.dex */
public interface I {
    void destroy();

    void enterBackground();

    void enterForeground();

    void getOfferWallCredits(String str, String str2, b.f.d.g.e eVar);

    void initBanner(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.b bVar);

    void initInterstitial(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.c cVar);

    void initOfferWall(String str, String str2, Map<String, String> map, b.f.d.g.e eVar);

    void initRewardedVideo(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.d dVar2);

    boolean isInterstitialAdAvailable(String str);

    void loadBanner(JSONObject jSONObject, b.f.d.g.a.b bVar);

    void loadInterstitial(com.ironsource.sdk.data.d dVar, Map<String, String> map, b.f.d.g.a.c cVar);

    void loadInterstitial(String str, b.f.d.g.a.c cVar);

    void registerConnectionReceiver(Context context);

    void restoreSavedState();

    void setCommunicationWithAdView(ISNAdView iSNAdView);

    void showInterstitial(com.ironsource.sdk.data.d dVar, Map<String, String> map, b.f.d.g.a.c cVar);

    void showInterstitial(JSONObject jSONObject, b.f.d.g.a.c cVar);

    void showOfferWall(Map<String, String> map);

    void showRewardedVideo(JSONObject jSONObject, b.f.d.g.a.d dVar);

    void unregisterConnectionReceiver(Context context);

    void updateConsentInfo(JSONObject jSONObject);
}
