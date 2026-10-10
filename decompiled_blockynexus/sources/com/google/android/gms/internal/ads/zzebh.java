package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzebh extends zzeaf<zzedl, zzedi> {
    private final /* synthetic */ zzebf zzhvq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzebh(zzebf zzebfVar, Class cls) {
        super(cls);
        this.zzhvq = zzebfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ void zzc(zzelj zzeljVar) throws GeneralSecurityException {
        zzedl zzedlVar = (zzedl) zzeljVar;
        zzeht.zzfp(zzedlVar.getKeySize());
        zzebf zzebfVar = this.zzhvq;
        zzebf.zza(zzedlVar.zzazs());
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzedi zzd(zzelj zzeljVar) throws GeneralSecurityException {
        zzedl zzedlVar = (zzedl) zzeljVar;
        return (zzedi) zzedi.zzazt().zzc(zzedlVar.zzazs()).zzu(zzeip.zzu(zzehs.zzfo(zzedlVar.getKeySize()))).zzeu(0).zzbgt();
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzelj zzq(zzeip zzeipVar) throws zzekj {
        return zzedl.zzh(zzeipVar, zzejm.zzbft());
    }
}
