package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.map.geolocation.TencentLocationListener;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f2896c;

    public Da(String str, String str2, String str3) {
        this.f2894a = str2;
        this.f2895b = str;
        this.f2896c = str3;
    }

    public static int a(Context context) {
        try {
            return a((WifiManager) context.getSystemService(TencentLocationListener.WIFI));
        } catch (Throwable unused) {
            return 4;
        }
    }

    public static String a(String str) {
        return str == null ? "" : str;
    }

    @SuppressLint({"MissingPermission"})
    private static int a(WifiManager wifiManager) {
        if (wifiManager == null) {
            return 4;
        }
        try {
            return wifiManager.getWifiState();
        } catch (Throwable unused) {
            return 4;
        }
    }

    public static boolean a(List<ScanResult> list, List<ScanResult> list2) {
        if (list == list2) {
            return true;
        }
        int size = list == null ? 0 : list.size();
        if (size != (list2 == null ? 0 : list2.size())) {
            return false;
        }
        if (size == 0) {
            return true;
        }
        try {
            HashMap map = new HashMap();
            for (ScanResult scanResult : list) {
                map.put(scanResult.BSSID, Integer.valueOf(scanResult.level));
            }
            for (ScanResult scanResult2 : list2) {
                if (!map.containsKey(scanResult2.BSSID) || scanResult2.level != ((Integer) map.get(scanResult2.BSSID)).intValue()) {
                    return false;
                }
            }
        } catch (Throwable th) {
            C0458qa.a("", th);
        }
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public static String a() {
        String bssid;
        int rssi;
        try {
            WifiInfo wifiInfoB = C0458qa.b(C0458qa.d());
            if (wifiInfoB != null && (bssid = wifiInfoB.getBSSID()) != null && !bssid.equals("000000000000") && !bssid.equals("00-00-00-00-00-00") && !bssid.equals("00:00:00:00:00:00") && (rssi = wifiInfoB.getRssi()) >= -100 && rssi <= -20) {
                return "{\"mac\":\"" + bssid + "\",\"rssi\":" + rssi + ",\"ssid\":\"" + wifiInfoB.getSSID().replace("\"", "").replace("|", "") + "\"}";
            }
        } catch (Throwable unused) {
        }
        return "{}";
    }
}
