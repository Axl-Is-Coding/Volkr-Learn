package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzanx extends zzanf {
    private final Object zzdlf;
    private zzaoc zzdlg;
    private zzaur zzdlh;
    private IObjectWrapper zzdli;
    private MediationRewardedAd zzdlj;

    public zzanx(MediationAdapter mediationAdapter) {
        this.zzdlf = mediationAdapter;
    }

    private final Bundle zzd(zzvg zzvgVar) {
        Bundle bundle;
        Bundle bundle2 = zzvgVar.zzchi;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zzdlf.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void destroy() throws RemoteException {
        Object obj = this.zzdlf;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.zzdlf;
        if (obj instanceof zzbiy) {
            return ((zzbiy) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzbiy.class.getCanonicalName();
        String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbq.zzfe(sb.toString());
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzyo getVideoController() {
        Object obj = this.zzdlf;
        if (!(obj instanceof com.google.android.gms.ads.mediation.zza)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zza) obj).getVideoController();
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean isInitialized() throws RemoteException {
        Object obj = this.zzdlf;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbbq.zzef("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzdlf).isInitialized();
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            return this.zzdlh != null;
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void pause() throws RemoteException {
        Object obj = this.zzdlf;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void resume() throws RemoteException {
        Object obj = this.zzdlf;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Object obj = this.zzdlf;
        if (obj instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
                return;
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                return;
            }
        }
        String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
        String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbq.zzef(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void showInterstitial() throws RemoteException {
        if (this.zzdlf instanceof MediationInterstitialAdapter) {
            zzbbq.zzef("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzdlf).showInterstitial();
                return;
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void showVideo() throws RemoteException {
        Object obj = this.zzdlf;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbbq.zzef("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzdlf).showVideo();
                return;
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzdlj;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzdli));
                return;
            } else {
                zzbbq.zzfc("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
        zza(iObjectWrapper, zzvnVar, zzvgVar, str, null, zzanhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzb(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
        if (this.zzdlf instanceof Adapter) {
            zzbbq.zzef("Requesting rewarded ad from adapter.");
            try {
                ((Adapter) this.zzdlf).loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str, zzvgVar, (String) null), zzd(zzvgVar), zzc(zzvgVar), zzvgVar.zznb, zzvgVar.zzadm, zzvgVar.zzadn, zza(str, zzvgVar), ""), zza(zzanhVar));
                return;
            } catch (Exception e2) {
                zzbbq.zzc("", e2);
                throw new RemoteException();
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzc(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
        if (this.zzdlf instanceof Adapter) {
            zzbbq.zzef("Requesting rewarded interstitial ad from adapter.");
            try {
                ((Adapter) this.zzdlf).loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str, zzvgVar, (String) null), zzd(zzvgVar), zzc(zzvgVar), zzvgVar.zznb, zzvgVar.zzadm, zzvgVar.zzadn, zza(str, zzvgVar), ""), zza(zzanhVar));
                return;
            } catch (Exception e2) {
                zzbbq.zzc("", e2);
                throw new RemoteException();
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zzdlf;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzdlf instanceof Adapter) {
            zzbbq.zzef("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzdlj;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
                return;
            } else {
                zzbbq.zzfc("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper zzts() throws RemoteException {
        Object obj = this.zzdlf;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationBannerAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzano zztt() {
        NativeAdMapper nativeAdMapperZzug = this.zzdlg.zzug();
        if (nativeAdMapperZzug instanceof NativeAppInstallAdMapper) {
            return new zzaoe((NativeAppInstallAdMapper) nativeAdMapperZzug);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzanp zztu() {
        NativeAdMapper nativeAdMapperZzug = this.zzdlg.zzug();
        if (nativeAdMapperZzug instanceof NativeContentAdMapper) {
            return new zzaod((NativeContentAdMapper) nativeAdMapperZzug);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle zztv() {
        Object obj = this.zzdlf;
        if (obj instanceof zzbiw) {
            return ((zzbiw) obj).zztv();
        }
        String canonicalName = zzbiw.class.getCanonicalName();
        String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbq.zzfe(sb.toString());
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle zztw() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean zztx() {
        return this.zzdlf instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzafa zzty() {
        NativeCustomTemplateAd nativeCustomTemplateAdZzui = this.zzdlg.zzui();
        if (nativeCustomTemplateAdZzui instanceof zzafb) {
            return ((zzafb) nativeCustomTemplateAdZzui).zzst();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzanu zztz() {
        UnifiedNativeAdMapper unifiedNativeAdMapperZzuh = this.zzdlg.zzuh();
        if (unifiedNativeAdMapperZzuh != null) {
            return new zzaow(unifiedNativeAdMapperZzuh);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzapv zzua() {
        Object obj = this.zzdlf;
        if (obj instanceof Adapter) {
            return zzapv.zza(((Adapter) obj).getVersionInfo());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzapv zzub() {
        Object obj = this.zzdlf;
        if (obj instanceof Adapter) {
            return zzapv.zza(((Adapter) obj).getSDKVersionInfo());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvg zzvgVar, String str, String str2, zzanh zzanhVar) throws RemoteException {
        if (!(this.zzdlf instanceof MediationBannerAdapter)) {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbbq.zzfe(sb.toString());
            throw new RemoteException();
        }
        zzbbq.zzef("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdlf;
            mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaoc(zzanhVar), zza(str, zzvgVar, str2), zzvnVar.zzcia ? com.google.android.gms.ads.zzb.zza(zzvnVar.width, zzvnVar.height) : com.google.android.gms.ads.zzb.zza(zzvnVar.width, zzvnVar.height, zzvnVar.zzacy), new zzany(zzvgVar.zzchb == -1 ? null : new Date(zzvgVar.zzchb), zzvgVar.zzchc, zzvgVar.zzchd != null ? new HashSet(zzvgVar.zzchd) : null, zzvgVar.zznb, zzc(zzvgVar), zzvgVar.zzadm, zzvgVar.zzchn, zzvgVar.zzadn, zza(str, zzvgVar)), zzvgVar.zzchi != null ? zzvgVar.zzchi.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            throw new RemoteException();
        }
    }

    public zzanx(Adapter adapter) {
        this.zzdlf = adapter;
    }

    private static boolean zzc(zzvg zzvgVar) {
        if (zzvgVar.zzche) {
            return true;
        }
        zzwm.zzpt();
        return zzbbg.zzym();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
        zza(iObjectWrapper, zzvgVar, str, (String) null, zzanhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, String str2, zzanh zzanhVar) throws RemoteException {
        if (this.zzdlf instanceof MediationInterstitialAdapter) {
            zzbbq.zzef("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzdlf;
                mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaoc(zzanhVar), zza(str, zzvgVar, str2), new zzany(zzvgVar.zzchb == -1 ? null : new Date(zzvgVar.zzchb), zzvgVar.zzchc, zzvgVar.zzchd != null ? new HashSet(zzvgVar.zzchd) : null, zzvgVar.zznb, zzc(zzvgVar), zzvgVar.zzadm, zzvgVar.zzchn, zzvgVar.zzadn, zza(str, zzvgVar)), zzvgVar.zzchi != null ? zzvgVar.zzchi.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
                return;
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, String str2, zzanh zzanhVar, zzadu zzaduVar, List<String> list) throws RemoteException {
        Object obj = this.zzdlf;
        if (obj instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
                zzaog zzaogVar = new zzaog(zzvgVar.zzchb == -1 ? null : new Date(zzvgVar.zzchb), zzvgVar.zzchc, zzvgVar.zzchd != null ? new HashSet(zzvgVar.zzchd) : null, zzvgVar.zznb, zzc(zzvgVar), zzvgVar.zzadm, zzaduVar, list, zzvgVar.zzchn, zzvgVar.zzadn, zza(str, zzvgVar));
                Bundle bundle = zzvgVar.zzchi != null ? zzvgVar.zzchi.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.zzdlg = new zzaoc(zzanhVar);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzdlg, zza(str, zzvgVar, str2), zzaogVar, bundle);
                return;
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationNativeAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzaur zzaurVar, String str2) throws RemoteException {
        zzany zzanyVar;
        Bundle bundle;
        Object obj = this.zzdlf;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbbq.zzef("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdlf;
                Bundle bundleZza = zza(str2, zzvgVar, (String) null);
                if (zzvgVar != null) {
                    zzany zzanyVar2 = new zzany(zzvgVar.zzchb == -1 ? null : new Date(zzvgVar.zzchb), zzvgVar.zzchc, zzvgVar.zzchd != null ? new HashSet(zzvgVar.zzchd) : null, zzvgVar.zznb, zzc(zzvgVar), zzvgVar.zzadm, zzvgVar.zzchn, zzvgVar.zzadn, zza(str2, zzvgVar));
                    bundle = zzvgVar.zzchi != null ? zzvgVar.zzchi.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzanyVar = zzanyVar2;
                } else {
                    zzanyVar = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzanyVar, str, new zzaus(zzaurVar), bundleZza, bundle);
                return;
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            this.zzdli = iObjectWrapper;
            this.zzdlh = zzaurVar;
            zzaurVar.zzaf(ObjectWrapper.wrap(obj));
            return;
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzaur zzaurVar, List<String> list) throws RemoteException {
        if (this.zzdlf instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzbbq.zzef("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzdlf;
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(zza(it.next(), (zzvg) null, (String) null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaus(zzaurVar), arrayList);
                return;
            } catch (Throwable th) {
                zzbbq.zzd("Could not initialize rewarded video adapter.", th);
                throw new RemoteException();
            }
        }
        String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(zzvg zzvgVar, String str) throws RemoteException {
        zza(zzvgVar, str, (String) null);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(zzvg zzvgVar, String str, String str2) throws RemoteException {
        Object obj = this.zzdlf;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbbq.zzef("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdlf;
                mediationRewardedVideoAdAdapter.loadAd(new zzany(zzvgVar.zzchb == -1 ? null : new Date(zzvgVar.zzchb), zzvgVar.zzchc, zzvgVar.zzchd != null ? new HashSet(zzvgVar.zzchd) : null, zzvgVar.zznb, zzc(zzvgVar), zzvgVar.zzadm, zzvgVar.zzchn, zzvgVar.zzadn, zza(str, zzvgVar)), zza(str, zzvgVar, str2), zzvgVar.zzchi != null ? zzvgVar.zzchi.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
                return;
            } catch (Throwable th) {
                zzbbq.zzc("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            zzb(this.zzdli, zzvgVar, str, new zzaob((Adapter) obj, this.zzdlh));
            return;
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.zzdlf.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzbbq.zzfe(sb.toString());
        throw new RemoteException();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzais zzaisVar, List<zzaja> list) throws RemoteException {
        AdFormat adFormat;
        if (this.zzdlf instanceof Adapter) {
            zzaoa zzaoaVar = new zzaoa(this, zzaisVar);
            ArrayList arrayList = new ArrayList();
            for (zzaja zzajaVar : list) {
                String str = zzajaVar.zzdge;
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
                    throw new RemoteException();
                }
                arrayList.add(new MediationConfiguration(adFormat, zzajaVar.extras));
            }
            ((Adapter) this.zzdlf).initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzaoaVar, arrayList);
            return;
        }
        throw new RemoteException();
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzanh zzanhVar) {
        return new zzanz(this, zzanhVar);
    }

    private final Bundle zza(String str, zzvg zzvgVar, String str2) throws RemoteException {
        Bundle bundle;
        String strValueOf = String.valueOf(str);
        zzbbq.zzef(strValueOf.length() != 0 ? "Server parameters: ".concat(strValueOf) : new String("Server parameters: "));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } else {
                bundle = bundle2;
            }
            if (this.zzdlf instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzvgVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzvgVar.zzadm);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            throw new RemoteException();
        }
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
