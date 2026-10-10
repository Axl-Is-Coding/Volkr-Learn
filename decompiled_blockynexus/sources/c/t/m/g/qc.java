package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.text.TextUtils;
import c.t.m.g.AbstractC0462s;
import com.tencent.map.geolocation.TencentLocationListener;
import java.io.ByteArrayOutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes.dex */
public final class qc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f3356a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3357b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f3358c = "unknown";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile int f3359d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f3360e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile int f3361f = -1;
    private static Map<String, a> g = new ConcurrentHashMap();
    private static BroadcastReceiver h = new rc();
    private static String i = "";
    private static String j = "cmwap";
    private static String k = "3gwap";
    private static String l = "uniwap";
    private static String m = "ctwap";

    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f3362a;

        default a() {
        }

        static void a(int i, String str) {
            if (i != 0) {
                ic.b();
                ic.c();
                ic.f3246b = str;
            }
        }

        private static String b(String str, int i) {
            return C0434ia.d().e().a(str, i, fc.f(), fc.g, N.a().a(qc.b()), C0446ma.a(qc.g()));
        }

        static int a(String str, int i, int i2, int i3) {
            int i4;
            try {
                String strB = b(str, fc.c());
                if (TextUtils.isEmpty(strB)) {
                    strB = b(str, 0);
                }
                i4 = Integer.parseInt(strB);
            } catch (Throwable unused) {
                i4 = i3;
            }
            return C0455pa.a(i4, i, i2, i3);
        }

        static Handler a(String str) {
            HandlerThread handlerThread = new HandlerThread("halley_" + fc.c() + "_" + str, 10);
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0037 -> B:22:0x003f). Please report as a decompilation issue!!! */
        static boolean a(String str, boolean z, Map<String, String> map) {
            if (map != null) {
                Iterator<String> it = map.keySet().iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            try {
                B bE = B.e();
                String strA = B.a(str, z, map);
                try {
                    if (bE.j.getAndIncrement() > bE.k) {
                        bE.j.decrementAndGet();
                    } else {
                        new AbstractC0462s.b(strA).a(false);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return true;
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
        }

        static boolean a(int i) {
            return i > 0 && i <= Integer.MAX_VALUE && new Random().nextInt(i) == 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0033  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static int a(java.lang.String r5, int r6) {
            /*
                java.lang.String r0 = "HLDisconnEvent"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto La
                r5 = -2
                return r5
            La:
                r5 = -288(0xfffffffffffffee0, float:NaN)
                r0 = -3
                r1 = 1
                r2 = -4
                r3 = 0
                if (r6 == 0) goto L22
                if (r6 == r2) goto L1b
                if (r6 == r0) goto L1b
                if (r6 != r5) goto L19
                goto L1b
            L19:
                r4 = 0
                goto L1c
            L1b:
                r4 = 1
            L1c:
                if (r4 == 0) goto L1f
                goto L22
            L1f:
                java.lang.String r4 = "self_report_fail_denominator_value"
                goto L24
            L22:
                java.lang.String r4 = "self_report_succ_denominator_value"
            L24:
                if (r6 == 0) goto L33
                if (r6 == r2) goto L2e
                if (r6 == r0) goto L2e
                if (r6 != r5) goto L2d
                goto L2e
            L2d:
                r1 = 0
            L2e:
                if (r1 == 0) goto L31
                goto L33
            L31:
                r5 = 2
                goto L35
            L33:
                r5 = 100
            L35:
                r6 = 2147483647(0x7fffffff, float:NaN)
                int r5 = a(r4, r3, r6, r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.qc.a.a(java.lang.String, int):int");
        }

        static byte[] a(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Deflater deflater = new Deflater();
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[256];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            deflater.finish();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        }
    }

    public static void a() {
        try {
            e();
            fc.a().registerReceiver(h, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, a aVar) {
        synchronized (g) {
            g.put(str, aVar);
        }
    }

    public static String b() {
        return f3358c;
    }

    public static String c() {
        int i2 = f3359d;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "" : "4g" : "3g" : "2g" : TencentLocationListener.WIFI;
    }

    public static String d() {
        int i2 = f3359d;
        return i2 != 1 ? (i2 == 2 || i2 == 3 || i2 == 4) ? f3357b : "null" : TencentLocationListener.WIFI;
    }

    public static synchronized void e() {
        int i2;
        try {
            i2 = f3359d;
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) fc.a().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    f3356a = true;
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        f3359d = 1;
                        f3361f = 0;
                        f3360e = false;
                        WifiInfo connectionInfo = ((WifiManager) fc.a().getApplicationContext().getSystemService(TencentLocationListener.WIFI)).getConnectionInfo();
                        f3358c = "ssid_" + connectionInfo.getSSID() + connectionInfo.getBSSID();
                    } else {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        if (extraInfo != null) {
                            f3357b = extraInfo.trim().toLowerCase();
                            if (type == 0) {
                                f3358c = "apn_" + f3357b;
                                int subtype = activeNetworkInfo.getSubtype();
                                f3361f = subtype;
                                if (subtype == 1 || subtype == 2 || subtype == 4) {
                                    f3359d = 2;
                                } else if (subtype == 13 || subtype == 19) {
                                    f3359d = 4;
                                } else {
                                    f3359d = 3;
                                }
                                boolean zContains = f3357b.contains("wap");
                                f3360e = zContains;
                                if (zContains) {
                                    String str = (f3357b.contains(k) || f3357b.contains(j) || f3357b.contains(l)) ? "10.0.0.172" : f3357b.contains(m) ? "10.0.0.200" : "";
                                    i = str;
                                }
                            } else {
                                f3357b = "unknown";
                                f3359d = 0;
                                f3361f = -1;
                                f3358c = "unknown";
                                f3360e = false;
                            }
                        } else {
                            f3357b = "unknown";
                            f3359d = 0;
                            f3361f = -1;
                            f3358c = "unknown";
                            f3360e = false;
                        }
                    }
                } else {
                    f3357b = "unknown";
                    f3359d = 0;
                    f3361f = -1;
                    f3358c = "unknown";
                    f3360e = false;
                    f3356a = false;
                }
                if (i2 != f3359d) {
                    synchronized (g) {
                        Iterator<a> it = g.values().iterator();
                        while (it.hasNext()) {
                            if (it.next() != null) {
                                a.a(f3359d, f3358c);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (i2 != f3359d) {
                    synchronized (g) {
                        Iterator<a> it2 = g.values().iterator();
                        while (it2.hasNext()) {
                            if (it2.next() != null) {
                                a.a(f3359d, f3358c);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            if (i2 != f3359d) {
                synchronized (g) {
                    Iterator<a> it3 = g.values().iterator();
                    while (it3.hasNext()) {
                        if (it3.next() != null) {
                            a.a(f3359d, f3358c);
                        }
                    }
                }
            }
            throw th2;
        }
    }

    public static String f() {
        if (f3361f == -1) {
            return "unknown";
        }
        switch (f3361f) {
        }
        return "unknown";
    }

    public static int g() {
        return f3359d;
    }

    public static boolean h() {
        return f3356a;
    }

    public static boolean i() {
        return f3360e;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Integer j() {
        /*
            e()
            int r0 = c.t.m.g.qc.f3359d
            r1 = 3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r3 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r5 = 2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r7 = 0
            if (r0 == r5) goto L22
            int r0 = c.t.m.g.qc.f3359d
            if (r0 == r1) goto L22
            int r0 = c.t.m.g.qc.f3359d
            r1 = 4
            if (r0 != r1) goto L21
            goto L22
        L21:
            r3 = 0
        L22:
            if (r3 == 0) goto Lbd
            android.content.Context r0 = c.t.m.g.fc.a()
            java.lang.String r1 = c.t.m.g.qc.f3357b
            java.lang.String r3 = "phone"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            if (r0 == 0) goto L68
            int r3 = r0.getSimState()
            r5 = 5
            if (r3 != r5) goto L68
            java.lang.String r0 = r0.getSimOperator()
            int r3 = r0.length()
            if (r3 <= 0) goto L68
            java.lang.String r3 = "46000"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto Lb3
            java.lang.String r3 = "46002"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L56
            goto Lb3
        L56:
            java.lang.String r3 = "46001"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5f
            goto Lb1
        L5f:
            java.lang.String r3 = "46003"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L68
            goto Lb9
        L68:
            if (r1 == 0) goto Lb5
            java.lang.String r0 = r1.toLowerCase()
            java.lang.String r1 = "cmnet"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto Lb3
            java.lang.String r1 = "cmwap"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L7f
            goto Lb3
        L7f:
            java.lang.String r1 = "uninet"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto Lb1
            java.lang.String r1 = "uniwap"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto Lb1
            java.lang.String r1 = "3gnet"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto Lb1
            java.lang.String r1 = "3gwap"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto La0
            goto Lb1
        La0:
            java.lang.String r1 = "ctnet"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto Lb9
            java.lang.String r1 = "ctwap"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto Lb5
            goto Lb9
        Lb1:
            r2 = r6
            goto Lb9
        Lb3:
            r2 = r4
            goto Lb9
        Lb5:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
        Lb9:
            int r7 = r2.intValue()
        Lbd:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.qc.j():java.lang.Integer");
    }

    public static Proxy k() {
        if (!f3360e || TextUtils.isEmpty(i)) {
            return null;
        }
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(i, 80));
    }

    public static boolean l() {
        try {
            PowerManager powerManager = (PowerManager) fc.a().getSystemService("power");
            if (Build.VERSION.SDK_INT < 23 || powerManager == null) {
                return false;
            }
            return ((Boolean) PowerManager.class.getDeclaredMethod("isDeviceIdleMode", new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }
}
