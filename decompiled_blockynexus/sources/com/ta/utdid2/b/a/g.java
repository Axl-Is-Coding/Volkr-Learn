package com.ta.utdid2.b.a;

import java.util.Random;

/* JADX INFO: compiled from: PhoneInfoUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class g {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r1) {
        /*
            if (r1 == 0) goto L11
            java.lang.String r0 = "phone"
            java.lang.Object r1 = r1.getSystemService(r0)     // Catch: java.lang.Exception -> L11
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Exception -> L11
            if (r1 == 0) goto L11
            java.lang.String r1 = r1.getDeviceId()     // Catch: java.lang.Exception -> L11
            goto L12
        L11:
            r1 = 0
        L12:
            boolean r0 = com.ta.utdid2.b.a.i.m95a(r1)
            if (r0 == 0) goto L1c
            java.lang.String r1 = c()
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.g.a(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r1) {
        /*
            if (r1 == 0) goto L11
            java.lang.String r0 = "phone"
            java.lang.Object r1 = r1.getSystemService(r0)     // Catch: java.lang.Exception -> L11
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Exception -> L11
            if (r1 == 0) goto L11
            java.lang.String r1 = r1.getSubscriberId()     // Catch: java.lang.Exception -> L11
            goto L12
        L11:
            r1 = 0
        L12:
            boolean r0 = com.ta.utdid2.b.a.i.m95a(r1)
            if (r0 == 0) goto L1c
            java.lang.String r1 = c()
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.g.b(android.content.Context):java.lang.String");
    }

    public static final String c() {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNanoTime = (int) System.nanoTime();
        int iNextInt = new Random().nextInt();
        int iNextInt2 = new Random().nextInt();
        byte[] bytes = e.getBytes(iCurrentTimeMillis);
        byte[] bytes2 = e.getBytes(iNanoTime);
        byte[] bytes3 = e.getBytes(iNextInt);
        byte[] bytes4 = e.getBytes(iNextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return b.encodeToString(bArr, 2);
    }
}
