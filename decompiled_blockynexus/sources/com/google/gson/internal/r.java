package com.google.gson.internal;

/* JADX INFO: compiled from: JavaVersion.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f14237a = c();

    static int a(String str) {
        int iC = c(str);
        if (iC == -1) {
            iC = b(str);
        }
        if (iC == -1) {
            return 6;
        }
        return iC;
    }

    private static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static int c() {
        return a(System.getProperty("java.version"));
    }

    public static int a() {
        return f14237a;
    }

    private static int c(String str) {
        try {
            String[] strArrSplit = str.split("[._]");
            int i = Integer.parseInt(strArrSplit[0]);
            return (i != 1 || strArrSplit.length <= 1) ? i : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean b() {
        return f14237a >= 9;
    }
}
