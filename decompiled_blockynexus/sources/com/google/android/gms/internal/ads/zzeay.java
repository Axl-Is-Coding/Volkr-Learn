package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefb;
import com.google.android.gms.internal.ads.zzefj;
import com.google.android.gms.internal.ads.zzefm;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeay {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static zzefm zzb(zzefj zzefjVar) {
        zzefm.zzb zzbVarZzfi = zzefm.zzbco().zzfi(zzefjVar.zzbcg());
        for (zzefj.zzb zzbVar : zzefjVar.zzbch()) {
            zzbVarZzfi.zzb((zzefm.zza) zzefm.zza.zzbcq().zzhr(zzbVar.zzbcl().zzbbt()).zzb(zzbVar.zzayu()).zzb(zzbVar.zzayv()).zzfj(zzbVar.zzbcm()).zzbgt());
        }
        return (zzefm) zzbVarZzfi.zzbgt();
    }

    public static void zzc(zzefj zzefjVar) throws GeneralSecurityException {
        int iZzbcg = zzefjVar.zzbcg();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzefj.zzb zzbVar : zzefjVar.zzbch()) {
            if (zzbVar.zzayu() == zzefc.ENABLED) {
                if (!zzbVar.zzbck()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzbVar.zzbcm())));
                }
                if (zzbVar.zzayv() == zzefv.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzbVar.zzbcm())));
                }
                if (zzbVar.zzayu() == zzefc.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzbVar.zzbcm())));
                }
                if (zzbVar.zzbcm() == iZzbcg) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                if (zzbVar.zzbcl().zzbbv() != zzefb.zza.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
