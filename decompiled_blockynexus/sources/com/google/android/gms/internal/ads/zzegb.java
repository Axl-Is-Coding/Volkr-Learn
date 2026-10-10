package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzegb extends zzejz<zzegb, zza> implements zzell {
    private static volatile zzelw<zzegb> zzel;
    private static final zzegb zzibj;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzegb, zza> implements zzell {
        private zza() {
            super(zzegb.zzibj);
        }

        /* synthetic */ zza(zzegc zzegcVar) {
            this();
        }
    }

    static {
        zzegb zzegbVar = new zzegb();
        zzibj = zzegbVar;
        zzejz.zza((Class<zzegb>) zzegb.class, zzegbVar);
    }

    private zzegb() {
    }

    public static zzegb zzy(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzegb) zzejz.zza(zzibj, zzeipVar, zzejmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzegc zzegcVar = null;
        switch (zzegc.zzdv[i - 1]) {
            case 1:
                return new zzegb();
            case 2:
                return new zza(zzegcVar);
            case 3:
                return zzejz.zza(zzibj, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzibj;
            case 5:
                zzelw<zzegb> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzegb.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzibj);
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
