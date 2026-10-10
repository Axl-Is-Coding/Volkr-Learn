package com.uc.crashsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.sandboxol.center.config.VipSubscribeStatus;
import com.uc.crashsdk.a.h;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public class b {
    static final /* synthetic */ boolean i = !b.class.desiredAssertionStatus();
    private static String j = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static String n = null;
    private static String o = null;
    private static String p = null;
    private static String q = null;
    private static String r = null;
    private static String s = null;
    private static String t = null;
    private static String u = null;
    private static String v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f20522a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f20523b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f20524c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f20525d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f20526e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f20527f = false;
    public static boolean g = true;
    public static boolean h = false;
    private static boolean w = false;
    private static boolean x = false;
    private static volatile boolean y = false;
    private static boolean z = false;
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static final Object F = new Object();
    private static String G = null;
    private static int H = 0;
    private static boolean I = false;
    private static boolean J = false;
    private static boolean K = true;
    private static RandomAccessFile L = null;
    private static boolean M = false;
    private static final Object N = new Object();
    private static String O = null;
    private static boolean P = false;
    private static volatile Object[] Q = null;
    private static Runnable R = new com.uc.crashsdk.a.e(101);
    private static boolean S = false;
    private static long T = 0;
    private static final Object U = new Object();
    private static long V = 0;
    private static boolean W = false;
    private static boolean X = false;
    private static boolean Y = false;
    private static long Z = 0;
    private static final WeakHashMap<Activity, Integer> aa = new WeakHashMap<>();
    private static boolean ab = false;
    private static String ac = null;
    private static boolean ad = false;
    private static boolean ae = false;
    private static boolean af = false;
    private static boolean ag = false;
    private static boolean ah = false;
    private static final Object ai = new Object();
    private static PendingIntent aj = null;

    static void A() {
        String str;
        if (!f20525d || (str = ac) == null) {
            return;
        }
        JNIBridge.set(129, str);
    }

    static String B() {
        String str = ac;
        return str == null ? "" : str;
    }

    public static boolean C() {
        if (!ad) {
            if (!com.uc.crashsdk.a.g.a(a.f20478a) && a.f20478a.equals(e.h())) {
                ae = true;
                if (f20525d) {
                    JNIBridge.set(2, true);
                }
            }
            ad = true;
        }
        return ae;
    }

    static void D() {
        af = true;
        if (f20525d) {
            JNIBridge.set(34, true);
        }
    }

    public static boolean E() {
        return af;
    }

    public static int F() {
        boolean zR = R();
        return q() ? zR ? 3 : 6 : p() ? zR ? 2 : 5 : zR ? 4 : 1;
    }

    public static int G() {
        boolean zS = S();
        boolean zT = T();
        boolean zU = U();
        if (q()) {
            if (zS) {
                return 12;
            }
            if (zT) {
                return 14;
            }
            return zU ? 16 : 98;
        }
        if (!p()) {
            return 1;
        }
        if (zS) {
            return 11;
        }
        if (zT) {
            return 13;
        }
        return zU ? 15 : 97;
    }

    static void H() {
        if (f20525d) {
            JNIBridge.nativeSet(27, H, VipSubscribeStatus.SUBSCRIPTION_REVOKED, null);
            JNIBridge.set(30, K);
        }
    }

    public static boolean I() {
        if (!ah) {
            synchronized (ai) {
                if (!ah) {
                    ag = ab();
                    ah = true;
                }
            }
        }
        return ag;
    }

    public static void J() {
        if (e.F() || I() || aj != null || g.h() < 0) {
            return;
        }
        try {
            Context contextA = com.uc.crashsdk.a.g.a();
            Intent launchIntentForPackage = contextA.getPackageManager().getLaunchIntentForPackage(contextA.getPackageName());
            launchIntentForPackage.addFlags(335544320);
            aj = PendingIntent.getActivity(contextA, 0, launchIntentForPackage, 0);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    static boolean K() {
        if (aj == null) {
            com.uc.crashsdk.a.a.b("Restart intent is null!");
            return false;
        }
        try {
            com.uc.crashsdk.a.a.a("crashsdk", "restarting ...");
            ((AlarmManager) com.uc.crashsdk.a.g.a().getSystemService("alarm")).set(1, System.currentTimeMillis() + 200, aj);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    static /* synthetic */ boolean L() {
        ab = true;
        return true;
    }

    private static String N() {
        if (j == null) {
            j = c("ss");
        }
        return j;
    }

    private static String O() {
        if (l == null) {
            l = c("ctn");
        }
        return l;
    }

    private static String P() {
        if (m == null) {
            m = c("cta");
        }
        return m;
    }

    private static void Q() {
        if (y || x) {
            return;
        }
        synchronized (F) {
            if (y) {
                return;
            }
            d(g.U());
            String strM = m();
            File file = new File(b());
            File file2 = new File(O());
            z = "f".equals(strM);
            A = "b".equals(strM);
            C = file.exists();
            D = file2.exists();
            boolean z2 = C || D;
            B = z2;
            if (!z2 && (z || A)) {
                boolean zO = o();
                E = zO;
                B = zO;
            }
            try {
                if (w()) {
                    W();
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            y = true;
        }
    }

    private static boolean R() {
        Q();
        return B;
    }

    private static boolean S() {
        Q();
        return C;
    }

    private static boolean T() {
        Q();
        return D;
    }

    private static boolean U() {
        Q();
        return E;
    }

    private static void V() {
        if (f20525d) {
            JNIBridge.set(26, w);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:29:0x0044). Please report as a decompilation issue!!! */
    private static void W() {
        if (!S) {
            S = true;
            try {
                new File(b()).delete();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            try {
                new File(O()).delete();
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            try {
                if (f20525d) {
                    JNIBridge.cmd(16);
                } else {
                    new File(P()).delete();
                }
            } catch (Throwable th3) {
                com.uc.crashsdk.a.g.a(th3);
            }
        }
        Object[] objArrY = Y();
        if (!objArrY[0].equals(O) && Q == null) {
            a(objArrY);
        } else {
            P = true;
            X();
        }
    }

    private static void X() {
        if (!com.uc.crashsdk.a.f.b(R)) {
            com.uc.crashsdk.a.f.a(1, R);
            return;
        }
        Object[] objArr = Q;
        if (objArr == null || !Y()[0].equals(objArr[0])) {
            com.uc.crashsdk.a.f.a(R);
            com.uc.crashsdk.a.f.a(1, R);
        }
    }

    private static Object[] Y() {
        synchronized (U) {
            V++;
            if (w) {
                return new Object[]{"e", Long.valueOf(V)};
            }
            if (y()) {
                return new Object[]{"f", Long.valueOf(V)};
            }
            return new Object[]{"b", Long.valueOf(V)};
        }
    }

    private static Object Z() {
        Method declaredMethod;
        Object objA;
        Object objA2 = a((Application) com.uc.crashsdk.a.g.a(), (Class<?>) Application.class, "mLoadedApk");
        if (objA2 != null && (objA = a(objA2, (Class<?>) null, "mActivityThread")) != null) {
            return objA;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            if (cls != null && (declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, new Object[0]);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return null;
    }

    static String a() {
        int length;
        String str = G;
        if (str != null) {
            return str;
        }
        String strH = e.h();
        if (com.uc.crashsdk.a.g.a(strH)) {
            G = "LLUN";
        } else {
            if (strH.length() > 48) {
                length = strH.length() - 48;
                strH = strH.substring(0, 48);
            } else {
                length = 0;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bytes = strH.getBytes();
            for (int length2 = bytes.length - 1; length2 >= 0; length2--) {
                byte b2 = bytes[length2];
                if (b2 == 46) {
                    sb.append('0');
                } else if (b2 == 58) {
                    sb.append('1');
                } else if (b2 >= 97 && b2 <= 122) {
                    sb.append((char) ((b2 + 65) - 97));
                } else if (b2 >= 65 && b2 <= 90) {
                    sb.append((char) b2);
                } else if (b2 < 48 || b2 > 57) {
                    sb.append('2');
                } else {
                    sb.append((char) b2);
                }
            }
            if (length > 0) {
                sb.append(String.valueOf(length));
            }
            G = sb.toString();
        }
        return G;
    }

    private static boolean aa() {
        String strA = com.uc.crashsdk.a.g.a(new File("/proc/self/cgroup"), 512, false);
        if (com.uc.crashsdk.a.g.a(strA)) {
            return false;
        }
        return strA.contains("/bg_non_interactive") || strA.contains("/background");
    }

    private static boolean ab() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, new Object[0]);
                if (objInvoke != null && (objInvoke instanceof Boolean)) {
                    return ((Boolean) objInvoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        int iMyUid = Process.myUid() % 100000;
        return iMyUid >= 99000 && iMyUid <= 99999;
    }

    private static String c(String str) {
        return g.U() + a() + Consts.DOT + str;
    }

    static String d() {
        if (u == null) {
            u = c("bati");
        }
        return u;
    }

    static String e() {
        if (v == null) {
            v = c("hdr");
        }
        return v;
    }

    static String f() {
        if (p == null) {
            p = g.U() + "up";
        }
        return p;
    }

    public static String g() {
        if (q == null) {
            q = g.U() + "authu";
        }
        return q;
    }

    public static String h() {
        if (r == null) {
            r = g.U() + "statu";
        }
        return r;
    }

    static String i() {
        if (s == null) {
            s = g.U() + "poli";
        }
        return s;
    }

    static String j() {
        if (t == null) {
            t = g.U() + "ver";
        }
        return t;
    }

    public static String k() {
        return g.U() + "bvu";
    }

    static String l() {
        return g.U() + "fds";
    }

    static String m() {
        return com.uc.crashsdk.a.g.a(new File(N()), 8, false);
    }

    static boolean n() {
        return x;
    }

    static boolean o() {
        if (!I) {
            if (f20525d) {
                J = JNIBridge.cmd(15) == 1;
            } else {
                J = new File(P()).exists();
            }
            I = true;
        }
        return J;
    }

    static boolean p() {
        Q();
        return z;
    }

    static boolean q() {
        Q();
        return A;
    }

    static boolean r() {
        return w;
    }

    public static void s() {
        boolean z2;
        d(g.U());
        x = true;
        z = false;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        String[] strArr = {".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"};
        String[] strArr2 = {"up", "authu", "statu", "poli"};
        File[] fileArrListFiles = new File(g.U()).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                String name = file.getName();
                int i2 = 0;
                while (true) {
                    if (i2 >= 7) {
                        z2 = false;
                        break;
                    } else {
                        if (name.endsWith(strArr[i2])) {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (!z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 4) {
                            break;
                        }
                        if (name.equals(strArr2[i3])) {
                            z2 = true;
                            break;
                        }
                        i3++;
                    }
                }
                if (z2) {
                    com.uc.crashsdk.a.a.a("crashsdk", "delete file: " + file.getPath());
                    com.uc.crashsdk.a.g.a(file);
                }
            }
        }
        W();
    }

    public static void t() {
        if (w) {
            return;
        }
        w = true;
        if (I() || e.t()) {
            return;
        }
        d(g.U());
        V();
        W();
    }

    static boolean u() {
        return d(g.U());
    }

    static boolean v() {
        return d(g.V());
    }

    static boolean w() {
        return W || !aa();
    }

    public static boolean x() {
        return X || !aa();
    }

    static boolean y() {
        return X && !w;
    }

    static void z() {
        com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(100));
    }

    static String b() {
        if (k == null) {
            k = c("ctj");
        }
        return k;
    }

    static String c() {
        if (n == null) {
            n = c("st");
        }
        return n;
    }

    private static boolean d(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "Crash log directory was placed by a file!", null);
        if (!file.delete()) {
            return false;
        }
        file.mkdirs();
        return true;
    }

    public static void b(boolean z2) {
        if (e.t()) {
            return;
        }
        if (z2 && w) {
            if (g.M()) {
                Log.v("crashsdk", "setForeground, reset sExited to false!!!");
            }
            w = false;
            V();
        }
        boolean z3 = e.F() || I();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (W && !X && z2) {
            long j2 = Z;
            if (j2 != 0 && !z3 && jCurrentTimeMillis - j2 > 1800000) {
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(104), 1000L);
            }
        }
        Z = jCurrentTimeMillis;
        X = z2;
        if (z2) {
            W = true;
        }
        if (f20525d) {
            JNIBridge.nativeSetForeground(z2);
        }
        if (w || z3) {
            return;
        }
        Q();
        W();
        if (z2) {
            a.a(false);
            if (!Y) {
                e.B();
                Y = true;
            }
        }
        if (!M) {
            X();
        }
        e.c(z2);
    }

    public static boolean c(int i2) {
        return (i2 & H) != 0;
    }

    public static void a(boolean z2) {
        K = z2;
        if (f20525d) {
            JNIBridge.set(30, K);
        }
    }

    public static String a(String str) {
        return "debug.crs." + str;
    }

    private static void a(Object[] objArr) {
        Q = objArr;
        synchronized (N) {
            String str = (String) objArr[0];
            long jLongValue = ((Long) objArr[1]).longValue();
            if (jLongValue < T) {
                com.uc.crashsdk.a.a.c("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", Long.valueOf(jLongValue), Long.valueOf(T)));
                return;
            }
            T = jLongValue;
            String strN = N();
            if (f20525d) {
                if (L != null) {
                    com.uc.crashsdk.a.g.a(L);
                    L = null;
                }
                boolean zNativeChangeState = JNIBridge.nativeChangeState(strN, str, M);
                M = false;
                if (!zNativeChangeState) {
                    com.uc.crashsdk.a.a.b("write state failed: " + str);
                }
            } else {
                if (L == null || M) {
                    if (L != null) {
                        com.uc.crashsdk.a.g.a(L);
                        L = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(strN, "rw");
                        L = randomAccessFile;
                        randomAccessFile.seek(0L);
                        M = false;
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                    }
                }
                try {
                    L.write(str.getBytes());
                    L.seek(0L);
                } catch (Exception e3) {
                    com.uc.crashsdk.a.g.a(e3);
                }
            }
            O = str;
            Q = null;
        }
    }

    public static void b(int i2) {
        H = i2;
        H();
    }

    static void b(Context context) {
        com.uc.crashsdk.a.a.a("Restart APP");
        if (context == null) {
            return;
        }
        if (o == null) {
            o = c("rt");
        }
        File file = new File(o);
        long j2 = -1;
        try {
            j2 = Long.parseLong(com.uc.crashsdk.a.g.d(file));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        boolean z2 = false;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        if (g.h() >= 0 && (j2 <= 0 || jCurrentTimeMillis - j2 > g.h())) {
            d(g.U());
            com.uc.crashsdk.a.g.a(file, String.valueOf(jCurrentTimeMillis));
            z2 = true;
        }
        com.uc.crashsdk.a.a.a("lastTime: " + j2 + ", currentTime: " + jCurrentTimeMillis + ", needRestart: " + z2);
        if (z2) {
            try {
                d.a(true);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            K();
        }
    }

    public static boolean a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new c());
            if (!g.J()) {
                return true;
            }
            z();
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static void a(int i2) {
        Object objA;
        Activity activity;
        int i3;
        boolean z2 = false;
        boolean z3 = true;
        switch (i2) {
            case 100:
                Object objZ = Z();
                if (objZ == null || (objA = a(objZ, (Class<?>) null, "mActivities")) == null) {
                    return;
                }
                try {
                    Iterator it = ((Map) objA).entrySet().iterator();
                    boolean z4 = false;
                    while (it.hasNext()) {
                        Object value = ((Map.Entry) it.next()).getValue();
                        if (value != null && (activity = (Activity) a(value, (Class<?>) null, "activity")) != null) {
                            boolean zBooleanValue = ((Boolean) a(value, (Class<?>) null, "paused")).booleanValue();
                            boolean zBooleanValue2 = ((Boolean) a(value, (Class<?>) null, "stopped")).booleanValue();
                            synchronized (aa) {
                                if (zBooleanValue || zBooleanValue2) {
                                    i3 = 2;
                                } else {
                                    i3 = 1;
                                    z4 = true;
                                }
                                aa.put(activity, Integer.valueOf(i3));
                                break;
                            }
                        }
                        z2 = true;
                    }
                    if (z2) {
                        b(z4);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 101:
                try {
                    if (new File(N()).exists()) {
                        z3 = false;
                    }
                    M = z3;
                    if (z3 || P) {
                        a(Y());
                        P = false;
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    com.uc.crashsdk.a.g.a(th2);
                    return;
                }
            case 102:
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(103));
                return;
            case 103:
                try {
                    com.uc.crashsdk.a.g.a(new File(P()));
                    return;
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 104:
                h.d();
                f.a(102);
                if (C()) {
                    e.C();
                    return;
                }
                return;
            default:
                if (!i) {
                    throw new AssertionError();
                }
                return;
        }
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    public static boolean a(Object obj, String str, com.uc.crashsdk.a.e eVar) {
        FileChannel channel;
        Throwable th;
        synchronized (obj) {
            FileChannel fileChannel = null;
            fileLockLock = null;
            FileLock fileLockLock = null;
            boolean zA = false;
            if (f20525d) {
                int iNativeOpenFile = JNIBridge.nativeOpenFile(str);
                if (iNativeOpenFile < 0) {
                    com.uc.crashsdk.a.a.a("crashsdk", "Can not open file: " + str, null);
                    return false;
                }
                try {
                    boolean zNativeLockFile = JNIBridge.nativeLockFile(iNativeOpenFile, true);
                    try {
                        zA = eVar.a();
                        return zA;
                    } finally {
                        if (zNativeLockFile) {
                            JNIBridge.nativeLockFile(iNativeOpenFile, false);
                        }
                    }
                } finally {
                    JNIBridge.nativeCloseFile(iNativeOpenFile);
                }
            }
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            try {
                try {
                    channel = new RandomAccessFile(file, "rw").getChannel();
                } catch (Throwable th2) {
                    th = th2;
                    channel = null;
                    com.uc.crashsdk.a.g.a(channel);
                    throw th;
                }
            } catch (Exception e3) {
                try {
                    com.uc.crashsdk.a.g.a(e3);
                    channel = null;
                } catch (Exception e4) {
                    e = e4;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileChannel);
                    return zA;
                }
            }
            if (channel != null) {
                try {
                    try {
                        fileLockLock = channel.lock();
                    } catch (Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            fileChannel = channel;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.uc.crashsdk.a.g.a(channel);
                    throw th;
                }
            }
            try {
                zA = eVar.a();
                com.uc.crashsdk.a.g.a(channel);
                return zA;
            } finally {
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (Exception e7) {
                        com.uc.crashsdk.a.g.a(e7);
                    }
                }
            }
        }
    }
}
