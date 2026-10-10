package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzecm {
    static final /* synthetic */ int[] zzhwk;
    static final /* synthetic */ int[] zzhwl;
    static final /* synthetic */ int[] zzhwm = new int[zzeec.values().length];

    static {
        try {
            zzhwm[zzeec.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzhwm[zzeec.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzhwm[zzeec.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        zzhwl = new int[zzeeq.values().length];
        try {
            zzhwl[zzeeq.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zzhwl[zzeeq.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zzhwl[zzeeq.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        zzhwk = new int[zzeer.values().length];
        try {
            zzhwk[zzeer.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            zzhwk[zzeer.SHA256.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            zzhwk[zzeer.SHA512.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
