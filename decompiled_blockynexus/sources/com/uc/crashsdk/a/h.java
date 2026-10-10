package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import com.facebook.internal.ServerProtocol;
import com.sandboxol.center.config.StringConstant;
import com.uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.au;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f20510a = !h.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f20511b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f20512c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f20513d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, a> f20514e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f20515f = new Object();
    private static final Object g = new Object();
    private static final SparseArray<String> h = new SparseArray<>();
    private static boolean i = false;
    private static boolean j = false;
    private static final Object k = new Object();
    private static String l = null;

    /* JADX INFO: compiled from: ProGuard */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f20516a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f20517b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Map<String, String> f20518c = new HashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f20519d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f20520e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f20521f;

        a(String str, boolean z, boolean z2) {
            this.f20520e = false;
            this.f20521f = false;
            this.f20519d = str;
            this.f20520e = z;
            this.f20521f = z2;
        }

        private long d(String str) {
            return g.c(a(str));
        }

        final void a(String str, String str2) {
            this.f20518c.put(str, str2);
        }

        final String b(String str) {
            String strA = a(str);
            return strA == null ? "" : strA;
        }

        final boolean c(String str) {
            if (g.a(str)) {
                return false;
            }
            String str2 = null;
            HashMap map = new HashMap();
            Map mapC = h.c(str);
            long jC = 0;
            int iC = 0;
            for (String str3 : mapC.keySet()) {
                String str4 = (String) mapC.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.f20520e && str3.equals("up")) {
                    jC = g.c(str4);
                } else if (this.f20520e && str3.equals("pid")) {
                    iC = (int) g.c(str4);
                } else {
                    map.put(str3, str4);
                }
            }
            String str5 = this.f20519d;
            if (str5 != null && !str5.equals(str2)) {
                return false;
            }
            this.f20516a = jC;
            this.f20517b = iC;
            this.f20519d = str2;
            this.f20518c = map;
            return true;
        }

        final void a(String str, long j) {
            long jD = d(str) + j;
            if (jD <= 100) {
                j = jD < 0 ? 0L : jD;
            }
            a(str, String.valueOf(j));
        }

        final boolean a(a aVar) {
            if (!this.f20521f) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", this.f20519d), null);
                return false;
            }
            for (String str : aVar.f20518c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, aVar.a(str));
                } else {
                    long jD = aVar.d(str);
                    if (jD == 0) {
                        a(str, aVar.a(str));
                    } else if (jD < 100) {
                        a(str, jD);
                    }
                }
            }
            return true;
        }

        final String a(String str) {
            return this.f20518c.get(str);
        }

        final String a(boolean z, boolean z2, boolean z3) {
            if (this.f20519d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z) {
                h.b(sb, "lt", "uc");
                h.b(sb, "pre", com.uc.crashsdk.g.e());
                h.b(sb, "pkg", com.uc.crashsdk.a.f20478a);
                h.b(sb, "rom", Build.VERSION.RELEASE);
                h.b(sb, "brd", Build.BRAND);
                h.b(sb, "model", Build.MODEL);
                h.a(sb, ServerProtocol.DIALOG_PARAM_SDK_VERSION, Build.VERSION.SDK_INT);
                h.b(sb, au.v, com.uc.crashsdk.e.e());
                h.b(sb, "hdw", com.uc.crashsdk.e.f());
                long jN = h.n();
                h.a(sb, "ram", jN);
                h.b(sb, "aram", h.a(jN));
                h.b(sb, "cver", "3.2.0.4");
                h.b(sb, "cseq", "200403192109");
                h.b(sb, "ctag", "umeng");
                h.b(sb, "aver", com.uc.crashsdk.a.a());
                h.b(sb, "ver", com.uc.crashsdk.g.R());
                h.b(sb, "sver", com.uc.crashsdk.g.S());
                h.b(sb, "seq", com.uc.crashsdk.g.T());
                h.b(sb, "grd", com.uc.crashsdk.b.x() ? "fg" : "bg");
                h.b(sb, au.w, "android");
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            }
            h.b(sb, "lt", this.f20519d);
            h.a(sb, this.f20518c);
            if (this.f20520e && !z2) {
                long j = this.f20516a;
                if (j != 0) {
                    h.b(sb, "up", String.valueOf(j));
                }
                if (z3) {
                    h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(Process.myPid())));
                } else {
                    int i = this.f20517b;
                    if (i != 0) {
                        h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(i)));
                    }
                }
            }
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            return sb.toString();
        }
    }

    static /* synthetic */ String a(long j2) {
        return j2 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED ? "512M" : String.format(Locale.US, "%dG", Long.valueOf(((j2 / 1024) + 512) / 1024));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("`");
    }

    static /* synthetic */ Map c(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] strArrSplit = str2.split("=", 3);
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
        return map;
    }

    public static void d() {
        b(2, 2000L);
        a(1, 70000L);
    }

    public static boolean e() {
        return j;
    }

    public static void f() {
        b(1, 2000L);
    }

    public static void g() {
        b(3, 0L);
    }

    public static void h() {
        b(4, 0L);
    }

    public static void i() {
        if (com.uc.crashsdk.g.O()) {
            f.a(1, new e(303));
        }
    }

    static byte[] j() {
        return new byte[]{127, 100, 110, 31};
    }

    private static String l() {
        return com.uc.crashsdk.g.U() + "pv.wa";
    }

    private static String m() {
        return com.uc.crashsdk.g.U() + "cdt.wa";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long n() {
        Iterator<String> it = g.a(new File("/proc/meminfo"), 2).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next.contains("MemTotal:")) {
                try {
                    return Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e2) {
                    g.a(e2);
                    return 0L;
                }
            }
        }
    }

    private static String o() {
        if (g.a(l)) {
            synchronized (k) {
                l = g.a(com.uc.crashsdk.b.h(), com.uc.crashsdk.g.P() ? "https://gjapplog.ucweb.com/collect" : "https://applog.uc.cn/collect", true);
            }
        }
        return l;
    }

    static /* synthetic */ void a(StringBuilder sb, String str, long j2) {
        b(sb, str, String.valueOf(j2));
    }

    public static void b() {
        a(2, 0L);
    }

    public static void c() {
        a(3, 0L);
    }

    private static void b(int i2, long j2) {
        if (com.uc.crashsdk.g.O()) {
            f.a(1, new e(301, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    private static boolean d(String str) {
        File file = new File(str);
        for (a aVar : a(file, "cst", 30)) {
            String strA = aVar.a("prc");
            if (!g.a(strA)) {
                a aVar2 = f20514e.get(strA);
                if (aVar2 != null) {
                    aVar2.a(aVar);
                } else {
                    f20514e.put(strA, aVar);
                }
            }
        }
        boolean zB = b(com.uc.crashsdk.e.p(), a((Iterable<a>) f20514e.values(), true, false).toString());
        g.b(file);
        if (zB || g.a(file, a((Iterable<a>) f20514e.values(), false, true).toString())) {
            f20514e.clear();
        }
        return true;
    }

    static /* synthetic */ void a(StringBuilder sb, Map map) {
        for (String str : map.keySet()) {
            b(sb, str, (String) map.get(str));
        }
    }

    static void a(String str) {
        synchronized (f20511b) {
            File file = new File(l());
            a aVar = new a("pv", true, true);
            String strC = g.c(file);
            if (!g.a(strC)) {
                aVar.c(strC);
            }
            aVar.a(str, 1L);
            aVar.a("aujv", 1L);
            g.a(file, aVar.a(false, false, false));
        }
    }

    static boolean b(int i2, Object[] objArr) throws Throwable {
        switch (i2) {
            case 351:
                if (!f20510a && objArr == null) {
                    throw new AssertionError();
                }
                String str = (String) objArr[0];
                int iIntValue = ((Integer) objArr[1]).intValue();
                if (iIntValue == 1) {
                    if (j) {
                        return false;
                    }
                    j = true;
                }
                File file = new File(str);
                ArrayList<a> arrayListA = a(file, "crp", 100);
                if (iIntValue != 4) {
                    a aVar = new a("crp", false, false);
                    if (iIntValue == 1) {
                        aVar.a("et", String.valueOf(com.uc.crashsdk.b.F()));
                        aVar.a("ete", String.valueOf(com.uc.crashsdk.b.G()));
                    } else if (iIntValue == 3) {
                        aVar.a("et", "1");
                        aVar.a("ete", "1");
                    } else if (iIntValue == 2) {
                        aVar.a("hpv", "1");
                    }
                    aVar.a("prc", com.uc.crashsdk.e.h());
                    aVar.a("imp", com.uc.crashsdk.b.C() ? "1" : "0");
                    a(aVar);
                    arrayListA.add(0, aVar);
                }
                if (!arrayListA.isEmpty()) {
                    boolean zB = b(com.uc.crashsdk.e.p(), a((Iterable<a>) arrayListA, true, false).toString());
                    g.b(file);
                    if (!zB) {
                        g.a(file, a((Iterable<a>) arrayListA, false, true).toString());
                    }
                }
                return true;
            case 352:
                if (f20510a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case 353:
                if (f20510a || objArr != null) {
                    return b((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                }
                throw new AssertionError();
            case 354:
                if (!f20510a && objArr == null) {
                    throw new AssertionError();
                }
                File file2 = new File((String) objArr[0]);
                boolean zB2 = b(com.uc.crashsdk.e.p(), a((Iterable<a>) a(file2, "cst", 30), true, false).toString());
                if (zB2) {
                    g.b(file2);
                }
                return zB2;
            default:
                return false;
        }
    }

    public static void a() {
        a(0, com.uc.crashsdk.b.E() ? 700000L : 70000L);
    }

    private static void a(int i2, long j2) {
        if (com.uc.crashsdk.b.C()) {
            f.a(0, new e(302, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    public static boolean a(String str, String str2) {
        try {
            String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", "-");
            String strReplaceAll = g.a(str2) ? "" : str2.replaceAll("[`=]", "-");
            synchronized (f20512c) {
                if (f20512c.get(str3) == null) {
                    if (f20513d >= 20) {
                        return false;
                    }
                    f20513d++;
                }
                f20512c.put(str3, strReplaceAll);
                return true;
            }
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    public static void b(boolean z) {
        if (a(z, "crash detail upload")) {
            return;
        }
        String str = com.uc.crashsdk.g.U() + "dt.wa";
        com.uc.crashsdk.b.a(f20515f, str, new e(352, new Object[]{str}));
        String strM = m();
        com.uc.crashsdk.b.a(g, strM, new e(354, new Object[]{strM}));
    }

    private static boolean b(String str, String str2, boolean z, boolean z2) throws Throwable {
        a aVar;
        File file = new File(m());
        ArrayList<a> arrayListA = a(file, "cst", 30);
        String str3 = str + str2;
        Iterator<a> it = arrayListA.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (str3.equals(aVar.b("prc") + aVar.b("typ"))) {
                break;
            }
        }
        if (aVar == null) {
            aVar = new a("cst", false, true);
            aVar.a("prc", str);
            aVar.a("typ", str2);
            a(aVar);
            arrayListA.add(aVar);
        }
        aVar.a("cnt", 1L);
        if (z) {
            aVar.a("lim", 1L);
        }
        if (z2) {
            aVar.a("syu", 1L);
        }
        return g.a(file, a((Iterable<a>) arrayListA, false, false).toString());
    }

    private static void a(a aVar) {
        synchronized (f20512c) {
            for (String str : f20512c.keySet()) {
                aVar.a(str, f20512c.get(str));
            }
        }
    }

    public static void a(boolean z) {
        a(1, z);
    }

    public static boolean a(boolean z, String str) {
        if (!com.uc.crashsdk.b.f20525d || z || !JNIBridge.nativeIsCrashing()) {
            return false;
        }
        com.uc.crashsdk.a.a.b("crashsdk", "Native is crashing, skip stat for " + str);
        return true;
    }

    private static void a(int i2, boolean z) {
        if (a(z, "crash rate")) {
            return;
        }
        String str = com.uc.crashsdk.g.U() + "cr.wa";
        com.uc.crashsdk.b.a(f20511b, str, new e(351, new Object[]{str, Integer.valueOf(i2)}));
    }

    private static boolean b(String str, String str2) {
        byte[] bArrA;
        boolean z;
        String string;
        byte[] bArrA2;
        if (g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        try {
            byte[] bArr = new byte[16];
            c.a(bArr, 0, c.a());
            c.a(bArr, 4, j());
            c.a(bArr, 8, com.uc.crashsdk.a.f());
            c.a(bArr, 12, d.c());
            bArrA = c.a(bytes, bArr);
        } catch (Throwable th) {
            g.a(th);
        }
        if (bArrA != null) {
            z = true;
        } else {
            bArrA = bytes;
            z = false;
        }
        if (str == null) {
            str = "unknown";
        }
        String str3 = com.uc.crashsdk.g.P() ? "4ea4e41a3993" : "28ef1713347d";
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strD = g.d(str3 + str + strValueOf + "AppChk#2014");
        if (strD == null) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(o());
            sb.append("?chk=");
            sb.append(strD.substring(strD.length() - 8, strD.length()));
            sb.append("&vno=");
            sb.append(strValueOf);
            sb.append("&uuid=");
            sb.append(str);
            sb.append("&app=");
            sb.append(str3);
            if (z) {
                sb.append("&enc=aes");
            }
            string = sb.toString();
        }
        return (string == null || (bArrA2 = c.a(string, bArrA)) == null || !new String(bArrA2).contains("retcode=0")) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:69:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:69:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:69:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a5 A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:69:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00af A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:69:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(int r9, java.lang.Object[] r10) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.a(int, java.lang.Object[]):void");
    }

    private static StringBuilder a(Iterable<a> iterable, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (a aVar : iterable) {
            if (z3) {
                sb.append(aVar.a(z, z, z2));
                z3 = false;
            } else {
                sb.append(aVar.a(false, z, z2));
            }
        }
        return sb;
    }

    static void b(String str) {
        synchronized (k) {
            l = str;
            b.a(com.uc.crashsdk.b.h(), l + UMCustomLogInfoBuilder.LINE_SEP);
        }
    }

    public static void a(String str, int i2, int i3) {
        if (com.uc.crashsdk.g.O()) {
            synchronized (f20515f) {
                a aVar = f20514e.get(str);
                if (aVar == null) {
                    aVar = new a("cst", false, true);
                    f20514e.put(str, aVar);
                    a(aVar);
                }
                synchronized (h) {
                    if (h.size() == 0) {
                        a(100, "pv");
                        a(102, "hpv");
                        a(1, StringConstant.VIDEO_TYPE_ALL);
                        a(2, "afg");
                        a(101, "abg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(32, "urs");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(40, "anf");
                        a(41, "anb");
                        a(42, "ancf");
                        a(43, "ancb");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(200, "ltf");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(201, "lec");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = h.get(i2);
                if (str2 == null) {
                    com.uc.crashsdk.a.a.a("crashsdk", "map key is not set with: " + i2, null);
                }
                aVar.a("prc", str);
                if (str2 != null) {
                    aVar.a(str2, String.valueOf(i3));
                }
            }
        }
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        if (!com.uc.crashsdk.g.O()) {
            return false;
        }
        return com.uc.crashsdk.b.a(g, m(), new e(353, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}));
    }

    private static void a(int i2, String str) {
        h.put(i2, str);
    }

    private static ArrayList<a> a(File file, String str, int i2) throws Throwable {
        ArrayList<String> arrayListA = g.a(file, i2);
        ArrayList<a> arrayList = new ArrayList<>();
        for (String str2 : arrayListA) {
            a aVar = new a(str, false, false);
            if (aVar.c(str2)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
