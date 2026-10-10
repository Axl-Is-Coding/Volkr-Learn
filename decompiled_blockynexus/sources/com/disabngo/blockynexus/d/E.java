package com.disabngo.blockynexus.d;

import android.content.Context;
import android.location.LocationListener;

/* JADX INFO: compiled from: LocationHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class E implements LocationListener {
    private static double a(double d2) {
        return (d2 * 3.141592653589793d) / 180.0d;
    }

    public static boolean a(Context context) {
        return androidx.core.content.b.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.content.b.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static double a(double d2, double d3, double d4, double d5) {
        double dA = a(d2);
        double dA2 = a(d4);
        double dRound = Math.round(Math.asin(Math.sqrt(Math.pow(Math.sin((dA - dA2) / 2.0d), 2.0d) + (Math.cos(dA) * Math.cos(dA2) * Math.pow(Math.sin((a(d3) - a(d5)) / 2.0d), 2.0d)))) * 2.0d * 6378.137d * 10000.0d);
        Double.isNaN(dRound);
        return dRound / 10000.0d;
    }
}
