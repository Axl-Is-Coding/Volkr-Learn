package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzefm extends zzejz<zzefm, zzb> implements zzell {
    private static volatile zzelw<zzefm> zzel;
    private static final zzefm zzian;
    private int zziaf;
    private zzekk<zza> zziam = zzejz.zzbgk();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz<zza, C0111zza> implements zzell {
        private static volatile zzelw<zza> zzel;
        private static final zza zziao;
        private String zzhzh = "";
        private int zzhzy;
        private int zziaj;
        private int zziak;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzefm$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public static final class C0111zza extends zzejz.zzb<zza, C0111zza> implements zzell {
            private C0111zza() {
                super(zza.zziao);
            }

            public final C0111zza zzb(zzefc zzefcVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zza(zzefcVar);
                return this;
            }

            public final C0111zza zzfj(int i) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzfh(i);
                return this;
            }

            public final C0111zza zzhr(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzhp(str);
                return this;
            }

            /* synthetic */ C0111zza(zzefl zzeflVar) {
                this();
            }

            public final C0111zza zzb(zzefv zzefvVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zza(zzefvVar);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zziao = zzaVar;
            zzejz.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzefc zzefcVar) {
            this.zziaj = zzefcVar.zzv();
        }

        public static C0111zza zzbcq() {
            return zziao.zzbgf();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzfh(int i) {
            this.zziak = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzhp(String str) {
            str.getClass();
            this.zzhzh = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzefv zzefvVar) {
            this.zzhzy = zzefvVar.zzv();
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzefl zzeflVar = null;
            switch (zzefl.zzdv[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0111zza(zzeflVar);
                case 3:
                    return zzejz.zza(zziao, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzhzh", "zziaj", "zziak", "zzhzy"});
                case 4:
                    return zziao;
                case 5:
                    zzelw<zza> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zziao);
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zzb extends zzejz.zzb<zzefm, zzb> implements zzell {
        private zzb() {
            super(zzefm.zzian);
        }

        public final zzb zzb(zza zzaVar) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzefm) this.zzijh).zza(zzaVar);
            return this;
        }

        public final zzb zzfi(int i) {
            if (this.zziji) {
                zzbgp();
                this.zziji = false;
            }
            ((zzefm) this.zzijh).zzfg(i);
            return this;
        }

        /* synthetic */ zzb(zzefl zzeflVar) {
            this();
        }
    }

    static {
        zzefm zzefmVar = new zzefm();
        zzian = zzefmVar;
        zzejz.zza((Class<zzefm>) zzefm.class, zzefmVar);
    }

    private zzefm() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        zzaVar.getClass();
        zzekk<zza> zzekkVar = this.zziam;
        if (!zzekkVar.zzbeb()) {
            this.zziam = zzejz.zza(zzekkVar);
        }
        this.zziam.add(zzaVar);
    }

    public static zzb zzbco() {
        return zzian.zzbgf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzfg(int i) {
        this.zziaf = i;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzefl zzeflVar = null;
        switch (zzefl.zzdv[i - 1]) {
            case 1:
                return new zzefm();
            case 2:
                return new zzb(zzeflVar);
            case 3:
                return zzejz.zza(zzian, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zziaf", "zziam", zza.class});
            case 4:
                return zzian;
            case 5:
                zzelw<zzefm> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzefm.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzian);
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
