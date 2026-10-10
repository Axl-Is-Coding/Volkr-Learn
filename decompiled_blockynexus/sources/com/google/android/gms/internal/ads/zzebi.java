package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzebi extends zzeaf<zzedq, zzedp> {
    private final /* synthetic */ zzebg zzhvr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzebi(zzebg zzebgVar, Class cls) {
        super(cls);
        this.zzhvr = zzebgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ void zzc(zzelj zzeljVar) throws GeneralSecurityException {
        zzedq zzedqVar = (zzedq) zzeljVar;
        zzeht.zzfp(zzedqVar.getKeySize());
        if (zzedqVar.zzbab().zzazy() != 12 && zzedqVar.zzbab().zzazy() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzedp zzd(zzelj zzeljVar) throws GeneralSecurityException {
        zzedq zzedqVar = (zzedq) zzeljVar;
        return (zzedp) zzedp.zzbac().zzv(zzeip.zzu(zzehs.zzfo(zzedqVar.getKeySize()))).zzb(zzedqVar.zzbab()).zzev(0).zzbgt();
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzelj zzq(zzeip zzeipVar) throws zzekj {
        return zzedq.zzj(zzeipVar, zzejm.zzbft());
    }
}
