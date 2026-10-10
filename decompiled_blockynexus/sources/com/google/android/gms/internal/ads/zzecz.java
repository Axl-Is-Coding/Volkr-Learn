package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzecz extends zzejz<zzecz, zza> implements zzell {
    private static volatile zzelw<zzecz> zzel;
    private static final zzecz zzhwt;
    private int zzhwq;
    private zzeip zzhwr = zzeip.zzier;
    private zzedd zzhws;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzecz, zza> implements zzell {
        private zza() {
            super(zzecz.zzhwt);
        }

        public final zza zzd(zzedd zzeddVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzecz) this.zzijh).zzc(zzeddVar);
            return this;
        }

        public final zza zzes(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzecz) this.zzijh).setVersion(0);
            return this;
        }

        public final zza zzt(zzeip zzeipVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzecz) this.zzijh).zzs(zzeipVar);
            return this;
        }

        /* synthetic */ zza(zzecy zzecyVar) {
            this();
        }
    }

    static {
        zzecz zzeczVar = new zzecz();
        zzhwt = zzeczVar;
        zzejz.zza((Class<zzecz>) zzecz.class, zzeczVar);
    }

    private zzecz() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    public static zza zzazf() {
        return zzhwt.zzbgf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzedd zzeddVar) {
        zzeddVar.getClass();
        this.zzhws = zzeddVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzeip zzeipVar) {
        zzeipVar.getClass();
        this.zzhwr = zzeipVar;
    }

    public final int getVersion() {
        return this.zzhwq;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzecy zzecyVar = null;
        switch (zzecy.zzdv[i - 1]) {
            case 1:
                return new zzecz();
            case 2:
                return new zza(zzecyVar);
            case 3:
                return zzejz.zza(zzhwt, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzhwq", "zzhwr", "zzhws"});
            case 4:
                return zzhwt;
            case 5:
                zzelw<zzecz> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzecz.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhwt);
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

    public final zzeip zzazd() {
        return this.zzhwr;
    }

    public final zzedd zzaze() {
        zzedd zzeddVar = this.zzhws;
        return zzeddVar == null ? zzedd.zzazj() : zzeddVar;
    }

    public static zzecz zzc(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzecz) zzejz.zza(zzhwt, zzeipVar, zzejmVar);
    }
}
