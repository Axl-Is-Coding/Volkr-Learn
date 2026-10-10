package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzby {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zza extends zzejz<zza, C0107zza> implements zzell {
        private static volatile zzelw<zza> zzel;
        private static final zza zzex;
        private int zzdw;
        private zzb zzev;
        private zzc zzew;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzby$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class C0107zza extends zzejz.zzb<zza, C0107zza> implements zzell {
            private C0107zza() {
                super(zza.zzex);
            }

            /* synthetic */ C0107zza(zzca zzcaVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzex = zzaVar;
            zzejz.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzca zzcaVar = null;
            switch (zzca.zzdv[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0107zza(zzcaVar);
                case 3:
                    return zzejz.zza(zzex, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzdw", "zzev", "zzew"});
                case 4:
                    return zzex;
                case 5:
                    zzelw<zza> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzex);
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

        public final zzc zzaa() {
            zzc zzcVar = this.zzew;
            return zzcVar == null ? zzc.zzag() : zzcVar;
        }

        public final boolean zzx() {
            return (this.zzdw & 1) != 0;
        }

        public final zzb zzy() {
            zzb zzbVar = this.zzev;
            return zzbVar == null ? zzb.zzad() : zzbVar;
        }

        public final boolean zzz() {
            return (this.zzdw & 2) != 0;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zzb extends zzejz<zzb, zza> implements zzell {
        private static volatile zzelw<zzb> zzel;
        private static final zzb zzez;
        private int zzdw;
        private int zzey = 2;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class zza extends zzejz.zzb<zzb, zza> implements zzell {
            private zza() {
                super(zzb.zzez);
            }

            /* synthetic */ zza(zzca zzcaVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzez = zzbVar;
            zzejz.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        public static zzb zzad() {
            return zzez;
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzca zzcaVar = null;
            switch (zzca.zzdv[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzcaVar);
                case 3:
                    return zzejz.zza(zzez, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001bဌ\u0000", new Object[]{"zzdw", "zzey", zzcb.zzw()});
                case 4:
                    return zzez;
                case 5:
                    zzelw<zzb> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zzb.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzez);
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

        public final zzcb zzac() {
            zzcb zzcbVarZzj = zzcb.zzj(this.zzey);
            return zzcbVarZzj == null ? zzcb.ENUM_SIGNAL_SOURCE_ADSHIELD : zzcbVarZzj;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zzc extends zzejz<zzc, zza> implements zzell {
        private static volatile zzelw<zzc> zzel;
        private static final zzc zzfm;
        private int zzdw;
        private String zzfg = "";
        private String zzfh = "";
        private String zzfi = "";
        private String zzfj = "";
        private String zzfk = "";
        private String zzfl = "";

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class zza extends zzejz.zzb<zzc, zza> implements zzell {
            private zza() {
                super(zzc.zzfm);
            }

            /* synthetic */ zza(zzca zzcaVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzfm = zzcVar;
            zzejz.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        public static zzc zzag() {
            return zzfm;
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzca zzcaVar = null;
            switch (zzca.zzdv[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzcaVar);
                case 3:
                    return zzejz.zza(zzfm, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zzdw", "zzfg", "zzfh", "zzfi", "zzfj", "zzfk", "zzfl"});
                case 4:
                    return zzfm;
                case 5:
                    zzelw<zzc> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zzc.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzfm);
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

        public final String zzaf() {
            return this.zzfg;
        }
    }
}
