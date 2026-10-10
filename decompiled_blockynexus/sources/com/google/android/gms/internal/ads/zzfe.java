package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfe {
    static zzeac zzaaa;

    static boolean zzb(zzex zzexVar) throws IllegalAccessException, GeneralSecurityException, InvocationTargetException {
        Method methodZza;
        if (zzaaa != null) {
            return true;
        }
        String str = (String) zzwm.zzpx().zzd(zzabb.zzcrd);
        if (str == null || str.length() == 0) {
            str = (zzexVar == null || (methodZza = zzexVar.zza("TkuK+8ZKbIcxeUe4msY7eeifKf/tICuqqRvwzwQUhsKM0HemvJhBrPQYp0qpvgcE", "eNJuSXkridnHpFkTgNBQFH0ivDH801goaJfT5bONEac=")) == null) ? null : (String) methodZza.invoke(null, new Object[0]);
            if (str == null) {
                return false;
            }
        }
        try {
            zzeah zzeahVarZzl = zzeal.zzl(zzcv.zzb(str, true));
            for (zzefi zzefiVar : zzece.zzhvl.zzbdf()) {
                if (zzefiVar.zzbbt().isEmpty()) {
                    throw new GeneralSecurityException("Missing type_url.");
                }
                if (zzefiVar.zzbcb().isEmpty()) {
                    throw new GeneralSecurityException("Missing primitive_name.");
                }
                if (zzefiVar.zzbce().isEmpty()) {
                    throw new GeneralSecurityException("Missing catalogue_name.");
                }
                if (!zzefiVar.zzbce().equals("TinkAead") && !zzefiVar.zzbce().equals("TinkMac") && !zzefiVar.zzbce().equals("TinkHybridDecrypt") && !zzefiVar.zzbce().equals("TinkHybridEncrypt") && !zzefiVar.zzbce().equals("TinkPublicKeySign") && !zzefiVar.zzbce().equals("TinkPublicKeyVerify") && !zzefiVar.zzbce().equals("TinkStreamingAead") && !zzefiVar.zzbce().equals("TinkDeterministicAead")) {
                    zzdzy<?> zzdzyVarZzhn = zzear.zzhn(zzefiVar.zzbce());
                    zzear.zza(zzdzyVarZzhn.zzayj());
                    zzear.zza(zzdzyVarZzhn.zzb(zzefiVar.zzbbt(), zzefiVar.zzbcb(), zzefiVar.zzbcc()), zzefiVar.zzbcd());
                }
            }
            zzaaa = zzeci.zza(zzeahVarZzl, null);
        } catch (IllegalArgumentException | GeneralSecurityException unused) {
        }
        return zzaaa != null;
    }
}
