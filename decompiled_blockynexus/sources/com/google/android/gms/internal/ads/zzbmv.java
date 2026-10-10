package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmv implements zzeoy<zzbmu> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzamk> zzfoh;
    private final zzeph<zzbms> zzfoi;
    private final zzeph<zzbml> zzfoj;
    private final zzeph<Clock> zzfok;

    private zzbmv(zzeph<zzamk> zzephVar, zzeph<zzbms> zzephVar2, zzeph<Executor> zzephVar3, zzeph<zzbml> zzephVar4, zzeph<Clock> zzephVar5) {
        this.zzfoh = zzephVar;
        this.zzfoi = zzephVar2;
        this.zzesr = zzephVar3;
        this.zzfoj = zzephVar4;
        this.zzfok = zzephVar5;
    }

    public static zzbmv zza(zzeph<zzamk> zzephVar, zzeph<zzbms> zzephVar2, zzeph<Executor> zzephVar3, zzeph<zzbml> zzephVar4, zzeph<Clock> zzephVar5) {
        return new zzbmv(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbmu(this.zzfoh.get(), this.zzfoi.get(), this.zzesr.get(), this.zzfoj.get(), this.zzfok.get());
    }
}
