package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;

/* JADX INFO: compiled from: TestHelperUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class aa {
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b A[Catch: Exception -> 0x0087, TRY_LEAVE, TryCatch #7 {Exception -> 0x0087, blocks: (B:43:0x0083, B:47:0x008b), top: B:59:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "com.union_test.internationad"
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r4.<init>()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            java.lang.String r5 = "data/data/"
            r4.append(r5)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r4.append(r2)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            java.lang.String r2 = "/"
            r4.append(r2)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r4.append(r7)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            boolean r7 = r3.exists()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            if (r7 != 0) goto L2d
            return r1
        L2d:
            java.io.FileReader r7 = new java.io.FileReader     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5c
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5c
        L37:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r1 == 0) goto L41
            r0.append(r1)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            goto L37
        L41:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r7.close()     // Catch: java.lang.Exception -> L4c
            r2.close()     // Catch: java.lang.Exception -> L4c
            goto L50
        L4c:
            r7 = move-exception
            r7.printStackTrace()
        L50:
            return r0
        L51:
            r0 = move-exception
            goto L5a
        L53:
            r1 = move-exception
            r6 = r1
            r1 = r7
            r7 = r6
            goto L67
        L58:
            r0 = move-exception
            r2 = r1
        L5a:
            r1 = r7
            goto L81
        L5c:
            r2 = move-exception
            r6 = r1
            r1 = r7
            r7 = r2
            r2 = r6
            goto L67
        L62:
            r0 = move-exception
            r2 = r1
            goto L81
        L65:
            r7 = move-exception
            r2 = r1
        L67:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L80
            if (r1 == 0) goto L72
            r1.close()     // Catch: java.lang.Exception -> L70
            goto L72
        L70:
            r7 = move-exception
            goto L78
        L72:
            if (r2 == 0) goto L7b
            r2.close()     // Catch: java.lang.Exception -> L70
            goto L7b
        L78:
            r7.printStackTrace()
        L7b:
            java.lang.String r7 = r0.toString()
            return r7
        L80:
            r0 = move-exception
        L81:
            if (r1 == 0) goto L89
            r1.close()     // Catch: java.lang.Exception -> L87
            goto L89
        L87:
            r7 = move-exception
            goto L8f
        L89:
            if (r2 == 0) goto L92
            r2.close()     // Catch: java.lang.Exception -> L87
            goto L92
        L8f:
            r7.printStackTrace()
        L92:
            goto L94
        L93:
            throw r0
        L94:
            goto L93
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.aa.a(java.lang.String):java.lang.String");
    }

    public static boolean a(Context context) {
        return "5001121".equals(com.bytedance.sdk.openadsdk.core.h.b().c()) && "com.union_test.internationad".equals(ab.f()) && o.c();
    }

    public static String a(String str, String str2) {
        if (str.contains("https://pangolin.snssdk.com")) {
            return str.replace("https://pangolin.snssdk.com", str2);
        }
        if (str.contains("https://is.snssdk.com")) {
            return str.replace("https://is.snssdk.com", str2);
        }
        return str.contains("https://pangolin16.snssdk.com") ? str.replace("https://pangolin16.snssdk.com", str2) : str;
    }
}
