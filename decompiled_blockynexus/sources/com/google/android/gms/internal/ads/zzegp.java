package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzegp implements zzdzv {
    private final zzegn zzica;
    private final zzegn zzicb;

    public zzegp(byte[] bArr) throws InvalidKeyException {
        this.zzica = zzf(bArr, 1);
        this.zzicb = zzf(bArr, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzdzv
    public byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > (Integer.MAX_VALUE - this.zzica.zzbdn()) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + this.zzica.zzbdn() + 16);
        if (byteBufferAllocate.remaining() < bArr.length + this.zzica.zzbdn() + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int iPosition = byteBufferAllocate.position();
        this.zzica.zza(byteBufferAllocate, bArr);
        byteBufferAllocate.position(iPosition);
        byte[] bArr3 = new byte[this.zzica.zzbdn()];
        byteBufferAllocate.get(bArr3);
        byteBufferAllocate.limit(byteBufferAllocate.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr4 = new byte[32];
        this.zzicb.zze(bArr3, 0).get(bArr4);
        int length = bArr2.length % 16 == 0 ? bArr2.length : (bArr2.length + 16) - (bArr2.length % 16);
        int iRemaining = byteBufferAllocate.remaining();
        int i = iRemaining % 16;
        int i2 = (i == 0 ? iRemaining : (iRemaining + 16) - i) + length;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(bArr2);
        byteBufferOrder.position(length);
        byteBufferOrder.put(byteBufferAllocate);
        byteBufferOrder.position(i2);
        byteBufferOrder.putLong(bArr2.length);
        byteBufferOrder.putLong(iRemaining);
        byte[] bArrZze = zzeho.zze(bArr4, byteBufferOrder.array());
        byteBufferAllocate.limit(byteBufferAllocate.limit() + 16);
        byteBufferAllocate.put(bArrZze);
        return byteBufferAllocate.array();
    }

    abstract zzegn zzf(byte[] bArr, int i) throws InvalidKeyException;
}
