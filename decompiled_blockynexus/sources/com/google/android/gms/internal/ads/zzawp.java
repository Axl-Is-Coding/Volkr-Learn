package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzawp implements zzqu {
    private final Object lock;
    private String zzbuu;
    private final Context zzclo;
    private boolean zzdxz;

    public zzawp(Context context, String str) {
        this.zzclo = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzbuu = str;
        this.zzdxz = false;
        this.lock = new Object();
    }

    public final String getAdUnitId() {
        return this.zzbuu;
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(zzqr zzqrVar) {
        zzam(zzqrVar.zzbro);
    }

    public final void zzam(boolean z) {
        if (com.google.android.gms.ads.internal.zzp.zzlp().zzac(this.zzclo)) {
            synchronized (this.lock) {
                if (this.zzdxz == z) {
                    return;
                }
                this.zzdxz = z;
                if (TextUtils.isEmpty(this.zzbuu)) {
                    return;
                }
                if (this.zzdxz) {
                    com.google.android.gms.ads.internal.zzp.zzlp().zzf(this.zzclo, this.zzbuu);
                } else {
                    com.google.android.gms.ads.internal.zzp.zzlp().zzg(this.zzclo, this.zzbuu);
                }
            }
        }
    }
}
