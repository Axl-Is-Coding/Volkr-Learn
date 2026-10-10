package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeet extends zzejz<zzeet, zza> implements zzell {
    private static volatile zzelw<zzeet> zzel;
    private static final zzeet zzhzd;
    private int zzhwq;
    private zzeip zzhwr = zzeip.zzier;
    private zzeey zzhzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzeet, zza> implements zzell {
        private zza() {
            super(zzeet.zzhzd);
        }

        public final zza zzad(zzeip zzeipVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzeet) this.zzijh).zzs(zzeipVar);
            return this;
        }

        public final zza zzd(zzeey zzeeyVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzeet) this.zzijh).zzc(zzeeyVar);
            return this;
        }

        public final zza zzfd(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzeet) this.zzijh).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzeev zzeevVar) {
            this();
        }
    }

    static {
        zzeet zzeetVar = new zzeet();
        zzhzd = zzeetVar;
        zzejz.zza((Class<zzeet>) zzeet.class, zzeetVar);
    }

    private zzeet() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    public static zza zzbbl() {
        return zzhzd.zzbgf();
    }

    public static zzeet zzbbm() {
        return zzhzd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzeey zzeeyVar) {
        zzeeyVar.getClass();
        this.zzhzc = zzeeyVar;
    }

    public static zzeet zzr(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzeet) zzejz.zza(zzhzd, zzeipVar, zzejmVar);
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
        zzeev zzeevVar = null;
        switch (zzeev.zzdv[i - 1]) {
            case 1:
                return new zzeet();
            case 2:
                return new zza(zzeevVar);
            case 3:
                return zzejz.zza(zzhzd, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhwq", "zzhzc", "zzhwr"});
            case 4:
                return zzhzd;
            case 5:
                zzelw<zzeet> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzeet.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhzd);
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

    public final zzeey zzbbk() {
        zzeey zzeeyVar = this.zzhzc;
        return zzeeyVar == null ? zzeey.zzbbr() : zzeeyVar;
    }
}
