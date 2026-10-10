package com.tendcloud.tenddata;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class cy extends cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19980a = "TalkingData";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f19981c = "SaaS";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f19982d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f19983e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f19984f = 2;
    public static final int g = 3;
    public static final int h = 4;
    private static String j = "";
    private static int k = 1;
    private final String i = "Android";

    public cy() {
        a("version", (Object) 4);
        a("minorVersion", (Object) 0);
        a("build", (Object) 56);
        if (!af.b(ab.v)) {
            try {
                a("jobNum", Integer.valueOf(Integer.parseInt(ab.v)));
            } catch (Throwable unused) {
            }
        }
        a("partner", f19981c);
        a("platform", "Android");
        a("type", f19980a);
        a("framework", j);
        int i = k;
        if (i > 0) {
            a("from", Integer.valueOf(i));
        }
    }

    public void a(String str, String str2, String str3) {
        JSONArray jSONArray;
        if (this.f19979b.isNull("features")) {
            jSONArray = new JSONArray();
        } else {
            try {
                jSONArray = this.f19979b.getJSONArray("features");
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONArray = null;
            }
        }
        if (jSONArray != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", str);
                jSONObject.put("version", str2);
                jSONObject.put("minorVersion", str3);
                jSONArray.put(jSONObject);
            } catch (JSONException e3) {
                e3.printStackTrace();
                bp.postSDKError(e3);
            }
            a("features", jSONArray);
        }
    }

    public String b() {
        return j;
    }

    public void setFrameWork(String str) {
        j = str;
    }
}
