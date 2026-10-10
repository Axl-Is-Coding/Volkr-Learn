package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.LogType;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.imlib.statistics.UserData;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public class e implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f20537b;
    private static String i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<FileInputStream> f20541e = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f20536a = !e.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f20538c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f20539d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f20540f = 0;
    private static long g = -1;
    private static boolean h = true;
    private static String j = "";
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static final Object n = new Object();
    private static final Object o = new Object();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final ArrayList<String> r = new ArrayList<>();
    private static int s = 0;
    private static String t = null;
    private static boolean u = false;
    private static String v = null;
    private static String w = null;
    private static String x = null;
    private static final Object y = new Object();
    private static final Object z = new Object();
    private static Map<String, Integer> A = null;
    private static String B = null;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static String J = "?";
    private static boolean K = false;
    private static boolean L = false;
    private static int M = 0;
    private static int N = 0;
    private static boolean O = false;
    private static com.uc.crashsdk.a.e P = new com.uc.crashsdk.a.e(405);
    private static c Q = new c(0);
    private static boolean R = false;
    private static final com.uc.crashsdk.a.e S = new com.uc.crashsdk.a.e(412);
    private static Thread.UncaughtExceptionHandler T = null;
    private static Throwable U = null;
    private static boolean V = false;
    private static boolean W = false;
    private static Runnable X = null;
    private static final Object Y = new Object();
    private static int Z = 101;
    private static Runnable aa = new com.uc.crashsdk.a.e(407);
    private static final Object ab = new Object();
    private static boolean ac = false;
    private static ParcelFileDescriptor ad = null;
    private static boolean ae = false;
    private static boolean af = false;

    /* JADX INFO: compiled from: ProGuard */
    private static class b implements Comparator<File> {
        private b() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.intent.action.BATTERY_CHANGED".equals(action)) {
                if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                    boolean unused = e.K = "android.intent.action.BATTERY_LOW".equals(action);
                    e.K();
                    return;
                } else {
                    if ("android.intent.action.ANR".equals(action)) {
                        try {
                            e.d(context);
                            return;
                        } catch (Throwable th) {
                            com.uc.crashsdk.a.g.a(th);
                            return;
                        }
                    }
                    return;
                }
            }
            int unused2 = e.C = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int unused3 = e.D = intent.getIntExtra("scale", -1);
            int unused4 = e.E = intent.getIntExtra("voltage", -1);
            int unused5 = e.F = intent.getIntExtra("health", -1);
            int unused6 = e.G = intent.getIntExtra("plugged", -1);
            int unused7 = e.H = intent.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1);
            int unused8 = e.I = intent.getIntExtra("temperature", -1);
            String unused9 = e.J = intent.getStringExtra("technology");
            if (e.J() >= 2) {
                e.K();
                e.L();
            }
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    public e() {
        try {
            M();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void A() {
        if (g.q()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(403), 10000L);
        }
    }

    public static void B() {
        if (ac || com.uc.crashsdk.b.I()) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(408), 1000L);
    }

    static void C() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(409), 7000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void D() {
        /*
            int r0 = com.uc.crashsdk.g.L()
            r1 = 4
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L13
            if (r0 == r2) goto L13
            if (r0 != r1) goto Lf
            goto L13
        Lf:
            if (r0 != r3) goto L45
        L11:
            r3 = 0
            goto L45
        L13:
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r5 < r6) goto L45
            r6 = 25
            if (r5 > r6) goto L45
            if (r0 != 0) goto L21
            r5 = 0
            goto L22
        L21:
            r5 = 1
        L22:
            r6 = 0
            if (r0 != r2) goto L35
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 10
            long r8 = r8 % r10
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 != 0) goto L33
            r2 = 1
            goto L36
        L33:
            r2 = 0
            goto L36
        L35:
            r2 = r5
        L36:
            if (r0 != r1) goto L44
            long r0 = java.lang.System.currentTimeMillis()
            r8 = 3
            long r0 = r0 % r8
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L11
            goto L45
        L44:
            r3 = r2
        L45:
            if (r3 != 0) goto L4e
            java.lang.String r0 = "crashsdk"
            java.lang.String r1 = "SIG 3 is disabled by settings"
            com.uc.crashsdk.a.a.a(r0, r1)
        L4e:
            boolean r0 = com.uc.crashsdk.b.I()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r1 == r2) goto L6a
            if (r3 == 0) goto L6a
            r1 = 2
            com.uc.crashsdk.a.e r2 = new com.uc.crashsdk.a.e
            r3 = 413(0x19d, float:5.79E-43)
            r2.<init>(r3)
            com.uc.crashsdk.a.f.a(r1, r2)
            r3 = 0
        L6a:
            r1 = 7
            long r4 = (long) r0
            r0 = 0
            com.uc.crashsdk.JNIBridge.nativeCmd(r1, r4, r0, r0)
            if (r3 == 0) goto L77
            r0 = 8
            com.uc.crashsdk.JNIBridge.cmd(r0)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.D():void");
    }

    public static ParcelFileDescriptor E() {
        if (!com.uc.crashsdk.b.f20525d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        ParcelFileDescriptor parcelFileDescriptor = ad;
        if (parcelFileDescriptor != null) {
            return parcelFileDescriptor;
        }
        int iCmd = (int) JNIBridge.cmd(14);
        if (iCmd == -1) {
            return null;
        }
        ad = ParcelFileDescriptor.adoptFd(iCmd);
        ae = true;
        return ad;
    }

    public static boolean F() {
        return af;
    }

    public static void G() {
        String strV = g.V();
        File file = new File(strV);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + strV);
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    a(false, false);
                    return;
                }
            }
        }
    }

    static /* synthetic */ int J() {
        int i2 = M + 1;
        M = i2;
        return i2;
    }

    static /* synthetic */ void K() {
        StringBuilder sbX;
        if (com.uc.crashsdk.b.f20525d && (sbX = X()) != null) {
            JNIBridge.set(125, sbX.toString());
        }
        L = true;
        Y();
    }

    static /* synthetic */ int L() {
        M = 0;
        return 0;
    }

    private void M() {
        int iG = g.G();
        for (int i2 = 0; i2 < iG; i2++) {
            try {
                this.f20541e.add(new FileInputStream("/dev/null"));
            } catch (Exception e2) {
                com.uc.crashsdk.a.g.a(e2);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean N() {
        if (g.N()) {
            return true;
        }
        return a();
    }

    private static String O() {
        return g.e() + "_";
    }

    private static String P() {
        return com.uc.crashsdk.b.y() ? "fg" : "bg";
    }

    private static byte[] Q() {
        byte[] bArr = null;
        int i2 = 1024;
        while (bArr == null && i2 > 0) {
            try {
                bArr = new byte[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    return bArr;
                }
            }
        }
        return bArr;
    }

    private static String R() {
        return (!com.uc.crashsdk.b.C() || f20539d) ? LogType.JAVA_TYPE : "ucebujava";
    }

    private static void S() throws Throwable {
        String strTrim;
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable th;
        String strTrim2 = "-";
        try {
            strTrim = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            strTrim = "-";
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i2 = 0;
                do {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.startsWith("Hardware")) {
                                strTrim = line.substring(line.indexOf(":") + 1).trim();
                            } else if (line.startsWith("Processor")) {
                                strTrim2 = line.substring(line.indexOf(":") + 1).trim();
                            }
                            i2++;
                        } catch (Throwable th3) {
                            th = th3;
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        com.uc.crashsdk.a.g.a(fileReader);
                        com.uc.crashsdk.a.g.a(bufferedReader);
                        throw th;
                    }
                } while (i2 < 2);
                com.uc.crashsdk.a.g.a(fileReader);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            fileReader = null;
            bufferedReader = null;
        }
        com.uc.crashsdk.a.g.a(bufferedReader);
        k = strTrim;
        l = strTrim2;
    }

    private static String T() {
        return g.U() + "bytes";
    }

    private static boolean U() {
        return Build.VERSION.SDK_INT < 29;
    }

    private static void V() {
        if (O || com.uc.crashsdk.b.C() || com.uc.crashsdk.b.I()) {
            return;
        }
        JNIBridge.cmd(18);
    }

    private static void W() {
        com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(414), 1000L);
    }

    private static StringBuilder X() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(C);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append("scale: ");
            sb.append(D);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            switch (F) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(F);
            sb.append(str);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            int i2 = G;
            String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(G);
            sb.append(str2);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            int i3 = H;
            String str3 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)" : " (Unknown)";
            sb.append("status: ");
            sb.append(H);
            sb.append(str3);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append("voltage: ");
            sb.append(E);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append("temperature: ");
            sb.append(I);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append("technology: ");
            sb.append(J);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append("battery low: ");
            sb.append(K);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            return sb;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void Y() {
        if (com.uc.crashsdk.b.f20524c && L && com.uc.crashsdk.a.f20480c) {
            L = false;
            if (com.uc.crashsdk.a.f.b(P)) {
                return;
            }
            com.uc.crashsdk.a.f.a(0, P, 2000L);
        }
    }

    private static boolean Z() {
        return com.uc.crashsdk.b.f20525d && JNIBridge.nativeIsCrashing();
    }

    public static boolean a() {
        if (f20540f == 0) {
            f20540f = 2L;
            if (g(com.uc.crashsdk.b.a("logs")) == 1) {
                f20540f = 1L;
            }
        }
        return f20540f == 1;
    }

    private static void aa() {
        String strW = g.W();
        File file = new File(strW);
        if (file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length > 150) {
                    Arrays.sort(fileArrListFiles, new b((byte) 0));
                    int length = fileArrListFiles.length - 150;
                    int i2 = length < 0 ? 0 : length;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (i3 < fileArrListFiles.length) {
                        File file2 = fileArrListFiles[i3];
                        boolean z2 = i3 < i2;
                        if (!z2 && jCurrentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        try {
                            file2.delete();
                            i4++;
                            i5 = 0;
                        } catch (Throwable th) {
                            i5++;
                            com.uc.crashsdk.a.g.a(th);
                        }
                        if (i5 >= 3) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i4 + " logs in " + strW);
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    static long b() {
        if (g == -1) {
            g = g(com.uc.crashsdk.b.a("local"));
        }
        return g;
    }

    private static String j(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", d(), m(), P(), str);
    }

    private static String k(String str) {
        if (!com.uc.crashsdk.a.g.b(str)) {
            return "";
        }
        int iIndexOf = str.indexOf(0);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        return str.trim();
    }

    private static String l(String str) throws Throwable {
        String strA = com.uc.crashsdk.a.b.a(str, g.w(), g.v());
        if (!str.equals(strA)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return strA;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean[] m(java.lang.String r7) {
        /*
            boolean r0 = com.uc.crashsdk.g.v()
            boolean r1 = com.uc.crashsdk.g.x()
            r2 = 0
            if (r0 != 0) goto Ld
            if (r1 == 0) goto L6d
        Ld:
            java.lang.String r3 = ".tmp"
            boolean r3 = r7.endsWith(r3)
            if (r3 != 0) goto L6b
            java.lang.String r3 = ".ec"
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L1e
            goto L6b
        L1e:
            char r3 = java.io.File.separatorChar
            int r3 = r7.lastIndexOf(r3)
            if (r3 >= 0) goto L27
            r3 = 0
        L27:
            r4 = 0
        L28:
            r5 = 95
            int r3 = r7.indexOf(r5, r3)
            if (r3 < 0) goto L34
            int r4 = r4 + 1
            int r3 = r3 + 1
        L34:
            if (r3 >= 0) goto L28
            r3 = 8
            if (r4 == r3) goto L3b
            goto L6b
        L3b:
            java.lang.String r3 = com.uc.crashsdk.g.w()
            java.lang.String r4 = ".log"
            boolean r6 = r7.endsWith(r4)
            if (r6 != 0) goto L54
            boolean r0 = com.uc.crashsdk.a.g.a(r3)
            if (r0 != 0) goto L6b
            boolean r7 = r7.endsWith(r3)
            if (r7 != 0) goto L5a
            goto L6b
        L54:
            boolean r3 = com.uc.crashsdk.a.g.a(r3)
            if (r3 == 0) goto L5c
        L5a:
            r0 = 0
            goto L6d
        L5c:
            int r3 = r7.lastIndexOf(r5)
            int r3 = r7.indexOf(r4, r3)
            int r7 = r7.lastIndexOf(r4)
            if (r3 == r7) goto L6d
            goto L5a
        L6b:
            r0 = 0
            r1 = 0
        L6d:
            r7 = 2
            boolean[] r7 = new boolean[r7]
            r7[r2] = r0
            r0 = 1
            r7[r0] = r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.m(java.lang.String):boolean[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean n(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.n(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae A[Catch: all -> 0x0106, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:38:0x00ae, B:49:0x00d3, B:56:0x00ee, B:52:0x00de, B:67:0x0104, B:63:0x00f9, B:11:0x0033, B:13:0x003b, B:14:0x0044, B:16:0x004c, B:18:0x0054, B:20:0x005c, B:26:0x006a, B:28:0x0074, B:30:0x0081, B:32:0x008b, B:33:0x0096, B:35:0x00a0), top: B:74:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean o(java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.o(java.lang.String):boolean");
    }

    private static Map<String, Integer> p(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("\\|", 30)) {
            String[] strArrSplit = str2.split(":", 3);
            if (strArrSplit.length == 2) {
                String strTrim = strArrSplit[0].trim();
                if (!com.uc.crashsdk.a.g.a(strTrim)) {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(strArrSplit[1].trim(), 10);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    map.put(strTrim, Integer.valueOf(i2));
                }
            }
        }
        return map;
    }

    private static void q(String str) {
        if (g.q()) {
            try {
                aa();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                File file = new File(g.W());
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                com.uc.crashsdk.a.g.a(new File(str), file);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    private static String r(String str) {
        return String.format("$^%s^$", str);
    }

    public static void s() {
        Thread.setDefaultUncaughtExceptionHandler(T);
    }

    static boolean t() {
        return f20538c.get() || Z();
    }

    public static Throwable u() {
        return U;
    }

    public static int v() {
        if (com.uc.crashsdk.b.F() == 5) {
            return Z;
        }
        return 100;
    }

    public static void w() {
        long jO = g.o();
        if (jO < 0) {
            return;
        }
        boolean z2 = com.uc.crashsdk.b.F() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(401));
        if (z2) {
            X = new com.uc.crashsdk.a.e(402);
            com.uc.crashsdk.a.f.a(0, X, jO);
        }
    }

    static void x() {
        if (com.uc.crashsdk.b.f20524c && com.uc.crashsdk.a.f20480c && !com.uc.crashsdk.a.f.b(aa)) {
            com.uc.crashsdk.a.f.a(0, aa, 1000L);
        }
    }

    public static boolean y() {
        synchronized (Y) {
            if (X == null || W) {
                return false;
            }
            com.uc.crashsdk.a.f.a(X);
            X = null;
            return true;
        }
    }

    public static String z() {
        return "https://errlog.umeng.com/upload";
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) throws Throwable {
        a(thread, th, false);
    }

    static String d() {
        String str = i;
        if (str != null) {
            return str;
        }
        String strI = i((String) null);
        i = strI;
        return strI;
    }

    private static long g(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return 0L;
    }

    private static String h(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String i(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", O(), g.R(), g.T(), h(Build.MODEL), h(Build.VERSION.RELEASE), str);
    }

    public static void r() {
        T = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    static void c() {
        i = null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:6|67|7|(4:9|10|11|(4:15|(3:17|(2:19|80)(1:81)|20)|79|21))|22|(8:77|24|75|25|29|(1:31)|32|(1:(1:35)(1:36)))|37|(2:73|38)|(11:40|69|41|49|71|50|(1:54)|55|(1:59)|63|64)(8:45|71|50|(2:52|54)|55|(2:57|59)|63|64)|48|49|71|50|(0)|55|(0)|63|64) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0141, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0142, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00de A[Catch: Throwable -> 0x0141, TryCatch #2 {Throwable -> 0x0141, blocks: (B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x010c, B:57:0x0112, B:59:0x011a), top: B:71:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0112 A[Catch: Throwable -> 0x0141, TryCatch #2 {Throwable -> 0x0141, blocks: (B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x010c, B:57:0x0112, B:59:0x011a), top: B:71:0x00d8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e() {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e():java.lang.String");
    }

    public static String f() throws Throwable {
        if (com.uc.crashsdk.a.g.a(k)) {
            S();
        }
        return k;
    }

    public static String h() {
        String str = m;
        if (str != null) {
            return str;
        }
        String strA = a(Process.myPid());
        m = strA;
        return strA;
    }

    public static boolean b(int i2, Object[] objArr) {
        if (i2 == 451) {
            if (f20536a || objArr != null) {
                return a((String) objArr[0], (d) objArr[1]);
            }
            throw new AssertionError();
        }
        if (i2 != 452) {
            if (f20536a) {
                return false;
            }
            throw new AssertionError();
        }
        if (!f20536a && objArr == null) {
            throw new AssertionError();
        }
        String str = (String) objArr[0];
        d dVar = (d) objArr[1];
        return com.uc.crashsdk.a.g.a(new File(str), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.f20547a), Long.valueOf(dVar.f20548b), Integer.valueOf(dVar.f20549c), Integer.valueOf(dVar.f20550d)).getBytes());
    }

    private static void c(OutputStream outputStream) {
        HashSet hashSet;
        Throwable th;
        File[] fileArrListFiles;
        try {
            outputStream.write("disk info:\n".getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        if (af) {
            h = false;
            try {
                outputStream.write(r("FSSTAT").getBytes("UTF-8"));
            } catch (Throwable th3) {
                a(th3, outputStream);
            }
            h = true;
        } else {
            try {
                hashSet = new HashSet();
                try {
                    a(outputStream, a(new File(com.uc.crashsdk.a.g.b())), hashSet);
                } catch (Throwable th4) {
                    th = th4;
                    a(th, outputStream);
                }
            } catch (Throwable th5) {
                hashSet = null;
                th = th5;
            }
            try {
                a(outputStream, a(Environment.getExternalStorageDirectory()), hashSet);
                File file = new File("/storage");
                if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2.isDirectory()) {
                            a(outputStream, a(file2), hashSet);
                        }
                    }
                }
            } catch (Throwable th6) {
                a(th6, outputStream);
            }
        }
        a(outputStream);
    }

    private static void d(OutputStream outputStream) {
        if (com.uc.crashsdk.b.f20525d) {
            String strL = com.uc.crashsdk.b.l();
            h = false;
            if (1 == JNIBridge.cmd(17, strL)) {
                File file = new File(strL);
                try {
                    byte[] bArrE = com.uc.crashsdk.a.g.e(file);
                    if (bArrE != null) {
                        outputStream.write(bArrE);
                    }
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                h = true;
                a(outputStream);
            }
            h = true;
            return;
        }
        File[] fileArrListFiles = null;
        int iH = 900;
        try {
            iH = g.H();
            fileArrListFiles = new File("/proc/self/fd").listFiles();
            if (fileArrListFiles != null) {
                outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArrListFiles.length), Integer.valueOf(iH)).getBytes("UTF-8"));
            } else {
                outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        if (fileArrListFiles != null) {
            try {
                if (fileArrListFiles.length >= iH) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (File file2 : fileArrListFiles) {
                            sb.append(file2.getName());
                            sb.append(" -> ");
                            sb.append(file2.getCanonicalPath());
                            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                        }
                    } catch (Throwable th4) {
                        a(th4, outputStream);
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
            } catch (Throwable th5) {
                a(th5, outputStream);
            }
        }
        a(outputStream);
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static String k() {
        if (com.uc.crashsdk.a.g.a(w)) {
            synchronized (y) {
                w = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.f(), x, true);
            }
        }
        return w;
    }

    public static void a(int i2, Object[] objArr) {
        int i3;
        switch (i2) {
            case 401:
                JNIBridge.nativeCmd(10, com.uc.crashsdk.b.F() == 5 ? 1L : 0L, null, null);
                com.uc.crashsdk.a.f20480c = true;
                com.uc.crashsdk.a.a(false);
                L = true;
                Y();
                x();
                return;
            case 402:
                synchronized (Y) {
                    if (X == null) {
                        return;
                    }
                    W = true;
                    if (com.uc.crashsdk.b.n()) {
                        return;
                    }
                    if (!com.uc.crashsdk.a.d.d()) {
                        com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                        return;
                    }
                    if (!c(LogType.UNEXP_TYPE)) {
                        com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
                        return;
                    }
                    int iNativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(g.o(), g.p());
                    if (iNativeGenerateUnexpLog != 0) {
                        f.a(11);
                        if ((iNativeGenerateUnexpLog & 4352) != 0) {
                            Z = 105;
                            i3 = 30;
                        } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_EXIT) != 0) {
                            Z = 104;
                            i3 = 31;
                        } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                            Z = 106;
                            i3 = 32;
                        } else {
                            if ((iNativeGenerateUnexpLog & LogType.UNEXP_ANR) != 0) {
                                Z = 103;
                                f.a(10);
                            } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_LOW_MEMORY) != 0) {
                                Z = 107;
                                f.a(29);
                            } else {
                                Z = 102;
                            }
                            a(true);
                        }
                        f.a(i3);
                        a(true);
                    }
                    synchronized (Y) {
                        X = null;
                        break;
                    }
                    return;
                }
            case 403:
                aa();
                return;
            case 404:
            default:
                if (!f20536a) {
                    throw new AssertionError();
                }
                return;
            case 405:
                L = false;
                StringBuilder sbX = X();
                String strD = com.uc.crashsdk.b.d();
                if (sbX != null) {
                    com.uc.crashsdk.a.g.a(new File(strD), sbX.toString());
                    return;
                }
                return;
            case 406:
                if (!f20536a && objArr == null) {
                    throw new AssertionError();
                }
                a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    com.uc.crashsdk.a.d();
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 408:
                synchronized (ab) {
                    if (!ac && g.O() && com.uc.crashsdk.b.w()) {
                        com.uc.crashsdk.b.p();
                        h.f();
                        f.c();
                        if (com.uc.crashsdk.b.C()) {
                            C();
                        }
                        if (g.O()) {
                            a(Calendar.getInstance());
                        }
                        ac = true;
                        return;
                    }
                    return;
                }
            case 409:
                b(false, false);
                return;
            case 410:
                a(false, true);
                return;
            case 411:
                if (com.uc.crashsdk.b.f20525d) {
                    JNIBridge.set(28, c(LogType.NATIVE_TYPE));
                    JNIBridge.set(29, c(LogType.ANR_TYPE));
                    return;
                }
                return;
            case 412:
                if (!R && com.uc.crashsdk.b.y() && g.K()) {
                    b(com.uc.crashsdk.a.g.a());
                    return;
                }
                if (R) {
                    if (com.uc.crashsdk.b.y() && g.K()) {
                        return;
                    }
                    try {
                        com.uc.crashsdk.a.g.a().unregisterReceiver(Q);
                        R = false;
                        return;
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                        return;
                    }
                }
                return;
            case 413:
                JNIBridge.cmd(8);
                return;
            case 414:
                try {
                    if (d(com.uc.crashsdk.a.g.a())) {
                        return;
                    }
                    int i4 = N + 1;
                    N = i4;
                    if (i4 < 10) {
                        W();
                        return;
                    } else {
                        if (com.uc.crashsdk.b.f20525d) {
                            JNIBridge.set(130, "(get failed)");
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 415:
                if (!f20536a && objArr == null) {
                    throw new AssertionError();
                }
                long jLongValue = ((Long) objArr[0]).longValue();
                Calendar calendar = Calendar.getInstance();
                if (calendar.getTimeInMillis() >= jLongValue) {
                    h.g();
                    f.a(100);
                    b(true, true);
                    h.b();
                } else {
                    h.h();
                    h.i();
                    h.c();
                }
                a(calendar);
                break;
                break;
            case 416:
                break;
        }
        V();
    }

    private static void f(OutputStream outputStream) throws Throwable {
        FileReader fileReader;
        BufferedReader bufferedReader;
        int iIndexOf;
        if (com.uc.crashsdk.b.f20525d) {
            try {
                outputStream.write("solib build id:\n".getBytes("UTF-8"));
            } catch (Throwable th) {
                a(th, outputStream);
            }
            FileReader fileReader2 = null;
            try {
                ArrayList arrayList = new ArrayList();
                fileReader = new FileReader(new File("/proc/self/maps"));
                try {
                    bufferedReader = new BufferedReader(fileReader, 512);
                    while (true) {
                        try {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                if (line.endsWith(".so") && (iIndexOf = line.indexOf(47)) != -1) {
                                    String strSubstring = line.substring(iIndexOf);
                                    if ((strSubstring.contains("/data/") || strSubstring.contains(com.uc.crashsdk.a.f20478a)) && !arrayList.contains(strSubstring)) {
                                        arrayList.add(strSubstring);
                                        if (af) {
                                            try {
                                                outputStream.write((String.format("$^%s`%s^$", "SOBUILDID", strSubstring) + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
                                            } catch (Throwable th2) {
                                                a(th2, outputStream);
                                            }
                                        } else {
                                            outputStream.write(String.format(Locale.US, "%s: %s\n", strSubstring, JNIBridge.nativeGet(3, 0L, strSubstring)).getBytes("UTF-8"));
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileReader2 = fileReader;
                                try {
                                    a(th, outputStream);
                                    com.uc.crashsdk.a.g.a(fileReader2);
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileReader = fileReader2;
                                    com.uc.crashsdk.a.g.a(fileReader);
                                    com.uc.crashsdk.a.g.a(bufferedReader);
                                    throw th;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th;
                        }
                    }
                    com.uc.crashsdk.a.g.a(fileReader);
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader = null;
                }
            } catch (Throwable th7) {
                th = th7;
                fileReader = null;
                bufferedReader = null;
            }
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f20542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OutputStream f20543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20544c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20545d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f20546e = false;

        a(long j, OutputStream outputStream) {
            this.f20542a = j;
            this.f20543b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(byte[] r7, int r8, int r9) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f20545d
                int r0 = r0 + r9
                r6.f20545d = r0
                boolean r0 = r6.f20546e
                if (r0 == 0) goto Lb
                r7 = 0
                return r7
            Lb:
                int r0 = com.uc.crashsdk.g.y()
                if (r0 <= 0) goto L19
                int r1 = r6.f20544c
                int r2 = r1 + r9
                if (r2 <= r0) goto L19
                int r0 = r0 - r1
                goto L1a
            L19:
                r0 = r9
            L1a:
                int r1 = r6.f20544c
                int r1 = r1 + r0
                r6.f20544c = r1
                long r1 = r6.f20542a
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L30
                java.lang.String r1 = new java.lang.String
                r1.<init>(r7, r8, r0)
                r6.b(r1)
                goto L35
            L30:
                java.io.OutputStream r1 = r6.f20543b
                r1.write(r7, r8, r0)
            L35:
                if (r0 >= r9) goto L3a
                r7 = 1
                r6.f20546e = r7
            L3a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a.a(byte[], int, int):int");
        }

        private void b(String str) {
            if (com.uc.crashsdk.b.f20525d) {
                JNIBridge.nativeClientWriteData(this.f20542a, str);
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
            if (e.h && e.N()) {
                com.uc.crashsdk.a.a.d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i)));
            }
            if (this.f20542a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i)));
            } else {
                this.f20543b.write(i);
            }
            this.f20544c++;
            this.f20545d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (e.h && e.N()) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                if (i2 != 1 || bArr2[0] != 10) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i, i2);
        }

        final void a() {
            try {
                if (this.f20545d - this.f20544c > 0) {
                    a(UMCustomLogInfoBuilder.LINE_SEP);
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.f20545d), Integer.valueOf(this.f20544c), Integer.valueOf(g.y()), Integer.valueOf(this.f20545d - this.f20544c)));
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            if (e.h && e.N() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        final void a(String str) throws IOException {
            if (e.h && e.N()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.f20542a != 0) {
                b(str);
            } else {
                this.f20543b.write(str.getBytes("UTF-8"));
            }
        }
    }

    static String g() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.a.g.a().getSystemService("activity");
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / 1024);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / 1024);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            return sb.toString();
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return "";
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f20547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f20548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f20549c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f20550d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f20551e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f20552f;
        boolean g;

        private d() {
            this.f20547a = 0L;
            this.f20548b = 0L;
            this.f20549c = 0;
            this.f20550d = 0;
            this.f20551e = false;
            this.f20552f = false;
            this.g = false;
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    public static void l() {
        if (af) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(411), 1000L);
    }

    static boolean i() {
        return f20539d;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054 A[Catch: Throwable -> 0x006d, TryCatch #0 {Throwable -> 0x006d, blocks: (B:6:0x000a, B:8:0x002a, B:20:0x004e, B:22:0x0054, B:24:0x0065), top: B:30:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void o() {
        /*
            java.lang.String r0 = com.uc.crashsdk.e.B
            boolean r0 = com.uc.crashsdk.a.g.a(r0)
            if (r0 != 0) goto L9
            return
        L9:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L6d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r2.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r3 = com.uc.crashsdk.g.U()     // Catch: java.lang.Throwable -> L6d
            r2.append(r3)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r3 = "unique"
            r2.append(r3)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6d
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L6d
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L6d
            if (r2 == 0) goto L4e
            r2 = 48
            r3 = 0
            java.lang.String r2 = com.uc.crashsdk.a.g.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L6d
            if (r2 == 0) goto L4d
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            r4 = 36
            if (r3 == r4) goto L3c
            goto L4e
        L3c:
            java.lang.String r0 = "[^0-9a-zA-Z-]"
            java.lang.String r3 = "-"
            java.lang.String r0 = r2.replaceAll(r0, r3)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L49
            goto L4e
        L45:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L6e
        L49:
            r0 = move-exception
            com.uc.crashsdk.a.g.a(r0)     // Catch: java.lang.Throwable -> L45
        L4d:
            r0 = r2
        L4e:
            boolean r2 = com.uc.crashsdk.a.g.a(r0)     // Catch: java.lang.Throwable -> L6d
            if (r2 == 0) goto L71
            com.uc.crashsdk.b.D()     // Catch: java.lang.Throwable -> L6d
            java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L6d
            boolean r2 = com.uc.crashsdk.a.g.a(r0)     // Catch: java.lang.Throwable -> L6d
            if (r2 != 0) goto L71
            byte[] r2 = r0.getBytes()     // Catch: java.lang.Throwable -> L6d
            com.uc.crashsdk.a.g.a(r1, r2)     // Catch: java.lang.Throwable -> L6d
            goto L71
        L6d:
            r1 = move-exception
        L6e:
            com.uc.crashsdk.a.g.a(r1)
        L71:
            com.uc.crashsdk.e.B = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.o():void");
    }

    public static String p() {
        return B;
    }

    static void q() {
        O = false;
        if (!com.uc.crashsdk.b.y()) {
            com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(416), 11000L);
        }
        if (U()) {
            return;
        }
        N = 0;
        W();
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String strR;
        String strNativeGet;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), m()).getBytes("UTF-8"));
            Locale locale = Locale.US;
            Object[] objArr = new Object[3];
            objArr[0] = e();
            if (com.uc.crashsdk.a.g.a(l)) {
                S();
            }
            objArr[1] = l;
            objArr[2] = f();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            Locale locale2 = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = a(new Date(f20537b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = com.uc.crashsdk.a.g.d();
            objArr2[3] = com.uc.crashsdk.b.y() ? "fg" : "bg";
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", g.R(), g.S(), g.T(), Integer.valueOf(com.uc.crashsdk.a.c())).getBytes("UTF-8"));
            String str3 = "0";
            String str4 = "";
            if (com.uc.crashsdk.b.f20525d) {
                String strNativeGet2 = JNIBridge.nativeGet(1, 0L, null);
                strNativeGet = JNIBridge.nativeGet(2, 0L, null);
                str3 = strNativeGet2;
            } else {
                strNativeGet = "";
            }
            outputStream.write(String.format(Locale.US, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.2.0.4", str3, "200403192109", strNativeGet, "umeng").getBytes("UTF-8"));
            if (str != null) {
                str4 = str;
            }
            outputStream.write(("Report Name: " + str4.substring(str4.lastIndexOf(47) + 1) + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            if (af) {
                strR = r("UUID");
            } else {
                strR = B;
            }
            outputStream.write(String.format("UUID: %s\n", strR).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String strB = com.uc.crashsdk.b.B();
            if (com.uc.crashsdk.a.g.a(strB)) {
                strB = "(none)";
            }
            outputStream.write(("Activity: " + strB + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, "UTF-8");
            if (af) {
                h = false;
                outputStream.write(r("HEADER").getBytes("UTF-8"));
                h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    static String m() {
        return a(new Date());
    }

    private static void g(OutputStream outputStream) {
        String strM;
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (af) {
                strM = r("LASTVER");
            } else {
                strM = com.uc.crashsdk.a.m();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", strM).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            synchronized (r) {
                if (t != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", t).getBytes("UTF-8"));
                }
                if (s > 0 || r.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(s)).getBytes("UTF-8"));
                    Iterator<String> it = r.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "dumping all threads: %s\n", Boolean.valueOf(u)).getBytes("UTF-8"));
            if (v != null) {
                outputStream.write(String.format(Locale.US, "dumping threads: %s\n", v).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    static boolean c(String str) {
        if (af) {
            return true;
        }
        try {
            return o(str);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    static void c(boolean z2) {
        boolean z3 = true;
        if (!R ? !z2 || !g.K() : z2 && g.K()) {
            z3 = false;
        }
        if (z3) {
            if (com.uc.crashsdk.a.f.b(S)) {
                com.uc.crashsdk.a.f.a(S);
            }
            com.uc.crashsdk.a.f.a(0, S, 3000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void a(boolean z2) {
        File[] fileArrListFiles;
        try {
            if (com.uc.crashsdk.b.v() && (fileArrListFiles = new File(g.V()).listFiles()) != null) {
                int iL = g.l();
                int iM = g.m();
                if (fileArrListFiles.length < Math.min(iL, iM)) {
                    return;
                }
                Object[] objArr = 0;
                int i2 = 0;
                int i3 = 0;
                for (File file : fileArrListFiles) {
                    if (b(file)) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                int i4 = (!z2 || i2 < iL) ? 0 : (i2 - iL) + 1;
                int i5 = (z2 || i3 < iM) ? 0 : (i3 - iM) + 1;
                if (i4 == 0 && i5 == 0) {
                    return;
                }
                Arrays.sort(fileArrListFiles, new b(objArr == true ? 1 : 0));
                int i6 = i5;
                int i7 = i4;
                for (File file2 : fileArrListFiles) {
                    boolean zB = b(file2);
                    if (zB && i7 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i7 += -1;
                    } else if (!zB && i6 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                        file2.delete();
                        i6 += -1;
                    }
                    if (i7 == 0 && i6 == 0) {
                        break;
                    }
                }
                f.a(16, i4 + i5);
                if (i4 > 0) {
                    f.a(22, i4);
                }
                if (i5 > 0) {
                    f.a(23, i5);
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void n() {
        f20537b = System.currentTimeMillis();
    }

    private static void e(OutputStream outputStream) {
        int I2;
        int length;
        File[] fileArrListFiles = null;
        try {
            I2 = g.I();
            try {
                fileArrListFiles = new File("/proc/self/task").listFiles();
                if (fileArrListFiles == null) {
                    return;
                }
                length = fileArrListFiles.length;
                if (length < I2) {
                    return;
                }
            } catch (Throwable th) {
                th = th;
                com.uc.crashsdk.a.g.a(th);
                length = 0;
            }
        } catch (Throwable th2) {
            th = th2;
            I2 = 300;
        }
        if (fileArrListFiles == null) {
            return;
        }
        try {
            outputStream.write("threads info:\n".getBytes("UTF-8"));
            outputStream.write(String.format(Locale.US, "threads count: %d, dump limit: %d.\n", Integer.valueOf(length), Integer.valueOf(I2)).getBytes("UTF-8"));
            outputStream.write(" tid     name\n".getBytes("UTF-8"));
            for (File file : fileArrListFiles) {
                outputStream.write(String.format(Locale.US, "%5s %s\n", file.getName(), k(com.uc.crashsdk.a.g.a(new File(file.getPath(), "comm"), 128, false))).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z2 = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int iMyPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == iMyPid) {
                O = true;
                if (N()) {
                    com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (com.uc.crashsdk.b.f20525d) {
                    JNIBridge.set(130, next.longMsg);
                }
                z2 = true;
            }
        }
        if (!z2 && com.uc.crashsdk.b.f20525d) {
            V();
        }
        return true;
    }

    static String a(String str, String str2) {
        String[] strArr;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                strArr = new String[]{"ps", "-ef"};
            } else {
                strArr = new String[]{"ps"};
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream()));
            boolean zB = com.uc.crashsdk.a.g.b(str);
            boolean zB2 = com.uc.crashsdk.a.g.b(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if ((zB && line.contains(str)) || (zB2 && line.contains(str2)) || (line.indexOf(47) < 0 && line.indexOf(46) > 0)) {
                        byteArrayOutputStream.write(line.getBytes("UTF-8"));
                        byteArrayOutputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
                    }
                } else {
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "exception exists.";
        }
    }

    public static boolean d(String str) {
        try {
            if (!com.uc.crashsdk.a.g.b(str) || !str.startsWith("lib") || !str.endsWith(".so")) {
                return false;
            }
            System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static int d(boolean z2) {
        int iB;
        if (z2) {
            iB = f.a(com.uc.crashsdk.b.c()) ? 1 : 0;
        } else {
            iB = f.b();
        }
        int iB2 = f.b(z2);
        return iB2 > iB ? iB2 : iB;
    }

    static StringBuilder e(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i2 = 8192;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i2);
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    return bufferedReader;
                }
            }
        }
        return bufferedReader;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    private static String a(File file) {
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (Throwable unused) {
            canonicalPath = null;
        }
        return com.uc.crashsdk.a.g.a(canonicalPath) ? file.getPath() : canonicalPath;
    }

    private static void a(OutputStream outputStream, String str, Set<String> set) {
        if (com.uc.crashsdk.a.g.a(str) || set.contains(str) || str.equals("/storage/emulated")) {
            return;
        }
        set.add(str);
        try {
            StatFs statFs = new StatFs(str);
            long jA = a(statFs, "getBlockCountLong", "getBlockCount");
            long jA2 = a(statFs, "getBlockSizeLong", "getBlockSize");
            if ((jA / 1024) * jA2 < 10240) {
                return;
            }
            long jA3 = a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
            long jA4 = a(statFs, "getFreeBlocksLong", "getFreeBlocks");
            try {
                outputStream.write(String.format(Locale.US, "%s:\n", str).getBytes("UTF-8"));
                Locale locale = Locale.US;
                Object[] objArr = new Object[1];
                double d2 = jA;
                Double.isNaN(d2);
                double d3 = jA2;
                Double.isNaN(d3);
                objArr[0] = Long.valueOf((long) (((d2 * 1.0d) * d3) / 1024.0d));
                outputStream.write(String.format(locale, "  total:      %d kB\n", objArr).getBytes("UTF-8"));
                Locale locale2 = Locale.US;
                Object[] objArr2 = new Object[1];
                double d4 = jA3;
                Double.isNaN(d4);
                Double.isNaN(d3);
                objArr2[0] = Long.valueOf((long) (((d4 * 1.0d) * d3) / 1024.0d));
                outputStream.write(String.format(locale2, "  available:  %d kB\n", objArr2).getBytes("UTF-8"));
                Locale locale3 = Locale.US;
                Object[] objArr3 = new Object[1];
                double d5 = jA4;
                Double.isNaN(d5);
                Double.isNaN(d3);
                objArr3[0] = Long.valueOf((long) (((d5 * 1.0d) * d3) / 1024.0d));
                outputStream.write(String.format(locale3, "  free:       %d kB\n", objArr3).getBytes("UTF-8"));
                outputStream.write(String.format(Locale.US, "  block size: %d B\n\n", Long.valueOf(jA2)).getBytes("UTF-8"));
            } catch (Throwable th) {
                a(th, outputStream);
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReaderA = null;
        try {
            try {
                outputStream.write("logcat:\n".getBytes("UTF-8"));
            } finally {
                com.uc.crashsdk.a.g.a((Closeable) null);
            }
        } catch (Throwable th) {
            h = true;
            a(th, outputStream);
        }
        if (g.n() <= 0) {
            try {
                outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                a(th2, outputStream);
            }
            a(outputStream);
            return;
        }
        int iN = g.n();
        bufferedReaderA = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", com.umeng.analytics.pro.b.ao, "-b", "main", "-v", "threadtime", "-t", String.valueOf(iN)}).getInputStream()));
        if (bufferedReaderA == null) {
            try {
                outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
            } catch (Throwable th3) {
                a(th3, outputStream);
            }
            a(outputStream);
            return;
        }
        h = false;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String line = bufferedReaderA.readLine();
            if (line != null) {
                i2++;
                if (i3 < iN && !line.contains(" I auditd ") && !line.contains(" I liblog ")) {
                    outputStream.write(line.getBytes("UTF-8"));
                    outputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
                    i3++;
                }
            } else {
                try {
                    break;
                } catch (Throwable th4) {
                    a(th4, outputStream);
                }
            }
        }
        outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes("UTF-8"));
        h = true;
        com.uc.crashsdk.a.g.a(bufferedReaderA);
        a(outputStream);
    }

    private static long a(StatFs statFs, String str, String str2) {
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(statFs, new Object[0]);
                if (objInvoke != null && (objInvoke instanceof Long)) {
                    return ((Long) objInvoke).longValue();
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object objInvoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (objInvoke2 == null || !(objInvoke2 instanceof Integer)) {
                return 0L;
            }
            return ((Integer) objInvoke2).intValue();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    private static void b(a aVar) {
        h = false;
        try {
            aVar.write((r("LOG_END") + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    private static void a(a aVar) {
        try {
            aVar.a(String.format(Locale.US, "log end: %s\n", m()));
        } catch (Throwable th) {
            a(th, aVar);
        }
    }

    static int b(OutputStream outputStream, String str, int i2) throws Throwable {
        int i3;
        DataInputStream dataInputStream;
        int i4;
        DataInputStream dataInputStream2 = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    byte[] bArrQ = Q();
                    if (bArrQ == null) {
                        outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                        com.uc.crashsdk.a.g.a((Closeable) null);
                        return 0;
                    }
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    i4 = 0;
                    i3 = 0;
                    loop0: while (true) {
                        boolean z2 = false;
                        while (true) {
                            try {
                                int i5 = dataInputStream.read(bArrQ);
                                if (i5 == -1) {
                                    break loop0;
                                }
                                i4 += i5;
                                int i6 = i2 - i3;
                                if (i5 <= i6 + 32) {
                                    i6 = i5;
                                }
                                if (i6 > 0 && !z2) {
                                    outputStream.write(bArrQ, 0, i6);
                                    i3 += i6;
                                }
                                if (!z2) {
                                    if (i6 < i5 || i3 >= i2) {
                                        z2 = true;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                dataInputStream2 = dataInputStream;
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(dataInputStream2);
                            }
                        }
                    }
                } else {
                    outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                    dataInputStream = null;
                    i4 = 0;
                    i3 = 0;
                }
                if (i3 > 0) {
                    outputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
                }
                if (i3 < i4) {
                    outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i4 - i3)).getBytes("UTF-8"));
                }
                com.uc.crashsdk.a.g.a(dataInputStream);
            } catch (Throwable th2) {
                th = th2;
                i3 = 0;
            }
            a(outputStream);
            return i3;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    static int a(OutputStream outputStream, String str, int i2) {
        Throwable th;
        int length;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String strA = com.uc.crashsdk.a.b.a(str);
            if (strA == null) {
                strA = "file: '" + str + "' not found or decode failed!";
            }
            length = strA.length();
            if (length > i2 + 32) {
                length = i2;
            }
            if (length > 0) {
                try {
                    outputStream.write(strA.getBytes("UTF-8"), 0, length);
                    outputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
                } catch (Throwable th2) {
                    th = th2;
                    a(th, outputStream);
                }
            }
            if (length < strA.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(strA.length() - length)).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            th = th3;
            length = 0;
        }
        a(outputStream);
        return length;
    }

    static String a(int i2) {
        try {
            String strA = com.uc.crashsdk.a.g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, false);
            return com.uc.crashsdk.a.g.b(strA) ? k(strA) : "unknown";
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "unknown";
        }
    }

    static void b(boolean z2) {
        try {
            boolean zS = g.r() && com.uc.crashsdk.b.C() && !f20539d;
            if (!zS) {
                zS = g.s();
            }
            if (zS) {
                if (z2) {
                    String strK = k();
                    if (com.uc.crashsdk.a.g.a(strK)) {
                        return;
                    }
                    j();
                    a(strK, false, false);
                    return;
                }
                a(true, false);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x02db A[Catch: all -> 0x0038, Throwable -> 0x0337, TRY_LEAVE, TryCatch #13 {all -> 0x0038, blocks: (B:11:0x002e, B:13:0x0032, B:19:0x003f, B:21:0x0048, B:26:0x0051, B:30:0x0092, B:31:0x009b, B:33:0x00ac, B:37:0x00be, B:39:0x00c4, B:41:0x00ce, B:45:0x00eb, B:49:0x00f8, B:53:0x0106, B:54:0x0109, B:59:0x0112, B:65:0x011d, B:71:0x0128, B:76:0x013c, B:80:0x0161, B:84:0x0182, B:85:0x0188, B:90:0x0191, B:92:0x0195, B:93:0x0197, B:97:0x01a9, B:96:0x01a6, B:98:0x01ab, B:103:0x01b4, B:104:0x01b7, B:109:0x01c0, B:113:0x01ce, B:115:0x01d2, B:122:0x01fa, B:123:0x0200, B:127:0x020e, B:129:0x0212, B:151:0x02c5, B:152:0x02ce, B:157:0x02d7, B:159:0x02db, B:160:0x02dd, B:164:0x02ef, B:163:0x02ec, B:165:0x02f1, B:170:0x02fa, B:175:0x0303, B:177:0x0307, B:178:0x0309, B:182:0x031b, B:181:0x0318, B:183:0x031d, B:184:0x0323, B:188:0x0329, B:174:0x0300, B:169:0x02f7, B:156:0x02d4, B:134:0x022b, B:136:0x024c, B:137:0x024e, B:139:0x0261, B:140:0x0266, B:142:0x027e, B:145:0x02a3, B:147:0x02aa, B:132:0x0226, B:126:0x020b, B:116:0x01e4, B:118:0x01ea, B:121:0x01f7, B:112:0x01cb, B:108:0x01bd, B:102:0x01b1, B:89:0x018e, B:83:0x017f, B:79:0x015e, B:74:0x0138, B:69:0x0123, B:63:0x0118, B:58:0x010f, B:52:0x0103, B:48:0x00f5, B:44:0x00e8, B:36:0x00bb, B:29:0x008f, B:25:0x004e, B:18:0x003c), top: B:247:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0307 A[Catch: all -> 0x0038, Throwable -> 0x0337, TRY_LEAVE, TryCatch #13 {all -> 0x0038, blocks: (B:11:0x002e, B:13:0x0032, B:19:0x003f, B:21:0x0048, B:26:0x0051, B:30:0x0092, B:31:0x009b, B:33:0x00ac, B:37:0x00be, B:39:0x00c4, B:41:0x00ce, B:45:0x00eb, B:49:0x00f8, B:53:0x0106, B:54:0x0109, B:59:0x0112, B:65:0x011d, B:71:0x0128, B:76:0x013c, B:80:0x0161, B:84:0x0182, B:85:0x0188, B:90:0x0191, B:92:0x0195, B:93:0x0197, B:97:0x01a9, B:96:0x01a6, B:98:0x01ab, B:103:0x01b4, B:104:0x01b7, B:109:0x01c0, B:113:0x01ce, B:115:0x01d2, B:122:0x01fa, B:123:0x0200, B:127:0x020e, B:129:0x0212, B:151:0x02c5, B:152:0x02ce, B:157:0x02d7, B:159:0x02db, B:160:0x02dd, B:164:0x02ef, B:163:0x02ec, B:165:0x02f1, B:170:0x02fa, B:175:0x0303, B:177:0x0307, B:178:0x0309, B:182:0x031b, B:181:0x0318, B:183:0x031d, B:184:0x0323, B:188:0x0329, B:174:0x0300, B:169:0x02f7, B:156:0x02d4, B:134:0x022b, B:136:0x024c, B:137:0x024e, B:139:0x0261, B:140:0x0266, B:142:0x027e, B:145:0x02a3, B:147:0x02aa, B:132:0x0226, B:126:0x020b, B:116:0x01e4, B:118:0x01ea, B:121:0x01f7, B:112:0x01cb, B:108:0x01bd, B:102:0x01b1, B:89:0x018e, B:83:0x017f, B:79:0x015e, B:74:0x0138, B:69:0x0123, B:63:0x0118, B:58:0x010f, B:52:0x0103, B:48:0x00f5, B:44:0x00e8, B:36:0x00bb, B:29:0x008f, B:25:0x004e, B:18:0x003c), top: B:247:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0330  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.Throwable r17, java.lang.String r18, long r19, boolean r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 888
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Throwable, java.lang.String, long, boolean):java.lang.String");
    }

    private static boolean b(File file) {
        int iIndexOf;
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(95);
        if (iLastIndexOf <= 0 || (iIndexOf = name.indexOf(46, iLastIndexOf)) <= 0) {
            return false;
        }
        String strSubstring = name.substring(iLastIndexOf + 1, iIndexOf);
        return LogType.JAVA_TYPE.equals(strSubstring) || "ucebujava".equals(strSubstring) || LogType.NATIVE_TYPE.equals(strSubstring) || "ucebujni".equals(strSubstring) || LogType.UNEXP_TYPE.equals(strSubstring) || LogType.ANR_TYPE.equals(strSubstring);
    }

    private static String b(String str, boolean z2, boolean z3) {
        if (z2) {
            try {
                str = l(str);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (!z3) {
            return str;
        }
        try {
            return a(str);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return str;
        }
    }

    static void b(String str, String str2, boolean z2) {
        h.a(str, str2, false, z2);
    }

    public static void b(String str) {
        synchronized (z) {
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.i(), str + UMCustomLogInfoBuilder.LINE_SEP);
        }
    }

    private static void b(String str, String str2) {
        try {
            com.uc.crashsdk.d.a(str, h(), str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void b(Context context) {
        if (g.K()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(Q, intentFilter, null, com.uc.crashsdk.a.f.a(1));
                R = true;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    public static void b(int i2) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(410), i2 * 1000);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(boolean z2, boolean z3) {
        int i2;
        if (z3 && !ac) {
            f.d(false);
        }
        if (z2) {
            boolean zA = f.a(com.uc.crashsdk.b.c(), false);
            h.i();
            i2 = zA;
        } else {
            int iA = f.a();
            h.i();
            i2 = iA;
        }
        return z3 ? f.a(z2) : i2;
    }

    static String a(String str) {
        int iLastIndexOf;
        int iIndexOf;
        int i2;
        int iIndexOf2;
        File file;
        byte[] bArrE;
        if (!g.x() || (iLastIndexOf = str.lastIndexOf(47)) <= 0 || (iIndexOf = str.indexOf(95, iLastIndexOf)) <= iLastIndexOf || (iIndexOf2 = str.indexOf(95, (i2 = iIndexOf + 1))) <= iIndexOf) {
            return str;
        }
        String strD = com.uc.crashsdk.a.g.d("CrashSDK" + str.substring(iLastIndexOf + 1, iIndexOf) + str.substring(i2, iIndexOf2));
        if (strD == null || (bArrE = com.uc.crashsdk.a.g.e((file = new File(str)))) == null || bArrE.length <= 0) {
            return str;
        }
        byte[] bArrB = null;
        try {
            bArrB = com.uc.crashsdk.a.c.b(bArrE, strD.substring(0, 16).getBytes());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        if (bArrB == null) {
            return str;
        }
        String str2 = str + ".ec";
        File file2 = new File(str2 + ".tmp");
        if (!com.uc.crashsdk.a.g.a(file2, bArrB)) {
            return str;
        }
        if (!file2.renameTo(new File(str2))) {
            file2.delete();
            return str;
        }
        file.delete();
        return str2;
    }

    static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02fa A[Catch: all -> 0x0434, Throwable -> 0x0436, TryCatch #4 {Throwable -> 0x0436, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0034, B:11:0x003a, B:12:0x004d, B:14:0x005d, B:16:0x0067, B:149:0x03bf, B:18:0x006d, B:20:0x007b, B:22:0x008d, B:25:0x00ae, B:27:0x00be, B:31:0x00cc, B:42:0x00f8, B:38:0x00ea, B:61:0x01c5, B:63:0x01d9, B:65:0x01dd, B:66:0x01df, B:68:0x01e4, B:69:0x01e6, B:70:0x01eb, B:80:0x020e, B:81:0x0224, B:83:0x022a, B:85:0x0233, B:87:0x0241, B:89:0x0260, B:90:0x0273, B:92:0x0285, B:94:0x0294, B:95:0x02a5, B:109:0x02e8, B:115:0x02fa, B:118:0x0303, B:121:0x030f, B:123:0x031d, B:125:0x032a, B:128:0x0331, B:132:0x033e, B:134:0x034a, B:136:0x0364, B:137:0x0369, B:139:0x0378, B:141:0x0385, B:147:0x03b1, B:152:0x03d3, B:154:0x03da, B:156:0x03e1, B:158:0x03e8, B:160:0x03ef, B:162:0x03f6, B:168:0x0408, B:170:0x040f, B:172:0x0416, B:174:0x041d, B:166:0x0401, B:140:0x037f, B:142:0x03a3, B:144:0x03a9, B:97:0x02ac, B:99:0x02b2, B:102:0x02ba, B:104:0x02be, B:106:0x02d2, B:108:0x02d6, B:74:0x01f5, B:76:0x0203, B:78:0x0209, B:60:0x01c1, B:175:0x0425), top: B:196:0x000a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instruction units count: 1102
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, boolean, boolean):void");
    }

    public static boolean a(boolean z2, boolean z3) {
        if (!f20539d) {
            if (com.uc.crashsdk.b.f20525d) {
                JNIBridge.set(1, true);
            }
            f20539d = true;
        }
        try {
            String strK = k();
            if (com.uc.crashsdk.a.g.a(strK)) {
                com.uc.crashsdk.a.a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            synchronized (n) {
                if (com.uc.crashsdk.a.f.a(z2 ? 1 : 0, new com.uc.crashsdk.a.e(406, new Object[]{strK, Boolean.valueOf(z3), Boolean.valueOf(z2)})) && z2) {
                    try {
                        n.wait();
                    } catch (InterruptedException e2) {
                        com.uc.crashsdk.a.g.a(e2);
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        boolean zA;
        FileChannel channel;
        Exception e2;
        synchronized (o) {
            ?? file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e3) {
                    com.uc.crashsdk.a.g.a(e3);
                }
            }
            FileLock fileLockLock = null;
            zA = false;
            try {
                try {
                    try {
                        channel = new RandomAccessFile((File) file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        com.uc.crashsdk.a.g.a((Closeable) file);
                        throw th;
                    }
                } catch (Exception e4) {
                    try {
                        com.uc.crashsdk.a.g.a(e4);
                        channel = null;
                    } catch (Exception e5) {
                        channel = null;
                        e2 = e5;
                        com.uc.crashsdk.a.g.a(e2);
                        com.uc.crashsdk.a.g.a(channel);
                        return zA;
                    }
                }
                if (channel != null) {
                    try {
                        fileLockLock = channel.lock();
                    } catch (Exception e6) {
                        try {
                            com.uc.crashsdk.a.g.a(e6);
                        } catch (Exception e7) {
                            e2 = e7;
                            com.uc.crashsdk.a.g.a(e2);
                        }
                    }
                }
                try {
                    zA = eVar.a();
                    com.uc.crashsdk.a.g.a(channel);
                } finally {
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (Exception e8) {
                            com.uc.crashsdk.a.g.a(e8);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                file = 0;
            }
        }
        return zA;
    }

    private static boolean a(String str, d dVar) {
        String strA = com.uc.crashsdk.a.g.a(new File(str), 64, false);
        if (strA == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(strA);
            if (matcher.find()) {
                long j2 = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - j2 < 86400000) {
                    dVar.f20548b = Long.parseLong(matcher.group(2));
                    dVar.f20549c = Integer.parseInt(matcher.group(3));
                    dVar.f20550d = Integer.parseInt(matcher.group(4));
                    dVar.f20547a = j2;
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public static boolean a(StringBuffer stringBuffer, String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j3;
        boolean z2;
        boolean zA;
        if (f20538c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z3 = af || com.uc.crashsdk.b.I();
        if (!z3 && !com.uc.crashsdk.a.d.d()) {
            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        }
        if (!c(str)) {
            com.uc.crashsdk.a.a.d("DEBUG", "custom log sample miss: " + str);
            return false;
        }
        if (Z()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        }
        if (stringBuffer == null || str == null) {
            return false;
        }
        String strA = g.V() + j(str);
        ?? r11 = (j2 & 32) != 0 ? 1 : 0;
        if (z3) {
            long jNativeClientCreateConnection = com.uc.crashsdk.b.f20525d ? JNIBridge.nativeClientCreateConnection(strA, UserData.CUSTOM_KEY, str, r11) : 0L;
            if (jNativeClientCreateConnection == 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "skip custom log: " + str);
                return false;
            }
            j3 = jNativeClientCreateConnection;
        } else {
            if (a(h(), str, (boolean) r11)) {
                return false;
            }
            g.a();
            a(false);
            j3 = 0;
        }
        synchronized (p) {
            z2 = r11;
            zA = a(strA, j3, stringBuffer, str, j2, arrayList, arrayList2, arrayList3, str2);
        }
        if (zA && !z3) {
            b(h(), str, z2);
        }
        if (j3 != 0) {
            JNIBridge.nativeClientCloseConnection(j3);
        }
        if (!zA) {
            return false;
        }
        if (!z3) {
            q(strA);
        }
        if (!z3) {
            strA = a(l(strA));
        }
        b(strA, str);
        if (z2 == 0 || z3) {
            return true;
        }
        try {
            a(true, false);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    static boolean a(String str, String str2, boolean z2) {
        if (!n(str2)) {
            return false;
        }
        h.a(str, str2, true, z2);
        com.uc.crashsdk.a.a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
        return true;
    }

    private static void a(a aVar, String str, long j2) throws Throwable {
        String strNativeDumpThreads;
        String str2 = null;
        if (com.uc.crashsdk.b.f20525d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            strNativeDumpThreads = JNIBridge.nativeDumpThreads(str, j2);
            if (af || strNativeDumpThreads == null || strNativeDumpThreads.length() >= 512 || !strNativeDumpThreads.startsWith("/") || strNativeDumpThreads.indexOf(10) >= 0) {
                str2 = strNativeDumpThreads;
            } else {
                if (!new File(strNativeDumpThreads).exists()) {
                    str2 = "Can not found " + strNativeDumpThreads;
                }
                String str3 = str2;
                str2 = strNativeDumpThreads;
                strNativeDumpThreads = str3;
            }
        } else {
            strNativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (strNativeDumpThreads != null) {
            try {
                aVar.write(strNativeDumpThreads.getBytes("UTF-8"));
                aVar.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            a((OutputStream) aVar);
        } else if (str2 != null && !af) {
            b(aVar, str2, 1048576);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r17, long r18, java.lang.StringBuffer r20, java.lang.String r21, long r22, java.util.ArrayList<java.lang.String> r24, java.util.ArrayList<java.lang.String> r25, java.util.ArrayList<java.lang.String> r26, java.lang.String r27) {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, long, java.lang.StringBuffer, java.lang.String, long, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    public static void a(String str, boolean z2) {
        if (z2) {
            x = str;
            return;
        }
        synchronized (y) {
            w = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.f(), str + UMCustomLogInfoBuilder.LINE_SEP);
        }
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    static void a(OutputStream outputStream, String str, String str2, int i2, boolean z2, boolean z3) {
        h = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(z2 ? 1 : 0);
            objArr[4] = Integer.valueOf(z3 ? 1 : 0);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
        a(outputStream);
    }

    static void a(OutputStream outputStream, String str, String str2) {
        h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    public static void a(Context context) {
        try {
            if (U()) {
                context.registerReceiver(new c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, com.uc.crashsdk.a.f.a(3));
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:161:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0554 A[Catch: all -> 0x05eb, TRY_LEAVE, TryCatch #28 {all -> 0x05eb, blocks: (B:330:0x042c, B:333:0x043e, B:335:0x0444, B:337:0x045c, B:338:0x045f, B:339:0x0486, B:344:0x048f, B:343:0x048c, B:240:0x0322, B:399:0x053e, B:401:0x0554), top: B:508:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:419:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0590 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x05bd A[Catch: Throwable -> 0x05d6, TryCatch #7 {Throwable -> 0x05d6, blocks: (B:428:0x05a1, B:431:0x05ac, B:433:0x05bd, B:435:0x05c1, B:436:0x05c6, B:439:0x05ce), top: B:509:0x05a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:438:0x05cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:445:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0617 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:470:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0644 A[Catch: Throwable -> 0x065d, TryCatch #1 {Throwable -> 0x065d, blocks: (B:475:0x0628, B:478:0x0633, B:480:0x0644, B:482:0x0648, B:483:0x064d, B:486:0x0655), top: B:498:0x0628 }] */
    /* JADX WARN: Removed duplicated region for block: B:485:0x0653 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:492:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:554:0x05fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0575 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:596:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:597:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0100  */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:139:0x01f4 -> B:568:0x01fc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x01f9 -> B:568:0x01fc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Thread r24, java.lang.Throwable r25, boolean r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Thread, java.lang.Throwable, boolean):void");
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    private static void a(Calendar calendar) {
        if (g.Q()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j2 = timeInMillis2 - timeInMillis;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(415, new Object[]{Long.valueOf(timeInMillis2)}), j2 <= 3600000 ? 1000 + j2 : 3600000L);
        }
    }

    static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z2 = str == null;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                if (!z2 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    i3 = 0;
                    z2 = true;
                }
            }
            i2 = i3;
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (ae) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        }
        if (!com.uc.crashsdk.b.f20525d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        }
        if (ad != null) {
            com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
        }
        ad = parcelFileDescriptor;
        int fd = parcelFileDescriptor.getFd();
        int iNativeCmd = (int) JNIBridge.nativeCmd(13, fd, null, null);
        af = iNativeCmd != -1;
        return fd == -1 || iNativeCmd != -1;
    }
}
