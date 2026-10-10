package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import io.rong.common.dlog.DLog;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbw {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zza extends zzejz<zza, C0105zza> implements zzell {
        private static final zza zzek;
        private static volatile zzelw<zza> zzel;
        private int zzdw;
        private long zzdy;
        private long zzec;
        private long zzed;
        private long zzef;
        private int zzej;
        private String zzdx = "";
        private String zzdz = "";
        private String zzea = "";
        private String zzeb = "";
        private String zzee = "";
        private String zzeg = "";
        private String zzeh = "";
        private zzekk<zzb> zzei = zzejz.zzbgk();

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbw$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class C0105zza extends zzejz.zzb<zza, C0105zza> implements zzell {
            private C0105zza() {
                super(zza.zzek);
            }

            public final C0105zza zza(zzc zzcVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzb(zzcVar);
                return this;
            }

            public final C0105zza zzc(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzd(j);
                return this;
            }

            public final C0105zza zzk(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzp(str);
                return this;
            }

            public final C0105zza zzl(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzq(str);
                return this;
            }

            public final C0105zza zzm(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzr(str);
                return this;
            }

            public final C0105zza zzn(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzs(str);
                return this;
            }

            public final C0105zza zzo(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzt(str);
                return this;
            }

            /* synthetic */ C0105zza(zzbv zzbvVar) {
                this();
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class zzb extends zzejz<zzb, C0106zza> implements zzell {
            private static volatile zzelw<zzb> zzel;
            private static final zzb zzeo;
            private int zzdw;
            private String zzem = "";
            private String zzen = "";

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbw$zza$zzb$zza, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
            public static final class C0106zza extends zzejz.zzb<zzb, C0106zza> implements zzell {
                private C0106zza() {
                    super(zzb.zzeo);
                }

                /* synthetic */ C0106zza(zzbv zzbvVar) {
                    this();
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzeo = zzbVar;
                zzejz.zza((Class<zzb>) zzb.class, zzbVar);
            }

            private zzb() {
            }

            @Override // com.google.android.gms.internal.ads.zzejz
            protected final Object zza(int i, Object obj, Object obj2) {
                zzbv zzbvVar = null;
                switch (zzbv.zzdv[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0106zza(zzbvVar);
                    case 3:
                        return zzejz.zza(zzeo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzdw", "zzem", "zzen"});
                    case 4:
                        return zzeo;
                    case 5:
                        zzelw<zzb> zzaVar = zzel;
                        if (zzaVar == null) {
                            synchronized (zzb.class) {
                                zzaVar = zzel;
                                if (zzaVar == null) {
                                    zzaVar = new zzejz.zza<>(zzeo);
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

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public enum zzc implements zzeke {
            UNKNOWN(0),
            ENABLED(1),
            DISABLED(2);

            private static final zzekd<zzc> zzes = new zzbx();
            private final int value;

            zzc(int i) {
                this.value = i;
            }

            public static zzc zzh(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return ENABLED;
                }
                if (i != 2) {
                    return null;
                }
                return DISABLED;
            }

            public static zzekg zzw() {
                return zzbz.zzeu;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.ads.zzeke
            public final int zzv() {
                return this.value;
            }
        }

        static {
            zza zzaVar = new zza();
            zzek = zzaVar;
            zzejz.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzc zzcVar) {
            this.zzej = zzcVar.zzv();
            this.zzdw |= DLog.CRS;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzdw |= 2;
            this.zzdy = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(String str) {
            str.getClass();
            this.zzdw |= 1;
            this.zzdx = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq(String str) {
            str.getClass();
            this.zzdw |= 4;
            this.zzdz = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr(String str) {
            str.getClass();
            this.zzdw |= 8;
            this.zzea = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzs(String str) {
            str.getClass();
            this.zzdw |= 16;
            this.zzeb = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzt(String str) {
            str.getClass();
            this.zzdw |= 1024;
            this.zzeh = str;
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzbv zzbvVar = null;
            switch (zzbv.zzdv[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0105zza(zzbvVar);
                case 3:
                    return zzejz.zza(zzek, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zzdw", "zzdx", "zzdy", "zzdz", "zzea", "zzeb", "zzec", "zzed", "zzee", "zzef", "zzeg", "zzeh", "zzei", zzb.class, "zzej", zzc.zzw()});
                case 4:
                    return zzek;
                case 5:
                    zzelw<zza> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzek);
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

        public static C0105zza zzs() {
            return zzek.zzbgf();
        }
    }
}
