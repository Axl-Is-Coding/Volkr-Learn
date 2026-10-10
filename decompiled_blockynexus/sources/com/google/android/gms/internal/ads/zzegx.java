package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzegx {
    static final /* synthetic */ int[] zzicm;
    static final /* synthetic */ int[] zzicn = new int[zzeha.values().length];

    static {
        try {
            zzicn[zzeha.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzicn[zzeha.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzicn[zzeha.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        zzicm = new int[zzegz.values().length];
        try {
            zzicm[zzegz.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zzicm[zzegz.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zzicm[zzegz.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
