package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzhy;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzca {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zza extends zzhy<zza, C0125zza> implements zzjl {
        private static final zza zzh;
        private static volatile zzjs<zza> zzi;
        private int zzc;
        private String zzd = "";
        private boolean zze;
        private boolean zzf;
        private int zzg;

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzca$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class C0125zza extends zzhy.zzb<zza, C0125zza> implements zzjl {
            private C0125zza() {
                super(zza.zzh);
            }

            public final String zza() {
                return ((zza) this.zza).zza();
            }

            public final boolean zzb() {
                return ((zza) this.zza).zzb();
            }

            public final boolean zzc() {
                return ((zza) this.zza).zzc();
            }

            public final boolean zzd() {
                return ((zza) this.zza).zzd();
            }

            public final int zze() {
                return ((zza) this.zza).zze();
            }

            /* synthetic */ C0125zza(zzcc zzccVar) {
                this();
            }

            public final C0125zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzh = zzaVar;
            zzhy.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public final String zza() {
            return this.zzd;
        }

        public final boolean zzb() {
            return this.zze;
        }

        public final boolean zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return (this.zzc & 8) != 0;
        }

        public final int zze() {
            return this.zzg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcc zzccVar = null;
            switch (zzcc.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0125zza(zzccVar);
                case 3:
                    return zzhy.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjs<zza> zzaVar = zzi;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
                            zzaVar = zzi;
                            if (zzaVar == null) {
                                zzaVar = new zzhy.zza<>(zzh);
                                zzi = zzaVar;
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzb extends zzhy<zzb, zza> implements zzjl {
        private static final zzb zzm;
        private static volatile zzjs<zzb> zzn;
        private int zzc;
        private long zzd;
        private int zzf;
        private boolean zzk;
        private String zze = "";
        private zzig<zzc> zzg = zzhy.zzbs();
        private zzig<zza> zzh = zzhy.zzbs();
        private zzig<zzbv.zza> zzi = zzhy.zzbs();
        private String zzj = "";
        private zzig<zzck.zzc> zzl = zzhy.zzbs();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzb, zza> implements zzjl {
            private zza() {
                super(zzb.zzm);
            }

            public final int zza() {
                return ((zzb) this.zza).zzf();
            }

            public final List<zzbv.zza> zzb() {
                return Collections.unmodifiableList(((zzb) this.zza).zzg());
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zzl();
                return this;
            }

            /* synthetic */ zza(zzcc zzccVar) {
                this();
            }

            public final zza zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zza.C0125zza c0125zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, (zza) c0125zza.zzy());
                return this;
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzm = zzbVar;
            zzhy.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        public static zza zzi() {
            return zzm.zzbm();
        }

        public static zzb zzj() {
            return zzm;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl() {
            this.zzi = zzhy.zzbs();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzh.size();
        }

        public final List<zzbv.zza> zzg() {
            return this.zzi;
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public final zza zza(int i) {
            return this.zzh.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zza zzaVar) {
            zzaVar.getClass();
            zzig<zza> zzigVar = this.zzh;
            if (!zzigVar.zza()) {
                this.zzh = zzhy.zza(zzigVar);
            }
            this.zzh.set(i, zzaVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcc zzccVar = null;
            switch (zzcc.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzccVar);
                case 3:
                    return zzhy.zza(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzc.class, "zzh", zza.class, "zzi", zzbv.zza.class, "zzj", "zzk", "zzl", zzck.zzc.class});
                case 4:
                    return zzm;
                case 5:
                    zzjs<zzb> zzaVar = zzn;
                    if (zzaVar == null) {
                        synchronized (zzb.class) {
                            zzaVar = zzn;
                            if (zzaVar == null) {
                                zzaVar = new zzhy.zza<>(zzm);
                                zzn = zzaVar;
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzc extends zzhy<zzc, zza> implements zzjl {
        private static final zzc zzf;
        private static volatile zzjs<zzc> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzc, zza> implements zzjl {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(zzcc zzccVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzf = zzcVar;
            zzhy.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcc zzccVar = null;
            switch (zzcc.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzccVar);
                case 3:
                    return zzhy.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjs<zzc> zzaVar = zzg;
                    if (zzaVar == null) {
                        synchronized (zzc.class) {
                            zzaVar = zzg;
                            if (zzaVar == null) {
                                zzaVar = new zzhy.zza<>(zzf);
                                zzg = zzaVar;
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
}
