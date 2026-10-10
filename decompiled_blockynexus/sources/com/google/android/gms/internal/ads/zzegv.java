package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzegv {
    private final zzehm zzicj;
    private final zzehm zzick;

    public zzegv(byte[] bArr, byte[] bArr2) {
        this.zzicj = zzehm.zzs(bArr);
        this.zzick = zzehm.zzs(bArr2);
    }

    public final byte[] zzbdo() {
        zzehm zzehmVar = this.zzicj;
        if (zzehmVar == null) {
            return null;
        }
        return zzehmVar.getBytes();
    }

    public final byte[] zzbdp() {
        zzehm zzehmVar = this.zzick;
        if (zzehmVar == null) {
            return null;
        }
        return zzehmVar.getBytes();
    }
}
