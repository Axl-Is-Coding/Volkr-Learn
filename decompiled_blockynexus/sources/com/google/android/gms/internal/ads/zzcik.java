package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcik extends zzagd {
    private final String zzcib;
    private final zzcei zzfxu;
    private final zzcdx zzgaw;

    public zzcik(String str, zzcdx zzcdxVar, zzcei zzceiVar) {
        this.zzcib = str;
        this.zzgaw = zzcdxVar;
        this.zzfxu = zzceiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void cancelUnconfirmedClick() throws RemoteException {
        this.zzgaw.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void destroy() throws RemoteException {
        this.zzgaw.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getAdvertiser() throws RemoteException {
        return this.zzfxu.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getBody() throws RemoteException {
        return this.zzfxu.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getCallToAction() throws RemoteException {
        return this.zzfxu.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final Bundle getExtras() throws RemoteException {
        return this.zzfxu.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getHeadline() throws RemoteException {
        return this.zzfxu.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final List<?> getImages() throws RemoteException {
        return this.zzfxu.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzcib;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final List<?> getMuteThisAdReasons() throws RemoteException {
        return isCustomMuteThisAdEnabled() ? this.zzfxu.getMuteThisAdReasons() : Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getPrice() throws RemoteException {
        return this.zzfxu.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final double getStarRating() throws RemoteException {
        return this.zzfxu.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getStore() throws RemoteException {
        return this.zzfxu.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final zzyo getVideoController() throws RemoteException {
        return this.zzfxu.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final boolean isCustomClickGestureEnabled() {
        return this.zzgaw.isCustomClickGestureEnabled();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final boolean isCustomMuteThisAdEnabled() throws RemoteException {
        return (this.zzfxu.getMuteThisAdReasons().isEmpty() || this.zzfxu.zzamd() == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzgaw.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void recordCustomClickGesture() {
        this.zzgaw.recordCustomClickGesture();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzgaw.zzi(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzgaw.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void zza(zzafz zzafzVar) throws RemoteException {
        this.zzgaw.zza(zzafzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final zzyn zzki() throws RemoteException {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcxl)).booleanValue()) {
            return this.zzgaw.zzaix();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final IObjectWrapper zzsk() throws RemoteException {
        return ObjectWrapper.wrap(this.zzgaw);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final zzaee zzsl() throws RemoteException {
        return this.zzfxu.zzsl();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final zzadw zzsm() throws RemoteException {
        return this.zzfxu.zzsm();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final IObjectWrapper zzsn() throws RemoteException {
        return this.zzfxu.zzsn();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void zzsv() {
        this.zzgaw.zzsv();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final zzadz zzsw() throws RemoteException {
        return this.zzgaw.zzalx().zzsw();
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void zza(zzyd zzydVar) throws RemoteException {
        this.zzgaw.zza(zzydVar);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void zza(zzxz zzxzVar) throws RemoteException {
        this.zzgaw.zza(zzxzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void zza(zzyi zzyiVar) throws RemoteException {
        this.zzgaw.zza(zzyiVar);
    }
}
