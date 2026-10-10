package com.tendcloud.tenddata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class cv extends cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, Object> f19974a = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HashMap<String, Object> f19975c = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile cv f19976f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f19977d = {"PUSH", "EAuth"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String[] f19978e = {"APP", "TRACKING", "GAME", "BG", "FINTECH"};

    private cv() {
        a("displayName", l.a().h(ab.g));
        a("globalId", l.a().a(ab.g));
        a("versionName", n.k());
        a("versionCode", Integer.valueOf(n.j()));
        a("installTime", Long.valueOf(l.a().d(ab.g)));
        a("updateTime", Long.valueOf(l.a().e(ab.g)));
    }

    public void a(Object obj, a aVar) {
        f19974a.put(aVar.name(), obj);
    }

    public void b(Object obj, a aVar) {
        f19975c.put(aVar.name(), obj);
    }

    public void setAppChannel(String str) {
        a("channel", str);
    }

    public void setSubmitAppId(a aVar) {
        if (aVar != null) {
            try {
                Object objA = f19974a.get(aVar.name());
                if (objA == null && f19974a.size() > 0) {
                    objA = a(aVar);
                }
                a("appKey", objA);
            } catch (Throwable unused) {
            }
        }
    }

    public void setSubmitChannelId(a aVar) {
        if (aVar == null) {
            setAppChannel("Default");
            return;
        }
        try {
            Object obj = f19975c.get(aVar.name());
            if (obj == null && f19975c.size() > 0) {
                obj = f19975c.get(b().get(0).name());
            }
            a("channel", obj);
        } catch (Throwable unused) {
        }
    }

    public void setUniqueId(String str) {
        a("uniqueId", str);
    }

    private Object a(a aVar) {
        Object obj = null;
        obj = null;
        if (aVar != null) {
            try {
                if (Arrays.asList(this.f19977d).contains(aVar.name())) {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appKey", (Object) null);
                    jSONObject.put("service", (Object) null);
                    jSONArray.put(jSONObject);
                    try {
                        if (!af.b((String) null)) {
                            a(jSONArray, aVar);
                        }
                    } catch (Throwable unused) {
                    }
                    obj = jSONArray;
                } else if (Arrays.asList(this.f19978e).contains(aVar.name())) {
                    String strA = ab.a(ab.g, aVar);
                    boolean zB = af.b(strA);
                    obj = strA;
                    if (!zB) {
                        a((Object) strA, aVar);
                        obj = strA;
                    }
                } else {
                    obj = f19974a.get(b().get(0).name());
                }
            } catch (Throwable unused2) {
            }
        }
        return obj;
    }

    private ArrayList<a> b() {
        ArrayList<a> arrayList = new ArrayList<>();
        try {
            Iterator<Map.Entry<String, Object>> it = f19974a.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(a.valueOf(it.next().getKey().toString()));
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static cv a() {
        if (f19976f == null) {
            synchronized (co.class) {
                if (f19976f == null) {
                    f19976f = new cv();
                }
            }
        }
        return f19976f;
    }
}
