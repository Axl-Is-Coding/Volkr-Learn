package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefb;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzebv extends zzeag<zzefr> {
    zzebv() {
        super(zzefr.class, new zzebu(zzdzv.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzefb.zza zzayo() {
        return zzefb.zza.REMOTE;
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzeaf<zzefu, zzefr> zzayr() {
        return new zzebx(this, zzefu.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ void zze(zzelj zzeljVar) throws GeneralSecurityException {
        zzeht.zzy(((zzefr) zzeljVar).getVersion(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ zzelj zzr(zzeip zzeipVar) throws zzekj {
        return zzefr.zzv(zzeipVar, zzejm.zzbft());
    }
}
