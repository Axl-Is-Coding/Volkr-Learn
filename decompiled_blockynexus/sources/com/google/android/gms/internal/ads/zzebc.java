package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzebc extends zzeaf<zzedh, zzede> {
    private final /* synthetic */ zzebb zzhvp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzebc(zzebb zzebbVar, Class cls) {
        super(cls);
        this.zzhvp = zzebbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ void zzc(zzelj zzeljVar) throws GeneralSecurityException {
        zzedh zzedhVar = (zzedh) zzeljVar;
        new zzebf().zzayr().zzc(zzedhVar.zzazp());
        new zzecp().zzayr().zzc(zzedhVar.zzazq());
        zzeht.zzfp(zzedhVar.zzazp().getKeySize());
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzede zzd(zzelj zzeljVar) throws GeneralSecurityException {
        zzedh zzedhVar = (zzedh) zzeljVar;
        zzedi zzediVarZzd = new zzebf().zzayr().zzd(zzedhVar.zzazp());
        return (zzede) zzede.zzazn().zzb(zzediVarZzd).zzb(new zzecp().zzayr().zzd(zzedhVar.zzazq())).zzet(0).zzbgt();
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzelj zzq(zzeip zzeipVar) throws zzekj {
        return zzedh.zzf(zzeipVar, zzejm.zzbft());
    }
}
