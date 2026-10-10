package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.a;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.b;
import com.google.ads.mediation.d;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaof<NETWORK_EXTRAS extends d, SERVER_PARAMETERS extends MediationServerParameters> extends zzanf {
    private final b<NETWORK_EXTRAS, SERVER_PARAMETERS> zzdlw;
    private final NETWORK_EXTRAS zzdlx;

    public zzaof(b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar, NETWORK_EXTRAS network_extras) {
        this.zzdlw = bVar;
        this.zzdlx = network_extras;
    }

    private static boolean zzc(zzvg zzvgVar) {
        if (zzvgVar.zzche) {
            return true;
        }
        zzwm.zzpt();
        return zzbbg.zzym();
    }

    private final SERVER_PARAMETERS zzdp(String str) throws RemoteException {
        HashMap map;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                map = new HashMap(jSONObject.length());
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            } else {
                map = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> serverParametersType = this.zzdlw.getServerParametersType();
            if (serverParametersType == null) {
                return null;
            }
            SERVER_PARAMETERS server_parametersNewInstance = serverParametersType.newInstance();
            server_parametersNewInstance.a(map);
            return server_parametersNewInstance;
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void destroy() throws RemoteException {
        try {
            this.zzdlw.destroy();
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzyo getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void showInterstitial() throws RemoteException {
        b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.zzdlw;
        if (!(bVar instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbbq.zzfe(strValueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbbq.zzef("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdlw).showInterstitial();
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void showVideo() {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzais zzaisVar, List<zzaja> list) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzaur zzaurVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzaur zzaurVar, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, String str2, zzanh zzanhVar, zzadu zzaduVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
        zza(iObjectWrapper, zzvnVar, zzvgVar, str, null, zzanhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(zzvg zzvgVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(zzvg zzvgVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzb(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzc(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper zzts() throws RemoteException {
        b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.zzdlw;
        if (!(bVar instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbbq.zzfe(strValueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(strValueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) bVar).getBannerView());
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzano zztt() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzanp zztu() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle zztv() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle zztw() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean zztx() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzafa zzty() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzanu zztz() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzapv zzua() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzapv zzub() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvg zzvgVar, String str, String str2, zzanh zzanhVar) throws RemoteException {
        a aVar;
        b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.zzdlw;
        if (!(bVar instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbbq.zzfe(strValueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(strValueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzbbq.zzef("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdlw;
            zzaoi zzaoiVar = new zzaoi(zzanhVar);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            MediationServerParameters mediationServerParametersZzdp = zzdp(str);
            int i = 0;
            a[] aVarArr = {a.f12536a, a.f12537b, a.f12538c, a.f12539d, a.f12540e, a.f12541f};
            while (true) {
                if (i >= 6) {
                    aVar = new a(com.google.android.gms.ads.zzb.zza(zzvnVar.width, zzvnVar.height, zzvnVar.zzacy));
                    break;
                } else {
                    if (aVarArr[i].b() == zzvnVar.width && aVarArr[i].a() == zzvnVar.height) {
                        aVar = aVarArr[i];
                        break;
                    }
                    i++;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzaoiVar, activity, mediationServerParametersZzdp, aVar, zzaou.zza(zzvgVar, zzc(zzvgVar)), this.zzdlx);
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
        zza(iObjectWrapper, zzvgVar, str, (String) null, zzanhVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, String str2, zzanh zzanhVar) throws RemoteException {
        b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.zzdlw;
        if (!(bVar instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbbq.zzfe(strValueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbbq.zzef("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdlw).requestInterstitialAd(new zzaoi(zzanhVar), (Activity) ObjectWrapper.unwrap(iObjectWrapper), zzdp(str), zzaou.zza(zzvgVar, zzc(zzvgVar)), this.zzdlx);
        } catch (Throwable th) {
            zzbbq.zzc("", th);
            throw new RemoteException();
        }
    }
}
