package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeeh extends zzejz<zzeeh, zza> implements zzell {
    private static volatile zzelw<zzeeh> zzel;
    private static final zzeeh zzhya;
    private zzeei zzhxz;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzeeh, zza> implements zzell {
        private zza() {
            super(zzeeh.zzhya);
        }

        /* synthetic */ zza(zzeeg zzeegVar) {
            this();
        }
    }

    static {
        zzeeh zzeehVar = new zzeeh();
        zzhya = zzeehVar;
        zzejz.zza((Class<zzeeh>) zzeeh.class, zzeehVar);
    }

    private zzeeh() {
    }

    public static zzeeh zzo(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzeeh) zzejz.zza(zzhya, zzeipVar, zzejmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzeeg zzeegVar = null;
        switch (zzeeg.zzdv[i - 1]) {
            case 1:
                return new zzeeh();
            case 2:
                return new zza(zzeegVar);
            case 3:
                return zzejz.zza(zzhya, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzhxz"});
            case 4:
                return zzhya;
            case 5:
                zzelw<zzeeh> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzeeh.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhya);
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

    public final zzeei zzbaq() {
        zzeei zzeeiVar = this.zzhxz;
        return zzeeiVar == null ? zzeei.zzbav() : zzeeiVar;
    }
}
