package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzciz implements zzeoy<zzciy> {
    private final zzeph<Context> zzesu;
    private final zzeph<Executor> zzfqk;
    private final zzeph<zzbbx> zzfup;
    private final zzeph<zzeg> zzfyn;
    private final zzeph<com.google.android.gms.ads.internal.zzb> zzgds;
    private final zzeph<zzbgr> zzgey;

    public zzciz(zzeph<Context> zzephVar, zzeph<Executor> zzephVar2, zzeph<zzeg> zzephVar3, zzeph<zzbbx> zzephVar4, zzeph<com.google.android.gms.ads.internal.zzb> zzephVar5, zzeph<zzbgr> zzephVar6) {
        this.zzesu = zzephVar;
        this.zzfqk = zzephVar2;
        this.zzfyn = zzephVar3;
        this.zzfup = zzephVar4;
        this.zzgds = zzephVar5;
        this.zzgey = zzephVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzciy(this.zzesu.get(), this.zzfqk.get(), this.zzfyn.get(), this.zzfup.get(), this.zzgds.get(), this.zzgey.get());
    }
}
