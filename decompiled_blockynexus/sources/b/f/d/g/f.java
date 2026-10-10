package b.f.d.g;

import org.json.JSONObject;

/* JADX INFO: compiled from: OnRewardedVideoListener.java */
/* JADX INFO: loaded from: classes2.dex */
public interface f extends a {
    void onRVAdClicked();

    void onRVAdClosed();

    void onRVAdCredited(int i);

    void onRVAdOpened();

    void onRVEventNotificationReceived(String str, JSONObject jSONObject);

    void onRVInitFail(String str);

    void onRVInitSuccess(com.ironsource.sdk.data.a aVar);

    void onRVNoMoreOffers();

    void onRVShowFail(String str);
}
