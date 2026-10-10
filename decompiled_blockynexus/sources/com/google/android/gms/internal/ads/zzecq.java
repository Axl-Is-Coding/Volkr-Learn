package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzecq extends zzeaf<zzeda, zzecz> {
    zzecq(zzeco zzecoVar, Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ void zzc(zzelj zzeljVar) throws GeneralSecurityException {
        zzeda zzedaVar = (zzeda) zzeljVar;
        zzeco.zza(zzedaVar.zzaze());
        zzeco.zzeq(zzedaVar.getKeySize());
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzecz zzd(zzelj zzeljVar) throws GeneralSecurityException {
        zzeda zzedaVar = (zzeda) zzeljVar;
        return (zzecz) zzecz.zzazf().zzes(0).zzt(zzeip.zzu(zzehs.zzfo(zzedaVar.getKeySize()))).zzd(zzedaVar.zzaze()).zzbgt();
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzelj zzq(zzeip zzeipVar) throws zzekj {
        return zzeda.zzd(zzeipVar, zzejm.zzbft());
    }
}
