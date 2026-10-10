package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzedp extends zzejz<zzedp, zza> implements zzell {
    private static volatile zzelw<zzedp> zzel;
    private static final zzedp zzhxk;
    private int zzhwq;
    private zzeip zzhwr = zzeip.zzier;
    private zzedt zzhxj;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzedp, zza> implements zzell {
        private zza() {
            super(zzedp.zzhxk);
        }

        public final zza zzb(zzedt zzedtVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzedp) this.zzijh).zza(zzedtVar);
            return this;
        }

        public final zza zzev(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzedp) this.zzijh).setVersion(0);
            return this;
        }

        public final zza zzv(zzeip zzeipVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzedp) this.zzijh).zzs(zzeipVar);
            return this;
        }

        /* synthetic */ zza(zzedo zzedoVar) {
            this();
        }
    }

    static {
        zzedp zzedpVar = new zzedp();
        zzhxk = zzedpVar;
        zzejz.zza((Class<zzedp>) zzedp.class, zzedpVar);
    }

    private zzedp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzedt zzedtVar) {
        zzedtVar.getClass();
        this.zzhxj = zzedtVar;
    }

    public static zza zzbac() {
        return zzhxk.zzbgf();
    }

    public static zzedp zzi(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzedp) zzejz.zza(zzhxk, zzeipVar, zzejmVar);
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

    public final zzedt zzbab() {
        zzedt zzedtVar = this.zzhxj;
        return zzedtVar == null ? zzedt.zzbaf() : zzedtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzedo zzedoVar = null;
        switch (zzedo.zzdv[i - 1]) {
            case 1:
                return new zzedp();
            case 2:
                return new zza(zzedoVar);
            case 3:
                return zzejz.zza(zzhxk, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhwq", "zzhxj", "zzhwr"});
            case 4:
                return zzhxk;
            case 5:
                zzelw<zzedp> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzedp.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxk);
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
