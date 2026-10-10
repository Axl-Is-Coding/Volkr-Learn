package com.uc.crashsdk;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.uc.crashsdk.a.h;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f20557a = !f.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, SparseIntArray> f20558b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f20559c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseArray<String> f20560d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f20561e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f20562f = false;

    static void a(int i) {
        a(i, 1);
    }

    private static boolean b(int i, int i2) {
        try {
            b.u();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            String strC = c(i);
            if (strC == null) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stat type not exists: " + i, null);
                return false;
            }
            File file = new File(b.c());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            StringBuffer stringBufferA = a(file);
            if (com.uc.crashsdk.a.g.a(stringBufferA)) {
                if (stringBufferA == null) {
                    stringBufferA = new StringBuffer();
                }
                stringBufferA.append("[");
                stringBufferA.append(e.h());
                stringBufferA.append("]\n");
            }
            a(stringBufferA, strC, a(stringBufferA, strC) + i2);
            return a(file, stringBufferA);
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
            return false;
        }
    }

    private static boolean c(String str) {
        SparseIntArray sparseIntArray = f20558b.get(str);
        if (sparseIntArray == null) {
            return false;
        }
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int iKeyAt = sparseIntArray.keyAt(i);
            d.a(str, iKeyAt, sparseIntArray.get(iKeyAt));
        }
        return true;
    }

    private static char[] d() {
        char[] cArr = null;
        int i = 1024;
        while (cArr == null && i > 0) {
            try {
                cArr = new char[i];
            } catch (Throwable unused) {
                i /= 2;
                if (i < 512) {
                    return cArr;
                }
            }
        }
        return cArr;
    }

    private static void e() {
        synchronized (f20560d) {
            if (f20560d.size() != 0) {
                return;
            }
            f20560d.put(100, "start_pv");
            f20560d.put(102, "start_hpv");
            f20560d.put(1, "all_all");
            f20560d.put(2, "all_fg");
            f20560d.put(101, "all_bg");
            f20560d.put(3, "java_fg");
            f20560d.put(4, "java_bg");
            f20560d.put(7, "native_fg");
            f20560d.put(8, "native_bg");
            f20560d.put(27, "native_anr_fg");
            f20560d.put(28, "native_anr_bg");
            f20560d.put(9, "native_ok");
            f20560d.put(10, "unexp_anr");
            f20560d.put(29, "unexp_lowmem");
            f20560d.put(30, "unexp_killed");
            f20560d.put(31, "unexp_exit");
            f20560d.put(32, "unexp_restart");
            f20560d.put(11, "unexp_fg");
            f20560d.put(12, "unexp_bg");
            f20560d.put(40, "anr_fg");
            f20560d.put(41, "anr_bg");
            f20560d.put(42, "anr_cr_fg");
            f20560d.put(43, "anr_cr_bg");
            f20560d.put(13, "log_up_succ");
            f20560d.put(14, "log_up_fail");
            f20560d.put(15, "log_empty");
            f20560d.put(200, "log_tmp");
            f20560d.put(16, "log_abd_all");
            f20560d.put(22, "log_abd_builtin");
            f20560d.put(23, "log_abd_custom");
            f20560d.put(17, "log_large");
            f20560d.put(18, "log_up_all");
            f20560d.put(19, "log_up_bytes");
            f20560d.put(20, "log_up_crash");
            f20560d.put(21, "log_up_custom");
            f20560d.put(24, "log_zipped");
            f20560d.put(201, "log_enced");
            f20560d.put(25, "log_renamed");
            f20560d.put(26, "log_safe_skip");
        }
    }

    private static File[] f() {
        File[] fileArrListFiles = new File(g.U()).listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            if (file.getPath().endsWith(".st")) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    static void a(int i, int i2) {
        if (i2 != 0) {
            a(b.c(), new com.uc.crashsdk.a.e(751, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            return;
        }
        com.uc.crashsdk.a.a.b("Add stat for type " + i + " with count 0!");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004a A[Catch: all -> 0x0056, TryCatch #0 {, blocks: (B:7:0x0008, B:9:0x000c, B:11:0x000e, B:13:0x0016, B:15:0x0018, B:17:0x0020, B:19:0x002a, B:27:0x004a, B:28:0x004d, B:29:0x0054, B:21:0x0031, B:23:0x0037, B:25:0x0042), top: B:36:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void d(boolean r3) {
        /*
            boolean r0 = com.uc.crashsdk.f.f20562f
            if (r0 == 0) goto L5
            return
        L5:
            java.lang.Object r0 = com.uc.crashsdk.f.f20561e
            monitor-enter(r0)
            boolean r1 = com.uc.crashsdk.f.f20562f     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        Le:
            java.lang.String r1 = "crash detail"
            boolean r3 = com.uc.crashsdk.a.h.a(r3, r1)     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L18
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        L18:
            r3 = 0
            boolean r1 = com.uc.crashsdk.b.p()     // Catch: java.lang.Throwable -> L56
            r2 = 1
            if (r1 == 0) goto L31
            r3 = 2
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            boolean r3 = com.uc.crashsdk.b.o()     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L2f
            r3 = 42
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
        L2f:
            r3 = 1
            goto L48
        L31:
            boolean r1 = com.uc.crashsdk.b.q()     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L48
            r3 = 101(0x65, float:1.42E-43)
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            boolean r3 = com.uc.crashsdk.b.o()     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L2f
            r3 = 43
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            goto L2f
        L48:
            if (r3 == 0) goto L4d
            a(r2, r2)     // Catch: java.lang.Throwable -> L56
        L4d:
            r3 = 100
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            com.uc.crashsdk.f.f20562f = r2     // Catch: java.lang.Throwable -> L56
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        L56:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            goto L5a
        L59:
            throw r3
        L5a:
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.d(boolean):void");
    }

    private static String c(int i) {
        String str;
        e();
        synchronized (f20560d) {
            str = f20560d.get(i);
        }
        return str;
    }

    private static StringBuffer a(File file) throws Throwable {
        FileReader fileReader;
        FileReader fileReader2 = null;
        if (!file.exists()) {
            return null;
        }
        char[] cArrD = d();
        if (cArrD == null) {
            com.uc.crashsdk.a.a.a("crashsdk", "readCrashStatData alloc buffer failed!", null);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                fileReader = new FileReader(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            int i = fileReader.read(cArrD);
            if (i > 0) {
                fileReader2 = null;
                stringBuffer.append(cArrD, 0, i);
            }
            com.uc.crashsdk.a.g.a(fileReader);
        } catch (Exception e3) {
            e = e3;
            fileReader2 = fileReader;
            com.uc.crashsdk.a.g.a(e);
            com.uc.crashsdk.a.g.a(fileReader2);
        } catch (Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            com.uc.crashsdk.a.g.a(fileReader2);
            throw th;
        }
        return stringBuffer;
    }

    static void c(boolean z) {
        if (g.O() && !b.I()) {
            e.j();
            if (!h.e()) {
                h.a(z);
            }
            if (b.C()) {
                d(z);
                a(b.c(), z);
                h.b(z);
            }
        }
    }

    private static int a(StringBuffer stringBuffer, String str) {
        int iIndexOf = stringBuffer.indexOf(str);
        if (iIndexOf < 0) {
            return 0;
        }
        int iIndexOf2 = stringBuffer.indexOf("=", iIndexOf + str.length());
        if (iIndexOf2 < 0) {
            com.uc.crashsdk.a.a.b(str + " line not contain '='!");
            return 0;
        }
        int i = iIndexOf2 + 1;
        int iIndexOf3 = stringBuffer.indexOf(UMCustomLogInfoBuilder.LINE_SEP, i);
        if (iIndexOf3 < 0) {
            iIndexOf3 = stringBuffer.length();
        }
        try {
            int i2 = Integer.parseInt(stringBuffer.substring(i, iIndexOf3));
            if (i2 < 0) {
                return 0;
            }
            return i2;
        } catch (NumberFormatException e2) {
            com.uc.crashsdk.a.g.a(e2);
            return 0;
        }
    }

    private static boolean b(String str) {
        e();
        synchronized (f20560d) {
            File file = new File(str);
            StringBuffer stringBufferA = a(file);
            if (com.uc.crashsdk.a.g.a(stringBufferA)) {
                return false;
            }
            int iIndexOf = stringBufferA.indexOf("[");
            if (iIndexOf < 0) {
                com.uc.crashsdk.a.a.a("crashsdk", "Can not found process name start!", null);
                return false;
            }
            int i = iIndexOf + 1;
            int iIndexOf2 = stringBufferA.indexOf("]", i);
            if (iIndexOf2 < 0) {
                com.uc.crashsdk.a.a.a("crashsdk", "Can not found process name end!", null);
                return false;
            }
            String strSubstring = stringBufferA.substring(i, iIndexOf2);
            boolean z = false;
            for (int i2 = 0; i2 < f20560d.size(); i2++) {
                try {
                    int iKeyAt = f20560d.keyAt(i2);
                    String str2 = f20560d.get(iKeyAt);
                    int iA = a(stringBufferA, str2);
                    if (iA > 0) {
                        h.a(strSubstring, iKeyAt, iA);
                        synchronized (f20558b) {
                            SparseIntArray sparseIntArray = f20558b.get(strSubstring);
                            if (sparseIntArray == null) {
                                sparseIntArray = new SparseIntArray();
                                f20558b.put(strSubstring, sparseIntArray);
                            }
                            sparseIntArray.put(iKeyAt, sparseIntArray.get(iKeyAt, 0) + iA);
                        }
                        a(stringBufferA, str2, 0);
                        z = true;
                    }
                } finally {
                    if (z) {
                        a(file, stringBufferA);
                    }
                }
            }
            return true;
        }
    }

    static void c() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(700), 3000L);
    }

    private static void a(StringBuffer stringBuffer, String str, int i) {
        int iIndexOf = stringBuffer.indexOf(str);
        if (iIndexOf < 0) {
            if (i > 0) {
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(i);
                stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
                return;
            }
            return;
        }
        int iIndexOf2 = stringBuffer.indexOf(UMCustomLogInfoBuilder.LINE_SEP, iIndexOf);
        if (iIndexOf2 < 0) {
            iIndexOf2 = stringBuffer.length();
        }
        stringBuffer.replace(iIndexOf, iIndexOf2, str + "=" + String.valueOf(i));
    }

    private static boolean a(File file, StringBuffer stringBuffer) throws Throwable {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String string = stringBuffer.toString();
            fileWriter.write(string, 0, string.length());
            com.uc.crashsdk.a.g.a(fileWriter);
            return true;
        } catch (Exception e3) {
            e = e3;
            fileWriter2 = fileWriter;
            com.uc.crashsdk.a.g.a(e);
            com.uc.crashsdk.a.g.a(fileWriter2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            com.uc.crashsdk.a.g.a(fileWriter2);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static int a(boolean z) {
        int i;
        synchronized (f20558b) {
            if (z) {
                String strH = e.h();
                boolean zC = c(strH);
                f20558b.remove(strH);
                i = zC;
            } else {
                Iterator<String> it = f20558b.keySet().iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (c(it.next())) {
                        i2++;
                    }
                }
                f20558b.clear();
                i = i2;
            }
        }
        return i;
    }

    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        return b.a(f20559c, str, eVar);
    }

    static boolean a(String str, boolean z) {
        if (h.a(z, "crash detail report")) {
            return false;
        }
        return a(str, new com.uc.crashsdk.a.e(752, new Object[]{str}));
    }

    static int b(boolean z) {
        int size;
        synchronized (f20558b) {
            if (z) {
                String strH = e.h();
                if (f20558b.containsKey(strH)) {
                    f20558b.remove(strH);
                    size = 1;
                } else {
                    size = 0;
                }
            } else {
                size = f20558b.size();
                f20558b.clear();
            }
        }
        return size;
    }

    static int a() {
        File[] fileArrF = f();
        if (fileArrF == null) {
            return 0;
        }
        int i = 0;
        for (File file : fileArrF) {
            if (a(file.getAbsolutePath(), false)) {
                i++;
            }
        }
        return i;
    }

    static boolean a(String str) {
        return a(str, new com.uc.crashsdk.a.e(753, new Object[]{str}));
    }

    public static boolean a(int i, Object[] objArr) {
        switch (i) {
            case 751:
                if (f20557a || objArr != null) {
                    return b(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                }
                throw new AssertionError();
            case 752:
                if (f20557a || objArr != null) {
                    return b((String) objArr[0]);
                }
                throw new AssertionError();
            case 753:
                if (!f20557a && objArr == null) {
                    throw new AssertionError();
                }
                File file = new File((String) objArr[0]);
                if (!file.exists()) {
                    return false;
                }
                file.delete();
                return true;
            default:
                return false;
        }
    }

    static int b() {
        File[] fileArrF = f();
        if (fileArrF == null) {
            return 0;
        }
        int i = 0;
        for (File file : fileArrF) {
            if (a(file.getAbsolutePath())) {
                i++;
            }
        }
        return i;
    }

    public static void b(int i) {
        if (i != 700) {
            return;
        }
        d(false);
    }
}
