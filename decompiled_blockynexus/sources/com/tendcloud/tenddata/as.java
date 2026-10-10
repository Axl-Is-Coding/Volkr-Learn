package com.tendcloud.tenddata;

import android.os.SystemClock;
import io.grpc.internal.GrpcUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f19798a = 600;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f19799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f19800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, List<String>> f19801d;

    private as(int i, String str) {
        this(i, str.getBytes(), null);
    }

    public static int a() {
        return 600;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0044 A[PHI: r9 r10
      0x0044: PHI (r9v6 java.io.InputStream) = (r9v4 java.io.InputStream), (r9v5 java.io.InputStream), (r9v7 java.io.InputStream) binds: [B:23:0x0041, B:11:0x002a, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x0044: PHI (r10v3 com.tendcloud.tenddata.as) = (r10v0 com.tendcloud.tenddata.as), (r10v1 com.tendcloud.tenddata.as), (r10v4 com.tendcloud.tenddata.as) binds: [B:23:0x0041, B:11:0x002a, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x002a A[EXC_TOP_SPLITTER, PHI: r9 r10
      0x002a: PHI (r9v5 java.io.InputStream) = (r9v4 java.io.InputStream), (r9v7 java.io.InputStream) binds: [B:23:0x0041, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002a: PHI (r10v1 com.tendcloud.tenddata.as) = (r10v0 com.tendcloud.tenddata.as), (r10v4 com.tendcloud.tenddata.as) binds: [B:23:0x0041, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tendcloud.tenddata.as a(java.lang.String r11, java.net.HttpURLConnection r12, long r13, com.tendcloud.tenddata.ap r15) throws java.lang.Throwable {
        /*
            r0 = 0
            int r8 = r12.getResponseCode()     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L35
            r1 = 400(0x190, float:5.6E-43)
            if (r8 <= r1) goto Le
            java.io.InputStream r1 = r12.getErrorStream()     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L32
            goto L12
        Le:
            java.io.InputStream r1 = r12.getInputStream()     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L32
        L12:
            r9 = r1
            java.util.Map r1 = r12.getHeaderFields()     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L45
            int r2 = r12.getContentLength()     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L45
            com.tendcloud.tenddata.as r10 = a(r8, r2, r9, r1)     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L45
            r1 = r11
            r2 = r12
            r3 = r8
            r4 = r13
            r6 = r10
            r7 = r15
            a(r1, r2, r3, r4, r6, r7)     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L45
            if (r9 == 0) goto L44
        L2a:
            r9.close()     // Catch: java.lang.Throwable -> L44
            goto L44
        L2e:
            r11 = move-exception
            goto L39
        L30:
            r11 = move-exception
            goto L38
        L32:
            r11 = move-exception
            r9 = r0
            goto L46
        L35:
            r11 = move-exception
            r8 = 600(0x258, float:8.41E-43)
        L38:
            r9 = r0
        L39:
            com.tendcloud.tenddata.bp.postSDKError(r11)     // Catch: java.lang.Throwable -> L45
            com.tendcloud.tenddata.as r10 = new com.tendcloud.tenddata.as     // Catch: java.lang.Throwable -> L45
            r10.<init>(r8, r0, r0)     // Catch: java.lang.Throwable -> L45
            if (r9 == 0) goto L44
            goto L2a
        L44:
            return r10
        L45:
            r11 = move-exception
        L46:
            if (r9 == 0) goto L4b
            r9.close()     // Catch: java.lang.Throwable -> L4b
        L4b:
            goto L4d
        L4c:
            throw r11
        L4d:
            goto L4c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.as.a(java.lang.String, java.net.HttpURLConnection, long, com.tendcloud.tenddata.ap):com.tendcloud.tenddata.as");
    }

    public int b() {
        return this.f19799b;
    }

    public byte[] c() {
        return this.f19800c;
    }

    public Map<String, List<String>> d() {
        return this.f19801d;
    }

    private as(int i, byte[] bArr, Map<String, List<String>> map) {
        this.f19799b = i;
        this.f19800c = bArr;
        this.f19801d = map;
    }

    public static as a(String str) {
        return new as(600, str);
    }

    private static as a(int i, int i2, InputStream inputStream, Map<String, List<String>> map) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = i2 != -1 ? new ByteArrayOutputStream(i2) : new ByteArrayOutputStream();
            while (true) {
                int i3 = inputStream.read();
                if (i3 != -1) {
                    byteArrayOutputStream.write(i3);
                } else {
                    inputStream.close();
                    return new as(i, byteArrayOutputStream.toByteArray(), map);
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    private static void a(String str, HttpURLConnection httpURLConnection, int i, long j, as asVar, ap apVar) {
        boolean z;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getRequestMethod().equalsIgnoreCase(GrpcUtil.HTTP_METHOD)) {
                    TreeMap treeMap = new TreeMap();
                    URL url = httpURLConnection.getURL();
                    treeMap.put("targetUrl", url.toString());
                    try {
                        treeMap.put("targetIP", InetAddress.getByName(url.getHost()).getHostAddress());
                    } catch (Throwable unused) {
                        treeMap.put("targetIP", "0.0.0.0");
                    }
                    if (i == 200) {
                        if (apVar != null && apVar.a() != null) {
                            treeMap.put("reqSize", Integer.valueOf(apVar.a().length));
                        }
                        treeMap.put("respTime", Long.valueOf(SystemClock.elapsedRealtime() - j));
                        z = true;
                    } else {
                        treeMap.put("errorMsg", a(asVar));
                        treeMap.put("statusCode", Integer.valueOf(i));
                        z = false;
                    }
                    bp.a(str, z, treeMap);
                }
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }
    }

    private static String a(as asVar) {
        if (asVar == null || asVar.c() == null) {
            return "";
        }
        try {
            byte[] bArrC = asVar.c();
            return bArrC.length > 104857600 ? "Input stream more than 100 MB size limit" : new String(bArrC);
        } catch (Throwable th) {
            bp.postSDKError(th);
            return "";
        }
    }
}
