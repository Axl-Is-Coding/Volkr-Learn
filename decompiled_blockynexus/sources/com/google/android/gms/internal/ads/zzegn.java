package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzegn implements zzehl {
    private static final int[] zzibx = zzr(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    int[] zziby;
    private final int zzibz;

    zzegn(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zziby = zzr(bArr);
        this.zzibz = i;
    }

    private static int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    static void zzc(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            zza(iArr, 0, 4, 8, 12);
            zza(iArr, 1, 5, 9, 13);
            zza(iArr, 2, 6, 10, 14);
            zza(iArr, 3, 7, 11, 15);
            zza(iArr, 0, 5, 10, 15);
            zza(iArr, 1, 6, 11, 12);
            zza(iArr, 2, 7, 8, 13);
            zza(iArr, 3, 4, 9, 14);
        }
    }

    private static int[] zzr(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }

    final void zza(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - zzbdn() < bArr.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        byte[] bArrZzfo = zzehs.zzfo(zzbdn());
        byteBuffer.put(bArrZzfo);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        int iRemaining = byteBufferWrap.remaining();
        int i = (iRemaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBufferZze = zze(bArrZzfo, this.zzibz + i2);
            if (i2 == i - 1) {
                zzegl.zza(byteBuffer, byteBufferWrap, byteBufferZze, iRemaining % 64);
            } else {
                zzegl.zza(byteBuffer, byteBufferWrap, byteBufferZze, 64);
            }
        }
    }

    abstract int[] zzb(int[] iArr, int i);

    abstract int zzbdn();

    final ByteBuffer zze(byte[] bArr, int i) {
        int[] iArrZzb = zzb(zzr(bArr), i);
        int[] iArr = (int[]) iArrZzb.clone();
        zzc(iArr);
        for (int i2 = 0; i2 < iArrZzb.length; i2++) {
            iArrZzb[i2] = iArrZzb[i2] + iArr[i2];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrZzb, 0, 16);
        return byteBufferOrder;
    }

    @Override // com.google.android.gms.internal.ads.zzehl
    public final byte[] zzo(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > Integer.MAX_VALUE - zzbdn()) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(zzbdn() + bArr.length);
        zza(byteBufferAllocate, bArr);
        return byteBufferAllocate.array();
    }

    static void zza(int[] iArr, int[] iArr2) {
        int[] iArr3 = zzibx;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, zzibx.length, 8);
    }

    private static void zza(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = rotateLeft(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = rotateLeft(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = rotateLeft(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = rotateLeft(iArr[i2] ^ iArr[i3], 7);
    }
}
