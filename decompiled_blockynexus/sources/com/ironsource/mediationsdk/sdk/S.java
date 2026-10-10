package com.ironsource.mediationsdk.sdk;

import org.json.JSONObject;

/* JADX INFO: compiled from: RewardedVideoAdapterApi.java */
/* JADX INFO: loaded from: classes2.dex */
public interface S {
    void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, X x);

    void initRewardedVideo(String str, String str2, JSONObject jSONObject, X x);

    boolean isRewardedVideoAvailable(JSONObject jSONObject);

    void showRewardedVideo(JSONObject jSONObject, X x);
}
