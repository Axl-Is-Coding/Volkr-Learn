package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefb;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzebb extends zzeag<zzede> {
    zzebb() {
        super(zzede.class, new zzebd(zzdzv.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzefb.zza zzayo() {
        return zzefb.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzeaf<zzedh, zzede> zzayr() {
        return new zzebc(this, zzedh.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ void zze(zzelj zzeljVar) throws GeneralSecurityException {
        zzeht.zzy(((zzede) zzeljVar).getVersion(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ zzelj zzr(zzeip zzeipVar) throws zzekj {
        return zzede.zze(zzeipVar, zzejm.zzbft());
    }
}
