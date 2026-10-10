package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeey extends zzejz<zzeey, zza> implements zzell {
    private static volatile zzelw<zzeey> zzel;
    private static final zzeey zzhzg;
    private int zzhww;
    private int zzhzf;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzeey, zza> implements zzell {
        private zza() {
            super(zzeey.zzhzg);
        }

        /* synthetic */ zza(zzeez zzeezVar) {
            this();
        }
    }

    static {
        zzeey zzeeyVar = new zzeey();
        zzhzg = zzeeyVar;
        zzejz.zza((Class<zzeey>) zzeey.class, zzeeyVar);
    }

    private zzeey() {
    }

    public static zzeey zzbbr() {
        return zzhzg;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzeez zzeezVar = null;
        switch (zzeez.zzdv[i - 1]) {
            case 1:
                return new zzeey();
            case 2:
                return new zza(zzeezVar);
            case 3:
                return zzejz.zza(zzhzg, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzhzf", "zzhww"});
            case 4:
                return zzhzg;
            case 5:
                zzelw<zzeey> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzeey.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhzg);
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

    public final zzeer zzbbq() {
        zzeer zzeerVarZzfc = zzeer.zzfc(this.zzhzf);
        return zzeerVarZzfc == null ? zzeer.UNRECOGNIZED : zzeerVarZzfc;
    }
}
