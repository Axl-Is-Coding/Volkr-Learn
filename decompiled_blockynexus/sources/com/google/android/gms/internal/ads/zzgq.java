package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgq extends zzejz<zzgq, zza> implements zzell {
    private static final zzgq zzacb;
    private static volatile zzelw<zzgq> zzel;
    private zzgr zzaby;
    private zzeip zzabz;
    private zzeip zzaca;
    private int zzdw;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzgq, zza> implements zzell {
        private zza() {
            super(zzgq.zzacb);
        }

        /* synthetic */ zza(zzgp zzgpVar) {
            this();
        }
    }

    static {
        zzgq zzgqVar = new zzgq();
        zzacb = zzgqVar;
        zzejz.zza((Class<zzgq>) zzgq.class, zzgqVar);
    }

    private zzgq() {
        zzeip zzeipVar = zzeip.zzier;
        this.zzabz = zzeipVar;
        this.zzaca = zzeipVar;
    }

    public static zzgq zza(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzgq) zzejz.zza(zzacb, zzeipVar, zzejmVar);
    }

    public final zzgr zzdc() {
        zzgr zzgrVar = this.zzaby;
        return zzgrVar == null ? zzgr.zzdm() : zzgrVar;
    }

    public final zzeip zzdd() {
        return this.zzabz;
    }

    public final zzeip zzde() {
        return this.zzaca;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzgp zzgpVar = null;
        switch (zzgp.zzdv[i - 1]) {
            case 1:
                return new zzgq();
            case 2:
                return new zza(zzgpVar);
            case 3:
                return zzejz.zza(zzacb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdw", "zzaby", "zzabz", "zzaca"});
            case 4:
                return zzacb;
            case 5:
                zzelw<zzgq> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzgq.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzacb);
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
