package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdty;
import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzduc extends zzejz<zzduc, zza> implements zzell {
    private static volatile zzelw<zzduc> zzel;
    private static final zzduc zzhnk;
    private int zzdw;
    private int zzhnh;
    private zzdty zzhnj;
    private String zzdx = "";
    private String zzhni = "";

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzduc, zza> implements zzell {
        private zza() {
            super(zzduc.zzhnk);
        }

        public final zza zza(zzdty.zzb zzbVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzduc) this.zzijh).zza((zzdty) zzbVar.zzbgt());
            return this;
        }

        public final zza zzb(zzb zzbVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzduc) this.zzijh).zza(zzbVar);
            return this;
        }

        public final zza zzhf(String str) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzduc) this.zzijh).zzp(str);
            return this;
        }

        /* synthetic */ zza(zzdud zzdudVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public enum zzb implements zzeke {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);

        private static final zzekd<zzb> zzes = new zzdue();
        private final int value;

        zzb(int i) {
            this.value = i;
        }

        public static zzb zzeh(int i) {
            if (i == 0) {
                return EVENT_TYPE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return BLOCKED_IMPRESSION;
        }

        public static zzekg zzw() {
            return zzdug.zzeu;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.ads.zzeke
        public final int zzv() {
            return this.value;
        }
    }

    static {
        zzduc zzducVar = new zzduc();
        zzhnk = zzducVar;
        zzejz.zza((Class<zzduc>) zzduc.class, zzducVar);
    }

    private zzduc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzb zzbVar) {
        this.zzhnh = zzbVar.zzv();
        this.zzdw |= 1;
    }

    public static zza zzawh() {
        return zzhnk.zzbgf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzp(String str) {
        str.getClass();
        this.zzdw |= 2;
        this.zzdx = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdty zzdtyVar) {
        zzdtyVar.getClass();
        this.zzhnj = zzdtyVar;
        this.zzdw |= 8;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzdud zzdudVar = null;
        switch (zzdud.zzdv[i - 1]) {
            case 1:
                return new zzduc();
            case 2:
                return new zza(zzdudVar);
            case 3:
                return zzejz.zza(zzhnk, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzdw", "zzhnh", zzb.zzw(), "zzdx", "zzhni", "zzhnj"});
            case 4:
                return zzhnk;
            case 5:
                zzelw<zzduc> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzduc.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhnk);
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
