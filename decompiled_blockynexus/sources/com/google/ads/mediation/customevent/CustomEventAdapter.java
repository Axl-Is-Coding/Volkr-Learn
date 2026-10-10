package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbbq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, d>, MediationInterstitialAdapter<CustomEventExtras, d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f12556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private CustomEventBanner f12557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private CustomEventInterstitial f12558c;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    @VisibleForTesting
    class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f12559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.ads.mediation.c f12560b;

        public a(CustomEventAdapter customEventAdapter, com.google.ads.mediation.c cVar) {
            this.f12559a = customEventAdapter;
            this.f12560b = cVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    @VisibleForTesting
    static final class zza implements CustomEventBannerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CustomEventAdapter f12562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediationBannerListener f12563b;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f12562a = customEventAdapter;
            this.f12563b = mediationBannerListener;
        }

        @Override // com.google.ads.mediation.customevent.CustomEventBannerListener
        public final void onClick() {
            zzbbq.zzef("Custom event adapter called onFailedToReceiveAd.");
            this.f12563b.onClick(this.f12562a);
        }
    }

    private static <T> T a(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzbbq.zzfe(sb.toString());
            return null;
        }
    }

    @Override // com.google.ads.mediation.b
    public final void destroy() {
        CustomEventBanner customEventBanner = this.f12557b;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.f12558c;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    @Override // com.google.ads.mediation.b
    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.f12556a;
    }

    @Override // com.google.ads.mediation.b
    public final Class<d> getServerParametersType() {
        return d.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, d dVar, com.google.ads.a aVar, com.google.ads.mediation.a aVar2, CustomEventExtras customEventExtras) {
        this.f12557b = (CustomEventBanner) a(dVar.f12565b);
        if (this.f12557b == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest$ErrorCode.INTERNAL_ERROR);
        } else {
            this.f12557b.requestBannerAd(new zza(this, mediationBannerListener), activity, dVar.f12564a, dVar.f12566c, aVar, aVar2, customEventExtras == null ? null : customEventExtras.getExtra(dVar.f12564a));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(com.google.ads.mediation.c cVar, Activity activity, d dVar, com.google.ads.mediation.a aVar, CustomEventExtras customEventExtras) {
        this.f12558c = (CustomEventInterstitial) a(dVar.f12565b);
        if (this.f12558c == null) {
            cVar.onFailedToReceiveAd(this, AdRequest$ErrorCode.INTERNAL_ERROR);
        } else {
            this.f12558c.requestInterstitialAd(new a(this, cVar), activity, dVar.f12564a, dVar.f12566c, aVar, customEventExtras == null ? null : customEventExtras.getExtra(dVar.f12564a));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.f12558c.showInterstitial();
    }
}
