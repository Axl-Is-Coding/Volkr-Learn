package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzedd extends zzejz<zzedd, zza> implements zzell {
    private static volatile zzelw<zzedd> zzel;
    private static final zzedd zzhwx;
    private int zzhww;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzedd, zza> implements zzell {
        private zza() {
            super(zzedd.zzhwx);
        }

        /* synthetic */ zza(zzedc zzedcVar) {
            this();
        }
    }

    static {
        zzedd zzeddVar = new zzedd();
        zzhwx = zzeddVar;
        zzejz.zza((Class<zzedd>) zzedd.class, zzeddVar);
    }

    private zzedd() {
    }

    public static zzedd zzazj() {
        return zzhwx;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzedc zzedcVar = null;
        switch (zzedc.zzdv[i - 1]) {
            case 1:
                return new zzedd();
            case 2:
                return new zza(zzedcVar);
            case 3:
                return zzejz.zza(zzhwx, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhww"});
            case 4:
                return zzhwx;
            case 5:
                zzelw<zzedd> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzedd.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhwx);
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

    public final int zzazi() {
        return this.zzhww;
    }
}
