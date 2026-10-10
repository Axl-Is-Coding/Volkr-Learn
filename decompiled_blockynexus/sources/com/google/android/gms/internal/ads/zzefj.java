package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzefj extends zzejz<zzefj, zza> implements zzell {
    private static volatile zzelw<zzefj> zzel;
    private static final zzefj zziah;
    private int zziaf;
    private zzekk<zzb> zziag = zzejz.zzbgk();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzefj, zza> implements zzell {
        private zza() {
            super(zzefj.zziah);
        }

        /* synthetic */ zza(zzefk zzefkVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zzb extends zzejz<zzb, zza> implements zzell {
        private static volatile zzelw<zzb> zzel;
        private static final zzb zzial;
        private int zzhzy;
        private zzefb zziai;
        private int zziaj;
        private int zziak;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public static final class zza extends zzejz.zzb<zzb, zza> implements zzell {
            private zza() {
                super(zzb.zzial);
            }

            /* synthetic */ zza(zzefk zzefkVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzial = zzbVar;
            zzejz.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzefk zzefkVar = null;
            switch (zzefk.zzdv[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzefkVar);
                case 3:
                    return zzejz.zza(zzial, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zziai", "zziaj", "zziak", "zzhzy"});
                case 4:
                    return zzial;
                case 5:
                    zzelw<zzb> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zzb.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzial);
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

        public final zzefc zzayu() {
            zzefc zzefcVarZzff = zzefc.zzff(this.zziaj);
            return zzefcVarZzff == null ? zzefc.UNRECOGNIZED : zzefcVarZzff;
        }

        public final zzefv zzayv() {
            zzefv zzefvVarZzfm = zzefv.zzfm(this.zzhzy);
            return zzefvVarZzfm == null ? zzefv.UNRECOGNIZED : zzefvVarZzfm;
        }

        public final boolean zzbck() {
            return this.zziai != null;
        }

        public final zzefb zzbcl() {
            zzefb zzefbVar = this.zziai;
            return zzefbVar == null ? zzefb.zzbbx() : zzefbVar;
        }

        public final int zzbcm() {
            return this.zziak;
        }
    }

    static {
        zzefj zzefjVar = new zzefj();
        zziah = zzefjVar;
        zzejz.zza((Class<zzefj>) zzefj.class, zzefjVar);
    }

    private zzefj() {
    }

    public static zzefj zzc(byte[] bArr, zzejm zzejmVar) throws zzekj {
        return (zzefj) zzejz.zza(zziah, bArr, zzejmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzefk zzefkVar = null;
        switch (zzefk.zzdv[i - 1]) {
            case 1:
                return new zzefj();
            case 2:
                return new zza(zzefkVar);
            case 3:
                return zzejz.zza(zziah, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zziaf", "zziag", zzb.class});
            case 4:
                return zziah;
            case 5:
                zzelw<zzefj> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzefj.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zziah);
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

    public final int zzbcg() {
        return this.zziaf;
    }

    public final List<zzb> zzbch() {
        return this.zziag;
    }

    public final int zzbci() {
        return this.zziag.size();
    }
}
