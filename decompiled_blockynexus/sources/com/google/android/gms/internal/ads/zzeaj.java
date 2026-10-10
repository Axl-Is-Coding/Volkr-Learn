package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeaj {
    private static final CopyOnWriteArrayList<zzeak> zzhuj = new CopyOnWriteArrayList<>();

    public static zzeak zzhj(String str) throws GeneralSecurityException {
        for (zzeak zzeakVar : zzhuj) {
            if (zzeakVar.zzhk(str)) {
                return zzeakVar;
            }
        }
        String strValueOf = String.valueOf(str);
        throw new GeneralSecurityException(strValueOf.length() != 0 ? "No KMS client does support: ".concat(strValueOf) : new String("No KMS client does support: "));
    }
}
