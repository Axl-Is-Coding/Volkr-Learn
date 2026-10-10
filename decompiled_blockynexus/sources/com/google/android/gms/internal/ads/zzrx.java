package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzrx extends zzrq {
    private MessageDigest zzbug;
    private final int zzbuh;
    private final int zzbui;

    public zzrx(int i) {
        int i2 = i / 8;
        this.zzbuh = i % 8 > 0 ? i2 + 1 : i2;
        this.zzbui = i;
    }

    @Override // com.google.android.gms.internal.ads.zzrq
    public final byte[] zzbu(String str) {
        synchronized (this.mLock) {
            this.zzbug = zzms();
            if (this.zzbug == null) {
                return new byte[0];
            }
            this.zzbug.reset();
            this.zzbug.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] bArrDigest = this.zzbug.digest();
            byte[] bArr = new byte[bArrDigest.length > this.zzbuh ? this.zzbuh : bArrDigest.length];
            System.arraycopy(bArrDigest, 0, bArr, 0, bArr.length);
            if (this.zzbui % 8 > 0) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    if (i > 0) {
                        j <<= 8;
                    }
                    j += (long) (bArr[i] & 255);
                }
                long j2 = j >>> (8 - (this.zzbui % 8));
                for (int i2 = this.zzbuh - 1; i2 >= 0; i2--) {
                    bArr[i2] = (byte) (255 & j2);
                    j2 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
