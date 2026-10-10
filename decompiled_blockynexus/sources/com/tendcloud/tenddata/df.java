package com.tendcloud.tenddata;

import android.os.SystemClock;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class df extends cx {
    public df() {
        a("bootTime", Long.valueOf(c()));
        a("activeTime", Long.valueOf(SystemClock.elapsedRealtime()));
        a("freeDiskSpace", Integer.valueOf(b()));
        a("batteryLevel", Integer.valueOf(p.e(ab.g)));
        a("batteryState", Integer.valueOf(p.f(ab.g)));
    }

    public static int b() {
        try {
            int[] iArrS = p.s();
            if (iArrS != null) {
                return iArrS[1];
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long c() {
        try {
            return System.currentTimeMillis() - SystemClock.elapsedRealtime();
        } catch (Throwable unused) {
            return -1L;
        }
    }
}
