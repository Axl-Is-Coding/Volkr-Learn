package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.map.geolocation.TencentLocationListener;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: c.t.m.g.eb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public class C0423eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HandlerThread f3145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile C0423eb f3146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f3147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Ya f3148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f3149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<String, AbstractC0426fb> f3150f;
    final PackageManager g;
    public final TelephonyManager h;
    public final WifiManager i;
    public final LocationManager j;
    public final Gb k;
    private CountDownLatch l;
    private final SharedPreferences m;
    String n;
    private List<Yb> o;

    private C0423eb(Context context) {
        this.f3147c = context;
        this.g = context.getPackageManager();
        this.h = (TelephonyManager) context.getSystemService("phone");
        this.i = (WifiManager) context.getSystemService(TencentLocationListener.WIFI);
        this.j = (LocationManager) context.getSystemService("location");
        this.k = new Eb(context, Wb.a(context.getPackageName()));
        this.m = context.getSharedPreferences("LocationSDK", 0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0417cb(this));
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        this.f3149e = threadPoolExecutor;
        HandlerThread handlerThread = new HandlerThread("GeoLocationService");
        f3145a = handlerThread;
        handlerThread.start();
        this.f3150f = new HashMap<>();
        if (Build.VERSION.SDK_INT >= 12) {
            this.f3150f.put(TencentLocationListener.CELL, new C0429gb(TencentLocationListener.CELL));
        }
        this.f3148d = new Ya(this);
        try {
            this.f3148d.i = b(context);
        } catch (Exception unused) {
        }
        a();
    }

    private static String c(String str) {
        return str == null ? "" : str;
    }

    public static HandlerThread f() {
        HandlerThread handlerThread;
        synchronized (C0423eb.class) {
            if (f3145a == null || f3145a.getLooper() == null || !f3145a.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("GeoLocationService");
                f3145a = handlerThread2;
                handlerThread2.start();
            }
            handlerThread = f3145a;
        }
        return handlerThread;
    }

    public final boolean b() {
        return this.h != null;
    }

    public final boolean c() {
        return this.i != null;
    }

    public final boolean d() {
        return this.j != null;
    }

    public final Ya e() {
        try {
            this.l.await();
            return this.f3148d;
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public final String g() {
        if (!Ha.a().d("up_apps")) {
            return "";
        }
        if (System.currentTimeMillis() - this.m.getLong("location_time", 0L) > 259200000) {
            try {
                List<PackageInfo> installedPackages = this.g.getInstalledPackages(8192);
                StringBuilder sb = new StringBuilder();
                int i = 1;
                for (PackageInfo packageInfo : installedPackages) {
                    int i2 = packageInfo.applicationInfo.flags;
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    if ((i2 & 1) <= 0 && i <= 60) {
                        String string = packageInfo.applicationInfo.loadLabel(this.g).toString();
                        if (!(string.length() > 30 || string.startsWith("com.") || string.contains("theme") || string.contains("CheilPengtai"))) {
                            sb.append(packageInfo.applicationInfo.packageName);
                            sb.append("_");
                            sb.append(string);
                            sb.append('_');
                            sb.append(packageInfo.versionName);
                            sb.append('|');
                            i++;
                        }
                    }
                }
                this.m.edit().putLong("location_time", System.currentTimeMillis()).apply();
                return b(sb.toString());
            } catch (Exception unused) {
                this.m.edit().putLong("location_time", System.currentTimeMillis()).apply();
            }
        }
        return "";
    }

    final PackageInfo h() {
        try {
            return this.g.getPackageInfo(this.f3147c.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return new PackageInfo();
        }
    }

    final String i() {
        byte[] hardwareAddress;
        String string = "";
        try {
            string = this.m.getString("macaddr", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null) {
                if (!networkInterfaces.hasMoreElements()) {
                    break;
                }
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null && networkInterfaceNextElement.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = networkInterfaceNextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    string = sb.toString();
                    this.m.edit().putString("macaddr", string).apply();
                }
            }
        } catch (Throwable unused) {
        }
        return string;
    }

    public static C0423eb a(Context context) {
        if (f3146b == null) {
            synchronized (C0423eb.class) {
                if (f3146b == null) {
                    f3146b = new C0423eb(context);
                }
            }
        }
        return f3146b;
    }

    public final synchronized void b(Object obj) {
        if (obj == null) {
            return;
        }
        List<Yb> list = this.o;
        if (list != null) {
            for (Yb yb : list) {
                if (obj.getClass().equals(yb.f3063a)) {
                    try {
                        yb.f3064b.invoke(yb.f3065c, obj);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public final void a() {
        this.l = new CountDownLatch(1);
        new Thread(new RunnableC0420db(this)).start();
    }

    private static String b(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                if (bundle.containsKey("TencentGeoLocationSDK")) {
                    return bundle.getString("TencentGeoLocationSDK");
                }
                if (bundle.containsKey("TencentMapSDK")) {
                    return bundle.getString("TencentMapSDK");
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public final AbstractC0426fb a(String str) {
        return this.f3150f.get(str);
    }

    public final synchronized void a(Object obj) {
        boolean z;
        if (this.o == null) {
            this.o = new ArrayList();
        }
        Iterator<Yb> it = this.o.iterator();
        while (true) {
            if (it.hasNext()) {
                if (obj == it.next().f3065c) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            return;
        }
        for (Method method : obj.getClass().getDeclaredMethods()) {
            String name = method.getName();
            if (name.startsWith("on") && name.endsWith("Event")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    this.o.add(new Yb(parameterTypes[0], method, obj));
                } else {
                    throw new IllegalArgumentException("EventHandler methods must specify a single Object paramter.");
                }
            }
        }
    }

    private String b(String str) {
        Ya ya = this.f3148d;
        HashMap map = new HashMap();
        map.put("version", ya.d());
        map.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, c(ya.j));
        map.put("app_label", c(ya.l));
        map.put("l", str);
        try {
            JSONObject jSONObject = new JSONObject(map);
            Ya ya2 = this.f3148d;
            HashMap map2 = new HashMap();
            map2.put("imei", c(ya2.a()));
            map2.put("imsi", c(ya2.b()));
            map2.put("n", c(C0458qa.a(ya2.f3061e)));
            map2.put("qq", c(C0458qa.a(ya2.g)));
            map2.put("mac", c(ya2.c().toLowerCase(Locale.ENGLISH)));
            map2.put("model", c(Build.MANUFACTURER + "_" + Build.MODEL));
            return jSONObject.put("attribute", new JSONObject(map2)).toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
