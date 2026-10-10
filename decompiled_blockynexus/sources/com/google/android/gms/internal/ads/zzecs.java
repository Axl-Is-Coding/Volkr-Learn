package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzecs extends zzeai<zzeam, zzeet> {
    zzecs(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeai
    public final /* synthetic */ zzeam zzag(zzeet zzeetVar) throws GeneralSecurityException {
        zzeet zzeetVar2 = zzeetVar;
        zzeer zzeerVarZzbbq = zzeetVar2.zzbbk().zzbbq();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzeetVar2.zzazd().toByteArray(), "HMAC");
        int iZzazi = zzeetVar2.zzbbk().zzazi();
        int i = zzecu.zzhwk[zzeerVarZzbbq.ordinal()];
        if (i == 1) {
            return new zzehp(new zzehn("HMACSHA1", secretKeySpec), iZzazi);
        }
        if (i == 2) {
            return new zzehp(new zzehn("HMACSHA256", secretKeySpec), iZzazi);
        }
        if (i == 3) {
            return new zzehp(new zzehn("HMACSHA512", secretKeySpec), iZzazi);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
