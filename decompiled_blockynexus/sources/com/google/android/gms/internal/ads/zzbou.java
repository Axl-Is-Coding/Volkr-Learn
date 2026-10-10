package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbou implements zzeoy<zzbos> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzcaf> zzfdb;
    private final zzeph<zzbqn> zzfeb;
    private final zzeph<zzczf> zzfjc;
    private final zzeph<View> zzfnp;
    private final zzeph<zzdnu> zzfqg;
    private final zzeph<zzbgj> zzfqh;
    private final zzeph<zzbql> zzfqi;
    private final zzeph<zzcep> zzfqj;
    private final zzeph<Executor> zzfqk;

    public zzbou(zzeph<zzbqn> zzephVar, zzeph<Context> zzephVar2, zzeph<zzdnu> zzephVar3, zzeph<View> zzephVar4, zzeph<zzbgj> zzephVar5, zzeph<zzbql> zzephVar6, zzeph<zzcep> zzephVar7, zzeph<zzcaf> zzephVar8, zzeph<zzczf> zzephVar9, zzeph<Executor> zzephVar10) {
        this.zzfeb = zzephVar;
        this.zzesu = zzephVar2;
        this.zzfqg = zzephVar3;
        this.zzfnp = zzephVar4;
        this.zzfqh = zzephVar5;
        this.zzfqi = zzephVar6;
        this.zzfqj = zzephVar7;
        this.zzfdb = zzephVar8;
        this.zzfjc = zzephVar9;
        this.zzfqk = zzephVar10;
    }

    public static zzbos zza(zzbqn zzbqnVar, Context context, zzdnu zzdnuVar, View view, zzbgj zzbgjVar, zzbql zzbqlVar, zzcep zzcepVar, zzcaf zzcafVar, zzeos<zzczf> zzeosVar, Executor executor) {
        return new zzbos(zzbqnVar, context, zzdnuVar, view, zzbgjVar, zzbqlVar, zzcepVar, zzcafVar, zzeosVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfeb.get(), this.zzesu.get(), this.zzfqg.get(), this.zzfnp.get(), this.zzfqh.get(), this.zzfqi.get(), this.zzfqj.get(), this.zzfdb.get(), zzeov.zzat(this.zzfjc), this.zzfqk.get());
    }
}
