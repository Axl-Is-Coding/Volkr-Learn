package com.alibaba.sdk.android.feedback.xblink.i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3886a = "a";

    public static String a(String str) {
        int iIndexOf;
        if (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf(HybridPlusWebView.CHARSET)) == -1 || str.indexOf("=", iIndexOf) == -1) {
            return "";
        }
        String strSubstring = str.substring(str.indexOf("=", iIndexOf) + 1);
        int iIndexOf2 = strSubstring.indexOf(";");
        if (iIndexOf2 != -1) {
            strSubstring = strSubstring.substring(0, iIndexOf2).trim();
        }
        return strSubstring.trim();
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, 0) != null;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                g.b(f3886a, e2 + "");
            }
        }
        return false;
    }
}
