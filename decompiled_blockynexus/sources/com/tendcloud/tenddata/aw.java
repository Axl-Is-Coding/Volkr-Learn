package com.tendcloud.tenddata;

import android.content.SharedPreferences;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
final class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f19809a = "mPBE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f19810b = "_Ladder_Project";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f19811c = "Pythagoras_phase";

    private aw() {
    }

    static void a(String str, byte[] bArr) throws Throwable {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append((int) b2);
            sb.append(",");
        }
        a(ab.g.getFilesDir() + File.separator + f19809a, str, sb.toString());
    }

    static void b(String str, String str2) throws Throwable {
        a(ab.g.getFilesDir().getPath(), str, str2);
    }

    static void c(String str, String str2) {
        System.getProperties().setProperty(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0050 A[EXC_TOP_SPLITTER, PHI: r1 r5
      0x0050: PHI (r1v1 java.lang.String) = (r1v0 java.lang.String), (r1v3 java.lang.String) binds: [B:32:0x005c, B:24:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0050: PHI (r5v5 java.io.FileInputStream) = (r5v3 java.io.FileInputStream), (r5v6 java.io.FileInputStream) binds: [B:32:0x005c, B:24:0x004e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String d(java.lang.String r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            java.lang.String r1 = ""
            if (r5 != 0) goto L1a
            boolean r5 = r0.isDirectory()
            if (r5 != 0) goto L1a
            boolean r5 = r0.mkdirs()
            if (r5 != 0) goto L1a
            return r1
        L1a:
            r5 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L5b
            r2.<init>(r0, r6)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L5b
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L5b
            if (r6 == 0) goto L47
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L5b
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L5b
            long r2 = r2.length()     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L45
            int r5 = (int) r2     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L45
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L45
            int r0 = r6.read(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L45
            if (r0 <= 0) goto L3e
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L45
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L45
            r1 = r0
        L3e:
            r5 = r6
            goto L4e
        L40:
            r5 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
            goto L55
        L45:
            r5 = r6
            goto L5c
        L47:
            boolean r6 = r2.createNewFile()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L5b
            if (r6 != 0) goto L4e
            return r1
        L4e:
            if (r5 == 0) goto L5f
        L50:
            r5.close()     // Catch: java.lang.Throwable -> L5f
            goto L5f
        L54:
            r6 = move-exception
        L55:
            if (r5 == 0) goto L5a
            r5.close()     // Catch: java.lang.Throwable -> L5a
        L5a:
            throw r6
        L5b:
        L5c:
            if (r5 == 0) goto L5f
            goto L50
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.aw.d(java.lang.String, java.lang.String):java.lang.String");
    }

    static String c(String str) {
        return System.getProperties().getProperty(str);
    }

    static String b(String str) {
        return d(ab.g.getFilesDir().getPath(), str);
    }

    static void a(String str, String str2) throws Throwable {
        a(ab.g.getFilesDir() + File.separator + f19810b, str, str2);
    }

    private static void a(String str, String str2, String str3) throws Throwable {
        File file;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                file = new File(str);
            } catch (Throwable unused) {
                return;
            }
        } catch (Throwable unused2) {
        }
        if (file.exists() || file.isDirectory() || file.mkdirs()) {
            File file2 = new File(file, str2);
            if (file2.exists() || file2.createNewFile()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(str3.getBytes());
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                }
                return;
            }
            return;
        }
        return;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused3) {
            }
        }
        throw th;
    }

    static byte[] a(String str, int i) throws Throwable {
        SharedPreferences sharedPreferences = ab.g.getSharedPreferences(f19809a, 0);
        String string = sharedPreferences.getString(str, "");
        String str2 = ab.g.getFilesDir() + File.separator + f19809a;
        String strD = d(str2, str);
        if (af.b(strD)) {
            if (af.b(string)) {
                return null;
            }
            a(str2, str, string);
            sharedPreferences.edit().putString(str, "").apply();
            return a(i, string);
        }
        return a(i, strD);
    }

    static String a(String str) throws Throwable {
        SharedPreferences sharedPreferences = ab.g.getSharedPreferences(f19811c, 0);
        String string = sharedPreferences.getString(str, "");
        String str2 = ab.g.getFilesDir() + File.separator + f19810b;
        String strD = d(str2, str);
        if (!af.b(strD) || af.b(string)) {
            return strD;
        }
        a(str2, str, string);
        sharedPreferences.edit().putString(str, "").apply();
        return string;
    }

    private static byte[] a(int i, String str) {
        try {
            if (af.b(str)) {
                return null;
            }
            byte[] bArr = new byte[i];
            String[] strArrSplit = str.split(",");
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                bArr[i2] = Byte.parseByte(strArrSplit[i2]);
            }
            return bArr;
        } catch (Throwable unused) {
            return null;
        }
    }
}
