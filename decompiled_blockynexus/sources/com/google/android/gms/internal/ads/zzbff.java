package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbff extends zzbm {
    static final zzbff zzelj = new zzbff();

    zzbff() {
    }

    @Override // com.google.android.gms.internal.ads.zzbm
    public final zzbp zza(String str, byte[] bArr, String str2) {
        return "moov".equals(str) ? new zzbr() : "mvhd".equals(str) ? new zzbu() : new zzbt(str);
    }
}
