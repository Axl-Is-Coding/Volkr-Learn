package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcna implements zzeoy<zzcmy> {
    private final zzeph<Clock> zzfok;
    private final zzeph<zzcms> zzghq;
    private final zzeph<Set<zzcmx>> zzghr;

    private zzcna(zzeph<zzcms> zzephVar, zzeph<Set<zzcmx>> zzephVar2, zzeph<Clock> zzephVar3) {
        this.zzghq = zzephVar;
        this.zzghr = zzephVar2;
        this.zzfok = zzephVar3;
    }

    public static zzcna zzo(zzeph<zzcms> zzephVar, zzeph<Set<zzcmx>> zzephVar2, zzeph<Clock> zzephVar3) {
        return new zzcna(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcmy(this.zzghq.get(), this.zzghr.get(), this.zzfok.get());
    }
}
