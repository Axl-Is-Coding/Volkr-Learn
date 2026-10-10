package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.Log;
import android.util.SparseArray;
import com.uc.crashsdk.export.LogType;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.dlog.DLog;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f20481d = !a.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20478a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f20479b = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, String> f20482e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List<String> f20483f = new ArrayList();
    private static String g = "";
    private static String h = null;
    private static int i = -1;
    private static long j = 0;
    private static final HashMap<String, Object[]> k = new HashMap<>();
    private static final List<String> l = new ArrayList();
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static final HashMap<String, Object[]> q = new HashMap<>();
    private static final List<String> r = new ArrayList();
    private static int s = 0;
    private static int t = 0;
    private static int u = 0;
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static final SparseArray<Object[]> y = new SparseArray<>();
    private static final List<Integer> z = new ArrayList();
    private static final HashMap<String, Object[]> A = new HashMap<>();
    private static final List<String> B = new ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static boolean f20480c = false;
    private static Runnable F = new com.uc.crashsdk.a.e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;

    public static String a() {
        String str = h;
        return str != null ? str : o() ? h : "";
    }

    static long b() {
        return j;
    }

    static int c() {
        if (i == -1) {
            o();
        }
        return i;
    }

    static void d() {
        StringBuilder sb = new StringBuilder();
        synchronized (f20482e) {
            for (String str : f20483f) {
                String str2 = f20482e.get(str);
                sb.append(str);
                sb.append(": ");
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", e.m()));
        com.uc.crashsdk.a.b.a(b.e(), sb.toString());
    }

    static void e() {
        if (!f20481d && !b.f20525d) {
            throw new AssertionError();
        }
        synchronized (f20482e) {
            for (String str : f20483f) {
                JNIBridge.nativeAddHeaderInfo(str, f20482e.get(str));
            }
        }
    }

    public static byte[] f() {
        return new byte[]{24, 99, 121, 60};
    }

    static void g() {
        if (!f20481d && !b.f20525d) {
            throw new AssertionError();
        }
        synchronized (k) {
            for (String str : l) {
                Object[] objArr = k.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & iIntValue) != 0) {
                    JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), iIntValue, ((Boolean) objArr[4]).booleanValue());
                }
            }
        }
    }

    static String h() {
        StringBuilder sb = new StringBuilder();
        synchronized (k) {
            boolean z2 = true;
            for (String str : l) {
                if (LogType.isForJava(((Integer) k.get(str)[0]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    static void i() {
        if (!f20481d && !b.f20525d) {
            throw new AssertionError();
        }
        synchronized (q) {
            for (String str : r) {
                Object[] objArr = q.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & iIntValue) != 0) {
                    JNIBridge.nativeAddCallbackInfo(str, iIntValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                }
            }
        }
    }

    static String j() {
        String string;
        synchronized (q) {
            StringBuilder sb = new StringBuilder();
            synchronized (r) {
                boolean z2 = true;
                for (String str : r) {
                    if (LogType.isForJava(((Integer) q.get(str)[0]).intValue())) {
                        if (!z2) {
                            sb.append("`");
                        }
                        sb.append(str);
                        z2 = false;
                    }
                }
            }
            string = sb.toString();
        }
        return string;
    }

    static void k() {
        if (!f20481d && !b.f20525d) {
            throw new AssertionError();
        }
        synchronized (A) {
            for (String str : B) {
                Object[] objArr = A.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                int iIntValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if ((1048577 & iIntValue2) != 0 && JNIBridge.nativeCreateCachedInfo(str, iIntValue, iIntValue2) != 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext() && JNIBridge.nativeAddCachedInfo(str, (String) it.next())) {
                    }
                }
            }
        }
    }

    static String l() {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            boolean z2 = true;
            for (String str : B) {
                if (LogType.isForJava(((Integer) A.get(str)[1]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    static String m() {
        if (!G) {
            g = com.uc.crashsdk.a.b.a(b.j());
            G = true;
            if (g == null) {
                g = "";
            }
        }
        return g;
    }

    public static void n() {
        p();
        if (!H) {
            H = true;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(202));
        } else if (b.f20525d) {
            JNIBridge.set(128, g);
        }
    }

    private static boolean o() {
        try {
            PackageInfo packageInfo = com.uc.crashsdk.a.g.a().getPackageManager().getPackageInfo(f20478a, 0);
            h = packageInfo.versionName;
            j = packageInfo.lastUpdateTime;
            i = packageInfo.versionCode;
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.b(th);
            return false;
        }
    }

    private static void p() {
        if (!I && e.a()) {
            if (b.f20525d || !b.g) {
                String str = String.format(Locale.US, "%s/%s/%s", g.R(), g.S(), g.T());
                com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + e.p());
                com.uc.crashsdk.a.a.b("crashsdk", "Version: " + str);
                com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + e.h());
                I = true;
            }
        }
    }

    private static StringBuilder b(String str, boolean z2) {
        String strA;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = q.get(str);
            try {
                if (objArr == null) {
                    strA = "Unknown callback: " + str;
                } else {
                    Callable callable = (Callable) objArr[1];
                    strA = callable != null ? (String) callable.call() : d.a(str, z2);
                }
                if (strA != null) {
                    sb.append(strA);
                }
            } catch (Throwable th) {
                sb.append("[DEBUG] Callback occurred new exception:\n");
                sb.append(Log.getStackTraceString(th));
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        return sb;
    }

    public static void a(String str, String str2) {
        synchronized (f20482e) {
            if (!f20482e.containsKey(str)) {
                f20483f.add(str);
            }
            f20482e.put(str, str2);
            if (b.f20525d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            e.x();
        }
    }

    static ArrayList<String> c(String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return null;
        }
        String[] strArrSplit = str.split(";", 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : strArrSplit) {
            if (!com.uc.crashsdk.a.g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static void a(OutputStream outputStream, String str) {
        synchronized (f20482e) {
            for (String str2 : f20483f) {
                try {
                    StringBuilder sb = new StringBuilder(11);
                    sb.append(str2);
                    sb.append(": ");
                    String str3 = f20482e.get(str2);
                    if (str3 != null) {
                        sb.append(str3);
                    }
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                    outputStream.write(sb.toString().getBytes(str));
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
            }
        }
    }

    public static int b(String str, String str2) {
        int iIntValue;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, DLog.CRS);
        }
        synchronized (A) {
            Object[] objArr = A.get(str);
            if (objArr != null) {
                int iIntValue2 = ((Integer) objArr[0]).intValue();
                iIntValue = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= iIntValue2) {
                    list.remove(0);
                }
                list.add(str2);
                iAddType = LogType.isForJava(iIntValue) ? LogType.addType(0, 16) : 0;
                if (!b.f20525d) {
                    if (LogType.isForNative(iIntValue)) {
                        iAddType = LogType.addType(iAddType, 1);
                    }
                    if (LogType.isForANR(iIntValue)) {
                        iAddType = LogType.addType(iAddType, 1048576);
                    }
                }
            } else {
                iIntValue = 0;
            }
            if (b.f20525d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                if (LogType.isForNative(iIntValue)) {
                    iAddType = LogType.addType(iAddType, 1);
                }
                if (LogType.isForANR(iIntValue)) {
                    iAddType = LogType.addType(iAddType, 1048576);
                }
            }
        }
        return iAddType;
    }

    public static int a(String str, String str2, boolean z2, boolean z3, int i2, boolean z4) {
        int iRemoveType;
        int iIntValue;
        boolean z5;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        synchronized (k) {
            if (k.containsKey(str)) {
                iIntValue = ((Integer) k.get(str)[0]).intValue();
                iRemoveType = LogType.addType(iIntValue, i2);
            } else {
                iRemoveType = i2;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                if (m >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 16);
                } else {
                    m++;
                }
            }
            if (LogType.isForNative(iRemoveType) && !LogType.isForNative(iIntValue)) {
                if (n >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                } else {
                    n++;
                }
            }
            if (LogType.isForUnexp(iRemoveType) && !LogType.isForUnexp(iIntValue)) {
                if (o >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                } else {
                    o++;
                }
            }
            if (LogType.isForANR(iRemoveType) && !LogType.isForANR(iIntValue)) {
                if (p >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                } else {
                    p++;
                }
            }
            if ((1048849 & iRemoveType) == 0) {
                z5 = false;
            } else {
                if (iIntValue == 0) {
                    l.add(str);
                }
                z5 = true;
            }
            if (!z5) {
                return iRemoveType;
            }
            if (b.f20525d && (1048833 & i2) != 0) {
                int iNativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z2, z3, i2, z4);
                if (!LogType.isForNative(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                }
                if (!LogType.isForUnexp(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                }
                if (!LogType.isForANR(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                }
            }
            k.put(str, new Object[]{Integer.valueOf(iRemoveType), str2, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)});
            return iRemoveType;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void b(java.io.OutputStream r11, java.lang.String r12, java.lang.String r13, java.util.ArrayList<java.lang.String> r14) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: Throwable -> 0x00d7, all -> 0x0103, TRY_LEAVE, TryCatch #1 {, blocks: (B:8:0x0012, B:9:0x0019, B:11:0x001f, B:12:0x0025, B:14:0x002f, B:20:0x0045, B:22:0x0050, B:24:0x0063, B:34:0x007f, B:36:0x009b, B:38:0x00a3, B:47:0x00c3, B:49:0x00ce, B:40:0x00b0, B:41:0x00b5, B:55:0x00da, B:17:0x003e, B:58:0x00e3, B:59:0x00e7, B:61:0x00ed, B:63:0x00fb, B:64:0x0101), top: B:73:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b0 A[Catch: Throwable -> 0x00d3, all -> 0x0103, TryCatch #1 {, blocks: (B:8:0x0012, B:9:0x0019, B:11:0x001f, B:12:0x0025, B:14:0x002f, B:20:0x0045, B:22:0x0050, B:24:0x0063, B:34:0x007f, B:36:0x009b, B:38:0x00a3, B:47:0x00c3, B:49:0x00ce, B:40:0x00b0, B:41:0x00b5, B:55:0x00da, B:17:0x003e, B:58:0x00e3, B:59:0x00e7, B:61:0x00ed, B:63:0x00fb, B:64:0x0101), top: B:73:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5 A[Catch: Throwable -> 0x00d3, all -> 0x0103, TRY_LEAVE, TryCatch #1 {, blocks: (B:8:0x0012, B:9:0x0019, B:11:0x001f, B:12:0x0025, B:14:0x002f, B:20:0x0045, B:22:0x0050, B:24:0x0063, B:34:0x007f, B:36:0x009b, B:38:0x00a3, B:47:0x00c3, B:49:0x00ce, B:40:0x00b0, B:41:0x00b5, B:55:0x00da, B:17:0x003e, B:58:0x00e3, B:59:0x00e7, B:61:0x00ed, B:63:0x00fb, B:64:0x0101), top: B:73:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.io.OutputStream r18, java.lang.String r19, java.util.ArrayList<java.lang.String> r20) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.util.ArrayList):void");
    }

    static String b(String str) {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            Object[] objArr = A.get(str);
            int iIntValue = ((Integer) objArr[0]).intValue();
            List list = (List) objArr[2];
            sb.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), Integer.valueOf(iIntValue)));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            }
        }
        return sb.toString();
    }

    static String a(String str) {
        synchronized (k) {
            Object[] objArr = k.get(str);
            if (objArr == null) {
                return null;
            }
            int i2 = 1;
            String str2 = (String) objArr[1];
            boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean zBooleanValue2 = ((Boolean) objArr[3]).booleanValue();
            Locale locale = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = str2;
            objArr2[1] = "`";
            objArr2[2] = Integer.valueOf(zBooleanValue ? 1 : 0);
            if (!zBooleanValue2) {
                i2 = 0;
            }
            objArr2[3] = Integer.valueOf(i2);
            return String.format(locale, "%s%s%d%d", objArr2);
        }
    }

    private static boolean a(List<String> list, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0066 A[Catch: all -> 0x0170, TryCatch #0 {, blocks: (B:7:0x000d, B:9:0x0015, B:11:0x002b, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:32:0x0066, B:23:0x004b, B:26:0x0050, B:30:0x005e, B:27:0x0056, B:33:0x006c, B:35:0x0073, B:37:0x0079, B:52:0x00aa, B:54:0x00b1, B:56:0x00b9, B:58:0x00bf, B:60:0x00c3, B:61:0x00c8, B:63:0x00d0, B:65:0x00d8, B:67:0x00de, B:69:0x00e2, B:70:0x00e7, B:72:0x00ef, B:79:0x0101, B:81:0x0103, B:83:0x0107, B:85:0x010d, B:87:0x0119, B:89:0x011f, B:91:0x0126, B:92:0x012b, B:94:0x0131, B:96:0x0137, B:97:0x013c, B:99:0x0142, B:101:0x0148, B:103:0x0150, B:104:0x016e, B:76:0x00f9, B:43:0x0085, B:46:0x008a, B:47:0x0098, B:50:0x00a0), top: B:111:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00aa A[Catch: all -> 0x0170, TryCatch #0 {, blocks: (B:7:0x000d, B:9:0x0015, B:11:0x002b, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:32:0x0066, B:23:0x004b, B:26:0x0050, B:30:0x005e, B:27:0x0056, B:33:0x006c, B:35:0x0073, B:37:0x0079, B:52:0x00aa, B:54:0x00b1, B:56:0x00b9, B:58:0x00bf, B:60:0x00c3, B:61:0x00c8, B:63:0x00d0, B:65:0x00d8, B:67:0x00de, B:69:0x00e2, B:70:0x00e7, B:72:0x00ef, B:79:0x0101, B:81:0x0103, B:83:0x0107, B:85:0x010d, B:87:0x0119, B:89:0x011f, B:91:0x0126, B:92:0x012b, B:94:0x0131, B:96:0x0137, B:97:0x013c, B:99:0x0142, B:101:0x0148, B:103:0x0150, B:104:0x016e, B:76:0x00f9, B:43:0x0085, B:46:0x008a, B:47:0x0098, B:50:0x00a0), top: B:111:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String r16, int r17, java.util.concurrent.Callable<java.lang.String> r18, long r19, int r21) {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.lang.String, int, java.util.concurrent.Callable, long, int):int");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:7|50|8|(3:59|10|(4:57|12|65|61)(4:56|16|(1:18)(1:19)|(1:24)(1:23)))(3:55|13|(4:58|15|62|61)(5:60|16|(0)(0)|(1:21)|24))|52|28|63|61|5) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
    
        com.uc.crashsdk.e.a(r2, r10);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: Throwable -> 0x008d, all -> 0x00d1, TryCatch #1 {Throwable -> 0x008d, blocks: (B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005d, B:21:0x0075, B:23:0x007b, B:24:0x0083, B:19:0x006b, B:13:0x002f), top: B:50:0x0015, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[Catch: Throwable -> 0x008d, all -> 0x00d1, TryCatch #1 {Throwable -> 0x008d, blocks: (B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005d, B:21:0x0075, B:23:0x007b, B:24:0x0083, B:19:0x006b, B:13:0x002f), top: B:50:0x0015, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.io.OutputStream r10, java.lang.String r11, java.lang.String r12, java.util.ArrayList<java.lang.String> r13) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    static String a(String str, boolean z2) {
        String string;
        synchronized (q) {
            Object[] objArr = q.get(str);
            long jLongValue = ((Long) objArr[2]).longValue();
            if (jLongValue != 0) {
                string = JNIBridge.nativeGetCallbackInfo(str, jLongValue, ((Integer) objArr[3]).intValue(), z2);
            } else {
                string = b(str, z2).toString();
            }
        }
        return string;
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        synchronized (y) {
            int id = (int) thread.getId();
            if (y.get(id) == null) {
                z.add(Integer.valueOf(id));
            }
            y.put(id, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc A[Catch: Throwable -> 0x0102, all -> 0x0120, TryCatch #4 {Throwable -> 0x0102, blocks: (B:34:0x00c5, B:36:0x00cc, B:37:0x00d5, B:39:0x00da, B:41:0x00de, B:42:0x00e7), top: B:65:0x00c5, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00da A[Catch: Throwable -> 0x0102, all -> 0x0120, TryCatch #4 {Throwable -> 0x0102, blocks: (B:34:0x00c5, B:36:0x00cc, B:37:0x00d5, B:39:0x00da, B:41:0x00de, B:42:0x00e7), top: B:65:0x00c5, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.io.OutputStream r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String):void");
    }

    public static int a(String str, int i2, int i3) {
        int iRemoveType;
        int iIntValue;
        boolean z2;
        if (str == null || i2 <= 0) {
            return 0;
        }
        if (i2 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        synchronized (A) {
            if (A.containsKey(str)) {
                iIntValue = ((Integer) A.get(str)[1]).intValue();
                iRemoveType = LogType.addType(iIntValue, i3);
            } else {
                iRemoveType = i3;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                if (C >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 16);
                } else {
                    C++;
                }
            }
            if (LogType.isForNative(iRemoveType) && !LogType.isForNative(iIntValue)) {
                if (D >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                } else {
                    D++;
                }
            }
            if (LogType.isForANR(iRemoveType) && !LogType.isForANR(iIntValue)) {
                if (E >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                } else {
                    E++;
                }
            }
            if ((1048849 & iRemoveType) == 0) {
                z2 = false;
            } else {
                if (iIntValue == 0) {
                    B.add(str);
                }
                z2 = true;
            }
            if (!z2) {
                return iRemoveType;
            }
            if (b.f20525d && (i3 & 1048577) != 0) {
                int iNativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i2, iRemoveType);
                if (!LogType.isForNative(iNativeCreateCachedInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                }
                if (!LogType.isForANR(iNativeCreateCachedInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                }
            }
            A.put(str, new Object[]{Integer.valueOf(i2), Integer.valueOf(iRemoveType), new ArrayList()});
            return iRemoveType;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static int a(int i2, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            str = Thread.currentThread().getName();
        }
        ?? r0 = 0;
        r0 = 0;
        if (LogType.isForNative(i2) || LogType.isForANR(i2)) {
            if (b.f20525d) {
                synchronized (y) {
                    JNIBridge.nativeCmd(4, i2, str, null);
                }
                boolean zIsForNative = LogType.isForNative(i2);
                r0 = zIsForNative;
                if (LogType.isForANR(i2)) {
                    r0 = (zIsForNative ? 1 : 0) | 1048576;
                }
            } else {
                com.uc.crashsdk.a.a.a("crashsdk", "crashsdk so has not loaded!", null);
            }
        }
        if (!LogType.isForJava(i2)) {
            return r0;
        }
        a(str, Thread.currentThread());
        return r0 | 16;
    }

    public static boolean a(boolean z2) {
        int iE;
        if (!b.f20524c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        }
        if (e.F() || b.I()) {
            return false;
        }
        if (z2) {
            com.uc.crashsdk.a.f.a(F);
            iE = 0;
        } else {
            if (!b.y()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            }
            if (g.E() <= 0) {
                return false;
            }
            if (com.uc.crashsdk.a.f.b(F)) {
                return true;
            }
            iE = g.E() * 1000;
        }
        com.uc.crashsdk.a.f.a(0, F, iE);
        return true;
    }

    public static void a(int i2) {
        if (i2 == 201) {
            com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (b.f20525d && f20480c) {
                JNIBridge.nativeCmd(11, g.E(), String.valueOf(g.F()), null);
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            a(false);
            return;
        }
        if (i2 != 202) {
            if (!f20481d) {
                throw new AssertionError();
            }
            return;
        }
        p();
        String str = String.format(Locale.US, "%s/%s/%s", g.R(), g.S(), g.T());
        g = m();
        if (b.f20525d) {
            JNIBridge.set(128, g);
        }
        boolean z2 = !str.equals(g);
        if (z2) {
            com.uc.crashsdk.a.b.a(b.j(), str);
        }
        if (z2 && g.u()) {
            com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "Is new version ('%s' -> '%s'), deleting old stats data!", g, str));
            b.s();
        }
    }
}
