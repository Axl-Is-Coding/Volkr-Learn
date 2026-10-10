package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefb;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzebg extends zzeag<zzedp> {
    zzebg() {
        super(zzedp.class, new zzebj(zzdzv.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzefb.zza zzayo() {
        return zzefb.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzeaf<zzedq, zzedp> zzayr() {
        return new zzebi(this, zzedq.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ void zze(zzelj zzeljVar) throws GeneralSecurityException {
        zzedp zzedpVar = (zzedp) zzeljVar;
        zzeht.zzy(zzedpVar.getVersion(), 0);
        zzeht.zzfp(zzedpVar.zzazd().size());
        if (zzedpVar.zzbab().zzazy() != 12 && zzedpVar.zzbab().zzazy() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ zzelj zzr(zzeip zzeipVar) throws zzekj {
        return zzedp.zzi(zzeipVar, zzejm.zzbft());
    }
}
