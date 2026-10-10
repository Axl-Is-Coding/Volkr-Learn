package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzedx extends zzejz<zzedx, zza> implements zzell {
    private static volatile zzelw<zzedx> zzel;
    private static final zzedx zzhxo;
    private int zzhwq;
    private int zzhwu;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzedx, zza> implements zzell {
        private zza() {
            super(zzedx.zzhxo);
        }

        /* synthetic */ zza(zzedw zzedwVar) {
            this();
        }
    }

    static {
        zzedx zzedxVar = new zzedx();
        zzhxo = zzedxVar;
        zzejz.zza((Class<zzedx>) zzedx.class, zzedxVar);
    }

    private zzedx() {
    }

    public static zzedx zzl(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzedx) zzejz.zza(zzhxo, zzeipVar, zzejmVar);
    }

    public final int getKeySize() {
        return this.zzhwu;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzedw zzedwVar = null;
        switch (zzedw.zzdv[i - 1]) {
            case 1:
                return new zzedx();
            case 2:
                return new zza(zzedwVar);
            case 3:
                return zzejz.zza(zzhxo, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzhwu", "zzhwq"});
            case 4:
                return zzhxo;
            case 5:
                zzelw<zzedx> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzedx.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxo);
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
}
