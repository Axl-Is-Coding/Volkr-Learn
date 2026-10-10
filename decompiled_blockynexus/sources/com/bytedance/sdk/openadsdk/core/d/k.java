package com.bytedance.sdk.openadsdk.core.d;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.clothes.EchoesHandler;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TempPkgModel.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<a> f6130d;

    /* JADX INFO: compiled from: TempPkgModel.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f6132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f6133c;

        public String a() {
            return this.f6131a;
        }

        public String b() {
            return this.f6132b;
        }

        public int c() {
            return this.f6133c;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            String str = this.f6131a;
            return str != null && str.equals(((a) obj).a());
        }

        public int hashCode() {
            int iHashCode = this.f6133c;
            String str = this.f6131a;
            if (str != null) {
                iHashCode = (iHashCode * 31) + str.hashCode();
            }
            String str2 = this.f6132b;
            return str2 != null ? (iHashCode * 31) + str2.hashCode() : iHashCode;
        }

        public void a(String str) {
            this.f6131a = str;
        }

        public void b(String str) {
            this.f6132b = str;
        }

        public void a(int i) {
            this.f6133c = i;
        }
    }

    public String a() {
        return this.f6127a;
    }

    public String b() {
        return this.f6128b;
    }

    public String c() {
        return this.f6129c;
    }

    public List<a> d() {
        if (this.f6130d == null) {
            this.f6130d = new ArrayList();
        }
        return this.f6130d;
    }

    public boolean e() {
        return (c() == null || b() == null || a() == null) ? false : true;
    }

    public String f() {
        if (!e()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", a());
            jSONObject.putOpt("version", b());
            jSONObject.putOpt("main", c());
            JSONArray jSONArray = new JSONArray();
            if (d() != null) {
                for (a aVar : d()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", aVar.a());
                    jSONObject2.putOpt("md5", aVar.b());
                    jSONObject2.putOpt(FirebaseAnalytics.Param.LEVEL, Integer.valueOf(aVar.c()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt(EchoesHandler.ASSETS_NAME, jSONArray);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(String str) {
        this.f6127a = str;
    }

    public void b(String str) {
        this.f6128b = str;
    }

    public void c(String str) {
        this.f6129c = str;
    }

    public void a(List<a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f6130d = list;
    }

    public static k a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            k kVar = new k();
            try {
                kVar.a(jSONObject.getString("name"));
                kVar.b(jSONObject.getString("version"));
                kVar.c(jSONObject.getString("main"));
                JSONArray jSONArray = jSONObject.getJSONArray(EchoesHandler.ASSETS_NAME);
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.a(jSONObject2.getString("url"));
                        aVar.b(jSONObject2.getString("md5"));
                        aVar.a(jSONObject2.getInt(FirebaseAnalytics.Param.LEVEL));
                        arrayList.add(aVar);
                    }
                }
                kVar.a(arrayList);
                if (!kVar.e()) {
                    return null;
                }
            } catch (Throwable unused) {
            }
            return kVar;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static k d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }
}
