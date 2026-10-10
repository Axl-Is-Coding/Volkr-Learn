package okhttp3.internal.http;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.C;
import okhttp3.CookieJar;
import okhttp3.H;
import okhttp3.n;
import okhttp3.u;
import okhttp3.v;
import okio.ByteString;

/* JADX INFO: compiled from: HttpHeaders.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ByteString f23239a = ByteString.encodeUtf8("\"\\");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ByteString f23240b = ByteString.encodeUtf8("\t ,=");

    public static long a(H h) {
        return a(h.o());
    }

    public static boolean b(u uVar) {
        return c(uVar).contains("*");
    }

    public static boolean c(H h) {
        return b(h.o());
    }

    public static u d(H h) {
        return a(h.s().y().c(), h.o());
    }

    private static Set<String> e(H h) {
        return c(h.o());
    }

    public static long a(u uVar) {
        return a(uVar.b("Content-Length"));
    }

    public static boolean b(H h) {
        if (h.y().e().equals("HEAD")) {
            return false;
        }
        int iG = h.g();
        return (((iG >= 100 && iG < 200) || iG == 204 || iG == 304) && a(h) == -1 && !"chunked".equalsIgnoreCase(h.a("Transfer-Encoding"))) ? false : true;
    }

    public static Set<String> c(u uVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iB = uVar.b();
        Set<String> treeSet = setEmptySet;
        for (int i = 0; i < iB; i++) {
            if ("Vary".equalsIgnoreCase(uVar.a(i))) {
                String strB = uVar.b(i);
                if (treeSet.isEmpty()) {
                    treeSet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strB.split(",")) {
                    treeSet.add(str.trim());
                }
            }
        }
        return treeSet;
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

    public static boolean a(H h, u uVar, C c2) {
        for (String str : e(h)) {
            if (!okhttp3.a.e.a(uVar.c(str), c2.b(str))) {
                return false;
            }
        }
        return true;
    }

    public static u a(u uVar, u uVar2) {
        Set<String> setC = c(uVar2);
        if (setC.isEmpty()) {
            return new u.a().a();
        }
        u.a aVar = new u.a();
        int iB = uVar.b();
        for (int i = 0; i < iB; i++) {
            String strA = uVar.a(i);
            if (setC.contains(strA)) {
                aVar.a(strA, uVar.b(i));
            }
        }
        return aVar.a();
    }

    public static int b(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    public static void a(CookieJar cookieJar, v vVar, u uVar) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<n> listA = n.a(vVar, uVar);
        if (listA.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(vVar, listA);
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
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
}
