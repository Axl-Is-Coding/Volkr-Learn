package com.bumptech.glide.e;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

/* JADX INFO: compiled from: LogTime.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f4167a;

    static {
        f4167a = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    @TargetApi(17)
    public static long a() {
        return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis();
    }

    public static double a(long j) {
        double dA = a() - j;
        double d2 = f4167a;
        Double.isNaN(dA);
        return dA * d2;
    }
}
