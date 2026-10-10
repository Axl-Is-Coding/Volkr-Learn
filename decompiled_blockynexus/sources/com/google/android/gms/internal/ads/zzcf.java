package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import io.grpc.internal.GrpcUtil;
import io.rong.common.dlog.DLog;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcf {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zza extends zzejz<zza, C0108zza> implements zzell {
        private static volatile zzelw<zza> zzel;
        private static final zza zzik;
        private int zzdw;
        private int zzfn;
        private int zzfo;
        private long zzfq;
        private long zzfr;
        private long zzfs;
        private long zzft;
        private long zzfu;
        private long zzfv;
        private long zzfw;
        private long zzfx;
        private long zzfy;
        private long zzfz;
        private long zzgb;
        private long zzgc;
        private long zzgd;
        private long zzge;
        private long zzgf;
        private long zzgg;
        private long zzgh;
        private long zzgi;
        private long zzgj;
        private long zzgm;
        private long zzgn;
        private long zzgo;
        private long zzgp;
        private zzb zzgs;
        private zze zzhi;
        private zzf zzhk;
        private int zzhv;
        private int zzhw;
        private int zzhx;
        private zze zzhy;
        private long zzid;
        private boolean zzig;
        private long zzii;
        private zzd zzij;
        private String zzfp = "";
        private String zzeg = "";
        private String zzga = "";
        private String zzfg = "";
        private String zzgk = "D";
        private String zzgl = "";
        private String zzfi = "";
        private long zzgq = -1;
        private long zzgr = -1;
        private long zzgt = -1;
        private long zzgu = -1;
        private long zzgv = -1;
        private long zzgw = -1;
        private long zzgx = -1;
        private long zzgy = -1;
        private String zzfj = "D";
        private String zzfk = "D";
        private long zzgz = -1;
        private int zzha = 1000;
        private int zzhb = 1000;
        private long zzhc = -1;
        private long zzhd = -1;
        private long zzhe = -1;
        private long zzhf = -1;
        private long zzhg = -1;
        private int zzhh = 1000;
        private zzekk<zze> zzhj = zzejz.zzbgk();
        private long zzhl = -1;
        private long zzhm = -1;
        private long zzhn = -1;
        private long zzho = -1;
        private long zzhp = -1;
        private long zzhq = -1;
        private long zzhr = -1;
        private long zzhs = -1;
        private String zzht = "D";
        private long zzhu = -1;
        private long zzhz = -1;
        private int zzia = 1000;
        private int zzib = 1000;
        private String zzic = "D";
        private String zzie = "";
        private int zzif = 2;
        private String zzih = "";

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzcf$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class C0108zza extends zzejz.zzb<zza, C0108zza> implements zzell {
            private C0108zza() {
                super(zza.zzik);
            }

            public final C0108zza zza(zzcn zzcnVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzf(zzcnVar);
                return this;
            }

            public final C0108zza zzaa(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbh(j);
                return this;
            }

            public final C0108zza zzab(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbi(j);
                return this;
            }

            public final C0108zza zzac(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbj(j);
                return this;
            }

            public final C0108zza zzad(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbk(j);
                return this;
            }

            public final C0108zza zzae(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbl(j);
                return this;
            }

            public final C0108zza zzaf(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbm(j);
                return this;
            }

            public final C0108zza zzag(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbn(j);
                return this;
            }

            public final C0108zza zzah(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbo(j);
                return this;
            }

            public final C0108zza zzai() {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzak();
                return this;
            }

            public final C0108zza zzaj(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbq(j);
                return this;
            }

            public final C0108zza zzak(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbr(j);
                return this;
            }

            public final C0108zza zzb(zzcn zzcnVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzg(zzcnVar);
                return this;
            }

            public final C0108zza zzc(zzcn zzcnVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzh(zzcnVar);
                return this;
            }

            public final C0108zza zzd(zzcn zzcnVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzi(zzcnVar);
                return this;
            }

            public final C0108zza zze(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzal(j);
                return this;
            }

            public final C0108zza zzf(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzam(j);
                return this;
            }

            public final C0108zza zzg(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzan(j);
                return this;
            }

            public final C0108zza zzh(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzao(j);
                return this;
            }

            public final C0108zza zzi(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzap(j);
                return this;
            }

            public final C0108zza zzj(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzaq(j);
                return this;
            }

            public final C0108zza zzk(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzar(j);
                return this;
            }

            public final C0108zza zzl(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzas(j);
                return this;
            }

            public final C0108zza zzm(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzat(j);
                return this;
            }

            public final C0108zza zzn(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzau(j);
                return this;
            }

            public final C0108zza zzo(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzav(j);
                return this;
            }

            public final C0108zza zzp(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzaw(j);
                return this;
            }

            public final C0108zza zzq(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzax(j);
                return this;
            }

            public final C0108zza zzr(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzay(j);
                return this;
            }

            public final C0108zza zzs(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzaz(j);
                return this;
            }

            public final C0108zza zzt(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzba(j);
                return this;
            }

            public final C0108zza zzu(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzad(str);
                return this;
            }

            public final C0108zza zzv(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzae(str);
                return this;
            }

            public final C0108zza zzw(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzaf(str);
                return this;
            }

            public final C0108zza zzx(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzag(str);
                return this;
            }

            public final C0108zza zzy(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzah(str);
                return this;
            }

            public final C0108zza zzz(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbg(j);
                return this;
            }

            /* synthetic */ C0108zza(zzce zzceVar) {
                this();
            }

            public final C0108zza zza(zze zzeVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzc(zzeVar);
                return this;
            }

            public final C0108zza zzaa(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzaj(str);
                return this;
            }

            public final C0108zza zzab(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzak(str);
                return this;
            }

            public final C0108zza zzac(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzal(str);
                return this;
            }

            public final C0108zza zzai(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbp(j);
                return this;
            }

            public final C0108zza zzb(zze zzeVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzd(zzeVar);
                return this;
            }

            public final C0108zza zze(zzcn zzcnVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzj(zzcnVar);
                return this;
            }

            @Deprecated
            public final C0108zza zzu(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbb(j);
                return this;
            }

            public final C0108zza zzv(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbc(j);
                return this;
            }

            public final C0108zza zzw(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbd(j);
                return this;
            }

            public final C0108zza zzx(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbe(j);
                return this;
            }

            public final C0108zza zzy(long j) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzbf(j);
                return this;
            }

            public final C0108zza zzz(String str) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzai(str);
                return this;
            }

            public final C0108zza zza(zzf zzfVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzb(zzfVar);
                return this;
            }

            public final C0108zza zza(zzc zzcVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzb(zzcVar);
                return this;
            }

            public final C0108zza zza(boolean z) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zza) this.zzijh).zzb(z);
                return this;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public enum zzb implements zzeke {
            DEBUGGER_STATE_UNSPECIFIED(0),
            DEBUGGER_STATE_NOT_INSTALLED(1),
            DEBUGGER_STATE_INSTALLED(2),
            DEBUGGER_STATE_ACTIVE(3),
            DEBUGGER_STATE_ENVVAR(4),
            DEBUGGER_STATE_MACHPORT(5),
            DEBUGGER_STATE_ENVVAR_MACHPORT(6);

            private static final zzekd<zzb> zzes = new zzcg();
            private final int value;

            zzb(int i) {
                this.value = i;
            }

            public static zzb zzk(int i) {
                switch (i) {
                    case 0:
                        return DEBUGGER_STATE_UNSPECIFIED;
                    case 1:
                        return DEBUGGER_STATE_NOT_INSTALLED;
                    case 2:
                        return DEBUGGER_STATE_INSTALLED;
                    case 3:
                        return DEBUGGER_STATE_ACTIVE;
                    case 4:
                        return DEBUGGER_STATE_ENVVAR;
                    case 5:
                        return DEBUGGER_STATE_MACHPORT;
                    case 6:
                        return DEBUGGER_STATE_ENVVAR_MACHPORT;
                    default:
                        return null;
                }
            }

            public static zzekg zzw() {
                return zzch.zzeu;
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

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public enum zzc implements zzeke {
            DEVICE_IDENTIFIER_NO_ID(0),
            DEVICE_IDENTIFIER_APP_SPECIFIC_ID(1),
            DEVICE_IDENTIFIER_GLOBAL_ID(2),
            DEVICE_IDENTIFIER_ADVERTISER_ID(3),
            DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED(4),
            DEVICE_IDENTIFIER_ANDROID_AD_ID(5),
            DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID(6);

            private static final zzekd<zzc> zzes = new zzcj();
            private final int value;

            zzc(int i) {
                this.value = i;
            }

            public static zzc zzl(int i) {
                switch (i) {
                    case 0:
                        return DEVICE_IDENTIFIER_NO_ID;
                    case 1:
                        return DEVICE_IDENTIFIER_APP_SPECIFIC_ID;
                    case 2:
                        return DEVICE_IDENTIFIER_GLOBAL_ID;
                    case 3:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID;
                    case 4:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED;
                    case 5:
                        return DEVICE_IDENTIFIER_ANDROID_AD_ID;
                    case 6:
                        return DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID;
                    default:
                        return null;
                }
            }

            public static zzekg zzw() {
                return zzci.zzeu;
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

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public enum zzd implements zzeke {
            ERROR_ENCODE_SIZE_FAIL(1),
            ERROR_UNKNOWN(3),
            ERROR_NO_SIGNALS(5),
            ERROR_ENCRYPTION(7),
            ERROR_MEMORY(9),
            ERROR_SIMULATOR(11),
            ERROR_SERVICE(13),
            ERROR_THREAD(15),
            PSN_WEB64_FAIL(2),
            PSN_DECRYPT_SIZE_FAIL(4),
            PSN_MD5_CHECK_FAIL(8),
            PSN_MD5_SIZE_FAIL(16),
            PSN_MD5_FAIL(32),
            PSN_DECODE_FAIL(64),
            PSN_SALT_FAIL(128),
            PSN_BITSLICER_FAIL(256),
            PSN_REQUEST_TYPE_FAIL(512),
            PSN_INVALID_ERROR_CODE(1024),
            PSN_TIMESTAMP_EXPIRED(DLog.CRS),
            PSN_ENCODE_SIZE_FAIL(4096),
            PSN_BLANK_VALUE(8192),
            PSN_INITIALIZATION_FAIL(16384),
            PSN_GASS_CLIENT_FAIL(32768),
            PSN_SIGNALS_TIMEOUT(65536),
            PSN_TINK_FAIL(131072);

            private static final zzekd<zzd> zzes = new zzck();
            private final int value;

            zzd(int i) {
                this.value = i;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.ads.zzeke
            public final int zzv() {
                return this.value;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class zze extends zzejz<zze, C0109zza> implements zzell {
            private static volatile zzelw<zze> zzel;
            private static final zze zzku;
            private int zzdw;
            private long zzko;
            private long zzkp;
            private long zzgb = -1;
            private long zzgc = -1;
            private long zzkb = -1;
            private long zzkc = -1;
            private long zzkd = -1;
            private long zzke = -1;
            private int zzkf = 1000;
            private long zzkg = -1;
            private long zzkh = -1;
            private long zzki = -1;
            private int zzkj = 1000;
            private long zzkk = -1;
            private long zzkl = -1;
            private long zzkm = -1;
            private long zzkn = -1;
            private long zzkq = -1;
            private long zzkr = -1;
            private long zzks = -1;
            private long zzkt = -1;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzcf$zza$zze$zza, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
            public static final class C0109zza extends zzejz.zzb<zze, C0109zza> implements zzell {
                private C0109zza() {
                    super(zze.zzku);
                }

                public final C0109zza zzat() {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzau();
                    return this;
                }

                public final C0109zza zzbs(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzaq(j);
                    return this;
                }

                public final C0109zza zzbt(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzar(j);
                    return this;
                }

                public final C0109zza zzbu(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcj(j);
                    return this;
                }

                public final C0109zza zzbv(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzck(j);
                    return this;
                }

                public final C0109zza zzbw(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcl(j);
                    return this;
                }

                public final C0109zza zzbx(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcm(j);
                    return this;
                }

                public final C0109zza zzby(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcn(j);
                    return this;
                }

                public final C0109zza zzbz(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzco(j);
                    return this;
                }

                public final C0109zza zzca(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcp(j);
                    return this;
                }

                public final C0109zza zzcb(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcq(j);
                    return this;
                }

                public final C0109zza zzcc(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcr(j);
                    return this;
                }

                public final C0109zza zzcd(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcs(j);
                    return this;
                }

                public final C0109zza zzce(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzct(j);
                    return this;
                }

                public final C0109zza zzcf(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcu(j);
                    return this;
                }

                public final C0109zza zzcg(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcv(j);
                    return this;
                }

                public final C0109zza zzch(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcw(j);
                    return this;
                }

                public final C0109zza zzci(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzcx(j);
                    return this;
                }

                public final C0109zza zzk(zzcn zzcnVar) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzm(zzcnVar);
                    return this;
                }

                public final C0109zza zzl(zzcn zzcnVar) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zze) this.zzijh).zzn(zzcnVar);
                    return this;
                }

                /* synthetic */ C0109zza(zzce zzceVar) {
                    this();
                }
            }

            static {
                zze zzeVar = new zze();
                zzku = zzeVar;
                zzejz.zza((Class<zze>) zze.class, zzeVar);
            }

            private zze() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzaq(long j) {
                this.zzdw |= 1;
                this.zzgb = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzar(long j) {
                this.zzdw |= 2;
                this.zzgc = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzau() {
                this.zzdw &= -9;
                this.zzkc = -1L;
            }

            public static C0109zza zzav() {
                return zzku.zzbgf();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcj(long j) {
                this.zzdw |= 4;
                this.zzkb = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzck(long j) {
                this.zzdw |= 8;
                this.zzkc = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcl(long j) {
                this.zzdw |= 16;
                this.zzkd = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcm(long j) {
                this.zzdw |= 32;
                this.zzke = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcn(long j) {
                this.zzdw |= 128;
                this.zzkg = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzco(long j) {
                this.zzdw |= 256;
                this.zzkh = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcp(long j) {
                this.zzdw |= 512;
                this.zzki = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcq(long j) {
                this.zzdw |= DLog.CRS;
                this.zzkk = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcr(long j) {
                this.zzdw |= 4096;
                this.zzkl = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcs(long j) {
                this.zzdw |= 8192;
                this.zzkm = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzct(long j) {
                this.zzdw |= 16384;
                this.zzkn = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcu(long j) {
                this.zzdw |= 32768;
                this.zzko = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcv(long j) {
                this.zzdw |= 65536;
                this.zzkp = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcw(long j) {
                this.zzdw |= 131072;
                this.zzkq = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcx(long j) {
                this.zzdw |= 262144;
                this.zzkr = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzm(zzcn zzcnVar) {
                this.zzkf = zzcnVar.zzv();
                this.zzdw |= 64;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzn(zzcn zzcnVar) {
                this.zzkj = zzcnVar.zzv();
                this.zzdw |= 1024;
            }

            @Override // com.google.android.gms.internal.ads.zzejz
            protected final Object zza(int i, Object obj, Object obj2) {
                zzce zzceVar = null;
                switch (zzce.zzdv[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C0109zza(zzceVar);
                    case 3:
                        return zzejz.zza(zzku, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzdw", "zzgb", "zzgc", "zzkb", "zzkc", "zzkd", "zzke", "zzkf", zzcn.zzw(), "zzkg", "zzkh", "zzki", "zzkj", zzcn.zzw(), "zzkk", "zzkl", "zzkm", "zzkn", "zzko", "zzkp", "zzkq", "zzkr", "zzks", "zzkt"});
                    case 4:
                        return zzku;
                    case 5:
                        zzelw<zze> zzaVar = zzel;
                        if (zzaVar == null) {
                            synchronized (zze.class) {
                                zzaVar = zzel;
                                if (zzaVar == null) {
                                    zzaVar = new zzejz.zza<>(zzku);
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
            zza zzaVar = new zza();
            zzik = zzaVar;
            zzejz.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public static zza zza(byte[] bArr, zzejm zzejmVar) throws zzekj {
            return (zza) zzejz.zza(zzik, bArr, zzejmVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzad(String str) {
            str.getClass();
            this.zzdw |= 1;
            this.zzfp = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzae(String str) {
            str.getClass();
            this.zzdw |= 2;
            this.zzeg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzag(String str) {
            str.getClass();
            this.zzdw |= 16777216;
            this.zzgl = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzah(String str) {
            str.getClass();
            this.zzdw |= 268435456;
            this.zzfi = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzai(String str) {
            str.getClass();
            this.zzfn |= 128;
            this.zzfj = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzak() {
            this.zzhj = zzejz.zzbgk();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzal(long j) {
            this.zzdw |= 4;
            this.zzfq = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzam(long j) {
            this.zzdw |= 16;
            this.zzfs = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzan(long j) {
            this.zzdw |= 32;
            this.zzft = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzao(long j) {
            this.zzdw |= 1024;
            this.zzfy = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzap(long j) {
            this.zzdw |= DLog.CRS;
            this.zzfz = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaq(long j) {
            this.zzdw |= 8192;
            this.zzgb = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzar(long j) {
            this.zzdw |= 16384;
            this.zzgc = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzas(long j) {
            this.zzdw |= 32768;
            this.zzgd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzat(long j) {
            this.zzdw |= 65536;
            this.zzge = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzau(long j) {
            this.zzdw |= 524288;
            this.zzgh = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzav(long j) {
            this.zzdw |= 1048576;
            this.zzgi = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaw(long j) {
            this.zzdw |= 2097152;
            this.zzgj = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzax(long j) {
            this.zzdw |= 33554432;
            this.zzgm = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzay(long j) {
            this.zzdw |= 67108864;
            this.zzgn = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaz(long j) {
            this.zzdw |= 134217728;
            this.zzgo = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzf zzfVar) {
            zzfVar.getClass();
            this.zzhk = zzfVar;
            this.zzfn |= 524288;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzba(long j) {
            this.zzdw |= 536870912;
            this.zzgp = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbb(long j) {
            this.zzdw |= FileTypeUtils.GIGABYTE;
            this.zzgq = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbc(long j) {
            this.zzdw |= Integer.MIN_VALUE;
            this.zzgr = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbd(long j) {
            this.zzfn |= 2;
            this.zzgt = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbe(long j) {
            this.zzfn |= 4;
            this.zzgu = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbf(long j) {
            this.zzfn |= 8;
            this.zzgv = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbg(long j) {
            this.zzfn |= 16;
            this.zzgw = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbh(long j) {
            this.zzfn |= 32;
            this.zzgx = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbi(long j) {
            this.zzfn |= 64;
            this.zzgy = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbj(long j) {
            this.zzfn |= 4096;
            this.zzhc = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbk(long j) {
            this.zzfn |= 8192;
            this.zzhd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbl(long j) {
            this.zzfn |= 16384;
            this.zzhe = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbm(long j) {
            this.zzfn |= 2097152;
            this.zzhm = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbn(long j) {
            this.zzfn |= GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            this.zzhn = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbo(long j) {
            this.zzfn |= 8388608;
            this.zzho = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbp(long j) {
            this.zzfn |= 67108864;
            this.zzhr = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbq(long j) {
            this.zzfn |= 134217728;
            this.zzhs = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbr(long j) {
            this.zzfo |= DLog.CRS;
            this.zzii = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zze zzeVar) {
            zzeVar.getClass();
            this.zzhi = zzeVar;
            this.zzfn |= 262144;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(zze zzeVar) {
            zzeVar.getClass();
            zzekk<zze> zzekkVar = this.zzhj;
            if (!zzekkVar.zzbeb()) {
                this.zzhj = zzejz.zza(zzekkVar);
            }
            this.zzhj.add(zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(zzcn zzcnVar) {
            this.zzha = zzcnVar.zzv();
            this.zzfn |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(zzcn zzcnVar) {
            this.zzhb = zzcnVar.zzv();
            this.zzfn |= DLog.CRS;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(zzcn zzcnVar) {
            this.zzhh = zzcnVar.zzv();
            this.zzfn |= 131072;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(zzcn zzcnVar) {
            this.zzia = zzcnVar.zzv();
            this.zzfo |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(zzcn zzcnVar) {
            this.zzib = zzcnVar.zzv();
            this.zzfo |= 16;
        }

        public final String zzaf() {
            return this.zzfg;
        }

        public final boolean zzaj() {
            return (this.zzdw & GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaf(String str) {
            str.getClass();
            this.zzdw |= GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            this.zzfg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaj(String str) {
            str.getClass();
            this.zzfn |= 256;
            this.zzfk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzak(String str) {
            str.getClass();
            this.zzfn |= 268435456;
            this.zzht = str;
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzce zzceVar = null;
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0108zza(zzceVar);
                case 3:
                    return zzejz.zza(zzik, "\u0001N\u0000\u0003\u0001ÉN\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂF\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈG\u0019ဂK\u001aဌH\u001bဈ\u0016\u001cဇI\u001dဈ\u0018\u001eဈJ\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0ဌ*1ဌ+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08ဌ19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=Aဌ>Bဌ?Cဈ<Dဌ@EဉAFဂBGဂ8Hဂ9IဌCJဂ)Kဈ\u0017LဌDMဈEÉဉL", new Object[]{"zzdw", "zzfn", "zzfo", "zzfp", "zzeg", "zzfq", "zzfr", "zzfs", "zzft", "zzfu", "zzfv", "zzfw", "zzfx", "zzfy", "zzfz", "zzga", "zzgb", "zzgc", "zzgd", "zzge", "zzgf", "zzgg", "zzgh", "zzid", "zzgi", "zzgj", "zzie", "zzii", "zzif", zzc.zzw(), "zzfg", "zzig", "zzgl", "zzih", "zzgm", "zzgn", "zzgo", "zzfi", "zzgp", "zzgq", "zzgr", "zzgs", "zzgt", "zzgu", "zzgv", "zzgw", "zzhj", zze.class, "zzgx", "zzgy", "zzfj", "zzfk", "zzha", zzcn.zzw(), "zzhb", zzcn.zzw(), "zzhi", "zzhc", "zzhd", "zzhe", "zzhf", "zzhg", "zzhh", zzcn.zzw(), "zzhk", "zzhl", "zzhm", "zzhn", "zzho", "zzhr", "zzhs", "zzhu", "zzhv", zzcm.zzw(), "zzhw", zzcs.zzw(), "zzht", "zzhx", zzb.zzw(), "zzhy", "zzhz", "zzhp", "zzhq", "zzia", zzcn.zzw(), "zzgz", "zzgk", "zzib", zzcn.zzw(), "zzic", "zzij"});
                case 4:
                    return zzik;
                case 5:
                    zzelw<zza> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzik);
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

        public static C0108zza zzaq() {
            return zzik.zzbgf();
        }

        public static zza zzar() {
            return zzik;
        }

        public final String zzal() {
            return this.zzie;
        }

        public final zzc zzam() {
            zzc zzcVarZzl = zzc.zzl(this.zzif);
            return zzcVarZzl == null ? zzc.DEVICE_IDENTIFIER_GLOBAL_ID : zzcVarZzl;
        }

        public final boolean zzan() {
            return this.zzig;
        }

        public final boolean zzao() {
            return (this.zzfo & 4096) != 0;
        }

        public final zzd zzap() {
            zzd zzdVar = this.zzij;
            return zzdVar == null ? zzd.zzbi() : zzdVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzal(String str) {
            str.getClass();
            this.zzfo |= 128;
            this.zzie = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzc zzcVar) {
            this.zzif = zzcVar.zzv();
            this.zzfo |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzfo |= 512;
            this.zzig = z;
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class zzf extends zzejz<zzf, C0110zza> implements zzell {
            private static volatile zzelw<zzf> zzel;
            private static final zzf zzkz;
            private int zzdw;
            private long zzhf = -1;
            private long zzhg = -1;
            private long zzkv = -1;
            private long zzkw = -1;
            private long zzkx = -1;
            private long zzky = -1;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzcf$zza$zzf$zza, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
            public static final class C0110zza extends zzejz.zzb<zzf, C0110zza> implements zzell {
                private C0110zza() {
                    super(zzf.zzkz);
                }

                public final C0110zza zzcy(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzf) this.zzijh).zzdc(j);
                    return this;
                }

                public final C0110zza zzcz(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzf) this.zzijh).zzdd(j);
                    return this;
                }

                public final C0110zza zzda(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzf) this.zzijh).zzde(j);
                    return this;
                }

                public final C0110zza zzdb(long j) {
                    if (this.zziji) {
                        zzbgp();
                        this.zziji = false;
                    }
                    ((zzf) this.zzijh).zzdf(j);
                    return this;
                }

                /* synthetic */ C0110zza(zzce zzceVar) {
                    this();
                }
            }

            static {
                zzf zzfVar = new zzf();
                zzkz = zzfVar;
                zzejz.zza((Class<zzf>) zzf.class, zzfVar);
            }

            private zzf() {
            }

            public static C0110zza zzax() {
                return zzkz.zzbgf();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzdc(long j) {
                this.zzdw |= 4;
                this.zzkv = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzdd(long j) {
                this.zzdw |= 8;
                this.zzkw = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzde(long j) {
                this.zzdw |= 16;
                this.zzkx = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzdf(long j) {
                this.zzdw |= 32;
                this.zzky = j;
            }

            @Override // com.google.android.gms.internal.ads.zzejz
            protected final Object zza(int i, Object obj, Object obj2) {
                zzce zzceVar = null;
                switch (zzce.zzdv[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0110zza(zzceVar);
                    case 3:
                        return zzejz.zza(zzkz, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zzdw", "zzhf", "zzhg", "zzkv", "zzkw", "zzkx", "zzky"});
                    case 4:
                        return zzkz;
                    case 5:
                        zzelw<zzf> zzaVar = zzel;
                        if (zzaVar == null) {
                            synchronized (zzf.class) {
                                zzaVar = zzel;
                                if (zzaVar == null) {
                                    zzaVar = new zzejz.zza<>(zzkz);
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zzb extends zzejz<zzb, zza> implements zzell {
        private static volatile zzelw<zzb> zzel;
        private static final zzb zzlf;
        private int zzdw;
        private long zzla;
        private int zzlb;
        private boolean zzlc;
        private zzekf zzld = zzejz.zzbgi();
        private long zzle;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class zza extends zzejz.zzb<zzb, zza> implements zzell {
            private zza() {
                super(zzb.zzlf);
            }

            /* synthetic */ zza(zzce zzceVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzlf = zzbVar;
            zzejz.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzce zzceVar = null;
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzceVar);
                case 3:
                    return zzejz.zza(zzlf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003", new Object[]{"zzdw", "zzla", "zzlb", "zzlc", "zzld", "zzle"});
                case 4:
                    return zzlf;
                case 5:
                    zzelw<zzb> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zzb.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzlf);
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
    public static final class zzc extends zzejz<zzc, zza> implements zzell {
        private static volatile zzelw<zzc> zzel;
        private static final zzc zzlk;
        private int zzdw;
        private zzeip zzlg;
        private zzeip zzlh;
        private zzeip zzli;
        private zzeip zzlj;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class zza extends zzejz.zzb<zzc, zza> implements zzell {
            private zza() {
                super(zzc.zzlk);
            }

            public final zza zza(zzeip zzeipVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzc) this.zzijh).zze(zzeipVar);
                return this;
            }

            public final zza zzb(zzeip zzeipVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzc) this.zzijh).zzf(zzeipVar);
                return this;
            }

            public final zza zzc(zzeip zzeipVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzc) this.zzijh).zzg(zzeipVar);
                return this;
            }

            public final zza zzd(zzeip zzeipVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzc) this.zzijh).zzh(zzeipVar);
                return this;
            }

            /* synthetic */ zza(zzce zzceVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzlk = zzcVar;
            zzejz.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
            zzeip zzeipVar = zzeip.zzier;
            this.zzlg = zzeipVar;
            this.zzlh = zzeipVar;
            this.zzli = zzeipVar;
            this.zzlj = zzeipVar;
        }

        public static zzc zzb(byte[] bArr, zzejm zzejmVar) throws zzekj {
            return (zzc) zzejz.zza(zzlk, bArr, zzejmVar);
        }

        public static zza zzbe() {
            return zzlk.zzbgf();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(zzeip zzeipVar) {
            zzeipVar.getClass();
            this.zzdw |= 1;
            this.zzlg = zzeipVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(zzeip zzeipVar) {
            zzeipVar.getClass();
            this.zzdw |= 2;
            this.zzlh = zzeipVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(zzeip zzeipVar) {
            zzeipVar.getClass();
            this.zzdw |= 4;
            this.zzli = zzeipVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(zzeip zzeipVar) {
            zzeipVar.getClass();
            this.zzdw |= 8;
            this.zzlj = zzeipVar;
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzce zzceVar = null;
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzceVar);
                case 3:
                    return zzejz.zza(zzlk, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzdw", "zzlg", "zzlh", "zzli", "zzlj"});
                case 4:
                    return zzlk;
                case 5:
                    zzelw<zzc> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zzc.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzlk);
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

        public final zzeip zzba() {
            return this.zzlg;
        }

        public final zzeip zzbb() {
            return this.zzlh;
        }

        public final zzeip zzbc() {
            return this.zzli;
        }

        public final zzeip zzbd() {
            return this.zzlj;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zzd extends zzejz<zzd, zza> implements zzell {
        private static volatile zzelw<zzd> zzel;
        private static final zzd zzme;
        private int zzdw;
        private long zzla;
        private String zzmc = "";
        private zzeip zzmd = zzeip.zzier;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class zza extends zzejz.zzb<zzd, zza> implements zzell {
            private zza() {
                super(zzd.zzme);
            }

            /* synthetic */ zza(zzce zzceVar) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzme = zzdVar;
            zzejz.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        public static zzd zzbi() {
            return zzme;
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzce zzceVar = null;
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzceVar);
                case 3:
                    return zzejz.zza(zzme, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzdw", "zzla", "zzmc", "zzmd"});
                case 4:
                    return zzme;
                case 5:
                    zzelw<zzd> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zzd.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzme);
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

        public final boolean zzbg() {
            return (this.zzdw & 1) != 0;
        }

        public final long zzbh() {
            return this.zzla;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
    public static final class zze extends zzejz<zze, zza> implements zzell {
        private static volatile zzelw<zze> zzel;
        private static final zze zzmf;
        private int zzdw;
        private String zzfl = "";

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class zza extends zzejz.zzb<zze, zza> implements zzell {
            private zza() {
                super(zze.zzmf);
            }

            /* synthetic */ zza(zzce zzceVar) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zzmf = zzeVar;
            zzejz.zza((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzce zzceVar = null;
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzceVar);
                case 3:
                    return zzejz.zza(zzmf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdw", "zzfl"});
                case 4:
                    return zzmf;
                case 5:
                    zzelw<zze> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zze.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzmf);
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
    public static final class zzf extends zzejz<zzf, zza> implements zzell {
        private static volatile zzelw<zzf> zzel;
        private static final zzf zzmh;
        private int zzdw;
        private zzekk<zzeip> zzmg = zzejz.zzbgk();
        private zzeip zzlh = zzeip.zzier;
        private int zzhw = 1;
        private int zzhv = 1;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
        public static final class zza extends zzejz.zzb<zzf, zza> implements zzell {
            private zza() {
                super(zzf.zzmh);
            }

            public final zza zzb(zzcm zzcmVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzf) this.zzijh).zza(zzcmVar);
                return this;
            }

            public final zza zzj(zzeip zzeipVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzf) this.zzijh).zzi(zzeipVar);
                return this;
            }

            public final zza zzk(zzeip zzeipVar) {
                if (this.zziji) {
                    zzbgp();
                    this.zziji = false;
                }
                ((zzf) this.zzijh).zzf(zzeipVar);
                return this;
            }

            /* synthetic */ zza(zzce zzceVar) {
                this();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzmh = zzfVar;
            zzejz.zza((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzcm zzcmVar) {
            this.zzhv = zzcmVar.zzv();
            this.zzdw |= 4;
        }

        public static zza zzbl() {
            return zzmh.zzbgf();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(zzeip zzeipVar) {
            zzeipVar.getClass();
            this.zzdw |= 1;
            this.zzlh = zzeipVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(zzeip zzeipVar) {
            zzeipVar.getClass();
            zzekk<zzeip> zzekkVar = this.zzmg;
            if (!zzekkVar.zzbeb()) {
                this.zzmg = zzejz.zza(zzekkVar);
            }
            this.zzmg.add(zzeipVar);
        }

        @Override // com.google.android.gms.internal.ads.zzejz
        protected final Object zza(int i, Object obj, Object obj2) {
            zzce zzceVar = null;
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzceVar);
                case 3:
                    return zzejz.zza(zzmh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zzdw", "zzmg", "zzlh", "zzhw", zzcs.zzw(), "zzhv", zzcm.zzw()});
                case 4:
                    return zzmh;
                case 5:
                    zzelw<zzf> zzaVar = zzel;
                    if (zzaVar == null) {
                        synchronized (zzf.class) {
                            zzaVar = zzel;
                            if (zzaVar == null) {
                                zzaVar = new zzejz.zza<>(zzmh);
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
