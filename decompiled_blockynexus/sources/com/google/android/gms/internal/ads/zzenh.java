package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzenh {
    zzenh() {
    }

    abstract int zzb(int i, byte[] bArr, int i2, int i3);

    abstract int zzb(CharSequence charSequence, byte[] bArr, int i, int i2);

    final boolean zzm(byte[] bArr, int i, int i2) {
        return zzb(0, bArr, i, i2) == 0;
    }

    abstract String zzo(byte[] bArr, int i, int i2) throws zzekj;
}
