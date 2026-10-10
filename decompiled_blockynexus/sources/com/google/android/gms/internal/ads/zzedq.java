package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzedq extends zzejz<zzedq, zza> implements zzell {
    private static volatile zzelw<zzedq> zzel;
    private static final zzedq zzhxl;
    private int zzhwu;
    private zzedt zzhxj;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzedq, zza> implements zzell {
        private zza() {
            super(zzedq.zzhxl);
        }

        /* synthetic */ zza(zzedr zzedrVar) {
            this();
        }
    }

    static {
        zzedq zzedqVar = new zzedq();
        zzhxl = zzedqVar;
        zzejz.zza((Class<zzedq>) zzedq.class, zzedqVar);
    }

    private zzedq() {
    }

    public static zzedq zzj(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzedq) zzejz.zza(zzhxl, zzeipVar, zzejmVar);
    }

    public final int getKeySize() {
        return this.zzhwu;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzedr zzedrVar = null;
        switch (zzedr.zzdv[i - 1]) {
            case 1:
                return new zzedq();
            case 2:
                return new zza(zzedrVar);
            case 3:
                return zzejz.zza(zzhxl, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzhxj", "zzhwu"});
            case 4:
                return zzhxl;
            case 5:
                zzelw<zzedq> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzedq.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxl);
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

    public final zzedt zzbab() {
        zzedt zzedtVar = this.zzhxj;
        return zzedtVar == null ? zzedt.zzbaf() : zzedtVar;
    }
}
