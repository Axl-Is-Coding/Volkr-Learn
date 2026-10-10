package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzect {

    @Deprecated
    private static final zzefw zzhvl;

    @Deprecated
    private static final zzefw zzhvm;

    @Deprecated
    private static final zzefw zzhvn;
    private static final String zzhwo = new zzecp().getKeyType();

    static {
        zzefw zzefwVarZzbdg = zzefw.zzbdg();
        zzhvl = zzefwVarZzbdg;
        zzhvm = zzefwVarZzbdg;
        zzhvn = zzhvl;
        try {
            zzazb();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void zzazb() throws GeneralSecurityException {
        zzear.zza((zzeag) new zzecp(), true);
        zzear.zza((zzeag) new zzeco(), true);
        zzear.zza(new zzecw());
    }
}
