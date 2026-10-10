package com.uc.crashsdk.a;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f20484a = {126, 147, 115, 241, 101, 198, 215, 134};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f20485b = {125, 185, 233, 226, 129, 142, 151, 176};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f20486c = {238, 185, 233, 179, 129, 142, 151, 167};

    public static String a(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file = new File(str);
        FileInputStream fileInputStream3 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream2 = new FileInputStream(file);
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream2.read(bArr);
            g.a(fileInputStream2);
            byte[] bArrA = a(bArr, f20484a);
            if (bArrA == null || bArrA.length <= 0) {
                g.a((Closeable) null);
                return null;
            }
            int length = bArrA.length - 1;
            String str2 = bArrA[length] == 10 ? new String(bArrA, 0, length) : new String(bArrA);
            g.a((Closeable) null);
            return str2;
        } catch (Exception e3) {
            fileInputStream = fileInputStream2;
            e = e3;
            try {
                g.a(e);
                g.a(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream3 = fileInputStream;
                g.a(fileInputStream3);
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream3 = fileInputStream2;
            th = th3;
            g.a(fileInputStream3);
            throw th;
        }
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr != null && iArr != null && iArr.length == 8) {
            int length = bArr.length;
            try {
                byte[] bArr2 = new byte[length + 2];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = bArr[i];
                    bArr2[i] = (byte) (iArr[i % 8] ^ b3);
                    b2 = (byte) (b2 ^ b3);
                }
                bArr2[length] = (byte) (iArr[0] ^ b2);
                bArr2[length + 1] = (byte) (iArr[1] ^ b2);
                return bArr2;
            } catch (Exception e2) {
                g.a(e2);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        r1 = com.uc.crashsdk.a.g.e(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8, boolean r9) throws java.lang.Throwable {
        /*
            if (r9 != 0) goto L3
            return r7
        L3:
            boolean r0 = com.uc.crashsdk.a.g.a(r7)
            if (r0 == 0) goto La
            return r7
        La:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r1 = r0.exists()
            if (r1 == 0) goto Lc7
            long r1 = r0.length()
            r3 = 3145728(0x300000, double:1.554196E-317)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L22
            goto Lc7
        L22:
            byte[] r1 = com.uc.crashsdk.a.g.e(r0)
            if (r1 == 0) goto Lc7
            int r2 = r1.length
            if (r2 > 0) goto L2d
            goto Lc7
        L2d:
            r2 = 1
            r3 = 0
            if (r9 == 0) goto L8c
            r9 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L52 java.lang.Throwable -> L55
            r4.<init>()     // Catch: java.lang.Throwable -> L52 java.lang.Throwable -> L55
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L4d
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L4d
            r5.write(r1)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L83
            r4.flush()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L83
        L42:
            com.uc.crashsdk.a.g.a(r4)
            com.uc.crashsdk.a.g.a(r5)
            goto L5d
        L49:
            r9 = move-exception
            goto L59
        L4b:
            r7 = move-exception
            goto L85
        L4d:
            r5 = move-exception
            r6 = r5
            r5 = r9
            r9 = r6
            goto L59
        L52:
            r7 = move-exception
            r4 = r9
            goto L85
        L55:
            r4 = move-exception
            r5 = r9
            r9 = r4
            r4 = r5
        L59:
            com.uc.crashsdk.a.g.a(r9)     // Catch: java.lang.Throwable -> L83
            goto L42
        L5d:
            byte[] r1 = r4.toByteArray()     // Catch: java.lang.Throwable -> L63
            r9 = 1
            goto L68
        L63:
            r9 = move-exception
            com.uc.crashsdk.a.g.a(r9)
            r9 = 0
        L68:
            if (r9 == 0) goto L82
            if (r1 == 0) goto L82
            int r9 = r1.length
            if (r9 > 0) goto L70
            goto L82
        L70:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r9 = r8
            r8 = 1
            goto L8e
        L82:
            return r7
        L83:
            r7 = move-exception
            r9 = r5
        L85:
            com.uc.crashsdk.a.g.a(r4)
            com.uc.crashsdk.a.g.a(r9)
            throw r7
        L8c:
            r9 = r7
            r8 = 0
        L8e:
            if (r8 == 0) goto Lc7
            java.lang.String r8 = r0.getName()
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto Lad
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r9)
            java.lang.String r4 = ".tmp"
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            r4 = 1
            goto Laf
        Lad:
            r8 = r9
            r4 = 0
        Laf:
            java.io.File r5 = new java.io.File
            r5.<init>(r8)
            boolean r8 = com.uc.crashsdk.a.g.a(r5, r1)
            if (r8 != 0) goto Lbc
            r2 = 0
            goto Lc4
        Lbc:
            if (r4 == 0) goto Lc4
            r0.delete()
            r5.renameTo(r0)
        Lc4:
            if (r2 == 0) goto Lc7
            return r9
        Lc7:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 >= 2 && iArr != null && iArr.length == 8) {
            int length = (bArr.length - 2) - 0;
            try {
                byte[] bArr2 = new byte[length];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = (byte) (bArr[i + 0] ^ iArr[i % 8]);
                    bArr2[i] = b3;
                    b2 = (byte) (b2 ^ b3);
                }
                if (bArr[length + 0] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length + 1 + 0] == ((byte) ((iArr[1] ^ b2) & 255))) {
                    return bArr2;
                }
                return null;
            } catch (Exception e2) {
                g.a(e2);
            }
        }
        return null;
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            g.a(th);
            fileOutputStream = null;
        }
        boolean z = false;
        if (fileOutputStream == null) {
            return false;
        }
        byte[] bArrB = b(str2.getBytes(), f20484a);
        try {
            if (bArrB == null) {
                return false;
            }
            try {
                fileOutputStream.write(bArrB);
                z = true;
            } catch (Throwable th2) {
                g.a(th2);
            }
            return z;
        } finally {
            g.a(fileOutputStream);
        }
    }
}
