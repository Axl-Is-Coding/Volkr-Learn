package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeex extends zzejz<zzeex, zza> implements zzell {
    private static volatile zzelw<zzeex> zzel;
    private static final zzeex zzhze;
    private int zzhwq;
    private int zzhwu;
    private zzeey zzhzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzeex, zza> implements zzell {
        private zza() {
            super(zzeex.zzhze);
        }

        /* synthetic */ zza(zzeew zzeewVar) {
            this();
        }
    }

    static {
        zzeex zzeexVar = new zzeex();
        zzhze = zzeexVar;
        zzejz.zza((Class<zzeex>) zzeex.class, zzeexVar);
    }

    private zzeex() {
    }

    public static zzeex zzbbo() {
        return zzhze;
    }

    public static zzeex zzs(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzeex) zzejz.zza(zzhze, zzeipVar, zzejmVar);
    }

    public final int getKeySize() {
        return this.zzhwu;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzeew zzeewVar = null;
        switch (zzeew.zzdv[i - 1]) {
            case 1:
                return new zzeex();
            case 2:
                return new zza(zzeewVar);
            case 3:
                return zzejz.zza(zzhze, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzhzc", "zzhwu", "zzhwq"});
            case 4:
                return zzhze;
            case 5:
                zzelw<zzeex> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzeex.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhze);
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

    public final zzeey zzbbk() {
        zzeey zzeeyVar = this.zzhzc;
        return zzeeyVar == null ? zzeey.zzbbr() : zzeeyVar;
    }
}
