package com.tencent.tp;

/* JADX INFO: loaded from: classes5.dex */
public class q {
    public static char a(char c2) {
        char c3;
        if (c2 >= 'a' && c2 <= 'z') {
            c3 = (char) (c2 + 5);
            if (c3 <= 'z') {
                return c3;
            }
        } else {
            if (c2 < 'A' || c2 > 'Z') {
                return c2;
            }
            c3 = (char) (c2 + 5);
            if (c3 <= 'Z') {
                return c3;
            }
        }
        return (char) (c3 - 26);
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(a(str.charAt(i)));
        }
        return sb.toString();
    }
}
