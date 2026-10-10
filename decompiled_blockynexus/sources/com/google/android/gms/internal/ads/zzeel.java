package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeel extends zzejz<zzeel, zza> implements zzell {
    private static volatile zzelw<zzeel> zzel;
    private static final zzeel zzhyg;
    private int zzhwq;
    private zzeip zzhwr = zzeip.zzier;
    private zzeem zzhyf;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzeel, zza> implements zzell {
        private zza() {
            super(zzeel.zzhyg);
        }

        public final zza zzaa(zzeip zzeipVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzeel) this.zzijh).zzs(zzeipVar);
            return this;
        }

        public final zza zzb(zzeem zzeemVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzeel) this.zzijh).zza(zzeemVar);
            return this;
        }

        public final zza zzez(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzeel) this.zzijh).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzeek zzeekVar) {
            this();
        }
    }

    static {
        zzeel zzeelVar = new zzeel();
        zzhyg = zzeelVar;
        zzejz.zza((Class<zzeel>) zzeel.class, zzeelVar);
    }

    private zzeel() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzeem zzeemVar) {
        zzeemVar.getClass();
        this.zzhyf = zzeemVar;
    }

    public static zza zzbay() {
        return zzhyg.zzbgf();
    }

    public static zzeel zzp(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzeel) zzejz.zza(zzhyg, zzeipVar, zzejmVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzeip zzeipVar) {
        zzeipVar.getClass();
        this.zzhwr = zzeipVar;
    }

    public final int getVersion() {
        return this.zzhwq;
    }

    public final zzeip zzazd() {
        return this.zzhwr;
    }

    public final zzeem zzbax() {
        zzeem zzeemVar = this.zzhyf;
        return zzeemVar == null ? zzeem.zzbbd() : zzeemVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzeek zzeekVar = null;
        switch (zzeek.zzdv[i - 1]) {
            case 1:
                return new zzeel();
            case 2:
                return new zza(zzeekVar);
            case 3:
                return zzejz.zza(zzhyg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhwq", "zzhyf", "zzhwr"});
            case 4:
                return zzhyg;
            case 5:
                zzelw<zzeel> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzeel.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhyg);
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
