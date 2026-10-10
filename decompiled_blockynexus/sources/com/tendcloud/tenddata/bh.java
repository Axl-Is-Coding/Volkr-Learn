package com.tendcloud.tenddata;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tendcloud.tenddata.ap;
import com.tendcloud.tenddata.bw;
import com.tendcloud.tenddata.t;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f19853a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f19854b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19855c = 3;
    private static String i = null;
    private static String j = "TDpref_cloudcontrol";
    private static final String k = "TDpref_config";
    private static final String l = "TDpref_last_request_time";
    private static final String m = "TDpref_cloud_cv";
    private static boolean o;
    private static String s;
    private static String t;
    private static String u;
    private static String v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f19856d = 720;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f19857e = 604800000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<String, JSONObject> f19858f = new HashMap<>();
    private HashSet<String> g = new HashSet<>();
    private JSONObject h = new JSONObject();
    private int x;
    private Handler y;
    private static String[] n = {"232", "206", "284", "280", "219", "230", "238", "248", "244", "208", "308", "340", "543", "546", "547", "647", "742", "262", "202", "216", "272", "222", "247", "246", "270", "278", "204", "363", "362", "260", "268", "226", "231", "293", "214", "240", "234", "235", "266", "346", "348", "350", "354", "376", "750", "454", "455", "466", "525", "310", "311", "312", "313", "314", "315", "316", "330", "332", "534", "535", "544", "302", "505", "530", "548"};
    private static boolean p = true;
    private static boolean q = false;
    private static boolean r = true;
    private static boolean w = false;
    private static boolean z = true;
    private static volatile bh A = null;

    private bh() {
        this.y = null;
        HandlerThread handlerThread = new HandlerThread("ModuleCloudControl", 10);
        handlerThread.start();
        this.y = new Handler(handlerThread.getLooper()) { // from class: com.tendcloud.tenddata.bh.1
            String appId;
            String channelId;
            a features;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    if (message.obj != null) {
                        HashMap map = (HashMap) message.obj;
                        this.appId = String.valueOf(map.get("appId"));
                        this.channelId = String.valueOf(map.get("channelId"));
                        this.features = (a) map.get("Features");
                    }
                    int i2 = message.what;
                    if (i2 == 0) {
                        bh.this.b(this.appId, this.channelId, this.features);
                        return;
                    }
                    if (i2 == 1) {
                        boolean unused = bh.z = false;
                        bh.this.b(this.appId, this.channelId, this.features);
                        return;
                    }
                    if (i2 != 3) {
                        return;
                    }
                    bx bxVar = new bx();
                    bxVar.f19906b = "app";
                    bxVar.f19907c = "initaddition";
                    bxVar.f19905a = this.features;
                    ag.a().post(bxVar);
                    bw bwVar = new bw();
                    bwVar.f19903a = this.features;
                    bwVar.f19904b = bw.a.IMMEDIATELY;
                    ag.a().post(bwVar);
                } catch (Throwable th) {
                    bp.postSDKError(th);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, a aVar) {
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                a(jSONObject, "bl", Integer.valueOf(this.x));
                a(jSONObject, "pl", (Object) 1);
                a(jSONObject, "sv", "4.0.56");
                a(jSONObject, "smcc", s);
                a(jSONObject, "smnc", t);
                a(jSONObject, "bmcc", u);
                a(jSONObject, "bmnc", v);
                a(jSONObject, "dt", "Mobile");
                a(jSONObject, "ov", p.a());
                a(jSONObject, "av", n.k());
                a(jSONObject, "px", p.d(ab.g));
                a(jSONObject, "nt", u.m(ab.g));
                a(jSONObject, "op", u.t(ab.g));
                a(jSONObject, "ch", str2);
                a(jSONObject, "cv", Long.valueOf(w.b(ab.g, j, m, 0L)));
                a(jSONObject, "TDID", o.a(ab.g));
                a(jSONObject, "AppID", str);
                as asVarA = am.a(am.a().url(aa.s).body(new ap(ap.a.JSON, jSONObject.toString().getBytes())).header(new aq().a("Accept-Encoding", "")).method(ar.POST).build());
                t.getFileLock(i);
                String strC = af.c(asVarA.c());
                if (asVarA.b() == 200) {
                    b(a(new JSONObject(strC)));
                    w.a(ab.g, j, l, System.currentTimeMillis());
                } else if (z) {
                    HashMap map = new HashMap();
                    map.put("appId", str);
                    map.put("channelId", str2);
                    map.put("Features", aVar);
                    this.y.sendMessageDelayed(this.y.obtainMessage(1, map), 5000L);
                }
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        } finally {
            t.releaseFileLock(i);
        }
    }

    private void d() {
        try {
            j += this.x;
            i = t.b.Cloud_Control_Lock_File.toString() + this.x;
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private boolean e() {
        long jB = w.b(ab.g, j, l, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jB == 0) {
            return true;
        }
        long j2 = jCurrentTimeMillis - jB;
        return j2 > (this.f19856d * 60) * 1000 || j2 > this.f19857e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            as asVarA = am.a(am.a().url(aa.y).method(ar.GET).build());
            if (asVarA != null && asVarA.b() == 200) {
                p = new JSONObject(new String(asVarA.c())).optBoolean("GDPRregion");
            }
        } catch (Throwable unused) {
        }
    }

    private void g() {
        try {
            if (this.h.length() == 0) {
                String strA = a(t.b(i));
                JSONObject jSONObject = af.b(strA) ? null : new JSONObject(strA);
                if (jSONObject == null || jSONObject.length() <= 0) {
                    return;
                }
                this.h = jSONObject;
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private void h() {
        try {
            try {
                t.getFileLock(i);
                String strB = w.b(ab.g, j, k, "");
                b(af.b(strB) ? null : new JSONObject(strB));
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        } finally {
            t.releaseFileLock(i);
        }
    }

    private void i() {
        try {
            Iterator<String> itKeys = this.h.keys();
            while (itKeys.hasNext()) {
                JSONObject jSONObject = this.h.getJSONObject(itKeys.next());
                Iterator<String> itKeys2 = jSONObject.keys();
                ArrayList arrayList = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next = itKeys2.next();
                    if (!this.g.contains(next)) {
                        arrayList.add(next);
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    jSONObject.remove((String) arrayList.get(i2));
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public void c() {
        a(t.b(i), this.h.toString());
        this.h = new JSONObject();
    }

    public static bh a() {
        if (A == null) {
            synchronized (bh.class) {
                if (A == null) {
                    A = new bh();
                }
            }
        }
        return A;
    }

    public void a(String str, String str2, a aVar) {
        HashMap map = new HashMap();
        map.put("appId", str);
        map.put("channelId", str2);
        map.put("Features", aVar);
        this.x = a(aVar);
        d();
        q = n.e(aVar) == 1;
        if (q) {
            if (!u.i(ab.g)) {
                ad.f19754a.execute(new Runnable() { // from class: com.tendcloud.tenddata.bh.2
                    @Override // java.lang.Runnable
                    public void run() {
                        bh.this.f();
                    }
                });
                Handler handler = this.y;
                handler.sendMessageDelayed(handler.obtainMessage(3, map), 5000L);
                w = true;
                return;
            }
            r = false;
        }
        String strQ = u.q(ab.g);
        String strP = u.p(ab.g);
        s = af.b(strQ) ? "" : strQ.substring(0, 3);
        t = af.b(strQ) ? "" : strQ.substring(3);
        u = af.b(strP) ? "" : strP.substring(0, 3);
        v = af.b(strP) ? "" : strP.substring(3);
        o = b(s) || b(u);
        h();
        try {
            if (ab.q || e()) {
                this.y.sendMessage(this.y.obtainMessage(0, map));
            }
        } catch (Throwable unused) {
        }
        w = true;
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if ((obj instanceof String) && ((String) obj).length() == 0) {
                return;
            }
            jSONObject.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        try {
            String strB = w.b(ab.g, j, k, "");
            if (!af.b(strB)) {
                JSONObject jSONObject2 = new JSONObject(strB);
                if (jSONObject.has("cv") && jSONObject2.getInt("cv") == jSONObject.getInt("cv")) {
                    if (jSONObject.has("r")) {
                        jSONObject2.put("r", jSONObject.getJSONArray("r"));
                    }
                    w.a(ab.g, j, k, jSONObject2.toString());
                    return jSONObject2;
                }
                w.a(ab.g, j, k, jSONObject.toString());
                if (!jSONObject.has("cv")) {
                    return jSONObject;
                }
                w.a(ab.g, j, m, jSONObject.getLong("cv"));
                return jSONObject;
            }
            w.a(ab.g, j, k, jSONObject.toString());
            return jSONObject;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has(com.umeng.analytics.pro.au.ay)) {
                this.f19856d = jSONObject.getInt(com.umeng.analytics.pro.au.ay);
            }
            this.g = new HashSet<>();
            if (jSONObject.has("c") && jSONObject.has("r")) {
                JSONArray jSONArray = jSONObject.getJSONArray("c");
                JSONArray jSONArray2 = jSONObject.getJSONArray("r");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    int i3 = jSONObject2.getInt("id");
                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                        if (i3 == jSONArray2.getInt(i4)) {
                            a(jSONObject2, String.valueOf(i3));
                        }
                        this.g.add(String.valueOf(i3));
                    }
                }
                if (jSONArray.length() == 0) {
                    this.f19858f = new HashMap<>();
                }
                g();
                i();
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private void a(JSONObject jSONObject, String str) {
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.remove("clt");
            jSONObject.remove("id");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!af.b(string)) {
                    if (this.f19858f.containsKey(string)) {
                        this.f19858f.get(string).put(str, jSONObject);
                    } else {
                        this.f19858f.put(string, new JSONObject().put(str, jSONObject));
                    }
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public JSONArray a(String str) {
        return a(str, (JSONObject) null, (JSONObject) null);
    }

    public JSONArray a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArray = new JSONArray();
        if (!w) {
            return jSONArray;
        }
        try {
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
        if (ab.q) {
            return jSONArray;
        }
        if (q && r) {
            if (p) {
                return null;
            }
            return jSONArray;
        }
        if (!this.f19858f.containsKey(str)) {
            if (o) {
                return jSONArray;
            }
            return null;
        }
        if (jSONObject != null && jSONObject2 != null) {
            if (jSONObject.has(str)) {
                return jSONArray;
            }
            if (jSONObject2.has(str)) {
                return null;
            }
            jSONObject2.put(str, true);
        }
        JSONObject jSONObject3 = this.f19858f.get(str);
        Iterator<String> itKeys = jSONObject3.keys();
        ArrayList arrayList = new ArrayList();
        g();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            arrayList.add(next);
            JSONObject jSONObject4 = jSONObject3.getJSONObject(next);
            long j2 = jSONObject4.getLong("st");
            long j3 = jSONObject4.getLong("et");
            int i2 = jSONObject4.getInt("cn");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis >= j2 && jCurrentTimeMillis <= j3 && i2 > 0) {
                if (this.h.has(str)) {
                    JSONObject jSONObject5 = this.h.getJSONObject(str);
                    if (jSONObject5.has(next)) {
                        if (jSONObject5.getInt(next) < i2) {
                            jSONArray.put(Integer.parseInt(next));
                            jSONObject5.put(next, jSONObject5.getInt(next) + 1);
                            this.h.put(str, jSONObject5);
                        }
                    } else {
                        this.h.put(str, jSONObject5.put(next, 1));
                        jSONArray.put(Integer.parseInt(next));
                    }
                } else {
                    this.h.put(str, new JSONObject().put(next, 1));
                    jSONArray.put(Integer.parseInt(next));
                }
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray;
    }

    public String b() {
        return i;
    }

    private boolean b(String str) {
        try {
            if (af.b(str)) {
                return false;
            }
            for (int i2 = 0; i2 < n.length; i2++) {
                if (str.equals(n[i2])) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return true;
        }
    }

    private int a(a aVar) {
        int iIndex = aVar.index();
        if (iIndex == 0) {
            return 1;
        }
        if (iIndex != 1) {
            return iIndex != 3 ? -1 : 3;
        }
        return 2;
    }

    private void a(RandomAccessFile randomAccessFile, String str) {
        try {
            randomAccessFile.setLength(0L);
            randomAccessFile.seek(0L);
            randomAccessFile.write(str.getBytes());
        } catch (Throwable unused) {
        }
    }

    private String a(RandomAccessFile randomAccessFile) {
        try {
            byte[] bArr = new byte[(int) randomAccessFile.length()];
            randomAccessFile.seek(0L);
            randomAccessFile.read(bArr);
            return new String(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
