package com.tendcloud.tenddata;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.android.billingclient.api.BillingFlowParams;
import com.sandboxol.blocky.config.GameSharedConstant;
import com.tencent.map.geolocation.TencentLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class ae {
    public static List<Location> a(Context context) {
        boolean zIsProviderEnabled;
        ArrayList arrayList = new ArrayList();
        try {
            if (!af.b(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                return arrayList;
            }
            LocationManager locationManager = (LocationManager) ab.g.getSystemService("location");
            boolean zIsProviderEnabled2 = false;
            if (locationManager != null) {
                zIsProviderEnabled2 = locationManager.isProviderEnabled("gps");
                zIsProviderEnabled = locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
            } else {
                zIsProviderEnabled = false;
            }
            if (zIsProviderEnabled2 || zIsProviderEnabled) {
                arrayList.add(locationManager.getLastKnownLocation("passive"));
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static String b(Context context) {
        try {
            List<Location> listA = a(context);
            StringBuilder sb = new StringBuilder();
            for (Location location : listA) {
                if (location != null) {
                    sb.append(location.getLatitude());
                    sb.append(',');
                    sb.append(location.getLongitude());
                    sb.append(',');
                    sb.append(location.hasAltitude() ? Double.valueOf(location.getAltitude()) : "");
                    sb.append(',');
                    sb.append(location.getTime());
                    sb.append(',');
                    sb.append(location.hasAccuracy() ? Float.valueOf(location.getAccuracy()) : "");
                    sb.append(',');
                    sb.append(location.hasBearing() ? Float.valueOf(location.getBearing()) : "");
                    sb.append(',');
                    sb.append(location.hasSpeed() ? Float.valueOf(location.getSpeed()) : "");
                    sb.append(',');
                    sb.append(location.getProvider());
                    sb.append(':');
                }
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray c(Context context) {
        boolean zIsProviderEnabled;
        JSONArray jSONArray = new JSONArray();
        if (!af.b(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            return jSONArray;
        }
        try {
            LocationManager locationManager = (LocationManager) ab.g.getSystemService("location");
            boolean zIsProviderEnabled2 = false;
            if (locationManager != null) {
                zIsProviderEnabled2 = locationManager.isProviderEnabled("gps");
                zIsProviderEnabled = locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
            } else {
                zIsProviderEnabled = false;
            }
            if (zIsProviderEnabled2 || zIsProviderEnabled) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
                if (lastKnownLocation != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.umeng.analytics.pro.b.B, lastKnownLocation.getLatitude());
                        jSONObject.put(com.umeng.analytics.pro.b.C, lastKnownLocation.getLongitude());
                        jSONObject.put("ts", lastKnownLocation.getTime());
                        if (af.a(17)) {
                            jSONObject.put("elapsed", lastKnownLocation.getElapsedRealtimeNanos());
                        }
                        if (lastKnownLocation.hasAltitude()) {
                            jSONObject.put("altitude", lastKnownLocation.getAltitude());
                        }
                        if (lastKnownLocation.hasAccuracy()) {
                            jSONObject.put("hAccuracy", lastKnownLocation.getAccuracy());
                        }
                        if (lastKnownLocation.hasBearing()) {
                            jSONObject.put("bearing", lastKnownLocation.getBearing());
                        }
                        if (lastKnownLocation.hasSpeed()) {
                            jSONObject.put("speed", lastKnownLocation.getSpeed());
                        }
                        jSONObject.put(com.umeng.analytics.pro.b.L, lastKnownLocation.getProvider());
                        jSONArray.put(jSONObject);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
        return jSONArray;
    }

    public static JSONArray d(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArrayB = u.B(context);
            if (jSONArrayB.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "sim");
                jSONObject.put("extra", jSONArrayB);
                jSONArray.put(jSONObject);
            }
            String str = ab.s;
            if (str != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, str);
                jSONObject2.put("type", GameSharedConstant.ACCOUNT);
                jSONArray.put(jSONObject2);
            }
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
            return null;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    public static Long[][] e(Context context) {
        return new Long[3][];
    }
}
