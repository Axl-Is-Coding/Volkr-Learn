package com.tendcloud.tenddata;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f20070a = "RC4/ECB/NoPadding";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f20071b = "ARCFOUR";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20072c = "r5czusfu0wjcaz4pp01v2k7qte55xc25fngq4ylby2civ230vdy6uy6goz9w4kgfqjk31l8khfzfvbxj7emcprjyy8nngf0r9dvxzwbhm2uw7ljre52jt95lg0knyp8e5c4go44s3z5ciy58h0tuosmwhupa62rdnkeicgdba6w6f0kenp0xac7so8j1vdbjpqwyprx2ouenv22isustwnpltt9ui5plnijd4bq4013o3mzdkllozn26zwds9x38";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f20073d = f20072c.getBytes();

    public static byte[] a(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(f20070a);
        cipher.init(1, new SecretKeySpec(f20073d, f20071b));
        return cipher.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(f20070a);
        cipher.init(1, new SecretKeySpec(str.getBytes(), f20071b));
        return cipher.doFinal(bArr);
    }
}
