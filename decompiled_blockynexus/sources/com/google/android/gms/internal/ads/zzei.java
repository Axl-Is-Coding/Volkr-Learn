package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzei {
    private static Cipher zzye;
    private static final Object zzyf = new Object();
    private static final Object zzyg = new Object();
    private final SecureRandom zzyd = null;

    public zzei(SecureRandom secureRandom) {
    }

    private static Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher;
        synchronized (zzyg) {
            if (zzye == null) {
                zzye = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = zzye;
        }
        return cipher;
    }

    public final byte[] zza(byte[] bArr, String str) throws zzeh {
        byte[] bArrDoFinal;
        if (bArr.length != 16) {
            throw new zzeh(this);
        }
        try {
            byte[] bArrZzb = zzcv.zzb(str, false);
            if (bArrZzb.length <= 16) {
                throw new zzeh(this);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrZzb.length);
            byteBufferAllocate.put(bArrZzb);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArrZzb.length - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzyf) {
                getCipher().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                bArrDoFinal = getCipher().doFinal(bArr3);
            }
            return bArrDoFinal;
        } catch (IllegalArgumentException e2) {
            throw new zzeh(this, e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new zzeh(this, e3);
        } catch (InvalidKeyException e4) {
            throw new zzeh(this, e4);
        } catch (NoSuchAlgorithmException e5) {
            throw new zzeh(this, e5);
        } catch (BadPaddingException e6) {
            throw new zzeh(this, e6);
        } catch (IllegalBlockSizeException e7) {
            throw new zzeh(this, e7);
        } catch (NoSuchPaddingException e8) {
            throw new zzeh(this, e8);
        }
    }

    public final byte[] zzap(String str) throws zzeh {
        try {
            byte[] bArrZzb = zzcv.zzb(str, false);
            if (bArrZzb.length != 32) {
                throw new zzeh(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(bArrZzb, 4, 16).get(bArr);
            for (int i = 0; i < 16; i++) {
                bArr[i] = (byte) (bArr[i] ^ 68);
            }
            return bArr;
        } catch (IllegalArgumentException e2) {
            throw new zzeh(this, e2);
        }
    }

    public final String zzb(byte[] bArr, byte[] bArr2) throws zzeh {
        byte[] bArrDoFinal;
        byte[] iv;
        if (bArr.length != 16) {
            throw new zzeh(this);
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzyf) {
                getCipher().init(1, secretKeySpec, (SecureRandom) null);
                bArrDoFinal = getCipher().doFinal(bArr2);
                iv = getCipher().getIV();
            }
            int length = bArrDoFinal.length + iv.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
            byteBufferAllocate.put(iv).put(bArrDoFinal);
            byteBufferAllocate.flip();
            byte[] bArr3 = new byte[length];
            byteBufferAllocate.get(bArr3);
            return zzcv.zza(bArr3, false);
        } catch (InvalidKeyException e2) {
            throw new zzeh(this, e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new zzeh(this, e3);
        } catch (BadPaddingException e4) {
            throw new zzeh(this, e4);
        } catch (IllegalBlockSizeException e5) {
            throw new zzeh(this, e5);
        } catch (NoSuchPaddingException e6) {
            throw new zzeh(this, e6);
        }
    }
}
