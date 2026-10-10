package com.google.ads.mediation;

import android.app.Activity;
import android.view.View;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface MediationBannerAdapter<ADDITIONAL_PARAMETERS extends d, SERVER_PARAMETERS extends MediationServerParameters> extends b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    View getBannerView();

    void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, SERVER_PARAMETERS server_parameters, com.google.ads.a aVar, a aVar2, ADDITIONAL_PARAMETERS additional_parameters);
}
