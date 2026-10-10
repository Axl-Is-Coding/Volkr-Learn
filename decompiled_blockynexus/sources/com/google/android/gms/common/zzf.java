package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzf extends zzd {
    private static final WeakReference<byte[]> zzb = new WeakReference<>(null);
    private WeakReference<byte[]> zza;

    zzf(byte[] bArr) {
        super(bArr);
        this.zza = zzb;
    }

    @Override // com.google.android.gms.common.zzd
    final byte[] zza() {
        byte[] bArrZzd;
        synchronized (this) {
            bArrZzd = this.zza.get();
            if (bArrZzd == null) {
                bArrZzd = zzd();
                this.zza = new WeakReference<>(bArrZzd);
            }
        }
        return bArrZzd;
    }

    protected abstract byte[] zzd();
}
