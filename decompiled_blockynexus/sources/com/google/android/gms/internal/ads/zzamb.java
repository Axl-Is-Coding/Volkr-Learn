package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamb {

    @VisibleForTesting
    private static final zzbad<zzaki> zzdiq = new zzame();

    @VisibleForTesting
    private static final zzbad<zzaki> zzdir = new zzamd();
    private final zzakr zzdis;

    public zzamb(Context context, zzbbx zzbbxVar, String str) {
        this.zzdis = new zzakr(context, zzbbxVar, str, zzdiq, zzdir);
    }

    public final <I, O> zzalt<I, O> zza(String str, zzaly<I> zzalyVar, zzalv<O> zzalvVar) {
        return new zzamg(this.zzdis, str, zzalyVar, zzalvVar);
    }

    public final zzamk zztp() {
        return new zzamk(this.zzdis);
    }
}
