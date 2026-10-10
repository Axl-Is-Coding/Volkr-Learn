package com.bytedance.sdk.openadsdk.multipro;

import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: compiled from: ParamEncode.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(str.getBytes(), 10);
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : new String(Base64.decode(str, 10));
    }
}
