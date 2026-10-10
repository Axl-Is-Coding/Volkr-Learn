package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdqo {
    private HashMap<zzdqf, zzdqn<? extends zzbqo>> zzhiv = new HashMap<>();

    public final <AdT extends zzbqo> zzdqn<AdT> zza(zzdqf zzdqfVar, Context context, zzdpw zzdpwVar, zzdqv<AdT> zzdqvVar) {
        zzdqn<AdT> zzdqnVar = (zzdqn) this.zzhiv.get(zzdqfVar);
        if (zzdqnVar != null) {
            return zzdqnVar;
        }
        zzdqc zzdqcVar = new zzdqc(zzdqg.zza(zzdqfVar, context));
        zzdqn<AdT> zzdqnVar2 = new zzdqn<>(zzdqcVar, new zzdqs(zzdqcVar, zzdpwVar, zzdqvVar));
        this.zzhiv.put(zzdqfVar, zzdqnVar2);
        return zzdqnVar2;
    }
}
