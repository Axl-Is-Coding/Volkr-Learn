package com.ironsource.mediationsdk.sdk;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.sdk.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: InterstitialAdapterApi.java */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2358m {
    void initInterstitial(String str, String str2, JSONObject jSONObject, r rVar);

    boolean isInterstitialReady(JSONObject jSONObject);

    void loadInterstitial(JSONObject jSONObject, r rVar);

    void showInterstitial(JSONObject jSONObject, r rVar);
}
