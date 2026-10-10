package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwt implements zzeoy<zzcwr> {
    private final zzeph<Context> zzesu;
    private final zzeph<Executor> zzfqk;
    private final zzeph<zzcjj> zzgof;

    public zzcwt(zzeph<Context> zzephVar, zzeph<Executor> zzephVar2, zzeph<zzcjj> zzephVar3) {
        this.zzesu = zzephVar;
        this.zzfqk = zzephVar2;
        this.zzgof = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcwr(this.zzesu.get(), this.zzfqk.get(), this.zzgof.get());
    }
}
