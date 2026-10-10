package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzefr extends zzejz<zzefr, zza> implements zzell {
    private static volatile zzelw<zzefr> zzel;
    private static final zzefr zziau;
    private int zzhwq;
    private zzefu zziat;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzefr, zza> implements zzell {
        private zza() {
            super(zzefr.zziau);
        }

        public final zza zzb(zzefu zzefuVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzefr) this.zzijh).zza(zzefuVar);
            return this;
        }

        public final zza zzfl(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzefr) this.zzijh).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzefs zzefsVar) {
            this();
        }
    }

    static {
        zzefr zzefrVar = new zzefr();
        zziau = zzefrVar;
        zzejz.zza((Class<zzefr>) zzefr.class, zzefrVar);
    }

    private zzefr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzefu zzefuVar) {
        zzefuVar.getClass();
        this.zziat = zzefuVar;
    }

    public static zza zzbcz() {
        return zziau.zzbgf();
    }

    public static zzefr zzv(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzefr) zzejz.zza(zziau, zzeipVar, zzejmVar);
    }

    public final int getVersion() {
        return this.zzhwq;
    }

    public final zzefu zzbcy() {
        zzefu zzefuVar = this.zziat;
        return zzefuVar == null ? zzefu.zzbdd() : zzefuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzefs zzefsVar = null;
        switch (zzefs.zzdv[i - 1]) {
            case 1:
                return new zzefr();
            case 2:
                return new zza(zzefsVar);
            case 3:
                return zzejz.zza(zziau, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhwq", "zziat"});
            case 4:
                return zziau;
            case 5:
                zzelw<zzefr> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzefr.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zziau);
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
