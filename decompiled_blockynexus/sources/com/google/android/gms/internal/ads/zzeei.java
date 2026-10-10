package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeei extends zzejz<zzeei, zza> implements zzell {
    private static volatile zzelw<zzeei> zzel;
    private static final zzeei zzhye;
    private zzeep zzhyb;
    private zzeed zzhyc;
    private int zzhyd;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzeei, zza> implements zzell {
        private zza() {
            super(zzeei.zzhye);
        }

        /* synthetic */ zza(zzeej zzeejVar) {
            this();
        }
    }

    static {
        zzeei zzeeiVar = new zzeei();
        zzhye = zzeeiVar;
        zzejz.zza((Class<zzeei>) zzeei.class, zzeeiVar);
    }

    private zzeei() {
    }

    public static zzeei zzbav() {
        return zzhye;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzeej zzeejVar = null;
        switch (zzeej.zzdv[i - 1]) {
            case 1:
                return new zzeei();
            case 2:
                return new zza(zzeejVar);
            case 3:
                return zzejz.zza(zzhye, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzhyb", "zzhyc", "zzhyd"});
            case 4:
                return zzhye;
            case 5:
                zzelw<zzeei> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzeei.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhye);
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

    public final zzeep zzbas() {
        zzeep zzeepVar = this.zzhyb;
        return zzeepVar == null ? zzeep.zzbbi() : zzeepVar;
    }

    public final zzeed zzbat() {
        zzeed zzeedVar = this.zzhyc;
        return zzeedVar == null ? zzeed.zzbao() : zzeedVar;
    }

    public final zzeec zzbau() {
        zzeec zzeecVarZzey = zzeec.zzey(this.zzhyd);
        return zzeecVarZzey == null ? zzeec.UNRECOGNIZED : zzeecVarZzey;
    }
}
