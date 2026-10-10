package com.google.android.gms.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public class MediationUtils {
    protected static final double MIN_HEIGHT_RATIO = 0.7d;
    protected static final double MIN_WIDTH_RATIO = 0.5d;

    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.ads.AdSize findClosestSize(android.content.Context r11, com.google.android.gms.ads.AdSize r12, java.util.List<com.google.android.gms.ads.AdSize> r13) {
        /*
            r0 = 0
            if (r13 == 0) goto La3
            if (r12 != 0) goto L7
            goto La3
        L7:
            boolean r1 = r12.zzdt()
            if (r1 != 0) goto L30
            android.content.res.Resources r1 = r11.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            int r2 = r12.getWidthInPixels(r11)
            float r2 = (float) r2
            float r2 = r2 / r1
            int r2 = java.lang.Math.round(r2)
            int r11 = r12.getHeightInPixels(r11)
            float r11 = (float) r11
            float r11 = r11 / r1
            int r11 = java.lang.Math.round(r11)
            com.google.android.gms.ads.AdSize r12 = new com.google.android.gms.ads.AdSize
            r12.<init>(r2, r11)
        L30:
            java.util.Iterator r11 = r13.iterator()
        L34:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto La3
            java.lang.Object r13 = r11.next()
            com.google.android.gms.ads.AdSize r13 = (com.google.android.gms.ads.AdSize) r13
            r1 = 0
            if (r13 != 0) goto L44
            goto L85
        L44:
            int r2 = r12.getWidth()
            int r3 = r13.getWidth()
            int r4 = r12.getHeight()
            int r5 = r13.getHeight()
            double r6 = (double) r2
            r8 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r8
            double r8 = (double) r3
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 > 0) goto L85
            if (r2 >= r3) goto L64
            goto L85
        L64:
            boolean r2 = r12.zzdt()
            if (r2 == 0) goto L71
            int r2 = r12.zzdu()
            if (r2 >= r5) goto L84
            goto L85
        L71:
            double r2 = (double) r4
            r6 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r6
            double r6 = (double) r5
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 > 0) goto L85
            if (r4 >= r5) goto L84
            goto L85
        L84:
            r1 = 1
        L85:
            if (r1 == 0) goto L34
            if (r0 != 0) goto L8a
            goto La1
        L8a:
            int r1 = r0.getWidth()
            int r2 = r0.getHeight()
            int r1 = r1 * r2
            int r2 = r13.getWidth()
            int r3 = r13.getHeight()
            int r2 = r2 * r3
            if (r1 <= r2) goto La1
            r13 = r0
        La1:
            r0 = r13
            goto L34
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.MediationUtils.findClosestSize(android.content.Context, com.google.android.gms.ads.AdSize, java.util.List):com.google.android.gms.ads.AdSize");
    }
}
