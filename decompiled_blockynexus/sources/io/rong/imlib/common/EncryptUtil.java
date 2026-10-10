package io.rong.imlib.common;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import io.rong.common.rlog.RLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class EncryptUtil {
    private static final String TAG = "EncryptUtil";
    private static EncryptUtil instance;
    private String key;

    private EncryptUtil(Context context) {
        String appSignatureSHA1NoSign = SignatureUtils.getAppSignatureSHA1NoSign(context);
        if (TextUtils.isEmpty(appSignatureSHA1NoSign) || appSignatureSHA1NoSign.length() < 16) {
            appSignatureSHA1NoSign = getAndroidId(context) + "#$ERDTS$D%F^Gojikbh";
        }
        String strSHA = SHA(appSignatureSHA1NoSign);
        if (strSHA != null) {
            this.key = strSHA.substring(0, 16);
        } else {
            RLog.e(TAG, "key is null");
        }
    }

    private String SHA(String str) {
        if (str != null && str.length() > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(str.getBytes());
                byte[] bArrDigest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : bArrDigest) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() == 1) {
                        stringBuffer.append('0');
                    }
                    stringBuffer.append(hexString);
                }
                return stringBuffer.toString();
            } catch (NoSuchAlgorithmException e2) {
                RLog.e(TAG, "SHA", e2);
            }
        }
        return null;
    }

    private String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static synchronized EncryptUtil getInstance(Context context) {
        if (instance == null) {
            instance = new EncryptUtil(context);
        }
        return instance;
    }

    public String decrypt(String str) {
        if (str == null) {
            return null;
        }
        if (this.key == null) {
            RLog.e(TAG, "key is null");
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(this.key.getBytes(), "AES"));
            return new String(cipher.doFinal(bArrDecode));
        } catch (Exception e2) {
            RLog.e(TAG, "decrypt", e2);
            return null;
        }
    }

    public String encrypt(String str) {
        if (str == null) {
            return null;
        }
        if (this.key == null) {
            RLog.e(TAG, "key is null");
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(this.key.getBytes(), "AES"));
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 2);
        } catch (Exception e2) {
            RLog.e(TAG, "encrypt", e2);
            return null;
        }
    }
}
