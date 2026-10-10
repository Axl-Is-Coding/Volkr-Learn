package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzsn extends AppOpenAd {
    private final zzsg zzbus;

    public zzsn(zzsg zzsgVar) {
        this.zzbus = zzsgVar;
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final ResponseInfo getResponseInfo() {
        zzyn zzynVarZzki;
        try {
            zzynVarZzki = this.zzbus.zzki();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            zzynVarZzki = null;
        }
        return ResponseInfo.zza(zzynVarZzki);
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void show(Activity activity, FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzbus.zza(ObjectWrapper.wrap(activity), new zzsd(fullScreenContentCallback));
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    protected final void zza(zzsm zzsmVar) {
        try {
            this.zzbus.zza(zzsmVar);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    protected final zzxc zzdw() {
        try {
            return this.zzbus.zzdw();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }
}
