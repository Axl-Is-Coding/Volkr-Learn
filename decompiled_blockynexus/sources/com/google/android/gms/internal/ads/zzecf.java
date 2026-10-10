package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzecf extends zzeai<zzeac, zzeem> {
    zzecf(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeai
    public final /* synthetic */ zzeac zzag(zzeem zzeemVar) throws GeneralSecurityException {
        zzeem zzeemVar2 = zzeemVar;
        zzeei zzeeiVarZzbaq = zzeemVar2.zzbaq();
        zzeep zzeepVarZzbas = zzeeiVarZzbaq.zzbas();
        return new zzegu(zzegy.zza(zzecj.zza(zzeepVarZzbas.zzbbf()), zzeemVar2.zzbba().toByteArray(), zzeemVar2.zzbbb().toByteArray()), zzeepVarZzbas.zzbbh().toByteArray(), zzecj.zza(zzeepVarZzbas.zzbbg()), zzecj.zza(zzeeiVarZzbaq.zzbau()), new zzecl(zzeeiVarZzbaq.zzbat().zzban()));
    }
}
