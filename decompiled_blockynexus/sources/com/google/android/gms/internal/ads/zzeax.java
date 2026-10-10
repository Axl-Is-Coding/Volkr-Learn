package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeax {
    public static final String zzhve = new zzebb().getKeyType();
    public static final String zzhvf = new zzebl().getKeyType();
    private static final String zzhvg = new zzebg().getKeyType();
    private static final String zzhvh = new zzebr().getKeyType();
    private static final String zzhvi = new zzebv().getKeyType();
    private static final String zzhvj = new zzebm().getKeyType();
    private static final String zzhvk = new zzebw().getKeyType();

    @Deprecated
    private static final zzefw zzhvl;

    @Deprecated
    private static final zzefw zzhvm;

    @Deprecated
    private static final zzefw zzhvn;

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
        zzect.zzazb();
        zzear.zza((zzeag) new zzebb(), true);
        zzear.zza((zzeag) new zzebg(), true);
        zzear.zza((zzeag) new zzebl(), true);
        zzear.zza((zzeag) new zzebm(), true);
        zzear.zza((zzeag) new zzebr(), true);
        zzear.zza((zzeag) new zzebv(), true);
        zzear.zza((zzeag) new zzebw(), true);
        zzear.zza(new zzeba());
    }
}
