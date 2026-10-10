package com.tendcloud.tenddata;

import com.android.billingclient.api.BillingFlowParams;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.blocky.config.GameSharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.tendcloud.tenddata.bw;
import com.tendcloud.tenddata.zz;
import io.rong.imlib.statistics.UserData;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile be f19843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f19844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f19845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f19846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f19847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f19848f;
    private static String g;
    private static String h;
    private static String j;
    private static JSONObject p;
    private String i;
    private a k = a.UNKNOWN;
    private String l;
    private int m;
    private String n;
    private JSONObject o;

    /* JADX INFO: compiled from: td */
    public enum a {
        MALE,
        FEMALE,
        UNKNOWN
    }

    static {
        try {
            ag.a().register(a());
        } catch (Throwable unused) {
        }
        f19844b = GameSharedConstant.ACCOUNT;
        f19845c = BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID;
        f19846d = "name";
        f19847e = UserData.GENDER_KEY;
        f19848f = "age";
        g = "type";
        h = "accountCus";
        j = StringConstant.PARTY_GAME_CATEGORY_DEFAULT;
    }

    private be() {
    }

    private boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private void b() {
        try {
            Map<String, Object> mapD = d();
            zz.a aVar = new zz.a();
            aVar.paraMap.put("apiType", 9);
            aVar.paraMap.put("domain", f19844b);
            aVar.paraMap.put("action", "update");
            aVar.paraMap.put("data", mapD);
            zz.c().obtainMessage(102, aVar).sendToTarget();
            cs.a().setAccount(new JSONObject(mapD));
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private static void c() {
        n.setLastRoleName(j);
        n.b(j, p.toString());
    }

    private Map<String, Object> d() {
        TreeMap treeMap = new TreeMap();
        try {
            treeMap.put(f19845c, this.i);
            if (this.m != 0) {
                treeMap.put(f19848f, Integer.valueOf(this.m));
            }
            if (!"UNKNOWN".equals(this.k.name())) {
                treeMap.put(f19847e, this.k.name());
            }
            if (this.l != null) {
                treeMap.put(f19846d, this.l);
            }
            if (this.n != null) {
                treeMap.put(g, this.n);
            }
            if (this.o != null && this.o.length() > 0) {
                treeMap.put(UserData.CUSTOM_KEY, this.o);
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
        return treeMap;
    }

    private static Map<String, Object> e() {
        TreeMap treeMap = new TreeMap();
        try {
            treeMap.put("name", j);
            if (p != null && p.length() > 0) {
                treeMap.put(UserData.CUSTOM_KEY, p);
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
        return treeMap;
    }

    private static void f() {
        try {
            cs.a().setSubaccount(new JSONObject(e()));
            b(null);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public final void onTDEBEventAccount(zz.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.paraMap != null && Integer.parseInt(String.valueOf(aVar.paraMap.get("apiType"))) == 9) {
                    aVar.paraMap.get(GameSharedConstant.ACCOUNT);
                    com.tendcloud.tenddata.a aVar2 = (com.tendcloud.tenddata.a) aVar.paraMap.get("service");
                    Object obj = aVar.paraMap.get("data");
                    Object obj2 = aVar.paraMap.get("domain");
                    Object obj3 = aVar.paraMap.get("action");
                    Object obj4 = aVar.paraMap.get("immediate");
                    if (obj3 == null || !(obj3.equals(FirebaseAnalytics.Event.LOGIN) || obj3.equals("register") || obj3.equals("apply") || obj3.equals("activate"))) {
                        if (obj3 != null) {
                            a(obj2, obj3, obj, aVar2);
                            if (a(obj4)) {
                                a(aVar2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TreeMap treeMap = new TreeMap();
                    treeMap.put(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, String.valueOf(aVar.paraMap.get(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID)));
                    String str = (String) aVar.paraMap.get("type");
                    String str2 = (String) aVar.paraMap.get("name");
                    if (str != null && !str.isEmpty()) {
                        treeMap.put("type", str);
                    }
                    if (str2 != null && !str2.isEmpty()) {
                        treeMap.put("name", str2);
                    }
                    a(obj2, obj3, treeMap, aVar2);
                }
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }
    }

    public void setAccountType(String str) {
        try {
            if (this.n == null || !this.n.equalsIgnoreCase(str)) {
                this.n = str;
                b();
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public void setAge(int i) {
        try {
            if (this.m != i) {
                this.m = i;
                b();
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public void setGender(a aVar) {
        try {
            if (this.k != aVar) {
                this.k = aVar;
                b();
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public void setName(String str) {
        try {
            if (this.l == null || !this.l.equalsIgnoreCase(str)) {
                this.l = str;
                b();
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private void a(com.tendcloud.tenddata.a aVar) {
        try {
            bw bwVar = new bw();
            bwVar.f19904b = bw.a.IMMEDIATELY;
            bwVar.f19903a = aVar;
            ag.a().post(bwVar);
        } catch (Throwable unused) {
        }
    }

    protected static void a(Object obj, Object obj2, Object obj3, com.tendcloud.tenddata.a aVar) {
        if (aVar == null || obj == null || obj2 == null || !(obj instanceof String) || !(obj2 instanceof String)) {
            return;
        }
        bx bxVar = new bx();
        bxVar.f19906b = String.valueOf(obj);
        bxVar.f19907c = String.valueOf(obj2);
        if (obj3 != null && (obj3 instanceof Map)) {
            bxVar.f19908d = (Map) obj3;
        }
        bxVar.f19905a = aVar;
        ag.a().post(bxVar);
    }

    public synchronized void b(String str, String str2) {
        if (this.o == null) {
            this.o = new JSONObject();
        }
        try {
            this.o.put(str, str2);
            b();
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        try {
            this.i = str;
            String strA = n.a(this.i);
            if (strA != null) {
                try {
                    JSONObject jSONObject = new JSONObject(strA);
                    if (jSONObject.has(f19846d)) {
                        this.l = jSONObject.getString(f19846d);
                    }
                    if (jSONObject.has(f19847e)) {
                        this.k = a.valueOf(jSONObject.getString(f19847e));
                    }
                    if (jSONObject.has(f19848f)) {
                        this.m = jSONObject.getInt(f19848f);
                    }
                    if (jSONObject.has(g)) {
                        this.n = jSONObject.getString(g);
                    }
                    if (jSONObject.has(h)) {
                        this.o = jSONObject.getJSONObject(h);
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public synchronized void b(String str, int i) {
        if (this.o == null) {
            this.o = new JSONObject();
        }
        try {
            this.o.put(str, i);
            b();
        } catch (Throwable unused) {
        }
    }

    private static void b(com.tendcloud.tenddata.a aVar) {
        try {
            Map<String, Object> mapE = e();
            cs.a().setSubaccount(new JSONObject(mapE));
            a(f19844b, "roleUpdate", mapE, aVar);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static synchronized void a(String str, com.tendcloud.tenddata.a aVar) {
        try {
            n.setLastRoleName(str);
            p = null;
            j = str;
            String strB = n.b(str);
            if (strB != null) {
                try {
                    p = new JSONObject(strB);
                    b(aVar);
                } catch (JSONException e2) {
                    m.dForInternal(e2.getMessage());
                }
            } else {
                p = new JSONObject();
                c();
                Map<String, Object> mapE = e();
                a(f19844b, "roleCreate", mapE, aVar);
                cs.a().setSubaccount(new JSONObject(mapE));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(String str, String str2) {
        if (p == null) {
            p = new JSONObject();
        }
        try {
            p.put(str, str2);
            c();
            f();
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(String str, int i) {
        if (p == null) {
            p = new JSONObject();
        }
        try {
            p.put(str, i);
            c();
            f();
        } catch (Throwable unused) {
        }
    }

    public static be a() {
        if (f19843a == null) {
            synchronized (be.class) {
                if (f19843a == null) {
                    f19843a = new be();
                }
            }
        }
        return f19843a;
    }
}
