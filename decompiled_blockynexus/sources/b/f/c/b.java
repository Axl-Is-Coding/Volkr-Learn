package b.f.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocationListener;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConnectivityUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    @SuppressLint({"MissingPermission"})
    public static String a(Network network, Context context) {
        if (context == null) {
            return "none";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (network == null || connectivityManager == null) {
            return "none";
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return d(context);
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities == null) {
                return d(context);
            }
            return networkCapabilities.hasTransport(1) ? TencentLocationListener.WIFI : networkCapabilities.hasTransport(0) ? "3g" : d(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "none";
        }
    }

    public static String b(Context context) {
        return Build.VERSION.SDK_INT >= 23 ? a(a(context), context) : d(context);
    }

    public static boolean c(Context context) {
        return b(context, a(context)).equals("vpn");
    }

    private static String d(Context context) {
        String strA = a.a(context);
        return TextUtils.isEmpty(strA) ? "none" : strA;
    }

    @SuppressLint({"MissingPermission"})
    private static String b(Context context, Network network) {
        NetworkCapabilities networkCapabilities;
        if (Build.VERSION.SDK_INT >= 23 && network != null && context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null) {
                    return "";
                }
                if (networkCapabilities.hasTransport(1)) {
                    return TencentLocationListener.WIFI;
                }
                if (networkCapabilities.hasTransport(0)) {
                    return "cellular";
                }
                if (networkCapabilities.hasTransport(4)) {
                    return "vpn";
                }
                if (networkCapabilities.hasTransport(3)) {
                    return "ethernet";
                }
                if (networkCapabilities.hasTransport(5)) {
                    return "wifiAware";
                }
                if (networkCapabilities.hasTransport(6)) {
                    return "lowpan";
                }
                if (networkCapabilities.hasTransport(2)) {
                    return "bluetooth";
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    @SuppressLint({"MissingPermission"})
    public static Network a(Context context) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT < 23 || connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetwork();
    }

    @SuppressLint({"MissingPermission"})
    public static JSONObject a(Context context, Network network) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (Build.VERSION.SDK_INT >= 23 && network != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) != null) {
                    jSONObject.put("networkCapabilities", networkCapabilities.toString());
                    jSONObject.put("downloadSpeed", networkCapabilities.getLinkDownstreamBandwidthKbps());
                    jSONObject.put("uploadSpeed", networkCapabilities.getLinkUpstreamBandwidthKbps());
                    jSONObject.put("hasVPN", c(context));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
