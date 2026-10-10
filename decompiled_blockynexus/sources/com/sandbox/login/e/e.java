package com.sandbox.login.e;

import android.text.TextUtils;
import com.localapi.RsaCipher;
import com.sandboxol.center.config.StringConstant;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: LoginHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static boolean a(String str) {
        if (str != null && str.length() > 0) {
            String lowerCase = str.toLowerCase();
            if (!lowerCase.startsWith(StringConstant.THIRD_PART_LOGIN_FB) && !lowerCase.startsWith(StringConstant.THIRD_PART_LOGIN_GOOGLE) && !lowerCase.startsWith(StringConstant.THIRD_PART_LOGIN_TW) && !lowerCase.startsWith("quicksdk")) {
                return Pattern.matches("^(?!\\d+$)[a-zA-Z0-9_]{6,16}$", str);
            }
        }
        return false;
    }

    public static String b(String str) {
        String strA;
        try {
            strA = f.a(RsaCipher.PUBLIC_KEY_B64, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            strA = "";
        }
        return TextUtils.isEmpty(strA) ? str : strA;
    }
}
