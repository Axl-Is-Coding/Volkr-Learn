package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeem extends zzejz<zzeem, zza> implements zzell {
    private static volatile zzelw<zzeem> zzel;
    private static final zzeem zzhyj;
    private int zzhwq;
    private zzeei zzhxz;
    private zzeip zzhyh;
    private zzeip zzhyi;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzeem, zza> implements zzell {
        private zza() {
            super(zzeem.zzhyj);
        }

        public final zza zzab(zzeip zzeipVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzeem) this.zzijh).zzy(zzeipVar);
            return this;
        }

        public final zza zzac(zzeip zzeipVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzeem) this.zzijh).zzz(zzeipVar);
            return this;
        }

        public final zza zzc(zzeei zzeeiVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzeem) this.zzijh).zzb(zzeeiVar);
            return this;
        }

        public final zza zzfa(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzeem) this.zzijh).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzeen zzeenVar) {
            this();
        }
    }

    static {
        zzeem zzeemVar = new zzeem();
        zzhyj = zzeemVar;
        zzejz.zza((Class<zzeem>) zzeem.class, zzeemVar);
    }

    private zzeem() {
        zzeip zzeipVar = zzeip.zzier;
        this.zzhyh = zzeipVar;
        this.zzhyi = zzeipVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzeei zzeeiVar) {
        zzeeiVar.getClass();
        this.zzhxz = zzeeiVar;
    }

    public static zza zzbbc() {
        return zzhyj.zzbgf();
    }

    public static zzeem zzbbd() {
        return zzhyj;
    }

    public static zzeem zzq(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzeem) zzejz.zza(zzhyj, zzeipVar, zzejmVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzy(zzeip zzeipVar) {
        zzeipVar.getClass();
        this.zzhyh = zzeipVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzz(zzeip zzeipVar) {
        zzeipVar.getClass();
        this.zzhyi = zzeipVar;
    }

    public final int getVersion() {
        return this.zzhwq;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzeen zzeenVar = null;
        switch (zzeen.zzdv[i - 1]) {
            case 1:
                return new zzeem();
            case 2:
                return new zza(zzeenVar);
            case 3:
                return zzejz.zza(zzhyj, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzhwq", "zzhxz", "zzhyh", "zzhyi"});
            case 4:
                return zzhyj;
            case 5:
                zzelw<zzeem> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzeem.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhyj);
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

    public final zzeip zzbba() {
        return this.zzhyh;
    }

    public final zzeip zzbbb() {
        return this.zzhyi;
    }
}
