package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zztx {

    @VisibleForTesting
    zzgx zzbxy;

    @VisibleForTesting
    boolean zzbxz;

    public zztx(Context context, String str, String str2) {
        zzabb.initialize(context);
        try {
            this.zzbxy = (zzgx) zzbbt.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zztw.zzbxx);
            ObjectWrapper.wrap(context);
            this.zzbxy.zza(ObjectWrapper.wrap(context), str, null);
            this.zzbxz = true;
        } catch (RemoteException | zzbbv | NullPointerException unused) {
            zzbbq.zzef("Cannot dynamite load clearcut");
        }
    }

    public final zzub zzf(byte[] bArr) {
        return new zzub(this, bArr);
    }

    public zztx(Context context) {
        zzabb.initialize(context);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzctw)).booleanValue()) {
            try {
                this.zzbxy = (zzgx) zzbbt.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zztz.zzbxx);
                ObjectWrapper.wrap(context);
                this.zzbxy.zza(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzbxz = true;
            } catch (RemoteException | zzbbv | NullPointerException unused) {
                zzbbq.zzef("Cannot dynamite load clearcut");
            }
        }
    }

    public zztx() {
    }
}
