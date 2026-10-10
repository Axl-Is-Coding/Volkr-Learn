package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.facebook.internal.AnalyticsEvents;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceAES.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15037a;

    public static synchronized String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            SecretKeySpec secretKeySpecA = a(str);
            byte[] bArr = new byte[16];
            Arrays.fill(bArr, (byte) 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            byte[] bArrDecode = Base64.decode(str2, 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, secretKeySpecA, ivParameterSpec);
            return new String(cipher.doFinal(bArrDecode));
        } catch (Exception e2) {
            e2.printStackTrace();
            if (f15037a) {
                return "";
            }
            f15037a = true;
            JSONObject jSONObjectB = j.b(false);
            try {
                jSONObjectB.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "false");
                jSONObjectB.put("errorCode", 1);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(114, jSONObjectB));
            return "";
        }
    }

    public static synchronized String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            SecretKeySpec secretKeySpecA = a(str);
            byte[] bytes = str2.getBytes("UTF8");
            byte[] bArr = new byte[16];
            Arrays.fill(bArr, (byte) 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, secretKeySpecA, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(bytes), 0).replaceAll(System.getProperty("line.separator"), "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static SecretKeySpec a(String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[32];
        Arrays.fill(bArr, (byte) 0);
        byte[] bytes = str.getBytes("UTF-8");
        System.arraycopy(bytes, 0, bArr, 0, bytes.length < bArr.length ? bytes.length : bArr.length);
        return new SecretKeySpec(bArr, "AES");
    }
}
