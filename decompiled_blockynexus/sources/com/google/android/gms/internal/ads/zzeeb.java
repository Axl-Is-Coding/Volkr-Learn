package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeeb extends zzejz<zzeeb, zza> implements zzell {
    private static volatile zzelw<zzeeb> zzel;
    private static final zzeeb zzhxq;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzeeb, zza> implements zzell {
        private zza() {
            super(zzeeb.zzhxq);
        }

        /* synthetic */ zza(zzeea zzeeaVar) {
            this();
        }
    }

    static {
        zzeeb zzeebVar = new zzeeb();
        zzhxq = zzeebVar;
        zzejz.zza((Class<zzeeb>) zzeeb.class, zzeebVar);
    }

    private zzeeb() {
    }

    public static zzeeb zzn(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzeeb) zzejz.zza(zzhxq, zzeipVar, zzejmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzeea zzeeaVar = null;
        switch (zzeea.zzdv[i - 1]) {
            case 1:
                return new zzeeb();
            case 2:
                return new zza(zzeeaVar);
            case 3:
                return zzejz.zza(zzhxq, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzhxq;
            case 5:
                zzelw<zzeeb> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzeeb.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxq);
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
