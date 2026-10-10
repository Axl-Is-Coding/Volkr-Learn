package com.sandboxol.common.utils;

/* JADX INFO: loaded from: classes3.dex */
public class TextEllipsizeUtil {

    public static class SignLib {
        public static final String END_POINT = "...";
    }

    public static String ellipsizeString(int i, String str, String str2) {
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, (i - 1) - str2.length()) + str2;
    }
}
