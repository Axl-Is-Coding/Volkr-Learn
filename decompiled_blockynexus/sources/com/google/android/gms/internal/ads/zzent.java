package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzent {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz<zza, zzb> implements zzell {
        private static volatile zzelw<zza> zzel;
        private static final zza zziqi;
        private int zzdw;
        private int zziqb;
        private C0112zza zziqc;
        private zzeip zziqd;
        private zzeip zziqe;
        private boolean zziqf;
        private boolean zziqg;
        private byte zziqh = 2;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzent$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public static final class C0112zza extends zzejz<C0112zza, C0113zza> implements zzell {
            private static volatile zzelw<C0112zza> zzel;
            private static final C0112zza zziqn;
            private int zzdw;
            private String zziqj = "";
            private String zziqk = "";
            private String zziql = "";
            private int zziqm;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzent$zza$zza$zza, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public static final class C0113zza extends zzejz.zzb<C0112zza, C0113zza> implements zzell {
                private C0113zza() {
                    super(C0112zza.zziqn);
                }

                /* synthetic */ C0113zza(zzenv zzenvVar) {
                    this();
                }
            }

            static {
                C0112zza c0112zza = new C0112zza();
                zziqn = c0112zza;
                zzejz.zza((Class<C0112zza>) C0112zza.class, c0112zza);
            }

            private C0112zza() {
            }

            @Override // com.google.android.gms.internal.ads.zzejz
            protected final Object zza(int i, Object obj, Object obj2) {
                zzenv zzenvVar = null;
                switch (zzenv.zzdv[i - 1]) {
                    case 1:
                        return new C0112zza();
                    case 2:
                        return new C0113zza(zzenvVar);
                    case 3:
                        return zzejz.zza(zziqn, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zzdw", "zziqj", "zziqk", "zziql", "zziqm"});
                    case 4:
                        return zziqn;
                    case 5:
                        zzelw<C0112zza> zzaVar = zzel;
                        if (zzaVar == null) {
                            synchronized (C0112zza.class) {
                                zzaVar = zzel;
                                if (zzaVar == null) {
                                    zzaVar = new zzejz.zza<>(zziqn);
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
        public static final class zzb extends zzejz.zzb<zza, zzb> implements zzell {
            private zzb() {
                super(zza.zziqi);
            }

            /* synthetic */ zzb(zzenv zzenvVar) {
                this();
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public enum zzc implements zzeke {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);

            private static final zzekd<zzc> zzes = new zzenx();
            private final int value;

            zzc(int i) {
                this.value = i;
            }

            public static zzc zzht(int i) {
                if (i == 0) {
                    return SAFE;
                }
                if (i == 1) {
                    return DANGEROUS;
                }
                if (i == 2) {
                    return UNKNOWN;
                }
                if (i == 3) {
                    return POTENTIALLY_UNWANTED;
                }
                if (i != 4) {
                    return null;
                }
                return DANGEROUS_HOST;
            }

            public static zzekg zzw() {
                return zzenw.zzeu;
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
            zziqi = zzaVar;
            zzejz.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
            zzeip zzeipVar = zzeip.zzier;
            this.zziqd = zzeipVar;
            this.zziqe = zzeipVar;
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzenv zzenvVar = null;
            switch (zzenv.zzdv[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(zzenvVar);
                case 3:
                    return zzejz.zza(zziqi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဉ\u0001\u0003ည\u0002\u0004ည\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzdw", "zziqb", zzc.zzw(), "zziqc", "zziqd", "zziqe", "zziqf", "zziqg"});
                case 4:
                    return zziqi;
                case 5:
                    zzelw<zza> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zziqi);
                                zzel = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
                case 6:
                    return Byte.valueOf(this.zziqh);
                case 7:
                    this.zziqh = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zzb extends zzejz<zzb, zza> implements zzell {
        private static volatile zzelw<zzb> zzel;
        private static final zzb zzirj;
        private int zzbzr;
        private int zzdw;
        private int zziqu;
        private C0114zzb zziqx;
        private zzf zzira;
        private boolean zzirb;
        private boolean zzire;
        private boolean zzirf;
        private zzi zzirg;
        private byte zziqh = 2;
        private String zziqk = "";
        private String zziqv = "";
        private String zziqw = "";
        private zzekk<zzh> zziqy = zzejz.zzbgk();
        private String zziqz = "";
        private zzekk<String> zzirc = zzejz.zzbgk();
        private String zzird = "";
        private zzeip zziqd = zzeip.zzier;
        private zzekk<String> zzirh = zzejz.zzbgk();
        private zzekk<String> zziri = zzejz.zzbgk();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public static final class zza extends zzejz.zzb<zzb, zza> implements zzell {
            private zza() {
                super(zzb.zzirj);
            }

            public final String getUrl() {
                return ((zzb) this.zzijh).getUrl();
            }

            public final zza zza(zzg zzgVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzb) this.zzijh).zzb(zzgVar);
                return this;
            }

            public final List<zzh> zzbji() {
                return Collections.unmodifiableList(((zzb) this.zzijh).zzbji());
            }

            public final String zzbjj() {
                return ((zzb) this.zzijh).zzbjj();
            }

            public final zza zzbjk() {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzb) this.zzijh).zzbjl();
                return this;
            }

            public final zza zzhy(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzb) this.zzijh).setUrl(str);
                return this;
            }

            public final zza zzhz(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzb) this.zzijh).zzib(str);
                return this;
            }

            public final zza zzia(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzb) this.zzijh).zzea(str);
                return this;
            }

            public final zza zzm(Iterable<String> iterable) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzb) this.zzijh).zzo(iterable);
                return this;
            }

            public final zza zzn(Iterable<String> iterable) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzb) this.zzijh).zzp(iterable);
                return this;
            }

            /* synthetic */ zza(zzenv zzenvVar) {
                this();
            }

            public final zza zza(C0114zzb c0114zzb) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzb) this.zzijh).zzb(c0114zzb);
                return this;
            }

            public final zza zza(zzh zzhVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzb) this.zzijh).zzb(zzhVar);
                return this;
            }

            public final zza zza(zzf zzfVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzb) this.zzijh).zzb(zzfVar);
                return this;
            }

            public final zza zza(zzi zziVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzb) this.zzijh).zzb(zziVar);
                return this;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public static final class zze extends zzejz<zze, zza> implements zzell {
            private static volatile zzelw<zze> zzel;
            private static final zze zzisa;
            private int zzdw;
            private byte zziqh = 2;
            private zzekk<zzc> zzirp = zzejz.zzbgk();
            private zzeip zzirq;
            private zzeip zzirr;
            private int zzirs;
            private C0116zzb zziry;
            private zzeip zzirz;

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public static final class zza extends zzejz.zzb<zze, zza> implements zzell {
                private zza() {
                    super(zze.zzisa);
                }

                /* synthetic */ zza(zzenv zzenvVar) {
                    this();
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzent$zzb$zze$zzb, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public static final class C0116zzb extends zzejz<C0116zzb, zza> implements zzell {
                private static volatile zzelw<C0116zzb> zzel;
                private static final C0116zzb zzisd;
                private int zzdw;
                private zzeip zzirw;
                private int zzisb;
                private zzeip zzisc;

                /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzent$zzb$zze$zzb$zza */
                /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
                public static final class zza extends zzejz.zzb<C0116zzb, zza> implements zzell {
                    private zza() {
                        super(C0116zzb.zzisd);
                    }

                    /* synthetic */ zza(zzenv zzenvVar) {
                        this();
                    }
                }

                static {
                    C0116zzb c0116zzb = new C0116zzb();
                    zzisd = c0116zzb;
                    zzejz.zza((Class<C0116zzb>) C0116zzb.class, c0116zzb);
                }

                private C0116zzb() {
                    zzeip zzeipVar = zzeip.zzier;
                    this.zzisc = zzeipVar;
                    this.zzirw = zzeipVar;
                }

                @Override // com.google.android.gms.internal.ads.zzejz
                protected final Object zza(int i, Object obj, Object obj2) {
                    zzenv zzenvVar = null;
                    switch (zzenv.zzdv[i - 1]) {
                        case 1:
                            return new C0116zzb();
                        case 2:
                            return new zza(zzenvVar);
                        case 3:
                            return zzejz.zza(zzisd, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdw", "zzisb", "zzisc", "zzirw"});
                        case 4:
                            return zzisd;
                        case 5:
                            zzelw<C0116zzb> zzaVar = zzel;
                            if (zzaVar == null) {
                                synchronized (C0116zzb.class) {
                                    zzaVar = zzel;
                                    if (zzaVar == null) {
                                        zzaVar = new zzejz.zza<>(zzisd);
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

            static {
                zze zzeVar = new zze();
                zzisa = zzeVar;
                zzejz.zza((Class<zze>) zze.class, zzeVar);
            }

            private zze() {
                zzeip zzeipVar = zzeip.zzier;
                this.zzirq = zzeipVar;
                this.zzirr = zzeipVar;
                this.zzirz = zzeipVar;
            }

            @Override // com.google.android.gms.internal.ads.zzejz
            protected final Object zza(int i, Object obj, Object obj2) {
                zzenv zzenvVar = null;
                switch (zzenv.zzdv[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza(zzenvVar);
                    case 3:
                        return zzejz.zza(zzisa, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzdw", "zziry", "zzirp", zzc.class, "zzirq", "zzirr", "zzirs", "zzirz"});
                    case 4:
                        return zzisa;
                    case 5:
                        zzelw<zze> zzaVar = zzel;
                        if (zzaVar == null) {
                            synchronized (zze.class) {
                                zzaVar = zzel;
                                if (zzaVar == null) {
                                    zzaVar = new zzejz.zza<>(zzisa);
                                    zzel = zzaVar;
                                }
                                break;
                            }
                        }
                        return zzaVar;
                    case 6:
                        return Byte.valueOf(this.zziqh);
                    case 7:
                        this.zziqh = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public enum zzg implements zzeke {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);

            private static final zzekd<zzg> zzes = new zzeob();
            private final int value;

            zzg(int i) {
                this.value = i;
            }

            public static zzg zzhv(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzekg zzw() {
                return zzeoa.zzeu;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzg.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.ads.zzeke
            public final int zzv() {
                return this.value;
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzirj = zzbVar;
            zzejz.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setUrl(String str) {
            str.getClass();
            this.zzdw |= 4;
            this.zziqk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzg zzgVar) {
            this.zzbzr = zzgVar.zzv();
            this.zzdw |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbjl() {
            this.zzdw &= -65;
            this.zziqz = zzirj.zziqz;
        }

        public static zza zzbjm() {
            return zzirj.zzbgf();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzea(String str) {
            str.getClass();
            this.zzdw |= 64;
            this.zziqz = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzib(String str) {
            str.getClass();
            this.zzdw |= 8;
            this.zziqv = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo(Iterable<String> iterable) {
            zzekk<String> zzekkVar = this.zzirh;
            if (!zzekkVar.zzbeb()) {
                this.zzirh = zzejz.zza(zzekkVar);
            }
            zzeif.zza(iterable, this.zzirh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(Iterable<String> iterable) {
            zzekk<String> zzekkVar = this.zziri;
            if (!zzekkVar.zzbeb()) {
                this.zziri = zzejz.zza(zzekkVar);
            }
            zzeif.zza(iterable, this.zziri);
        }

        public final String getUrl() {
            return this.zziqk;
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzenv zzenvVar = null;
            switch (zzenv.zzdv[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzenvVar);
                case 3:
                    return zzejz.zza(zzirj, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zzdw", "zziqk", "zziqv", "zziqw", "zziqy", zzh.class, "zzirb", "zzirc", "zzird", "zzire", "zzirf", "zzbzr", zzg.zzw(), "zziqu", zza.zzc.zzw(), "zziqx", "zziqz", "zzira", "zziqd", "zzirg", "zzirh", "zziri"});
                case 4:
                    return zzirj;
                case 5:
                    zzelw<zzb> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zzb.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzirj);
                                zzel = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
                case 6:
                    return Byte.valueOf(this.zziqh);
                case 7:
                    this.zziqh = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final List<zzh> zzbji() {
            return this.zziqy;
        }

        public final String zzbjj() {
            return this.zziqz;
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public static final class zzh extends zzejz<zzh, C0118zzb> implements zzell {
            private static volatile zzelw<zzh> zzel;
            private static final zzh zziti;
            private int zzdw;
            private int zzita;
            private zzd zzitb;
            private zze zzitc;
            private int zzitd;
            private int zzitg;
            private byte zziqh = 2;
            private String zziqk = "";
            private zzekf zzite = zzejz.zzbgi();
            private String zzitf = "";
            private zzekk<String> zzith = zzejz.zzbgk();

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public enum zza implements zzeke {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);

                private static final zzekd<zza> zzes = new zzeod();
                private final int value;

                zza(int i) {
                    this.value = i;
                }

                public static zza zzhw(int i) {
                    if (i == 0) {
                        return AD_RESOURCE_UNKNOWN;
                    }
                    if (i == 1) {
                        return AD_RESOURCE_CREATIVE;
                    }
                    if (i == 2) {
                        return AD_RESOURCE_POST_CLICK;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                }

                public static zzekg zzw() {
                    return zzeoc.zzeu;
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

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzent$zzb$zzh$zzb, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public static final class C0118zzb extends zzejz.zzb<zzh, C0118zzb> implements zzell {
                private C0118zzb() {
                    super(zzh.zziti);
                }

                public final C0118zzb zzb(zzd zzdVar) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzh) this.zzijh).zza(zzdVar);
                    return this;
                }

                public final C0118zzb zzhx(int i) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzh) this.zzijh).setId(i);
                    return this;
                }

                public final C0118zzb zzih(String str) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzh) this.zzijh).setUrl(str);
                    return this;
                }

                public final C0118zzb zzii(String str) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzh) this.zzijh).zzif(str);
                    return this;
                }

                /* synthetic */ C0118zzb(zzenv zzenvVar) {
                    this();
                }

                public final C0118zzb zzb(zza zzaVar) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzh) this.zzijh).zza(zzaVar);
                    return this;
                }
            }

            static {
                zzh zzhVar = new zzh();
                zziti = zzhVar;
                zzejz.zza((Class<zzh>) zzh.class, zzhVar);
            }

            private zzh() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void setId(int i) {
                this.zzdw |= 1;
                this.zzita = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void setUrl(String str) {
                str.getClass();
                this.zzdw |= 2;
                this.zziqk = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzd zzdVar) {
                zzdVar.getClass();
                this.zzitb = zzdVar;
                this.zzdw |= 4;
            }

            public static C0118zzb zzbka() {
                return zziti.zzbgf();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzif(String str) {
                str.getClass();
                zzekk<String> zzekkVar = this.zzith;
                if (!zzekkVar.zzbeb()) {
                    this.zzith = zzejz.zza(zzekkVar);
                }
                this.zzith.add(str);
            }

            public final String getUrl() {
                return this.zziqk;
            }

            public final int zzbjz() {
                return this.zzith.size();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zza zzaVar) {
                this.zzitg = zzaVar.zzv();
                this.zzdw |= 64;
            }

            @Override // com.google.android.gms.internal.ads.zzejz
            protected final Object zza(int i, Object obj, Object obj2) {
                zzenv zzenvVar = null;
                switch (zzenv.zzdv[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C0118zzb(zzenvVar);
                    case 3:
                        return zzejz.zza(zziti, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zzdw", "zzita", "zziqk", "zzitb", "zzitc", "zzitd", "zzite", "zzitf", "zzitg", zza.zzw(), "zzith"});
                    case 4:
                        return zziti;
                    case 5:
                        zzelw<zzh> zzaVar = zzel;
                        if (zzaVar == null) {
                            synchronized (zzh.class) {
                                zzaVar = zzel;
                                if (zzaVar == null) {
                                    zzaVar = new zzejz.zza<>(zziti);
                                    zzel = zzaVar;
                                }
                                break;
                            }
                        }
                        return zzaVar;
                    case 6:
                        return Byte.valueOf(this.zziqh);
                    case 7:
                        this.zziqh = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(C0114zzb c0114zzb) {
            c0114zzb.getClass();
            this.zziqx = c0114zzb;
            this.zzdw |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzh zzhVar) {
            zzhVar.getClass();
            zzekk<zzh> zzekkVar = this.zziqy;
            if (!zzekkVar.zzbeb()) {
                this.zziqy = zzejz.zza(zzekkVar);
            }
            this.zziqy.add(zzhVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzf zzfVar) {
            zzfVar.getClass();
            this.zzira = zzfVar;
            this.zzdw |= 128;
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzent$zzb$zzb, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public static final class C0114zzb extends zzejz<C0114zzb, zza> implements zzell {
            private static volatile zzelw<C0114zzb> zzel;
            private static final C0114zzb zzirl;
            private int zzdw;
            private String zzirk = "";

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzent$zzb$zzb$zza */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public static final class zza extends zzejz.zzb<C0114zzb, zza> implements zzell {
                private zza() {
                    super(C0114zzb.zzirl);
                }

                public final zza zzic(String str) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((C0114zzb) this.zzijh).zzid(str);
                    return this;
                }

                /* synthetic */ zza(zzenv zzenvVar) {
                    this();
                }
            }

            static {
                C0114zzb c0114zzb = new C0114zzb();
                zzirl = c0114zzb;
                zzejz.zza((Class<C0114zzb>) C0114zzb.class, c0114zzb);
            }

            private C0114zzb() {
            }

            public static zza zzbjo() {
                return zzirl.zzbgf();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzid(String str) {
                str.getClass();
                this.zzdw |= 1;
                this.zzirk = str;
            }

            @Override // com.google.android.gms.internal.ads.zzejz
            protected final Object zza(int i, Object obj, Object obj2) {
                zzenv zzenvVar = null;
                switch (zzenv.zzdv[i - 1]) {
                    case 1:
                        return new C0114zzb();
                    case 2:
                        return new zza(zzenvVar);
                    case 3:
                        return zzejz.zza(zzirl, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdw", "zzirk"});
                    case 4:
                        return zzirl;
                    case 5:
                        zzelw<C0114zzb> zzaVar = zzel;
                        if (zzaVar == null) {
                            synchronized (C0114zzb.class) {
                                zzaVar = zzel;
                                if (zzaVar == null) {
                                    zzaVar = new zzejz.zza<>(zzirl);
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
        public static final class zzi extends zzejz<zzi, zza> implements zzell {
            private static volatile zzelw<zzi> zzel;
            private static final zzi zzitm;
            private int zzdw;
            private String zzitj = "";
            private long zzitk;
            private boolean zzitl;

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public static final class zza extends zzejz.zzb<zzi, zza> implements zzell {
                private zza() {
                    super(zzi.zzitm);
                }

                public final zza zzbx(boolean z) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzi) this.zzijh).zzbw(z);
                    return this;
                }

                public final zza zzfu(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzi) this.zzijh).zzft(j);
                    return this;
                }

                public final zza zzij(String str) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzi) this.zzijh).zzig(str);
                    return this;
                }

                /* synthetic */ zza(zzenv zzenvVar) {
                    this();
                }
            }

            static {
                zzi zziVar = new zzi();
                zzitm = zziVar;
                zzejz.zza((Class<zzi>) zzi.class, zziVar);
            }

            private zzi() {
            }

            public static zza zzbkc() {
                return zzitm.zzbgf();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbw(boolean z) {
                this.zzdw |= 4;
                this.zzitl = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzft(long j) {
                this.zzdw |= 2;
                this.zzitk = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzig(String str) {
                str.getClass();
                this.zzdw |= 1;
                this.zzitj = str;
            }

            @Override // com.google.android.gms.internal.ads.zzejz
            protected final Object zza(int i, Object obj, Object obj2) {
                zzenv zzenvVar = null;
                switch (zzenv.zzdv[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(zzenvVar);
                    case 3:
                        return zzejz.zza(zzitm, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zzdw", "zzitj", "zzitk", "zzitl"});
                    case 4:
                        return zzitm;
                    case 5:
                        zzelw<zzi> zzaVar = zzel;
                        if (zzaVar == null) {
                            synchronized (zzi.class) {
                                zzaVar = zzel;
                                if (zzaVar == null) {
                                    zzaVar = new zzejz.zza<>(zzitm);
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzi zziVar) {
            zziVar.getClass();
            this.zzirg = zziVar;
            this.zzdw |= 8192;
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public static final class zzc extends zzejz<zzc, zza> implements zzell {
            private static volatile zzelw<zzc> zzel;
            private static final zzc zzirn;
            private int zzdw;
            private zzeip zzhzi;
            private byte zziqh = 2;
            private zzeip zzirm;

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public static final class zza extends zzejz.zzb<zzc, zza> implements zzell {
                private zza() {
                    super(zzc.zzirn);
                }

                public final zza zzan(zzeip zzeipVar) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzc) this.zzijh).zzap(zzeipVar);
                    return this;
                }

                public final zza zzao(zzeip zzeipVar) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzc) this.zzijh).zzae(zzeipVar);
                    return this;
                }

                /* synthetic */ zza(zzenv zzenvVar) {
                    this();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zzirn = zzcVar;
                zzejz.zza((Class<zzc>) zzc.class, zzcVar);
            }

            private zzc() {
                zzeip zzeipVar = zzeip.zzier;
                this.zzirm = zzeipVar;
                this.zzhzi = zzeipVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzae(zzeip zzeipVar) {
                zzeipVar.getClass();
                this.zzdw |= 2;
                this.zzhzi = zzeipVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzap(zzeip zzeipVar) {
                zzeipVar.getClass();
                this.zzdw |= 1;
                this.zzirm = zzeipVar;
            }

            public static zza zzbjq() {
                return zzirn.zzbgf();
            }

            @Override // com.google.android.gms.internal.ads.zzejz
            protected final Object zza(int i, Object obj, Object obj2) {
                zzenv zzenvVar = null;
                switch (zzenv.zzdv[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(zzenvVar);
                    case 3:
                        return zzejz.zza(zzirn, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzdw", "zzirm", "zzhzi"});
                    case 4:
                        return zzirn;
                    case 5:
                        zzelw<zzc> zzaVar = zzel;
                        if (zzaVar == null) {
                            synchronized (zzc.class) {
                                zzaVar = zzel;
                                if (zzaVar == null) {
                                    zzaVar = new zzejz.zza<>(zzirn);
                                    zzel = zzaVar;
                                }
                                break;
                            }
                        }
                        return zzaVar;
                    case 6:
                        return Byte.valueOf(this.zziqh);
                    case 7:
                        this.zziqh = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public static final class zzd extends zzejz<zzd, zza> implements zzell {
            private static volatile zzelw<zzd> zzel;
            private static final zzd zzirt;
            private int zzdw;
            private C0115zzb zziro;
            private zzeip zzirq;
            private zzeip zzirr;
            private int zzirs;
            private byte zziqh = 2;
            private zzekk<zzc> zzirp = zzejz.zzbgk();

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public static final class zza extends zzejz.zzb<zzd, zza> implements zzell {
                private zza() {
                    super(zzd.zzirt);
                }

                public final zza zza(zzc zzcVar) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzd) this.zzijh).zzb(zzcVar);
                    return this;
                }

                /* synthetic */ zza(zzenv zzenvVar) {
                    this();
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzent$zzb$zzd$zzb, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public static final class C0115zzb extends zzejz<C0115zzb, zza> implements zzell {
                private static volatile zzelw<C0115zzb> zzel;
                private static final C0115zzb zzirx;
                private int zzdw;
                private zzeip zziru;
                private zzeip zzirv;
                private zzeip zzirw;

                /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzent$zzb$zzd$zzb$zza */
                /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
                public static final class zza extends zzejz.zzb<C0115zzb, zza> implements zzell {
                    private zza() {
                        super(C0115zzb.zzirx);
                    }

                    /* synthetic */ zza(zzenv zzenvVar) {
                        this();
                    }
                }

                static {
                    C0115zzb c0115zzb = new C0115zzb();
                    zzirx = c0115zzb;
                    zzejz.zza((Class<C0115zzb>) C0115zzb.class, c0115zzb);
                }

                private C0115zzb() {
                    zzeip zzeipVar = zzeip.zzier;
                    this.zziru = zzeipVar;
                    this.zzirv = zzeipVar;
                    this.zzirw = zzeipVar;
                }

                @Override // com.google.android.gms.internal.ads.zzejz
                protected final Object zza(int i, Object obj, Object obj2) {
                    zzenv zzenvVar = null;
                    switch (zzenv.zzdv[i - 1]) {
                        case 1:
                            return new C0115zzb();
                        case 2:
                            return new zza(zzenvVar);
                        case 3:
                            return zzejz.zza(zzirx, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdw", "zziru", "zzirv", "zzirw"});
                        case 4:
                            return zzirx;
                        case 5:
                            zzelw<C0115zzb> zzaVar = zzel;
                            if (zzaVar == null) {
                                synchronized (C0115zzb.class) {
                                    zzaVar = zzel;
                                    if (zzaVar == null) {
                                        zzaVar = new zzejz.zza<>(zzirx);
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

            static {
                zzd zzdVar = new zzd();
                zzirt = zzdVar;
                zzejz.zza((Class<zzd>) zzd.class, zzdVar);
            }

            private zzd() {
                zzeip zzeipVar = zzeip.zzier;
                this.zzirq = zzeipVar;
                this.zzirr = zzeipVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzb(zzc zzcVar) {
                zzcVar.getClass();
                zzekk<zzc> zzekkVar = this.zzirp;
                if (!zzekkVar.zzbeb()) {
                    this.zzirp = zzejz.zza(zzekkVar);
                }
                this.zzirp.add(zzcVar);
            }

            public static zza zzbjs() {
                return zzirt.zzbgf();
            }

            @Override // com.google.android.gms.internal.ads.zzejz
            protected final Object zza(int i, Object obj, Object obj2) {
                zzenv zzenvVar = null;
                switch (zzenv.zzdv[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(zzenvVar);
                    case 3:
                        return zzejz.zza(zzirt, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzdw", "zziro", "zzirp", zzc.class, "zzirq", "zzirr", "zzirs"});
                    case 4:
                        return zzirt;
                    case 5:
                        zzelw<zzd> zzaVar = zzel;
                        if (zzaVar == null) {
                            synchronized (zzd.class) {
                                zzaVar = zzel;
                                if (zzaVar == null) {
                                    zzaVar = new zzejz.zza<>(zzirt);
                                    zzel = zzaVar;
                                }
                                break;
                            }
                        }
                        return zzaVar;
                    case 6:
                        return Byte.valueOf(this.zziqh);
                    case 7:
                        this.zziqh = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
        public static final class zzf extends zzejz<zzf, zza> implements zzell {
            private static volatile zzelw<zzf> zzel;
            private static final zzf zzisg;
            private int zzbzr;
            private int zzdw;
            private String zzise = "";
            private zzeip zzisf = zzeip.zzier;

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public static final class zza extends zzejz.zzb<zzf, zza> implements zzell {
                private zza() {
                    super(zzf.zzisg);
                }

                public final zza zza(EnumC0117zzb enumC0117zzb) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzf) this.zzijh).zzb(enumC0117zzb);
                    return this;
                }

                public final zza zzaq(zzeip zzeipVar) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzf) this.zzijh).zzar(zzeipVar);
                    return this;
                }

                public final zza zzie(String str) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzf) this.zzijh).setMimeType(str);
                    return this;
                }

                /* synthetic */ zza(zzenv zzenvVar) {
                    this();
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzent$zzb$zzf$zzb, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
            public enum EnumC0117zzb implements zzeke {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);

                private static final zzekd<EnumC0117zzb> zzes = new zzeny();
                private final int value;

                EnumC0117zzb(int i) {
                    this.value = i;
                }

                public static EnumC0117zzb zzhu(int i) {
                    if (i == 0) {
                        return TYPE_UNKNOWN;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return TYPE_CREATIVE;
                }

                public static zzekg zzw() {
                    return zzenz.zzeu;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + EnumC0117zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
                }

                @Override // com.google.android.gms.internal.ads.zzeke
                public final int zzv() {
                    return this.value;
                }
            }

            static {
                zzf zzfVar = new zzf();
                zzisg = zzfVar;
                zzejz.zza((Class<zzf>) zzf.class, zzfVar);
            }

            private zzf() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void setMimeType(String str) {
                str.getClass();
                this.zzdw |= 2;
                this.zzise = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzar(zzeip zzeipVar) {
                zzeipVar.getClass();
                this.zzdw |= 4;
                this.zzisf = zzeipVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzb(EnumC0117zzb enumC0117zzb) {
                this.zzbzr = enumC0117zzb.zzv();
                this.zzdw |= 1;
            }

            public static zza zzbjx() {
                return zzisg.zzbgf();
            }

            @Override // com.google.android.gms.internal.ads.zzejz
            protected final Object zza(int i, Object obj, Object obj2) {
                zzenv zzenvVar = null;
                switch (zzenv.zzdv[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new zza(zzenvVar);
                    case 3:
                        return zzejz.zza(zzisg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zzdw", "zzbzr", EnumC0117zzb.zzw(), "zzise", "zzisf"});
                    case 4:
                        return zzisg;
                    case 5:
                        zzelw<zzf> zzaVar = zzel;
                        if (zzaVar == null) {
                            synchronized (zzf.class) {
                                zzaVar = zzel;
                                if (zzaVar == null) {
                                    zzaVar = new zzejz.zza<>(zzisg);
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
    }
}
