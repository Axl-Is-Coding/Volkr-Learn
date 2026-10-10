package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.text.TextUtils;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.alibaba.sdk.android.feedback.xblink.f.a {
    public static String a(String str) {
        String strA;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.a("WXEncriptionTool", "FeedbackAPI sign before:" + str);
        if (TextUtils.isEmpty(com.alibaba.sdk.android.feedback.a.b.e())) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b("WXEncriptionTool", "FeedbackAPI appsecret is null");
            strA = "";
        } else {
            strA = a(str.getBytes(), com.alibaba.sdk.android.feedback.a.b.e().getBytes());
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.a("WXEncriptionTool", "FeedbackAPI sign after:" + strA);
        return strA;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; bArr != null && i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString().toLowerCase();
    }

    public static String a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "HmacSHA1");
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return a(mac.doFinal(bArr));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        try {
            mVar.a("data", a(new JSONObject(str).getString("data")));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        bVar.a(mVar);
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!"sign".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
