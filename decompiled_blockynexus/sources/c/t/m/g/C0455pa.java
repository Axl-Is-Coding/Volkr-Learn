package c.t.m.g;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.tencent.map.geolocation.TencentLocationListener;
import com.umeng.analytics.pro.ci;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: renamed from: c.t.m.g.pa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0455pa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3340a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3341b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f3342c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f3343d = "";

    public static int a(int i, int i2) {
        return Math.min(Math.max(i, 0), i2);
    }

    public static String a() {
        TelephonyManager telephonyManager;
        try {
            String str = f3340a;
            boolean z = true;
            if (str != null && str.trim().length() != 0) {
                z = false;
            }
            if (z && (telephonyManager = (TelephonyManager) fc.a().getSystemService("phone")) != null) {
                String deviceId = telephonyManager.getDeviceId();
                if (deviceId == null) {
                    deviceId = "NOIMEI";
                }
                f3340a = deviceId;
            }
        } catch (Throwable unused) {
        }
        return f3340a;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(int r3) throws java.lang.Throwable {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "/proc/"
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = "/cmdline"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3f
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3f
            if (r2 != 0) goto L2c
            java.lang.String r3 = r3.trim()     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3f
        L2c:
            r1.close()     // Catch: java.io.IOException -> L2f
        L2f:
            return r3
        L30:
            r3 = move-exception
            goto L36
        L32:
            r3 = move-exception
            goto L41
        L34:
            r3 = move-exception
            r1 = r0
        L36:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3f
            if (r1 == 0) goto L3e
            r1.close()     // Catch: java.io.IOException -> L3e
        L3e:
            return r0
        L3f:
            r3 = move-exception
            r0 = r1
        L41:
            if (r0 == 0) goto L46
            r0.close()     // Catch: java.io.IOException -> L46
        L46:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.C0455pa.a(int):java.lang.String");
    }

    public static String a(long j, String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            return simpleDateFormat.format(calendar.getTime());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a(Context context, int i) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            try {
                activityManager = (ActivityManager) systemService;
            } catch (Throwable th) {
                th.printStackTrace();
                activityManager = null;
            }
        } else {
            activityManager = null;
        }
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.size() <= 0) {
            return null;
        }
        int size = runningAppProcesses.size();
        for (int i2 = 0; i2 < size; i2++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static String a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        if (!TextUtils.isEmpty(stackTraceString)) {
            String[] strArrSplit = stackTraceString.split(UMCustomLogInfoBuilder.LINE_SEP);
            if (strArrSplit.length >= 2) {
                return strArrSplit[0] + strArrSplit[1];
            }
            if (strArrSplit.length == 1) {
                return strArrSplit[0];
            }
        }
        return "";
    }

    private static String a(InetAddress inetAddress) {
        try {
            byte[] address = inetAddress.getAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < address.length; i++) {
                StringBuilder sb2 = new StringBuilder(Consts.DOT);
                sb2.append(address[i] < 0 ? address[i] + 256 : address[i]);
                sb.append(sb2.toString());
            }
            return sb.substring(1);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        int length = bArr.length;
        if (bArr == null) {
            return "null";
        }
        int iMin = Math.min(length, bArr.length);
        StringBuffer stringBuffer = new StringBuffer("size:" + iMin + ",content:");
        for (int i = 0; i < iMin; i++) {
            stringBuffer.append(Integer.toHexString((bArr[i] >> 4) & 15));
            stringBuffer.append(Integer.toHexString(bArr[i] & ci.m));
        }
        return stringBuffer.toString();
    }

    public static String c() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            String str = f3342c;
            boolean z = true;
            if (str != null && str.trim().length() != 0) {
                z = false;
            }
            if (z && (wifiManager = (WifiManager) fc.a().getApplicationContext().getSystemService(TencentLocationListener.WIFI)) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                String macAddress = connectionInfo.getMacAddress();
                if (macAddress == null) {
                    macAddress = "NOMAC";
                }
                f3342c = macAddress;
            }
        } catch (Throwable unused) {
        }
        return f3342c;
    }

    public static String c(String str) {
        try {
            return a(InetAddress.getByName(str));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String d() {
        try {
            return C0452oa.a("" + a() + c() + System.currentTimeMillis() + b() + ((int) (Math.random() * 2.147483647E9d)));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean d(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length != 4) {
            return false;
        }
        for (String str2 : strArrSplit) {
            try {
                i = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
            }
            if (i < 0 || i > 255) {
                return false;
            }
        }
        return true;
    }

    public static String e() {
        try {
            String str = f3343d;
            boolean z = true;
            if (str != null && str.trim().length() != 0) {
                z = false;
            }
            if (z) {
                f3343d = Settings.Secure.getString(fc.a().getContentResolver(), "android_id");
            }
            return f3343d;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String f() {
        try {
            return "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int a(int i, int i2, int i3, int i4) {
        return ((i < i2 || i > i3) && i4 >= i2 && i4 <= i3) ? i4 : Math.min(Math.max(i, i2), i3);
    }

    public static String b() {
        TelephonyManager telephonyManager;
        try {
            String str = f3341b;
            boolean z = true;
            if (str != null && str.trim().length() != 0) {
                z = false;
            }
            if (z && (telephonyManager = (TelephonyManager) fc.a().getSystemService("phone")) != null) {
                String subscriberId = telephonyManager.getSubscriberId();
                if (subscriberId == null) {
                    subscriberId = "NOIMSI";
                }
                f3341b = subscriberId;
            }
        } catch (Throwable unused) {
        }
        return f3341b;
    }
}
