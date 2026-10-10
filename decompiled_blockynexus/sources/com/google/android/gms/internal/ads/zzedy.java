package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzedy extends zzejz<zzedy, zza> implements zzell {
    private static volatile zzelw<zzedy> zzel;
    private static final zzedy zzhxp;
    private int zzhwq;
    private zzeip zzhwr = zzeip.zzier;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzedy, zza> implements zzell {
        private zza() {
            super(zzedy.zzhxp);
        }

        public final zza zzex(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzedy) this.zzijh).setVersion(0);
            return this;
        }

        public final zza zzx(zzeip zzeipVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzedy) this.zzijh).zzs(zzeipVar);
            return this;
        }

        /* synthetic */ zza(zzedz zzedzVar) {
            this();
        }
    }

    static {
        zzedy zzedyVar = new zzedy();
        zzhxp = zzedyVar;
        zzejz.zza((Class<zzedy>) zzedy.class, zzedyVar);
    }

    private zzedy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    public static zza zzbak() {
        return zzhxp.zzbgf();
    }

    public static zzedy zzm(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzedy) zzejz.zza(zzhxp, zzeipVar, zzejmVar);
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
        zzedz zzedzVar = null;
        switch (zzedz.zzdv[i - 1]) {
            case 1:
                return new zzedy();
            case 2:
                return new zza(zzedzVar);
            case 3:
                return zzejz.zza(zzhxp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzhwq", "zzhwr"});
            case 4:
                return zzhxp;
            case 5:
                zzelw<zzedy> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzedy.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxp);
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
