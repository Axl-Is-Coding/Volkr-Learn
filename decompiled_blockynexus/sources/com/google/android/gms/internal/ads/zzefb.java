package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzefb extends zzejz<zzefb, zzb> implements zzell {
    private static volatile zzelw<zzefb> zzel;
    private static final zzefb zzhzk;
    private String zzhzh = "";
    private zzeip zzhzi = zzeip.zzier;
    private int zzhzj;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public enum zza implements zzeke {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);

        private static final zzekd<zza> zzes = new zzefd();
        private final int value;

        zza(int i) {
            this.value = i;
        }

        public static zza zzfe(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        @Override // java.lang.Enum
        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(zza.class.getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zzv());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append('>');
            return sb.toString();
        }

        @Override // com.google.android.gms.internal.ads.zzeke
        public final int zzv() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zzb extends zzejz.zzb<zzefb, zzb> implements zzell {
        private zzb() {
            super(zzefb.zzhzk);
        }

        public final zzb zzaf(zzeip zzeipVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzefb) this.zzijh).zzae(zzeipVar);
            return this;
        }

        public final zzb zzb(zza zzaVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzefb) this.zzijh).zza(zzaVar);
            return this;
        }

        public final zzb zzhq(String str) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzefb) this.zzijh).zzhp(str);
            return this;
        }

        /* synthetic */ zzb(zzefa zzefaVar) {
            this();
        }
    }

    static {
        zzefb zzefbVar = new zzefb();
        zzhzk = zzefbVar;
        zzejz.zza((Class<zzefb>) zzefb.class, zzefbVar);
    }

    private zzefb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        this.zzhzj = zzaVar.zzv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzae(zzeip zzeipVar) {
        zzeipVar.getClass();
        this.zzhzi = zzeipVar;
    }

    public static zzb zzbbw() {
        return zzhzk.zzbgf();
    }

    public static zzefb zzbbx() {
        return zzhzk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzhp(String str) {
        str.getClass();
        this.zzhzh = str;
    }

    public final String zzbbt() {
        return this.zzhzh;
    }

    public final zzeip zzbbu() {
        return this.zzhzi;
    }

    public final zza zzbbv() {
        zza zzaVarZzfe = zza.zzfe(this.zzhzj);
        return zzaVarZzfe == null ? zza.UNRECOGNIZED : zzaVarZzfe;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzefa zzefaVar = null;
        switch (zzefa.zzdv[i - 1]) {
            case 1:
                return new zzefb();
            case 2:
                return new zzb(zzefaVar);
            case 3:
                return zzejz.zza(zzhzk, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzhzh", "zzhzi", "zzhzj"});
            case 4:
                return zzhzk;
            case 5:
                zzelw<zzefb> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzefb.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhzk);
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
