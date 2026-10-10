package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;

/* JADX INFO: renamed from: c.t.m.g.ab, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class C0411ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3082a = "0123456789ABCDEF";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3083b = "0123456789ABCDEF";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f3084c = "0123456789ABCDEF";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f3085d = "0123456789ABCDEF";

    public static String a() {
        return a(C0458qa.d());
    }

    public static String b() {
        return b(C0458qa.d());
    }

    public static String c() {
        return c(C0458qa.d());
    }

    @SuppressLint({"MissingPermission"})
    public static String d() {
        try {
            return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
        } catch (Throwable unused) {
            return "0123456789ABCDEF";
        }
    }

    public static String e() {
        byte[] hardwareAddress;
        if (TextUtils.isEmpty(f3084c) || "0123456789ABCDEF".equals(f3084c)) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                    if (networkInterfaceNextElement != null && networkInterfaceNextElement.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = networkInterfaceNextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b2)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        f3084c = sb.toString();
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return a(f3084c);
    }

    @SuppressLint({"MissingPermission"})
    @Deprecated
    private static String a(Context context) {
        if (TextUtils.isEmpty(f3082a) || "0123456789ABCDEF".equals(f3082a)) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                f3082a = Za.a(Build.VERSION.SDK_INT >= 26 ? telephonyManager.getImei() : telephonyManager.getDeviceId(), Za.f3068a).toUpperCase(Locale.ENGLISH);
            } catch (Throwable unused) {
            }
        }
        return a(f3082a);
    }

    @SuppressLint({"MissingPermission"})
    @Deprecated
    private static String b(Context context) {
        if (TextUtils.isEmpty(f3083b) || "0123456789ABCDEF".equals(f3083b)) {
            try {
                f3083b = Za.a(((TelephonyManager) context.getSystemService("phone")).getSubscriberId(), Za.f3069b);
            } catch (Throwable unused) {
            }
        }
        return a(f3083b);
    }

    @SuppressLint({"MissingPermission"})
    @Deprecated
    private static String c(Context context) {
        if (TextUtils.isEmpty(f3085d) || "0123456789ABCDEF".equals(f3085d)) {
            try {
                f3085d = Za.a(((TelephonyManager) context.getSystemService("phone")).getLine1Number(), Za.f3070c);
            } catch (Throwable unused) {
            }
        }
        return a(f3085d);
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "0123456789ABCDEF" : str;
    }
}
