package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqb implements zzeoy<zzbpw> {
    private final zzeph<zzbqn> zzfeb;
    private final zzeph<Runnable> zzfkd;
    private final zzeph<zzafy> zzfop;
    private final zzeph<Executor> zzfqk;

    public zzbqb(zzeph<zzbqn> zzephVar, zzeph<zzafy> zzephVar2, zzeph<Runnable> zzephVar3, zzeph<Executor> zzephVar4) {
        this.zzfeb = zzephVar;
        this.zzfop = zzephVar2;
        this.zzfkd = zzephVar3;
        this.zzfqk = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbpw(this.zzfeb.get(), this.zzfop.get(), this.zzfkd.get(), this.zzfqk.get());
    }
}
