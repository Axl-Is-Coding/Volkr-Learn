package com.google.android.gms.ads.mediation.rtb;

import com.google.android.gms.ads.AdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public interface SignalCallbacks {
    void onFailure(AdError adError);

    @Deprecated
    void onFailure(String str);

    void onSuccess(String str);
}
