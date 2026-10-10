package com.disabngo.blockynexus.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import com.tencent.map.geolocation.TencentLocation;

/* JADX INFO: compiled from: GpsUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {
    public static final boolean a(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
        }
        return false;
    }

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), i);
    }
}
