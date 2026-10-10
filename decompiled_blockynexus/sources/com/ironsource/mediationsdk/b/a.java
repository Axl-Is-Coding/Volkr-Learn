package com.ironsource.mediationsdk.b;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AbstractEventsFormatter.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14767a = "eventId";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14768b = "timestamp";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14769c = "adUnit";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14770d = "InterstitialEvents";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14771e = com.umeng.analytics.pro.b.ao;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f14772f = com.umeng.analytics.pro.b.ao;
    JSONObject g;
    int h;
    private String i;

    a() {
    }

    private String a(int i) {
        if (i == 2) {
            return "InterstitialEvents";
        }
        if (i != 3) {
        }
        return com.umeng.analytics.pro.b.ao;
    }

    protected abstract String a();

    public abstract String a(ArrayList<b.f.b.b> arrayList, JSONObject jSONObject);

    JSONObject a(b.f.b.b bVar) {
        try {
            JSONObject jSONObject = new JSONObject(bVar.a());
            jSONObject.put("eventId", bVar.c());
            jSONObject.put("timestamp", bVar.d());
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    String b() {
        return TextUtils.isEmpty(this.i) ? a() : this.i;
    }

    public abstract String c();

    String a(JSONArray jSONArray) {
        try {
            if (this.g == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(this.g.toString());
            jSONObject.put("timestamp", com.ironsource.mediationsdk.utils.j.f());
            jSONObject.put("adUnit", this.h);
            jSONObject.put(a(this.h), jSONArray);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    void a(String str) {
        this.i = str;
    }
}
