package io.rong.imkit.utils;

/* JADX INFO: loaded from: classes5.dex */
public class StringUtils {
    private static final String SEPARATOR = "#@6RONG_CLOUD9@#";

    public static String getArg1(String str) {
        if (str.contains(SEPARATOR)) {
            return str.substring(0, str.indexOf(SEPARATOR));
        }
        return null;
    }

    public static String getArg2(String str) {
        if (str.contains(SEPARATOR)) {
            return str.substring(str.indexOf(SEPARATOR) + 16);
        }
        return null;
    }

    public static String getKey(String str, String str2) {
        return str + SEPARATOR + str2;
    }
}
