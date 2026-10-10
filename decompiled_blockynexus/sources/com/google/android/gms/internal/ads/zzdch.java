package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdch implements zzeoy<zzdcf> {
    private final zzeph<Set<String>> zzgvo;

    private zzdch(zzeph<Set<String>> zzephVar) {
        this.zzgvo = zzephVar;
    }

    public static zzdch zzal(zzeph<Set<String>> zzephVar) {
        return new zzdch(zzephVar);
    }

    public static zzdcf zzd(Set<String> set) {
        return new zzdcf(set);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzd(this.zzgvo.get());
    }
}
