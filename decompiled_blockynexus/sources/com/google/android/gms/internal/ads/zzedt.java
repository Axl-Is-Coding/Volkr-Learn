package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzedt extends zzejz<zzedt, zza> implements zzell {
    private static volatile zzelw<zzedt> zzel;
    private static final zzedt zzhxm;
    private int zzhxh;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzedt, zza> implements zzell {
        private zza() {
            super(zzedt.zzhxm);
        }

        /* synthetic */ zza(zzeds zzedsVar) {
            this();
        }
    }

    static {
        zzedt zzedtVar = new zzedt();
        zzhxm = zzedtVar;
        zzejz.zza((Class<zzedt>) zzedt.class, zzedtVar);
    }

    private zzedt() {
    }

    public static zzedt zzbaf() {
        return zzhxm;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzeds zzedsVar = null;
        switch (zzeds.zzdv[i - 1]) {
            case 1:
                return new zzedt();
            case 2:
                return new zza(zzedsVar);
            case 3:
                return zzejz.zza(zzhxm, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhxh"});
            case 4:
                return zzhxm;
            case 5:
                zzelw<zzedt> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzedt.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxm);
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

    public final int zzazy() {
        return this.zzhxh;
    }
}
