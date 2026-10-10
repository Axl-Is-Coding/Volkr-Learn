package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefb;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzecp extends zzeag<zzeet> {
    public zzecp() {
        super(zzeet.class, new zzecs(zzeam.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzeey zzeeyVar) throws GeneralSecurityException {
        if (zzeeyVar.zzazi() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i = zzecu.zzhwk[zzeeyVar.zzbbq().ordinal()];
        if (i == 1) {
            if (zzeeyVar.zzazi() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i == 2) {
            if (zzeeyVar.zzazi() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i != 3) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (zzeeyVar.zzazi() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzefb.zza zzayo() {
        return zzefb.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final zzeaf<zzeex, zzeet> zzayr() {
        return new zzecr(this, zzeex.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ void zze(zzelj zzeljVar) throws GeneralSecurityException {
        zzeet zzeetVar = (zzeet) zzeljVar;
        zzeht.zzy(zzeetVar.getVersion(), 0);
        if (zzeetVar.zzazd().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zza(zzeetVar.zzbbk());
    }

    @Override // com.google.android.gms.internal.ads.zzeag
    public final /* synthetic */ zzelj zzr(zzeip zzeipVar) throws zzekj {
        return zzeet.zzr(zzeipVar, zzejm.zzbft());
    }
}
