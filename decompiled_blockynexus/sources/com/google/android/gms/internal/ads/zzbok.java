package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbok extends zzsf {
    private final zzxc zzbut;
    private final zzboh zzfpu;
    private final zzdkc zzfpv;

    public zzbok(zzboh zzbohVar, zzxc zzxcVar, zzdkc zzdkcVar) {
        this.zzfpu = zzbohVar;
        this.zzbut = zzxcVar;
        this.zzfpv = zzdkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(IObjectWrapper iObjectWrapper, zzsq zzsqVar) {
        try {
            this.zzfpv.zza(zzsqVar);
            this.zzfpu.zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzsqVar);
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(zzsm zzsmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final zzxc zzdw() {
        return this.zzbut;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final zzyn zzki() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcxl)).booleanValue()) {
            return this.zzfpu.zzaix();
        }
        return null;
    }
}
