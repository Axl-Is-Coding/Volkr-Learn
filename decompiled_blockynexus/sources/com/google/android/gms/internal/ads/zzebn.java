package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzebn extends zzeaf<zzedx, zzedu> {
    private final /* synthetic */ zzebl zzhvs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzebn(zzebl zzeblVar, Class cls) {
        super(cls);
        this.zzhvs = zzeblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ void zzc(zzelj zzeljVar) throws GeneralSecurityException {
        zzeht.zzfp(((zzedx) zzeljVar).getKeySize());
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzedu zzd(zzelj zzeljVar) throws GeneralSecurityException {
        return (zzedu) zzedu.zzbah().zzw(zzeip.zzu(zzehs.zzfo(((zzedx) zzeljVar).getKeySize()))).zzew(0).zzbgt();
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzelj zzq(zzeip zzeipVar) throws zzekj {
        return zzedx.zzl(zzeipVar, zzejm.zzbft());
    }
}
