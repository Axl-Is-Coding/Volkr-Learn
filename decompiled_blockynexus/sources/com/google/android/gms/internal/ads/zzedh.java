package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzedh extends zzejz<zzedh, zza> implements zzell {
    private static volatile zzelw<zzedh> zzel;
    private static final zzedh zzhxd;
    private zzedl zzhxb;
    private zzeex zzhxc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzedh, zza> implements zzell {
        private zza() {
            super(zzedh.zzhxd);
        }

        /* synthetic */ zza(zzedg zzedgVar) {
            this();
        }
    }

    static {
        zzedh zzedhVar = new zzedh();
        zzhxd = zzedhVar;
        zzejz.zza((Class<zzedh>) zzedh.class, zzedhVar);
    }

    private zzedh() {
    }

    public static zzedh zzf(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzedh) zzejz.zza(zzhxd, zzeipVar, zzejmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzedg zzedgVar = null;
        switch (zzedg.zzdv[i - 1]) {
            case 1:
                return new zzedh();
            case 2:
                return new zza(zzedgVar);
            case 3:
                return zzejz.zza(zzhxd, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzhxb", "zzhxc"});
            case 4:
                return zzhxd;
            case 5:
                zzelw<zzedh> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzedh.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxd);
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

    public final zzedl zzazp() {
        zzedl zzedlVar = this.zzhxb;
        return zzedlVar == null ? zzedl.zzazw() : zzedlVar;
    }

    public final zzeex zzazq() {
        zzeex zzeexVar = this.zzhxc;
        return zzeexVar == null ? zzeex.zzbbo() : zzeexVar;
    }
}
