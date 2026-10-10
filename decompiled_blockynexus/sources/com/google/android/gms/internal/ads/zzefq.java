package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzefq extends zzejz<zzefq, zza> implements zzell {
    private static volatile zzelw<zzefq> zzel;
    private static final zzefq zzias;
    private String zziar = "";

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzefq, zza> implements zzell {
        private zza() {
            super(zzefq.zzias);
        }

        /* synthetic */ zza(zzefp zzefpVar) {
            this();
        }
    }

    static {
        zzefq zzefqVar = new zzefq();
        zzias = zzefqVar;
        zzejz.zza((Class<zzefq>) zzefq.class, zzefqVar);
    }

    private zzefq() {
    }

    public static zzefq zzbcw() {
        return zzias;
    }

    public static zzefq zzu(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzefq) zzejz.zza(zzias, zzeipVar, zzejmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzefp zzefpVar = null;
        switch (zzefp.zzdv[i - 1]) {
            case 1:
                return new zzefq();
            case 2:
                return new zza(zzefpVar);
            case 3:
                return zzejz.zza(zzias, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zziar"});
            case 4:
                return zzias;
            case 5:
                zzelw<zzefq> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzefq.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzias);
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

    public final String zzbcv() {
        return this.zziar;
    }
}
