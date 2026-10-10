package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzapq extends zzapk {
    private MediationRewardedAd zzdlj;
    private final RtbAdapter zzdmi;
    private MediationInterstitialAd zzdmj;
    private String zzdmk = "";

    public zzapq(RtbAdapter rtbAdapter) {
        this.zzdmi = rtbAdapter;
    }

    private static boolean zzc(zzvg zzvgVar) {
        if (zzvgVar.zzche) {
            return true;
        }
        zzwm.zzpt();
        return zzbbg.zzym();
    }

    private final Bundle zzd(zzvg zzvgVar) {
        Bundle bundle;
        Bundle bundle2 = zzvgVar.zzchi;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zzdmi.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private static Bundle zzdu(String str) throws RemoteException {
        String strValueOf = String.valueOf(str);
        zzbbq.zzfe(strValueOf.length() != 0 ? "Server parameters: ".concat(strValueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e2) {
            zzbbq.zzc("", e2);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final zzyo getVideoController() {
        MediationExtrasReceiver mediationExtrasReceiver = this.zzdmi;
        if (!(mediationExtrasReceiver instanceof com.google.android.gms.ads.mediation.zza)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zza) mediationExtrasReceiver).getVideoController();
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzaov zzaovVar, zzanh zzanhVar, zzvn zzvnVar) throws RemoteException {
        try {
            this.zzdmi.loadBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdu(str2), zzd(zzvgVar), zzc(zzvgVar), zzvgVar.zznb, zzvgVar.zzadm, zzvgVar.zzadn, zza(str2, zzvgVar), com.google.android.gms.ads.zzb.zza(zzvnVar.width, zzvnVar.height, zzvnVar.zzacy), this.zzdmk), new zzapp(this, zzaovVar, zzanhVar));
        } catch (Throwable th) {
            zzbbq.zzc("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final boolean zzaa(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzdlj;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zzb(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapg zzapgVar, zzanh zzanhVar) throws RemoteException {
        try {
            this.zzdmi.loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdu(str2), zzd(zzvgVar), zzc(zzvgVar), zzvgVar.zznb, zzvgVar.zzadm, zzvgVar.zzadn, zza(str2, zzvgVar), this.zzdmk), zza(zzapgVar, zzanhVar));
        } catch (Throwable th) {
            zzbbq.zzc("Adapter failed to render rewarded interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zzdr(String str) {
        this.zzdmk = str;
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final zzapv zzua() throws RemoteException {
        return zzapv.zza(this.zzdmi.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final zzapv zzub() throws RemoteException {
        return zzapv.zza(this.zzdmi.getSDKVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zzy(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzdmj;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapa zzapaVar, zzanh zzanhVar) throws RemoteException {
        try {
            this.zzdmi.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdu(str2), zzd(zzvgVar), zzc(zzvgVar), zzvgVar.zznb, zzvgVar.zzadm, zzvgVar.zzadn, zza(str2, zzvgVar), this.zzdmk), new zzaps(this, zzapaVar, zzanhVar));
        } catch (Throwable th) {
            zzbbq.zzc("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapg zzapgVar, zzanh zzanhVar) throws RemoteException {
        try {
            this.zzdmi.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdu(str2), zzd(zzvgVar), zzc(zzvgVar), zzvgVar.zznb, zzvgVar.zzadm, zzvgVar.zzadn, zza(str2, zzvgVar), this.zzdmk), zza(zzapgVar, zzanhVar));
        } catch (Throwable th) {
            zzbbq.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapb zzapbVar, zzanh zzanhVar) throws RemoteException {
        try {
            this.zzdmi.loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdu(str2), zzd(zzvgVar), zzc(zzvgVar), zzvgVar.zznb, zzvgVar.zzadm, zzvgVar.zzadn, zza(str2, zzvgVar), this.zzdmk), new zzapr(this, zzapbVar, zzanhVar));
        } catch (Throwable th) {
            zzbbq.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvn zzvnVar, zzapm zzapmVar) throws RemoteException {
        AdFormat adFormat;
        try {
            zzapu zzapuVar = new zzapu(this, zzapmVar);
            RtbAdapter rtbAdapter = this.zzdmi;
            byte b2 = -1;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        b2 = 0;
                    }
                    break;
                case -1052618729:
                    if (str.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                        b2 = 3;
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        b2 = 2;
                    }
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                        b2 = 1;
                    }
                    break;
            }
            if (b2 == 0) {
                adFormat = AdFormat.BANNER;
            } else if (b2 == 1) {
                adFormat = AdFormat.INTERSTITIAL;
            } else if (b2 == 2) {
                adFormat = AdFormat.REWARDED;
            } else if (b2 == 3) {
                adFormat = AdFormat.NATIVE;
            } else {
                throw new IllegalArgumentException("Internal Error");
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList, bundle, com.google.android.gms.ads.zzb.zza(zzvnVar.width, zzvnVar.height, zzvnVar.zzacy)), zzapuVar);
        } catch (Throwable th) {
            zzbbq.zzc("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzapg zzapgVar, zzanh zzanhVar) {
        return new zzapt(this, zzapgVar, zzanhVar);
    }

    private static String zza(String str, zzvg zzvgVar) {
        String str2 = zzvgVar.zzado;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }
}
