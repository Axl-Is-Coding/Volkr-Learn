package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzefe extends zzejz<zzefe, zza> implements zzell {
    private static volatile zzelw<zzefe> zzel;
    private static final zzefe zzhzz;
    private String zzhzh = "";
    private zzeip zzhzi = zzeip.zzier;
    private int zzhzy;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzefe, zza> implements zzell {
        private zza() {
            super(zzefe.zzhzz);
        }

        /* synthetic */ zza(zzefg zzefgVar) {
            this();
        }
    }

    static {
        zzefe zzefeVar = new zzefe();
        zzhzz = zzefeVar;
        zzejz.zza((Class<zzefe>) zzefe.class, zzefeVar);
    }

    private zzefe() {
    }

    public static zzefe zzbbz() {
        return zzhzz;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzefg zzefgVar = null;
        switch (zzefg.zzdv[i - 1]) {
            case 1:
                return new zzefe();
            case 2:
                return new zza(zzefgVar);
            case 3:
                return zzejz.zza(zzhzz, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzhzh", "zzhzi", "zzhzy"});
            case 4:
                return zzhzz;
            case 5:
                zzelw<zzefe> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzefe.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhzz);
                            zzel = zzaVar;
                        }
                        break;
                    }
                }
                return zzaVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final String zzbbt() {
        return this.zzhzh;
    }

    public final zzeip zzbbu() {
        return this.zzhzi;
    }
}
