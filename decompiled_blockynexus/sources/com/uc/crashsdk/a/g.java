package com.uc.crashsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.sandboxol.vip.entity.VipDiamond;
import com.uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.ci;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f20505b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f20504a = !g.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f20506c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f20507d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f20508e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f20509f = null;
    private static String g = null;
    private static boolean h = false;
    private static final Object i = new Object();
    private static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(File file, File file2) throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                while (true) {
                    try {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            a(fileInputStream);
                            a(fileOutputStream2);
                            return;
                        }
                        fileOutputStream2.write(bArr, 0, i2);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void b(File file) {
        a(file, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable, java.io.FileInputStream] */
    public static String c(File file) throws Throwable {
        ?? fileInputStream;
        String string = "";
        if (!file.exists()) {
            return "";
        }
        ?? r0 = 0;
        ?? r02 = 0;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                fileInputStream = r0;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byte[] bArr = new byte[256];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                sb.append(new String(bArr, 0, i2));
            }
            string = sb.toString();
            a((Closeable) fileInputStream);
            r0 = sb;
        } catch (Throwable th3) {
            th = th3;
            r02 = fileInputStream;
            a(th, false);
            a((Closeable) r02);
            r0 = r02;
        }
        return string;
    }

    public static String d(File file) {
        return a(file, 64, true);
    }

    public static byte[] e(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    fileInputStream.read(bArr);
                    a(fileInputStream);
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    a(th, false);
                    a(fileInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                a(fileInputStream2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a(fileInputStream2);
            throw th;
        }
    }

    public static boolean f() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean g() {
        int iIndexOf;
        String strI = i();
        if (!a(strI) && (iIndexOf = strI.indexOf(" root ")) > 0) {
            String strSubstring = strI.substring(0, iIndexOf);
            if (strSubstring.contains("x") || strSubstring.contains(au.ax)) {
                return true;
            }
        }
        return false;
    }

    public static String h() {
        l();
        return a(f20509f) ? "" : f20509f;
    }

    public static String i() {
        l();
        return a(g) ? "" : g;
    }

    public static void j() {
        f.a(0, new e(VipDiamond.MVP), 15000L);
    }

    public static void k() {
        if (com.uc.crashsdk.b.f20525d && h) {
            JNIBridge.set(123, f20509f);
            JNIBridge.set(124, g);
        }
    }

    private static void l() {
        String strTrim;
        int iIndexOf;
        int iIndexOf2;
        if (h) {
            return;
        }
        synchronized (i) {
            if (h) {
                return;
            }
            String strA = a(new String[]{"sh", "-c", "type su"});
            if (!a(strA) && (iIndexOf = (strTrim = strA.trim()).indexOf(32)) > 0 && strTrim.contains("/su") && (iIndexOf2 = strTrim.indexOf(47, iIndexOf + 1)) > 0) {
                f20509f = strTrim.substring(iIndexOf2);
                String strA2 = a(new String[]{"ls", "-l", f20509f});
                if (!a(strA2)) {
                    g = strA2.trim();
                }
            }
            h = true;
            k();
        }
    }

    public static boolean a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static String d() {
        String str = f20508e;
        return str != null ? str : "";
    }

    public static void b(Throwable th) {
        a(th, true);
    }

    public static String d(String str) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            int length = bArrDigest.length;
            StringBuilder sb = new StringBuilder(length * 2);
            int i2 = length + 0;
            for (int i3 = 0; i3 < i2; i3++) {
                byte b2 = bArrDigest[i3];
                char c2 = j[(b2 & 240) >> 4];
                char c3 = j[b2 & ci.m];
                sb.append(c2);
                sb.append(c3);
            }
            return sb.toString();
        } catch (Exception e2) {
            a.a("crashsdk", "getMD5: ", e2);
            return null;
        }
    }

    public static String b() {
        return f20506c;
    }

    public static String a(File file, int i2, boolean z) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[i2];
                    int i3 = fileInputStream.read(bArr);
                    if (i3 > 0) {
                        String str = new String(bArr, 0, i3);
                        a(fileInputStream);
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (z) {
                        a(th, false);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                a(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        a(fileInputStream);
        return null;
    }

    public static boolean e() {
        if (g()) {
            return true;
        }
        return f();
    }

    public static long c(String str) {
        if (a(str)) {
            return 0L;
        }
        try {
            long j2 = Long.parseLong(str.trim());
            if (j2 < 0) {
                return 0L;
            }
            return j2;
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static String c() {
        return f20507d;
    }

    public static ArrayList<String> a(File file, int i2) throws Throwable {
        BufferedReader bufferedReader;
        Reader fileReader;
        ArrayList<String> arrayList = new ArrayList<>();
        Reader reader = null;
        try {
            fileReader = new FileReader(file);
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            bufferedReader = new BufferedReader(fileReader, 512);
            int i3 = 0;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    arrayList.add(line);
                    i3++;
                    if (i2 > 0 && i3 >= i2) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    reader = bufferedReader;
                    a(fileReader);
                    a(reader);
                    throw th;
                }
            }
            a(fileReader);
        } catch (Throwable th3) {
            th = th3;
            a(fileReader);
            a(reader);
            throw th;
        }
        a(bufferedReader);
        return arrayList;
    }

    public static boolean a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            a(fileOutputStream);
            return true;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            a(th, false);
            a(fileOutputStream2);
            return false;
        }
    }

    public static boolean a(File file, String str) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            fileWriter.write(str, 0, str.length());
            a(fileWriter);
            return true;
        } catch (Throwable th3) {
            th = th3;
            fileWriter2 = fileWriter;
            a(th, false);
            a(fileWriter2);
            return false;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                a(th, true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[PHI: r2
      0x0029: PHI (r2v2 java.lang.String) = (r2v1 java.lang.String), (r2v3 java.lang.String) binds: [B:7:0x0017, B:9:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r2, java.lang.String r3, boolean r4) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 == 0) goto L2a
            java.lang.String r2 = com.uc.crashsdk.a.b.a(r2)
            boolean r0 = a(r2)
            if (r0 == 0) goto L17
            goto L2a
        L17:
            if (r4 == 0) goto L29
            java.lang.String r2 = r2.trim()
            java.lang.String r4 = r2.toLowerCase()
            java.lang.String r0 = "http"
            boolean r4 = r4.startsWith(r0)
            if (r4 == 0) goto L2a
        L29:
            r1 = r2
        L2a:
            if (r1 != 0) goto L2d
            goto L2e
        L2d:
            r3 = r1
        L2e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.g.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    public static void a(Throwable th) {
        a(th, false);
    }

    private static void a(Throwable th, boolean z) {
        if (!z) {
            try {
                if (!com.uc.crashsdk.g.M()) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        th.printStackTrace();
    }

    public static void a(Context context) {
        if (f20505b != null) {
            a.b("mContext is existed");
        }
        f20505b = context;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        f20506c = applicationInfo.dataDir;
        f20507d = applicationInfo.sourceDir;
        try {
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(applicationInfo);
            if (obj == null || !(obj instanceof String)) {
                return;
            }
            f20508e = (String) obj;
        } catch (Throwable th) {
            a(th, false);
        }
    }

    public static Context a() {
        return f20505b;
    }

    public static void a(int i2) {
        if (i2 != 800) {
            if (!f20504a) {
                throw new AssertionError();
            }
        } else {
            l();
        }
    }

    private static String a(String[] strArr) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        StringBuilder sb;
        BufferedReader bufferedReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 512);
                try {
                    try {
                        sb = new StringBuilder();
                    } catch (Throwable th) {
                        th = th;
                        a(th, false);
                        a(bufferedReader);
                        a(inputStreamReader);
                        return null;
                    }
                } catch (Throwable th2) {
                    bufferedReader2 = bufferedReader;
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
            } else {
                String strTrim = sb.toString().trim();
                a(bufferedReader);
                a(inputStreamReader);
                return strTrim;
            }
            bufferedReader2 = bufferedReader;
            th = th2;
            a(bufferedReader2);
            a(inputStreamReader);
            throw th;
        }
    }
}
