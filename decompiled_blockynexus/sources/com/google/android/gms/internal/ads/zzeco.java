package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefb;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeco extends zzeag<zzecz> {
    zzeco() {
        super(zzecz.class, new zzecn(zzeam.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzedd zzeddVar) throws GeneralSecurityException {
        if (zzeddVar.zzazi() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (zzeddVar.zzazi() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzeq(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzefb.zza zzayo() {
        return zzefb.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzeaf<zzeda, zzecz> zzayr() {
        return new zzecq(this, zzeda.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ void zze(zzelj zzeljVar) throws GeneralSecurityException {
        zzecz zzeczVar = (zzecz) zzeljVar;
        zzeht.zzy(zzeczVar.getVersion(), 0);
        zzeq(zzeczVar.zzazd().size());
        zza(zzeczVar.zzaze());
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ zzelj zzr(zzeip zzeipVar) throws zzekj {
        return zzecz.zzc(zzeipVar, zzejm.zzbft());
    }
}
