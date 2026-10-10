package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.utils.ab;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: AES.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(bArrDecode));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a() {
        String strE = ab.e();
        if (strE == null || strE.length() != 16) {
            return null;
        }
        return strE;
    }

    public static String a(String str) {
        if (str == null || str.length() != 16) {
            return null;
        }
        return str.concat(str).substring(8, 24);
    }
}
