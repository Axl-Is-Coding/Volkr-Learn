package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.f;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzapx implements MediationInterstitialAdapter {
    private Uri uri;
    private Activity zzdms;
    private MediationInterstitialListener zzdmt;

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        zzbbq.zzef("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        zzbbq.zzef("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        zzbbq.zzef("Resuming AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdmt = mediationInterstitialListener;
        if (this.zzdmt == null) {
            zzbbq.zzfe("Listener not set for mediation. Returning.");
            return;
        }
        if (!(context instanceof Activity)) {
            zzbbq.zzfe("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzdmt.onAdFailedToLoad(this, 0);
            return;
        }
        if (!(PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacc.zzk(context))) {
            zzbbq.zzfe("Default browser does not support custom tabs. Bailing out.");
            this.zzdmt.onAdFailedToLoad(this, 0);
            return;
        }
        String string = bundle.getString("tab_url");
        if (TextUtils.isEmpty(string)) {
            zzbbq.zzfe("The tab_url retrieved from mediation metadata is empty. Bailing out.");
            this.zzdmt.onAdFailedToLoad(this, 0);
        } else {
            this.zzdms = (Activity) context;
            this.uri = Uri.parse(string);
            this.zzdmt.onAdLoaded(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        f fVarA = new f.a().a();
        fVarA.f773a.setData(this.uri);
        zzayu.zzeba.post(new zzapz(this, new AdOverlayInfoParcel(new com.google.android.gms.ads.internal.overlay.zzb(fVarA.f773a), null, new zzaqa(this), null, new zzbbx(0, 0, false))));
        com.google.android.gms.ads.internal.zzp.zzkv().zzwp();
    }
}
