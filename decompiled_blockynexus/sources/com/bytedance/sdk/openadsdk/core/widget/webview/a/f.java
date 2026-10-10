package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.utils.h;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: Version.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static k f6668a;

    /* JADX WARN: Removed duplicated region for block: B:40:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a() throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Version"
            r1 = 0
            java.io.File r2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.b.f()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            java.lang.String r4 = "temp_pkg_info.json"
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            long r4 = r3.length()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            long r4 = r2.longValue()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L6c
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            if (r4 == 0) goto L6c
            boolean r4 = r3.isFile()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            if (r4 == 0) goto L6c
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
            r4.read(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            java.lang.String r3 = "utf-8"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            com.bytedance.sdk.openadsdk.core.d.k r1 = com.bytedance.sdk.openadsdk.core.d.k.a(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            if (r1 == 0) goto L68
            com.bytedance.sdk.openadsdk.core.widget.webview.a.f.f6668a = r1     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            r1.<init>()     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            java.lang.String r2 = "old version read success: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            com.bytedance.sdk.openadsdk.core.d.k r2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.f.f6668a     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            java.lang.String r2 = r2.b()     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            r1.append(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
            com.bytedance.sdk.openadsdk.utils.o.b(r0, r1)     // Catch: java.lang.Throwable -> L6a java.lang.Throwable -> L88
        L68:
            r1 = r4
            goto L71
        L6a:
            r1 = move-exception
            goto L7d
        L6c:
            java.lang.String r2 = "version pkg json file does not exist"
            com.bytedance.sdk.openadsdk.utils.o.b(r0, r2)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L7a
        L71:
            if (r1 == 0) goto L87
            r1.close()     // Catch: java.io.IOException -> L87
            goto L87
        L77:
            r0 = move-exception
            r4 = r1
            goto L89
        L7a:
            r2 = move-exception
            r4 = r1
            r1 = r2
        L7d:
            java.lang.String r2 = "version init error"
            com.bytedance.sdk.openadsdk.utils.o.c(r0, r2, r1)     // Catch: java.lang.Throwable -> L88
            if (r4 == 0) goto L87
            r4.close()     // Catch: java.io.IOException -> L87
        L87:
            return
        L88:
            r0 = move-exception
        L89:
            if (r4 == 0) goto L8e
            r4.close()     // Catch: java.io.IOException -> L8e
        L8e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.webview.a.f.a():void");
    }

    public static synchronized k b() {
        return f6668a;
    }

    public static void c() throws Throwable {
        FileOutputStream fileOutputStream;
        k kVar = f6668a;
        if (kVar == null) {
            o.b("Version", "version save error1");
            return;
        }
        String strF = kVar.f();
        if (TextUtils.isEmpty(strF)) {
            o.b("Version", "version save error2");
            return;
        }
        File file = new File(b.f(), "temp_pkg_info.json");
        File file2 = new File(file + ".tmp");
        if (file2.exists()) {
            file2.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
            try {
                fileOutputStream.write(strF.getBytes("utf-8"));
                if (file.exists()) {
                    file.delete();
                }
                file2.renameTo(file);
                fileOutputStream.close();
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                o.c("Version", "version save error3", th);
                if (fileOutputStream2 == null) {
                } else {
                    fileOutputStream2.close();
                }
            }
        } catch (IOException unused) {
        }
    }

    public static void d() {
        k kVarB = b();
        if (kVarB == null) {
            return;
        }
        File fileF = b.f();
        try {
            new File(fileF, "temp_pkg_info.json").delete();
        } catch (Throwable unused) {
        }
        if (kVarB.d() != null) {
            Iterator<k.a> it = kVarB.d().iterator();
            while (it.hasNext()) {
                try {
                    new File(fileF, h.a(it.next().a())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
        f6668a = null;
    }

    public static boolean b(String str) {
        if (b() != null && !TextUtils.isEmpty(b().b())) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String strB = b().b();
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = strB.split("\\.");
            int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
            for (int i = 0; i < iMin; i++) {
                int length = strArrSplit[i].length() - strArrSplit2[i].length();
                if (length != 0) {
                    return length > 0;
                }
                int iCompareTo = strArrSplit[i].compareTo(strArrSplit2[i]);
                if (iCompareTo > 0) {
                    return true;
                }
                if (iCompareTo < 0) {
                    return false;
                }
                if (i == iMin - 1) {
                    return strArrSplit.length > strArrSplit2.length;
                }
            }
            return false;
        }
        return true;
    }

    public static synchronized void a(k kVar) {
        if (kVar != null) {
            if (kVar.e()) {
                f6668a = kVar;
            }
        }
    }

    public static k.a a(String str) {
        if (!TextUtils.isEmpty(str) && b() != null && b().d() != null && b().e()) {
            for (k.a aVar : b().d()) {
                if (aVar.a() != null && aVar.a().equals(str)) {
                    return aVar;
                }
            }
        }
        return null;
    }
}
