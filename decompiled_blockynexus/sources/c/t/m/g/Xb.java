package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import com.tencent.map.geolocation.TencentLocationListener;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Xb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f3054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f3055c;

    public static int a(WifiManager wifiManager) {
        if (wifiManager != null) {
            try {
                return wifiManager.getWifiState();
            } catch (Throwable unused) {
            }
        }
        return 4;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0026 -> B:20:0x002b). Please report as a decompilation issue!!! */
    public static synchronized boolean b(WifiManager wifiManager) {
        boolean zStartScan;
        zStartScan = false;
        if (wifiManager != null) {
            try {
                if (System.currentTimeMillis() - f3054b > 3000) {
                    zStartScan = wifiManager.startScan();
                    f3055c = zStartScan;
                    f3054b = System.currentTimeMillis();
                } else {
                    zStartScan = f3055c;
                }
            } catch (Throwable unused) {
                f3053a = true;
            }
        }
        return zStartScan;
    }

    public static List<ScanResult> c(WifiManager wifiManager) {
        List<ScanResult> scanResults = null;
        if (wifiManager != null) {
            try {
                scanResults = wifiManager.getScanResults();
                f3053a = false;
            } catch (Throwable unused) {
                f3053a = true;
            }
        }
        return scanResults == null ? Collections.emptyList() : scanResults;
    }

    public static boolean a(C0423eb c0423eb) {
        try {
            WifiManager wifiManager = c0423eb.i;
            if (wifiManager != null) {
                if (wifiManager.isWifiEnabled()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String c(C0423eb c0423eb) {
        String bssid;
        int rssi;
        Context context = c0423eb.f3147c;
        if (context == null) {
            return "{}";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(TencentLocationListener.WIFI);
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (wifiManager != null && connectivityManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (connectionInfo != null && networkInfo != null && networkInfo.isConnected() && (bssid = connectionInfo.getBSSID()) != null && !bssid.equals("000000000000") && !bssid.equals("00-00-00-00-00-00") && !bssid.equals("00:00:00:00:00:00") && (rssi = connectionInfo.getRssi()) >= -100 && rssi <= -20) {
                    return "{\"mac\":\"" + bssid + "\",\"rssi\":" + rssi + ",\"ssid\":\"" + connectionInfo.getSSID().replace("\"", "").replace("|", "") + "\"}";
                }
            }
        } catch (Exception unused) {
        }
        return "{}";
    }

    @SuppressLint({"NewApi"})
    public static boolean b(C0423eb c0423eb) {
        WifiManager wifiManager = c0423eb.i;
        boolean z = false;
        if (wifiManager == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && Settings.Secure.getInt(c0423eb.f3147c.getContentResolver(), "location_mode") == 0) {
                return false;
            }
            boolean zIsWifiEnabled = wifiManager.isWifiEnabled();
            if (!zIsWifiEnabled) {
                try {
                    if (Build.VERSION.SDK_INT >= 18) {
                        zIsWifiEnabled = wifiManager.isScanAlwaysAvailable();
                    }
                } catch (Throwable th) {
                    z = zIsWifiEnabled;
                    th = th;
                }
            }
            return zIsWifiEnabled;
        } catch (Throwable th2) {
            th = th2;
        }
        if (!(th instanceof SecurityException)) {
            return z;
        }
        f3053a = true;
        return z;
    }
}
