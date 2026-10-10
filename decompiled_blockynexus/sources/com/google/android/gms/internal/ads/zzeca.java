package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeca extends zzeai<zzdzz, zzeel> {
    zzeca(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeai
    public final /* synthetic */ zzdzz zzag(zzeel zzeelVar) throws GeneralSecurityException {
        zzeel zzeelVar2 = zzeelVar;
        zzeei zzeeiVarZzbaq = zzeelVar2.zzbax().zzbaq();
        zzeep zzeepVarZzbas = zzeeiVarZzbaq.zzbas();
        zzeha zzehaVarZza = zzecj.zza(zzeepVarZzbas.zzbbf());
        byte[] byteArray = zzeelVar2.zzazd().toByteArray();
        return new zzegr((ECPrivateKey) zzehb.zzidd.zzhs("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzegy.zza(zzehaVarZza))), zzeepVarZzbas.zzbbh().toByteArray(), zzecj.zza(zzeepVarZzbas.zzbbg()), zzecj.zza(zzeeiVarZzbaq.zzbau()), new zzecl(zzeeiVarZzbaq.zzbat().zzban()));
    }
}
