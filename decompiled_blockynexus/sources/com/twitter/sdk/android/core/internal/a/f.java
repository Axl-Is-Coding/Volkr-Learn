package com.twitter.sdk.android.core.internal.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.TreeMap;

/* JADX INFO: compiled from: UrlUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f {
    public static TreeMap<String, String> a(URI uri, boolean z) {
        return a(uri.getRawQuery(), z);
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public static String c(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public static TreeMap<String, String> a(String str, boolean z) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        if (str == null) {
            return treeMap;
        }
        for (String str2 : str.split("&")) {
            String[] strArrSplit = str2.split("=");
            if (strArrSplit.length == 2) {
                if (z) {
                    treeMap.put(b(strArrSplit[0]), b(strArrSplit[1]));
                } else {
                    treeMap.put(strArrSplit[0], strArrSplit[1]);
                }
            } else if (!TextUtils.isEmpty(strArrSplit[0])) {
                if (z) {
                    treeMap.put(b(strArrSplit[0]), "");
                } else {
                    treeMap.put(strArrSplit[0], "");
                }
            }
        }
        return treeMap;
    }

    public static String a(String str) {
        int i;
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String strC = c(str);
        int length = strC.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = strC.charAt(i2);
            if (cCharAt == '*') {
                sb.append("%2A");
            } else if (cCharAt == '+') {
                sb.append("%20");
            } else if (cCharAt == '%' && (i = i2 + 2) < length && strC.charAt(i2 + 1) == '7' && strC.charAt(i) == 'E') {
                sb.append('~');
                i2 = i;
            } else {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb.toString();
    }
}
