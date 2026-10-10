package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeep extends zzejz<zzeep, zza> implements zzell {
    private static volatile zzelw<zzeep> zzel;
    private static final zzeep zzhyn;
    private int zzhyk;
    private int zzhyl;
    private zzeip zzhym = zzeip.zzier;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzeep, zza> implements zzell {
        private zza() {
            super(zzeep.zzhyn);
        }

        /* synthetic */ zza(zzeeo zzeeoVar) {
            this();
        }
    }

    static {
        zzeep zzeepVar = new zzeep();
        zzhyn = zzeepVar;
        zzejz.zza((Class<zzeep>) zzeep.class, zzeepVar);
    }

    private zzeep() {
    }

    public static zzeep zzbbi() {
        return zzhyn;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzeeo zzeeoVar = null;
        switch (zzeeo.zzdv[i - 1]) {
            case 1:
                return new zzeep();
            case 2:
                return new zza(zzeeoVar);
            case 3:
                return zzejz.zza(zzhyn, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzhyk", "zzhyl", "zzhym"});
            case 4:
                return zzhyn;
            case 5:
                zzelw<zzeep> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzeep.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhyn);
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

    public final zzeeq zzbbf() {
        zzeeq zzeeqVarZzfb = zzeeq.zzfb(this.zzhyk);
        return zzeeqVarZzfb == null ? zzeeq.UNRECOGNIZED : zzeeqVarZzfb;
    }

    public final zzeer zzbbg() {
        zzeer zzeerVarZzfc = zzeer.zzfc(this.zzhyl);
        return zzeerVarZzfc == null ? zzeer.UNRECOGNIZED : zzeerVarZzfc;
    }

    public final zzeip zzbbh() {
        return this.zzhym;
    }
}
