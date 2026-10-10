package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzega extends zzejz<zzega, zza> implements zzell {
    private static volatile zzelw<zzega> zzel;
    private static final zzega zzibi;
    private int zzhwq;
    private zzeip zzhwr = zzeip.zzier;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzega, zza> implements zzell {
        private zza() {
            super(zzega.zzibi);
        }

        public final zza zzag(zzeip zzeipVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzega) this.zzijh).zzs(zzeipVar);
            return this;
        }

        public final zza zzfn(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzega) this.zzijh).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzefz zzefzVar) {
            this();
        }
    }

    static {
        zzega zzegaVar = new zzega();
        zzibi = zzegaVar;
        zzejz.zza((Class<zzega>) zzega.class, zzegaVar);
    }

    private zzega() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    public static zza zzbdi() {
        return zzibi.zzbgf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzeip zzeipVar) {
        zzeipVar.getClass();
        this.zzhwr = zzeipVar;
    }

    public static zzega zzx(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzega) zzejz.zza(zzibi, zzeipVar, zzejmVar);
    }

    public final int getVersion() {
        return this.zzhwq;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzefz zzefzVar = null;
        switch (zzefz.zzdv[i - 1]) {
            case 1:
                return new zzega();
            case 2:
                return new zza(zzefzVar);
            case 3:
                return zzejz.zza(zzibi, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzhwq", "zzhwr"});
            case 4:
                return zzibi;
            case 5:
                zzelw<zzega> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzega.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzibi);
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
