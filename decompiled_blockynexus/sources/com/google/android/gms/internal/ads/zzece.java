package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzece {
    private static final String zzhwc = new zzecc().getKeyType();
    private static final String zzhwd = new zzecb().getKeyType();

    @Deprecated
    public static final zzefw zzhvl = zzefw.zzbdg();

    @Deprecated
    private static final zzefw zzhvm = zzefw.zzbdg();

    @Deprecated
    private static final zzefw zzhvn = zzefw.zzbdg();

    static {
        try {
            zzeax.zzazb();
            zzear.zza((zzeas) new zzecb(), (zzeag) new zzecc(), true);
            zzear.zza(new zzecg());
            zzear.zza(new zzech());
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
