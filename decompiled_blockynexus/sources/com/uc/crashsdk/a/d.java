package com.uc.crashsdk.a;

import com.facebook.internal.ServerProtocol;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.framework.UMModuleRegister;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f20489a = !d.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f20490b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f20491c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f20492d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f20493e = "hsdk";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f20494f = "alid ";
    private static String g = null;
    private static final Object h = new Object();
    private static String i = null;

    public static void a() {
        f.a(0, new e(500), com.uc.crashsdk.b.E() ? 900000L : 90000L);
    }

    public static String b() {
        try {
            return "inv" + f20494f + "cras" + f20493e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    static byte[] c() {
        return new byte[]{6, 0, 23, 8};
    }

    public static boolean d() {
        if (!com.uc.crashsdk.e.F() && !com.uc.crashsdk.b.I()) {
            a(true);
            return f20490b;
        }
        return true;
    }

    private static String e() {
        if (g.a(i)) {
            synchronized (h) {
                i = g.a(com.uc.crashsdk.b.g(), "https://errlog.umeng.com/api/crashsdk/validate", true);
            }
        }
        return i;
    }

    private static String f() {
        byte[] bArrA;
        String strE;
        byte[] bArrA2;
        byte[] bArrA3;
        StringBuilder sb = new StringBuilder();
        a(sb, "platform", com.uc.crashsdk.g.e());
        a(sb, "pkgname", com.uc.crashsdk.a.f20478a);
        a(sb, UMModuleRegister.PROCESS, com.uc.crashsdk.e.h());
        a(sb, "version", com.uc.crashsdk.a.a());
        a(sb, "cver", "3.2.0.4");
        a(sb, "ctag", "umeng");
        a(sb, "inter", com.uc.crashsdk.g.P() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        a(sb, au.w, "android");
        String string = sb.toString();
        byte[] bArr = new byte[16];
        c.a(bArr, 0, h.j());
        c.a(bArr, 4, c.a());
        c.a(bArr, 8, c());
        c.a(bArr, 12, com.uc.crashsdk.a.f());
        try {
            bArrA = c.a(string.getBytes(), bArr, true);
        } catch (Throwable th) {
            g.a(th);
            bArrA = null;
        }
        if (bArrA == null || (strE = e()) == null || (bArrA2 = c.a(strE, bArrA)) == null) {
            return null;
        }
        try {
            bArrA3 = c.a(bArrA2, bArr, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArrA3 = null;
        }
        if (bArrA3 != null) {
            return new String(bArrA3);
        }
        return null;
    }

    public static void a(int i2) {
        if (i2 != 500) {
            if (!f20489a) {
                throw new AssertionError();
            }
            return;
        }
        synchronized (f20491c) {
            g = null;
            a(!com.uc.crashsdk.b.C());
            if (g.b(g)) {
                h.a(g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.d.a(boolean):boolean");
    }

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb;
    }
}
