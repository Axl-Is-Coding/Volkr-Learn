package com.tendcloud.tenddata;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.TencentLocationListener;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TelephonyManager f20053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f20054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f20055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f20056d = new HashMap<>();

    static {
        try {
            if (ab.g != null) {
                f20053a = (TelephonyManager) ab.g.getSystemService("phone");
                f20056d.put("imei", g(ab.g));
                f20056d.put("imeis", h(ab.g));
                f20056d.put("imsi", f(ab.g));
                f20056d.put("simId", i(ab.g));
                f20056d.put("androidId", e(ab.g));
            }
        } catch (Throwable unused) {
        }
    }

    private q() {
    }

    public static String c(Context context) {
        try {
            if (af.a(9) && af.b(26)) {
                return Build.SERIAL;
            }
            if (af.a(26) && af.b(context, "android.permission.READ_PHONE_STATE")) {
                return Build.getSerial();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d(Context context) {
        String strB;
        String str = null;
        try {
            strB = af.a(23) ? b() : j(context);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!af.j(strB)) {
                return strB;
            }
        } catch (Throwable th2) {
            str = strB;
            th = th2;
            bp.postSDKError(th);
        }
        return str;
    }

    public static String e(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String f(Context context) {
        try {
            if (af.b(context, "android.permission.READ_PHONE_STATE")) {
                return f20053a.getSubscriberId();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String g(Context context) {
        try {
            if (af.b(context, "android.permission.READ_PHONE_STATE")) {
                return u.C(context) == 2 ? a(1) : a(0);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String h(Context context) {
        try {
            if (!af.b(context, "android.permission.READ_PHONE_STATE")) {
                return null;
            }
            String strA = "";
            if (u.C(context) == 2) {
                try {
                    a(0);
                    strA = a(1);
                } catch (Exception unused) {
                }
            }
            return af.b(strA) ? a(0) : strA;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static String i(Context context) {
        try {
            if (af.b(context, "android.permission.READ_PHONE_STATE")) {
                return f20053a.getSimSerialNumber();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String j(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        String macAddress;
        try {
            if (!af.b(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService(TencentLocationListener.WIFI)) == null || !wifiManager.isWifiEnabled() || (connectionInfo = wifiManager.getConnectionInfo()) == null || (macAddress = connectionInfo.getMacAddress()) == null) {
                return null;
            }
            return macAddress.toUpperCase().trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str) {
        return f20056d.get(str);
    }

    public static String b(final Context context) {
        try {
            if (!f20055c) {
                ad.f19754a.execute(new Runnable() { // from class: com.tendcloud.tenddata.q.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            boolean unused = q.f20055c = true;
                            String unused2 = q.f20054b = (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context), new Object[0]);
                        } catch (Throwable unused3) {
                        }
                    }
                });
            }
            return f20054b;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(Context context) {
        try {
            String strD = d(context);
            if (!af.b(strD)) {
                strD = String.valueOf(Long.parseLong(strD.replaceAll(":", ""), 16));
            }
            String strA = a("androidId");
            String strA2 = a("imeis");
            String strA3 = a("imsi");
            String strA4 = a("simId");
            String strA5 = o.a(context);
            String strA6 = a();
            String strC = c(context);
            StringBuilder sb = new StringBuilder(170);
            sb.append(2);
            sb.append("|");
            sb.append(strD);
            sb.append("|");
            sb.append(strA);
            sb.append("|");
            sb.append(strA2);
            sb.append("|");
            sb.append(strA3);
            sb.append("|");
            sb.append(strA4);
            sb.append("|");
            sb.append(strA5);
            sb.append("|");
            sb.append(strA6);
            sb.append("|");
            sb.append(strC);
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    static String b(int i) {
        if (af.a(26)) {
            try {
                return f20053a.getMeid(i);
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    private static String b() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString().toUpperCase().trim();
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    static String a(int i) {
        if (af.a(26)) {
            try {
                return f20053a.getImei(i);
            } catch (Throwable unused) {
                return "";
            }
        }
        if (af.a(23)) {
            return f20053a.getDeviceId(i);
        }
        return f20053a.getDeviceId();
    }

    private static String a() {
        try {
            return de.b().c();
        } catch (Throwable unused) {
            return "";
        }
    }
}
