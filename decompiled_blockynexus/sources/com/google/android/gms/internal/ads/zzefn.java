package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzefn extends zzejz<zzefn, zza> implements zzell {
    private static volatile zzelw<zzefn> zzel;
    private static final zzefn zziaq;
    private int zzhwq;
    private zzefq zziap;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzefn, zza> implements zzell {
        private zza() {
            super(zzefn.zziaq);
        }

        public final zza zzb(zzefq zzefqVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzefn) this.zzijh).zza(zzefqVar);
            return this;
        }

        public final zza zzfk(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzefn) this.zzijh).setVersion(0);
            return this;
        }

        /* synthetic */ zza(zzefo zzefoVar) {
            this();
        }
    }

    static {
        zzefn zzefnVar = new zzefn();
        zziaq = zzefnVar;
        zzejz.zza((Class<zzefn>) zzefn.class, zzefnVar);
    }

    private zzefn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzefq zzefqVar) {
        zzefqVar.getClass();
        this.zziap = zzefqVar;
    }

    public static zza zzbct() {
        return zziaq.zzbgf();
    }

    public static zzefn zzt(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzefn) zzejz.zza(zziaq, zzeipVar, zzejmVar);
    }

    public final int getVersion() {
        return this.zzhwq;
    }

    public final zzefq zzbcs() {
        zzefq zzefqVar = this.zziap;
        return zzefqVar == null ? zzefq.zzbcw() : zzefqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzefo zzefoVar = null;
        switch (zzefo.zzdv[i - 1]) {
            case 1:
                return new zzefn();
            case 2:
                return new zza(zzefoVar);
            case 3:
                return zzejz.zza(zziaq, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhwq", "zziap"});
            case 4:
                return zziaq;
            case 5:
                zzelw<zzefn> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzefn.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zziaq);
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
