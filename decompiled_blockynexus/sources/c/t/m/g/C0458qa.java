package c.t.m.g;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import android.util.Pair;
import com.tencent.map.geolocation.TencentLocation;
import io.rong.common.dlog.DLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: c.t.m.g.qa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class C0458qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f3349a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f3351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0469ua f3352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HandlerThread f3353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Location f3354f;
    public volatile Location g;
    public volatile List<cp> h;
    private volatile cp i;
    public volatile List<ScanResult> j;
    private LruCache<String, Pair<Double, Double>> k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f3350b = new byte[0];
    public long l = 180000;
    public long m = 0;
    public long n = 0;
    public long o = 0;

    public C0458qa(Context context) {
        StringBuilder sb;
        this.f3351c = context == null ? null : context.getApplicationContext();
        if (this.f3351c == null) {
            throw new IllegalArgumentException("context cannot be null!");
        }
        a(context);
        this.k = new LruCache<>(100);
        String string = "";
        try {
            try {
                try {
                    boolean z = C0481ya.f3446a;
                    boolean z2 = C0481ya.f3447b;
                    string = this.f3351c.getExternalFilesDir("data").getAbsolutePath();
                } catch (Throwable th) {
                    if (TextUtils.isEmpty("")) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.f3351c.getFilesDir().getAbsolutePath());
                        sb2.append("/data/");
                    }
                    throw th;
                }
            } catch (Throwable unused) {
                if (TextUtils.isEmpty("")) {
                    sb = new StringBuilder();
                    sb.append(this.f3351c.getFilesDir().getAbsolutePath());
                }
            }
            if (TextUtils.isEmpty(string)) {
                sb = new StringBuilder();
                sb.append(this.f3351c.getFilesDir().getAbsolutePath());
                sb.append("/data/");
                string = sb.toString();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.f3352d = new C0469ua(this.f3351c, string);
            e();
        } catch (Throwable unused2) {
            this.f3352d = null;
        }
    }

    private static double a(double d2) {
        return (d2 * 3.141592653589793d) / 180.0d;
    }

    public static String a(String str) {
        return str == null ? "" : str;
    }

    public static synchronized Context d() {
        if (f3349a == null) {
            throw new NullPointerException("u should init first.");
        }
        return f3349a;
    }

    private void e() {
        for (Map.Entry<String, String> entry : C0481ya.b().entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    private void f() {
        this.f3354f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.m = 0L;
        this.n = 0L;
        this.o = 0L;
        this.k.evictAll();
    }

    public final void a(Looper looper) {
        synchronized (this.f3350b) {
            f();
            if (this.f3352d != null) {
                if (looper == null) {
                    this.f3353e = new HandlerThread("thread_dc");
                    this.f3353e.start();
                    looper = this.f3353e.getLooper();
                }
                this.f3352d.b(looper);
            }
        }
    }

    public final void b() {
        if (!a(this.f3352d, this.f3354f) || a(this.h)) {
            return;
        }
        if (C0481ya.f3451f && Da.a(this.f3351c) == 3) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.m < this.l) {
            this.o = jCurrentTimeMillis;
            this.g = a(this.g, this.f3354f);
            this.f3352d.a(this.f3354f, (List<ScanResult>) null, this.h);
        }
    }

    public final boolean c() {
        C0469ua c0469ua = this.f3352d;
        if (c0469ua == null) {
            return false;
        }
        return c0469ua.b();
    }

    public static boolean c(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int d(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return -1;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType();
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static boolean e(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo2 == null) {
                return false;
            }
            boolean zIsConnected = networkInfo2.isConnected();
            return (zIsConnected || networkInfo == null) ? zIsConnected : networkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static byte[] b(byte[] bArr) {
        if (bArr != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                a("compressGzip failed.", th);
                return Ta.f3014a;
            }
        }
        throw new NullPointerException("object is null.");
    }

    public final void a() {
        synchronized (this.f3350b) {
            if (this.f3352d != null && this.f3352d.b()) {
                C0469ua c0469ua = this.f3352d;
                synchronized (c0469ua.f3228c) {
                    if (c0469ua.f3227b) {
                        c0469ua.f3227b = false;
                        c0469ua.a();
                        c0469ua.c();
                    }
                }
            }
            Xa.a(this.f3353e, null, 300L);
            this.f3353e = null;
            f();
        }
    }

    private static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    @android.annotation.SuppressLint({"MissingPermission"})
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.wifi.WifiInfo b(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L5
            r1 = r0
            goto Ld
        L5:
            java.lang.String r1 = "wifi"
            java.lang.Object r1 = r4.getSystemService(r1)     // Catch: java.lang.Throwable -> L55
            android.net.wifi.WifiManager r1 = (android.net.wifi.WifiManager) r1     // Catch: java.lang.Throwable -> L55
        Ld:
            if (r4 != 0) goto L11
            r4 = r0
            goto L19
        L11:
            java.lang.String r2 = "connectivity"
            java.lang.Object r4 = r4.getSystemService(r2)     // Catch: java.lang.Throwable -> L55
            android.net.ConnectivityManager r4 = (android.net.ConnectivityManager) r4     // Catch: java.lang.Throwable -> L55
        L19:
            if (r1 == 0) goto L55
            if (r4 != 0) goto L1e
            goto L55
        L1e:
            android.net.wifi.WifiInfo r1 = r1.getConnectionInfo()     // Catch: java.lang.Throwable -> L55
            r2 = 1
            android.net.NetworkInfo r4 = r4.getNetworkInfo(r2)     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L55
            if (r4 == 0) goto L55
            boolean r4 = r4.isConnected()     // Catch: java.lang.Throwable -> L55
            if (r4 != 0) goto L32
            goto L55
        L32:
            java.lang.String r4 = r1.getBSSID()     // Catch: java.lang.Throwable -> L55
            if (r4 == 0) goto L50
            java.lang.String r3 = "000000000000"
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L55
            if (r3 != 0) goto L50
            java.lang.String r3 = "00-00-00-00-00-00"
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L55
            if (r3 != 0) goto L50
            java.lang.String r3 = "00:00:00:00:00:00"
            boolean r4 = r4.equals(r3)     // Catch: java.lang.Throwable -> L55
            if (r4 == 0) goto L51
        L50:
            r2 = 0
        L51:
            if (r2 != 0) goto L54
            return r0
        L54:
            return r1
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.C0458qa.b(android.content.Context):android.net.wifi.WifiInfo");
    }

    public final void a(Da da) {
        synchronized (this.f3350b) {
            if (this.f3352d != null) {
                this.f3352d.h = da;
                StringBuilder sb = new StringBuilder("appInfo:1.4.8,");
                sb.append(Da.a(da.f2895b));
                sb.append("_");
                sb.append(Da.a(da.f2894a));
                sb.append(",");
                sb.append(Da.a(Build.MANUFACTURER));
                sb.append(",");
                sb.append(Da.a(Build.MODEL));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0113 A[Catch: all -> 0x011c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x011c, blocks: (B:11:0x001e, B:13:0x0034, B:16:0x0056, B:18:0x0060, B:21:0x006a, B:31:0x0113, B:25:0x0090), top: B:46:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0116 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(c.t.m.g.cp r20, java.util.List<c.t.m.g.cp> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.C0458qa.a(c.t.m.g.cp, java.util.List):void");
    }

    public final void a(String str, String str2) {
        synchronized (this.f3350b) {
            if (this.f3352d == null || b(str2)) {
                return;
            }
            try {
                StringBuilder sb = new StringBuilder("setSetting(");
                sb.append(str);
                sb.append(",");
                sb.append(str2);
                sb.append(")");
                if ("D_CH_ID".equals(str)) {
                    Aa.a(str2);
                } else if ("D_FC_SRC".equals(str)) {
                    Aa.b(str2);
                } else if ("D_POS_COLL".equals(str)) {
                    C0481ya.f3448c = Boolean.parseBoolean(str2.toLowerCase());
                } else if ("D_WRITE_MAC".equals(str)) {
                    C0481ya.f3449d = Boolean.parseBoolean(str2.toLowerCase());
                } else {
                    if ("D_UP_NET".equals(str)) {
                        if ("m".equals(str2.toLowerCase())) {
                            C0481ya.f3451f = true;
                        } else if ("w".equals(str2.toLowerCase())) {
                            C0481ya.f3451f = false;
                            C0481ya.g = false;
                        } else if ("w_m1".equals(str2.toLowerCase())) {
                            C0481ya.f3451f = false;
                            C0481ya.g = true;
                        }
                    } else if ("D_HUAWEI_SET_SN".equals(str)) {
                        Ca.f2889a = b(str2) ? "" : str2;
                    } else {
                        C0469ua c0469ua = this.f3352d;
                        if ("D_UP_INTERVAL".equals(str)) {
                            c0469ua.k = Math.max(900000L, Long.parseLong(str2));
                        } else if ("D_UP_USE_HTTPS".equals(str)) {
                            C0481ya.f3450e = Boolean.parseBoolean(str2);
                        } else if ("D_MAX_1F_SIZE".equals(str)) {
                            c0469ua.j = C0469ua.a(Long.parseLong(str2), 10240L, 512000L);
                        } else if ("D_NUM_UP".equals(str)) {
                            c0469ua.l = (int) C0469ua.a(Long.parseLong(str2), 1L, 5L);
                        } else if ("D_MAX_BUF_WF".equals(str)) {
                            c0469ua.m = (int) C0469ua.a(Long.parseLong(str2), 5120L, 51200L);
                        } else if ("D_MAX_FOLDER_SIZE".equals(str)) {
                            c0469ua.n = C0469ua.a(Long.parseLong(str2), 10485760L, 209715200L);
                        } else if ("D_MAX_SIZE_UP_1DAY".equals(str)) {
                            c0469ua.o = Math.max(Long.parseLong(str2), 0L);
                        } else if ("D_MAX_DAY_RENAME".equals(str)) {
                            c0469ua.p = C0469ua.a(Long.parseLong(str2), 1L, 5L) * 24 * 60 * 60 * 1000;
                        } else if ("D_MAX_DAY_DELETE".equals(str)) {
                            c0469ua.q = C0469ua.a(Long.parseLong(str2), 1L, 30L) * 24 * 60 * 60 * 1000;
                        } else if ("D_UP_WF_INFO".equals(str)) {
                            c0469ua.r = Boolean.parseBoolean(str2);
                        } else if ("D_CHEJI_ALLOW_UPLOAD_GPS".equals(str)) {
                            c0469ua.s = Integer.parseInt(str2) == 1 ? 1 : 0;
                        } else if ("D_CHEJI_UPLOAD_GPS_INTERVAL".equals(str)) {
                            c0469ua.t = C0469ua.a(Long.parseLong(str2), 20000L, 60000L);
                        } else if ("D_CHEJI_COLL_GPS_INTERVAL".equals(str)) {
                            c0469ua.u = C0469ua.a(Long.parseLong(str2), 1000L, 5000L);
                        } else if ("D_CHEJI_SET_STATUS".equals(str)) {
                            Integer.parseInt(str2);
                        } else if (!"D_CHEJI_SET_LOC_SDK_VER".equals(str)) {
                            "D_CHEJI_SET_LOC_SDK_APPKEY".equals(str);
                        }
                    }
                }
            } catch (Throwable th) {
                a("set setting data[" + str + "," + str2 + "] error.", th);
            }
        }
    }

    public static Location a(Location location, Location location2) {
        if (location == null) {
            location = new Location("gps");
        }
        if (location2 != null) {
            location.set(location2);
        }
        return location;
    }

    public static String a(byte[] bArr) {
        if (c(bArr)) {
            return "";
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b2)));
            }
            return sb.toString();
        } catch (Throwable th) {
            a("getMd5 error.", th);
            return "";
        }
    }

    public static synchronized void a(Context context) {
        if (f3349a == null || f3349a.getApplicationContext() == null) {
            if (context != null && context.getApplicationContext() != null) {
                f3349a = context.getApplicationContext();
            } else {
                throw new NullPointerException("context cannot be null.");
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static byte[] a(File file) throws Throwable {
        byte[] byteArray;
        BufferedInputStream bufferedInputStream;
        if (file.exists() && file.length() != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BufferedInputStream bufferedInputStream2 = null;
            byte[] bArrA = Sa.a().a(DLog.CRS);
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (Throwable unused) {
                }
                while (true) {
                    try {
                        int i = bufferedInputStream.read(bArrA);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArrA, 0, i);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream2 = bufferedInputStream;
                        Sa.a().a(bArrA);
                        a(bufferedInputStream2);
                        a(byteArrayOutputStream);
                        throw th;
                    }
                    a(byteArrayOutputStream);
                    return byteArray;
                }
                byteArray = byteArrayOutputStream.toByteArray();
                Sa.a().a(bArrA);
                a(bufferedInputStream);
                a(byteArrayOutputStream);
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return Ta.f3014a;
        }
    }

    public static boolean a(File file, byte[] bArr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            fileOutputStream.write(bArr);
            a(fileOutputStream);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a(Handler handler) {
        Looper looper = handler == null ? null : handler.getLooper();
        return looper != null && looper.getThread().isAlive();
    }

    public static boolean a(Handler handler, int i, long j) {
        return a(handler, handler == null ? null : handler.obtainMessage(i), j);
    }

    public static boolean a(Handler handler, Message message, long j) {
        if (message == null || !a(handler)) {
            return false;
        }
        return handler.sendMessageDelayed(message, j);
    }

    public static void a(String str, Throwable th) {
        while (true) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(". exception: ");
                sb.append(Log.getStackTraceString(th));
                return;
            } catch (Throwable th2) {
                th = th2;
                if (th instanceof OutOfMemoryError) {
                    return;
                } else {
                    str = "";
                }
            }
        }
    }

    private static boolean a(Object... objArr) {
        for (int i = 0; i < 2; i++) {
            if (objArr[i] == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static Location a(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return null;
        }
        Location location = new Location(tencentLocation.getProvider());
        location.setLatitude(tencentLocation.getLatitude());
        location.setLongitude(tencentLocation.getLongitude());
        location.setAccuracy(tencentLocation.getAccuracy());
        location.setTime(tencentLocation.getTime());
        return location;
    }
}
