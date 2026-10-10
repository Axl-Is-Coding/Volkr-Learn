package com.tendcloud.tenddata;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.tencent.map.geolocation.TencentLocationListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f20058a = "www.talkingdata.net";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f20059b = 80;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static TelephonyManager f20060c = null;
    private static final long h = 300000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f20061d = {"UNKNOWN", "GPRS", "EDGE", "UMTS", "CDMA", "EVDO_0", "EVDO_A", "1xRTT", "HSDPA", "HSUPA", "HSPA", "IDEN", "EVDO_B", "LTE", "EHRPD", "HSPAP"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f20062e = {"NONE", "GSM", "CDMA", "SIP"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f20063f = null;
    private static boolean g = false;
    private static long i = -300000;
    private static boolean j = false;
    private static b k = new b();
    private static JSONArray l = new JSONArray();

    /* JADX INFO: compiled from: td */
    public static class a implements Runnable {
        private Context context;
        private Object lock;
        private BroadcastReceiver receiver;

        public a(Context context, Object obj, BroadcastReceiver broadcastReceiver) {
            this.context = context;
            this.lock = obj;
            this.receiver = broadcastReceiver;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            BroadcastReceiver broadcastReceiver;
            try {
                synchronized (this.lock) {
                    try {
                        try {
                            this.lock.notifyAll();
                            context = this.context;
                            broadcastReceiver = this.receiver;
                        } catch (Throwable th) {
                            this.context.unregisterReceiver(this.receiver);
                            throw th;
                        }
                    } catch (Throwable unused) {
                        context = this.context;
                        broadcastReceiver = this.receiver;
                    }
                    context.unregisterReceiver(broadcastReceiver);
                }
            } catch (Throwable unused2) {
            }
        }

        public void unRegisterReceiver() {
            BroadcastReceiver broadcastReceiver = this.receiver;
            if (broadcastReceiver != null) {
                try {
                    this.context.unregisterReceiver(broadcastReceiver);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: td */
    static class b extends BroadcastReceiver {
        private CountDownLatch latch = new CountDownLatch(1);

        b() {
        }

        void await() {
            try {
                this.latch.await(2000L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                m.eForInternal(th);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!"android.net.wifi.SCAN_RESULTS".equals(intent.getAction()) || this.latch.getCount() <= 0) {
                return;
            }
            this.latch.countDown();
        }

        void reset() {
            this.latch = new CountDownLatch(1);
        }
    }

    public static synchronized JSONArray A(Context context) {
        if (!af.f19762c) {
            return null;
        }
        try {
            if (af.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(TencentLocationListener.WIFI);
                if (wifiManager.isWifiEnabled() || (Build.VERSION.SDK_INT >= 18 && wifiManager.isScanAlwaysAvailable())) {
                    if (af.b(context, "android.permission.CHANGE_WIFI_STATE") && !j) {
                        try {
                            context.registerReceiver(k, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                        } catch (Throwable unused) {
                        }
                        j = true;
                    }
                    wifiManager.startScan();
                    k.await();
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    k.reset();
                    if (scanResults != null) {
                        ArrayList arrayList = new ArrayList();
                        for (ScanResult scanResult : scanResults) {
                            if (scanResult.level >= -85) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", scanResult.BSSID);
                                    jSONObject.put("name", scanResult.SSID);
                                    jSONObject.put(FirebaseAnalytics.Param.LEVEL, scanResult.level);
                                    jSONObject.put("freq", scanResult.frequency);
                                    if (af.a(17)) {
                                        jSONObject.put("ts", scanResult.timestamp);
                                        jSONObject.put("scanTs", (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (scanResult.timestamp / 1000));
                                    }
                                    arrayList.add(jSONObject);
                                } catch (Throwable unused2) {
                                }
                            }
                        }
                        return a(arrayList, 20);
                    }
                }
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    public static JSONArray B(Context context) {
        if (l.length() > 0) {
            return l;
        }
        if (!af.b(context, "android.permission.READ_PHONE_STATE")) {
            return l;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ArrayList arrayList = new ArrayList();
            if (af.a(22)) {
                SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
                try {
                    JSONObject jSONObjectA = a(context, subscriptionManager, 0);
                    if (af.a(26)) {
                        try {
                            jSONObjectA.put("imei", q.a(0));
                        } catch (Throwable unused) {
                        }
                        try {
                            jSONObjectA.put("meid", q.b(0));
                        } catch (Throwable unused2) {
                        }
                    } else {
                        jSONObjectA.put("imei", q.a(0));
                    }
                    if (jSONObjectA.length() > 0) {
                        l.put(jSONObjectA);
                    }
                } catch (Throwable unused3) {
                }
                JSONObject jSONObjectA2 = a(context, subscriptionManager, 1);
                if (telephonyManager != null) {
                    if (af.a(26)) {
                        try {
                            jSONObjectA2.put("imei", q.a(1));
                        } catch (Throwable unused4) {
                        }
                        try {
                            jSONObjectA2.put("meid", q.b(1));
                        } catch (Throwable unused5) {
                        }
                    } else {
                        jSONObjectA2.put("imei", q.a(1));
                    }
                }
                if (jSONObjectA2.length() > 0) {
                    l.put(jSONObjectA2);
                }
            } else {
                String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : "";
                if (b(deviceId.trim()).booleanValue()) {
                    arrayList.add(deviceId.trim());
                    JSONObject jSONObjectA3 = a(telephonyManager, deviceId);
                    if (jSONObjectA3 != null) {
                        l.put(jSONObjectA3);
                    }
                }
                try {
                    TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone1");
                    String deviceId2 = telephonyManager2 != null ? telephonyManager2.getDeviceId() : "";
                    if (deviceId2 != null && b(deviceId2).booleanValue() && !arrayList.contains(deviceId2)) {
                        arrayList.add(deviceId2);
                        JSONObject jSONObjectA4 = a(telephonyManager2, deviceId2);
                        if (jSONObjectA4 != null) {
                            l.put(jSONObjectA4);
                        }
                    }
                } catch (Throwable unused6) {
                }
                try {
                    TelephonyManager telephonyManager3 = (TelephonyManager) context.getSystemService("phone2");
                    String deviceId3 = telephonyManager3 != null ? telephonyManager3.getDeviceId() : "";
                    if (deviceId3 != null && b(deviceId3).booleanValue() && !arrayList.contains(deviceId3)) {
                        arrayList.add(deviceId3);
                        JSONObject jSONObjectA5 = a(telephonyManager3, deviceId3);
                        if (jSONObjectA5 != null) {
                            l.put(jSONObjectA5);
                        }
                    }
                } catch (Throwable unused7) {
                }
                JSONArray jSONArrayH = H(context);
                JSONArray jSONArrayG = G(context);
                if (jSONArrayG != null) {
                    jSONArrayH = jSONArrayG;
                }
                JSONArray jSONArrayF = F(context);
                if (jSONArrayF != null) {
                    jSONArrayH = jSONArrayF;
                }
                JSONArray jSONArrayE = E(context);
                if (jSONArrayE == null) {
                    jSONArrayE = jSONArrayH;
                }
                if (jSONArrayE != null && jSONArrayE.length() > 0) {
                    for (int i2 = 0; i2 < jSONArrayE.length(); i2++) {
                        JSONObject jSONObject = jSONArrayE.getJSONObject(i2);
                        String string = jSONObject.getString("imei");
                        if (!arrayList.contains(string)) {
                            arrayList.add(string);
                            l.put(jSONObject);
                        }
                    }
                }
            }
        } catch (Throwable unused8) {
        }
        return l;
    }

    public static int C(Context context) {
        try {
            if (!af.a(23)) {
                return B(context).length();
            }
            if (f20060c == null) {
                a(context);
            }
            return f20060c.getPhoneCount();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static Map<String, Object> D(Context context) throws Throwable {
        DatagramSocket datagramSocket;
        if (e(context)) {
            try {
                String strB = b(context);
                if (strB != null) {
                    String strSubstring = strB.substring(0, strB.lastIndexOf(46) + 1);
                    DatagramPacket datagramPacket = new DatagramPacket(new byte[0], 0, 0);
                    datagramSocket = new DatagramSocket();
                    for (int i2 = 1; i2 < 255; i2++) {
                        try {
                            try {
                                try {
                                    datagramPacket.setAddress(InetAddress.getByName(strSubstring + i2));
                                    datagramSocket.send(datagramPacket);
                                    if (i2 == 125) {
                                        datagramSocket.close();
                                        datagramSocket = new DatagramSocket();
                                    }
                                } catch (Throwable unused) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (datagramSocket != null) {
                                    try {
                                        datagramSocket.close();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable unused3) {
                            if (datagramSocket != null) {
                                try {
                                    datagramSocket.close();
                                } catch (Throwable unused4) {
                                }
                            }
                            return null;
                        }
                    }
                    datagramSocket.close();
                } else {
                    datagramSocket = null;
                }
                Thread.sleep(5000L);
                Map<String, Object> mapB = b();
                if (datagramSocket != null) {
                    try {
                        datagramSocket.close();
                    } catch (Throwable unused5) {
                    }
                }
                return mapB;
            } catch (Throwable th2) {
                th = th2;
                datagramSocket = null;
            }
        }
        return null;
    }

    private static JSONArray E(Context context) {
        int i2;
        int i3;
        try {
            JSONArray jSONArray = new JSONArray();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Class<?> cls = Class.forName("com.android.internal.telephony.Phone");
            try {
                Field field = cls.getField("GEMINI_SIM_1");
                field.setAccessible(true);
                i2 = (Integer) field.get(null);
                Field field2 = cls.getField("GEMINI_SIM_2");
                field2.setAccessible(true);
                i3 = (Integer) field2.get(null);
            } catch (Throwable unused) {
                i2 = 0;
                i3 = 1;
            }
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", Integer.TYPE);
            if (telephonyManager != null && declaredMethod != null) {
                String strTrim = ((String) declaredMethod.invoke(telephonyManager, i2)).trim();
                String strTrim2 = ((String) declaredMethod.invoke(telephonyManager, i3)).trim();
                if (b(strTrim).booleanValue()) {
                    jSONArray.put(a(TelephonyManager.class, telephonyManager, i2, strTrim, "Gemini"));
                }
                if (b(strTrim2).booleanValue()) {
                    jSONArray.put(a(TelephonyManager.class, telephonyManager, i3, strTrim2, "Gemini"));
                }
                return jSONArray;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    private static JSONArray F(Context context) {
        int i2;
        int i3;
        JSONObject jSONObjectA;
        JSONObject jSONObjectA2;
        try {
            JSONArray jSONArray = new JSONArray();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Class<?> cls = Class.forName("com.android.internal.telephony.Phone");
            try {
                Field field = cls.getField("GEMINI_SIM_1");
                field.setAccessible(true);
                i2 = (Integer) field.get(null);
                Field field2 = cls.getField("GEMINI_SIM_2");
                field2.setAccessible(true);
                i3 = (Integer) field2.get(null);
            } catch (Throwable unused) {
                i2 = 0;
                i3 = 1;
            }
            Method method = TelephonyManager.class.getMethod("getDefault", Integer.TYPE);
            TelephonyManager telephonyManager2 = (TelephonyManager) method.invoke(telephonyManager, i2);
            TelephonyManager telephonyManager3 = (TelephonyManager) method.invoke(telephonyManager, i3);
            String strTrim = telephonyManager2.getDeviceId().trim();
            String strTrim2 = telephonyManager3.getDeviceId().trim();
            if (b(strTrim).booleanValue() && (jSONObjectA2 = a(telephonyManager2, strTrim)) != null) {
                jSONArray.put(jSONObjectA2);
            }
            if (b(strTrim2).booleanValue() && (jSONObjectA = a(telephonyManager3, strTrim2)) != null) {
                jSONArray.put(jSONObjectA);
            }
            return jSONArray;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static JSONArray G(Context context) {
        JSONObject jSONObjectA;
        JSONObject jSONObjectA2;
        try {
            JSONArray jSONArray = new JSONArray();
            Class<?> cls = Class.forName("com.android.internal.telephony.PhoneFactory");
            String str = (String) cls.getMethod("getServiceName", String.class, Integer.TYPE).invoke(cls, "phone", 1);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String strTrim = telephonyManager.getDeviceId().trim();
            TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService(str);
            String strTrim2 = telephonyManager2.getDeviceId().trim();
            if (b(strTrim).booleanValue() && (jSONObjectA2 = a(telephonyManager, strTrim)) != null) {
                jSONArray.put(jSONObjectA2);
            }
            if (b(strTrim2).booleanValue() && (jSONObjectA = a(telephonyManager2, strTrim2)) != null) {
                jSONArray.put(jSONObjectA);
            }
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONArray H(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            Class<?> cls = Class.forName("android.telephony.MSimTelephonyManager");
            Object systemService = context.getSystemService("phone_msim");
            Method method = cls.getMethod("getDeviceId", Integer.TYPE);
            String strTrim = ((String) method.invoke(systemService, 0)).trim();
            String strTrim2 = ((String) method.invoke(systemService, 1)).trim();
            if (b(strTrim).booleanValue()) {
                jSONArray.put(a(cls, systemService, 0, strTrim, ""));
            }
            if (b(strTrim2).booleanValue()) {
                jSONArray.put(a(cls, systemService, 1, strTrim2, ""));
            }
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    static void a(Context context) {
        try {
            f20060c = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
        }
    }

    private static String b(int i2) {
        switch (i2) {
            case 0:
            default:
                return "UNKNOWN";
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
            case 18:
                return "4G";
        }
    }

    public static String b(Context context) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress().toString();
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    public static boolean c(Context context) {
        ConnectivityManager connectivityManager;
        try {
            if (af.b(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                if (af.a(29)) {
                    Network activeNetwork = connectivityManager.getActiveNetwork();
                    if (activeNetwork != null) {
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                        return networkCapabilities != null && networkCapabilities.hasCapability(12);
                    }
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                    if (networkInfo == null || !networkInfo.getState().equals(NetworkInfo.State.UNKNOWN)) {
                        return false;
                    }
                }
            }
            if (SystemClock.elapsedRealtime() - i > h) {
                i = SystemClock.elapsedRealtime();
                Socket socket = null;
                try {
                    try {
                        socket = a() ? new Socket(Proxy.getDefaultHost(), Proxy.getDefaultPort()) : new Socket(f20058a, 80);
                        g = true;
                    } catch (Throwable unused) {
                        g = false;
                        if (socket != null) {
                        }
                        return g;
                    }
                    try {
                        socket.close();
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable th) {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            bp.postSDKError(th2);
        }
        return g;
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (!af.b(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean e(Context context) {
        try {
            if (j(context)) {
                return true;
            }
            return ((WifiManager) context.getSystemService(TencentLocationListener.WIFI)).isWifiEnabled();
        } catch (Throwable th) {
            bp.postSDKError(th);
            return false;
        }
    }

    public static boolean f(Context context) {
        try {
            if (f20060c == null) {
                a(context);
            }
            return f20060c.getSimState() == 5;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean g(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean h(Context context) {
        try {
            return af.a(17) ? Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1 : Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean i(Context context) {
        try {
            if (f20060c == null) {
                a(context);
            }
            int simState = f20060c.getSimState();
            return (1 == simState || simState == 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean j(Context context) {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        if (context == null && (context = ab.g) == null) {
            return false;
        }
        try {
            if (!af.b(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return false;
            }
            if (af.a(29)) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                return (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasTransport(1)) ? false : true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && 1 == activeNetworkInfo.getType() && activeNetworkInfo.isConnected();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean k(Context context) {
        if (context == null && (context = ab.g) == null) {
            return false;
        }
        try {
            if (f20060c == null) {
                a(context);
            }
            return f20060c.getDataState() == 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String l(Context context) {
        return !c(context) ? "OFFLINE" : j(context) ? "WIFI" : a(o(context));
    }

    public static String m(Context context) {
        return !c(context) ? "offline" : j(context) ? TencentLocationListener.WIFI : "cellular";
    }

    public static String n(Context context) {
        return (!(context == null && (context = ab.g) == null) && c(context)) ? j(context) ? "WIFI" : b(o(context)) : "UNKNOWN";
    }

    public static int o(Context context) {
        if (context == null) {
            try {
                if (ab.g == null) {
                    return 0;
                }
                context = ab.g;
            } catch (Throwable unused) {
                return 0;
            }
        }
        if (f20060c == null) {
            a(context);
        }
        return f20060c.getNetworkType();
    }

    public static String p(Context context) {
        try {
            if (f20060c == null) {
                a(context);
            }
            return f20060c.getNetworkOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String q(Context context) {
        try {
            if (f20060c == null) {
                a(context);
            }
            return f20060c.getSimOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String r(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(TencentLocationListener.WIFI);
        if (wifiManager == null || !af.b(context, "android.permission.ACCESS_WIFI_STATE") || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return null;
        }
        return connectionInfo.getBSSID();
    }

    public static String s(Context context) {
        try {
            if (f20060c == null) {
                a(context);
            }
            return f20060c.getNetworkCountryIso();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String t(Context context) {
        try {
            if (f20060c == null) {
                a(context);
            }
            return f20060c.getNetworkOperatorName();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String u(Context context) {
        try {
            if (f20060c == null) {
                a(context);
            }
            return f20060c.getSimOperatorName();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray v(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", TencentLocationListener.WIFI);
            jSONObject.put("available", e(context));
            jSONObject.put("connected", j(context));
            jSONObject.put("current", z(context));
            jSONObject.put("scannable", A(context));
            jSONObject.put(AppSettingsData.STATUS_CONFIGURED, y(context));
            jSONArray.put(jSONObject);
        } catch (Throwable unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "cellular");
            jSONObject2.put("available", f(context));
            jSONObject2.put("connected", k(context));
            jSONObject2.put("current", a(context, false));
            jSONObject2.put("scannable", w(context));
            jSONArray.put(jSONObject2);
        } catch (Throwable unused2) {
        }
        if (jSONArray.length() > 0) {
            return jSONArray;
        }
        return null;
    }

    @TargetApi(18)
    public static JSONArray w(Context context) {
        Context context2;
        List<NeighboringCellInfo> neighboringCellInfo;
        String str;
        CellSignalStrengthCdma cellSignalStrengthCdma;
        int mnc;
        int tac;
        int pci;
        int ci;
        int mcc;
        CellSignalStrength cellSignalStrength;
        if (context == null) {
            context2 = ab.g;
            if (context2 == null) {
                return null;
            }
        } else {
            context2 = context;
        }
        if (!af.b(context2, "android.permission.ACCESS_COARSE_LOCATION") && !af.b(context2, "android.permission.ACCESS_FINE_LOCATION")) {
            return null;
        }
        try {
            if (f20060c == null) {
                a(context2);
            }
            JSONArray jSONArray = new JSONArray();
            if (af.a(17)) {
                List<CellInfo> allCellInfo = f20060c.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("registered", cellInfo.isRegistered());
                            jSONObject.put("ts", cellInfo.getTimeStamp());
                            if (cellInfo instanceof CellInfoGsm) {
                                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                                CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                                int lac = cellIdentity.getLac();
                                int cid = cellIdentity.getCid();
                                int mcc2 = cellIdentity.getMcc();
                                str = "GSM";
                                mnc = cellIdentity.getMnc();
                                tac = lac;
                                pci = cid;
                                mcc = mcc2;
                                ci = -1;
                                cellSignalStrength = cellInfoGsm.getCellSignalStrength();
                            } else {
                                if (cellInfo instanceof CellInfoCdma) {
                                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                                    CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                                    int systemId = cellIdentity2.getSystemId();
                                    int networkId = cellIdentity2.getNetworkId();
                                    int basestationId = cellIdentity2.getBasestationId();
                                    CellSignalStrengthCdma cellSignalStrength2 = cellInfoCdma.getCellSignalStrength();
                                    jSONObject.put("cdmaDbm", cellSignalStrength2.getCdmaDbm());
                                    jSONObject.put("cdmaDbm", cellSignalStrength2.getCdmaDbm());
                                    jSONObject.put("cdmaEcio", cellSignalStrength2.getCdmaEcio());
                                    jSONObject.put("evdoDbm", cellSignalStrength2.getEvdoDbm());
                                    jSONObject.put("evdoEcio", cellSignalStrength2.getEvdoEcio());
                                    jSONObject.put("evdoSnr", cellSignalStrength2.getEvdoSnr());
                                    jSONObject.put("location", a(cellIdentity2.getLatitude(), cellIdentity2.getLongitude()));
                                    str = "CDMA";
                                    tac = systemId;
                                    pci = networkId;
                                    ci = basestationId;
                                    mnc = -1;
                                    cellSignalStrengthCdma = cellSignalStrength2;
                                } else if (cellInfo instanceof CellInfoWcdma) {
                                    str = "WCDMA";
                                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                                    CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                                    tac = cellIdentity3.getLac();
                                    pci = cellIdentity3.getCid();
                                    ci = cellIdentity3.getPsc();
                                    mcc = cellIdentity3.getMcc();
                                    mnc = cellIdentity3.getMnc();
                                    cellSignalStrength = cellInfoWcdma.getCellSignalStrength();
                                } else if (cellInfo instanceof CellInfoLte) {
                                    str = "LTE";
                                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                                    CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                                    tac = cellIdentity4.getTac();
                                    pci = cellIdentity4.getPci();
                                    ci = cellIdentity4.getCi();
                                    mcc = cellIdentity4.getMcc();
                                    mnc = cellIdentity4.getMnc();
                                    cellSignalStrength = cellInfoLte.getCellSignalStrength();
                                } else {
                                    str = null;
                                    cellSignalStrengthCdma = null;
                                    mnc = -1;
                                    tac = -1;
                                    pci = -1;
                                    ci = -1;
                                }
                                mcc = -1;
                                cellSignalStrength = cellSignalStrengthCdma;
                            }
                            if (tac != -1) {
                                jSONObject.put("systemId", tac);
                            }
                            if (pci != -1) {
                                jSONObject.put("networkId", pci);
                            }
                            if (ci != -1) {
                                jSONObject.put("basestationId", ci);
                            }
                            if (mcc != -1) {
                                jSONObject.put("mcc", mcc);
                            }
                            if (mnc != -1) {
                                jSONObject.put("mnc", mnc);
                            }
                            if (cellSignalStrength != null) {
                                jSONObject.put("asuLevel", cellSignalStrength.getAsuLevel());
                                jSONObject.put("dbm", cellSignalStrength.getDbm());
                            }
                            jSONObject.put("type", str);
                            jSONArray.put(jSONObject);
                        } catch (Throwable unused) {
                        }
                    }
                }
            } else if (af.a(5) && af.f19762c && (neighboringCellInfo = f20060c.getNeighboringCellInfo()) != null) {
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("systemId", neighboringCellInfo2.getLac());
                        jSONObject2.put("netId", neighboringCellInfo2.getCid());
                        jSONObject2.put("basestationId", neighboringCellInfo2.getPsc());
                        jSONObject2.put("asuLevel", neighboringCellInfo2.getRssi());
                        jSONObject2.put("type", neighboringCellInfo2.getNetworkType());
                        jSONArray.put(jSONObject2);
                    } catch (Throwable unused2) {
                    }
                }
            }
            return a(jSONArray, 20);
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    public static String x(Context context) {
        WifiInfo connectionInfo;
        try {
            if (!af.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService(TencentLocationListener.WIFI);
            if (!wifiManager.isWifiEnabled() || !j(context) || (connectionInfo = wifiManager.getConnectionInfo()) == null || connectionInfo.getSSID() == null) {
                return null;
            }
            return connectionInfo.getSSID();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray y(Context context) {
        List<WifiConfiguration> configuredNetworks;
        try {
            if (!af.b(context, "android.permission.ACCESS_WIFI_STATE") || (configuredNetworks = ((WifiManager) context.getSystemService(TencentLocationListener.WIFI)).getConfiguredNetworks()) == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("networkId", wifiConfiguration.networkId);
                    jSONObject.put("priority", wifiConfiguration.priority);
                    jSONObject.put("name", wifiConfiguration.SSID);
                    jSONObject.put("id", wifiConfiguration.BSSID);
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
            return b(jSONArray, 30);
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static JSONArray z(Context context) {
        WifiInfo connectionInfo;
        try {
            if (!af.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService(TencentLocationListener.WIFI);
            if (!wifiManager.isWifiEnabled() || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", connectionInfo.getSSID());
                jSONObject.put("id", bssid);
                jSONObject.put(FirebaseAnalytics.Param.LEVEL, connectionInfo.getRssi());
                jSONObject.put("hidden", connectionInfo.getHiddenSSID());
                jSONObject.put("ip", connectionInfo.getIpAddress());
                jSONObject.put("speed", connectionInfo.getLinkSpeed());
                jSONObject.put("networkId", connectionInfo.getNetworkId());
                jSONObject.put("mac", connectionInfo.getMacAddress());
                DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                if (dhcpInfo != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("dns1", dhcpInfo.dns1);
                    jSONObject2.put("dns2", dhcpInfo.dns2);
                    jSONObject2.put("gw", dhcpInfo.gateway);
                    jSONObject2.put("ip", dhcpInfo.ipAddress);
                    jSONObject2.put("mask", dhcpInfo.netmask);
                    jSONObject2.put("server", dhcpInfo.serverAddress);
                    jSONObject2.put("leaseDuration", dhcpInfo.leaseDuration);
                    jSONObject.put("dhcp", jSONObject2);
                }
            } catch (Throwable unused) {
            }
            jSONArray.put(jSONObject);
            return jSONArray;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static boolean a() {
        try {
            return af.a(11) ? !TextUtils.isEmpty(System.getProperty("http.proxyHost")) : !TextUtils.isEmpty(Proxy.getDefaultHost());
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String a(int i2) {
        if (i2 >= 0) {
            String[] strArr = f20061d;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
        }
        return String.valueOf(i2);
    }

    public static JSONArray a(Context context, boolean z) {
        CdmaCellLocation cdmaCellLocation;
        if (context == null) {
            try {
                if (ab.g == null) {
                    return null;
                }
                context = ab.g;
            } catch (Throwable th) {
                bp.postSDKError(th);
                return null;
            }
        }
        boolean z2 = true;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", o(context));
        jSONObject.put("mcc", p(context));
        jSONObject.put("operator", t(context));
        jSONObject.put("country", s(context));
        if (!af.b(context, "android.permission.ACCESS_COARSE_LOCATION") && !af.b(context, "android.permission.ACCESS_FINE_LOCATION")) {
            z2 = false;
        }
        if (z2) {
            if (f20060c == null) {
                a(context);
            }
            if (af.f19762c || z) {
                CellLocation cellLocation = f20060c.getCellLocation();
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    if (gsmCellLocation != null) {
                        jSONObject.put("systemId", gsmCellLocation.getLac());
                        jSONObject.put("networkId", gsmCellLocation.getCid());
                        if (af.a(9)) {
                            jSONObject.put("basestationId", gsmCellLocation.getPsc());
                        }
                    }
                } else if ((cellLocation instanceof CdmaCellLocation) && (cdmaCellLocation = (CdmaCellLocation) cellLocation) != null) {
                    jSONObject.put("systemId", cdmaCellLocation.getSystemId());
                    jSONObject.put("networkId", cdmaCellLocation.getNetworkId());
                    jSONObject.put("basestationId", cdmaCellLocation.getBaseStationId());
                    jSONObject.put("location", a(cdmaCellLocation.getBaseStationLatitude(), cdmaCellLocation.getBaseStationLongitude()));
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    public static JSONArray b(JSONArray jSONArray, int i2) {
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.optJSONObject(i3));
            }
            Collections.sort(arrayList, new Comparator<JSONObject>() { // from class: com.tendcloud.tenddata.u.2
                @Override // java.util.Comparator
                public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                    try {
                        return jSONObject.getInt("networkId") - jSONObject2.getInt("networkId");
                    } catch (Throwable unused) {
                        return 0;
                    }
                }
            });
            if (arrayList.size() <= i2) {
                i2 = arrayList.size();
            }
            return new JSONArray((Collection) arrayList.subList(0, i2));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Boolean b(String str) {
        try {
            Integer numValueOf = Integer.valueOf(str.length());
            if (numValueOf.intValue() > 10 && numValueOf.intValue() < 20 && !a(str.trim()).booleanValue()) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static Map<String, Object> b() {
        try {
            if (af.a(29)) {
                return c();
            }
            HashMap map = new HashMap();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/net/arp")));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    String[] strArrSplit = line.split("[ ]+");
                    if (!strArrSplit[0].matches("IP")) {
                        String str = strArrSplit[0];
                        String str2 = strArrSplit[3];
                        if (!map.containsKey(str) && !str2.equals("00:00:00:00:00:00")) {
                            map.put(str, str2);
                        }
                    }
                } else {
                    bufferedReader.close();
                    return map;
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String c(int i2) {
        if (i2 >= 0) {
            String[] strArr = f20062e;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
        }
        return String.valueOf(i2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:62|3)|(4:64|4|58|5)|(5:60|6|(3:8|(1:77)(3:69|14|(3:73|21|80))|74)(1:66)|25|50)|22|56|23|(1:25)|50|(1:(0))) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f A[PHI: r1 r3
      0x005f: PHI (r1v6 java.lang.Process) = (r1v5 java.lang.Process), (r1v8 java.lang.Process) binds: [B:48:0x008b, B:24:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x005f: PHI (r3v3 ??) = (r3v1 ??), (r3v6 ??) binds: [B:48:0x008b, B:24:0x005d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.Map<java.lang.String, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.HashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.String, java.lang.Object> c() throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L70 java.lang.Throwable -> L81
            java.lang.String r2 = "ip n"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L70 java.lang.Throwable -> L81
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L69 java.lang.Throwable -> L6e
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L69 java.lang.Throwable -> L6e
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L69 java.lang.Throwable -> L6e
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L69 java.lang.Throwable -> L6e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L69 java.lang.Throwable -> L6e
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L67
            r3.<init>()     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L67
        L1e:
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L63 java.lang.Throwable -> L65
            if (r0 == 0) goto L57
            java.lang.String r4 = "lladdr"
            int r4 = r0.indexOf(r4)     // Catch: java.lang.Throwable -> L63 java.lang.Throwable -> L65
            r5 = -1
            if (r4 <= r5) goto L1e
            java.lang.String r4 = " "
            java.lang.String[] r0 = r0.split(r4)     // Catch: java.lang.Throwable -> L63 java.lang.Throwable -> L65
            if (r0 == 0) goto L1e
            int r4 = r0.length     // Catch: java.lang.Throwable -> L63 java.lang.Throwable -> L65
            r5 = 5
            if (r4 <= r5) goto L1e
            r4 = 0
            r4 = r0[r4]     // Catch: java.lang.Throwable -> L63 java.lang.Throwable -> L65
            java.lang.String r0 = a(r0)     // Catch: java.lang.Throwable -> L63 java.lang.Throwable -> L65
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L63 java.lang.Throwable -> L65
            if (r5 != 0) goto L1e
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L63 java.lang.Throwable -> L65
            if (r5 == 0) goto L4d
            goto L1e
        L4d:
            boolean r5 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L63 java.lang.Throwable -> L65
            if (r5 != 0) goto L1e
            r3.put(r4, r0)     // Catch: java.lang.Throwable -> L63 java.lang.Throwable -> L65
            goto L1e
        L57:
            r1.waitFor()     // Catch: java.lang.Throwable -> L63 java.lang.Throwable -> L65
            r2.close()     // Catch: java.lang.Throwable -> L5d
        L5d:
            if (r1 == 0) goto L8e
        L5f:
            r1.destroy()
            goto L8e
        L63:
            goto L84
        L65:
            r0 = move-exception
            goto L74
        L67:
            r3 = r0
            goto L84
        L69:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L74
        L6e:
            r2 = r0
            goto L83
        L70:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L74:
            if (r2 == 0) goto L7b
            r2.close()     // Catch: java.lang.Throwable -> L7a
            goto L7b
        L7a:
        L7b:
            if (r1 == 0) goto L80
            r1.destroy()
        L80:
            throw r0
        L81:
            r1 = r0
            r2 = r1
        L83:
            r3 = r2
        L84:
            if (r2 == 0) goto L8b
            r2.close()     // Catch: java.lang.Throwable -> L8a
            goto L8b
        L8a:
        L8b:
            if (r1 == 0) goto L8e
            goto L5f
        L8e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.u.c():java.util.Map");
    }

    public static JSONArray a(JSONArray jSONArray, int i2) {
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.optJSONObject(i3));
            }
            Collections.sort(arrayList, new Comparator<JSONObject>() { // from class: com.tendcloud.tenddata.u.1
                @Override // java.util.Comparator
                public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                    try {
                        return jSONObject2.getInt("asuLevel") - jSONObject.getInt("asuLevel");
                    } catch (Throwable unused) {
                        return 0;
                    }
                }
            });
            if (arrayList.size() <= i2) {
                i2 = arrayList.size();
            }
            return new JSONArray((Collection) arrayList.subList(0, i2));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject a(int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.umeng.analytics.pro.b.B, i2);
            jSONObject.put(com.umeng.analytics.pro.b.C, i3);
            jSONObject.put("unit", "qd");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONArray a(ArrayList arrayList, int i2) {
        try {
            Collections.sort(arrayList, new Comparator<JSONObject>() { // from class: com.tendcloud.tenddata.u.3
                @Override // java.util.Comparator
                public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                    try {
                        return jSONObject2.getInt(FirebaseAnalytics.Param.LEVEL) - jSONObject.getInt(FirebaseAnalytics.Param.LEVEL);
                    } catch (Throwable unused) {
                        return 0;
                    }
                }
            });
            if (arrayList.size() <= i2) {
                i2 = arrayList.size();
            }
            return new JSONArray((Collection) arrayList.subList(0, i2));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONArray a(BitSet bitSet) {
        if (bitSet == null || bitSet.cardinality() < 1) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i2 = 0;
        while (true) {
            int iNextSetBit = bitSet.nextSetBit(i2);
            if (iNextSetBit < 0) {
                return jSONArray;
            }
            jSONArray.put(iNextSetBit);
            i2 = iNextSetBit + 1;
        }
    }

    private static JSONObject a(TelephonyManager telephonyManager, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imei", str.trim());
            String simCountryIso = "";
            jSONObject.put("subscriberId", telephonyManager.getSubscriberId() == null ? "" : telephonyManager.getSubscriberId());
            jSONObject.put("simSerialNumber", telephonyManager.getSimSerialNumber() == null ? "" : telephonyManager.getSimSerialNumber());
            jSONObject.put("dataState", telephonyManager.getDataState());
            jSONObject.put("networkType", a(telephonyManager.getNetworkType()));
            jSONObject.put("networkOperator", telephonyManager.getNetworkOperator());
            jSONObject.put("phoneType", c(telephonyManager.getPhoneType()));
            jSONObject.put("simOperator", telephonyManager.getSimOperator() == null ? "" : telephonyManager.getSimOperator());
            jSONObject.put("simOperatorName", telephonyManager.getSimOperatorName() == null ? "" : telephonyManager.getSimOperatorName());
            if (telephonyManager.getSimCountryIso() != null) {
                simCountryIso = telephonyManager.getSimCountryIso();
            }
            jSONObject.put("simCountryIso", simCountryIso);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONObject a(Context context, SubscriptionManager subscriptionManager, int i2) {
        SubscriptionInfo activeSubscriptionInfoForSimSlotIndex;
        JSONObject jSONObject = new JSONObject();
        try {
            if (af.a(22) && (activeSubscriptionInfoForSimSlotIndex = subscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(i2)) != null) {
                String countryIso = "";
                jSONObject.put("simSerialNumber", activeSubscriptionInfoForSimSlotIndex.getIccId() == null ? "" : activeSubscriptionInfoForSimSlotIndex.getIccId());
                jSONObject.put("simOperator", activeSubscriptionInfoForSimSlotIndex.getMcc() + "0" + activeSubscriptionInfoForSimSlotIndex.getMnc());
                jSONObject.put("simOperatorName", activeSubscriptionInfoForSimSlotIndex.getCarrierName() == null ? "" : activeSubscriptionInfoForSimSlotIndex.getCarrierName());
                if (activeSubscriptionInfoForSimSlotIndex.getCountryIso() != null) {
                    countryIso = activeSubscriptionInfoForSimSlotIndex.getCountryIso();
                }
                jSONObject.put("simCountryIso", countryIso);
                jSONObject.put("subscriberId", q.f(context));
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static Boolean a(String str) {
        try {
            char cCharAt = str.length() > 0 ? str.charAt(0) : '0';
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (cCharAt != str.charAt(i2)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static JSONObject a(Class<?> cls, Object obj, Integer num, String str, String str2) throws JSONException {
        String strTrim = "";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imei", str);
        try {
            Method method = cls.getMethod("getSubscriberId" + str2, Integer.TYPE);
            jSONObject.put("subscriberId", method.invoke(obj, num) == null ? "" : ((String) method.invoke(obj, num)).trim());
        } catch (Throwable unused) {
        }
        try {
            Method method2 = cls.getMethod("getSimSerialNumber" + str2, Integer.TYPE);
            jSONObject.put("simSerialNumber", method2.invoke(obj, num) == null ? "" : ((String) method2.invoke(obj, num)).trim());
        } catch (Throwable unused2) {
        }
        try {
            jSONObject.put("dataState", (Integer) cls.getMethod("getDataState" + str2, Integer.TYPE).invoke(obj, num));
        } catch (Throwable unused3) {
        }
        try {
            jSONObject.put("networkType", a(((Integer) cls.getMethod("getNetworkType" + str2, Integer.TYPE).invoke(obj, num)).intValue()));
        } catch (Throwable unused4) {
        }
        try {
            jSONObject.put("networkOperator", (String) cls.getMethod("getNetworkOperator" + str2, Integer.TYPE).invoke(obj, num));
        } catch (Throwable unused5) {
        }
        try {
            jSONObject.put("phoneType", c(((Integer) cls.getMethod("getPhoneType" + str2, Integer.TYPE).invoke(obj, num)).intValue()));
        } catch (Throwable unused6) {
        }
        try {
            Method method3 = cls.getMethod("getSimOperator" + str2, Integer.TYPE);
            jSONObject.put("simOperator", method3.invoke(obj, num) == null ? "" : ((String) method3.invoke(obj, num)).trim());
        } catch (Throwable unused7) {
        }
        try {
            Method method4 = cls.getMethod("getSimOperatorName" + str2, Integer.TYPE);
            if (method4.invoke(obj, num) != null) {
                strTrim = ((String) method4.invoke(obj, num)).trim();
            }
            jSONObject.put("simOperatorName", strTrim);
        } catch (Throwable unused8) {
        }
        return jSONObject;
    }

    private static String a(String[] strArr) {
        if (strArr != null && strArr.length >= 6) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= strArr.length) {
                    break;
                }
                if ("lladdr".equalsIgnoreCase(strArr[i3])) {
                    i2 = i3 + 1;
                    break;
                }
                i3++;
            }
            if (i2 > 0 && i2 < strArr.length) {
                String str = strArr[i2];
                if (str.matches("([\\da-fA-F]{2}:){5}([\\da-fA-F]{2}){1}") && !str.equals("00:00:00:00:00:00")) {
                    return str;
                }
            }
        }
        return null;
    }
}
