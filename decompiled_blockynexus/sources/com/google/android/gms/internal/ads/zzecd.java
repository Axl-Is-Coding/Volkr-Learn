package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzecd extends zzeaf<zzeeh, zzeel> {
    private final /* synthetic */ zzecb zzhwb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzecd(zzecb zzecbVar, Class cls) {
        super(cls);
        this.zzhwb = zzecbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ void zzc(zzelj zzeljVar) throws GeneralSecurityException {
        zzecj.zza(((zzeeh) zzeljVar).zzbaq());
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzeel zzd(zzelj zzeljVar) throws GeneralSecurityException {
        zzeeh zzeehVar = (zzeeh) zzeljVar;
        KeyPair keyPairZza = zzegy.zza(zzegy.zza(zzecj.zza(zzeehVar.zzbaq().zzbas().zzbbf())));
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairZza.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairZza.getPrivate();
        ECPoint w = eCPublicKey.getW();
        return (zzeel) zzeel.zzbay().zzez(0).zzb((zzeem) zzeem.zzbbc().zzfa(0).zzc(zzeehVar.zzbaq()).zzab(zzeip.zzu(w.getAffineX().toByteArray())).zzac(zzeip.zzu(w.getAffineY().toByteArray())).zzbgt()).zzaa(zzeip.zzu(eCPrivateKey.getS().toByteArray())).zzbgt();
    }

    @Override // com.google.android.gms.internal.ads.zzeaf
    public final /* synthetic */ zzelj zzq(zzeip zzeipVar) throws zzekj {
        return zzeeh.zzo(zzeipVar, zzejm.zzbft());
    }
}
