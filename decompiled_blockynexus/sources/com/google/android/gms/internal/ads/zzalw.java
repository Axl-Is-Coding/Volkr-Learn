package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzalw {
    private final Object zzdij = new Object();
    private final Object zzdik = new Object();
    private zzamb zzdil;
    private zzamb zzdim;

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzamb zza(Context context, zzbbx zzbbxVar) {
        zzamb zzambVar;
        synchronized (this.zzdik) {
            if (this.zzdim == null) {
                this.zzdim = new zzamb(zzl(context), zzbbxVar, zzade.zzdcm.get());
            }
            zzambVar = this.zzdim;
        }
        return zzambVar;
    }

    public final zzamb zzb(Context context, zzbbx zzbbxVar) {
        zzamb zzambVar;
        synchronized (this.zzdij) {
            if (this.zzdil == null) {
                this.zzdil = new zzamb(zzl(context), zzbbxVar, (String) zzwm.zzpx().zzd(zzabb.zzcls));
            }
            zzambVar = this.zzdil;
        }
        return zzambVar;
    }
}
