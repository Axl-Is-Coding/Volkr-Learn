package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefb;
import com.google.android.gms.internal.ads.zzefj;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class zzeal {
    @Deprecated
    public static final zzeah zzl(byte[] bArr) throws GeneralSecurityException {
        try {
            zzefj zzefjVarZzc = zzefj.zzc(bArr, zzejm.zzbft());
            for (zzefj.zzb zzbVar : zzefjVarZzc.zzbch()) {
                if (zzbVar.zzbcl().zzbbv() == zzefb.zza.UNKNOWN_KEYMATERIAL || zzbVar.zzbcl().zzbbv() == zzefb.zza.SYMMETRIC || zzbVar.zzbcl().zzbbv() == zzefb.zza.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzeah.zza(zzefjVarZzc);
        } catch (zzekj unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
