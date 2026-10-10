package com.ironsource.mediationsdk;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AuctionResponseItem.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2325i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f14848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f14849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f14850f;
    private boolean g;
    private com.ironsource.mediationsdk.c.a h;

    public C2325i(String str) {
        this.f14845a = str;
        this.f14846b = "";
        this.f14847c = "";
        this.f14848d = new ArrayList();
        this.f14849e = new ArrayList();
        this.f14850f = new ArrayList();
        this.g = true;
        this.h = null;
    }

    public List<String> a() {
        return this.f14848d;
    }

    public String b() {
        return this.f14845a;
    }

    public List<String> c() {
        return this.f14849e;
    }

    public List<String> d() {
        return this.f14850f;
    }

    public String e() {
        return this.f14847c;
    }

    public String f() {
        return this.f14846b;
    }

    public boolean g() {
        return this.g;
    }

    public com.ironsource.mediationsdk.c.a a(String str) {
        com.ironsource.mediationsdk.c.a aVar = this.h;
        if (aVar != null) {
            aVar.a("${PLACEMENT_NAME}", str);
        }
        return this.h;
    }

    public C2325i(JSONObject jSONObject, JSONObject jSONObject2) {
        this.g = false;
        try {
            if (jSONObject.has("instance")) {
                this.f14845a = jSONObject.getString("instance");
            }
            if (jSONObject.has("adMarkup")) {
                this.f14846b = jSONObject.getString("adMarkup");
            } else if (jSONObject.has("serverData")) {
                this.f14846b = jSONObject.getString("serverData");
            } else {
                this.f14846b = "";
            }
            if (jSONObject.has("price")) {
                this.f14847c = jSONObject.getString("price");
            } else {
                this.f14847c = "0";
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("notifications");
            this.f14848d = new ArrayList();
            if (jSONObjectOptJSONObject.has("burl")) {
                JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("burl");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f14848d.add(jSONArray.getString(i));
                }
            }
            this.f14849e = new ArrayList();
            if (jSONObjectOptJSONObject.has("lurl")) {
                JSONArray jSONArray2 = jSONObjectOptJSONObject.getJSONArray("lurl");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    this.f14849e.add(jSONArray2.getString(i2));
                }
            }
            this.f14850f = new ArrayList();
            if (jSONObjectOptJSONObject.has("nurl")) {
                JSONArray jSONArray3 = jSONObjectOptJSONObject.getJSONArray("nurl");
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    this.f14850f.add(jSONArray3.getString(i3));
                }
            }
            this.h = new com.ironsource.mediationsdk.c.a(com.ironsource.mediationsdk.h.a.a(jSONObject2, jSONObject.has("armData") ? jSONObject.optJSONObject("armData") : null));
            this.g = true;
        } catch (Exception unused) {
        }
    }

    public C2325i(JSONObject jSONObject) {
        this(jSONObject, null);
    }
}
