package com.tendcloud.tenddata;

import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile HashMap<String, al> f19779a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f19780b = "TD_IP_CACHE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19781c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19782d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19783e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f19784f = null;
    private String g = null;

    /* JADX INFO: compiled from: td */
    public static class a {
        static final int resolvedIp = 1;
        static final int savedIp = 3;
        static final int staticIp = 4;
        static final int successIp = 2;
    }

    static URL a(URL url, String str) {
        return u.a() ? url : new URL(url.getProtocol(), str, url.getPort(), url.getFile());
    }

    static synchronized void b(String str, String str2) {
        if (!af.b(str) && !f19779a.containsKey(str)) {
            if (f19779a == null) {
                return;
            }
            try {
                al alVar = new al();
                alVar.g = str;
                alVar.f19781c = str2;
                alVar.f19783e = w.b(ab.g, f19780b, af.e(str), (String) null);
                alVar.f19782d = b(alVar.g);
                f19779a.put(alVar.g, alVar);
            } catch (Throwable unused) {
            }
        }
    }

    static void a(String str) {
        String strA = a(str, 1);
        if (strA == null || strA.equalsIgnoreCase(a(str, 3)) || ab.g == null) {
            return;
        }
        w.a(ab.g, f19780b, af.e(str), a(str, 1));
        a(str, a(str, 1), 3);
    }

    static void a(String str, String str2) {
        if (ab.g != null) {
            w.a(ab.g, f19780b, af.e(str), str2);
            a(str, str2, 2);
        }
    }

    static String b(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Throwable unused) {
            return null;
        }
    }

    static synchronized void a(String str, String str2, int i) {
        if (!af.b(str) && f19779a.containsKey(str)) {
            if (f19779a == null) {
                return;
            }
            al alVar = f19779a.get(str);
            if (i == 1) {
                alVar.f19782d = str2;
            } else if (i == 2) {
                alVar.f19784f = str2;
            } else if (i == 3) {
                alVar.f19783e = str2;
            } else if (i == 4) {
                alVar.f19781c = str2;
            }
        }
    }

    static synchronized String a(String str, int i) {
        if (!af.b(str) && f19779a.containsKey(str)) {
            if (f19779a == null) {
                return null;
            }
            al alVar = f19779a.get(str);
            if (alVar == null) {
                return null;
            }
            if (i == 1) {
                return alVar.f19782d;
            }
            if (i == 2) {
                return alVar.f19784f;
            }
            if (i == 3) {
                return alVar.f19783e;
            }
            if (i != 4) {
                return null;
            }
            return alVar.f19781c;
        }
        return null;
    }
}
