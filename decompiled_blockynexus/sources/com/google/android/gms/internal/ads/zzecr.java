package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzecr extends zzeaf<zzeex, zzeet> {
    private final /* synthetic */ zzecp zzhwn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzecr(zzecp zzecpVar, Class cls) {
        super(cls);
        this.zzhwn = zzecpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ void zzc(zzelj zzeljVar) throws GeneralSecurityException {
        zzeex zzeexVar = (zzeex) zzeljVar;
        if (zzeexVar.getKeySize() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzecp.zza(zzeexVar.zzbbk());
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzeet zzd(zzelj zzeljVar) throws GeneralSecurityException {
        zzeex zzeexVar = (zzeex) zzeljVar;
        return (zzeet) zzeet.zzbbl().zzfd(0).zzd(zzeexVar.zzbbk()).zzad(zzeip.zzu(zzehs.zzfo(zzeexVar.getKeySize()))).zzbgt();
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzelj zzq(zzeip zzeipVar) throws zzekj {
        return zzeex.zzs(zzeipVar, zzejm.zzbft());
    }
}
