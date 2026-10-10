package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefb;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzebm extends zzeag<zzedy> {
    zzebm() {
        super(zzedy.class, new zzebp(zzdzv.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzefb.zza zzayo() {
        return zzefb.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzeaf<zzeeb, zzedy> zzayr() {
        return new zzebo(this, zzeeb.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ void zze(zzelj zzeljVar) throws GeneralSecurityException {
        zzedy zzedyVar = (zzedy) zzeljVar;
        zzeht.zzy(zzedyVar.getVersion(), 0);
        if (zzedyVar.zzazd().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ zzelj zzr(zzeip zzeipVar) throws zzekj {
        return zzedy.zzm(zzeipVar, zzejm.zzbft());
    }
}
