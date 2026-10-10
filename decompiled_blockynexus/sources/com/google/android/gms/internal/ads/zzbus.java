package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbus implements zzeoy<zzbuk> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzbuo> zzfdv;
    private final zzeph<Set<zzcab<zzbul>>> zzfqq;

    private zzbus(zzeph<zzbuo> zzephVar, zzeph<Set<zzcab<zzbul>>> zzephVar2, zzeph<Executor> zzephVar3) {
        this.zzfdv = zzephVar;
        this.zzfqq = zzephVar2;
        this.zzesr = zzephVar3;
    }

    public static zzbus zzj(zzeph<zzbuo> zzephVar, zzeph<Set<zzcab<zzbul>>> zzephVar2, zzeph<Executor> zzephVar3) {
        return new zzbus(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbuk(this.zzfdv.get(), this.zzfqq.get(), this.zzesr.get());
    }
}
