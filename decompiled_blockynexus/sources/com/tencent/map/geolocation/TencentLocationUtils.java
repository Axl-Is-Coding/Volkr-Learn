package com.tencent.map.geolocation;

import android.content.Context;
import c.t.m.g.Tb;
import c.t.m.g.Vb;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes5.dex */
public class TencentLocationUtils {
    private TencentLocationUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean contains(TencentLocation tencentLocation, double d2, TencentLocation tencentLocation2) {
        if (tencentLocation == null || tencentLocation2 == null) {
            throw new NullPointerException();
        }
        return distanceBetween(tencentLocation, tencentLocation2) <= d2;
    }

    public static double distanceBetween(TencentLocation tencentLocation, TencentLocation tencentLocation2) {
        if (tencentLocation == null || tencentLocation2 == null) {
            throw new NullPointerException();
        }
        return Vb.a(tencentLocation.getLatitude(), tencentLocation.getLongitude(), tencentLocation2.getLatitude(), tencentLocation2.getLongitude());
    }

    public static boolean isFromGps(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return false;
        }
        return "gps".equals(tencentLocation.getProvider());
    }

    public static boolean isFromNetwork(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return false;
        }
        return TencentLocation.NETWORK_PROVIDER.equals(tencentLocation.getProvider());
    }

    public static boolean isSupportGps(Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        Tb.a();
        return (Tb.a(context) & 16) == 0;
    }

    public static boolean wgs84ToGcj02(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null || dArr.length != 2 || dArr2.length != 2) {
            return false;
        }
        return Vb.a(dArr, dArr2);
    }

    public static double distanceBetween(double d2, double d3, double d4, double d5) {
        return Vb.a(d2, d3, d4, d5);
    }
}
