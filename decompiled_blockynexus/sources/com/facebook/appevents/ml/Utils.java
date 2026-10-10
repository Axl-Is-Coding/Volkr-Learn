package com.facebook.appevents.ml;

import android.text.TextUtils;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    static String normalizeString(String str) {
        return TextUtils.join(" ", str.trim().split("\\s+"));
    }

    static int[] vectorize(String str, int i) {
        int[] iArr = new int[i];
        byte[] bytes = normalizeString(str).getBytes(Charset.forName("UTF-8"));
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < bytes.length) {
                iArr[i2] = bytes[i2] & 255;
            } else {
                iArr[i2] = 0;
            }
        }
        return iArr;
    }
}
