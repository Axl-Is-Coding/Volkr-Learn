package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzrt extends zzrq {
    private MessageDigest zzbug;

    @Override // com.google.android.gms.internal.ads.zzrq
    public final byte[] zzbu(String str) {
        byte[] bArrArray;
        String[] strArrSplit = str.split(" ");
        int length = 4;
        if (strArrSplit.length == 1) {
            int iZzbv = zzru.zzbv(strArrSplit[0]);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate.putInt(iZzbv);
            bArrArray = byteBufferAllocate.array();
        } else if (strArrSplit.length < 5) {
            bArrArray = new byte[strArrSplit.length << 1];
            for (int i = 0; i < strArrSplit.length; i++) {
                int iZzbv2 = zzru.zzbv(strArrSplit[i]);
                int i2 = (iZzbv2 >> 16) ^ (65535 & iZzbv2);
                byte[] bArr = {(byte) i2, (byte) (i2 >> 8)};
                int i3 = i << 1;
                bArrArray[i3] = bArr[0];
                bArrArray[i3 + 1] = bArr[1];
            }
        } else {
            bArrArray = new byte[strArrSplit.length];
            for (int i4 = 0; i4 < strArrSplit.length; i4++) {
                int iZzbv3 = zzru.zzbv(strArrSplit[i4]);
                bArrArray[i4] = (byte) ((iZzbv3 >> 24) ^ (((iZzbv3 & 255) ^ ((iZzbv3 >> 8) & 255)) ^ ((iZzbv3 >> 16) & 255)));
            }
        }
        this.zzbug = zzms();
        synchronized (this.mLock) {
            if (this.zzbug == null) {
                return new byte[0];
            }
            this.zzbug.reset();
            this.zzbug.update(bArrArray);
            byte[] bArrDigest = this.zzbug.digest();
            if (bArrDigest.length <= 4) {
                length = bArrDigest.length;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArrDigest, 0, bArr2, 0, bArr2.length);
            return bArr2;
        }
    }
}
