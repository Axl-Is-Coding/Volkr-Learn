package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeda extends zzejz<zzeda, zza> implements zzell {
    private static volatile zzelw<zzeda> zzel;
    private static final zzeda zzhwv;
    private zzedd zzhws;
    private int zzhwu;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzeda, zza> implements zzell {
        private zza() {
            super(zzeda.zzhwv);
        }

        /* synthetic */ zza(zzedb zzedbVar) {
            this();
        }
    }

    static {
        zzeda zzedaVar = new zzeda();
        zzhwv = zzedaVar;
        zzejz.zza((Class<zzeda>) zzeda.class, zzedaVar);
    }

    private zzeda() {
    }

    public static zzeda zzd(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzeda) zzejz.zza(zzhwv, zzeipVar, zzejmVar);
    }

    public final int getKeySize() {
        return this.zzhwu;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzedb zzedbVar = null;
        switch (zzedb.zzdv[i - 1]) {
            case 1:
                return new zzeda();
            case 2:
                return new zza(zzedbVar);
            case 3:
                return zzejz.zza(zzhwv, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhwu", "zzhws"});
            case 4:
                return zzhwv;
            case 5:
                zzelw<zzeda> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzeda.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhwv);
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

    public final zzedd zzaze() {
        zzedd zzeddVar = this.zzhws;
        return zzeddVar == null ? zzedd.zzazj() : zzeddVar;
    }
}
