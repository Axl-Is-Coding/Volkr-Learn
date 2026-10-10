package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzedm extends zzejz<zzedm, zza> implements zzell {
    private static volatile zzelw<zzedm> zzel;
    private static final zzedm zzhxi;
    private int zzhxh;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzedm, zza> implements zzell {
        private zza() {
            super(zzedm.zzhxi);
        }

        /* synthetic */ zza(zzedn zzednVar) {
            this();
        }
    }

    static {
        zzedm zzedmVar = new zzedm();
        zzhxi = zzedmVar;
        zzejz.zza((Class<zzedm>) zzedm.class, zzedmVar);
    }

    private zzedm() {
    }

    public static zzedm zzazz() {
        return zzhxi;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzedn zzednVar = null;
        switch (zzedn.zzdv[i - 1]) {
            case 1:
                return new zzedm();
            case 2:
                return new zza(zzednVar);
            case 3:
                return zzejz.zza(zzhxi, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhxh"});
            case 4:
                return zzhxi;
            case 5:
                zzelw<zzedm> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzedm.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxi);
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
