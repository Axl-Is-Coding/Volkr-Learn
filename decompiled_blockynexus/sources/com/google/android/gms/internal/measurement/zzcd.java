package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import io.grpc.internal.GrpcUtil;
import io.rong.common.dlog.DLog;
import io.rong.imkit.utils.FileTypeUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcd {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zza extends zzhy<zza, C0126zza> implements zzjl {
        private static final zza zzh;
        private static volatile zzjs<zza> zzi;
        private int zzc;
        private int zzd;
        private zzi zze;
        private zzi zzf;
        private boolean zzg;

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzcd$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class C0126zza extends zzhy.zzb<zza, C0126zza> implements zzjl {
            private C0126zza() {
                super(zza.zzh);
            }

            public final C0126zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i);
                return this;
            }

            /* synthetic */ C0126zza(zzcf zzcfVar) {
                this();
            }

            public final C0126zza zza(zzi.zza zzaVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza((zzi) zzaVar.zzy());
                return this;
            }

            public final C0126zza zza(zzi zziVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(zziVar);
                return this;
            }

            public final C0126zza zza(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(z);
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

        public static C0126zza zzh() {
            return zzh.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final zzi zzc() {
            zzi zziVar = this.zze;
            return zziVar == null ? zzi.zzj() : zziVar;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final zzi zze() {
            zzi zziVar = this.zzf;
            return zziVar == null ? zzi.zzj() : zziVar;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final boolean zzg() {
            return this.zzg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzi zziVar) {
            zziVar.getClass();
            this.zzf = zziVar;
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzi zziVar) {
            zziVar.getClass();
            this.zze = zziVar;
            this.zzc |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcf zzcfVar = null;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0126zza(zzcfVar);
                case 3:
                    return zzhy.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
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
        private static final zzb zzf;
        private static volatile zzjs<zzb> zzg;
        private int zzc;
        private int zzd;
        private long zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzb, zza> implements zzjl {
            private zza() {
                super(zzb.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i);
                return this;
            }

            /* synthetic */ zza(zzcf zzcfVar) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(j);
                return this;
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzf = zzbVar;
            zzhy.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        public static zza zze() {
            return zzf.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final long zzd() {
            return this.zze;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcf zzcfVar = null;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzcfVar);
                case 3:
                    return zzhy.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjs<zzb> zzaVar = zzg;
                    if (zzaVar == null) {
                        synchronized (zzb.class) {
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzc extends zzhy<zzc, zza> implements zzjl {
        private static final zzc zzi;
        private static volatile zzjs<zzc> zzj;
        private int zzc;
        private zzig<zze> zzd = zzhy.zzbs();
        private String zze = "";
        private long zzf;
        private long zzg;
        private int zzh;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzc, zza> implements zzjl {
            private zza() {
                super(zzc.zzi);
            }

            public final List<zze> zza() {
                return Collections.unmodifiableList(((zzc) this.zza).zza());
            }

            public final int zzb() {
                return ((zzc) this.zza).zzb();
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzm();
                return this;
            }

            public final String zzd() {
                return ((zzc) this.zza).zzc();
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzd();
            }

            public final long zzf() {
                return ((zzc) this.zza).zze();
            }

            public final long zzg() {
                return ((zzc) this.zza).zzg();
            }

            /* synthetic */ zza(zzcf zzcfVar) {
                this();
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb(i);
                return this;
            }

            public final zze zza(int i) {
                return ((zzc) this.zza).zza(i);
            }

            public final zza zza(int i, zze zzeVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(i, zzeVar);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb(j);
                return this;
            }

            public final zza zza(int i, zze.zza zzaVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(i, (zze) zzaVar.zzy());
                return this;
            }

            public final zza zza(zze zzeVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(zzeVar);
                return this;
            }

            public final zza zza(zze.zza zzaVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zze) zzaVar.zzy());
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(str);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(j);
                return this;
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzi = zzcVar;
            zzhy.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        public static zza zzj() {
            return zzi.zzbm();
        }

        private final void zzl() {
            zzig<zze> zzigVar = this.zzd;
            if (zzigVar.zza()) {
                return;
            }
            this.zzd = zzhy.zza(zzigVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm() {
            this.zzd = zzhy.zzbs();
        }

        public final List<zze> zza() {
            return this.zzd;
        }

        public final int zzb() {
            return this.zzd.size();
        }

        public final String zzc() {
            return this.zze;
        }

        public final boolean zzd() {
            return (this.zzc & 2) != 0;
        }

        public final long zze() {
            return this.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 4) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zzc & 8) != 0;
        }

        public final int zzi() {
            return this.zzh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i) {
            zzl();
            this.zzd.remove(i);
        }

        public final zze zza(int i) {
            return this.zzd.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zze zzeVar) {
            zzeVar.getClass();
            zzl();
            this.zzd.set(i, zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zze zzeVar) {
            zzeVar.getClass();
            zzl();
            this.zzd.add(zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zze> iterable) {
            zzl();
            zzgg.zza(iterable, this.zzd);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzf = j;
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcf zzcfVar = null;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzcfVar);
                case 3:
                    return zzhy.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", zze.class, "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjs<zzc> zzaVar = zzj;
                    if (zzaVar == null) {
                        synchronized (zzc.class) {
                            zzaVar = zzj;
                            if (zzaVar == null) {
                                zzaVar = new zzhy.zza<>(zzi);
                                zzj = zzaVar;
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
    public static final class zze extends zzhy<zze, zza> implements zzjl {
        private static final zze zzj;
        private static volatile zzjs<zze> zzk;
        private int zzc;
        private long zzf;
        private float zzg;
        private double zzh;
        private String zzd = "";
        private String zze = "";
        private zzig<zze> zzi = zzhy.zzbs();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zze, zza> implements zzjl {
            private zza() {
                super(zze.zzj);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzb(str);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzq();
                return this;
            }

            public final int zzd() {
                return ((zze) this.zza).zzl();
            }

            public final zza zze() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzs();
                return this;
            }

            /* synthetic */ zza(zzcf zzcfVar) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzo();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzp();
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(j);
                return this;
            }

            public final zza zza(double d2) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(d2);
                return this;
            }

            public final zza zza(zza zzaVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zze((zze) zzaVar.zzy());
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(iterable);
                return this;
            }
        }

        static {
            zze zzeVar = new zze();
            zzj = zzeVar;
            zzhy.zza((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }

        public static zza zzm() {
            return zzj.zzbm();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo() {
            this.zzc &= -3;
            this.zze = zzj.zze;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp() {
            this.zzc &= -5;
            this.zzf = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq() {
            this.zzc &= -17;
            this.zzh = 0.0d;
        }

        private final void zzr() {
            zzig<zze> zzigVar = this.zzi;
            if (zzigVar.zza()) {
                return;
            }
            this.zzi = zzhy.zza(zzigVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzs() {
            this.zzi = zzhy.zzbs();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final String zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final long zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final float zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return (this.zzc & 16) != 0;
        }

        public final double zzj() {
            return this.zzh;
        }

        public final List<zze> zzk() {
            return this.zzi;
        }

        public final int zzl() {
            return this.zzi.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(zze zzeVar) {
            zzeVar.getClass();
            zzr();
            this.zzi.add(zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(double d2) {
            this.zzc |= 16;
            this.zzh = d2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zze> iterable) {
            zzr();
            zzgg.zza(iterable, this.zzi);
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcf zzcfVar = null;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzcfVar);
                case 3:
                    return zzhy.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zze.class});
                case 4:
                    return zzj;
                case 5:
                    zzjs<zze> zzaVar = zzk;
                    if (zzaVar == null) {
                        synchronized (zze.class) {
                            zzaVar = zzk;
                            if (zzaVar == null) {
                                zzaVar = new zzhy.zza<>(zzj);
                                zzk = zzaVar;
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
    public static final class zzf extends zzhy<zzf, zza> implements zzjl {
        private static final zzf zzd;
        private static volatile zzjs<zzf> zze;
        private zzig<zzg> zzc = zzhy.zzbs();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzf, zza> implements zzjl {
            private zza() {
                super(zzf.zzd);
            }

            public final zzg zza(int i) {
                return ((zzf) this.zza).zza(0);
            }

            /* synthetic */ zza(zzcf zzcfVar) {
                this();
            }

            public final zza zza(zzg.zza zzaVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza((zzg) zzaVar.zzy());
                return this;
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzd = zzfVar;
            zzhy.zza((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }

        public static zza zzb() {
            return zzd.zzbm();
        }

        public final List<zzg> zza() {
            return this.zzc;
        }

        public final zzg zza(int i) {
            return this.zzc.get(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzg zzgVar) {
            zzgVar.getClass();
            zzig<zzg> zzigVar = this.zzc;
            if (!zzigVar.zza()) {
                this.zzc = zzhy.zza(zzigVar);
            }
            this.zzc.add(zzgVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcf zzcfVar = null;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzcfVar);
                case 3:
                    return zzhy.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzg.class});
                case 4:
                    return zzd;
                case 5:
                    zzjs<zzf> zzaVar = zze;
                    if (zzaVar == null) {
                        synchronized (zzf.class) {
                            zzaVar = zze;
                            if (zzaVar == null) {
                                zzaVar = new zzhy.zza<>(zzd);
                                zze = zzaVar;
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
    public static final class zzg extends zzhy<zzg, zza> implements zzjl {
        private static final zzg zzax;
        private static volatile zzjs<zzg> zzay;
        private int zzaa;
        private boolean zzad;
        private int zzag;
        private int zzah;
        private int zzai;
        private long zzak;
        private long zzal;
        private int zzao;
        private zzh zzaq;
        private long zzas;
        private long zzat;
        private int zzaw;
        private int zzc;
        private int zzd;
        private int zze;
        private long zzh;
        private long zzi;
        private long zzj;
        private long zzk;
        private long zzl;
        private int zzq;
        private long zzu;
        private long zzv;
        private boolean zzx;
        private long zzz;
        private zzig<zzc> zzf = zzhy.zzbs();
        private zzig<zzk> zzg = zzhy.zzbs();
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private String zzw = "";
        private String zzy = "";
        private String zzab = "";
        private String zzac = "";
        private zzig<zza> zzae = zzhy.zzbs();
        private String zzaf = "";
        private String zzaj = "";
        private String zzam = "";
        private String zzan = "";
        private String zzap = "";
        private zzie zzar = zzhy.zzbq();
        private String zzau = "";
        private String zzav = "";

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzg, zza> implements zzjl {
            private zza() {
                super(zzg.zzax);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(1);
                return this;
            }

            public final int zzb() {
                return ((zzg) this.zza).zzd();
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbx();
                return this;
            }

            public final List<zzk> zzd() {
                return Collections.unmodifiableList(((zzg) this.zza).zze());
            }

            public final int zze() {
                return ((zzg) this.zza).zzf();
            }

            public final long zzf() {
                return ((zzg) this.zza).zzj();
            }

            public final long zzg() {
                return ((zzg) this.zza).zzl();
            }

            public final zza zzh() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbz();
                return this;
            }

            public final zza zzi() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzca();
                return this;
            }

            public final String zzj() {
                return ((zzg) this.zza).zzx();
            }

            public final zza zzk() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcb();
                return this;
            }

            public final zza zzl() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcc();
                return this;
            }

            public final zza zzm() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcd();
                return this;
            }

            public final zza zzn() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzce();
                return this;
            }

            public final String zzo() {
                return ((zzg) this.zza).zzam();
            }

            public final zza zzp() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcf();
                return this;
            }

            public final zza zzq() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcg();
                return this;
            }

            public final zza zzr() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzch();
                return this;
            }

            public final String zzs() {
                return ((zzg) this.zza).zzbe();
            }

            /* synthetic */ zza(zzcf zzcfVar) {
                this();
            }

            public final zzc zzb(int i) {
                return ((zzg) this.zza).zza(i);
            }

            public final zza zze(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(i);
                return this;
            }

            public final zza zzf(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(i);
                return this;
            }

            public final zza zzg(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(str);
                return this;
            }

            public final zza zzj(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(str);
                return this;
            }

            public final zza zzo(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzo(str);
                return this;
            }

            public final zza zzb(Iterable<? extends zzk> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(iterable);
                return this;
            }

            public final zzk zzd(int i) {
                return ((zzg) this.zza).zzb(i);
            }

            public final List<zzc> zza() {
                return Collections.unmodifiableList(((zzg) this.zza).zzc());
            }

            public final zza zzc(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(i);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(j);
                return this;
            }

            public final zza zzh(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(str);
                return this;
            }

            public final zza zzi(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(str);
                return this;
            }

            public final zza zzk(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk(str);
                return this;
            }

            public final zza zzl(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl(str);
                return this;
            }

            public final zza zzm(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzm(str);
                return this;
            }

            public final zza zzn(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzn(null);
                return this;
            }

            public final zza zzp(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzp(str);
                return this;
            }

            public final zza zzq(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzq(str);
                return this;
            }

            public final zza zze(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(j);
                return this;
            }

            public final zza zzf(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(str);
                return this;
            }

            public final zza zzg(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(j);
                return this;
            }

            public final zza zzj(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(j);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(j);
                return this;
            }

            public final zza zza(int i, zzc.zza zzaVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(i, (zzc) zzaVar.zzy());
                return this;
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(j);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(str);
                return this;
            }

            public final zza zzh(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(j);
                return this;
            }

            public final zza zzi(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(j);
                return this;
            }

            public final zza zzk(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk(j);
                return this;
            }

            public final zza zzl(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl(j);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(str);
                return this;
            }

            public final zza zzf(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(j);
                return this;
            }

            public final zza zzg(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(i);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(Iterable<? extends Integer> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(iterable);
                return this;
            }

            public final zza zzh(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(i);
                return this;
            }

            public final zza zzi(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(i);
                return this;
            }

            public final zza zza(zzc.zza zzaVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzc) zzaVar.zzy());
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(z);
                return this;
            }

            public final zza zzc(Iterable<? extends zza> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(iterable);
                return this;
            }

            public final zza zza(Iterable<? extends zzc> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(int i, zzk zzkVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(i, zzkVar);
                return this;
            }

            public final zza zza(zzk zzkVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(zzkVar);
                return this;
            }

            public final zza zza(zzk.zza zzaVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzk) zzaVar.zzy());
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(j);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(z);
                return this;
            }

            public final zza zza(zzh.zza zzaVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzh) zzaVar.zzy());
                return this;
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzax = zzgVar;
            zzhy.zza((Class<zzg>) zzg.class, zzgVar);
        }

        private zzg() {
        }

        public static zza zzbh() {
            return zzax.zzbm();
        }

        private final void zzbw() {
            zzig<zzc> zzigVar = this.zzf;
            if (zzigVar.zza()) {
                return;
            }
            this.zzf = zzhy.zza(zzigVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbx() {
            this.zzf = zzhy.zzbs();
        }

        private final void zzby() {
            zzig<zzk> zzigVar = this.zzg;
            if (zzigVar.zza()) {
                return;
            }
            this.zzg = zzhy.zza(zzigVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbz() {
            this.zzc &= -17;
            this.zzk = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzca() {
            this.zzc &= -33;
            this.zzl = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcb() {
            this.zzc &= -65537;
            this.zzw = zzax.zzw;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcc() {
            this.zzc &= -131073;
            this.zzx = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcd() {
            this.zzc &= -262145;
            this.zzy = zzax.zzy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzce() {
            this.zzc &= -2097153;
            this.zzab = zzax.zzab;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcf() {
            this.zzae = zzhy.zzbs();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcg() {
            this.zzc &= -268435457;
            this.zzaj = zzax.zzaj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzch() {
            this.zzc &= Integer.MAX_VALUE;
            this.zzam = zzax.zzam;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(int i) {
            this.zzc |= 1;
            this.zze = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(int i) {
            zzbw();
            this.zzf.remove(i);
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzaa() {
            return this.zzu;
        }

        public final boolean zzab() {
            return (this.zzc & 32768) != 0;
        }

        public final long zzac() {
            return this.zzv;
        }

        public final String zzad() {
            return this.zzw;
        }

        public final boolean zzae() {
            return (this.zzc & 131072) != 0;
        }

        public final boolean zzaf() {
            return this.zzx;
        }

        public final String zzag() {
            return this.zzy;
        }

        public final boolean zzah() {
            return (this.zzc & 524288) != 0;
        }

        public final long zzai() {
            return this.zzz;
        }

        public final boolean zzaj() {
            return (this.zzc & 1048576) != 0;
        }

        public final int zzak() {
            return this.zzaa;
        }

        public final String zzal() {
            return this.zzab;
        }

        public final String zzam() {
            return this.zzac;
        }

        public final boolean zzan() {
            return (this.zzc & 8388608) != 0;
        }

        public final boolean zzao() {
            return this.zzad;
        }

        public final List<zza> zzap() {
            return this.zzae;
        }

        public final String zzaq() {
            return this.zzaf;
        }

        public final boolean zzar() {
            return (this.zzc & 33554432) != 0;
        }

        public final int zzas() {
            return this.zzag;
        }

        public final String zzat() {
            return this.zzaj;
        }

        public final boolean zzau() {
            return (this.zzc & 536870912) != 0;
        }

        public final long zzav() {
            return this.zzak;
        }

        public final boolean zzaw() {
            return (this.zzc & FileTypeUtils.GIGABYTE) != 0;
        }

        public final long zzax() {
            return this.zzal;
        }

        public final String zzay() {
            return this.zzam;
        }

        public final boolean zzaz() {
            return (this.zzd & 2) != 0;
        }

        public final int zzb() {
            return this.zze;
        }

        public final int zzba() {
            return this.zzao;
        }

        public final String zzbb() {
            return this.zzap;
        }

        public final boolean zzbc() {
            return (this.zzd & 16) != 0;
        }

        public final long zzbd() {
            return this.zzas;
        }

        public final String zzbe() {
            return this.zzau;
        }

        public final boolean zzbf() {
            return (this.zzd & 128) != 0;
        }

        public final String zzbg() {
            return this.zzav;
        }

        public final List<zzc> zzc() {
            return this.zzf;
        }

        public final int zzf() {
            return this.zzg.size();
        }

        public final boolean zzg() {
            return (this.zzc & 2) != 0;
        }

        public final long zzh() {
            return this.zzh;
        }

        public final boolean zzi() {
            return (this.zzc & 4) != 0;
        }

        public final long zzj() {
            return this.zzi;
        }

        public final boolean zzk() {
            return (this.zzc & 8) != 0;
        }

        public final long zzl() {
            return this.zzj;
        }

        public final boolean zzm() {
            return (this.zzc & 16) != 0;
        }

        public final long zzn() {
            return this.zzk;
        }

        public final boolean zzo() {
            return (this.zzc & 32) != 0;
        }

        public final long zzp() {
            return this.zzl;
        }

        public final String zzq() {
            return this.zzm;
        }

        public final String zzr() {
            return this.zzn;
        }

        public final String zzs() {
            return this.zzo;
        }

        public final String zzt() {
            return this.zzp;
        }

        public final boolean zzu() {
            return (this.zzc & 1024) != 0;
        }

        public final int zzv() {
            return this.zzq;
        }

        public final String zzw() {
            return this.zzr;
        }

        public final String zzx() {
            return this.zzs;
        }

        public final String zzy() {
            return this.zzt;
        }

        public final boolean zzz() {
            return (this.zzc & 16384) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzc |= 8;
            this.zzj = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(int i) {
            zzby();
            this.zzg.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(int i) {
            this.zzc |= 1024;
            this.zzq = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(String str) {
            str.getClass();
            this.zzc |= 65536;
            this.zzw = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(String str) {
            str.getClass();
            this.zzc |= 262144;
            this.zzy = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zzc |= 2097152;
            this.zzab = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(String str) {
            str.getClass();
            this.zzc |= GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            this.zzac = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(String str) {
            str.getClass();
            this.zzc |= 16777216;
            this.zzaf = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm(String str) {
            str.getClass();
            this.zzc |= 268435456;
            this.zzaj = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzc |= Integer.MIN_VALUE;
            this.zzam = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zzd |= 4;
            this.zzap = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(String str) {
            str.getClass();
            this.zzd |= 64;
            this.zzau = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq(String str) {
            str.getClass();
            this.zzd |= 128;
            this.zzav = str;
        }

        public final zzc zza(int i) {
            return this.zzf.get(i);
        }

        public final zzk zzb(int i) {
            return this.zzg.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zzc zzcVar) {
            zzcVar.getClass();
            zzbw();
            this.zzf.set(i, zzcVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(Iterable<? extends zzk> iterable) {
            zzby();
            zzgg.zza(iterable, this.zzg);
        }

        public final int zzd() {
            return this.zzf.size();
        }

        public final List<zzk> zze() {
            return this.zzg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 256;
            this.zzo = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzc |= 16;
            this.zzk = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(long j) {
            this.zzc |= 32;
            this.zzl = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzc |= 4096;
            this.zzs = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(String str) {
            str.getClass();
            this.zzc |= 8192;
            this.zzt = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzi = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(long j) {
            this.zzc |= 524288;
            this.zzz = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(int i) {
            this.zzc |= 33554432;
            this.zzag = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(long j) {
            this.zzc |= FileTypeUtils.GIGABYTE;
            this.zzal = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(long j) {
            this.zzd |= 16;
            this.zzas = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzd |= 32;
            this.zzat = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            zzcVar.getClass();
            zzbw();
            this.zzf.add(zzcVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 512;
            this.zzp = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= DLog.CRS;
            this.zzr = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzn = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(Iterable<? extends zza> iterable) {
            zzig<zza> zzigVar = this.zzae;
            if (!zzigVar.zza()) {
                this.zzae = zzhy.zza(zzigVar);
            }
            zzgg.zza(iterable, this.zzae);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzc |= 16384;
            this.zzu = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzc |= 32768;
            this.zzv = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(int i) {
            this.zzc |= 1048576;
            this.zzaa = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(long j) {
            this.zzc |= 536870912;
            this.zzak = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(int i) {
            this.zzd |= 2;
            this.zzao = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzc> iterable) {
            zzbw();
            zzgg.zza(iterable, this.zzf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(Iterable<? extends Integer> iterable) {
            zzie zzieVar = this.zzar;
            if (!zzieVar.zza()) {
                int size = zzieVar.size();
                this.zzar = zzieVar.zza(size == 0 ? 10 : size << 1);
            }
            zzgg.zza(iterable, this.zzar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8388608;
            this.zzad = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zzk zzkVar) {
            zzkVar.getClass();
            zzby();
            this.zzg.set(i, zzkVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzk zzkVar) {
            zzkVar.getClass();
            zzby();
            this.zzg.add(zzkVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzh = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 64;
            this.zzm = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 131072;
            this.zzx = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzh zzhVar) {
            zzhVar.getClass();
            this.zzaq = zzhVar;
            this.zzd |= 8;
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcf zzcfVar = null;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzcfVar);
                case 3:
                    return zzhy.zza(zzax, "\u0001-\u0000\u0002\u00015-\u0000\u0004\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", zzk.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzk", "zzad", "zzae", zza.class, "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzaw", zzce.zzb()});
                case 4:
                    return zzax;
                case 5:
                    zzjs<zzg> zzaVar = zzay;
                    if (zzaVar == null) {
                        synchronized (zzg.class) {
                            zzaVar = zzay;
                            if (zzaVar == null) {
                                zzaVar = new zzhy.zza<>(zzax);
                                zzay = zzaVar;
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
    public static final class zzi extends zzhy<zzi, zza> implements zzjl {
        private static final zzi zzg;
        private static volatile zzjs<zzi> zzh;
        private zzih zzc = zzhy.zzbr();
        private zzih zzd = zzhy.zzbr();
        private zzig<zzb> zze = zzhy.zzbs();
        private zzig<zzj> zzf = zzhy.zzbs();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzi, zza> implements zzjl {
            private zza() {
                super(zzi.zzg);
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzc(Iterable<? extends zzb> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzc(iterable);
                return this;
            }

            public final zza zzd(Iterable<? extends zzj> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd(iterable);
                return this;
            }

            /* synthetic */ zza(zzcf zzcfVar) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzl();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzm();
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd(i);
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zze(i);
                return this;
            }
        }

        static {
            zzi zziVar = new zzi();
            zzg = zziVar;
            zzhy.zza((Class<zzi>) zzi.class, zziVar);
        }

        private zzi() {
        }

        public static zza zzi() {
            return zzg.zzbm();
        }

        public static zzi zzj() {
            return zzg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl() {
            this.zzc = zzhy.zzbr();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm() {
            this.zzd = zzhy.zzbr();
        }

        private final void zzn() {
            zzig<zzb> zzigVar = this.zze;
            if (zzigVar.zza()) {
                return;
            }
            this.zze = zzhy.zza(zzigVar);
        }

        private final void zzo() {
            zzig<zzj> zzigVar = this.zzf;
            if (zzigVar.zza()) {
                return;
            }
            this.zzf = zzhy.zza(zzigVar);
        }

        public final List<Long> zza() {
            return this.zzc;
        }

        public final int zzb() {
            return this.zzc.size();
        }

        public final List<Long> zzc() {
            return this.zzd;
        }

        public final int zzd() {
            return this.zzd.size();
        }

        public final List<zzb> zze() {
            return this.zze;
        }

        public final int zzf() {
            return this.zze.size();
        }

        public final List<zzj> zzg() {
            return this.zzf;
        }

        public final int zzh() {
            return this.zzf.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            zzih zzihVar = this.zzc;
            if (!zzihVar.zza()) {
                this.zzc = zzhy.zza(zzihVar);
            }
            zzgg.zza(iterable, this.zzc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(Iterable<? extends Long> iterable) {
            zzih zzihVar = this.zzd;
            if (!zzihVar.zza()) {
                this.zzd = zzhy.zza(zzihVar);
            }
            zzgg.zza(iterable, this.zzd);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(Iterable<? extends zzb> iterable) {
            zzn();
            zzgg.zza(iterable, this.zze);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(int i) {
            zzn();
            this.zze.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(int i) {
            zzo();
            this.zzf.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(Iterable<? extends zzj> iterable) {
            zzo();
            zzgg.zza(iterable, this.zzf);
        }

        public final zzb zza(int i) {
            return this.zze.get(i);
        }

        public final zzj zzb(int i) {
            return this.zzf.get(i);
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcf zzcfVar = null;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(zzcfVar);
                case 3:
                    return zzhy.zza(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", zzb.class, "zzf", zzj.class});
                case 4:
                    return zzg;
                case 5:
                    zzjs<zzi> zzaVar = zzh;
                    if (zzaVar == null) {
                        synchronized (zzi.class) {
                            zzaVar = zzh;
                            if (zzaVar == null) {
                                zzaVar = new zzhy.zza<>(zzg);
                                zzh = zzaVar;
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
    public static final class zzj extends zzhy<zzj, zza> implements zzjl {
        private static final zzj zzf;
        private static volatile zzjs<zzj> zzg;
        private int zzc;
        private int zzd;
        private zzih zze = zzhy.zzbr();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzj, zza> implements zzjl {
            private zza() {
                super(zzj.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzb(i);
                return this;
            }

            /* synthetic */ zza(zzcf zzcfVar) {
                this();
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza(iterable);
                return this;
            }
        }

        static {
            zzj zzjVar = new zzj();
            zzf = zzjVar;
            zzhy.zza((Class<zzj>) zzj.class, zzjVar);
        }

        private zzj() {
        }

        public static zza zze() {
            return zzf.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final List<Long> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final long zza(int i) {
            return this.zze.zzb(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            zzih zzihVar = this.zze;
            if (!zzihVar.zza()) {
                this.zze = zzhy.zza(zzihVar);
            }
            zzgg.zza(iterable, this.zze);
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcf zzcfVar = null;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(zzcfVar);
                case 3:
                    return zzhy.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjs<zzj> zzaVar = zzg;
                    if (zzaVar == null) {
                        synchronized (zzj.class) {
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzk extends zzhy<zzk, zza> implements zzjl {
        private static final zzk zzj;
        private static volatile zzjs<zzk> zzk;
        private int zzc;
        private long zzd;
        private String zze = "";
        private String zzf = "";
        private long zzg;
        private float zzh;
        private double zzi;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzk, zza> implements zzjl {
            private zza() {
                super(zzk.zzj);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(j);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb(str);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzn();
                return this;
            }

            /* synthetic */ zza(zzcf zzcfVar) {
                this();
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(str);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb(j);
                return this;
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzl();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzm();
                return this;
            }

            public final zza zza(double d2) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(d2);
                return this;
            }
        }

        static {
            zzk zzkVar = new zzk();
            zzj = zzkVar;
            zzhy.zza((Class<zzk>) zzk.class, zzkVar);
        }

        private zzk() {
        }

        public static zza zzj() {
            return zzj.zzbm();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl() {
            this.zzc &= -5;
            this.zzf = zzj.zzf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm() {
            this.zzc &= -9;
            this.zzg = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn() {
            this.zzc &= -33;
            this.zzi = 0.0d;
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final String zze() {
            return this.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zzc & 32) != 0;
        }

        public final double zzi() {
            return this.zzi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(double d2) {
            this.zzc |= 32;
            this.zzi = d2;
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcf zzcfVar = null;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zzcfVar);
                case 3:
                    return zzhy.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzjs<zzk> zzaVar = zzk;
                    if (zzaVar == null) {
                        synchronized (zzk.class) {
                            zzaVar = zzk;
                            if (zzaVar == null) {
                                zzaVar = new zzhy.zza<>(zzj);
                                zzk = zzaVar;
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
    public static final class zzd extends zzhy<zzd, zza> implements zzjl {
        private static final zzd zzf;
        private static volatile zzjs<zzd> zzg;
        private int zzc;
        private String zzd = "";
        private long zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzd, zza> implements zzjl {
            private zza() {
                super(zzd.zzf);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzcf zzcfVar) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(j);
                return this;
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzf = zzdVar;
            zzhy.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public static zza zza() {
            return zzf.zzbm();
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcf zzcfVar = null;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzcfVar);
                case 3:
                    return zzhy.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjs<zzd> zzaVar = zzg;
                    if (zzaVar == null) {
                        synchronized (zzd.class) {
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzh extends zzhy<zzh, zza> implements zzjl {
        private static final zzh zzf;
        private static volatile zzjs<zzh> zzg;
        private int zzc;
        private int zzd = 1;
        private zzig<zzd> zze = zzhy.zzbs();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzh, zza> implements zzjl {
            private zza() {
                super(zzh.zzf);
            }

            public final zza zza(zzd.zza zzaVar) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza((zzd) zzaVar.zzy());
                return this;
            }

            /* synthetic */ zza(zzcf zzcfVar) {
                this();
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public enum zzb implements zzid {
            RADS(1),
            PROVISIONING(2);

            private static final zzic<zzb> zzc = new zzci();
            private final int zzd;

            zzb(int i) {
                this.zzd = i;
            }

            public static zzif zzb() {
                return zzcj.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.measurement.zzid
            public final int zza() {
                return this.zzd;
            }

            public static zzb zza(int i) {
                if (i == 1) {
                    return RADS;
                }
                if (i != 2) {
                    return null;
                }
                return PROVISIONING;
            }
        }

        static {
            zzh zzhVar = new zzh();
            zzf = zzhVar;
            zzhy.zza((Class<zzh>) zzh.class, zzhVar);
        }

        private zzh() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzd zzdVar) {
            zzdVar.getClass();
            zzig<zzd> zzigVar = this.zze;
            if (!zzigVar.zza()) {
                this.zze = zzhy.zza(zzigVar);
            }
            this.zze.add(zzdVar);
        }

        public static zza zza() {
            return zzf.zzbm();
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzcf zzcfVar = null;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzcfVar);
                case 3:
                    return zzhy.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", zzd.class});
                case 4:
                    return zzf;
                case 5:
                    zzjs<zzh> zzaVar = zzg;
                    if (zzaVar == null) {
                        synchronized (zzh.class) {
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
