package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzede extends zzejz<zzede, zza> implements zzell {
    private static volatile zzelw<zzede> zzel;
    private static final zzede zzhxa;
    private int zzhwq;
    private zzedi zzhwy;
    private zzeet zzhwz;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzede, zza> implements zzell {
        private zza() {
            super(zzede.zzhxa);
        }

        public final zza zzb(zzedi zzediVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzede) this.zzijh).zza(zzediVar);
            return this;
        }

        public final zza zzet(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzede) this.zzijh).setVersion(i);
            return this;
        }

        /* synthetic */ zza(zzedf zzedfVar) {
            this();
        }

        public final zza zzb(zzeet zzeetVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzede) this.zzijh).zza(zzeetVar);
            return this;
        }
    }

    static {
        zzede zzedeVar = new zzede();
        zzhxa = zzedeVar;
        zzejz.zza((Class<zzede>) zzede.class, zzedeVar);
    }

    private zzede() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzedi zzediVar) {
        zzediVar.getClass();
        this.zzhwy = zzediVar;
    }

    public static zza zzazn() {
        return zzhxa.zzbgf();
    }

    public static zzede zze(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzede) zzejz.zza(zzhxa, zzeipVar, zzejmVar);
    }

    public final int getVersion() {
        return this.zzhwq;
    }

    public final zzedi zzazl() {
        zzedi zzediVar = this.zzhwy;
        return zzediVar == null ? zzedi.zzazu() : zzediVar;
    }

    public final zzeet zzazm() {
        zzeet zzeetVar = this.zzhwz;
        return zzeetVar == null ? zzeet.zzbbm() : zzeetVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzeet zzeetVar) {
        zzeetVar.getClass();
        this.zzhwz = zzeetVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzedf zzedfVar = null;
        switch (zzedf.zzdv[i - 1]) {
            case 1:
                return new zzede();
            case 2:
                return new zza(zzedfVar);
            case 3:
                return zzejz.zza(zzhxa, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzhwq", "zzhwy", "zzhwz"});
            case 4:
                return zzhxa;
            case 5:
                zzelw<zzede> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzede.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxa);
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
