package com.tendcloud.tenddata;

import android.location.Location;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.appevents.UserDataStore;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.imkit.plugin.LocationConst;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class cl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f19940a = "locations";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f19941b = "wifiData";
    private static volatile cl g = null;
    private static final int i = 1;
    private static final int j = 2;
    private static final int k = 3;
    private static final long l = 600000;
    private static final long m = 5000;
    private static final long n = 5000;
    private static final long o = 3600000;
    private static final String p = "wifiHT";
    private static int q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f19942c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConnectivityManager f19945f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19943d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f19944e = 2;
    private ConnectivityManager.NetworkCallback h = new ConnectivityManager.NetworkCallback() { // from class: com.tendcloud.tenddata.cl.1
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            try {
                if (cl.this.f19942c != null) {
                    cl.this.f19942c.sendEmptyMessage(2);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
        }
    };

    private cl() {
        try {
            this.f19945f = (ConnectivityManager) ab.g.getSystemService("connectivity");
            HandlerThread handlerThread = new HandlerThread(p, 10);
            handlerThread.start();
            this.f19942c = new Handler(handlerThread.getLooper()) { // from class: com.tendcloud.tenddata.cl.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    try {
                        int i2 = message.what;
                        if (i2 == 1) {
                            cl.this.f();
                            cl.this.f19942c.sendEmptyMessageDelayed(1, cl.l);
                        } else if (i2 == 2) {
                            cl.this.c();
                        } else if (i2 == 3) {
                            cl.this.d();
                            cl.this.f19942c.sendEmptyMessageDelayed(3, cl.o);
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
            this.f19942c.sendEmptyMessageDelayed(1, 5000L);
            e();
        } catch (Throwable unused) {
        }
    }

    private void e() {
        try {
            if (af.a(21) && af.b(ab.g, "android.permission.CHANGE_NETWORK_STATE")) {
                this.f19945f.requestNetwork(new NetworkRequest.Builder().build(), this.h);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            String strX = u.x(ab.g);
            if (strX == null) {
                return;
            }
            String strReplace = strX.replace("\"", "");
            String strA = cm.a(ab.g, "locations");
            if (strA == null || b(strReplace, strA)) {
                return;
            }
            for (Location location : ae.a(ab.g)) {
                if (location != null) {
                    m.dForInternal("currentLocationStr: " + String.format(Locale.getDefault(), "%s: %.4f, %.4f, %s", location.getProvider(), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), location.toString()));
                    String strR = u.r(ab.g);
                    StringBuilder sb = new StringBuilder();
                    sb.append(location.getTime());
                    sb.append(",");
                    sb.append(location.getLatitude());
                    sb.append(",");
                    sb.append(location.getLongitude());
                    sb.append(",");
                    sb.append(location.getAltitude());
                    sb.append(",");
                    sb.append(strReplace);
                    sb.append(",");
                    if (strR == null) {
                        strR = "";
                    }
                    sb.append(strR);
                    String string = sb.toString();
                    String strA2 = cm.a(ab.g, "locations", true);
                    if (strA2 == null || strA2.isEmpty()) {
                        cm.a(ab.g, string, "locations");
                    } else {
                        String[] strArrSplit = strA2.split(",");
                        if (strArrSplit.length > 1) {
                            if ((System.currentTimeMillis() - Long.parseLong(strArrSplit[0])) / 1000 > 604800) {
                                cm.c(ab.g, string, "locations");
                            } else {
                                cm.a(ab.g, string, "locations");
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static cl a() {
        if (g == null) {
            synchronized (cl.class) {
                if (g == null) {
                    g = new cl();
                }
            }
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (u.j(ab.g)) {
                String strX = u.x(ab.g);
                if (!af.b(strX)) {
                    strX = strX.replace("\"", "");
                }
                String strR = u.r(ab.g);
                if (strX != null && !strX.contains("unknown") && strR != null && !strR.startsWith("02:00")) {
                    a(strX, strR);
                    d();
                    this.f19942c.sendEmptyMessageDelayed(3, o);
                    return;
                }
                if (q <= 2) {
                    q++;
                    this.f19942c.sendEmptyMessageDelayed(2, 5000L);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            String strA = cm.a(ab.g, f19941b);
            if (strA == null || strA.isEmpty()) {
                return;
            }
            JSONArray jSONArray = new JSONObject(strA).getJSONArray("wifiArray");
            TreeMap treeMap = new TreeMap();
            JSONObject jSONObjectA = a(jSONArray);
            if (jSONObjectA != null) {
                treeMap.put("home", jSONObjectA);
            }
            JSONObject jSONObjectB = b(jSONArray);
            if (jSONObjectB != null) {
                treeMap.put("office", jSONObjectB);
            }
            if (treeMap.isEmpty()) {
                return;
            }
            bx bxVar = new bx();
            bxVar.f19906b = "computing";
            bxVar.f19907c = LocationConst.POI;
            bxVar.f19908d = treeMap;
            bxVar.f19905a = a.ENV;
            ag.a().post(bxVar);
        } catch (Throwable unused) {
        }
    }

    public void b() {
        try {
            this.f19942c.removeCallbacksAndMessages(null);
            if (af.a(21)) {
                this.f19945f.unregisterNetworkCallback(this.h);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean b(String str, JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (str.equals(jSONArray.getJSONObject(i2).optString("bssid"))) {
                return true;
            }
        }
        return false;
    }

    private void a(String str, String str2) {
        JSONArray jSONArray;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strA = cm.a(ab.g, f19941b);
            if (strA != null && !strA.isEmpty()) {
                jSONArray = d(new JSONObject(strA).getJSONArray("wifiArray"));
                if (jSONArray.length() > 0 && a(str, jSONArray)) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (str.equals(jSONObject.get("ssid"))) {
                            jSONObject.put("time", jCurrentTimeMillis);
                            JSONArray jSONArray2 = jSONObject.getJSONArray("bssids");
                            if (b(str2, jSONArray2)) {
                                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                                    if (str2.equals(jSONObject2.get("bssid"))) {
                                        jSONObject2.put("count", jSONObject2.getInt("count") + 1);
                                        jSONObject2.put("times", jSONObject2.getString("times") + "," + jCurrentTimeMillis);
                                    }
                                }
                            } else {
                                jSONArray2.put(a(jCurrentTimeMillis, str2));
                            }
                        }
                    }
                } else {
                    jSONArray.put(a(jCurrentTimeMillis, str, str2));
                }
            } else {
                jSONArray = new JSONArray();
                jSONArray.put(a(jCurrentTimeMillis, str, str2));
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("wifiArray", jSONArray);
            cm.b(ab.g, jSONObject3.toString(), f19941b);
        } catch (Throwable unused) {
        }
    }

    private boolean b(long j2) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            int i2 = calendar.get(7);
            if (i2 < 2 || i2 > 6) {
                return false;
            }
            int i3 = calendar.get(11);
            return (i3 >= 9 && i3 <= 12) || (i3 >= 13 && i3 < 18);
        } catch (Throwable unused) {
            return false;
        }
    }

    private JSONObject b(JSONArray jSONArray) {
        try {
            JSONArray jSONArray2 = new JSONArray();
            int i2 = 0;
            String string = "";
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                JSONArray jSONArray3 = jSONObject.getJSONArray("bssids");
                int iA = 0;
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    iA += a(jSONArray3.getJSONObject(i4).getString("times"), 2);
                }
                if (iA > i2) {
                    string = jSONObject.getString("ssid");
                    jSONArray2 = jSONArray3;
                    i2 = iA;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (string.isEmpty() || jSONArray2.length() == 0) {
                return null;
            }
            jSONObject2.put("ssid", string);
            jSONObject2.put("bssid", c(jSONArray2));
            jSONObject2.put(UserDataStore.CITY, i2);
            jSONObject2.put("location", a(string));
            return jSONObject2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private JSONArray c(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                jSONArray2.put(jSONArray.getJSONObject(i2).getString("bssid"));
            } catch (Throwable unused) {
            }
        }
        return jSONArray2;
    }

    private JSONArray d(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                try {
                    if ((System.currentTimeMillis() - jSONObject.getLong("time")) / 1000 < 604800) {
                        jSONArray2.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
        }
        return jSONArray2;
    }

    private boolean b(String str, String str2) {
        try {
            if (!str2.isEmpty()) {
                for (String str3 : str2.split(",")) {
                    if (str3.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private boolean a(String str, JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (str.equals(jSONArray.getJSONObject(i2).optString("ssid"))) {
                return true;
            }
        }
        return false;
    }

    private JSONObject a(long j2, String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(a(j2, str2));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("time", String.valueOf(j2));
            jSONObject.put("ssid", str);
            jSONObject.put("bssids", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private JSONObject a(long j2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("times", String.valueOf(j2));
            jSONObject.put("bssid", str);
            jSONObject.put("count", 1);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean a(long j2) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            int i2 = calendar.get(11);
            return i2 >= 0 && i2 <= 5;
        } catch (Throwable unused) {
            return false;
        }
    }

    private JSONObject a(JSONArray jSONArray) {
        try {
            JSONArray jSONArray2 = new JSONArray();
            int i2 = 0;
            String string = "";
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                JSONArray jSONArray3 = jSONObject.getJSONArray("bssids");
                int iA = 0;
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    iA += a(jSONArray3.getJSONObject(i4).getString("times"), 1);
                }
                if (iA > i2) {
                    string = jSONObject.getString("ssid");
                    jSONArray2 = jSONArray3;
                    i2 = iA;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (string.isEmpty() || jSONArray2.length() == 0) {
                return null;
            }
            jSONObject2.put("ssid", string);
            jSONObject2.put("bssid", c(jSONArray2));
            jSONObject2.put(UserDataStore.CITY, i2);
            jSONObject2.put("location", a(string));
            return jSONObject2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private int a(String str, int i2) {
        try {
            int i3 = 0;
            for (String str2 : str.split(",")) {
                try {
                    if ((i2 == 1 && a(Long.parseLong(str2.trim()))) || (i2 == 2 && b(Long.parseLong(str2.trim())))) {
                        i3++;
                    }
                } catch (Throwable unused) {
                    return i3;
                }
            }
            return i3;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    private String a(String str) {
        try {
            String strA = cm.a(ab.g, "locations");
            if (strA == null || strA.isEmpty()) {
                return "";
            }
            String[] strArrSplit = strA.split(UMCustomLogInfoBuilder.LINE_SEP);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(",");
                if (strArrSplit2.length == 6 && strArrSplit2[4].equals(str)) {
                    arrayList.add(Float.valueOf(Float.parseFloat(strArrSplit2[1])));
                    arrayList2.add(Float.valueOf(Float.parseFloat(strArrSplit2[2])));
                }
            }
            return a(arrayList) + "," + a(arrayList2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static float a(List<Float> list) {
        Iterator<Float> it = list.iterator();
        float fFloatValue = WheelView.DividerConfig.FILL;
        while (it.hasNext()) {
            fFloatValue += it.next().floatValue();
        }
        return fFloatValue / list.size();
    }
}
