package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzegk implements zzdzv {
    private static final ThreadLocal<Cipher> zzibk = new zzegj();
    private final SecretKey zzibo;

    public zzegk(byte[] bArr) throws GeneralSecurityException {
        zzeht.zzfp(bArr.length);
        this.zzibo = new SecretKeySpec(bArr, "AES");
    }

    private static AlgorithmParameterSpec zzf(byte[] bArr, int i, int i2) throws GeneralSecurityException {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, 0, i2);
        } catch (ClassNotFoundException unused) {
            if (zzehu.zzbdt()) {
                return new IvParameterSpec(bArr, 0, i2);
            }
            throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzv
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 12 + 16];
        byte[] bArrZzfo = zzehs.zzfo(12);
        System.arraycopy(bArrZzfo, 0, bArr3, 0, 12);
        zzibk.get().init(1, this.zzibo, zzf(bArrZzfo, 0, bArrZzfo.length));
        if (bArr2 != null && bArr2.length != 0) {
            zzibk.get().updateAAD(bArr2);
        }
        int iDoFinal = zzibk.get().doFinal(bArr, 0, bArr.length, bArr3, 12);
        if (iDoFinal == bArr.length + 16) {
            return bArr3;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(iDoFinal - bArr.length)));
    }
}
