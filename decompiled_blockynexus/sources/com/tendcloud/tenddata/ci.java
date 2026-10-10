package com.tendcloud.tenddata;

import android.content.Context;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class ci {
    public static boolean a() {
        String strA;
        try {
            if (!af.b(29) && by.e() && (strA = a("persist.sys.identifierid.supported", "0")) != null) {
                return strA.equals("1");
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void reflectVIVO(Context context) {
        try {
            de.b().setOAID(a("oaid", null, context));
        } catch (Throwable unused) {
        }
        try {
            de.b().setVAID(a("vaid", null, context));
        } catch (Throwable unused2) {
        }
        try {
            de.b().setAAID(a("aaid", null, context));
        } catch (Throwable unused3) {
        }
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007e A[Catch: Throwable -> 0x0092, TryCatch #0 {Throwable -> 0x0092, blocks: (B:3:0x0002, B:27:0x0070, B:29:0x007e, B:31:0x0084, B:32:0x008f, B:23:0x003d, B:24:0x0053, B:25:0x0069, B:10:0x0018, B:13:0x0022, B:16:0x002c), top: B:35:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r8, java.lang.String r9, android.content.Context r10) {
        /*
            r0 = -1
            r1 = 0
            int r2 = r8.hashCode()     // Catch: java.lang.Throwable -> L92
            r3 = 2986299(0x2d913b, float:4.184696E-39)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L2c
            r3 = 3403373(0x33ee6d, float:4.769141E-39)
            if (r2 == r3) goto L22
            r3 = 3611910(0x371d06, float:5.061364E-39)
            if (r2 == r3) goto L18
            goto L35
        L18:
            java.lang.String r2 = "vaid"
            boolean r8 = r8.equals(r2)     // Catch: java.lang.Throwable -> L92
            if (r8 == 0) goto L35
            r0 = 1
            goto L35
        L22:
            java.lang.String r2 = "oaid"
            boolean r8 = r8.equals(r2)     // Catch: java.lang.Throwable -> L92
            if (r8 == 0) goto L35
            r0 = 0
            goto L35
        L2c:
            java.lang.String r2 = "aaid"
            boolean r8 = r8.equals(r2)     // Catch: java.lang.Throwable -> L92
            if (r8 == 0) goto L35
            r0 = 2
        L35:
            if (r0 == 0) goto L69
            if (r0 == r5) goto L53
            if (r0 == r4) goto L3d
            r3 = r1
            goto L70
        L3d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
            r8.<init>()     // Catch: java.lang.Throwable -> L92
            java.lang.String r0 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r8.append(r0)     // Catch: java.lang.Throwable -> L92
            r8.append(r9)     // Catch: java.lang.Throwable -> L92
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L92
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L92
            goto L6f
        L53:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
            r8.<init>()     // Catch: java.lang.Throwable -> L92
            java.lang.String r0 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r8.append(r0)     // Catch: java.lang.Throwable -> L92
            r8.append(r9)     // Catch: java.lang.Throwable -> L92
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L92
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L92
            goto L6f
        L69:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L92
        L6f:
            r3 = r8
        L70:
            android.content.ContentResolver r2 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L92
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L92
            if (r8 == 0) goto L92
            boolean r9 = r8.moveToNext()     // Catch: java.lang.Throwable -> L92
            if (r9 == 0) goto L8f
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L92
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L92
            r1 = r9
        L8f:
            r8.close()     // Catch: java.lang.Throwable -> L92
        L92:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.ci.a(java.lang.String, java.lang.String, android.content.Context):java.lang.String");
    }
}
