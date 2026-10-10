package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzedi extends zzejz<zzedi, zza> implements zzell {
    private static volatile zzelw<zzedi> zzel;
    private static final zzedi zzhxf;
    private int zzhwq;
    private zzeip zzhwr = zzeip.zzier;
    private zzedm zzhxe;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzedi, zza> implements zzell {
        private zza() {
            super(zzedi.zzhxf);
        }

        public final zza zzc(zzedm zzedmVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzedi) this.zzijh).zzb(zzedmVar);
            return this;
        }

        public final zza zzeu(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzedi) this.zzijh).setVersion(0);
            return this;
        }

        public final zza zzu(zzeip zzeipVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzedi) this.zzijh).zzs(zzeipVar);
            return this;
        }

        /* synthetic */ zza(zzedj zzedjVar) {
            this();
        }
    }

    static {
        zzedi zzediVar = new zzedi();
        zzhxf = zzediVar;
        zzejz.zza((Class<zzedi>) zzedi.class, zzediVar);
    }

    private zzedi() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhwq = i;
    }

    public static zza zzazt() {
        return zzhxf.zzbgf();
    }

    public static zzedi zzazu() {
        return zzhxf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzedm zzedmVar) {
        zzedmVar.getClass();
        this.zzhxe = zzedmVar;
    }

    public static zzedi zzg(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzedi) zzejz.zza(zzhxf, zzeipVar, zzejmVar);
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
        zzedj zzedjVar = null;
        switch (zzedj.zzdv[i - 1]) {
            case 1:
                return new zzedi();
            case 2:
                return new zza(zzedjVar);
            case 3:
                return zzejz.zza(zzhxf, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhwq", "zzhxe", "zzhwr"});
            case 4:
                return zzhxf;
            case 5:
                zzelw<zzedi> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzedi.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxf);
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

    public final zzedm zzazs() {
        zzedm zzedmVar = this.zzhxe;
        return zzedmVar == null ? zzedm.zzazz() : zzedmVar;
    }
}
