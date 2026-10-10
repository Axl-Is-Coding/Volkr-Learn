package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzedu extends zzejz<zzedu, zza> implements zzell {
    private static volatile zzelw<zzedu> zzel;
    private static final zzedu zzhxn;
    private int zzhwq;
    private zzeip zzhwr = zzeip.zzier;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzedu, zza> implements zzell {
        private zza() {
            super(zzedu.zzhxn);
        }

        public final zza zzew(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzedu) this.zzijh).setVersion(0);
            return this;
        }

        public final zza zzw(zzeip zzeipVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzedu) this.zzijh).zzs(zzeipVar);
            return this;
        }

        /* synthetic */ zza(zzedv zzedvVar) {
            this();
        }
    }

    static {
        zzedu zzeduVar = new zzedu();
        zzhxn = zzeduVar;
        zzejz.zza((Class<zzedu>) zzedu.class, zzeduVar);
    }

    private zzedu() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    public static zza zzbah() {
        return zzhxn.zzbgf();
    }

    public static zzedu zzk(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzedu) zzejz.zza(zzhxn, zzeipVar, zzejmVar);
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
        zzedv zzedvVar = null;
        switch (zzedv.zzdv[i - 1]) {
            case 1:
                return new zzedu();
            case 2:
                return new zza(zzedvVar);
            case 3:
                return zzejz.zza(zzhxn, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzhwq", "zzhwr"});
            case 4:
                return zzhxn;
            case 5:
                zzelw<zzedu> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzedu.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxn);
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
}
