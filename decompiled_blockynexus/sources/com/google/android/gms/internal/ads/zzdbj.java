package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbj implements zzeoy<Set<String>> {
    private final zzdbd zzgur;

    public zzdbj(zzdbd zzdbdVar) {
        this.zzgur = zzdbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<String> setZzarg = this.zzgur.zzarg();
        zzepe.zza(setZzarg, "Cannot return null from a non-@Nullable @Provides method");
        return setZzarg;
    }
}
