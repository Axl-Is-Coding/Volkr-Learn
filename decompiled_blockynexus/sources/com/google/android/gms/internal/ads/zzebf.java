package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefb;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzebf extends zzeag<zzedi> {
    zzebf() {
        super(zzedi.class, new zzebe(zzehl.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzedm zzedmVar) throws GeneralSecurityException {
        if (zzedmVar.zzazy() < 12 || zzedmVar.zzazy() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzefb.zza zzayo() {
        return zzefb.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzeaf<zzedl, zzedi> zzayr() {
        return new zzebh(this, zzedl.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ void zze(zzelj zzeljVar) throws GeneralSecurityException {
        zzedi zzediVar = (zzedi) zzeljVar;
        zzeht.zzy(zzediVar.getVersion(), 0);
        zzeht.zzfp(zzediVar.zzazd().size());
        zza(zzediVar.zzazs());
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ zzelj zzr(zzeip zzeipVar) throws zzekj {
        return zzedi.zzg(zzeipVar, zzejm.zzbft());
    }
}
