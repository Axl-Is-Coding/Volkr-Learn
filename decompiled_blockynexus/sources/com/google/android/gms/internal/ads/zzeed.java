package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeed extends zzejz<zzeed, zza> implements zzell {
    private static volatile zzelw<zzeed> zzel;
    private static final zzeed zzhxy;
    private zzefe zzhxx;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzeed, zza> implements zzell {
        private zza() {
            super(zzeed.zzhxy);
        }

        /* synthetic */ zza(zzeef zzeefVar) {
            this();
        }
    }

    static {
        zzeed zzeedVar = new zzeed();
        zzhxy = zzeedVar;
        zzejz.zza((Class<zzeed>) zzeed.class, zzeedVar);
    }

    private zzeed() {
    }

    public static zzeed zzbao() {
        return zzhxy;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzeef zzeefVar = null;
        switch (zzeef.zzdv[i - 1]) {
            case 1:
                return new zzeed();
            case 2:
                return new zza(zzeefVar);
            case 3:
                return zzejz.zza(zzhxy, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzhxx"});
            case 4:
                return zzhxy;
            case 5:
                zzelw<zzeed> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzeed.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxy);
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

    public final zzefe zzban() {
        zzefe zzefeVar = this.zzhxx;
        return zzefeVar == null ? zzefe.zzbbz() : zzefeVar;
    }
}
