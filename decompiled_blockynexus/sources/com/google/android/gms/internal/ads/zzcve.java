package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcve implements zzccm {
    private zzbuu zzftk = null;
    private final zzdnv zzftl;
    private final zzaph zzgpg;
    private final boolean zzgph;

    zzcve(zzdnv zzdnvVar, zzaph zzaphVar, boolean z) {
        this.zzftl = zzdnvVar;
        this.zzgpg = zzaphVar;
        this.zzgph = z;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void zza(boolean z, Context context) throws zzccl {
        try {
            if (!(this.zzgph ? this.zzgpg.zzaa(ObjectWrapper.wrap(context)) : this.zzgpg.zzz(ObjectWrapper.wrap(context)))) {
                throw new zzccl("Adapter failed to show.");
            }
            if (this.zzftk == null) {
                return;
            }
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqh)).booleanValue() || this.zzftl.zzhed != 2) {
                return;
            }
            this.zzftk.onAdImpression();
        } catch (Throwable th) {
            throw new zzccl(th);
        }
    }

    public final void zza(zzbuu zzbuuVar) {
        this.zzftk = zzbuuVar;
    }
}
