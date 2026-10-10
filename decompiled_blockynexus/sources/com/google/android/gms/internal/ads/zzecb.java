package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefb;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzecb extends zzeas<zzeel, zzeem> {
    private static final byte[] zzhwa = new byte[0];

    zzecb() {
        super(zzeel.class, zzeem.class, new zzeca(zzdzz.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzefb.zza zzayo() {
        return zzefb.zza.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzeaf<zzeeh, zzeel> zzayr() {
        return new zzecd(this, zzeeh.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ void zze(zzelj zzeljVar) throws GeneralSecurityException {
        zzeel zzeelVar = (zzeel) zzeljVar;
        if (zzeelVar.zzazd().isEmpty()) {
            throw new GeneralSecurityException("invalid ECIES private key");
        }
        zzeht.zzy(zzeelVar.getVersion(), 0);
        zzecj.zza(zzeelVar.zzbax().zzbaq());
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ zzelj zzr(zzeip zzeipVar) throws zzekj {
        return zzeel.zzp(zzeipVar, zzejm.zzbft());
    }
}
