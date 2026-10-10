package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgr extends zzejz<zzgr, zza> implements zzell {
    private static final zzgr zzach;
    private static volatile zzelw<zzgr> zzel;
    private String zzacc = "";
    private String zzacd = "";
    private long zzace;
    private long zzacf;
    private long zzacg;
    private int zzdw;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzgr, zza> implements zzell {
        private zza() {
            super(zzgr.zzach);
        }

        public final zza zzaw(String str) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzgr) this.zzijh).zzau(str);
            return this;
        }

        public final zza zzax(String str) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzgr) this.zzijh).zzav(str);
            return this;
        }

        public final zza zzdj(long j) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzgr) this.zzijh).zzdg(j);
            return this;
        }

        public final zza zzdk(long j) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzgr) this.zzijh).zzdh(j);
            return this;
        }

        public final zza zzdl(long j) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzgr) this.zzijh).zzdi(j);
            return this;
        }

        /* synthetic */ zza(zzgs zzgsVar) {
            this();
        }
    }

    static {
        zzgr zzgrVar = new zzgr();
        zzach = zzgrVar;
        zzejz.zza((Class<zzgr>) zzgr.class, zzgrVar);
    }

    private zzgr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzau(String str) {
        str.getClass();
        this.zzdw |= 1;
        this.zzacc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzav(String str) {
        str.getClass();
        this.zzdw |= 2;
        this.zzacd = str;
    }

    public static zzgr zzb(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzgr) zzejz.zza(zzach, zzeipVar, zzejmVar);
    }

    public static zza zzdl() {
        return zzach.zzbgf();
    }

    public static zzgr zzdm() {
        return zzach;
    }

    public static zzgr zzl(zzeip zzeipVar) throws zzekj {
        return (zzgr) zzejz.zza(zzach, zzeipVar);
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzgs zzgsVar = null;
        switch (zzgs.zzdv[i - 1]) {
            case 1:
                return new zzgr();
            case 2:
                return new zza(zzgsVar);
            case 3:
                return zzejz.zza(zzach, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzdw", "zzacc", "zzacd", "zzace", "zzacf", "zzacg"});
            case 4:
                return zzach;
            case 5:
                zzelw<zzgr> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzgr.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzach);
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

    public final String zzdg() {
        return this.zzacc;
    }

    public final String zzdh() {
        return this.zzacd;
    }

    public final long zzdi() {
        return this.zzace;
    }

    public final long zzdj() {
        return this.zzacf;
    }

    public final long zzdk() {
        return this.zzacg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdg(long j) {
        this.zzdw |= 4;
        this.zzace = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdh(long j) {
        this.zzdw |= 8;
        this.zzacf = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdi(long j) {
        this.zzdw |= 16;
        this.zzacg = j;
    }
}
