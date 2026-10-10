package com.tendcloud.tenddata;

import android.content.Context;
import android.os.Handler;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.sandboxol.center.config.IntConstant;
import java.io.File;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class ab {
    public static final String A = "TD_sdk_last_send_time_mobile_data";
    public static final String B = "isDeveloper";
    public static final int G = 104857600;
    static final String I = "All";
    public static final String K = "v1.0.0";
    public static final String L = "Android+TD+V4.0.56 gp";
    static long M = 0;
    public static final int P = 1800000;
    public static final long R = 30000;
    public static final int S = 100;
    public static final String T = "TD_APP_ID";
    public static final String U = "TD_CHANNEL_ID";
    private static final String W = "+V";
    private static final int X = 120;
    private static final int Y = 30;
    private static final int Z = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f19747a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f19748b = false;
    public static final int i = 1;
    public static final String j = "Android+";
    public static FileChannel k = null;
    public static String s = null;
    public static final String t = "TD";
    public static final String u = "TDLog";
    public static final String v = "1387";
    public static final String w = "TD_app_pefercen_profile";
    public static final String x = "TD_appId_";
    public static final String y = "TD_channelId";
    public static final String z = "TD_sdk_last_send_time_wifi";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f19749c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Object> f19750d = new TreeMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f19751e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f19752f = 0;
    public static Context g = null;
    public static Handler h = null;
    public static long l = 0;
    public static boolean m = false;
    public static int n = -1;
    public static boolean o = true;
    public static boolean p = true;
    public static boolean q = false;
    public static long r = 5000;
    private static HashMap<String, Object> V = new HashMap<>();
    public static String C = "Default";
    public static boolean D = false;
    public static String E = null;
    public static boolean F = false;
    static final String H = "WiFi";
    static String J = H;
    public static int N = 2;
    public static AtomicInteger O = new AtomicInteger(0);
    public static final AtomicBoolean Q = new AtomicBoolean(false);

    /* JADX INFO: compiled from: td */
    public class a {
        public static final int DST_FILE = 2;
        public static final int DST_SQLITE = 1;

        public a() {
        }
    }

    /* JADX INFO: compiled from: td */
    public static class b {
        public static final int API_MYNA_INIT = 90;
        public static final int API_MYNA_START = 91;
        public static final int API_MYNA_STOP = 92;
        public static final int API_ON_ERROR = 3;
        public static final int API_ON_EVENT = 2;
        public static final int API_ON_INIT = 1;
        public static final int API_ON_PAGE_END = 5;
        public static final int API_ON_PAGE_START = 4;
        public static final int API_TYPE_ACCOUNT = 9;
        public static final int API_TYPE_BRAND_GROWTH = 16;
        public static final int API_TYPE_CUST_LOCATION = 14;
        public static final int API_TYPE_GAME = 6;
        public static final int API_TYPE_GAME_SESSION_END = 15;
        public static final int API_TYPE_GAME_SESSION_START = 12;
        public static final int API_TYPE_IAP = 8;
        public static final int API_TYPE_INDUSTRY = 17;
        public static final int API_TYPE_SESSION_END = 11;
        public static final int API_TYPE_SESSION_PAUSE = 13;
        public static final int API_TYPE_SESSION_START = 10;
        public static final int API_TYPE_TRACKING = 7;
    }

    /* JADX INFO: compiled from: td */
    public class c {
        public static final int SDT_JSON = 2;
        public static final int SDT_MP = 1;
        public static final int SDT_PB = 3;
        public static final int SDT_UNKNOWN = -1;

        public c() {
        }
    }

    public static String a(Context context, com.tendcloud.tenddata.a aVar) {
        if (context == null || aVar == null) {
            m.dForInternal("Context or Service is null");
            return "";
        }
        String str = (String) V.get(aVar.name());
        if (!af.b(str)) {
            return str;
        }
        return w.b(context, w, x + aVar.name(), "");
    }

    public static String b(Context context, com.tendcloud.tenddata.a aVar) {
        if (af.b(C) || C.equals("Default")) {
            C = w.b(context, w, y + aVar.name(), "Default");
        }
        return C;
    }

    public static String c() {
        try {
            return new cy().b();
        } catch (Throwable unused) {
            return "Native";
        }
    }

    private static boolean d(com.tendcloud.tenddata.a aVar) {
        if (g == null || !aVar.name().equals("GAME")) {
            return false;
        }
        File filesDir = g.getFilesDir();
        try {
            File file = new File(filesDir, "td_database0SaaS");
            File file2 = new File(filesDir, "td_database1SaaS");
            File file3 = new File(filesDir, aa.z);
            File file4 = new File(file3, "td_database0SaaS");
            File file5 = new File(file3, "td_database1SaaS");
            if (!file2.exists() && !file.exists() && !file5.exists()) {
                if (!file4.exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setDeveloperMode(boolean z2) {
        try {
            w.a(g, w, B, z2 ? 1L : 0L);
        } catch (Throwable unused) {
        }
    }

    private static boolean c(com.tendcloud.tenddata.a aVar) {
        if (g == null || !aVar.name().equals("APP")) {
            return false;
        }
        File filesDir = g.getFilesDir();
        try {
            File file = new File(filesDir, "td_database3SaaS");
            File file2 = new File(filesDir, "td_database1SaaS");
            File file3 = new File(filesDir, aa.z);
            File file4 = new File(file3, "td_database3SaaS");
            File file5 = new File(file3, "td_database1SaaS");
            if (!file.exists() && !file2.exists() && !file4.exists()) {
                if (!file5.exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(String str, com.tendcloud.tenddata.a aVar) {
        w.a(g, w, y + aVar.name(), str);
    }

    public static void a(String str, com.tendcloud.tenddata.a aVar) {
        if (aVar != null) {
            V.put(aVar.name(), str);
            w.a(g, w, x + aVar.name(), str);
        }
    }

    public static boolean b() {
        try {
            return w.b(g, w, B, 0L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean b(com.tendcloud.tenddata.a aVar) {
        if (g == null || !aVar.name().equals("TRACKING")) {
            return false;
        }
        File filesDir = g.getFilesDir();
        try {
            File file = new File(filesDir, "td_database3SaaS");
            File file2 = new File(filesDir, "td_database0SaaS");
            File file3 = new File(filesDir, aa.z);
            File file4 = new File(file3, "td_database3SaaS");
            File file5 = new File(file3, "td_database0SaaS");
            if (!file.exists() && !file2.exists() && !file4.exists()) {
                if (!file5.exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int[] a() {
        return new int[]{IntConstant.ADS_INTERVAL, 30000};
    }

    public static void a(String str, String str2, com.tendcloud.tenddata.a aVar) {
        Context context = g;
        if (context != null) {
            h = new Handler(context.getMainLooper());
        }
        f19752f = System.currentTimeMillis();
        if (str != null && !str.trim().isEmpty() && str.contains("-") && !aVar.name().equals("FINTECH")) {
            try {
                str = str.split("-")[1];
            } catch (Throwable unused) {
                str = null;
            }
        }
        if (str2 != null && !str2.trim().isEmpty()) {
            C = str2;
        }
        a(str, aVar);
        b(C, aVar);
        cv.a().a((Object) str, aVar);
        cv.a().b(C, aVar);
        a(dz.f20015a);
    }

    private static boolean c(Context context, com.tendcloud.tenddata.a aVar) {
        try {
            if (g == null || !aVar.name().equals("TRACKING") || !context.getSharedPreferences("talkingdata_file_prefence", 0).getBoolean("actived", false)) {
                return true;
            }
            n.a(false, aVar);
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void a(int i2) {
        try {
            cy cyVar = new cy();
            if (i2 == 1) {
                cyVar.setFrameWork("Cocos2d");
            } else if (i2 == 2) {
                cyVar.setFrameWork(CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY);
            } else if (i2 == 3) {
                cyVar.setFrameWork("AIR");
            } else if (i2 != 4) {
                cyVar.setFrameWork("Native");
            } else {
                cyVar.setFrameWork("PhoneGap");
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(com.tendcloud.tenddata.a aVar) {
        if (g == null || aVar == null) {
            return false;
        }
        if (a(g)) {
            return n.e(aVar) == 1;
        }
        if (n.e(aVar) == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - n.d(aVar) > r * 4) {
                n.a(false, aVar);
            } else {
                if (jCurrentTimeMillis - n.e() <= r * 4) {
                    return c(g, aVar);
                }
                if (b(aVar) || d(aVar) || c(aVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(Context context) {
        try {
            return l.a().d(context) == l.a().e(context);
        } catch (Throwable unused) {
            return false;
        }
    }
}
