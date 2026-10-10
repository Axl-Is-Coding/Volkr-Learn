package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.m;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.s;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: HttpHeaders.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f4978a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long a(aa aaVar) {
        return a(aaVar.f());
    }

    public static boolean b(aa aaVar) {
        if (aaVar.a().b().equals("HEAD")) {
            return false;
        }
        int iC = aaVar.c();
        return (((iC >= 100 && iC < 200) || iC == 204 || iC == 304) && a(aaVar) == -1 && !"chunked".equalsIgnoreCase(aaVar.a("Transfer-Encoding"))) ? false : true;
    }

    public static long a(r rVar) {
        return a(rVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void a(m mVar, s sVar, r rVar) {
        if (mVar == m.f5273a) {
            return;
        }
        List<com.bytedance.sdk.a.b.l> listA = com.bytedance.sdk.a.b.l.a(sVar, rVar);
        if (listA.isEmpty()) {
            return;
        }
        mVar.a(sVar, listA);
    }

    public static int b(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }
}
