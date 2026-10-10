package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdty extends zzejz<zzdty, zzb> implements zzell {
    private static volatile zzelw<zzdty> zzel;
    private static final zzeki<Integer, zza> zzhmz = new zzdtx();
    private static final zzdty zzhnd;
    private int zzdw;
    private zzekf zzhmy = zzejz.zzbgi();
    private String zzhna = "";
    private String zzhnb = "";
    private String zzhnc = "";

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public enum zza implements zzeke {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);

        private static final zzekd<zza> zzes = new zzdub();
        private final int value;

        zza(int i) {
            this.value = i;
        }

        public static zza zzeg(int i) {
            if (i == 1) {
                return BLOCKED_REASON_UNKNOWN;
            }
            if (i != 2) {
                return null;
            }
            return BLOCKED_REASON_BACKGROUND;
        }

        public static zzekg zzw() {
            return zzdua.zzeu;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.ads.zzeke
        public final int zzv() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zzb extends zzejz.zzb<zzdty, zzb> implements zzell {
        private zzb() {
            super(zzdty.zzhnd);
        }

        public final zzb zzb(zza zzaVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzdty) this.zzijh).zza(zzaVar);
            return this;
        }

        public final zzb zzhe(String str) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzdty) this.zzijh).zzhd(str);
            return this;
        }

        /* synthetic */ zzb(zzdtx zzdtxVar) {
            this();
        }
    }

    static {
        zzdty zzdtyVar = new zzdty();
        zzhnd = zzdtyVar;
        zzejz.zza((Class<zzdty>) zzdty.class, zzdtyVar);
    }

    private zzdty() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        zzaVar.getClass();
        zzekf zzekfVar = this.zzhmy;
        if (!zzekfVar.zzbeb()) {
            this.zzhmy = zzejz.zza(zzekfVar);
        }
        this.zzhmy.zzhc(zzaVar.zzv());
    }

    public static zzb zzawf() {
        return zzhnd.zzbgf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzhd(String str) {
        str.getClass();
        this.zzdw |= 1;
        this.zzhna = str;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzdtx zzdtxVar = null;
        switch (zzdtz.zzdv[i - 1]) {
            case 1:
                return new zzdty();
            case 2:
                return new zzb(zzdtxVar);
            case 3:
                return zzejz.zza(zzhnd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzdw", "zzhmy", zza.zzw(), "zzhna", "zzhnb", "zzhnc"});
            case 4:
                return zzhnd;
            case 5:
                zzelw<zzdty> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzdty.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhnd);
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
