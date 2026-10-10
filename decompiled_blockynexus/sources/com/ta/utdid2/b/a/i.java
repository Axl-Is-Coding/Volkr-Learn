package com.ta.utdid2.b.a;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class i {
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m95a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i = 0;
        for (char c2 : str.toCharArray()) {
            i = (i * 31) + c2;
        }
        return i;
    }
}
