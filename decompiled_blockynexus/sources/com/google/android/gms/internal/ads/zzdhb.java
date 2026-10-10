package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhb<T> implements zzeoy<zzdgw<T>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<Set<zzdgx<? extends zzdgu<T>>>> zzgym;

    private zzdhb(zzeph<Executor> zzephVar, zzeph<Set<zzdgx<? extends zzdgu<T>>>> zzephVar2) {
        this.zzesr = zzephVar;
        this.zzgym = zzephVar2;
    }

    public static <T> zzdgw<T> zza(Executor executor, Set<zzdgx<? extends zzdgu<T>>> set) {
        return new zzdgw<>(executor, set);
    }

    public static <T> zzdhb<T> zzbg(zzeph<Executor> zzephVar, zzeph<Set<zzdgx<? extends zzdgu<T>>>> zzephVar2) {
        return new zzdhb<>(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzesr.get(), this.zzgym.get());
    }
}
