package io.rong.imlib;

import com.sandboxol.center.config.VipSubscribeStatus;
import com.umeng.analytics.pro.ci;
import io.rong.common.RLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public class MD5 {
    private static final String TAG = "MD5";
    private static final String[] strDigits = {"0", "1", "2", "3", VipSubscribeStatus.SUBSCRIPTION_PURCHASED, VipSubscribeStatus.SUBSCRIPTION_ON_HOLD, VipSubscribeStatus.SUBSCRIPTION_IN_GRACE_PERIOD, VipSubscribeStatus.SUBSCRIPTION_RESTARTED, VipSubscribeStatus.SUBSCRIPTION_PRICE_CHANGE_CONFIRMED, VipSubscribeStatus.SUBSCRIPTION_DEFERRED, "A", "B", "C", "D", "E", "F"};

    private static String byteToArrayString(byte b2) {
        int i = b2;
        if (b2 < 0) {
            i = b2 + ci.f20834a;
        }
        return strDigits[i / 16] + strDigits[i % 16];
    }

    private static String byteToString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(byteToArrayString(b2));
        }
        return stringBuffer.toString();
    }

    public static String encrypt(String str) {
        try {
            return byteToString(MessageDigest.getInstance(TAG).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            RLog.e(TAG, "encrypt", e2);
            return str;
        }
    }

    public static String encrypt(String str, boolean z) {
        try {
            String strByteToString = byteToString(MessageDigest.getInstance(TAG).digest(str.getBytes()));
            return z ? strByteToString.toLowerCase() : strByteToString;
        } catch (NoSuchAlgorithmException e2) {
            RLog.e(TAG, "encrypt", e2);
            return str;
        }
    }
}
