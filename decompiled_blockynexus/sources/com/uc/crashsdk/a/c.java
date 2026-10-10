package com.uc.crashsdk.a;

import io.grpc.internal.GrpcUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f20487a = !c.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f20488b = "";

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, true);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return a(bArr, bArr2, z, true);
    }

    private static boolean b(File file, String str, String str2) throws Throwable {
        try {
            byte[] bArrA = a(file);
            if (bArrA != null && bArrA.length != 0) {
                return a(bArrA, str, str2);
            }
            return false;
        } catch (Exception e2) {
            g.a(e2);
            return false;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(z ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (!z) {
            return cipher.doFinal(bArr);
        }
        if (!z2) {
            bArr = a(bArr);
        }
        return cipher.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 16];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i = 4; i < 16; i++) {
            bArr2[i] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    public static byte[] a() {
        return new byte[]{48, 25, 6, 55};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r8, byte[] r9) throws java.lang.Throwable {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb5
            r1.<init>(r8)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb5
            java.net.URLConnection r8 = r1.openConnection()     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb5
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> Lb5
            r1 = 5000(0x1388, float:7.006E-42)
            r8.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> L9f
            r8.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> L9f
            r1 = 1
            r8.setDoInput(r1)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> L9f
            r8.setDoOutput(r1)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> L9f
            java.lang.String r1 = "POST"
            r8.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> L9f
            r1 = 0
            r8.setUseCaches(r1)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> L9f
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r8.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> L9f
            java.lang.String r2 = "Content-Length"
            int r3 = r9.length     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> L9f
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> L9f
            r8.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> L9f
            java.io.OutputStream r2 = r8.getOutputStream()     // Catch: java.lang.Throwable -> L9a java.lang.Throwable -> L9f
            r2.write(r9)     // Catch: java.lang.Throwable -> L91 java.lang.Throwable -> L97
            int r9 = r8.getResponseCode()     // Catch: java.lang.Throwable -> L91 java.lang.Throwable -> L97
            r3 = 200(0xc8, float:2.8E-43)
            if (r9 == r3) goto L53
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r0)
            com.uc.crashsdk.a.g.a(r0)
            if (r8 == 0) goto L52
            r8.disconnect()     // Catch: java.lang.Throwable -> L52
        L52:
            return r0
        L53:
            java.io.InputStream r9 = r8.getInputStream()     // Catch: java.lang.Throwable -> L91 java.lang.Throwable -> L97
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L87 java.lang.Throwable -> L8f
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L87 java.lang.Throwable -> L8f
            int r5 = r9.available()     // Catch: java.lang.Throwable -> L87 java.lang.Throwable -> L8f
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L87 java.lang.Throwable -> L8f
        L64:
            int r5 = r9.read(r3)     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> Lb9
            r6 = -1
            if (r5 == r6) goto L6f
            r4.write(r3, r1, r5)     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> Lb9
            goto L64
        L6f:
            byte[] r0 = r4.toByteArray()     // Catch: java.lang.Throwable -> L82 java.lang.Throwable -> Lb9
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r9)
            com.uc.crashsdk.a.g.a(r4)
            if (r8 == 0) goto L81
            r8.disconnect()     // Catch: java.lang.Throwable -> L81
        L81:
            return r0
        L82:
            r0 = move-exception
            r1 = r8
            r8 = r9
            r9 = r0
            goto L95
        L87:
            r1 = move-exception
            r4 = r0
            r0 = r2
            r7 = r1
            r1 = r8
            r8 = r9
            r9 = r7
            goto La6
        L8f:
            r4 = r0
            goto Lb9
        L91:
            r9 = move-exception
            r1 = r8
            r8 = r0
            r4 = r8
        L95:
            r0 = r2
            goto La6
        L97:
            r9 = r0
            r4 = r9
            goto Lb9
        L9a:
            r9 = move-exception
            r1 = r8
            r8 = r0
            r4 = r8
            goto La6
        L9f:
            r9 = r0
            goto Lb7
        La1:
            r8 = move-exception
            r9 = r8
            r8 = r0
            r1 = r8
            r4 = r1
        La6:
            com.uc.crashsdk.a.g.a(r0)
            com.uc.crashsdk.a.g.a(r8)
            com.uc.crashsdk.a.g.a(r4)
            if (r1 == 0) goto Lb4
            r1.disconnect()     // Catch: java.lang.Throwable -> Lb4
        Lb4:
            throw r9
        Lb5:
            r8 = r0
            r9 = r8
        Lb7:
            r2 = r9
            r4 = r2
        Lb9:
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r9)
            com.uc.crashsdk.a.g.a(r4)
            if (r8 == 0) goto Lc7
            r8.disconnect()     // Catch: java.lang.Throwable -> Lc7
        Lc7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.c.a(java.lang.String, byte[]):byte[]");
    }

    public static void a(byte[] bArr, int i, byte[] bArr2) {
        if (!f20487a && bArr2.length != 4) {
            throw new AssertionError();
        }
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2 + i] = bArr2[i2];
        }
    }

    private static byte[] a(File file) throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr;
        int length;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        byte[] bArr2 = null;
        bufferedInputStream2 = null;
        bufferedInputStream2 = null;
        bufferedInputStream2 = null;
        if (!file.isFile()) {
            return null;
        }
        try {
            length = (int) file.length();
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    bArr = null;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e3) {
            e = e3;
            bArr = null;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            bArr2 = new byte[length];
            int i = 0;
            while (i < length) {
                int i2 = bufferedInputStream.read(bArr2, i, length - i);
                if (-1 == i2) {
                    break;
                }
                i += i2;
            }
            g.a(bufferedInputStream);
            g.a(fileInputStream);
            return bArr2;
        } catch (Exception e4) {
            e = e4;
            byte[] bArr3 = bArr2;
            bufferedInputStream2 = bufferedInputStream;
            bArr = bArr3;
            g.b(e);
            g.a(bufferedInputStream2);
            g.a(fileInputStream);
            return bArr;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            g.a(bufferedInputStream2);
            g.a(fileInputStream);
            throw th;
        }
    }

    public static boolean a(File file, String str, String str2) {
        for (int i = 0; i < 2; i++) {
            if (b(file, str, str2)) {
                return true;
            }
            a.a("crashsdk", "upload try again: " + str);
        }
        return false;
    }

    private static boolean a(byte[] bArr, String str, String str2) throws Throwable {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        a.a("Uploading to " + str2);
        OutputStream outputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
                httpURLConnection.setUseCaches(false);
                StringBuilder sb = new StringBuilder();
                sb.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\";");
                sb.append(" filename=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n");
                sb.append("\r\n");
                int length = sb.length() + 40 + bArr.length;
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                httpURLConnection.setRequestProperty("Content-Disposition", "form-data; name=\"file\"; filename=" + str);
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(length));
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(sb.toString().getBytes());
                    outputStream2.write(bArr);
                    outputStream2.write("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    a.a("crashsdk", "Response code: " + responseCode);
                    if (responseCode != 200) {
                        g.a(outputStream2);
                        g.a((Closeable) null);
                        g.a((Closeable) null);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused) {
                            }
                        }
                        return false;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int i = inputStream.read(bArr2);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, i);
                            } catch (Throwable th) {
                                th = th;
                                outputStream = outputStream2;
                                try {
                                    g.b(th);
                                    g.a(outputStream);
                                    g.a(inputStream);
                                    g.a(byteArrayOutputStream);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray != null) {
                            a.a("crashsdk", "Log upload response: " + new String(byteArray));
                            g.a(outputStream2);
                            g.a(inputStream);
                            g.a(byteArrayOutputStream);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused3) {
                                }
                            }
                            return true;
                        }
                        g.a(outputStream2);
                        g.a(inputStream);
                        g.a(byteArrayOutputStream);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused4) {
                            }
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
                outputStream = outputStream2;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            httpURLConnection = null;
            byteArrayOutputStream = null;
        }
        g.a(outputStream);
        g.a(inputStream);
        g.a(byteArrayOutputStream);
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused5) {
            }
        }
        throw th;
    }
}
