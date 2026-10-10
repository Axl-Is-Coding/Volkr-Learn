package b.f.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.TencentLocationListener;

/* JADX INFO: compiled from: ConnectivityService.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                sb.append("3g");
            } else if (type == 1) {
                sb.append(TencentLocationListener.WIFI);
            } else {
                sb.append(typeName);
            }
        }
        return sb.toString();
    }

    public static int b(Context context) {
        try {
            return context.getResources().getConfiguration().mcc;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static int c(Context context) {
        try {
            return context.getResources().getConfiguration().mnc;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static int d(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String e(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getSimOperator() : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean f(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
