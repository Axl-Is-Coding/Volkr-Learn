package com.google.ads.mediation;

import android.app.Activity;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface MediationInterstitialAdapter<ADDITIONAL_PARAMETERS extends d, SERVER_PARAMETERS extends MediationServerParameters> extends b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    void requestInterstitialAd(c cVar, Activity activity, SERVER_PARAMETERS server_parameters, a aVar, ADDITIONAL_PARAMETERS additional_parameters);

    void showInterstitial();
}
