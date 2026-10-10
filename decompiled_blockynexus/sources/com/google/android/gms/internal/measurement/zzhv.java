package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzhv {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb = new int[zzil.values().length];

    static {
        try {
            zzb[zzil.BYTE_STRING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzb[zzil.MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzb[zzil.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        zza = new int[zzhu.values().length];
        try {
            zza[zzhu.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zza[zzhu.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zza[zzhu.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
